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
import org.eclipse.egf.model.editor.EGFModelsEditorPlugin;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.IWorkbenchPartSite;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFAdapter extends EContentAdapter {

  private IWorkbenchPartSite _site;

  public EGFAdapter(IWorkbenchPartSite site) {
    _site = site;
  }

  @Override
  public void notifyChanged(Notification notification) {
    super.notifyChanged(notification);
    if (notification.getNewValue() != null && notification.getNewValue() instanceof Pattern) {
      handlePatternNotification(notification);
    }
  }

  private void handlePatternNotification(Notification notification) {
    if (notification.getEventType() == Notification.ADD) {
      Pattern pattern = (Pattern) notification.getNewValue();
      final IPlatformFcore fcore = EGFCorePlugin.getPlatformFcore(pattern.eResource());
      if (fcore == null || fcore.getPlatformBundle().getProject() == null) {
        return;
      }
      IRunnableWithProgress operation = new ConvertProjectOperation(fcore.getPlatformBundle().getProject(), true, true) {
        @Override
        public List<String> addDependencies() {
          List<String> dependencies = new ArrayList<String>(1);
          dependencies.add("org.eclipse.egf.pattern"); //$NON-NLS-1$
          return dependencies;
        }

        @Override
        public List<String> addSourceFolders() {
          List<String> sourceFolders = new ArrayList<String>(1);
          sourceFolders.add("generated"); //$NON-NLS-1$
          return sourceFolders;
        }
      };
      // Asynchronous operation
      try {
        new ProgressMonitorDialog(_site.getShell()).run(false, true, operation);
      } catch (InterruptedException ie) {
        // Nothing to do
      } catch (Exception e) {
        ThrowableHandler.handleThrowable(EGFModelsEditorPlugin.getPlugin().getSymbolicName(), e);
      }
    }
  }

}
