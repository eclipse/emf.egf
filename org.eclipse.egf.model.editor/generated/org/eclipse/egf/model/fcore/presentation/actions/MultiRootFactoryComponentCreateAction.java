/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 * Thales Corporate Services S.A.S
 */
package org.eclipse.egf.model.fcore.presentation.actions;

import java.util.Collection;

import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.StaticSelectionCommandAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;

/**
 * Multi-rooted resources support.
 * This action allows the user to create a FactoryComponent
 * root on the resource.
 */
public class MultiRootFactoryComponentCreateAction extends StaticSelectionCommandAction {

  /**
   * This constructs an instance of an action that creates a FactoryComponent
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public MultiRootFactoryComponentCreateAction(IEditorPart editorPart, ISelection selection) {
    super(editorPart);
    configureAction(selection);
  }

  /*
   * @see
   * org.eclipse.emf.edit.ui.action.StaticSelectionCommandAction#createActionCommand(org.eclipse
   * .emf.edit.domain.EditingDomain,
   * java.util.Collection)
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected Command createActionCommand(EditingDomain inputEditingDomain, Collection<?> collection) {
    if (collection != null && collection.size() == 1) {
      for (Object object : collection) {
        if (object instanceof Resource == false) {
          break;
        }
        return new MultiRootAddCommand(inputEditingDomain, (Resource) object, FcorePackage.Literals.FACTORY_COMPONENT, FcoreFactory.eINSTANCE.createFactoryComponent());
      }
    }
    return null;
  }

}
