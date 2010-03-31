/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.task.ui.contributions;

import java.net.URL;
import java.util.Enumeration;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.common.ui.constant.EGFCommonUIConstants;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.pde.helper.PluginHelper;
import org.eclipse.egf.core.ui.contributor.MenuContributor;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.task.EGFTaskPlugin;
import org.eclipse.egf.task.ui.l10n.EGFTaskUIMessages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.internal.core.target.provisional.IResolvedBundle;
import org.eclipse.pde.internal.core.target.provisional.ITargetDefinition;
import org.eclipse.ui.ide.IDE;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class OpenTaskImplementationMenuContributor extends MenuContributor {

  public static final String OPEN_TASK_IMPLEMENTATION_ACTION_ID = "open-task-implementation"; //$NON-NLS-1$  

  private class OpenTaskImplementationAction extends Action {

    public OpenTaskImplementationAction() {
      setId(OPEN_TASK_IMPLEMENTATION_ACTION_ID);
    }

    protected Task getTask() {
      if (_selection == null) {
        return null;
      }
      IStructuredSelection sselection = (IStructuredSelection) _selection;
      if (sselection.size() != 1) {
        return null;
      }
      Object object = sselection.getFirstElement();
      if (object instanceof Task) {
        return (Task) object;
      }
      return null;
    }

    protected Resource getResource() {
      Task task = getTask();
      if (task == null) {
        return null;
      }
      return task.eResource();
    }

    protected String getKind() {
      Task task = getTask();
      if (task == null) {
        return null;
      }
      if (task.getKindValue() != null && task.getKindValue().trim().length() != 0) {
        return task.getKindValue().trim();
      }
      return null;
    }

    protected String getImplementation() {
      Task task = getTask();
      if (task == null) {
        return null;
      }
      if (task.getImplementationValue() != null && task.getImplementationValue().trim().length() != 0) {
        return task.getImplementationValue().trim();
      }
      return null;
    }

    @Override
    public boolean isEnabled() {
      if (getTask() == null) {
        return false;
      }
      if (getTask().eResource() == null) {
        return false;
      }
      if (getKind() == null) {
        return false;
      }
      if (getImplementation() == null) {
        return false;
      }
      return true;
    }

    public URI getResourceURI() {
      Resource resource = getResource();
      if (resource == null) {
        return null;
      }
      URI uri = resource.getURI();
      if (uri != null && resource.getResourceSet() != null) {
        URIConverter converter = resource.getResourceSet().getURIConverter();
        if (converter != null) {
          uri = converter.normalize(uri);
        }
      }
      return uri;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void run() {
      URI uri = getResourceURI();
      // Workspace
      try {
        if (uri.isPlatformResource()) {
          String path = uri.toPlatformString(true);
          IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path));
          IJavaProject project = JavaCore.create(resource.getProject());
          IType type = project.findType(getImplementation());
          if (type != null) {
            JavaUI.openInEditor(type);
          } else {
            MessageDialog.openError(_activeEditorPart.getSite().getShell(), EGFTaskUIMessages.OpenTaskImplementationMenuContributor_error_title, NLS.bind(EGFTaskUIMessages.OpenTaskImplementationMenuContributor_error_message, getImplementation()));
          }
        } else {
          // Fcore
          IPlatformFcore fcore = EGFCorePlugin.getPlatformFcore(getResource());
          Bundle fcoreBundle = fcore.getPlatformBundle().getBundle();
          if (fcoreBundle == null) {
            MessageDialog.openError(_activeEditorPart.getSite().getShell(), EGFTaskUIMessages.OpenTaskImplementationMenuContributor_error_title, NLS.bind(EGFTaskUIMessages.OpenTaskImplementationMenuContributor_error_message, getImplementation()));
            return;
          }
          // Class
          Class<?> clazz = fcoreBundle.loadClass(getImplementation());
          if (clazz == null) {
            MessageDialog.openError(_activeEditorPart.getSite().getShell(), EGFTaskUIMessages.OpenTaskImplementationMenuContributor_error_title, NLS.bind(EGFTaskUIMessages.OpenTaskImplementationMenuContributor_error_message, getImplementation()));
          }
          // Host Bundle
          Bundle hostBundle = BundleHelper.getBundle(clazz);
          if (hostBundle == null) {
            MessageDialog.openError(_activeEditorPart.getSite().getShell(), EGFTaskUIMessages.OpenTaskImplementationMenuContributor_error_title, NLS.bind(EGFTaskUIMessages.OpenTaskImplementationMenuContributor_error_message, getImplementation()));
            return;
          }
          // If source exists in the current bundle
          URL implementation = null;
          Enumeration<URL> urls = hostBundle.findEntries("/", clazz.getSimpleName() + ".java", true); //$NON-NLS-1$ //$NON-NLS-2$
          if (urls != null && urls.hasMoreElements()) {
            implementation = urls.nextElement();
          }
          // Looking for a source bundle
          if (implementation == null) {
            // Locate a source bundle if any
            String sourceBundle = null;
            // Try to locate a source bundle
            ITargetDefinition definition = PluginHelper.getWorkspaceTargetHandle();
            if (definition.isResolved() == false) {
              definition.resolve(null);
            }
            // Locate source bundle if any
            for (IResolvedBundle bundle : definition.getAllBundles()) {
              if (bundle.isSourceBundle() && bundle.getSourceTarget() != null) {
                if (bundle.getSourceTarget().getBundleId() == hostBundle.getBundleId()) {
                  sourceBundle = bundle.getSourceTarget().getSymbolicName();
                  break;
                }
              }
            }
            // retrieve bundle if any
            if (sourceBundle != null) {
              Bundle bundle = Platform.getBundle(sourceBundle);
              if (bundle != null) {
                urls = hostBundle.findEntries("/", clazz.getSimpleName() + ".java", true); //$NON-NLS-1$ //$NON-NLS-2$
                if (urls != null && urls.hasMoreElements()) {
                  implementation = urls.nextElement();
                }
              }
            }
          }
          if (implementation != null) {
            implementation = FileLocator.resolve(implementation);
            IFileStore fileStore = EFS.getLocalFileSystem().getStore(implementation.toURI());
            IDE.openEditorOnFileStore(_activeEditorPart.getSite().getPage(), fileStore);
          } else {
            // Fail to source lookup
            MessageDialog.openError(_activeEditorPart.getSite().getShell(), EGFTaskUIMessages.OpenTaskImplementationMenuContributor_error_title, NLS.bind(EGFTaskUIMessages.OpenTaskImplementationMenuContributor_error_message, getImplementation()));
          }
        }
      } catch (Throwable t) {
        ThrowableHandler.handleThrowable(EGFModelEditorPlugin.getPlugin().getSymbolicName(), t);
      }
    }
  }

  private OpenTaskImplementationAction _openAction;

  public OpenTaskImplementationMenuContributor() {
    _openAction = new OpenTaskImplementationAction();
  }

  @Override
  public void menuAboutToShow(IMenuManager menuManager) {
    if (((IStructuredSelection) _selection).size() == 1 && _openAction.getTask() != null && EGFTaskPlugin.KIND_JAVA.equals(_openAction.getKind())) {
      _openAction.setText(getText());
      _openAction.setEnabled(_openAction.isEnabled());
      menuManager.insertBefore(EGFCommonUIConstants.OPEN_MENU_GROUP, _openAction);
    }
  }

  protected String getText() {
    return EGFTaskUIMessages.TaskImplementationMenuContributor_openAction_label;
  }

}
