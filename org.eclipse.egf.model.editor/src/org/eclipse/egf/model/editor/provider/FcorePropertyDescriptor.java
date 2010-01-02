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
package org.eclipse.egf.model.editor.provider;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.egf.core.ui.dialogs.TypeSelectionDialog;
import org.eclipse.egf.fprod.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.editor.EGFModelsEditorPlugin;
import org.eclipse.egf.model.editor.dialogs.ActivitySelectionDialog;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.egf.model.types.TypeAbstractClass;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
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

    CellEditor result = null;

    if (object instanceof TypeAbstractClass<?> || object instanceof Task) {

      // Data Holder
      final Class<?>[] clazzes = new Class<?>[1];
      final String[] values = new String[1];

      // Switch
      if (object instanceof TypeAbstractClass<?>) {
        TypeAbstractClass<?> typeAbstractClass = (TypeAbstractClass<?>) object;
        // Type should be defined
        if (typeAbstractClass.getType() == null) {
          return null;
        }
        clazzes[0] = typeAbstractClass.getType();
        values[0] = typeAbstractClass.getValue();
      } else if (object instanceof Task) {
        Task task = (Task) object;
        clazzes[0] = ITaskProduction.class;
        values[0] = task.getValue();
      } else {
        return null;
      }

      // IProject should exist
      final IProject[] projects = new IProject[1];
      projects[0] = ResourcesPlugin.getWorkspace().getRoot().getProject(((EObject) object).eResource().getURI().segment(1));
      if (projects[0] == null) {
        return null;
      }

      final ILabelProvider editLabelProvider = getEditLabelProvider();
      result = new ExtendedDialogCellEditor(composite, editLabelProvider) {
        @Override
        protected Object openDialogBox(Control cellEditorWindow) {
          TypeSelectionDialog dialog = new TypeSelectionDialog(composite.getShell(), projects[0], clazzes[0], values[0], false);
          dialog.open();
          Object[] innerResult = dialog.getResult();
          if (innerResult != null && innerResult.length > 0 && innerResult[0] instanceof IType) {
            return ((IType) innerResult[0]).getFullyQualifiedName();
          }
          return values[0];
        }
      };

      return result;

    } else if (object instanceof Invocation<?>) {

      Invocation<?> invocation = (Invocation<?>) object;
      EGenericType genericType = invocation.eClass().getEGenericSuperTypes().get(0).getETypeArguments().get(0);

      // Data Holder
      final Class<?>[] clazzes = new Class<?>[] { genericType.getEClassifier().getInstanceClass() };
      final Activity[] activities = new Activity[] { invocation.getActivity() };

      final ILabelProvider editLabelProvider = getEditLabelProvider();
      result = new ExtendedDialogCellEditor(composite, editLabelProvider) {
        @Override
        protected Object openDialogBox(Control cellEditorWindow) {
          ActivitySelectionDialog dialog = new ActivitySelectionDialog(EGFModelsEditorPlugin.getActiveWorkbenchShell(), clazzes[0], activities[0], false);
          dialog.open();
          Object[] innerResult = dialog.getResult();
          if (innerResult != null && innerResult.length > 0 && innerResult[0] instanceof Activity) {
            return innerResult[0];
          }
          return activities[0];
        }
      };

      return result;

    }

    return super.createPropertyEditor(composite);

  }
}
