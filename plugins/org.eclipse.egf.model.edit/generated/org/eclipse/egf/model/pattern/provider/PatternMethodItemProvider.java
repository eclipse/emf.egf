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

import org.eclipse.egf.model.edit.EGFModelEditPlugin;
import org.eclipse.egf.model.fcore.provider.NamedModelElementItemProvider;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.egf.model.pattern.PatternMethod}
 * object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class PatternMethodItemProvider extends NamedModelElementItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider, ITableItemColorProvider, ITableItemFontProvider,
        IItemColorProvider, IItemFontProvider {

    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PatternMethodItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addPatternFilePathPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Pattern File Path feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addPatternFilePathPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_PatternMethod_patternFilePath_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_PatternMethod_patternFilePath_feature", "_UI_PatternMethod_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                PatternPackage.Literals.PATTERN_METHOD__PATTERN_FILE_PATH, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This returns PatternMethod.gif. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated NOT
     */
    @Override
    public Object getImage(Object object) {
        PatternMethod method = (PatternMethod) object;
        if (method.getPattern() != null && method.getPattern().eGet(PatternPackage.Literals.PATTERN__HEADER_METHOD) == method) {
            return overlayImage(object, getResourceLocator().getImage("full/obj16/PatternHeaderMethod")); //$NON-NLS-1$
        } else if (method.getPattern() != null && method.getPattern().eGet(PatternPackage.Literals.PATTERN__FOOTER_METHOD) == method) {
            return overlayImage(object, getResourceLocator().getImage("full/obj16/PatternFooterMethod")); //$NON-NLS-1$
        }
        return overlayImage(object, getResourceLocator().getImage("full/obj16/PatternMethod")); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public String getText(Object object) {
        PatternMethod method = (PatternMethod) object;
        String label = method.getName();
        String type = getString("_UI_PatternMethod_type"); //$NON-NLS-1$
        if (method.getPattern() != null && method.getPattern().eGet(PatternPackage.Literals.PATTERN__HEADER_METHOD) == method) {
            type = getString("_UI_Pattern_headerMethod_feature") + " " + type; //$NON-NLS-1$ //$NON-NLS-2$
        } else if (method.getPattern() != null && method.getPattern().eGet(PatternPackage.Literals.PATTERN__FOOTER_METHOD) == method) {
            type = getString("_UI_Pattern_footerMethod_feature") + " " + type; //$NON-NLS-1$ //$NON-NLS-2$
        } else if (method.getPattern() != null && method.getPattern().eGet(PatternPackage.Literals.PATTERN__METHODS) != null) {
            @SuppressWarnings("unchecked")
            EList<PatternMethod> list = (EList<PatternMethod>) method.getPattern().eGet(PatternPackage.Literals.PATTERN__METHODS);
            if (list.contains(method)) {
                type = getString("_UI_Pattern_methods_feature") + " " + type; //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
        return label == null || label.length() == 0 ? type : type + " " + label; //$NON-NLS-1$
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);

        switch (notification.getFeatureID(PatternMethod.class)) {
            case PatternPackage.PATTERN_METHOD__PATTERN_FILE_PATH:
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
        return EGFModelEditPlugin.INSTANCE;
    }

}
