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

import java.util.Collection;
import java.util.List;

import org.eclipse.egf.common.helper.ClassHelper;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fcore.helper.InvocationContractHelper;
import org.eclipse.egf.model.types.TypeAbstractClass;
import org.eclipse.egf.model.types.TypeBigDecimal;
import org.eclipse.egf.model.types.TypeBigInteger;
import org.eclipse.egf.model.types.TypeBoolean;
import org.eclipse.egf.model.types.TypeByte;
import org.eclipse.egf.model.types.TypeCharacter;
import org.eclipse.egf.model.types.TypeCollection;
import org.eclipse.egf.model.types.TypeDate;
import org.eclipse.egf.model.types.TypeDouble;
import org.eclipse.egf.model.types.TypeFloat;
import org.eclipse.egf.model.types.TypeInteger;
import org.eclipse.egf.model.types.TypeList;
import org.eclipse.egf.model.types.TypeLong;
import org.eclipse.egf.model.types.TypeMap;
import org.eclipse.egf.model.types.TypeSet;
import org.eclipse.egf.model.types.TypeShort;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.model.types.TypeURI;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
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
 * This is the item provider adapter for a {@link org.eclipse.egf.model.fcore.InvocationContract} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class InvocationContractItemProvider extends ModelElementItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider, ITableItemColorProvider, ITableItemFontProvider,
    IItemColorProvider, IItemFontProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public InvocationContractItemProvider(AdapterFactory adapterFactory) {
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

      addFactoryComponentContractPropertyDescriptor(object);
      addOrchestrationParameterPropertyDescriptor(object);
      addSourceInvocationContractPropertyDescriptor(object);
      addTargetInvocationContractPropertyDescriptor(object);
      addInvokedContractPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Factory Component Contract feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected void addFactoryComponentContractPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_InvocationContract_factoryComponentContract_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_InvocationContract_factoryComponentContract_feature", "_UI_InvocationContract_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.INVOCATION_CONTRACT__FACTORY_COMPONENT_CONTRACT, true, false, true, null, getString("_UI_FactoryComponentPropertyCategory"), //$NON-NLS-1$
        null) {
      @Override
      public Collection<?> getChoiceOfValues(Object current) {
        InvocationContract contract = (InvocationContract) current;
        Collection<Contract> available = InvocationContractHelper.getAvailableFactoryComponentContract(contract);
        available.add(null);
        available.add(contract.getFactoryComponentContract());
        return available;
      }
    });
  }

  /**
   * This adds a property descriptor for the Orchestration Parameter feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected void addOrchestrationParameterPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_InvocationContract_orchestrationParameter_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_InvocationContract_orchestrationParameter_feature", "_UI_InvocationContract_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.INVOCATION_CONTRACT__ORCHESTRATION_PARAMETER, true, false, true, null, getString("_UI_OrchestrationPropertyCategory"), //$NON-NLS-1$
        null) {
      @Override
      public Collection<?> getChoiceOfValues(Object current) {
        InvocationContract contract = (InvocationContract) current;
        Collection<OrchestrationParameter> available = InvocationContractHelper.getAvailableOrchestrationParameter(contract);
        available.add(null);
        available.add(contract.getOrchestrationParameter());
        return available;
      }
    });
  }

  /**
   * This adds a property descriptor for the Source Invocation Contract feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected void addSourceInvocationContractPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_InvocationContract_sourceInvocationContract_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_InvocationContract_sourceInvocationContract_feature", "_UI_InvocationContract_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.INVOCATION_CONTRACT__SOURCE_INVOCATION_CONTRACT, true, false, true, null, getString("_UI_ConnectorPropertyCategory"), //$NON-NLS-1$
        null) {
      @Override
      public Collection<?> getChoiceOfValues(Object current) {
        InvocationContract contract = (InvocationContract) current;
        Collection<InvocationContract> available = InvocationContractHelper.getAvailableSourceInvocationContract(contract);
        available.add(null);
        available.add(contract.getSourceInvocationContract());
        return available;
      }
    });
  }

  /**
   * This adds a property descriptor for the Target Invocation Contract feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected void addTargetInvocationContractPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_InvocationContract_targetInvocationContract_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_InvocationContract_targetInvocationContract_feature", "_UI_InvocationContract_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.INVOCATION_CONTRACT__TARGET_INVOCATION_CONTRACT, true, false, true, null, getString("_UI_ConnectorPropertyCategory"), //$NON-NLS-1$
        null) {
      @Override
      public Collection<?> getChoiceOfValues(Object current) {
        return InvocationContractHelper.getAvailableTargetInvocationContract((InvocationContract) current);
      }
    });
  }

  /**
   * This adds a property descriptor for the Invoked Contract feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected void addInvokedContractPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_InvocationContract_invokedContract_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_InvocationContract_invokedContract_feature", "_UI_InvocationContract_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.INVOCATION_CONTRACT__INVOKED_CONTRACT, true, false, true, null, getString("_UI_BehaviourPropertyCategory"), //$NON-NLS-1$
        null) {
      @Override
      public Collection<?> getChoiceOfValues(Object current) {
        InvocationContract contract = (InvocationContract) current;
        Collection<Contract> available = InvocationContractHelper.getAvailableInvokedContract(contract);
        available.add(null);
        available.add(contract.getInvokedContract());
        return available;
      }
    });
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
    if (childrenFeatures == null) {
      super.getChildrenFeatures(object);
      childrenFeatures.add(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE);
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
   * This returns InvocationContract.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/InvocationContract")); //$NON-NLS-1$
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
    InvocationContract invocationContract = (InvocationContract) object;
    String invoked = null;
    if (invocationContract.getInvokedContract() != null) {
      invoked = invocationContract.getInvokedContract().getName();
      String mode = null;
      if (invocationContract.getInvokedContract().getMode() != null) {
        mode = "[" + invocationContract.getInvokedContract().getMode().getLiteral() + "]"; //$NON-NLS-1$ //$NON-NLS-2$
      }
      if ((invoked == null || invoked.length() == 0) && mode != null) {
        invoked = mode;
      } else if (mode != null) {
        invoked = invoked + " " + mode; //$NON-NLS-1$
      }
    }
    String label = "[" + getString("_UI_InvocationContract_type") + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    if (invoked != null) {
      label = invoked + " " + label; //$NON-NLS-1$
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

    switch (notification.getFeatureID(InvocationContract.class)) {
    case FcorePackage.INVOCATION_CONTRACT__FACTORY_COMPONENT_CONTRACT:
    case FcorePackage.INVOCATION_CONTRACT__ORCHESTRATION_PARAMETER:
    case FcorePackage.INVOCATION_CONTRACT__SOURCE_INVOCATION_CONTRACT:
    case FcorePackage.INVOCATION_CONTRACT__TARGET_INVOCATION_CONTRACT:
    case FcorePackage.INVOCATION_CONTRACT__INVOKED_CONTRACT:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
      return;
    case FcorePackage.INVOCATION_CONTRACT__TYPE:
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

    InvocationContract invocationContract = (InvocationContract) object;

    if (invocationContract.getInvokedContract() == null || invocationContract.getInvokedContract().getType() == null) {
      return;
    }

    // This is done once to avoid multiple classloader to be invoked when type is TypeClass
    Class<?> invokedContractType = invocationContract.getInvokedContract().getType().getType();

    {
      if (invocationContract.getInvokedContract().getType() instanceof TypeAbstractClass) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, TypesFactory.eINSTANCE.createTypeClass()));
      }
    }

    {
      TypeCollection type = TypesFactory.eINSTANCE.createTypeCollection();
      if (ClassHelper.asSubClass(type.getType(), invokedContractType)) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeList type = TypesFactory.eINSTANCE.createTypeList();
      if (ClassHelper.asSubClass(type.getType(), invokedContractType)) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeSet type = TypesFactory.eINSTANCE.createTypeSet();
      if (ClassHelper.asSubClass(type.getType(), invokedContractType)) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeMap type = TypesFactory.eINSTANCE.createTypeMap();
      if (ClassHelper.asSubClass(type.getType(), invokedContractType)) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeBigDecimal type = TypesFactory.eINSTANCE.createTypeBigDecimal();
      if (ClassHelper.asSubClass(type.getType(), invokedContractType)) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeBigInteger type = TypesFactory.eINSTANCE.createTypeBigInteger();
      if (ClassHelper.asSubClass(type.getType(), invokedContractType)) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeBoolean type = TypesFactory.eINSTANCE.createTypeBoolean();
      if (ClassHelper.asSubClass(type.getType(), invokedContractType)) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeByte type = TypesFactory.eINSTANCE.createTypeByte();
      if (ClassHelper.asSubClass(type.getType(), invokedContractType)) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeCharacter type = TypesFactory.eINSTANCE.createTypeCharacter();
      if (ClassHelper.asSubClass(type.getType(), invokedContractType)) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeDate type = TypesFactory.eINSTANCE.createTypeDate();
      if (ClassHelper.asSubClass(type.getType(), invokedContractType)) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeDouble type = TypesFactory.eINSTANCE.createTypeDouble();
      if (ClassHelper.asSubClass(type.getType(), invokedContractType)) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeFloat type = TypesFactory.eINSTANCE.createTypeFloat();
      if (ClassHelper.asSubClass(type.getType(), invokedContractType)) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeInteger type = TypesFactory.eINSTANCE.createTypeInteger();
      if (ClassHelper.asSubClass(type.getType(), invokedContractType)) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeLong type = TypesFactory.eINSTANCE.createTypeLong();
      if (ClassHelper.asSubClass(type.getType(), invokedContractType)) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeShort type = TypesFactory.eINSTANCE.createTypeShort();
      if (ClassHelper.asSubClass(type.getType(), invokedContractType)) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeString type = TypesFactory.eINSTANCE.createTypeString();
      if (ClassHelper.asSubClass(type.getType(), invokedContractType)) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeURI type = TypesFactory.eINSTANCE.createTypeURI();
      if (ClassHelper.asSubClass(type.getType(), invokedContractType)) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

  }

}
