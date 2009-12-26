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

import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.UniqueEList;
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

/**
 * This is the item provider adapter for a {@link org.eclipse.egf.model.fcore.FactoryComponentContract} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FactoryComponentContractItemProvider extends ActivityContractItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider, ITableItemColorProvider, ITableItemFontProvider, IItemColorProvider, IItemFontProvider {
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

      addInvocationContextsPropertyDescriptor(object);
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
    itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_FactoryComponentContract_invocationContexts_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_FactoryComponentContract_invocationContexts_feature", "_UI_FactoryComponentContract_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.FACTORY_COMPONENT_CONTRACT__INVOCATION_CONTEXTS, true, false, true, null, getString("_UI_ContextPropertyCategory"), null) { //$NON-NLS-1$
          @Override
          public Collection<?> getChoiceOfValues(Object current) {
            FactoryComponentContract factoryComponentContract = (FactoryComponentContract) current;
            Collection<InvocationContext> result = new UniqueEList<InvocationContext>();
            // Nothing to retrieve
            if (factoryComponentContract.getType() == null || factoryComponentContract.getActivity() == null) {
              return result;
            }
            FactoryComponent factoryComponent = factoryComponentContract.getActivity();
            // Out or In_Out should have only one assigned InvocationContext
            if (factoryComponentContract.getMode() != ContractMode.IN && factoryComponentContract.getInvocationContexts().size() != 0) {
              return result;
            }
            // Retrieve all the InvocationContexts based on their types and mode
            result.addAll(factoryComponent.getInvocationContexts(factoryComponentContract.getType(), factoryComponentContract.getMode()));
            if (result.size() > 0) {
              // Filter invocation context already assigned to an orchestration context
              for (Iterator<InvocationContext> it = result.iterator(); it.hasNext();) {
                InvocationContext invocationContext = it.next();
                // an In_Out could either be in an orchestration context with an In semantic and
                // in a Contract with an Out semantic but not both
                if (invocationContext.getOrchestrationContext() != null && factoryComponentContract.getMode() != ContractMode.OUT) {
                  it.remove();
                }
              }
              // Filter invocation context already assigned to a contract
              for (ActivityContract innerContract : factoryComponent.getActivityContracts(factoryComponentContract.getType(), factoryComponentContract.getMode())) {
                if (factoryComponentContract == innerContract) {
                  continue;
                }
                for (InvocationContext invocationContext : ((FactoryComponentContract) innerContract).getInvocationContexts()) {
                  result.remove(invocationContext);
                }
              }
            }
            return result;
          }
        });
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
