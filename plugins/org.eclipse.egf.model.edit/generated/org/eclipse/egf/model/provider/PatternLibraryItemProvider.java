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
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.model.edit.command.AbstractModelElementCommand;
import org.eclipse.egf.model.edit.command.AddModelElementCommand;
import org.eclipse.egf.model.edit.command.RemoveModelElementCommand;
import org.eclipse.egf.model.edit.command.SetModelElementCommand;
import org.eclipse.egf.model.edit.command.plugin.library.AddPatternLibraryWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.library.RemovePatternLibraryWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.library.SetPatternLibraryWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.pattern.AddPatternWrapperCommand;
import org.eclipse.egf.model.edit.command.plugin.pattern.RemovePatternWrapperCommand;
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
 * This is the item provider adapter for a {@link org.eclipse.egf.model.PatternLibrary} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class PatternLibraryItemProvider extends AbstractPatternElementItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider,
    ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
  /**
   * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public PatternLibraryItemProvider(AdapterFactory adapterFactory_p) {
    super(adapterFactory_p);
  }

  /**
   * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createAddCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject,
   *      org.eclipse.emf.ecore.EStructuralFeature, java.util.Collection, int)
   */
  @Override
  protected Command createAddCommand(EditingDomain domain_p, EObject owner_p, EStructuralFeature feature_p, Collection<?> collection_p, int index_p) {
    Command result = null;
    // Get the first and only one element of the given collection.
    Object value = getFirstElement(collection_p);
    if (null != value) {
      AbstractModelElementCommand command = new AddModelElementCommand(domain_p, owner_p, feature_p, value);
      // Create an add pattern library command.
      if (value instanceof PatternLibrary) {
        command.setPluginChangeCommand(new AddPatternLibraryWrapperCommand(domain_p, owner_p, feature_p, value));
        result = command;
      }
      // Create and add pattern model command.
      else if (value instanceof PatternModel) {
        command.setPluginChangeCommand(new AddPatternWrapperCommand(domain_p, owner_p, feature_p, value));
        result = command;
      }
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
    AbstractModelElementCommand result = new SetModelElementCommand(domain_p, owner_p, feature_p, value_p);
    // Create a command to take into account pattern library changes.
    result.setPluginChangeCommand(new SetPatternLibraryWrapperCommand(domain_p, owner_p, feature_p, value_p));
    return result;
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
      // Create a remove pattern library command.
      if (value instanceof PatternLibrary) {
        result.setPluginChangeCommand(new RemovePatternLibraryWrapperCommand(domain_p, owner_p, feature_p, value));
      }
      // Create a remove pattern command.
      else if (value instanceof PatternModel) {
        result.setPluginChangeCommand(new RemovePatternWrapperCommand(domain_p, owner_p, feature_p, value));
      }
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

      addProductionOrchestrationPropertyDescriptor(object);
      addRuntimeOrchestrationPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Production Orchestration feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addProductionOrchestrationPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_PatternLibrary_productionOrchestration_feature"), //$NON-NLS-1$
         getString("_UI_PropertyDescriptor_description", "_UI_PatternLibrary_productionOrchestration_feature", "_UI_PatternLibrary_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
         ModelPackage.Literals.PATTERN_LIBRARY__PRODUCTION_ORCHESTRATION,
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
   * This adds a property descriptor for the Runtime Orchestration feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addRuntimeOrchestrationPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_PatternLibrary_runtimeOrchestration_feature"), //$NON-NLS-1$
         getString("_UI_PropertyDescriptor_description", "_UI_PatternLibrary_runtimeOrchestration_feature", "_UI_PatternLibrary_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
         ModelPackage.Literals.PATTERN_LIBRARY__RUNTIME_ORCHESTRATION,
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
      childrenFeatures.add(ModelPackage.Literals.PATTERN_LIBRARY__PATTERN_ELEMENTS);
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
   * This returns PatternLibrary.gif.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/PatternLibrary")); //$NON-NLS-1$
  }

  /**
   * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public String getText(Object object) {
    return ICommonConstants.EMPTY_STRING + ((PatternLibrary) object).getName();
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

    switch (notification.getFeatureID(PatternLibrary.class)) {
      case ModelPackage.PATTERN_LIBRARY__PRODUCTION_ORCHESTRATION:
      case ModelPackage.PATTERN_LIBRARY__RUNTIME_ORCHESTRATION:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case ModelPackage.PATTERN_LIBRARY__PATTERN_ELEMENTS:
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
  }

}
