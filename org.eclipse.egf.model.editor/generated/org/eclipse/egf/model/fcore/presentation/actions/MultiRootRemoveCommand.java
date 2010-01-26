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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.CommandActionDelegate;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

/**
 * The extended library example supports multi-rooted resources
 * and therefore this command will remove a library from the resource..
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class MultiRootRemoveCommand extends RemoveCommand implements CommandActionDelegate {

  /**
   * Attribute for the adapter factory
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  private IItemLabelProvider _labelProvider = null;

  /**
   * Constructor
   * 
   * @param domain
   *          the editing domain
   * @param list
   *          the list to modify
   * @param collection
   *          the objects to be removed
   *          <!-- begin-user-doc -->
   *          <!-- end-user-doc -->
   * @generated
   */
  public MultiRootRemoveCommand(EditingDomain domain, EList<?> list, Collection<?> collection) {
    super(domain, list, collection);
    if (getDomain() instanceof AdapterFactoryEditingDomain) {
      _labelProvider = (IItemLabelProvider) ((AdapterFactoryEditingDomain) getDomain()).getAdapterFactory().adapt(getCollection().toArray()[0], IItemLabelProvider.class);
    }
    setLabel(LABEL);
    setDescription(DESCRIPTION);
  }

  /**
   * @see org.eclipse.emf.edit.command.CommandActionDelegate#getImage()
   *      <!-- begin-user-doc -->
   *      <!-- end-user-doc -->
   * @generated
   */
  public Object getImage() {
    return this._labelProvider != null ? this._labelProvider.getImage(getCollection().toArray()[0]) : null;
  }

  /**
   * @see org.eclipse.emf.edit.command.CommandActionDelegate#getText()
   *      <!-- begin-user-doc -->
   *      <!-- end-user-doc -->
   * @generated
   */
  public String getText() {
    return this._labelProvider != null ? this._labelProvider.getText(getCollection().toArray()[0]) : null;
  }

  /**
   * @see org.eclipse.emf.edit.command.CommandActionDelegate#getToolTipText()
   *      <!-- begin-user-doc -->
   *      <!-- end-user-doc -->
   * @generated
   */
  public String getToolTipText() {
    return getText();
  }

}
