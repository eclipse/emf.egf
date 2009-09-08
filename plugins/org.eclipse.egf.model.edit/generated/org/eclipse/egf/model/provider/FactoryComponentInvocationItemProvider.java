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
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.TaskFactoryHolder;
import org.eclipse.egf.model.edit.command.AbstractModelElementCommand;
import org.eclipse.egf.model.edit.command.SetModelElementCommand;
import org.eclipse.egf.model.edit.command.plugin.PluginChangeWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.context.AddContextInFcInvocationConfWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.context.RemoveContextInFcInvocationWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.fci.SetFactoryComponentInvocationWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.taskfactory.AddTaskFactoryHolderWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.taskfactory.RemoveTaskFactoryHolderWrapperCommand;
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
 * This is the item provider adapter for a {@link org.eclipse.egf.model.FactoryComponentInvocation} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class FactoryComponentInvocationItemProvider extends AbstractFactoryComponentFactoryItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider,
    ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
  /**
   * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public FactoryComponentInvocationItemProvider(AdapterFactory adapterFactory_p) {
    super(adapterFactory_p);
  }

  /**
   * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createAddCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject,
   *      org.eclipse.emf.ecore.EStructuralFeature, java.util.Collection, int)
   */
  @Override
  protected Command createAddCommand(EditingDomain domain_p, EObject owner_p, EStructuralFeature feature_p, Collection<?> collection_p, int index_p) {
    Command result = super.createAddCommand(domain_p, owner_p, feature_p, collection_p, index_p);
    // If result is null, proceed here.
    if (null == result) {
      // Get the feature id to switch on the right stuff.
      int featureId = feature_p.getFeatureID();
      AbstractModelElementCommand command = null;
      switch (featureId) {
        case ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY:
          // Get the first and only one element of the given collection.
          Object value = getFirstElement(collection_p);
          if (null != value) {
            // The feature does not have a 'many' multiplicity, we must use a 'set' because is not a list containment.
            command = new SetModelElementCommand(domain_p, owner_p, feature_p, value);
            command.setPluginChangeCommand(new AddTaskFactoryHolderWrapperCommand(domain_p, owner_p, feature_p, value));
          }
        break;
      }
      // Set the resulting command.
      result = command;
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createSetCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject,
   *      org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
   */
  @Override
  protected Command createSetCommand(EditingDomain domain_p, EObject owner_p, EStructuralFeature feature_p, Object value_p) {
    // Create a command to proceed a set operation.
    Command result = super.createSetCommand(domain_p, owner_p, feature_p, value_p);
    // If result is null, proceed here.
    if (null == result) {
      // Get the feature id to switch on the right stuff.
      int featureId = feature_p.getFeatureID();
      AbstractModelElementCommand command = new SetModelElementCommand(domain_p, owner_p, feature_p, value_p);
      switch (featureId) {
        case ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY:
          // We got here only when removing a task factory from a factory component invocation. When adding, have a look at #createAddCommand.
          // Get the task factory holder to remove.
          TaskFactoryHolder taskFactoryHolderToRemove = (TaskFactoryHolder) owner_p.eGet(feature_p);
          // The feature does not have a 'many' multiplicity, unset the task factory.
          command.setPluginChangeCommand(new RemoveTaskFactoryHolderWrapperCommand(domain_p, owner_p, feature_p, taskFactoryHolderToRemove));
        break;
        case ModelPackage.FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT_ID:
          // Changing the pointed factory component implies to update plug-in dependencies.
          // First, we have to remove the previous required plug-in related to the previous pointed factory component,
          // Secondly, we have to add the new required plug-in related to the new pointed factory component.
          // To be able to do that, we put as new value the previous pointed factory component id in our plug-in changes command.
          command.setPluginChangeCommand(new SetFactoryComponentInvocationWrapperCommand(domain_p, owner_p, feature_p, owner_p.eGet(feature_p)));
        break;
        default:
          // Create a command to take into account factory component configuration changes.
          command.setPluginChangeCommand(new SetFactoryComponentInvocationWrapperCommand(domain_p, owner_p, feature_p, value_p));
      }
      // Set the resulting command.
      result = command;
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.model.provider.AbstractFactoryComponentFactoryItemProvider#getAddContextWrapperCommand(org.eclipse.emf.edit.domain.EditingDomain,
   *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
   */
  @Override
  protected PluginChangeWrapperCommand getAddContextWrapperCommand(EditingDomain domain_p, EObject owner_p, EStructuralFeature feature_p, Object value_p) {
    return new AddContextInFcInvocationConfWrapperCommand(domain_p, owner_p, feature_p, value_p);
  }

  /**
   * @see org.eclipse.egf.model.provider.AbstractFactoryComponentFactoryItemProvider#getRemoveContextWrapperCommand(org.eclipse.emf.edit.domain.EditingDomain,
   *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.egf.model.Context)
   */
  @Override
  protected PluginChangeWrapperCommand getRemoveContextWrapperCommand(EditingDomain domain_p, EObject owner_p, EStructuralFeature feature_p,
      Object contextToRemove_p) {
    return new RemoveContextInFcInvocationWrapperCommand(domain_p, owner_p, feature_p, contextToRemove_p);
  }

  /**
   * @see org.eclipse.egf.model.provider.AbstractFactoryComponentFactoryItemProvider#hasChildren(java.lang.Object)
   */
  @Override
  public boolean hasChildren(Object object_p) {
    boolean result = super.hasChildren(object_p);
    if (!result && object_p instanceof FactoryComponentInvocation) {
      FactoryComponentInvocation fcInvocation = (FactoryComponentInvocation) object_p;
      // If task factory id is null, it means no factory : do not use directly the getTaskFactory to prevent from loading the object.
      result = (null != fcInvocation.getTaskFactoryId());
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

      addTaskFactoryIdPropertyDescriptor(object);
      addFactoryComponentIdPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Task Factory Id feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addTaskFactoryIdPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_FactoryComponentInvocation_taskFactoryId_feature"), //$NON-NLS-1$
         getString("_UI_PropertyDescriptor_description", "_UI_FactoryComponentInvocation_taskFactoryId_feature", "_UI_FactoryComponentInvocation_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
         ModelPackage.Literals.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY_ID,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Factory Component Id feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addFactoryComponentIdPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_FactoryComponentInvocation_factoryComponentId_feature"), //$NON-NLS-1$
         getString("_UI_PropertyDescriptor_description", "_UI_FactoryComponentInvocation_factoryComponentId_feature", "_UI_FactoryComponentInvocation_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
         ModelPackage.Literals.FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT_ID,
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
      childrenFeatures.add(ModelPackage.Literals.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY);
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
   * This returns FactoryComponentInvocation.gif.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/FactoryComponentInvocation")); //$NON-NLS-1$
  }

  /**
   * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public String getText(Object object) {
    StringBuilder fcInvocationLabel = new StringBuilder();
    // Append the factory component invocation name.
    FactoryComponentInvocation fcInvocation = ((FactoryComponentInvocation) object);
    fcInvocationLabel.append(ICommonConstants.EMPTY_STRING).append(fcInvocation.getName());
    // Get the referenced factory component by this factory component invocation.
    FactoryComponent referencedFc = CoreActivator.getDefault().getFactoryComponent(fcInvocation.getFactoryComponentId());
    // If retrieved, add its name in the returned label.
    if (null != referencedFc) {
      fcInvocationLabel.append(" -> ").append(referencedFc.getName()); //$NON-NLS-1$
    }
    return fcInvocationLabel.toString();
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

    switch (notification.getFeatureID(FactoryComponentInvocation.class)) {
      case ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY_ID:
      case ModelPackage.FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT_ID:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case ModelPackage.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY:
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
        (ModelPackage.Literals.FACTORY_COMPONENT_INVOCATION__TASK_FACTORY,
         ModelFactory.eINSTANCE.createTaskFactoryHolder()));
  }
}
