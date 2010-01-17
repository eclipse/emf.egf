/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.fcore.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemColorProvider;
import org.eclipse.emf.edit.provider.ITableItemFontProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.egf.model.fcore.ActivityContract} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ActivityContractItemProvider extends ModelElementItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider, ITableItemColorProvider, ITableItemFontProvider, IItemColorProvider, IItemFontProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActivityContractItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (itemPropertyDescriptors == null) {
      super.getPropertyDescriptors(object);

      addMandatoryPropertyDescriptor(object);
      addModePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Mandatory feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addMandatoryPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ActivityContract_mandatory_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_ActivityContract_mandatory_feature", "_UI_ActivityContract_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.ACTIVITY_CONTRACT__MANDATORY, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString("_UI_BehaviourPropertyCategory"), //$NON-NLS-1$
        null));
  }

  /**
   * This adds a property descriptor for the Mode feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addModePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ActivityContract_mode_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_ActivityContract_mode_feature", "_UI_ActivityContract_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.ACTIVITY_CONTRACT__MODE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_BehaviourPropertyCategory"), //$NON-NLS-1$
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
      childrenFeatures.add(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    String label = ((ActivityContract) object).getName();
    return label == null || label.length() == 0 ? "[" + getString("_UI_ActivityContract_type") + "]" : //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        label + " [" + getString("_UI_ActivityContract_type") + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification) {
    updateChildren(notification);

    switch (notification.getFeatureID(ActivityContract.class)) {
    case FcorePackage.ACTIVITY_CONTRACT__MANDATORY:
    case FcorePackage.ACTIVITY_CONTRACT__MODE:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
      return;
    case FcorePackage.ACTIVITY_CONTRACT__TYPE:
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

    newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, TypesFactory.eINSTANCE.createTypeCollection()));

    newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, TypesFactory.eINSTANCE.createTypeList()));

    newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, TypesFactory.eINSTANCE.createTypeSet()));

    newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, TypesFactory.eINSTANCE.createTypeGeneratorAdapterFactory()));

    newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, TypesFactory.eINSTANCE.createTypeMap()));

    newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, TypesFactory.eINSTANCE.createTypeBigDecimal()));

    newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, TypesFactory.eINSTANCE.createTypeBigInteger()));

    newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, TypesFactory.eINSTANCE.createTypeBoolean()));

    newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, TypesFactory.eINSTANCE.createTypeByte()));

    newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, TypesFactory.eINSTANCE.createTypeCharacter()));

    newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, TypesFactory.eINSTANCE.createTypeDate()));

    newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, TypesFactory.eINSTANCE.createTypeDouble()));

    newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, TypesFactory.eINSTANCE.createTypeFloat()));

    newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, TypesFactory.eINSTANCE.createTypeInteger()));

    newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, TypesFactory.eINSTANCE.createTypeLong()));

    newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, TypesFactory.eINSTANCE.createTypeShort()));

    newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, TypesFactory.eINSTANCE.createTypeString()));
  }

}
