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
package org.eclipse.egf.model.edit.ui.provider;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.egf.core.ui.dialogs.TypeSelectionDialog;
import org.eclipse.egf.model.types.TypeAbstractClass;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jdt.core.IType;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FcorePropertyDescriptor extends PropertyDescriptor {

  public FcorePropertyDescriptor(Object object, IItemPropertyDescriptor itemPropertyDescriptor) {
    super(object, itemPropertyDescriptor);
  }

  /**
   * This returns the cell editor that will be used to edit the value of this property.
   * This default implementation determines the type of cell editor from the nature of the
   * structural feature.
   */
  @Override
  public CellEditor createPropertyEditor(final Composite composite) {

    if (itemPropertyDescriptor.canSetProperty(object) == false) {
      return null;
    }

    if (object instanceof TypeAbstractClass<?> == false) {
      return super.createPropertyEditor(composite);
    }

    CellEditor result = null;

    // Type should be defined
    final TypeAbstractClass<?> typeClass = (TypeAbstractClass<?>) object;
    if (typeClass.getType() == null) {
      return null;
    }

    // IProject should exist
    final IProject[] projects = new IProject[1];
    projects[0] = ResourcesPlugin.getWorkspace().getRoot().getProject(typeClass.eResource().getURI().segment(1));
    if (projects[0] == null) {
      return null;
    }

    final ILabelProvider editLabelProvider = getEditLabelProvider();
    result = new ExtendedDialogCellEditor(composite, editLabelProvider) {
      @Override
      protected Object openDialogBox(Control cellEditorWindow) {
        TypeSelectionDialog dialog = new TypeSelectionDialog(composite.getShell(), projects[0], typeClass.getType(), typeClass.getValue(), false);
        dialog.open();
        Object[] innerResult = dialog.getResult();
        if (innerResult != null && innerResult.length > 0 && innerResult[0] instanceof IType) {
          return ((IType) innerResult[0]).getFullyQualifiedName();
        }
        return typeClass.getValue();
      }
    };

    return result;
  }
}
