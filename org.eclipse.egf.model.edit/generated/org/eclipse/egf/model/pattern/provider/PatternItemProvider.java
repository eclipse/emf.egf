/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.pattern.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternFactory;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
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
 * This is the item provider adapter for a
 * {@link org.eclipse.egf.model.pattern.Pattern} object. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class PatternItemProvider extends PatternElementItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider, ITableItemColorProvider, ITableItemFontProvider, IItemColorProvider, IItemFontProvider {
  /**
   * This constructs an instance from a factory and a notifier. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public PatternItemProvider(AdapterFactory adapterFactory) {
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

      addHeaderMethodPropertyDescriptor(object);
      addFooterMethodPropertyDescriptor(object);
      addSuperPatternPropertyDescriptor(object);
      addOrchestrationPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Header Method feature. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected void addHeaderMethodPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Pattern_headerMethod_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Pattern_headerMethod_feature", "_UI_Pattern_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        PatternPackage.Literals.PATTERN__HEADER_METHOD, true, false, true, null, null, null) {

      @Override
      public Collection<?> getChoiceOfValues(Object object) {
        Pattern pattern = (Pattern) object;
        EList<PatternMethod> methods = pattern.getMethods();
        if (pattern.getFooterMethod() != null) {
          methods.remove(pattern.getFooterMethod());
        }
        return pattern.getMethods();
      }

    });
  }

  /**
   * This adds a property descriptor for the Footer Method feature. <!--
   * begin-user-doc --> <!-- end-user-doc -->
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
      public Collection<?> getChoiceOfValues(Object object) {
        Pattern pattern = (Pattern) object;
        EList<PatternMethod> methods = pattern.getMethods();
        if (pattern.getHeaderMethod() != null) {
          methods.remove(pattern.getHeaderMethod());
        }
        return pattern.getMethods();
      }

    });
  }

  /**
   * This adds a property descriptor for the Super Pattern feature. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected void addSuperPatternPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Pattern_superPattern_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Pattern_superPattern_feature", "_UI_Pattern_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        PatternPackage.Literals.PATTERN__SUPER_PATTERN, true, false, true, null, null, null));
  }

  /**
   * This adds a property descriptor for the Orchestration feature. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected void addOrchestrationPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Pattern_orchestration_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Pattern_orchestration_feature", "_UI_Pattern_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        PatternPackage.Literals.PATTERN__ORCHESTRATION, true, false, false, null, null, null));
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce
   * an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand},
   * {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
    if (childrenFeatures == null) {
      super.getChildrenFeatures(object);
      childrenFeatures.add(PatternPackage.Literals.PATTERN__METHODS);
      childrenFeatures.add(PatternPackage.Literals.PATTERN__PARAMETERS);
      childrenFeatures.add(PatternPackage.Literals.PATTERN__NATURE);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child) {
    // Check the type of the specified child object and return the proper
    // feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns Pattern.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Pattern")); //$NON-NLS-1$
  }

  /**
   * This returns the label text for the adapted class. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String getText(Object object) {
    String label = ((Pattern) object).getName();
    return label == null || label.length() == 0 ? "[" + getString("_UI_Pattern_type") + "]" : //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        label + " [" + getString("_UI_Pattern_type") + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to
   * update any cached children and by creating a viewer notification, which it
   * passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification) {
    updateChildren(notification);

    switch (notification.getFeatureID(Pattern.class)) {
    case PatternPackage.PATTERN__HEADER_METHOD:
    case PatternPackage.PATTERN__FOOTER_METHOD:
    case PatternPackage.PATTERN__SUPER_PATTERN:
    case PatternPackage.PATTERN__ORCHESTRATION:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
      return;
    case PatternPackage.PATTERN__METHODS:
    case PatternPackage.PATTERN__PARAMETERS:
    case PatternPackage.PATTERN__NATURE:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
      return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing
   * the children that can be created under this object. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
    super.collectNewChildDescriptors(newChildDescriptors, object);

    newChildDescriptors.add(createChildParameter(PatternPackage.Literals.PATTERN__METHODS, PatternFactory.eINSTANCE.createPatternMethod()));

    newChildDescriptors.add(createChildParameter(PatternPackage.Literals.PATTERN__PARAMETERS, PatternFactory.eINSTANCE.createPatternParameter()));
  }

}
