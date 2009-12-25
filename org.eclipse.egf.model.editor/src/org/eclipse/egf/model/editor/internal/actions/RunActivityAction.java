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
package org.eclipse.egf.model.editor.internal.actions;

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
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.model.EGFModelsPlugin;
import org.eclipse.egf.model.editor.EGFModelsEditorPlugin;
import org.eclipse.egf.model.editor.l10n.EGFModelsEditorMessages;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.emf.ecore.util.EcoreUtil;
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

    // batching changes
    WorkspaceJob cleanJob = new WorkspaceJob(EGFModelsEditorMessages.GlobalRunActivityAction_label) {

      @Override
      public boolean belongsTo(Object family) {
        return EGFCorePlugin.FAMILY_MANUAL_BUILD.equals(family);
      }

      @Override
      public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
        IProductionContext rootContext = EGFModelsPlugin.getModelProductionContextFactory().createModelProductionContext(_activity);
        int steps = _activity.getSteps();
        SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, rootContext.getName()), (900 * steps) + 100);
        try {
          try {
            if (EGFModelsEditorPlugin.getPlugin().isDebugging()) {
              EGFModelsEditorPlugin.getPlugin().logInfo(NLS.bind("Activity ''{0}'' will invoke ''{1}'' step(s).", EcoreUtil.getURI(_activity).toString(), _activity.getSteps())); //$NON-NLS-1$
            }
            _activity.invoke(rootContext, subMonitor.newChild(900 * steps, SubMonitor.SUPPRESS_NONE));
            if (monitor.isCanceled()) {
              throw new OperationCanceledException();
            }
          } catch (InvocationException ie) {
            if (ie.getCause() instanceof CoreException) {
              throw (CoreException) ie.getCause();
            }
            throw new CoreException(EGFModelsEditorPlugin.getPlugin().newStatus(IStatus.ERROR, "RunActivityAction.run(..) _", ie.getCause())); //$NON-NLS-1$
          }
        } finally {
          rootContext.dispose();
          subMonitor.done();
        }
        return Status.OK_STATUS;
      }
    };
    cleanJob.setRule(ResourcesPlugin.getWorkspace().getRuleFactory().buildRule());
    cleanJob.setUser(true);
    cleanJob.schedule();

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
