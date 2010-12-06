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
package org.eclipse.egf.model.ftask.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.model.EGFFtaskPlugin;
import org.eclipse.egf.model.fcore.provider.ActivityItemProvider;
import org.eclipse.egf.model.ftask.FtaskPackage;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.CreateChildCommand;
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
 * This is the item provider adapter for a {@link org.eclipse.egf.model.ftask.Task} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TaskItemProvider extends ActivityItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider, ITableItemColorProvider, ITableItemFontProvider, IItemColorProvider, IItemFontProvider {

    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TaskItemProvider(AdapterFactory adapterFactory) {
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

            addKindPropertyDescriptor(object);
            addSuperTaskPropertyDescriptor(object);
            addImplementationPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Kind feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addKindPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Task_kind_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_Task_kind_feature", "_UI_Task_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                FtaskPackage.Literals.TASK__KIND, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_TaskPropertyCategory"), null) { //$NON-NLS-1$

                    @Override
                    public Collection<String> getChoiceOfValues(Object innerObject) {
                        Collection<String> result = EGFFtaskPlugin.getTaskNatureRegistry().getKinds();
                        if (result.contains(null) == false) {
                            result.add(null);
                        }
                        return result;
                    }

                });
    }

    /**
     * This adds a property descriptor for the Implementation feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addImplementationPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Task_implementation_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_Task_implementation_feature", "_UI_Task_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                FtaskPackage.Literals.TASK__IMPLEMENTATION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_InfoPropertyCategory"), //$NON-NLS-1$
                null));
    }

    /**
     * This adds a property descriptor for the Super Task feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSuperTaskPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Task_superTask_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_Task_superTask_feature", "_UI_Task_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                FtaskPackage.Literals.TASK__SUPER_TASK, true, false, true, null, getString("_UI_InfoPropertyCategory"), //$NON-NLS-1$
                null));
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
        Task task = (Task) object;
        String label = task.getName();
        String type = "[" + getString("_UI_Task_type"); //$NON-NLS-1$ //$NON-NLS-2$
        if (task.getKindValue() != null && task.getKindValue().trim().length() > 0) {
            type = type + " " + StringHelper.toUpperFirst(task.getKindValue()); //$NON-NLS-1$
        }
        type = type + "]"; //$NON-NLS-1$
        return label == null || label.length() == 0 ? type : label + " " + type; //$NON-NLS-1$
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

        switch (notification.getFeatureID(Task.class)) {
        case FtaskPackage.TASK__KIND:
        case FtaskPackage.TASK__IMPLEMENTATION:
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
     * This returns Task.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/Task")); //$NON-NLS-1$
    }

    /**
     * This returns the label for {@link CreateChildCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
        if (owner instanceof Resource) {
            Task task = (Task) child;
            String label = task.getName();
            String type = getString("_UI_Task_type"); //$NON-NLS-1$
            if (task.getKindValue() != null && task.getKindValue().trim().length() > 0) {
                type = type + " " + StringHelper.toUpperFirst(task.getKindValue()); //$NON-NLS-1$
            }
            return label == null || label.length() == 0 ? type : label + " " + type; //$NON-NLS-1$    }
        }
        return super.getCreateChildText(owner, feature, child, selection);

    }

}
