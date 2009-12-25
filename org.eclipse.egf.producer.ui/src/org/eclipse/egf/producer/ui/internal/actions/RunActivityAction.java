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
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.egf.common.ui.diagnostic.DiagnosticHandler;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.helper.EObjectHelper;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.MissingExtensionException;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.activity.ActivityProducer;
import org.eclipse.egf.producer.manager.IModelProducerManager;
import org.eclipse.egf.producer.ui.EGFProducerUIPlugin;
import org.eclipse.egf.producer.ui.l10n.ProducerUIMessages;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class RunActivityAction implements IObjectActionDelegate {

  private Activity _activity;

  public void run(IAction action) {

    if (_activity == null) {
      return;
    }

    ResourceSet resourceSet = new ResourceSetImpl();
    final Activity activity = (Activity) EObjectHelper.loadEObject(resourceSet, _activity);
    final InvocationException[] invocationException = new InvocationException[1];

    // run activity
    WorkspaceJob activityJob = new WorkspaceJob(ProducerUIMessages.GlobalRunActivityAction_label) {

      @Override
      public boolean belongsTo(Object family) {
        return EGFCorePlugin.FAMILY_MANUAL_BUILD.equals(family);
      }

      @Override
      public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
        IModelProducerManager<Activity> production = null;
        int ticks = 0;
        try {
          // Locate a Producer
          ActivityProducer<Activity> producer = null;
          try {
            producer = EGFProducerPlugin.getActivityProducer(activity);
          } catch (MissingExtensionException mee) {
            throw new InvocationException(mee);
          }
          // Create a Manager
          production = producer.createManager(activity);
          ticks = production.getSteps();
        } catch (InvocationException ie) {
          if (ie.getCause() instanceof CoreException) {
            throw (CoreException) ie.getCause();
          }
          invocationException[0] = ie;
          return Status.OK_STATUS;
        }
        SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, production.getName()), (900 * ticks) + 100);
        try {
          try {
            if (EGFProducerUIPlugin.getDefault().isDebugging()) {
              EGFProducerUIPlugin.getDefault().logInfo(NLS.bind("Activity ''{0}'' will invoke ''{1}'' step(s).", EObjectHelper.getText(activity), ticks)); //$NON-NLS-1$
            }
            production.invoke(subMonitor.newChild(900 * ticks, SubMonitor.SUPPRESS_NONE));
            if (monitor.isCanceled()) {
              throw new OperationCanceledException();
            }
          } catch (final InvocationException ie) {
            if (ie.getCause() instanceof CoreException) {
              throw (CoreException) ie.getCause();
            }
            invocationException[0] = ie;
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
    activityJob.setUser(true);
    activityJob.schedule();

    try {// block
      activityJob.join();
    } catch (InterruptedException e) {
      // Do nothing
    }

    if (invocationException[0] != null) {
      DiagnosticHandler.displayAsyncDiagnostic(EGFProducerUIPlugin.getActiveWorkbenchShell(), invocationException[0]);
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
