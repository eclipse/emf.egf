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
package org.eclipse.egf.core.test.context.task.memory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.test.EGFCoreTestPlugin;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.productionplan.ProductionPlanFactory;
import org.eclipse.egf.model.productionplan.Task;
import org.eclipse.egf.model.types.FloatType;
import org.eclipse.egf.model.types.GeneratorAdapterFactoryType;
import org.eclipse.egf.model.types.IntegerType;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.egf.productionplan.EGFProductionPlanPlugin;
import org.eclipse.egf.productionplan.context.IProductionPlanManager;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;

public class ContextTaskMemory extends TestCase {

  public static Test suite() {
    return new TestSuite(ContextTaskMemory.class);
  }

  public void testContractH1() throws Exception {

    Task task = ProductionPlanFactory.eINSTANCE.createTask();
    task.setInvocationId("org.eclipse.egf.example.task.h1.H1.id"); //$NON-NLS-1$

    IProductionPlanManager<?, ?> production = EGFProductionPlanPlugin.getProductionPlanManagerFactory().createProductionManager(EGFCoreTestPlugin.getDefault().getBundle(), task);
    try {
      production.invoke(new NullProgressMonitor());
    } catch (InvocationException ie) {
      return;
    }

    fail("InvocationException is expected"); //$NON-NLS-1$

  }

  public void testOutputContractClassNotTheSameH1() throws Exception {

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

    Contract price = FcoreFactory.eINSTANCE.createContract();
    price.setName("price"); //$NON-NLS-1$
    price.setMode(ContractMode.IN);
    contracts.getContracts().add(price);

    FloatType priceType = TypesFactory.eINSTANCE.createFloatType();
    priceType.setValue(new Float("10.5")); //$NON-NLS-1$    
    price.eSet(FcorePackage.Literals.CONTRACT__TYPE, priceType);

    Contract amount = FcoreFactory.eINSTANCE.createContract();
    amount.setName("amount"); //$NON-NLS-1$
    amount.setMode(ContractMode.OUT);
    contracts.getContracts().add(amount);
    FloatType amountType = TypesFactory.eINSTANCE.createFloatType();
    amount.eSet(FcorePackage.Literals.CONTRACT__TYPE, amountType);

    Contract generatorAdapterFactory = FcoreFactory.eINSTANCE.createContract();
    generatorAdapterFactory.setName("generatorAdapterFactory"); //$NON-NLS-1$
    generatorAdapterFactory.setMode(ContractMode.OUT);
    contracts.getContracts().add(generatorAdapterFactory);

    GeneratorAdapterFactoryType generatorAdapterFactoryType = TypesFactory.eINSTANCE.createGeneratorAdapterFactoryType();
    generatorAdapterFactoryType.setValue("org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory"); //$NON-NLS-1$
    generatorAdapterFactory.eSet(FcorePackage.Literals.CONTRACT__TYPE, generatorAdapterFactoryType);

    IProductionPlanManager<?, ?> production = EGFProductionPlanPlugin.getProductionPlanManagerFactory().createProductionManager(EGFCoreTestPlugin.getDefault().getBundle(), task);

    GenModelGeneratorAdapterFactory defaultValue = production.getProductionContext().getOutputValue("generatorAdapterFactory", GenModelGeneratorAdapterFactory.class); //$NON-NLS-1$

    try {
      production.invoke(new NullProgressMonitor());
    } catch (InvocationException ie) {
      return;
    }

    assertNotSame(production.getProductionContext().getOutputValue("generatorAdapterFactory", GenModelGeneratorAdapterFactory.class), defaultValue); //$NON-NLS-1$

  }
}
