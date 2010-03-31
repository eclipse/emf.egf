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
import org.eclipse.egf.core.ui.contributor.DefaultPropertyEditorContributor;
import org.eclipse.egf.core.ui.dialogs.FilteredTypeSelectionDialog;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jdt.core.IType;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class AbstractTypeEditorContributor extends DefaultPropertyEditorContributor {

  public CellEditor createPropertyEditor(final Composite composite, Object object, IItemPropertyDescriptor descriptor) {

    final String value = getValue(object);
    final Class<?> type = getType(object);

    final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(((EObject) object).eResource().getURI().segment(1));
    if (project == null)
      throw new IllegalStateException();

    return new ExtendedDialogCellEditor(composite, getLabelProvider(object, descriptor)) {
      @Override
      protected Object openDialogBox(Control cellEditorWindow) {
        FilteredTypeSelectionDialog dialog = new FilteredTypeSelectionDialog(composite.getShell(), project, type, value, null, false);
        if (dialog.open() != IDialogConstants.OK_ID) {
          return null;
        }
        Object[] innerResult = dialog.getResult();
        if (innerResult != null && innerResult.length > 0 && innerResult[0] instanceof IType) {
          return ((IType) innerResult[0]).getFullyQualifiedName();
        }
        return value;
      }
    };
  }

  protected abstract Class<?> getType(Object object);

  protected abstract String getValue(Object object);

}
