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

import org.eclipse.egf.model.AbstractFactoryComponentFactory;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.edit.command.AbstractModelElementCommand;
import org.eclipse.egf.model.edit.command.SetModelElementCommand;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
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
 * This is the item provider adapter for a {@link org.eclipse.egf.model.AbstractFactoryComponentFactory} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class AbstractFactoryComponentFactoryItemProvider extends NamedModelElementWithIdItemProvider implements IEditingDomainItemProvider,
    IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
  /**
   * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public AbstractFactoryComponentFactoryItemProvider(AdapterFactory adapterFactory_p) {
    super(adapterFactory_p);
  }

  /**
   * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createAddCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject,
   *      org.eclipse.emf.ecore.EStructuralFeature, java.util.Collection, int)
   */
  @Override
  protected Command createAddCommand(EditingDomain domain_p, EObject owner_p, EStructuralFeature feature_p, Collection<?> collection_p, int index_p) {
    Command result = null;
    // Get the feature id to switch on the right stuff.
    int featureId = feature_p.getFeatureID();
    AbstractModelElementCommand command = null;
    switch (featureId) {
      case ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT:
        // Get the first and only one element of the given collection.
        Object value = getFirstElement(collection_p);
        // Create a 'add' command.
        command = new SetModelElementCommand(domain_p, owner_p, feature_p, value);
        command.setPluginChangeCommand(getAddContextWrapperCommand(domain_p, owner_p, feature_p, value));
      break;
    }
    // Set the resulting command
    result = command;
    return result;
  }

  /**
   * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createSetCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject,
   *      org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
   */
  @Override
  protected Command createSetCommand(EditingDomain domain_p, EObject owner_p, EStructuralFeature feature_p, Object value_p) {
    Command result = null;
    // If result is null, proceed here.
    // Get the feature id to switch on the right stuff.
    int featureId = feature_p.getFeatureID();
    AbstractModelElementCommand command = null;
    switch (featureId) {
      case ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT:
        // We got here only when removing a context from a fc factory. When adding, have a look at #createAddCommand.
        // Get the context to remove.
        Context contextToRemove = (Context) owner_p.eGet(feature_p);
        // The feature does not have a 'many' multiplicity, unset the context.
        // Create a 'add' command.
        command = new SetModelElementCommand(domain_p, owner_p, feature_p, value_p);
        command.setPluginChangeCommand(getRemoveContextWrapperCommand(domain_p, owner_p, feature_p, contextToRemove));
      break;
    }
    // Set the resulting command
    result = command;
    return result;
  }

  /**
   * Return the RemoveContextWrapperCommand according to real {@link AbstractFactoryComponentFactory}.
   * @param domain_p
   * @param owner_p
   * @param feature_p
   * @param contextToRemove_p
   * @return
   */
  protected PluginChangeWrapperCommand getRemoveContextWrapperCommand(EditingDomain domain_p, EObject owner_p, EStructuralFeature feature_p,
      Object contextToRemove_p) {
    // Do nothing.
    return null;
  }

  /**
   * Return the AddContextWrapperCommand according to the real {@link AbstractFactoryComponentFactory}.
   * @param domain_p
   * @param owner_p
   * @param feature_p
   * @param value_p
   * @return
   */
  protected PluginChangeWrapperCommand getAddContextWrapperCommand(EditingDomain domain_p, EObject owner_p, EStructuralFeature feature_p, Object value_p) {
    // Do nothing.
    return null;
  }

  /**
   * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#hasChildren(java.lang.Object)
   */
  @Override
  public boolean hasChildren(Object object_p) {
    boolean result = false;
    if (object_p instanceof AbstractFactoryComponentFactory) {
      AbstractFactoryComponentFactory fcFactory = (AbstractFactoryComponentFactory) object_p;
      // If context id is null, it means no context : do not use directly the getContext to prevent from loading the object.
      result = (null != fcFactory.getContextId());
    }
    return result;
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

      addContextIdPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Context Id feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addContextIdPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_AbstractFactoryComponentFactory_contextId_feature"), //$NON-NLS-1$
         getString("_UI_PropertyDescriptor_description", "_UI_AbstractFactoryComponentFactory_contextId_feature", "_UI_AbstractFactoryComponentFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
         ModelPackage.Literals.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT_ID,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
    if (childrenFeatures == null) {
      super.getChildrenFeatures(object);
      childrenFeatures.add(ModelPackage.Literals.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child) {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    String label = ((AbstractFactoryComponentFactory)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_AbstractFactoryComponentFactory_type") : //$NON-NLS-1$
      getString("_UI_AbstractFactoryComponentFactory_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

    switch (notification.getFeatureID(AbstractFactoryComponentFactory.class)) {
      case ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT_ID:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case ModelPackage.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

    newChildDescriptors.add
      (createChildParameter
        (ModelPackage.Literals.ABSTRACT_FACTORY_COMPONENT_FACTORY__CONTEXT,
         ModelFactory.eINSTANCE.createContext()));
  }

}
