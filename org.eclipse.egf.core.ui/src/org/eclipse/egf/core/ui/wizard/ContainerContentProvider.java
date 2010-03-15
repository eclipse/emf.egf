/**
 * Copyright (c) 2000, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 */
package org.eclipse.egf.core.ui.wizard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.helper.JavaHelper;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * Provides content for a tree viewer that shows only containers.
 */
public class ContainerContentProvider implements ITreeContentProvider {

  private Map<IProject, List<IFolder>> _sourceOrOutputFolders = new HashMap<IProject, List<IFolder>>();

  /**
   * Creates a new ContainerContentProvider.
   */
  public ContainerContentProvider() {
  }

  /**
   * The visual part that is using this content provider is about
   * to be disposed. Deallocate all allocated SWT resources.
   */
  public void dispose() {
  }

  /*
   * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
   */
  public Object[] getChildren(Object element) {
    if (element instanceof IWorkspace) {
      // check if closed projects should be shown
      List<IProject> accessibleProjects = new ArrayList<IProject>();
      for (IProject project : ((IWorkspace) element).getRoot().getProjects()) {
        if (project.isOpen()) {
          try {
            _sourceOrOutputFolders.put(project, JavaHelper.getSourceAndOutputFolders(JavaCore.create(project)));
            accessibleProjects.add(project);
          } catch (CoreException ce) {
            EGFCoreUIPlugin.getDefault().logError(ce);
          }
        }
      }
      return accessibleProjects.toArray();
    } else if (element instanceof IContainer) {
      IContainer container = (IContainer) element;
      List<IFolder> folders = _sourceOrOutputFolders.get(container.getProject());
      if (container.isAccessible() && belongToFolders(folders, container) == false) {
        try {
          List<IResource> children = new ArrayList<IResource>();
          for (IResource member : container.members()) {
            if (member.getType() != IResource.FILE && belongToFolders(folders, member) == false) {
              children.add(member);
            }
          }
          return children.toArray();
        } catch (CoreException e) {
          // this should never happen because we call #isAccessible before invoking #members
        }
      }
    }
    return new Object[0];
  }

  private boolean belongToFolders(List<IFolder> folders, IResource resource) {
    if (folders == null || folders.size() == 0) {
      return false;
    }
    for (IFolder folder : folders) {
      if (resource.getFullPath().toOSString().startsWith(folder.getFullPath().toOSString())) {
        return true;
      }
    }
    return false;
  }

  /*
   * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
   */
  public Object[] getElements(Object element) {
    return getChildren(element);
  }

  /*
   * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
   */
  public Object getParent(Object element) {
    if (element instanceof IResource) {
      return ((IResource) element).getParent();
    }
    return null;
  }

  /*
   * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
   */
  public boolean hasChildren(Object element) {
    return getChildren(element).length > 0;
  }

  /*
   * @see org.eclipse.jface.viewers.IContentProvider#inputChanged
   */
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
  }

}
