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

package org.eclipse.egf.model.editor.contributions;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.contributor.DefaultPropertyEditorContributor;
import org.eclipse.egf.core.ui.dialogs.TypeSelectionDialog;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.types.TypeClass;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SelectionDialog;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TypeClassEditorContributor extends DefaultPropertyEditorContributor {

  public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
    if (checkFeature(object, descriptor, TypesPackage.Literals.TYPE_ABSTRACT_CLASS__VALUE) && object instanceof TypeClass && ((TypeClass) object).eContainer() instanceof Contract) {
      return true;
    }
    return false;
  }

  public CellEditor createPropertyEditor(final Composite composite, Object object, IItemPropertyDescriptor descriptor) {

    IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(((EObject) object).eResource().getURI().segment(1));
    if (project == null) {
      throw new IllegalStateException();
    }
    // IProject should be a JavaProject
    final IJavaElement[] javaProject = new IJavaElement[1];
    try {
      if (project.isAccessible() && project.hasNature(JavaCore.NATURE_ID)) {
        javaProject[0] = JavaCore.create(project);
      }
    } catch (CoreException e) {
      EGFCoreUIPlugin.getDefault().logError(e);
    }

    if (javaProject[0] == null) {
      return null;
    }

    return new ExtendedDialogCellEditor(composite, getLabelProvider(object, descriptor)) {
      @Override
      protected Object openDialogBox(Control cellEditorWindow) {
        SelectionDialog dialog = new TypeSelectionDialog(composite.getShell(), false, PlatformUI.getWorkbench().getProgressService(), SearchEngine.createJavaSearchScope(javaProject), IJavaSearchConstants.TYPE);
        if (dialog.open() != IDialogConstants.OK_ID) {
          return null;
        }
        Object[] innerResult = dialog.getResult();
        if (innerResult != null && innerResult.length > 0 && innerResult[0] instanceof IType) {
          return ((IType) innerResult[0]).getFullyQualifiedName();
        }
        return null;
      }
    };
  }

}
