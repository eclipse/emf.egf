/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.pattern.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternFactory;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.commands.PatternAddPatternMethodCommand;
import org.eclipse.egf.model.pattern.commands.PatternCopyCommand;
import org.eclipse.egf.model.pattern.commands.PatternCreateCopyCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
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
 * This is the item provider adapter for a {@link org.eclipse.egf.model.pattern.Pattern} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PatternItemProvider extends PatternElementItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider, ITableItemColorProvider, ITableItemFontProvider, IItemColorProvider, IItemFontProvider {

    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PatternItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Header Method feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addHeaderMethodPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Pattern_headerMethod_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_Pattern_headerMethod_feature", "_UI_Pattern_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                PatternPackage.Literals.PATTERN__HEADER_METHOD, true, false, true, null, null, null) {

            @Override
            public Collection<?> getChoiceOfValues(Object current) {
                Pattern pattern = (Pattern) current;
                EList<PatternMethod> result = new UniqueEList<PatternMethod>();
                // add a null value to reset an existing value
                result.add(null);
                // Load existing methods
                result.addAll(pattern.getMethods());
                if (pattern.getFooterMethod() != null) {
                    result.remove(pattern.getFooterMethod());
                }
                return result;
            }

        });
    }

    /**
     * This adds a property descriptor for the Footer Method feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addFooterMethodPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Pattern_footerMethod_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$ 
                        "_UI_Pattern_footerMethod_feature", //$NON-NLS-1$
                        "_UI_Pattern_type" //$NON-NLS-1$
                ), PatternPackage.Literals.PATTERN__FOOTER_METHOD, true, false, true, null, null, null) {

            @Override
            public Collection<?> getChoiceOfValues(Object current) {
                Pattern pattern = (Pattern) current;
                EList<PatternMethod> result = new UniqueEList<PatternMethod>();
                // add a null value to reset an existing value
                result.add(null);
                // Load existing methods
                result.addAll(pattern.getMethods());
                if (pattern.getHeaderMethod() != null) {
                    result.remove(pattern.getHeaderMethod());
                }
                return result;
            }

        });
    }

    /**
     * This adds a property descriptor for the Super Pattern feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSuperPatternPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Pattern_superPattern_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_Pattern_superPattern_feature", "_UI_Pattern_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                PatternPackage.Literals.PATTERN__SUPER_PATTERN, true, false, true, null, getString("_UI_ParentPropertyCategory"), //$NON-NLS-1$
                null));
    }

    /**
     * This adds a property descriptor for the Nature feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addNaturePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Pattern_nature_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_Pattern_nature_feature", "_UI_Pattern_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                PatternPackage.Literals.PATTERN__NATURE, true, false, true, null, getString("_UI_PatternPropertyCategory"), //$NON-NLS-1$
                null));
    }

    /**
     * This adds a property descriptor for the Init Method feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addInitMethodPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Pattern_initMethod_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_Pattern_initMethod_feature", "_UI_Pattern_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                PatternPackage.Literals.PATTERN__INIT_METHOD, true, false, true, null, getString("_UI_MethodPropertyCategory"), //$NON-NLS-1$
                null));
    }

    /**
     * This adds a property descriptor for the Condition Method feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addConditionMethodPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Pattern_conditionMethod_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_Pattern_conditionMethod_feature", "_UI_Pattern_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                PatternPackage.Literals.PATTERN__CONDITION_METHOD, true, false, true, null, null, null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to
     * deduce an appropriate feature for an {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
        if (childrenFeatures == null) {
            childrenFeatures = new ArrayList<EStructuralFeature>();
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
     * This returns Pattern.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/Pattern")); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((Pattern) object).getName();
        return label == null || label.length() == 0 ? "[" + getString("_UI_Pattern_type") + "]" : //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                label + " [" + getString("_UI_Pattern_type") + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
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

        switch (notification.getFeatureID(Pattern.class)) {
        case PatternPackage.PATTERN__NATURE:
        case PatternPackage.PATTERN__SUPER_PATTERN:
        case PatternPackage.PATTERN__HEADER_METHOD:
        case PatternPackage.PATTERN__INIT_METHOD:
        case PatternPackage.PATTERN__FOOTER_METHOD:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        case PatternPackage.PATTERN__METHODS:
        case PatternPackage.PATTERN__PARAMETERS:
        case PatternPackage.PATTERN__VARIABLES:
        case PatternPackage.PATTERN__ORCHESTRATION:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
            return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
     * describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        // Nothing to do
    }

    /**
     * This creates a primitive {@link org.eclipse.emf.edit.command.CopyCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    protected Command createCopyCommand(EditingDomain domain, EObject owner, CopyCommand.Helper helper) {
        return new PatternCopyCommand(domain, (Pattern) owner, helper, domain.getOptimizeCopy());
    }

    /**
     * This creates a primitive {@link org.eclipse.emf.edit.command.CreateCopyCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT 
     */
    @Override
    protected Command createCreateCopyCommand(EditingDomain domain, EObject owner, CopyCommand.Helper helper) {
        return new PatternCreateCopyCommand(domain, (Pattern) owner, helper);
    }

    /**
     * This creates a primitive {@link org.eclipse.emf.edit.command.AddCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    protected Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Collection<?> collection, int index) {
        if (feature != PatternPackage.Literals.PATTERN__METHODS) {
            return super.createAddCommand(domain, owner, feature, collection, index);
        }
        return new PatternAddPatternMethodCommand(domain, (Pattern) owner, collection, index);
    }

}
