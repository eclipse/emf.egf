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

import org.eclipse.emf.ecore.resource.Resource;
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
  private ItemProviderAdapter _itemProvider = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  private Object _value = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  private Object _feature = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  private Resource _resource = null;

  /**
   * Constructor
   * 
   * @param domain
   *          the editing domain
   * @param list
   *          the list to add to
   * @param _feature
   *          the feature to process
   * @param _value
   *          the value to add
   *          <!-- begin-user-doc -->
   *          <!-- end-user-doc -->
   * @generated
   */
  public MultiRootAddCommand(EditingDomain domain, Resource resource, Object feature, Object value) {
    this(domain, resource, feature, value, CommandParameter.NO_INDEX);
  }

  /**
   * Constructor
   * 
   * @param domain
   *          the editing domain
   * @param list
   *          the list to add to
   * @param _feature
   *          the feature to process
   * @param _value
   *          the value to add
   * @param index
   *          the index
   *          <!-- begin-user-doc -->
   *          <!-- end-user-doc -->
   * @generated
   */
  public MultiRootAddCommand(EditingDomain domain, Resource resource, Object feature, Object value, int index) {
    super(domain, resource.getContents(), value, index);
    _feature = feature;
    _value = value;
    _resource = resource;
    if (getDomain() instanceof AdapterFactoryEditingDomain) {
      IEditingDomainItemProvider editingDomainItemProvider = (IEditingDomainItemProvider) ((AdapterFactoryEditingDomain) getDomain()).getAdapterFactory().adapt(_value, IEditingDomainItemProvider.class);
      if (editingDomainItemProvider instanceof ItemProviderAdapter) {
        _itemProvider = (ItemProviderAdapter) editingDomainItemProvider;
      }
    }
    if (_itemProvider != null) {
      setLabel(_itemProvider.getCreateChildText(null, _feature, _value, null));
      setDescription(_itemProvider.getCreateChildToolTipText(null, _feature, _value, null));
    }
  }

  @Override
  protected boolean prepare() {
    if (domain.isReadOnly(_resource)) {
      return false;
    }
    return super.prepare();
  }

  /**
   * @see org.eclipse.emf.edit.command.CommandActionDelegate#getImage()
   *      <!-- begin-user-doc -->
   *      <!-- end-user-doc -->
   * @generated
   */
  public Object getImage() {
    return _itemProvider != null ? _itemProvider.getCreateChildImage(null, _feature, _value, null) : null;
  }

  /**
   * @see org.eclipse.emf.edit.command.CommandActionDelegate#getText()
   *      <!-- begin-user-doc -->
   *      <!-- end-user-doc -->
   * @generated
   */
  public String getText() {
    return _itemProvider != null ? _itemProvider.getCreateChildText(null, _feature, _value, null) : null;
  }

  /**
   * @see org.eclipse.emf.edit.command.CommandActionDelegate#getToolTipText()
   *      <!-- begin-user-doc -->
   *      <!-- end-user-doc -->
   * @generated
   */
  public String getToolTipText() {
    return _itemProvider != null ? _itemProvider.getCreateChildToolTipText(null, _feature, _value, null) : null;
  }

}
