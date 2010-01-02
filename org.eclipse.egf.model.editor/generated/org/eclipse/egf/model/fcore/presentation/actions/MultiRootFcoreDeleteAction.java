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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.DeleteAction;

/**
 * Multi-rooted resources support.
 * This action allows the user to delete a root from the resource.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class MultiRootFcoreDeleteAction extends DeleteAction {

  /**
   * Constructor
   * 
   * @param domain
   *          the editing domain
   * @param removeAllReferences
   *          removeAllReferences
   *          <!-- begin-user-doc -->
   *          <!-- end-user-doc -->
   * @generated
   */
  public MultiRootFcoreDeleteAction(EditingDomain domain, boolean removeAllReferences) {
    super(domain, removeAllReferences);
  }

  /**
   * Constructor
   * 
   * @param domain
   *          the editing domain
   *          <!-- begin-user-doc -->
   *          <!-- end-user-doc -->
   * @generated
   */
  public MultiRootFcoreDeleteAction(EditingDomain domain) {
    super(domain, false);
  }

  /**
   * Constructor
   * 
   * @param removeAllReferences
   *          the editing domain
   *          <!-- begin-user-doc -->
   *          <!-- end-user-doc -->
   * @generated
   */
  public MultiRootFcoreDeleteAction(boolean removeAllReferences) {
    super(removeAllReferences);
  }

  /**
   * Constructor
   * 
   * @param domain
   *          the editing domain
   *          <!-- begin-user-doc -->
   *          <!-- end-user-doc -->
   * @generated
   */
  public MultiRootFcoreDeleteAction() {
    super();
  }

  /**
   * @see org.eclipse.emf.edit.ui.action.CommandActionHandler#createCommand(java.util.Collection)
   *      <!-- begin-user-doc -->
   *      <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Command createCommand(Collection<?> selection) {
    if (selection == null || selection.isEmpty()) {
      return UnexecutableCommand.INSTANCE;
    }
    List<Object> otherList = new ArrayList<Object>();
    List<EObject> rootList = new ArrayList<EObject>();
    Command cmd = null;
    // Process Current Selection
    // 
    Iterator<?> iter = selection.iterator();
    while (iter.hasNext()) {
      Object next = iter.next();
      if (next instanceof EObject == false) {
        otherList.add(next);
        continue;
      }
      EObject eObject = (EObject) next;
      // Library should have a resource as parent domain
      //
      if (getEditingDomain().getParent(eObject) instanceof Resource) {
        if (eObject instanceof FactoryComponent || eObject instanceof Task) {
          rootList.add(eObject);
          continue;
        }
      }
      // Default
      //
      otherList.add(eObject);
    }
    // Build rootList Command
    //
    if (rootList.isEmpty() == false) {
      EObject eObject = rootList.get(0);
      if (eObject.eResource() != null) {
        cmd = new MultiRootRemoveCommand(domain, eObject.eResource().getContents(), rootList);
      }
    }
    // Build otherList Command
    //		
    if (otherList.isEmpty() == false) {
      if (cmd == null) {
        cmd = super.createCommand(otherList);
      } else {
        cmd = cmd.chain(super.createCommand(otherList));
      }
    }
    return cmd;
  }

}
