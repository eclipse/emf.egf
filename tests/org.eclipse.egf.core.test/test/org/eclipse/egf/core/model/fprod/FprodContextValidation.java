/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.model.fprod;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.model.fcore.InvocationContextContainer;
import org.eclipse.egf.model.fprod.FprodFactory;
import org.eclipse.egf.model.fprod.FprodPackage;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.egf.model.fprod.TaskContract;
import org.eclipse.egf.model.fprod.TaskContractContainer;
import org.eclipse.egf.model.fprod.TaskInvocation;
import org.eclipse.egf.model.types.FloatType;
import org.eclipse.egf.model.types.GeneratorAdapterFactoryType;
import org.eclipse.egf.model.types.IntegerType;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;

public class FprodContextValidation extends TestCase {

  public static Test suite() {
    return new TestSuite(FprodContextValidation.class);
  }

  public void testInContextName() throws Exception {

    // Task Definition

    Task task = FprodFactory.eINSTANCE.createTask();
    task.setValue("org.eclipse.egf.example.task.h1.H1.id"); //$NON-NLS-1$

    TaskContractContainer contracts = FprodFactory.eINSTANCE.createTaskContractContainer();
    task.eSet(FprodPackage.Literals.TASK__ACTIVITY_CONTRACT_CONTAINER, contracts);

    TaskContract quantity = FprodFactory.eINSTANCE.createTaskContract();
    quantity.setName("quantity"); //$NON-NLS-1$
    quantity.setMode(ContractMode.IN);
    contracts.getActivityContracts().add(quantity);

    IntegerType quantityType = TypesFactory.eINSTANCE.createIntegerType();
    quantityType.setValue(100);
    quantity.eSet(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, quantityType);

    TaskContract taskContractPrice = FprodFactory.eINSTANCE.createTaskContract();
    taskContractPrice.setName("price"); //$NON-NLS-1$
    taskContractPrice.setMode(ContractMode.IN);
    contracts.getActivityContracts().add(taskContractPrice);

    FloatType taskContractPriceType = TypesFactory.eINSTANCE.createFloatType();
    taskContractPriceType.setValue(new Float("10.5")); //$NON-NLS-1$    
    taskContractPrice.eSet(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, taskContractPriceType);

    TaskContract taskContractAmount = FprodFactory.eINSTANCE.createTaskContract();
    taskContractAmount.setName("amount"); //$NON-NLS-1$
    taskContractAmount.setMode(ContractMode.OUT);
    contracts.getActivityContracts().add(taskContractAmount);

    FloatType taskContractAmountType = TypesFactory.eINSTANCE.createFloatType();
    taskContractAmount.eSet(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, taskContractAmountType);

    TaskContract generatorAdapterFactory = FprodFactory.eINSTANCE.createTaskContract();
    generatorAdapterFactory.setName("generatorAdapterFactory"); //$NON-NLS-1$
    generatorAdapterFactory.setMode(ContractMode.OUT);
    contracts.getActivityContracts().add(generatorAdapterFactory);

    GeneratorAdapterFactoryType generatorAdapterFactoryType = TypesFactory.eINSTANCE.createGeneratorAdapterFactoryType();
    generatorAdapterFactoryType.setValue("org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory"); //$NON-NLS-1$
    generatorAdapterFactory.eSet(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, generatorAdapterFactoryType);

    // Factory Component Definition

    FactoryComponent factoryComponent = FcoreFactory.eINSTANCE.createFactoryComponent();

    ProductionPlan productionPlan = FprodFactory.eINSTANCE.createProductionPlan();
    factoryComponent.eSet(FcorePackage.Literals.FACTORY_COMPONENT__ORCHESTRATION, productionPlan);

    TaskInvocation taskInvocation = FprodFactory.eINSTANCE.createTaskInvocation();
    productionPlan.getInvocations().add(taskInvocation);

    InvocationContextContainer contexts = FcoreFactory.eINSTANCE.createInvocationContextContainer();
    taskInvocation.eSet(FcorePackage.Literals.INVOCATION__INVOCATION_CONTEXT_CONTAINER, contexts);

    InvocationContext taskInvocationQuantity1 = FcoreFactory.eINSTANCE.createInvocationContext();
    taskInvocationQuantity1.setName("quantity"); //$NON-NLS-1$
    taskInvocationQuantity1.eSet(FcorePackage.Literals.INVOCATION_CONTEXT__ACTIVITY_CONTRACT, quantity);
    contexts.getInvocationContexts().add(taskInvocationQuantity1);

    IntegerType taskInvocationQuantityType1 = TypesFactory.eINSTANCE.createIntegerType();
    taskInvocationQuantity1.eSet(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, taskInvocationQuantityType1);

    InvocationContext taskInvocationQuantity2 = FcoreFactory.eINSTANCE.createInvocationContext();
    taskInvocationQuantity2.setName("quantity"); //$NON-NLS-1$
    taskInvocationQuantity2.eSet(FcorePackage.Literals.INVOCATION_CONTEXT__ACTIVITY_CONTRACT, quantity);
    contexts.getInvocationContexts().add(taskInvocationQuantity2);

    IntegerType taskInvocationQuantityType2 = TypesFactory.eINSTANCE.createIntegerType();
    taskInvocationQuantity2.eSet(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, taskInvocationQuantityType2);

    Diagnostician diagnostician = new Diagnostician();
    Diagnostic diagnostic = diagnostician.validate(contexts);

    assertTrue(diagnostic.getSeverity() == Diagnostic.ERROR);

  }

  public void testOutContextName() throws Exception {

    // Task Definition

    Task task = FprodFactory.eINSTANCE.createTask();
    task.setValue("org.eclipse.egf.example.task.h1.H1.id"); //$NON-NLS-1$

    TaskContractContainer contracts = FprodFactory.eINSTANCE.createTaskContractContainer();
    task.eSet(FprodPackage.Literals.TASK__ACTIVITY_CONTRACT_CONTAINER, contracts);

    TaskContract taskContractquantity = FprodFactory.eINSTANCE.createTaskContract();
    taskContractquantity.setName("quantity"); //$NON-NLS-1$
    taskContractquantity.setMode(ContractMode.IN);
    contracts.getActivityContracts().add(taskContractquantity);

    IntegerType taskContractQuantityType = TypesFactory.eINSTANCE.createIntegerType();
    taskContractQuantityType.setValue(100);
    taskContractquantity.eSet(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, taskContractQuantityType);

    TaskContract taskContractPrice = FprodFactory.eINSTANCE.createTaskContract();
    taskContractPrice.setName("price"); //$NON-NLS-1$
    taskContractPrice.setMode(ContractMode.IN);
    contracts.getActivityContracts().add(taskContractPrice);

    FloatType taskContractPriceType = TypesFactory.eINSTANCE.createFloatType();
    taskContractPriceType.setValue(new Float("10.5")); //$NON-NLS-1$    
    taskContractPrice.eSet(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, taskContractPriceType);

    TaskContract taskContractAmount = FprodFactory.eINSTANCE.createTaskContract();
    taskContractAmount.setName("amount"); //$NON-NLS-1$
    taskContractAmount.setMode(ContractMode.OUT);
    contracts.getActivityContracts().add(taskContractAmount);

    FloatType taskContractAmountType = TypesFactory.eINSTANCE.createFloatType();
    taskContractAmount.eSet(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, taskContractAmountType);

    TaskContract generatorAdapterFactory = FprodFactory.eINSTANCE.createTaskContract();
    generatorAdapterFactory.setName("generatorAdapterFactory"); //$NON-NLS-1$
    generatorAdapterFactory.setMode(ContractMode.OUT);
    contracts.getActivityContracts().add(generatorAdapterFactory);

    GeneratorAdapterFactoryType generatorAdapterFactoryType = TypesFactory.eINSTANCE.createGeneratorAdapterFactoryType();
    generatorAdapterFactoryType.setValue("org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory"); //$NON-NLS-1$
    generatorAdapterFactory.eSet(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, generatorAdapterFactoryType);

    // Factory Component Definition

    FactoryComponent factoryComponent = FcoreFactory.eINSTANCE.createFactoryComponent();

    ProductionPlan productionPlan = FprodFactory.eINSTANCE.createProductionPlan();
    factoryComponent.eSet(FcorePackage.Literals.FACTORY_COMPONENT__ORCHESTRATION, productionPlan);

    TaskInvocation taskInvocation = FprodFactory.eINSTANCE.createTaskInvocation();
    productionPlan.getInvocations().add(taskInvocation);

    InvocationContextContainer contexts = FcoreFactory.eINSTANCE.createInvocationContextContainer();
    taskInvocation.eSet(FcorePackage.Literals.INVOCATION__INVOCATION_CONTEXT_CONTAINER, contexts);

    InvocationContext taskInvocationAmount1 = FcoreFactory.eINSTANCE.createInvocationContext();
    taskInvocationAmount1.setName("amount"); //$NON-NLS-1$
    taskInvocationAmount1.eSet(FcorePackage.Literals.INVOCATION_CONTEXT__ACTIVITY_CONTRACT, taskContractAmount);
    contexts.getInvocationContexts().add(taskInvocationAmount1);

    FloatType taskInvocationAmountType1 = TypesFactory.eINSTANCE.createFloatType();
    taskInvocationAmount1.eSet(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, taskInvocationAmountType1);

    InvocationContext taskInvocationAmount2 = FcoreFactory.eINSTANCE.createInvocationContext();
    taskInvocationAmount2.setName("amount"); //$NON-NLS-1$
    taskInvocationAmount2.eSet(FcorePackage.Literals.INVOCATION_CONTEXT__ACTIVITY_CONTRACT, taskContractAmount);
    contexts.getInvocationContexts().add(taskInvocationAmount2);

    FloatType taskInvocationAmountType2 = TypesFactory.eINSTANCE.createFloatType();
    taskInvocationAmount2.eSet(FcorePackage.Literals.INVOCATION_CONTEXT__TYPE, taskInvocationAmountType2);

    Diagnostician diagnostician = new Diagnostician();
    Diagnostic diagnostic = diagnostician.validate(contexts);

    assertTrue(diagnostic.getSeverity() == Diagnostic.ERROR);

  }

}
