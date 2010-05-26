/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.pattern.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.model.edit.EGFModelEditPlugin;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.Substitution;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.egf.model.pattern.Substitution} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class SubstitutionItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider, ITableItemColorProvider, ITableItemFontProvider, IItemColorProvider,
    IItemFontProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public SubstitutionItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (itemPropertyDescriptors == null) {
      super.getPropertyDescriptors(object);

      addOutcomingPropertyDescriptor(object);
      addIncomingPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Outcoming feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected void addOutcomingPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Substitution_outcoming_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Substitution_outcoming_feature", "_UI_Substitution_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        PatternPackage.Literals.SUBSTITUTION__OUTCOMING, true, false, true, null, null, null));
  }

  /**
   * This adds a property descriptor for the Incoming feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected void addIncomingPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Substitution_incoming_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Substitution_incoming_feature", "_UI_Substitution_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        PatternPackage.Literals.SUBSTITUTION__INCOMING, true, false, true, null, null, null));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean hasChildren(Object object) {
    return hasChildren(object, true);
  }

  /**
   * This returns Substitution.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Substitution")); //$NON-NLS-1$
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
    Substitution substitution = (Substitution) object;
    String activity = null;
    String name = null;
    if (substitution.getOutcoming() != null) {
      EObject root = EcoreUtil.getRootContainer(substitution.getOutcoming(), true);
      if (root != null) {
        IItemLabelProvider provider = (IItemLabelProvider) (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory()).adapt(root, IItemLabelProvider.class);
        if (provider == null) {
          activity = EMFHelper.getText(root);
        } else {
          activity = provider.getText(root);
        }
      }
      name = substitution.getOutcoming().getName();
    }
    String label = "[" + getString("_UI_Substitution_type") + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    if (name != null && name.trim().length() != 0) {
      label = name + " " + label; //$NON-NLS-1$
    }
    if (activity != null && activity.trim().length() != 0) {
      label = activity + " -> " + label; //$NON-NLS-1$
    }
    return label;
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification) {
    updateChildren(notification);

    switch (notification.getFeatureID(Substitution.class)) {
    case PatternPackage.SUBSTITUTION__OUTCOMING:
    case PatternPackage.SUBSTITUTION__INCOMING:
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
   * 
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
   * 
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    return EGFModelEditPlugin.INSTANCE;
  }

}
