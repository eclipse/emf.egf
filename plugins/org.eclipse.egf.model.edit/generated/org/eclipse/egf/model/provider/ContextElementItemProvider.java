/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.model.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.core.data.helper.DataHelper;
import org.eclipse.egf.model.ContextElement;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.edit.command.AbstractModelElementCommand;
import org.eclipse.egf.model.edit.command.SetModelElementCommand;
import org.eclipse.egf.model.edit.command.plugin.context.SetContextElementWrapperCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;


/**
 * This is the item provider adapter for a {@link org.eclipse.egf.model.ContextElement} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class ContextElementItemProvider extends NamedModelElementWithIdItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider,
    ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
  /**
   * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public ContextElementItemProvider(AdapterFactory adapterFactory_p) {
    super(adapterFactory_p);
  }

  /**
   * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createSetCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject,
   *      org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
   */
  @Override
  protected Command createSetCommand(EditingDomain domain_p, EObject owner_p, EStructuralFeature feature_p, Object value_p) {
    AbstractModelElementCommand result = new SetModelElementCommand(domain_p, owner_p, feature_p, value_p);
    result.setPluginChangeCommand(new SetContextElementWrapperCommand(domain_p, owner_p, feature_p, value_p));
    return result;
  }

  /**
   * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#hasChildren(java.lang.Object)
   */
  @Override
  public boolean hasChildren(Object object_p) {
    // Do not display children of context element.
    return false;
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (itemPropertyDescriptors == null) {
      super.getPropertyDescriptors(object);

      addReadableValuePropertyDescriptor(object);
      addKeyPropertyDescriptor(object);
      addContractReferenceIdPropertyDescriptor(object);
      addContextTypePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Readable Value feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addReadableValuePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ContextElement_readableValue_feature"), //$NON-NLS-1$
         getString("_UI_PropertyDescriptor_description", "_UI_ContextElement_readableValue_feature", "_UI_ContextElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
         ModelPackage.Literals.CONTEXT_ELEMENT__READABLE_VALUE,
         false,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Key feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addKeyPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ContextElement_key_feature"), //$NON-NLS-1$
         getString("_UI_PropertyDescriptor_description", "_UI_ContextElement_key_feature", "_UI_ContextElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
         ModelPackage.Literals.CONTEXT_ELEMENT__KEY,
         false,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Contract Reference Id feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addContractReferenceIdPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ContextElement_contractReferenceId_feature"), //$NON-NLS-1$
         getString("_UI_PropertyDescriptor_description", "_UI_ContextElement_contractReferenceId_feature", "_UI_ContextElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
         ModelPackage.Literals.CONTEXT_ELEMENT__CONTRACT_REFERENCE_ID,
         false,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         new String[] {
          "org.eclipse.ui.views.properties.expert" //$NON-NLS-1$
         }));
  }

  /**
   * This adds a property descriptor for the Context Type feature. <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  protected void addContextTypePropertyDescriptor(Object object) {
    ItemPropertyDescriptor contextTypeItemPropertyDescriptor =
                                                               new ItemPropertyDescriptor(
                                                                                          ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                                                          getResourceLocator(),
                                                                                          getString("_UI_ContextElement_contextType_feature"), getString( //$NON-NLS-1$
                                                                                                                                                         "_UI_PropertyDescriptor_description", //$NON-NLS-1$
                                                                                                                                                         "_UI_ContextElement_contextType_feature", "_UI_ContextElement_type"), ModelPackage.Literals.CONTEXT_ELEMENT__CONTEXT_TYPE, //$NON-NLS-1$ //$NON-NLS-2$
                                                                                          false, false, false, null, null, null) {

                                                                 /**
                                                                   * @see org.eclipse.emf.edit.provider.ItemPropertyDescriptor#canSetProperty(java.lang.Object)
                                                                   */
                                                                 @Override
                                                                 public boolean canSetProperty(Object object_p) {
                                                                   boolean canSetProperty = false;
                                                                   if (isSettable) {
                                                                     EditingDomain editingDomain = getEditingDomain(object_p);
                                                                     canSetProperty = (null != editingDomain) ? !editingDomain.isReadOnly(null) : true;
                                                                   }
                                                                   return canSetProperty;
                                                                 }

                                                                 /**
                                                                   * @see org.eclipse.emf.edit.provider.ItemPropertyDescriptor#getPropertyValue(java.lang.Object)
                                                                   */
                                                                 @Override
                                                                 public Object getPropertyValue(Object object_p) {
                                                                   ContextElement contextElement = (ContextElement) object_p;
                                                                   // Get the context type.
                                                                   return DataHelper.getContextType(contextElement);
                                                                 }
                                                               };

    itemPropertyDescriptors.add(contextTypeItemPropertyDescriptor);
  }

  /**
   * This returns ContextElement.gif.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/ContextElement")); //$NON-NLS-1$
  }

  /**
   * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public String getText(Object object) {
    String label = DataHelper.getLabel((ContextElement) object);
    return ICommonConstants.EMPTY_STRING + label;
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification) {
    updateChildren(notification);

    switch (notification.getFeatureID(ContextElement.class)) {
      case ModelPackage.CONTEXT_ELEMENT__CONTRACT_ELEMENT_REFERENCE:
      case ModelPackage.CONTEXT_ELEMENT__VALUE:
      case ModelPackage.CONTEXT_ELEMENT__READABLE_VALUE:
      case ModelPackage.CONTEXT_ELEMENT__KEY:
      case ModelPackage.CONTEXT_ELEMENT__CONTRACT_REFERENCE_ID:
      case ModelPackage.CONTEXT_ELEMENT__PLUGIN_ID:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
    super.collectNewChildDescriptors(newChildDescriptors, object);
  }

}
