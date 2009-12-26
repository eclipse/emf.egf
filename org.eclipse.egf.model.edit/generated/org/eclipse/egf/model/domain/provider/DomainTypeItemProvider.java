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
package org.eclipse.egf.model.domain.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.DomainType;
import org.eclipse.egf.model.edit.EGFModelsEditPlugin;
import org.eclipse.egf.model.fcore.provider.TypeItemProvider;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
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
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.egf.model.domain.DomainType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DomainTypeItemProvider extends TypeItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider, ITableItemColorProvider, ITableItemFontProvider, IItemColorProvider, IItemFontProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DomainTypeItemProvider(AdapterFactory adapterFactory) {
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

      addDomainPropertyDescriptor(object);
      addEPackagePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Domain feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addDomainPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_DomainType_domain_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_DomainType_domain_feature", "_UI_DomainType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        DomainPackage.Literals.DOMAIN_TYPE__DOMAIN, true, false, true, null, getString("_UI_ValuePropertyCategory"), //$NON-NLS-1$
        null));
  }

  /**
   * This adds a property descriptor for the EPackage feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addEPackagePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_DomainType_ePackage_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_DomainType_ePackage_feature", "_UI_DomainType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        DomainPackage.Literals.DOMAIN_TYPE__EPACKAGE, false, false, false, null, getString("_UI_ValuePropertyCategory"), //$NON-NLS-1$
        null));
  }

  /**
   * This returns DomainType.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/DomainType")); //$NON-NLS-1$
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @Override
  public String getText(Object object) {
    DomainType domainType = (DomainType) object;
    String label = domainType.getName();
    String nsuri = null;
    if (domainType.getEPackage() != null) {
      nsuri = "[" + domainType.getEPackage().getNsURI() + "]"; //$NON-NLS-1$ //$NON-NLS-2$
    }
    if (label == null || label.length() == 0) {
      label = "[" + getString("_UI_DomainType_type") + "]";//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
      if (nsuri != null) {
        label = nsuri + " " + label; //$NON-NLS-1$
      }
    } else {
      if (nsuri != null) {
        label = label + " " + nsuri + " [" + getString("_UI_DomainType_type") + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
      } else {
        label = label + " [" + getString("_UI_DomainType_type") + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
      }
    }
    return label;
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

    switch (notification.getFeatureID(DomainType.class)) {
    case DomainPackage.DOMAIN_TYPE__DOMAIN:
    case DomainPackage.DOMAIN_TYPE__EPACKAGE:
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

  /**
   * Return the resource locator for this item provider's resources.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    return EGFModelsEditPlugin.INSTANCE;
  }

}
