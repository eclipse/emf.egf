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

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.egf.common.ui.diagnostic.EMFValidator;
import org.eclipse.egf.common.ui.diagnostic.ThrowableHandler;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.helper.ResourceHelper;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.MissingExtensionException;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.dialogs.FcoreSelectionDialog;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.egf.producer.ui.EGFProducerUIPlugin;
import org.eclipse.egf.producer.ui.internal.ui.ProducerUIImages;
import org.eclipse.egf.producer.ui.l10n.ProducerUIMessages;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
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

    // 1 - Fcore Selection
    FcoreSelectionDialog fcoreDialog = new FcoreSelectionDialog(EGFProducerUIPlugin.getActiveWorkbenchShell(), false);
    fcoreDialog.setTitle(ProducerUIMessages.GlobalRunActivityAction_dialogTitle);
    fcoreDialog.setMessage(ProducerUIMessages.GlobalRunActivityAction_dialogMessage);
    int result = fcoreDialog.open();
    if (result != IDialogConstants.OK_ID) {
      return;
    }
    final Object[] fcores = fcoreDialog.getResult();
    if (fcores == null || fcores.length != 1) {
      return;
    }

    final Throwable[] throwable = new Throwable[1];
    final IActivityManager[] activityManager = new IActivityManager[1];
    final int[] ticks = new int[1];

    // 2 - Load Fcore Resource and Activity selection
    final Activity[] activity = new Activity[1];
    try {
      ResourceSet resourceSet = new ResourceSetImpl();
      Resource resource = ResourceHelper.loadResource(resourceSet, ((IPlatformFcore) fcores[0]).getURI());
      EObject eObject = resource.getContents().get(0);
      if (eObject instanceof Activity == false) {
        return;
      }
      activity[0] = (Activity) eObject;
    } catch (Throwable t) {
      throwable[0] = t;
    }

    // 3 - Locate a Manager Producer
    if (throwable[0] == null) {
      try {
        ActivityManagerProducer producer = null;
        try {
          producer = EGFProducerPlugin.getActivityManagerProducer(activity[0]);
        } catch (MissingExtensionException mee) {
          throw new InvocationException(mee);
        }
        // Create a Manager
        activityManager[0] = producer.createActivityManager(activity[0]);
        ticks[0] = activityManager[0].getSteps();
      } catch (Throwable t) {
        throwable[0] = t;
      }
    }

    // 4 - Validation
    if (throwable[0] == null) {
      IPreferenceStore store = EGFCoreUIPlugin.getDefault().getPreferenceStore();
      String validate = store.getString(IEGFModelConstants.VALIDATE_MODEL_INSTANCES_BEFORE_LAUNCH);
      if (validate.equals(MessageDialogWithToggle.NEVER) == false) {
        if (validate.equals(MessageDialogWithToggle.PROMPT)) {
          MessageDialog dialog = new MessageDialog(EGFProducerUIPlugin.getActiveWorkbenchShell(), CoreUIMessages.ValidateDialog_Title, null, CoreUIMessages.ValidateDialog_Always_Validate, MessageDialog.QUESTION_WITH_CANCEL, new String[] { CoreUIMessages.EGFProductionPreferencePage_Validate_Always, CoreUIMessages.EGFProductionPreferencePage_Validate_Prompt, IDialogConstants.CANCEL_LABEL }, 0);
          int ret = dialog.open();
          if (ret == 0) {
            store.setValue(IEGFModelConstants.VALIDATE_MODEL_INSTANCES_BEFORE_LAUNCH, MessageDialogWithToggle.ALWAYS);
          } else if (ret == 1) {
            store.setValue(IEGFModelConstants.VALIDATE_MODEL_INSTANCES_BEFORE_LAUNCH, MessageDialogWithToggle.PROMPT);
          } else {
            return;
          }
        }
        // doValidation();
        try {
          EMFValidator validator = new EMFValidator(activityManager[0].getTopElements());
          Diagnostic diagnostic = validator.validate();
          if (diagnostic.getSeverity() != Diagnostic.OK) {
            return;
          }
        } catch (InvocationException ie) {
          throwable[0] = ie;
        }
      }
    }

    // 3 - Run activity
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
                EGFProducerUIPlugin.getDefault().logInfo(NLS.bind("Activity ''{0}'' will invoke ''{1}'' step(s).", EMFHelper.getText(activity), ticks)); //$NON-NLS-1$
              }
              activityManager[0].invoke(subMonitor.newChild((1000 * ticks[0]), SubMonitor.SUPPRESS_NONE));
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
      } catch (InterruptedException ie) {
        // Do nothing
      }

    }

    if (throwable[0] != null) {
      EGFProducerUIPlugin.getDefault().logError(throwable[0]);
      ThrowableHandler.displayAsyncDiagnostic(EGFProducerUIPlugin.getActiveWorkbenchShell(), throwable[0]);
    }

    return;

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
