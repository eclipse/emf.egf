/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.pattern.Activator;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.ecore.EPackageHelper.RegistrationException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jdt.core.search.TypeReferenceMatch;
import org.eclipse.jdt.internal.core.search.JavaSearchParticipant;

/**
 * This class aims at filling the ecore model registry with model from workspace
 * projects.
 * 
 * @author Thomas Guiu
 * 
 */
public class RegistryReader {
  public void load() {
    List<IJavaProject> projects = new ArrayList<IJavaProject>();
    for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
      try {
        if (project.isAccessible() && project.hasNature(JavaCore.NATURE_ID)) {
          projects.add(JavaCore.create(project));
        }
      } catch (CoreException e) {
        Activator.getDefault().logError(e);
      }
    }
    if (projects.isEmpty())
      return;
    try {
      IType ePackageType = null;
      for (IJavaProject javaProject : projects) {
        ePackageType = javaProject.findType("org.eclipse.emf.ecore.EPackage"); //$NON-NLS-1$
        if (ePackageType != null) {
          break;
        }
      }
      if (ePackageType == null) {
        return;
      }
      IJavaSearchScope scope = SearchEngine.createJavaSearchScope(projects.toArray(new IJavaProject[projects.size()]), IJavaSearchScope.SOURCES);
      SearchPattern pattern = SearchPattern.createPattern(ePackageType, IJavaSearchConstants.IMPLEMENTORS);
      SearchRequestor requestor = new SearchRequestor() {

        @Override
        public void acceptSearchMatch(SearchMatch match) throws CoreException {
          if (match instanceof TypeReferenceMatch) {
            TypeReferenceMatch refMatch = (TypeReferenceMatch) match;
            IType type = (IType) refMatch.getElement();
            try {
              EPackageHelper.registerPackage(type.getJavaProject().getProject(), type.getFullyQualifiedName());
            } catch (RegistrationException e) {
              Activator.getDefault().logError(Messages.registration_error1, e);
            }
          }
        }
      };
      new SearchEngine().search(pattern, new SearchParticipant[] { new JavaSearchParticipant() }, scope, requestor, null);
    } catch (Exception e) {
      Activator.getDefault().logError(Messages.registration_error1, e);
    }
  }

}
