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
package org.eclipse.egf.core.model.productionplan;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.model.fcore.InvocationContextContainer;
import org.eclipse.egf.model.productionplan.ProductionPlan;
import org.eclipse.egf.model.productionplan.ProductionPlanFactory;
import org.eclipse.egf.model.productionplan.Task;
import org.eclipse.egf.model.productionplan.TaskInvocation;
import org.eclipse.egf.model.types.FloatType;
import org.eclipse.egf.model.types.GeneratorAdapterFactoryType;
import org.eclipse.egf.model.types.IntegerType;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;

public class ProductionPlanContextValidation extends TestCase {

  public static Test suite() {
    return new TestSuite(ProductionPlanContextValidation.class);
  }

  public void testInContextName() throws Exception {

    // Task Definition

    Task task = ProductionPlanFactory.eINSTANCE.createTask();
    task.setInvocationId("org.eclipse.egf.example.task.h1.H1.id"); //$NON-NLS-1$

    ContractContainer contracts = FcoreFactory.eINSTANCE.createContractContainer();
    task.eSet(FcorePackage.Literals.CONTRACT__CONTRACT_CONTAINER, contracts);

    Contract quantity = FcoreFactory.eINSTANCE.createContract();
    quantity.setName("quantity"); //$NON-NLS-1$
    quantity.setMode(ContractMode.IN);
    contracts.getContracts().add(quantity);

    IntegerType quantityType = TypesFactory.eINSTANCE.createIntegerType();
    quantityType.setValue(100);
    quantity.eSet(FcorePackage.Literals.CONTRACT__TYPE, quantityType);

    Contract taskContractPrice = FcoreFactory.eINSTANCE.createContract();
    taskContractPrice.setName("price"); //$NON-NLS-1$
    taskContractPrice.setMode(ContractMode.IN);
    contracts.getContracts().add(taskContractPrice);

    FloatType taskContractPriceType = TypesFactory.eINSTANCE.createFloatType();
    taskContractPriceType.setValue(new Float("10.5")); //$NON-NLS-1$    
    taskContractPrice.eSet(FcorePackage.Literals.CONTRACT__TYPE, taskContractPriceType);

    Contract taskContractAmount = FcoreFactory.eINSTANCE.createContract();
    taskContractAmount.setName("amount"); //$NON-NLS-1$
    taskContractAmount.setMode(ContractMode.OUT);
    contracts.getContracts().add(taskContractAmount);

    FloatType taskContractAmountType = TypesFactory.eINSTANCE.createFloatType();
    taskContractAmount.eSet(FcorePackage.Literals.CONTRACT__TYPE, taskContractAmountType);

    Contract generatorAdapterFactory = FcoreFactory.eINSTANCE.createContract();
    generatorAdapterFactory.setName("generatorAdapterFactory"); //$NON-NLS-1$
    generatorAdapterFactory.setMode(ContractMode.OUT);
    contracts.getContracts().add(generatorAdapterFactory);

    GeneratorAdapterFactoryType generatorAdapterFactoryType = TypesFactory.eINSTANCE.createGeneratorAdapterFactoryType();
    generatorAdapterFactoryType.setValue("org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory"); //$NON-NLS-1$
    generatorAdapterFactory.eSet(FcorePackage.Literals.CONTRACT__TYPE, generatorAdapterFactoryType);

    // Factory Component Definition

    FactoryComponent factoryComponent = FcoreFactory.eINSTANCE.createFactoryComponent();

    ProductionPlan productionPlan = ProductionPlanFactory.eINSTANCE.createProductionPlan();
    factoryComponent.eSet(FcorePackage.Literals.FACTORY_COMPONENT__ORCHESTRATION, productionPlan);

    TaskInvocation taskInvocation = ProductionPlanFactory.eINSTANCE.createTaskInvocation();
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

    Task task = ProductionPlanFactory.eINSTANCE.createTask();
    task.setInvocationId("org.eclipse.egf.example.task.h1.H1.id"); //$NON-NLS-1$

    ContractContainer contracts = FcoreFactory.eINSTANCE.createContractContainer();
    task.eSet(FcorePackage.Literals.CONTRACT__CONTRACT_CONTAINER, contracts);

    Contract taskContractquantity = FcoreFactory.eINSTANCE.createContract();
    taskContractquantity.setName("quantity"); //$NON-NLS-1$
    taskContractquantity.setMode(ContractMode.IN);
    contracts.getContracts().add(taskContractquantity);

    IntegerType taskContractQuantityType = TypesFactory.eINSTANCE.createIntegerType();
    taskContractQuantityType.setValue(100);
    taskContractquantity.eSet(FcorePackage.Literals.CONTRACT__TYPE, taskContractQuantityType);

    Contract taskContractPrice = FcoreFactory.eINSTANCE.createContract();
    taskContractPrice.setName("price"); //$NON-NLS-1$
    taskContractPrice.setMode(ContractMode.IN);
    contracts.getContracts().add(taskContractPrice);

    FloatType taskContractPriceType = TypesFactory.eINSTANCE.createFloatType();
    taskContractPriceType.setValue(new Float("10.5")); //$NON-NLS-1$    
    taskContractPrice.eSet(FcorePackage.Literals.CONTRACT__TYPE, taskContractPriceType);

    Contract taskContractAmount = FcoreFactory.eINSTANCE.createContract();
    taskContractAmount.setName("amount"); //$NON-NLS-1$
    taskContractAmount.setMode(ContractMode.OUT);
    contracts.getContracts().add(taskContractAmount);

    FloatType taskContractAmountType = TypesFactory.eINSTANCE.createFloatType();
    taskContractAmount.eSet(FcorePackage.Literals.CONTRACT__TYPE, taskContractAmountType);

    Contract generatorAdapterFactory = FcoreFactory.eINSTANCE.createContract();
    generatorAdapterFactory.setName("generatorAdapterFactory"); //$NON-NLS-1$
    generatorAdapterFactory.setMode(ContractMode.OUT);
    contracts.getContracts().add(generatorAdapterFactory);

    GeneratorAdapterFactoryType generatorAdapterFactoryType = TypesFactory.eINSTANCE.createGeneratorAdapterFactoryType();
    generatorAdapterFactoryType.setValue("org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory"); //$NON-NLS-1$
    generatorAdapterFactory.eSet(FcorePackage.Literals.CONTRACT__TYPE, generatorAdapterFactoryType);

    // Factory Component Definition

    FactoryComponent factoryComponent = FcoreFactory.eINSTANCE.createFactoryComponent();

    ProductionPlan productionPlan = ProductionPlanFactory.eINSTANCE.createProductionPlan();
    factoryComponent.eSet(FcorePackage.Literals.FACTORY_COMPONENT__ORCHESTRATION, productionPlan);

    TaskInvocation taskInvocation = ProductionPlanFactory.eINSTANCE.createTaskInvocation();
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
