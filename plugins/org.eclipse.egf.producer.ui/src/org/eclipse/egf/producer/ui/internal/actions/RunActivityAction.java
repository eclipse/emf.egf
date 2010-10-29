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
import org.eclipse.egf.core.domain.TargetPlatformResourceSet;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.diagnostic.EGFValidator;
import org.eclipse.egf.model.editor.dialogs.ActivitySelectionDialog;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.egf.producer.ui.EGFProducerUIPlugin;
import org.eclipse.egf.producer.ui.internal.dialogs.ActivityValidationSelectionDialog;
import org.eclipse.egf.producer.ui.internal.ui.IProducerUIImages;
import org.eclipse.egf.producer.ui.l10n.ProducerUIMessages;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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

        final IActivityManager<?>[] activityManager = new IActivityManager[1];
        List<Throwable> throwables = new ArrayList<Throwable>();
        final int[] ticks = new int[1];

        // 2 - Locate an ActivityManagerProducer and create an ActivityManager
        try {
            ActivityManagerProducer<Activity> producer = EGFProducerPlugin.getActivityManagerProducer(_activity);
            // Create a Manager
            activityManager[0] = producer.createActivityManager(_activity);
        } catch (Throwable t) {
            throwables.add(t);
        }

        // 3 - Validation
        if (throwables.size() == 0) {
            try {
                IPreferenceStore store = EGFCoreUIPlugin.getDefault().getPreferenceStore();
                String validate = store.getString(IEGFModelConstants.VALIDATE_MODEL_INSTANCES_BEFORE_LAUNCH);
                List<Activity> activities = activityManager[0].getActivities();
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
            } catch (InvocationException ie) {
                throwables.add(ie);
            }
        }

        // 4 - PreInvoke Validation
        if (throwables.size() == 0) {
            try {
                // Initialize Context
                activityManager[0].initializeContext();
                // Check if activity could be invoked
                final Diagnostic preInvokeDiag = activityManager[0].canInvoke();
                if (preInvokeDiag.getSeverity() != Diagnostic.OK) {
                    if (EGFProducerUIPlugin.getWorkbenchDisplay() != null) {
                        EGFProducerUIPlugin.getWorkbenchDisplay().asyncExec(new Runnable() {

                            public void run() {
                                EGFValidator.handleDiagnostic(ProducerUIMessages.ActivityValidationSelectionDialog_Title, ProducerUIMessages._UI_PreInvokeProblems_message, preInvokeDiag);
                            }

                        });
                    }
                    if (preInvokeDiag.getSeverity() == Diagnostic.ERROR) {
                        return;
                    }
                }
            } catch (InvocationException ie) {
                throwables.add(ie);
            }
        }

        // 5 - Count Ticks
        if (throwables.size() == 0) {
            try {
                ticks[0] = activityManager[0].getSteps();
            } catch (Throwable t) {
                throwables.add(t);
            }
        }

        // 6 - Run activity
        if (throwables.size() == 0) {

            WorkspaceJob activityJob = new WorkspaceJob(ProducerUIMessages.GlobalRunActivityAction_label) {

                @Override
                public boolean belongsTo(Object family) {
                    return EGFCorePlugin.FAMILY_MANUAL_BUILD.equals(family);
                }

                @Override
                public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
                    try {
                        SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, EMFHelper.getText(activityManager[0].getElement())), (1000 * ticks[0]));
                        try {
                            if (EGFProducerUIPlugin.getDefault().isDebugging()) {
                                if (ticks[0] == 1) {
                                    EGFProducerUIPlugin.getDefault().logInfo(NLS.bind(ProducerMessages.Activity_Invocation, EMFHelper.getText(_activity)));
                                } else {
                                    EGFProducerUIPlugin.getDefault().logInfo(NLS.bind(ProducerMessages.Activity_Invocations, EMFHelper.getText(_activity), ticks[0]));
                                }
                            }
                            final Diagnostic diagnostic = activityManager[0].invoke(subMonitor.newChild(1000 * ticks[0], SubMonitor.SUPPRESS_NONE));
                            if (subMonitor.isCanceled()) {
                                throw new OperationCanceledException();
                            }
                            // Post Invoke Validation
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
                        } catch (Throwable t) {
                            throw new CoreException(EGFProducerUIPlugin.getDefault().newStatus(IStatus.ERROR, EGFCommonMessages.Exception_unexpectedException, t));
                        } finally {
                            try {
                                activityManager[0].dispose();
                            } catch (InvocationException ie) {
                                if (ie.getCause() != null && ie.getCause() instanceof CoreException) {
                                    throw (CoreException) ie.getCause();
                                }
                                ThrowableHandler.handleThrowable(EGFProducerUIPlugin.getDefault().getPluginID(), ie);
                            } catch (Throwable t) {
                                throw new CoreException(EGFProducerUIPlugin.getDefault().newStatus(IStatus.ERROR, EGFCommonMessages.Exception_unexpectedException, t));
                            }
                        }
                    } finally {
                        monitor.done();
                    }
                    return Status.OK_STATUS;
                }
            };
            activityJob.setRule(ResourcesPlugin.getWorkspace().getRuleFactory().buildRule());
            activityJob.setProperty(IProgressConstants.ICON_PROPERTY, IProducerUIImages.EGF_RUN_ACTIVITY);
            activityJob.setPriority(Job.LONG);
            activityJob.setUser(true);
            activityJob.setSystem(false);
            activityJob.schedule();

        }

        if (throwables.size() != 0) {
            // In trouble case, try to dispose the manager
            if (activityManager[0] != null) {
                try {
                    activityManager[0].dispose();
                } catch (Throwable t) {
                    throwables.add(t);
                }
            }
            // Display Throwable
            for (Throwable throwable : throwables) {
                if (throwable instanceof InterruptedException == false) {
                    ThrowableHandler.handleThrowable(EGFProducerUIPlugin.getDefault().getPluginID(), throwable);
                }
            }
        }

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
                ResourceSet resourceSet = new TargetPlatformResourceSet();
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
