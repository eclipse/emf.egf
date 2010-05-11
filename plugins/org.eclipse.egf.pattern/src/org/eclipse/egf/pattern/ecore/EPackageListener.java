/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ecore;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.pattern.Activator;
import org.eclipse.egf.pattern.ecore.EPackageHelper.RegistrationException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;

/**
 * TODO: fix issue when a XXXPackage class is removed.
 * 
 * @author Thomas Guiu
 * 
 */
public class EPackageListener implements IResourceChangeListener {

  private static final String RESOURCE_SUFFIX = "Package.java"; //$NON-NLS-1$

  private static final class ResourceDeltaVisitor implements IResourceDeltaVisitor {
    public boolean visit(IResourceDelta delta) throws CoreException {
      IResource resource = delta.getResource();
      if (resource.getType() == IResource.FILE && resource.getName().endsWith(RESOURCE_SUFFIX)) {
        IProject project = resource.getProject();
        ICompilationUnit unit = (ICompilationUnit) JavaCore.create(resource);
        IType type = unit.findPrimaryType();
        if (type == null || !type.getField(EPackageHelper.INSTANCE_FIELD_NAME).exists())
          return false;

        String fullyQualifiedName = type.getFullyQualifiedName();
        try {
          switch (delta.getKind()) {
          case IResourceDelta.ADDED:
          case IResourceDelta.ADDED_PHANTOM:
          case IResourceDelta.CHANGED:
            EPackageHelper.registerPackage(project, fullyQualifiedName);
            break;
          case IResourceDelta.REMOVED:
          case IResourceDelta.REMOVED_PHANTOM:
            EPackageHelper.unregisterPackage(project, fullyQualifiedName);
            break;
          }
        } catch (RegistrationException e) {
          Activator.getDefault().logWarning(e);
        }
        return false;
      }
      return true;
    }
  }

  public void resourceChanged(IResourceChangeEvent event) {
    IResourceDelta delta = event.getDelta();
    if (delta == null)
      return;
    try {
      delta.accept(new ResourceDeltaVisitor());
    } catch (CoreException e) {
      Activator.getDefault().logWarning(e);
    }
  }

}
