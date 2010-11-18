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
package org.eclipse.egf.model.fcore.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.egf.model.edit.EGFModelEditPlugin;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.helper.FactoryComponentContractHelper;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
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
 * This is the item provider adapter for a {@link org.eclipse.egf.model.fcore.FactoryComponentContract} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FactoryComponentContractItemProvider extends ContractItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider, ITableItemColorProvider, ITableItemFontProvider,
        IItemColorProvider, IItemFontProvider {

    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FactoryComponentContractItemProvider(AdapterFactory adapterFactory) {
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

            addInvocationContractsPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Invocation Contracts feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addInvocationContractsPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_FactoryComponentContract_invocationContracts_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_FactoryComponentContract_invocationContracts_feature", "_UI_FactoryComponentContract_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                FcorePackage.Literals.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTRACTS, true, false, true, null, getString("_UI_InvocationContractsPropertyCategory"), null) { //$NON-NLS-1$

                    @Override
                    public Collection<?> getChoiceOfValues(Object current) {
                        return FactoryComponentContractHelper.getAvailableInvocationContracts((FactoryComponentContract) current);
                    }
                });
    }

    /**
     * This adds an overlay to the given image if the object is controlled.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    protected Object overlayImage(Object object, Object image) {
        FactoryComponentContract factoryComponentContract = (FactoryComponentContract) object;
        List<Object> images = new ArrayList<Object>(3);
        images.add(image);
        if (factoryComponentContract.getInvocationContracts() == null || factoryComponentContract.getInvocationContracts().size() == 0) {
            images.add(EGFModelEditPlugin.INSTANCE.getImage("full/ovr16/IsNotUsed")); //$NON-NLS-1$
        }
        if (factoryComponentContract.isMandatory()) {
            images.add(getResourceLocator().getImage("full/ovr16/Mandatory")); //$NON-NLS-1$
        }
        if (AdapterFactoryEditingDomain.isControlled(object)) {
            images.add(EMFEditPlugin.INSTANCE.getImage("full/ovr16/ControlledObject")); //$NON-NLS-1$
        }
        return new ComposedImage(images);
    }

    /**
     * This returns FactoryComponentContract.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/FactoryComponentContract")); //$NON-NLS-1$
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
        FactoryComponentContract contract = (FactoryComponentContract) object;
        String label = contract.getName();
        String mode = null;
        if (contract.getMode() != null) {
            mode = "[" + contract.getMode().getLiteral() + "]"; //$NON-NLS-1$ //$NON-NLS-2$
        }
        if (label == null || label.length() == 0) {
            label = "[" + getString("_UI_FactoryComponentContract_type") + "]";//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            if (mode != null) {
                label = mode + " " + label; //$NON-NLS-1$
            }
        } else {
            if (mode != null) {
                label = label + " " + mode + " [" + getString("_UI_FactoryComponentContract_type") + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            } else {
                label = label + " [" + getString("_UI_FactoryComponentContract_type") + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
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

        switch (notification.getFeatureID(FactoryComponentContract.class)) {
            case FcorePackage.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTRACTS:
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
