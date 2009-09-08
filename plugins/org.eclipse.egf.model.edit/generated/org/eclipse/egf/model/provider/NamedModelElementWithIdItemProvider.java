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
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;


/**
 * This is the item provider adapter for a {@link org.eclipse.egf.model.NamedModelElementWithId} object. <!-- begin-user-doc --> <!-- end-user-doc
 * -->
 * @generated
 */
public class NamedModelElementWithIdItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider,
    ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(NamedModelElementWithIdItemProvider.class.getPackage().getName());

  /**
   * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public NamedModelElementWithIdItemProvider(AdapterFactory adapterFactory_p) {
    super(adapterFactory_p);
  }

  /**
   * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createItemPropertyDescriptor(org.eclipse.emf.common.notify.AdapterFactory,
   *      org.eclipse.emf.common.util.ResourceLocator, java.lang.String, java.lang.String, org.eclipse.emf.ecore.EStructuralFeature, boolean, boolean, boolean,
   *      java.lang.Object, java.lang.String, java.lang.String[])
   */
  @Override
  protected ItemPropertyDescriptor createItemPropertyDescriptor(AdapterFactory adapterFactory_p, ResourceLocator resourceLocator_p, String displayName_p,
      String description_p, EStructuralFeature feature_p, boolean isSettable_p, boolean multiLine_p, boolean sortChoices_p, Object staticImage_p,
      String category_p, String[] filterFlags_p) {
    // Override the default behavior to be able to deal with data modification feature between the factory component explorer view and the installed factory components view.
    // Our data are not loaded from an EMF resource, hence we need to adapt the default code.
    ItemPropertyDescriptor itemPropertyDescriptor =
                                                    new ItemPropertyDescriptor(adapterFactory_p, resourceLocator_p, displayName_p, description_p, feature_p,
                                                                               isSettable_p, multiLine_p, sortChoices_p, staticImage_p, category_p,
                                                                               filterFlags_p) {

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
                                                    };
    return itemPropertyDescriptor;
  }

  /**
   * Get the first element in given collection.
   * @param collection_p
   * @return
   */
  protected Object getFirstElement(Collection<?> collection_p) {
    Iterator<?> iterator = collection_p.iterator();
    Object value = iterator.next();
    if (null == value) {
      StringBuilder loggerMessage = new StringBuilder("ProductionPlanItemProvider.createAddCommand(..) _ "); //$NON-NLS-1$
      loggerMessage.append("value must be not null"); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString());
    }
    return value;
  }

  /**
   * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (itemPropertyDescriptors == null) {
      super.getPropertyDescriptors(object);

      addIdPropertyDescriptor(object);
      addNamePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Id feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addIdPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_NamedModelElementWithId_id_feature"), //$NON-NLS-1$
         getString("_UI_PropertyDescriptor_description", "_UI_NamedModelElementWithId_id_feature", "_UI_NamedModelElementWithId_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
         ModelPackage.Literals.NAMED_MODEL_ELEMENT_WITH_ID__ID,
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
   * This adds a property descriptor for the Java Identifier feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addJavaIdentifierPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_NamedModelElementWithId_javaIdentifier_feature"), //$NON-NLS-1$
         getString("_UI_PropertyDescriptor_description", "_UI_NamedModelElementWithId_javaIdentifier_feature", "_UI_NamedModelElementWithId_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
         ModelPackage.Literals.NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER,
         false,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Name feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addNamePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_NamedModelElementWithId_name_feature"), //$NON-NLS-1$
         getString("_UI_PropertyDescriptor_description", "_UI_NamedModelElementWithId_name_feature", "_UI_NamedModelElementWithId_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
         ModelPackage.Literals.NAMED_MODEL_ELEMENT_WITH_ID__NAME,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Description feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addDescriptionPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_NamedModelElementWithId_description_feature"), //$NON-NLS-1$
         getString("_UI_PropertyDescriptor_description", "_UI_NamedModelElementWithId_description_feature", "_UI_NamedModelElementWithId_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
         ModelPackage.Literals.NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION,
         true,
         true,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This returns NamedModelElementWithId.gif.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/NamedModelElementWithId")); //$NON-NLS-1$
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    String label = ((NamedModelElementWithId)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_NamedModelElementWithId_type") : //$NON-NLS-1$
      getString("_UI_NamedModelElementWithId_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

    switch (notification.getFeatureID(NamedModelElementWithId.class)) {
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__ID:
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__JAVA_IDENTIFIER:
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__NAME:
      case ModelPackage.NAMED_MODEL_ELEMENT_WITH_ID__DESCRIPTION:
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
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    return FactoryComponentEditPlugin.INSTANCE;
  }

}
