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

import org.eclipse.egf.common.helper.ClassHelper;
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.model.fcore.OrchestrationContext;
import org.eclipse.egf.model.types.TypeBigDecimal;
import org.eclipse.egf.model.types.TypeBigInteger;
import org.eclipse.egf.model.types.TypeBoolean;
import org.eclipse.egf.model.types.TypeByte;
import org.eclipse.egf.model.types.TypeCharacter;
import org.eclipse.egf.model.types.TypeCollection;
import org.eclipse.egf.model.types.TypeDate;
import org.eclipse.egf.model.types.TypeDouble;
import org.eclipse.egf.model.types.TypeFloat;
import org.eclipse.egf.model.types.TypeGeneratorAdapterFactory;
import org.eclipse.egf.model.types.TypeInteger;
import org.eclipse.egf.model.types.TypeList;
import org.eclipse.egf.model.types.TypeLong;
import org.eclipse.egf.model.types.TypeMap;
import org.eclipse.egf.model.types.TypeSet;
import org.eclipse.egf.model.types.TypeShort;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.model.types.TypesFactory;
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
 * This is the item provider adapter for a {@link org.eclipse.egf.model.fcore.InvocationContext}
 * object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class InvocationContextItemProvider extends ModelElementItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider, ITableItemColorProvider, ITableItemFontProvider, IItemColorProvider, IItemFontProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public InvocationContextItemProvider(AdapterFactory adapterFactory) {
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

      addFactoryComponentExposedContractPropertyDescriptor(object);
      addOrchestrationContextPropertyDescriptor(object);
      addActivityContractPropertyDescriptor(object);
      addModePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Exposed Contract feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected void addFactoryComponentExposedContractPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_InvocationContext_factoryComponentExposedContract_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_InvocationContext_factoryComponentExposedContract_feature", "_UI_InvocationContext_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.INVOCATION_CONTEXT__FACTORY_COMPONENT_EXPOSED_CONTRACT, true, false, true, null, getString("_UI_ContextPropertyCategory"), //$NON-NLS-1$
        null) {
      @Override
      public Collection<?> getChoiceOfValues(Object current) {
        InvocationContext invocationContext = (InvocationContext) current;
        Collection<ActivityContract> result = new UniqueEList<ActivityContract>();
        if (result.contains(null) == false) {
          result.add(null);
        }
        // Nothing to retrieve
        if (invocationContext.getFactoryComponent() == null || invocationContext.getActivityContract() == null || invocationContext.getActivityContract().getType() == null) {
          return result;
        }
        // If an orchestration context is already assigned, InvocationContext in In mode are not
        // assignable
        if (invocationContext.getOrchestrationContext() != null && invocationContext.getMode() == ContractMode.IN) {
          return result;
        }
        // Retrieve all the typed contracts if available
        if (invocationContext.getMode() == ContractMode.IN) {
          result.addAll(invocationContext.getFactoryComponent().getActivityContracts(invocationContext.getActivityContract().getType(), ContractMode.IN));
        } else {
          // In or In_Out Contract should have only one assigned InvocationContext.
          for (ActivityContract activityContract : invocationContext.getFactoryComponent().getActivityContracts(invocationContext.getActivityContract().getType(), invocationContext.getMode())) {
            if (((FactoryComponentContract) activityContract).getInvocationContexts().size() == 0) {
              result.add(activityContract);
            }
          }
        }
        // If an orchestration context is already assigned, InvocationContext in In_Out mode are
        // only assignable to Out Mode Contract
        if (invocationContext.getOrchestrationContext() != null && invocationContext.getMode() == ContractMode.IN_OUT) {
          for (Iterator<ActivityContract> it = result.iterator(); it.hasNext();) {
            ActivityContract activityContract = it.next();
            if (activityContract.getMode() != ContractMode.OUT) {
              it.remove();
            }
          }
          return result;
        }
        return result;
      }
    });
  }

  /**
   * This adds a property descriptor for the Orchestration Context feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected void addOrchestrationContextPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_InvocationContext_orchestrationContext_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_InvocationContext_orchestrationContext_feature", "_UI_InvocationContext_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.INVOCATION_CONTEXT__ORCHESTRATION_CONTEXT, true, false, true, null, getString("_UI_ContextPropertyCategory"), //$NON-NLS-1$
        null) {
      @Override
      public Collection<?> getChoiceOfValues(Object current) {
        InvocationContext invocationContext = (InvocationContext) current;
        Collection<OrchestrationContext> result = new UniqueEList<OrchestrationContext>();
        if (result.contains(null) == false) {
          result.add(null);
        }
        // Nothing to retrieve
        if (invocationContext.getFactoryComponent() == null || invocationContext.getFactoryComponent().getOrchestration() == null || invocationContext.getActivityContract() == null || invocationContext.getActivityContract().getType() == null) {
          return result;
        }
        // InvocationContext in Out mode are not assignable
        if (invocationContext.getMode() == ContractMode.OUT) {
          return result;
        }
        // InvocationContract already assigned to an exposed contract should in be In_Out mode
        if (invocationContext.getFactoryComponentExposedContract() != null && invocationContext.getMode() != ContractMode.IN_OUT) {
          return result;
        }
        // Retrieve all compatible typed OrchestrationContext
        result.addAll(invocationContext.getFactoryComponent().getOrchestration().getOrchestrationContexts(invocationContext.getActivityContract().getType()));
        return result;
      }
    });
  }

  /**
   * This adds a property descriptor for the Activity Contract feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected void addActivityContractPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_InvocationContext_activityContract_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_InvocationContext_activityContract_feature", "_UI_InvocationContext_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.INVOCATION_CONTEXT__ACTIVITY_CONTRACT, true, false, true, null, getString("_UI_InvokePropertyCategory"), //$NON-NLS-1$
        null) {
      @Override
      public Collection<?> getChoiceOfValues(Object current) {
        InvocationContext invocationContext = (InvocationContext) current;
        Collection<ActivityContract> result = new UniqueEList<ActivityContract>();
        // Retrieve all the typed contracts if available
        if (invocationContext.getInvocation() != null && invocationContext.getInvocation().getActivity() != null) {
          // Type filtering
          if (invocationContext.getType() != null) {
            if (invocationContext.getFactoryComponentExposedContract() != null) {
              result.addAll(invocationContext.getInvocation().getActivity().getActivityContracts(invocationContext.getType(), invocationContext.getFactoryComponentExposedContract().getMode()));
            } else {
              result.addAll(invocationContext.getInvocation().getActivity().getActivityContracts(invocationContext.getType()));
            }
            // Filter all assigned contracts if necessary
            if (result.size() > 0) {
              for (ActivityContract innerContract : invocationContext.getInvocation().getInvocationActivityContracts(invocationContext.getType())) {
                result.remove(innerContract);
              }
            }
          } else {
            if (invocationContext.getFactoryComponentExposedContract() != null) {
              result.addAll(invocationContext.getInvocation().getActivity().getActivityContracts(invocationContext.getFactoryComponentExposedContract().getMode()));
            } else {
              result.addAll(invocationContext.getInvocation().getActivity().getActivityContracts());
            }
            // Filter all assigned contracts if necessary
            if (result.size() > 0) {
              for (ActivityContract innerContract : invocationContext.getInvocation().getInvocationActivityContracts()) {
                result.remove(innerContract);
              }
            }
          }
        }
        if (result.contains(null) == false) {
          result.add(null);
        }
        return result;
      }
    });
  }

  /**
   * This adds a property descriptor for the Mode feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  protected void addModePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_InvocationContext_mode_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_InvocationContext_mode_feature", "_UI_InvocationContext_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.INVOCATION_CONTEXT__MODE, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_InvokePropertyCategory"), //$NON-NLS-1$
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
      childrenFeatures.add(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE);
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
   * This returns InvocationContext.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/InvocationContext")); //$NON-NLS-1$
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
    InvocationContext context = (InvocationContext) object;
    String label = context.getName();
    String mode = null;
    if (context.getMode() != null) {
      mode = "[" + context.getMode().getLiteral() + "]"; //$NON-NLS-1$ //$NON-NLS-2$
    }
    if (label == null || label.length() == 0) {
      label = "[" + getString("_UI_InvocationContext_type") + "]";//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
      if (mode != null) {
        label = mode + " " + label; //$NON-NLS-1$
      }
    } else {
      if (mode != null) {
        label = label + " " + mode + " [" + getString("_UI_InvocationContext_type") + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
      } else {
        label = label + " [" + getString("_UI_InvocationContext_type") + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
      }
    }
    return label;
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

    switch (notification.getFeatureID(InvocationContext.class)) {
    case FcorePackage.INVOCATION_CONTEXT__ACTIVITY_CONTRACT:
    case FcorePackage.INVOCATION_CONTEXT__MODE:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
      return;
    case FcorePackage.INVOCATION_CONTEXT__TYPE:
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
   * @generated NOT
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {

    super.collectNewChildDescriptors(newChildDescriptors, object);

    if (object instanceof InvocationContext == false) {
      return;
    }
    InvocationContext invocationContext = (InvocationContext) object;

    if (invocationContext.getActivityContract() == null || invocationContext.getActivityContract().getType() == null) {
      return;
    }

    {
      TypeCollection type = TypesFactory.eINSTANCE.createTypeCollection();
      if (ClassHelper.asSubClass(type.getType(), invocationContext.getActivityContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, type));
      }
    }

    {
      TypeList type = TypesFactory.eINSTANCE.createTypeList();
      if (ClassHelper.asSubClass(type.getType(), invocationContext.getActivityContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, type));
      }
    }

    {
      TypeSet type = TypesFactory.eINSTANCE.createTypeSet();
      if (ClassHelper.asSubClass(type.getType(), invocationContext.getActivityContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, type));
      }
    }

    {
      TypeMap type = TypesFactory.eINSTANCE.createTypeMap();
      if (ClassHelper.asSubClass(type.getType(), invocationContext.getActivityContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, type));
      }
    }

    {
      TypeBigDecimal type = TypesFactory.eINSTANCE.createTypeBigDecimal();
      if (ClassHelper.asSubClass(type.getType(), invocationContext.getActivityContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, type));
      }
    }

    {
      TypeBigInteger type = TypesFactory.eINSTANCE.createTypeBigInteger();
      if (ClassHelper.asSubClass(type.getType(), invocationContext.getActivityContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, type));
      }
    }

    {
      TypeBoolean type = TypesFactory.eINSTANCE.createTypeBoolean();
      if (ClassHelper.asSubClass(type.getType(), invocationContext.getActivityContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, type));
      }
    }

    {
      TypeByte type = TypesFactory.eINSTANCE.createTypeByte();
      if (ClassHelper.asSubClass(type.getType(), invocationContext.getActivityContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, type));
      }
    }

    {
      TypeCharacter type = TypesFactory.eINSTANCE.createTypeCharacter();
      if (ClassHelper.asSubClass(type.getType(), invocationContext.getActivityContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, type));
      }
    }

    {
      TypeDate type = TypesFactory.eINSTANCE.createTypeDate();
      if (ClassHelper.asSubClass(type.getType(), invocationContext.getActivityContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, type));
      }
    }

    {
      TypeDouble type = TypesFactory.eINSTANCE.createTypeDouble();
      if (ClassHelper.asSubClass(type.getType(), invocationContext.getActivityContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, type));
      }
    }

    {
      TypeFloat type = TypesFactory.eINSTANCE.createTypeFloat();
      if (ClassHelper.asSubClass(type.getType(), invocationContext.getActivityContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, type));
      }
    }

    {
      TypeInteger type = TypesFactory.eINSTANCE.createTypeInteger();
      if (ClassHelper.asSubClass(type.getType(), invocationContext.getActivityContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, type));
      }
    }

    {
      TypeLong type = TypesFactory.eINSTANCE.createTypeLong();
      if (ClassHelper.asSubClass(type.getType(), invocationContext.getActivityContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, type));
      }
    }

    {
      TypeShort type = TypesFactory.eINSTANCE.createTypeShort();
      if (ClassHelper.asSubClass(type.getType(), invocationContext.getActivityContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, type));
      }
    }

    {
      TypeString type = TypesFactory.eINSTANCE.createTypeString();
      if (ClassHelper.asSubClass(type.getType(), invocationContext.getActivityContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, type));
      }
    }

    {
      TypeGeneratorAdapterFactory type = TypesFactory.eINSTANCE.createTypeGeneratorAdapterFactory();
      if (ClassHelper.asSubClass(type.getType(), invocationContext.getActivityContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, type));
      }
    }

  }

}
