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
package org.eclipse.egf.model.fcore.provider;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.UniqueEList;
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
 * This is the item provider adapter for a {@link org.eclipse.egf.model.fcore.Contract} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ContractItemProvider extends ModelElementItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider, ITableItemColorProvider, ITableItemFontProvider, IItemColorProvider, IItemFontProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public ContractItemProvider(AdapterFactory adapterFactory) {
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

      addInvocationContextsPropertyDescriptor(object);
      addMandatoryPropertyDescriptor(object);
      addModePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Invocation Contexts feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected void addInvocationContextsPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Contract_invocationContexts_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Contract_invocationContexts_feature", "_UI_Contract_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.CONTRACT__INVOCATION_CONTEXTS, true, false, true, null, getString("_UI_ContextPropertyCategory"), null) { //$NON-NLS-1$
          @Override
          public Collection<?> getChoiceOfValues(Object current) {
            Contract contract = (Contract) current;
            Collection<InvocationContext> result = new UniqueEList<InvocationContext>();
            // Nothing to retrieve
            if (contract.getType() == null || contract.getActivity() == null || contract.getActivity() instanceof FactoryComponent == false) {
              return result;
            }
            FactoryComponent factoryComponent = (FactoryComponent) contract.getActivity();
            // Out or In_Out should have only one assigned InvocationContext
            if (contract.getMode() != ContractMode.IN && contract.getInvocationContexts().size() != 0) {
              return result;
            }
            // Retrieve all the InvocationContexts based on their types and mode
            result.addAll(factoryComponent.getInvocationContexts(contract.getType(), contract.getMode()));
            if (result.size() > 0) {
              // Filter invocation context already assigned to an orchestration context
              for (Iterator<InvocationContext> it = result.iterator(); it.hasNext();) {
                InvocationContext invocationContext = it.next();
                // an In_Out could either be in an orchestration context with an In semantic and
                // in a Contract with an Out semantic but not both
                if (invocationContext.getOrchestrationContext() != null && contract.getMode() != ContractMode.OUT) {
                  it.remove();
                }
              }
              // Filter invocation context already assigned to a contract
              for (Contract innerContract : factoryComponent.getContracts(contract.getType(), contract.getMode())) {
                if (contract == innerContract) {
                  continue;
                }
                for (InvocationContext invocationContext : contract.getInvocationContexts()) {
                  result.remove(invocationContext);
                }
              }
            }
            return result;
          }
        });
  }

  /**
   * This adds a property descriptor for the Mandatory feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected void addMandatoryPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Contract_mandatory_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Contract_mandatory_feature", "_UI_Contract_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.CONTRACT__MANDATORY, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString("_UI_TypePropertyCategory"), //$NON-NLS-1$
        null));
  }

  /**
   * This adds a property descriptor for the Mode feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected void addModePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Contract_mode_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Contract_mode_feature", "_UI_Contract_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.CONTRACT__MODE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_TypePropertyCategory"), //$NON-NLS-1$
        null));
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate
   * feature for an {@link org.eclipse.emf.edit.command.AddCommand},
   * {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
    if (childrenFeatures == null) {
      super.getChildrenFeatures(object);
      childrenFeatures.add(FcorePackage.Literals.CONTRACT__TYPE);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child) {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns Contract.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Contract")); //$NON-NLS-1$
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
    String label = ((Contract) object).getName();
    return label == null || label.length() == 0 ? "[" + ((Contract) object).getMode().getLiteral() + "] [" + getString("_UI_Contract_type") + "]" : //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        label + " [" + ((Contract) object).getMode().getLiteral() + "] [" + getString("_UI_Contract_type") + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
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

    switch (notification.getFeatureID(Contract.class)) {
    case FcorePackage.CONTRACT__MANDATORY:
    case FcorePackage.CONTRACT__MODE:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
      return;
    case FcorePackage.CONTRACT__TYPE:
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
   * 
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
    super.collectNewChildDescriptors(newChildDescriptors, object);
  }

}
