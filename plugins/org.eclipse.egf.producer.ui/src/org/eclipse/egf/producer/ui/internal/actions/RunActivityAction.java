/*******************************************************************************
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.producer.ui.internal.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.domain.EgfResourceSet;
import org.eclipse.egf.core.domain.RuntimePlatformResourceSet;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.diagnostic.EGFValidator;
import org.eclipse.egf.model.editor.dialogs.ActivitySelectionDialog;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.egf.producer.ui.EGFProducerUIPlugin;
import org.eclipse.egf.producer.ui.internal.dialogs.ActivityValidationSelectionDialog;
import org.eclipse.egf.producer.ui.internal.ui.IProducerUIImages;
import org.eclipse.egf.producer.ui.l10n.ProducerUIMessages;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.progress.IProgressConstants;

public class RunActivityAction implements IObjectActionDelegate {

	/**
	 * Current shell
	 */
	private Shell _shell;

	private IPlatformFcore _fcore;

	private Activity _activity;

	/**
	 * Activities to validate (if any)
	 */
	private List<Activity> _validates = null;

	public void run(IAction action) {

		_validates = null;

		// 1 - Activity Selection
		if (_fcore != null) {
			ActivitySelectionDialog activityDialog = new ActivitySelectionDialog(_shell, _fcore, false);
			activityDialog.setTitle(ProducerUIMessages.GlobalRunActivityAction_dialogTitle);
			int result = activityDialog.open();
			if (result != IDialogConstants.OK_ID) {
				return;
			}
			final Object[] selection = activityDialog.getResult();
			if (selection == null || selection.length != 1) {
				return;
			}
			_activity = (Activity) selection[0];
		}

		// Nothing to process
		if (_activity == null) {
			return;
		}

		// 2 - Validation
		IPreferenceStore store = EGFCoreUIPlugin.getDefault().getPreferenceStore();
		String validate = store.getString(IEGFModelConstants.VALIDATE_MODEL_INSTANCES_BEFORE_LAUNCH);
		List<Activity> activities = _activity.getActivities();
		int status = showValidateDialog(activities, validate.equals(MessageDialogWithToggle.NEVER) == false, validate.equals(MessageDialogWithToggle.PROMPT));
		if (status != IDialogConstants.OK_ID) {
			return;
		}
		if (_validates != null && _validates.size() != 0) {
			EGFValidator validator = new EGFValidator(_validates);
			Diagnostic validationDiag = validator.validate();
			// Stop when an error is found
			if (validationDiag.getSeverity() == Diagnostic.ERROR) {
				return;
			}
		}
		// Build a subset of task
		final List<Task> tasks = new BasicEList<Task>();
		for (Activity activity : activities) {
			if (activity instanceof Task) {
				tasks.add((Task) activity);
			}
		}

		// Prepare our activity job
		WorkspaceJob activityJob = new WorkspaceJob(ProducerUIMessages.GlobalRunActivityAction_label) {

			@Override
			public boolean belongsTo(Object family) {
				return EGFCorePlugin.FAMILY_MANUAL_BUILD.equals(family);
			}

			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {

				// Prepare a dynamic bundle session
				ProjectBundleSession session = new ProjectBundleSession(EGFProducerUIPlugin.getDefault().getBundle().getBundleContext());
				IActivityManager<?> activityManager = null;
				SubMonitor subMonitor = null;

				// 3 - Locate workspace fcore
				List<IPlatformFcore> fcores = new UniqueEList<IPlatformFcore>();
				for (Resource resource : _activity.getResources()) {
					if (resource instanceof IPlatformFcoreProvider) {
						IPlatformFcore fcore = ((IPlatformFcoreProvider) resource).getIPlatformFcore();
						// Runtime or target associated with a runtime bundle
						if (fcore.isRuntime() || fcore.getBundle() != null) {
							continue;
						}
						// Workspace Bundle
						if (fcore.isWorkspace()) {
							fcores.add(fcore);
							continue;
						}
						// Cannot associate a Bundle to a target platform fcore
						throw new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.TargetPlatform_ExtensionPoint_no_bundle, fcore.getPlatformBundle().getBundleId()), null));
					}
				}

				subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, EMFHelper.getText(_activity)), (100 * fcores.size()) + (1000 * tasks.size()));

				try {

					// 4 - Load workspace bundles in runtime
					for (IPlatformFcore fcore : fcores) {
						SubMonitor childSubMonitor = subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE);
						childSubMonitor = SubMonitor.convert(childSubMonitor, NLS.bind(EGFCoreMessages.Production_Load_Bundle, fcore.getPlatformBundle().getBundleId()), 100);
						session.getBundle(fcore.getPlatformBundle().getProject());
					}

					// 5 - Switch to runtime mode
					ResourceSet resourceSet = new RuntimePlatformResourceSet();
					Activity activity = (Activity) resourceSet.getEObject(EcoreUtil.getURI(_activity), true);

					// 6 - Locate an ActivityManagerProducer and create an
					// ActivityManager
					ActivityManagerProducer<Activity> producer = EGFProducerPlugin.getActivityManagerProducer(activity);
					activityManager = producer.createActivityManager(activity);
					// Assign a ProjectBundleSession
					activityManager.setProjectBundleSession(session);

					// 7 - Initialize Context
					activityManager.initializeContext();

					// 8 - PreInvoke Validation
					final Diagnostic preInvokeDiag = activityManager.canInvoke();
					if (preInvokeDiag.getSeverity() != Diagnostic.OK) {
						if (EGFProducerUIPlugin.getWorkbenchDisplay() != null) {
							EGFProducerUIPlugin.getWorkbenchDisplay().asyncExec(new Runnable() {

								public void run() {
									EGFValidator.handleDiagnostic(ProducerUIMessages.ActivityValidationSelectionDialog_Title, ProducerUIMessages._UI_PreInvokeProblems_message, preInvokeDiag);
								}

							});
						}
						if (preInvokeDiag.getSeverity() == Diagnostic.ERROR) {
							return Status.OK_STATUS;
						}
					}

					// 9 - Run activity
					if (EGFProducerUIPlugin.getDefault().isDebugging()) {
						if (tasks.size() == 1) {
							EGFProducerUIPlugin.getDefault().logInfo(NLS.bind(ProducerMessages.Activity_Invocation, EMFHelper.getText(activity)));
						} else {
							EGFProducerUIPlugin.getDefault().logInfo(NLS.bind(ProducerMessages.Activity_Invocations, EMFHelper.getText(activity), tasks.size()));
						}
					}
					final Diagnostic diagnostic = activityManager.invoke(subMonitor.newChild(1000 * tasks.size(), SubMonitor.SUPPRESS_NONE));
					if (subMonitor.isCanceled()) {
						throw new OperationCanceledException();
					}

					// 10 - Post Invoke Validation
					if (diagnostic != null && diagnostic.getSeverity() != Diagnostic.OK) {
						if (EGFProducerUIPlugin.getWorkbenchDisplay() != null) {
							EGFProducerUIPlugin.getWorkbenchDisplay().asyncExec(new Runnable() {

								public void run() {
									EGFValidator.handleDiagnostic(ProducerUIMessages.ActivityValidationSelectionDialog_Title, ProducerUIMessages._UI_PreInvokeProblems_message, diagnostic);
								}

							});
						}
					}

				} catch (InvocationException ie) {
					if (ie.getCause() != null && ie.getCause() instanceof CoreException) {
						throw (CoreException) ie.getCause();
					}
					ThrowableHandler.handleThrowable(EGFProducerUIPlugin.getDefault().getPluginID(), ie);
				} catch (OperationCanceledException ex) {
					return Status.CANCEL_STATUS;
				} catch (Throwable t) {
					throw new CoreException(EGFProducerUIPlugin.getDefault().newStatus(IStatus.ERROR, EGFCommonMessages.Exception_unexpectedException, t));
				} finally {
					monitor.done();
					try {
						if (activityManager != null)
							activityManager.dispose();
					} catch (Throwable t) {
						EGFProducerUIPlugin.getDefault().logError(t);
					}
				}

				return Status.OK_STATUS;

			}

		};

		// Lock all the workspace
		activityJob.setRule(ResourcesPlugin.getWorkspace().getRuleFactory().buildRule());
		activityJob.setProperty(IProgressConstants.ICON_PROPERTY, IProducerUIImages.EGF_RUN_ACTIVITY);
		activityJob.setPriority(Job.LONG);
		activityJob.setUser(true);
		activityJob.setSystem(false);
		activityJob.schedule();

		return;

	}

	protected Activity getActivitySelection(IStructuredSelection selection) {
		Object selectedObject = selection.getFirstElement();
		if (selectedObject == null) {
			return null;
		}
		if (selectedObject instanceof Activity) {
			return (Activity) selectedObject;
		}
		return null;
	}

	protected IPlatformFcore getPlatformFcoreSelection(IStructuredSelection selection) {
		Object selectedObject = selection.getFirstElement();
		if (selectedObject == null) {
			return null;
		}
		if (selectedObject instanceof IResource) {
			// Load this IFile as an EMF Resource
			try {
				ResourceSet resourceSet = new EgfResourceSet();
				Resource resource = resourceSet.getResource(URIHelper.getPlatformPluginURI((IResource) selectedObject), true);
				IPlatformFcore fcore = ((IPlatformFcoreProvider) resource).getIPlatformFcore();
				if (fcore != null) {
					if (resource.getContents().size() == 1 && resource.getContents().get(0) instanceof Activity) {
						_activity = (Activity) resource.getContents().get(0);
						return null;
					}
					return fcore;
				}
			} catch (Throwable t) {
				EGFProducerUIPlugin.getDefault().logError(t);
			}
		}
		return null;
	}

	private int showValidateDialog(List<Activity> activities, boolean validate, boolean prompt) {
		if (validate) {
			if (prompt && activities != null && activities.size() > 0) {
				ActivityValidationSelectionDialog dialog = new ActivityValidationSelectionDialog(EGFProducerUIPlugin.getActiveWorkbenchShell(), activities);
				if (dialog.open() == IDialogConstants.CANCEL_ID) {
					return IDialogConstants.CANCEL_ID;
				}
				Object[] objects = dialog.getResult();
				_validates = new ArrayList<Activity>(objects.length);
				for (int i = 0; i < objects.length; i++) {
					_validates.add((Activity) objects[i]);
				}
			} else {
				_validates = activities;
			}
		}
		return IDialogConstants.OK_ID;
	}

	public void selectionChanged(IAction action, ISelection selection) {
		_activity = null;
		if (selection instanceof IStructuredSelection) {
			_activity = getActivitySelection((IStructuredSelection) selection);
			if (_activity == null) {
				_fcore = getPlatformFcoreSelection((IStructuredSelection) selection);
			}
		}
	}

	public void setActivePart(IAction action, IWorkbenchPart activePart) {
		_shell = activePart.getSite().getShell();
	}

}
