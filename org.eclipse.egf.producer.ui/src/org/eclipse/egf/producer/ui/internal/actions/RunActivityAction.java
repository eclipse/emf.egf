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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.MissingExtensionException;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.diagnostic.EGFValidator;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.egf.producer.ui.EGFProducerUIPlugin;
import org.eclipse.egf.producer.ui.internal.dialogs.ActivityValidationSelectionDialog;
import org.eclipse.egf.producer.ui.internal.ui.ProducerUIImages;
import org.eclipse.egf.producer.ui.l10n.ProducerUIMessages;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.progress.IProgressConstants;
import org.eclipse.ui.statushandlers.StatusManager;

public class RunActivityAction implements IObjectActionDelegate {

  private Activity _activity;

  /**
   * Activities to validate (if any)
   */
  private List<Activity> _validates = null;

  public void run(IAction action) {

    _validates = null;

    if (_activity == null) {
      return;
    }

    final Throwable[] throwable = new Throwable[1];

    // 1 - Locate a Manager Producer
    final IActivityManager[] activityManager = new IActivityManager[1];
    final int[] ticks = new int[1];
    try {
      ActivityManagerProducer producer = null;
      try {
        producer = EGFProducerPlugin.getActivityManagerProducer(_activity);
      } catch (MissingExtensionException mee) {
        throw new InvocationException(mee);
      }
      // Create a Manager
      activityManager[0] = producer.createActivityManager(_activity);
      ticks[0] = activityManager[0].getSteps();
    } catch (Throwable t) {
      throwable[0] = t;
    }

    // 2 - Validation
    if (throwable[0] == null) {
      try {
        IPreferenceStore store = EGFCoreUIPlugin.getDefault().getPreferenceStore();
        String validate = store.getString(IEGFModelConstants.VALIDATE_MODEL_INSTANCES_BEFORE_LAUNCH);
        int status = showValidateDialog(activityManager[0].getActivities(), validate.equals(MessageDialogWithToggle.NEVER) == false, validate.equals(MessageDialogWithToggle.PROMPT));
        if (status != IDialogConstants.OK_ID) {
          return;
        }
        if (_validates != null && _validates.size() != 0) {
          EGFValidator validator = new EGFValidator(activityManager[0].getActivities());
          Diagnostic validationDiag = validator.validate();
          if (validationDiag.getSeverity() != Diagnostic.OK) {
            return;
          }
        }
      } catch (InvocationException ie) {
        throwable[0] = ie;
      }
    }

    // 3 - canInvoke
    if (throwable[0] == null) {
      try {
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
        throwable[0] = ie;
      }
    }

    final Diagnostic[] invokeDiag = new Diagnostic[1];

    // 4 - Run activity
    if (throwable[0] == null) {

      WorkspaceJob activityJob = new WorkspaceJob(ProducerUIMessages.GlobalRunActivityAction_label) {

        @Override
        public boolean belongsTo(Object family) {
          return EGFCorePlugin.FAMILY_MANUAL_BUILD.equals(family);
        }

        @Override
        public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
          // Invoke
          SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, activityManager[0].getName()), (1000 * ticks[0]));
          try {
            try {
              if (EGFProducerUIPlugin.getDefault().isDebugging()) {
                EGFProducerUIPlugin.getDefault().logInfo(NLS.bind("Activity ''{0}'' will invoke ''{1}'' step(s).", EMFHelper.getText(_activity), ticks[0])); //$NON-NLS-1$
              }
              activityManager[0].initializeContext();
              invokeDiag[0] = activityManager[0].invoke(subMonitor.newChild(1000 * ticks[0], SubMonitor.SUPPRESS_NONE));
              if (monitor.isCanceled()) {
                throw new OperationCanceledException();
              }
            } catch (InvocationException ie) {
              if (ie.getCause() != null && ie.getCause() instanceof CoreException) {
                throw (CoreException) ie.getCause();
              }
              throwable[0] = ie;
            } catch (Throwable t) {
              throw new CoreException(EGFProducerUIPlugin.getDefault().newStatus(IStatus.ERROR, EGFCommonMessages.Exception_unexpectedException, t));
            } finally {
              try {
                activityManager[0].dispose();
              } catch (InvocationException ie) {
                if (ie.getCause() != null && ie.getCause() instanceof CoreException) {
                  throw (CoreException) ie.getCause();
                }
                throwable[0] = ie;
              } catch (Throwable t) {
                throw new CoreException(EGFProducerUIPlugin.getDefault().newStatus(IStatus.ERROR, EGFCommonMessages.Exception_unexpectedException, t));
              }
            }
          } finally {
            subMonitor.done();
          }
          return Status.OK_STATUS;
        }
      };
      activityJob.setRule(ResourcesPlugin.getWorkspace().getRuleFactory().buildRule());
      activityJob.setProperty(IProgressConstants.ICON_PROPERTY, ProducerUIImages.EGF_RUN_ACTIVITY);
      activityJob.setUser(true);
      activityJob.schedule();

      try {// block
        activityJob.join();
      } catch (InterruptedException e) {
        // Do nothing
      }

    }

    if (throwable[0] != null) {
      IStatus status = null;
      if (throwable[0] instanceof CoreException) {
        status = ((CoreException) throwable[0]).getStatus();
        EGFProducerUIPlugin.getDefault().log(status);
      } else if (throwable[0] instanceof InvocationException) {
        status = EGFProducerUIPlugin.getDefault().newStatus(IStatus.ERROR, InvocationException.class.getSimpleName(), throwable[0]);
      } else {
        status = EGFProducerUIPlugin.getDefault().newStatus(IStatus.ERROR, EGFCommonMessages.Exception_unexpectedException, throwable[0]);
        EGFProducerUIPlugin.getDefault().log(status);
      }
      StatusManager.getManager().handle(status, StatusManager.SHOW);
    } else if (invokeDiag[0] != null && invokeDiag[0].getSeverity() != Diagnostic.OK) {
      if (EGFProducerUIPlugin.getWorkbenchDisplay() != null) {
        EGFProducerUIPlugin.getWorkbenchDisplay().asyncExec(new Runnable() {
          public void run() {
            EGFValidator.handleDiagnostic(ProducerUIMessages._UI_CantInvokeProblems_title, ProducerUIMessages._UI_CantInvokeProblems_message, invokeDiag[0]);
          }
        });
      }
    }

    return;

  }

  protected Activity getSelection(IStructuredSelection selection) {
    Object selectedObject = selection.getFirstElement();
    if (selectedObject == null) {
      return null;
    }
    if (selectedObject instanceof Activity) {
      return (Activity) selectedObject;
    }
    if (selectedObject instanceof IAdaptable) {
      Object adaptedObject = ((IAdaptable) selectedObject).getAdapter(Activity.class);
      if (adaptedObject != null && adaptedObject instanceof Activity) {
        return (Activity) adaptedObject;
      }
    }
    IAdapterManager adapterManager = Platform.getAdapterManager();
    if (adapterManager.hasAdapter(selectedObject, Activity.class.getName())) {
      Object adaptedObject = adapterManager.loadAdapter(selectedObject, IFile.class.getName());
      if (adaptedObject instanceof Activity) {
        return (Activity) adaptedObject;
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
      _activity = getSelection((IStructuredSelection) selection);
    }
  }

  public void setActivePart(IAction action, IWorkbenchPart activePart) {
    // Nothing to do
  }

}
