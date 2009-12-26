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
package org.eclipse.egf.common.helper;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.common.EGFCommonPlugin;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TypeClassHelper {

  private TypeClassHelper() {
    // Prevent Instantiation
  }

  public static Collection<String> getClassHierarchyAsString(final IProject project, final Class<?> clazz) {

    final Collection<String> result = new UniqueEList<String>();

    // Usual Tests
    if (project == null || clazz == null) {
      return result;
    }
    // IProject should be a JavaProject
    IJavaProject javaProject = null;
    try {
      if (project.isAccessible() && project.hasNature(JavaCore.NATURE_ID)) {
        javaProject = JavaCore.create(project);
      }
    } catch (CoreException e) {
      EGFCommonPlugin.getDefault().logError(e);
    }
    if (javaProject == null) {
      return result;
    }
    try {
      // Retrieve IType
      IType classType = javaProject.findType(clazz.getName());
      if (classType == null) {
        return result;
      }
      // Current
      // public, non interface and non abstract are processed
      if (Flags.isPublic(classType.getFlags()) && Flags.isInterface(classType.getFlags()) == false && Flags.isAbstract(classType.getFlags()) == false) {
        String bundleId = BundleHelper.getBundleId(classType.getJavaProject().getProject());
        // type should be contained in a bundle
        if (bundleId != null) {
          result.add(classType.getFullyQualifiedName());
        }
      }
      // Hierarchy
      ITypeHierarchy typeHierarchy = classType.newTypeHierarchy(javaProject, new NullProgressMonitor());
      if (typeHierarchy == null) {
        return result;
      }
      for (IType type : typeHierarchy.getAllSubtypes(classType)) {
        // public, non interface and non abstract are processed
        if (Flags.isPublic(type.getFlags()) && Flags.isInterface(type.getFlags()) == false && Flags.isAbstract(type.getFlags()) == false) {
          String bundleId = BundleHelper.getBundleId(type.getJavaProject().getProject());
          // type should be contained in a bundle
          if (bundleId != null) {
            result.add(type.getFullyQualifiedName());
          }
        }
      }
    } catch (Exception e) {
      EGFCommonPlugin.getDefault().logError(e);
    } finally {
      try {
        javaProject.close();
      } catch (JavaModelException jme) {
        EGFCommonPlugin.getDefault().logError(jme);
      }
    }
    return result;
  }

}
