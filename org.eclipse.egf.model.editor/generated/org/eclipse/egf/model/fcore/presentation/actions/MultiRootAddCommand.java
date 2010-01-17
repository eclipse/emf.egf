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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandActionDelegate;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

/**
 * Multi-rooted resources support.
 * This command will add a root defined EObject to the resource.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class MultiRootAddCommand extends AddCommand implements CommandActionDelegate {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  private ItemProviderAdapter itemProvider = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  private Object value = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  private Object feature = null;

  /**
   * Constructor
   * 
   * @param domain
   *          the editing domain
   * @param list
   *          the list to add to
   * @param feature
   *          the feature to process
   * @param value
   *          the value to add
   *          <!-- begin-user-doc -->
   *          <!-- end-user-doc -->
   * @generated
   */
  public MultiRootAddCommand(EditingDomain domain_p, EList<?> list_p, Object feature_p, Object value_p) {
    this(domain_p, list_p, feature_p, value_p, CommandParameter.NO_INDEX);
  }

  /**
   * Constructor
   * 
   * @param domain
   *          the editing domain
   * @param list
   *          the list to add to
   * @param feature
   *          the feature to process
   * @param value
   *          the value to add
   * @param index
   *          the index
   *          <!-- begin-user-doc -->
   *          <!-- end-user-doc -->
   * @generated
   */
  public MultiRootAddCommand(EditingDomain domain_p, EList<?> list_p, Object feature_p, Object value_p, int index_p) {
    super(domain_p, list_p, value_p, index_p);
    feature = feature_p;
    value = value_p;
    if (getDomain() instanceof AdapterFactoryEditingDomain) {
      IEditingDomainItemProvider editingDomainItemProvider = (IEditingDomainItemProvider) ((AdapterFactoryEditingDomain) getDomain()).getAdapterFactory().adapt(value, IEditingDomainItemProvider.class);
      if (editingDomainItemProvider instanceof ItemProviderAdapter) {
        itemProvider = (ItemProviderAdapter) editingDomainItemProvider;
      }
    }
    if (itemProvider != null) {
      setLabel(itemProvider.getCreateChildText(null, feature, value, null));
      setDescription(itemProvider.getCreateChildToolTipText(null, feature, value, null));
    }
  }

  /**
   * @see org.eclipse.emf.edit.command.CommandActionDelegate#getImage()
   *      <!-- begin-user-doc -->
   *      <!-- end-user-doc -->
   * @generated
   */
  public Object getImage() {
    return itemProvider != null ? itemProvider.getCreateChildImage(null, feature, value, null) : null;
  }

  /**
   * @see org.eclipse.emf.edit.command.CommandActionDelegate#getText()
   *      <!-- begin-user-doc -->
   *      <!-- end-user-doc -->
   * @generated
   */
  public String getText() {
    return itemProvider != null ? itemProvider.getCreateChildText(null, feature, value, null) : null;
  }

  /**
   * @see org.eclipse.emf.edit.command.CommandActionDelegate#getToolTipText()
   *      <!-- begin-user-doc -->
   *      <!-- end-user-doc -->
   * @generated
   */
  public String getToolTipText() {
    return itemProvider != null ? itemProvider.getCreateChildToolTipText(null, feature, value, null) : null;
  }

}
