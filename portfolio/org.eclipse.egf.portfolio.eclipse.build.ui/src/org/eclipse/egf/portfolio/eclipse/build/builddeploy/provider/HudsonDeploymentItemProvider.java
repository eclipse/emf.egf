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

package org.eclipse.egf.portfolio.eclipse.build.builddeploy.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.DeploymentItemProvider;

import org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployFactory;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

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
 * This is the item provider adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class HudsonDeploymentItemProvider
	extends DeploymentItemProvider
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
	public HudsonDeploymentItemProvider(AdapterFactory adapterFactory) {
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

            addAssignedNodePropertyDescriptor(object);
            addJdkNamePropertyDescriptor(object);
            addAntNamePropertyDescriptor(object);
            addBuildIdPropertyDescriptor(object);
            addEnabledPropertyDescriptor(object);
            addUserDeployServerUrlPropertyDescriptor(object);
            addUserDeployJobNamePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

	/**
     * This adds a property descriptor for the Assigned Node feature.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void addAssignedNodePropertyDescriptor(Object object) {

        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HudsonDeployment_assignedNode_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HudsonDeployment_assignedNode_feature", "_UI_HudsonDeployment_type"),
                 BuilddeployPackage.Literals.HUDSON_DEPLOYMENT__ASSIGNED_NODE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));

    }

	/**
     * This adds a property descriptor for the Jdk Name feature.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void addJdkNamePropertyDescriptor(Object object) {

        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HudsonDeployment_jdkName_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HudsonDeployment_jdkName_feature", "_UI_HudsonDeployment_type"),
                 BuilddeployPackage.Literals.HUDSON_DEPLOYMENT__JDK_NAME,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));

    }

	/**
     * This adds a property descriptor for the Ant Name feature.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void addAntNamePropertyDescriptor(Object object) {

        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HudsonDeployment_antName_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HudsonDeployment_antName_feature", "_UI_HudsonDeployment_type"),
                 BuilddeployPackage.Literals.HUDSON_DEPLOYMENT__ANT_NAME,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));

    }

	/**
     * This adds a property descriptor for the Build Id feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addBuildIdPropertyDescriptor(Object object) {

        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HudsonDeployment_buildId_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HudsonDeployment_buildId_feature", "_UI_HudsonDeployment_type"),
                 BuilddeployPackage.Literals.HUDSON_DEPLOYMENT__BUILD_ID,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));

    }

    /**
     * This adds a property descriptor for the Enabled feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEnabledPropertyDescriptor(Object object) {

        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HudsonDeployment_enabled_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HudsonDeployment_enabled_feature", "_UI_HudsonDeployment_type"),
                 BuilddeployPackage.Literals.HUDSON_DEPLOYMENT__ENABLED,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));

    }

    /**
     * This adds a property descriptor for the User Deploy Server Url feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addUserDeployServerUrlPropertyDescriptor(Object object) {

        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HudsonDeployment_userDeployServerUrl_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HudsonDeployment_userDeployServerUrl_feature", "_UI_HudsonDeployment_type"),
                 BuilddeployPackage.Literals.HUDSON_DEPLOYMENT__USER_DEPLOY_SERVER_URL,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));

    }

    /**
     * This adds a property descriptor for the User Deploy Job Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addUserDeployJobNamePropertyDescriptor(Object object) {

        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_HudsonDeployment_userDeployJobName_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_HudsonDeployment_userDeployJobName_feature", "_UI_HudsonDeployment_type"),
                 BuilddeployPackage.Literals.HUDSON_DEPLOYMENT__USER_DEPLOY_JOB_NAME,
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
            childrenFeatures.add(BuilddeployPackage.Literals.HUDSON_DEPLOYMENT__USERS);
            childrenFeatures.add(BuilddeployPackage.Literals.HUDSON_DEPLOYMENT__TRIGGERS);
            childrenFeatures.add(BuilddeployPackage.Literals.HUDSON_DEPLOYMENT__GENERATION_LOCATION);
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
     * This returns HudsonDeployment.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/HudsonDeployment"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String getText(Object object) {

        String label = ((HudsonDeployment)object).getAssignedNode();
        return label == null || label.length() == 0 ?
            getString("_UI_HudsonDeployment_type") :
            getString("_UI_HudsonDeployment_type") + " " + label;

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

        switch (notification.getFeatureID(HudsonDeployment.class)) {
            case BuilddeployPackage.HUDSON_DEPLOYMENT__ASSIGNED_NODE:
            case BuilddeployPackage.HUDSON_DEPLOYMENT__JDK_NAME:
            case BuilddeployPackage.HUDSON_DEPLOYMENT__ANT_NAME:
            case BuilddeployPackage.HUDSON_DEPLOYMENT__BUILD_ID:
            case BuilddeployPackage.HUDSON_DEPLOYMENT__ENABLED:
            case BuilddeployPackage.HUDSON_DEPLOYMENT__USER_DEPLOY_SERVER_URL:
            case BuilddeployPackage.HUDSON_DEPLOYMENT__USER_DEPLOY_JOB_NAME:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case BuilddeployPackage.HUDSON_DEPLOYMENT__USERS:
            case BuilddeployPackage.HUDSON_DEPLOYMENT__TRIGGERS:
            case BuilddeployPackage.HUDSON_DEPLOYMENT__GENERATION_LOCATION:
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
                (BuilddeployPackage.Literals.HUDSON_DEPLOYMENT__USERS,
                 BuilddeployFactory.eINSTANCE.createUser()));




        newChildDescriptors.add
            (createChildParameter
                (BuilddeployPackage.Literals.HUDSON_DEPLOYMENT__TRIGGERS,
                 BuilddeployFactory.eINSTANCE.createCronTrigger()));




        newChildDescriptors.add
            (createChildParameter
                (BuilddeployPackage.Literals.HUDSON_DEPLOYMENT__TRIGGERS,
                 BuilddeployFactory.eINSTANCE.createSCMTrigger()));


    }


}
