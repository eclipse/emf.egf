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
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.diagnostic.EGFValidator;
import org.eclipse.egf.model.editor.dialogs.ActivitySelectionDialog;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.egf.producer.ui.EGFProducerUIPlugin;
import org.eclipse.egf.producer.ui.internal.dialogs.ActivityValidationSelectionDialog;
import org.eclipse.egf.producer.ui.internal.ui.ProducerUIImages;
import org.eclipse.egf.producer.ui.l10n.ProducerUIMessages;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IActionDelegate2;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.progress.IProgressConstants;

public class GlobalRunActivityAction extends Action implements IWorkbenchWindowActionDelegate, IActionDelegate2 {

  /**
   * Activities to validate (if any)
   */
  private List<Activity> _validates = null;

  public GlobalRunActivityAction() {
    super();
    setText(ProducerUIMessages.GlobalRunActivityAction_label);
    setDescription(ProducerUIMessages.GlobalRunActivityAction_description);
    setToolTipText(ProducerUIMessages.GlobalRunActivityAction_tooltip);
    setImageDescriptor(ProducerUIImages.EGF_RUN_ACTIVITY);
  }

  @Override
  public void run() {
    runWithEvent(null);
  }

  @Override
  public void runWithEvent(Event event) {

    _validates = null;

    // 1 - Activity Selection
    ActivitySelectionDialog activityDialog = new ActivitySelectionDialog(EGFProducerUIPlugin.getActiveWorkbenchShell(), false);
    activityDialog.setTitle(ProducerUIMessages.GlobalRunActivityAction_dialogTitle);
    int result = activityDialog.open();
    if (result != IDialogConstants.OK_ID) {
      return;
    }
    final Object[] selection = activityDialog.getResult();
    if (selection == null || selection.length != 1) {
      return;
    }

    final Activity[] activity = new Activity[] { (Activity) selection[0] };
    Throwable throwable = null;
    final IActivityManager<?>[] activityManager = new IActivityManager[1];
    final int[] ticks = new int[1];

    // 2 - Locate a Manager Producer
    try {
      ActivityManagerProducer<Activity> producer = null;
      try {
        producer = EGFProducerPlugin.getActivityManagerProducer(activity[0]);
      } catch (Throwable t) {
        throw new InvocationException(t);
      }
      // Create a Manager
      activityManager[0] = producer.createActivityManager(activity[0]);
    } catch (Throwable t) {
      throwable = t;
    }

    // 3 - Validation
    if (throwable == null) {
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
        throwable = ie;
      }
    }

    // 4 - canInvoke
    if (throwable == null) {
      try {
        // Initialize Context
        activityManager[0].initializeContext();
        // Check if activity could be invoked
        final Diagnostic preInvokeDiag = activityManager[0].canInvoke();
        if (preInvokeDiag.getSeverity() != Diagnostic.OK) {
          if (EGFProducerUIPlugin.getWorkbenchDisplay() != null) {
            EGFProducerUIPlugin.getWorkbenchDisplay().asyncExec(new Runnable() {
              public void run() {
                EGFValidator.handleDiagnostic(ProducerUIMessages._UI_CantInvokeProblems_title, ProducerUIMessages._UI_CantInvokeProblems_message, preInvokeDiag);
              }
            });
          }
          if (preInvokeDiag.getSeverity() == Diagnostic.ERROR) {
            return;
          }
        }
      } catch (InvocationException ie) {
        throwable = ie;
      }
    }

    // 5 - Count Ticks
    if (throwable == null) {
      try {
        ticks[0] = activityManager[0].getSteps();
      } catch (Throwable t) {
        throwable = t;
      }
    }

    // 6 - Run activity
    if (throwable == null) {

      WorkspaceJob activityJob = new WorkspaceJob(ProducerUIMessages.GlobalRunActivityAction_label) {

        @Override
        public boolean belongsTo(Object family) {
          return EGFCorePlugin.FAMILY_MANUAL_BUILD.equals(family);
        }

        @Override
        public IStatus runInWorkspace(IProgressMonitor innerMonitor) throws CoreException {
          // Invoke
          SubMonitor subMonitor = SubMonitor.convert(innerMonitor, NLS.bind(EGFCoreMessages.Production_Invoke, EMFHelper.getText(activityManager[0].getElement())), (1000 * ticks[0]));
          try {
            try {
              if (EGFProducerUIPlugin.getDefault().isDebugging()) {
                if (ticks[0] == 1) {
                  EGFProducerUIPlugin.getDefault().logInfo(NLS.bind(ProducerUIMessages.Activity_Invocation, EMFHelper.getText(activity[0])));
                } else {
                  EGFProducerUIPlugin.getDefault().logInfo(NLS.bind(ProducerUIMessages.Activity_Invocations, EMFHelper.getText(activity[0]), ticks[0]));
                }
              }
              final Diagnostic diagnostic = activityManager[0].invoke(subMonitor.newChild(1000 * ticks[0], SubMonitor.SUPPRESS_NONE));
              if (subMonitor.isCanceled()) {
                throw new OperationCanceledException();
              }
              if (diagnostic != null && diagnostic.getSeverity() != Diagnostic.OK) {
                if (EGFProducerUIPlugin.getWorkbenchDisplay() != null) {
                  EGFProducerUIPlugin.getWorkbenchDisplay().asyncExec(new Runnable() {
                    public void run() {
                      EGFValidator.handleDiagnostic(ProducerUIMessages._UI_CantInvokeProblems_title, ProducerUIMessages._UI_CantInvokeProblems_message, diagnostic);
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
            innerMonitor.done();
          }
          return Status.OK_STATUS;
        }
      };
      activityJob.setRule(ResourcesPlugin.getWorkspace().getRuleFactory().buildRule());
      activityJob.setProperty(IProgressConstants.ICON_PROPERTY, ProducerUIImages.EGF_RUN_ACTIVITY);
      activityJob.setPriority(Job.LONG);
      activityJob.setUser(true);
      activityJob.setSystem(false);
      activityJob.schedule();

    }

    if (throwable != null && throwable instanceof InterruptedException == false) {
      ThrowableHandler.handleThrowable(EGFProducerUIPlugin.getDefault().getPluginID(), throwable);
    }

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
    // do nothing.
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
