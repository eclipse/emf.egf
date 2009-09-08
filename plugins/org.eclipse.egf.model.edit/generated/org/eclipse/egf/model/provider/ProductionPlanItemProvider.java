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

import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.ProductionPlan;
import org.eclipse.egf.model.edit.command.AbstractModelElementCommand;
import org.eclipse.egf.model.edit.command.AddModelElementCommand;
import org.eclipse.egf.model.edit.command.RemoveModelElementCommand;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.context.AddContextInProductionPlanWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.context.RemoveContextInProductionPlanWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.fci.AddFactoryComponentInvocationWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.fci.RemoveFactoryComponentInvocationWrapperCommand;
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
 * This is the item provider adapter for a {@link org.eclipse.egf.model.ProductionPlan} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class ProductionPlanItemProvider extends AbstractFactoryComponentFactoryItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider,
    ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

  /**
   * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public ProductionPlanItemProvider(AdapterFactory adapterFactory_p) {
    super(adapterFactory_p);
  }

  /**
   * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createAddCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject,
   *      org.eclipse.emf.ecore.EStructuralFeature, java.util.Collection, int)
   */
  @Override
  protected Command createAddCommand(EditingDomain domain_p, EObject owner_p, EStructuralFeature feature_p, Collection<?> collection_p, int index_p) {
    Command result = super.createAddCommand(domain_p, owner_p, feature_p, collection_p, index_p);
    if (null == result) {
      // Get the first and only one element of the given collection.
      Object value = getFirstElement(collection_p);
      if (null != value) {
        AbstractModelElementCommand command = new AddModelElementCommand(domain_p, owner_p, feature_p, value);
        command.setPluginChangeCommand(new AddFactoryComponentInvocationWrapperCommand(domain_p, owner_p, feature_p, value));
        // Set the resulting command.
        result = command;
      }
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.model.provider.AbstractFactoryComponentFactoryItemProvider#getAddContextWrapperCommand(org.eclipse.emf.edit.domain.EditingDomain,
   *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
   */
  @Override
  protected PluginChangeWrapperCommand getAddContextWrapperCommand(EditingDomain domain_p, EObject owner_p, EStructuralFeature feature_p, Object value_p) {
    return new AddContextInProductionPlanWrapperCommand(domain_p, owner_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.model.provider.AbstractFactoryComponentFactoryItemProvider#getRemoveContextWrapperCommand(org.eclipse.emf.edit.domain.EditingDomain,
   *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
   */
  @Override
  protected PluginChangeWrapperCommand getRemoveContextWrapperCommand(EditingDomain domain_p, EObject owner_p, EStructuralFeature feature_p,
      Object contextToRemove_p) {
    return new RemoveContextInProductionPlanWrapperCommand(domain_p, owner_p, feature_p, contextToRemove_p);
  }

  /**
   * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createRemoveCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject,
   *      org.eclipse.emf.ecore.EStructuralFeature, java.util.Collection)
   */
  @Override
  protected Command createRemoveCommand(EditingDomain domain_p, EObject owner_p, EStructuralFeature feature_p, Collection<?> collection_p) {
    AbstractModelElementCommand result = null;
    // Get the first and only one element of the given collection.
    Object value = getFirstElement(collection_p);
    if (null != value) {
      result = new RemoveModelElementCommand(domain_p, owner_p, feature_p, value);
      result.setPluginChangeCommand(new RemoveFactoryComponentInvocationWrapperCommand(domain_p, owner_p, feature_p, value));
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.model.provider.AbstractFactoryComponentFactoryItemProvider#hasChildren(java.lang.Object)
   */
  @Override
  public boolean hasChildren(Object object_p) {
    boolean result = super.hasChildren(object_p);
    if (!result && object_p instanceof ProductionPlan) {
      ProductionPlan productionPlan = (ProductionPlan) object_p;
      // If factory component invocation id list is empty, it means no factory component invocation : do not use directly the getFactoryComponentInvocations to prevent from loading the
      // objects.
      result = !productionPlan.getFactoryComponentInvocationIds().isEmpty();
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

      addFactoryComponentInvocationIdsPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Factory Component Invocation Ids feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addFactoryComponentInvocationIdsPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ProductionPlan_factoryComponentInvocationIds_feature"), //$NON-NLS-1$
         getString("_UI_PropertyDescriptor_description", "_UI_ProductionPlan_factoryComponentInvocationIds_feature", "_UI_ProductionPlan_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
         ModelPackage.Literals.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATION_IDS,
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
      childrenFeatures.add(ModelPackage.Literals.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATIONS);
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
   * This returns ProductionPlan.gif.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/ProductionPlan")); //$NON-NLS-1$
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    String label = ((ProductionPlan)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_ProductionPlan_type") : //$NON-NLS-1$
      getString("_UI_ProductionPlan_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

    switch (notification.getFeatureID(ProductionPlan.class)) {
      case ModelPackage.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATION_IDS:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case ModelPackage.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATIONS:
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
        (ModelPackage.Literals.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATIONS,
         ModelFactory.eINSTANCE.createFactoryComponentInvocation()));
  }
}