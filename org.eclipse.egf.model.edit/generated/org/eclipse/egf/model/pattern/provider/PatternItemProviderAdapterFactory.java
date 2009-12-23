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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.egf.model.edit.EGFModelsEditPlugin;

import org.eclipse.egf.model.factorycomponent.FactoryComponentPackage;
import org.eclipse.egf.model.factorycomponent.ViewpointContainer;

import org.eclipse.egf.model.factorycomponent.util.FactoryComponentSwitch;

import org.eclipse.egf.model.pattern.PatternFactory;

import org.eclipse.egf.model.pattern.util.PatternAdapterFactory;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.command.CommandParameter;

import org.eclipse.emf.edit.domain.EditingDomain;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemColorProvider;
import org.eclipse.emf.edit.provider.ITableItemFontProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PatternItemProviderAdapterFactory extends PatternAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier,
    IDisposable {
  /**
   * This keeps track of the root adapter factory that delegates to this adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComposedAdapterFactory parentAdapterFactory;

  /**
   * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IChangeNotifier changeNotifier = new ChangeNotifier();

  /**
   * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Collection<Object> supportedTypes = new ArrayList<Object>();

  /**
   * This constructs an instance.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternItemProviderAdapterFactory() {
    supportedTypes.add(IEditingDomainItemProvider.class);
    supportedTypes.add(IStructuredItemContentProvider.class);
    supportedTypes.add(ITreeItemContentProvider.class);
    supportedTypes.add(IItemLabelProvider.class);
    supportedTypes.add(IItemPropertySource.class);
    supportedTypes.add(ITableItemLabelProvider.class);
    supportedTypes.add(ITableItemColorProvider.class);
    supportedTypes.add(ITableItemFontProvider.class);
    supportedTypes.add(IItemColorProvider.class);
    supportedTypes.add(IItemFontProvider.class);
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.Pattern} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PatternItemProvider patternItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.egf.model.pattern.Pattern}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createPatternAdapter() {
    if (patternItemProvider == null) {
      patternItemProvider = new PatternItemProvider(this);
    }

    return patternItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.PatternMethod} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PatternMethodItemProvider patternMethodItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.egf.model.pattern.PatternMethod}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createPatternMethodAdapter() {
    if (patternMethodItemProvider == null) {
      patternMethodItemProvider = new PatternMethodItemProvider(this);
    }

    return patternMethodItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.PatternParameter} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PatternParameterItemProvider patternParameterItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.egf.model.pattern.PatternParameter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createPatternParameterAdapter() {
    if (patternParameterItemProvider == null) {
      patternParameterItemProvider = new PatternParameterItemProvider(this);
    }

    return patternParameterItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.PatternSuperMethod} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PatternSuperMethodItemProvider patternSuperMethodItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.egf.model.pattern.PatternSuperMethod}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createPatternSuperMethodAdapter() {
    if (patternSuperMethodItemProvider == null) {
      patternSuperMethodItemProvider = new PatternSuperMethodItemProvider(this);
    }

    return patternSuperMethodItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.PatternLibrary} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PatternLibraryItemProvider patternLibraryItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.egf.model.pattern.PatternLibrary}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createPatternLibraryAdapter() {
    if (patternLibraryItemProvider == null) {
      patternLibraryItemProvider = new PatternLibraryItemProvider(this);
    }

    return patternLibraryItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.PatternViewpoint} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PatternViewpointItemProvider patternViewpointItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.egf.model.pattern.PatternViewpoint}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createPatternViewpointAdapter() {
    if (patternViewpointItemProvider == null) {
      patternViewpointItemProvider = new PatternViewpointItemProvider(this);
    }

    return patternViewpointItemProvider;
  }

  /**
   * This returns the root adapter factory that contains this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComposeableAdapterFactory getRootAdapterFactory() {
    return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
  }

  /**
   * This sets the composed adapter factory that contains this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
    this.parentAdapterFactory = parentAdapterFactory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object type) {
    return supportedTypes.contains(type) || super.isFactoryForType(type);
  }

  /**
   * This implementation substitutes the factory itself as the key for the adapter.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter adapt(Notifier notifier, Object type) {
    return super.adapt(notifier, this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object adapt(Object object, Object type) {
    if (isFactoryForType(type)) {
      Object adapter = super.adapt(object, type);
      if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
        return adapter;
      }
    }

    return null;
  }

  /**
   * This adds a listener.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void addListener(INotifyChangedListener notifyChangedListener) {
    changeNotifier.addListener(notifyChangedListener);
  }

  /**
   * This removes a listener.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void removeListener(INotifyChangedListener notifyChangedListener) {
    changeNotifier.removeListener(notifyChangedListener);
  }

  /**
   * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void fireNotifyChanged(Notification notification) {
    changeNotifier.fireNotifyChanged(notification);

    if (parentAdapterFactory != null) {
      parentAdapterFactory.fireNotifyChanged(notification);
    }
  }

  /**
   * This disposes all of the item providers created by this factory. 
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void dispose() {
    if (patternItemProvider != null)
      patternItemProvider.dispose();
    if (patternMethodItemProvider != null)
      patternMethodItemProvider.dispose();
    if (patternParameterItemProvider != null)
      patternParameterItemProvider.dispose();
    if (patternSuperMethodItemProvider != null)
      patternSuperMethodItemProvider.dispose();
    if (patternLibraryItemProvider != null)
      patternLibraryItemProvider.dispose();
    if (patternViewpointItemProvider != null)
      patternViewpointItemProvider.dispose();
  }

  /**
   * A child creation extender for the {@link FactoryComponentPackage}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static class FactoryComponentChildCreationExtender implements IChildCreationExtender {
    /**
     * The switch for creating child descriptors specific to each extended class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static class CreationSwitch extends FactoryComponentSwitch<Object> {
      /**
       * The child descriptors being populated.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      protected List<Object> newChildDescriptors;

      /**
       * The domain in which to create the children.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      protected EditingDomain editingDomain;

      /**
       * Creates the a switch for populating child descriptors in the given domain.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) {
        this.newChildDescriptors = newChildDescriptors;
        this.editingDomain = editingDomain;
      }

      /**
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      @Override
      public Object caseViewpointContainer(ViewpointContainer object) {
        newChildDescriptors.add(createChildParameter(FactoryComponentPackage.Literals.VIEWPOINT_CONTAINER__VIEWPOINTS,
            PatternFactory.eINSTANCE.createPatternViewpoint()));

        return null;
      }

      /**
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      protected CommandParameter createChildParameter(Object feature, Object child) {
        return new CommandParameter(null, feature, child);
      }

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
      ArrayList<Object> result = new ArrayList<Object>();
      new CreationSwitch(result, editingDomain).doSwitch((EObject) object);
      return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceLocator getResourceLocator() {
      return EGFModelsEditPlugin.INSTANCE;
    }
  }

}
