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
package org.eclipse.egf.model.helper;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.model.EGFModelsPlugin;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.jdt.core.Flags;
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
import org.eclipse.jdt.core.search.TypeDeclarationMatch;
import org.eclipse.jdt.internal.core.search.JavaSearchParticipant;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TypeClassHelper {

  private TypeClassHelper() {
    // Prevent Instantiation
  }

  public static Collection<String> getClassHierarchyAsString(IProject project, Class<?> clazz) {
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
      EGFModelsPlugin.getPlugin().logError(e);
    }
    if (javaProject == null) {
      return result;
    }
    try {
      IType classType = javaProject.findType(clazz.getName());
      if (classType == null) {
        return result;
      }
      IJavaSearchScope scope = SearchEngine.createHierarchyScope(classType);
      SearchPattern pattern = SearchPattern.createPattern(classType, IJavaSearchConstants.IMPLEMENTORS);
      SearchRequestor requestor = new SearchRequestor() {
        @Override
        public void acceptSearchMatch(SearchMatch match) throws CoreException {
          if (match instanceof TypeDeclarationMatch) {
            TypeDeclarationMatch typeMatch = (TypeDeclarationMatch) match;
            IType type = (IType) typeMatch.getElement();
            // Binary Types, non interface and non abstract are processed
            if (type.getClassFile() != null && Flags.isInterface(type.getFlags()) == false && Flags.isAbstract(type.getFlags()) == false) {
              String bundleId = BundleHelper.getBundleId(type.getJavaProject().getProject());
              // type should be contained in a bundle
              if (bundleId != null) {
                result.add(type.getFullyQualifiedName());
              }
            }
          }
        }
      };
      new SearchEngine().search(pattern, new SearchParticipant[] { new JavaSearchParticipant() }, scope, requestor, new NullProgressMonitor());
    } catch (Exception e) {
      EGFModelsPlugin.getPlugin().logError(e);
    }
    return result;
  }

}
