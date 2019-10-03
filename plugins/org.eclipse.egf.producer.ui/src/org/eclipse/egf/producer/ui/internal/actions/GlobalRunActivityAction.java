/*******************************************************************************
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.producer.ui.internal.actions;

import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.EGFCorePlugin;
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
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate2;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.progress.IProgressConstants;

public class GlobalRunActivityAction extends Action implements IWorkbenchWindowActionDelegate, IActionDelegate2 {

    /**
     * Current shell
     */
    private Shell _shell;

    /**
     * Activities to validate (if any)
     */
    private List<Activity> _validates = null;

    public GlobalRunActivityAction() {
        super();
        setText(ProducerUIMessages.GlobalRunActivityAction_label);
        setDescription(ProducerUIMessages.GlobalRunActivityAction_description);
        setToolTipText(ProducerUIMessages.GlobalRunActivityAction_tooltip);
        setImageDescriptor(EGFProducerUIPlugin.getDefault().getImageDescriptor(IProducerUIImages.EGF_RUN_ACTIVITY));
    }

    @Override
    public void run() {
        runWithEvent(null);
    }

    @Override
    public void runWithEvent(Event event) {

        _validates = null;

        // 1 - Activity Selection
        ActivitySelectionDialog activityDialog = new ActivitySelectionDialog(_shell, (Activity) null, false, true);
        activityDialog.setTitle(ProducerUIMessages.GlobalRunActivityAction_dialogTitle);
        int result = activityDialog.open();
        if (result != IDialogConstants.OK_ID) {
            return;
        }
        final Object[] selection = activityDialog.getResult();
        // Nothing to process
        if (selection == null || selection.length != 1) {
            return;
        }

        final Activity[] activity = new Activity[] { (Activity) selection[0] };

        // 2 - Validation
        IPreferenceStore store = EGFCoreUIPlugin.getDefault().getPreferenceStore();
        String validate = store.getString(IEGFModelConstants.VALIDATE_MODEL_INSTANCES_BEFORE_LAUNCH);
        List<Activity> activities = activity[0].getActivities();
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
        for (Activity innerActivity : activities) {
            if (innerActivity instanceof Task) {
                tasks.add((Task) innerActivity);
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
                for (Resource resource : activity[0].getResources()) {
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

                subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, EMFHelper.getText(activity[0])), (100 * fcores.size()) + (1000 * tasks.size()));

                try {

                    // 4 - Load workspace bundles in runtime
                    for (IPlatformFcore fcore : fcores) {
                        SubMonitor childSubMonitor = subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE);
                        childSubMonitor = SubMonitor.convert(childSubMonitor, NLS.bind(EGFCoreMessages.Production_Load_Bundle, fcore.getPlatformBundle().getBundleId()), 100);
                        session.getBundle(fcore.getPlatformBundle().getProject());
                    }

                    // 5 - Switch to runtime mode
                    ResourceSet resourceSet = new RuntimePlatformResourceSet();
                    activity[0] = (Activity) resourceSet.getEObject(EcoreUtil.getURI(activity[0]), true);

                    // 6 - Locate an ActivityManagerProducer and create an
                    // ActivityManager
                    ActivityManagerProducer<Activity> producer = EGFProducerPlugin.getActivityManagerProducer(activity[0]);
                    activityManager = producer.createActivityManager(activity[0]);
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

                    // 10 - PostInvoke Validation
                    if (diagnostic != null && diagnostic.getSeverity() != Diagnostic.OK) {
                        if (EGFProducerUIPlugin.getWorkbenchDisplay() != null) {
                            EGFProducerUIPlugin.getWorkbenchDisplay().asyncExec(new Runnable() {

                                public void run() {
                                    EGFValidator.handleDiagnostic(ProducerUIMessages.ActivityValidationSelectionDialog_Title, ProducerUIMessages._UI_PostInvokeProblems_message, diagnostic);
                                }

                            });
                        }
                    }

                } catch (InvocationException ie) {
                    if (ie.getCause() != null && ie.getCause() instanceof CoreException) {
                        throw (CoreException) ie.getCause();
                    }
                    ThrowableHandler.handleThrowable(EGFProducerUIPlugin.getDefault().getPluginID(), ie);
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

    // ---- IWorkbenchWindowActionDelegate
    // ------------------------------------------------

    public void run(IAction action) {
        run();
    }

    public void dispose() {
        // do nothing.
    }

    public void init(IWorkbenchWindow window) {
        _shell = window.getShell();
    }

    public void selectionChanged(IAction action, ISelection selection) {
        // do nothing. Action doesn't depend on selection.
    }

    // ---- IActionDelegate2
    // ------------------------------------------------

    public void runWithEvent(IAction action, Event event) {
        runWithEvent(event);
    }

    public void init(IAction action) {
        // do nothing.
    }

}
