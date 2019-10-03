/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v2.0
 *    which accompanies this distribution, and is available at
 *    https://www.eclipse.org/legal/epl-v2.0
 *
 *    SPDX-License-Identifier: EPL-2.0
 * 
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.buildstep.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.StepItemProvider;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepFactory;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

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
 * This is the item provider adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InstallStepItemProvider
    extends StepItemProvider
    implements
        IEditingDomainItemProvider,
        IStructuredItemContentProvider,
        ITreeItemContentProvider,
        IItemLabelProvider,
        IItemPropertySource {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InstallStepItemProvider(AdapterFactory adapterFactory) {
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

            addIdPropertyDescriptor(object);
            addProfilePropertyDescriptor(object);
            addResultStepsPropertyDescriptor(object);
            addUpdateSiteUrlsPropertyDescriptor(object);
            addFeatureNamesPropertyDescriptor(object);
            addProductNamesPropertyDescriptor(object);
            addInstallResultStepsSourceFeaturesPropertyDescriptor(object);
            addP2_osPropertyDescriptor(object);
            addP2_wsPropertyDescriptor(object);
            addP2_archPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Id feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addIdPropertyDescriptor(Object object) {

        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_InstallStep_id_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_InstallStep_id_feature", "_UI_InstallStep_type"),
                 BuildstepPackage.Literals.INSTALL_STEP__ID,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));

    }

    /**
     * This adds a property descriptor for the Profile feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addProfilePropertyDescriptor(Object object) {

        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_InstallStep_profile_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_InstallStep_profile_feature", "_UI_InstallStep_type"),
                 BuildstepPackage.Literals.INSTALL_STEP__PROFILE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));

    }

    /**
     * This adds a property descriptor for the Result Steps feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addResultStepsPropertyDescriptor(Object object) {

        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_InstallStep_resultSteps_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_InstallStep_resultSteps_feature", "_UI_InstallStep_type"),
                 BuildstepPackage.Literals.INSTALL_STEP__RESULT_STEPS,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));

    }

    /**
     * This adds a property descriptor for the Update Site Urls feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addUpdateSiteUrlsPropertyDescriptor(Object object) {

        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_InstallStep_updateSiteUrls_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_InstallStep_updateSiteUrls_feature", "_UI_InstallStep_type"),
                 BuildstepPackage.Literals.INSTALL_STEP__UPDATE_SITE_URLS,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));

    }

    /**
     * This adds a property descriptor for the Feature Names feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addFeatureNamesPropertyDescriptor(Object object) {

        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_InstallStep_featureNames_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_InstallStep_featureNames_feature", "_UI_InstallStep_type"),
                 BuildstepPackage.Literals.INSTALL_STEP__FEATURE_NAMES,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));

    }

    /**
     * This adds a property descriptor for the Product Names feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addProductNamesPropertyDescriptor(Object object) {

        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_InstallStep_productNames_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_InstallStep_productNames_feature", "_UI_InstallStep_type"),
                 BuildstepPackage.Literals.INSTALL_STEP__PRODUCT_NAMES,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));

    }

    /**
     * This adds a property descriptor for the Install Result Steps Source Features feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addInstallResultStepsSourceFeaturesPropertyDescriptor(Object object) {

        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_InstallStep_installResultStepsSourceFeatures_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_InstallStep_installResultStepsSourceFeatures_feature", "_UI_InstallStep_type"),
                 BuildstepPackage.Literals.INSTALL_STEP__INSTALL_RESULT_STEPS_SOURCE_FEATURES,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));

    }

    /**
     * This adds a property descriptor for the P2 os feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addP2_osPropertyDescriptor(Object object) {

        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_InstallStep_p2_os_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_InstallStep_p2_os_feature", "_UI_InstallStep_type"),
                 BuildstepPackage.Literals.INSTALL_STEP__P2_OS,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));

    }

    /**
     * This adds a property descriptor for the P2 ws feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addP2_wsPropertyDescriptor(Object object) {

        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_InstallStep_p2_ws_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_InstallStep_p2_ws_feature", "_UI_InstallStep_type"),
                 BuildstepPackage.Literals.INSTALL_STEP__P2_WS,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));

    }

    /**
     * This adds a property descriptor for the P2 arch feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addP2_archPropertyDescriptor(Object object) {

        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_InstallStep_p2_arch_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_InstallStep_p2_arch_feature", "_UI_InstallStep_type"),
                 BuildstepPackage.Literals.INSTALL_STEP__P2_ARCH,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));

    }

    /**
     * This returns InstallStep.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/InstallStep"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {

        String label = ((InstallStep)object).getName();
        return label == null || label.length() == 0 ?
            getString("_UI_InstallStep_type") :
            getString("_UI_InstallStep_type") + " " + label;

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

        switch (notification.getFeatureID(InstallStep.class)) {
            case BuildstepPackage.INSTALL_STEP__ID:
            case BuildstepPackage.INSTALL_STEP__PROFILE:
            case BuildstepPackage.INSTALL_STEP__UPDATE_SITE_URLS:
            case BuildstepPackage.INSTALL_STEP__FEATURE_NAMES:
            case BuildstepPackage.INSTALL_STEP__PRODUCT_NAMES:
            case BuildstepPackage.INSTALL_STEP__INSTALL_RESULT_STEPS_SOURCE_FEATURES:
            case BuildstepPackage.INSTALL_STEP__P2_OS:
            case BuildstepPackage.INSTALL_STEP__P2_WS:
            case BuildstepPackage.INSTALL_STEP__P2_ARCH:
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
