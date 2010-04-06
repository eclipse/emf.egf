/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.editor.adapter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.pde.tools.ConvertProjectOperation;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPartSite;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskBundleAdapter extends EContentAdapter {

  private Resource _resource;
  private Shell _shell;

  public TaskBundleAdapter(Resource resource) {
    _shell = EGFModelEditorPlugin.getActiveWorkbenchShell();
    _resource = resource;
  }

  public TaskBundleAdapter(Resource resource, IWorkbenchPartSite site) {
    _shell = site != null ? site.getShell() : EGFModelEditorPlugin.getActiveWorkbenchShell();
    _resource = resource;
  }

  @Override
  public void notifyChanged(Notification notification) {
    super.notifyChanged(notification);
    if (notification.getNewValue() != null && notification.getNewValue() instanceof Task) {
      handleTaskNotification(notification);
    }
  }

  private void handleTaskNotification(Notification notification) {
    if (notification.getEventType() == Notification.ADD) {
      Task task = (Task) notification.getNewValue();
      Resource resource = task.eResource();
      if (resource != _resource || ((ResourceImpl) resource).isLoading()) {
        return;
      }
      final IPlatformFcore fcore = EGFCorePlugin.getPlatformFcore(_resource);
      if (fcore == null || fcore.getPlatformBundle().getProject() == null) {
        return;
      }
      // If a task already exists, do not convert
      for (Object object : _resource.getContents()) {
        if (object instanceof Task && object != task) {
          return;
        }
      }
      IRunnableWithProgress operation = new ConvertProjectOperation(fcore.getPlatformBundle().getProject(), true, true) {
        @Override
        public List<String> addDependencies() {
          List<String> dependencies = new ArrayList<String>(1);
          dependencies.add("org.eclipse.egf.model.ftask"); //$NON-NLS-1$
          return dependencies;
        }

        @Override
        public List<String> addSourceFolders() {
          List<String> sourceFolders = new ArrayList<String>(1);
          sourceFolders.add("src"); //$NON-NLS-1$
          return sourceFolders;
        }
      };
      // asynchronous operation
      try {
        new ProgressMonitorDialog(_shell).run(true, false, operation);
      } catch (InterruptedException ie) {
        // Nothing to do
      } catch (Exception e) {
        ThrowableHandler.handleThrowable(EGFModelEditorPlugin.getPlugin().getSymbolicName(), e);
      }
    }
  }

}
