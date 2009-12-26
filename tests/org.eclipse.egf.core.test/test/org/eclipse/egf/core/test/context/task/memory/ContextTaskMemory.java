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
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.test.EGFCoreTestPlugin;
import org.eclipse.egf.fprod.producer.manager.ITaskManager;
import org.eclipse.egf.fprod.producer.manager.TaskManagerFactory;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fprod.FprodFactory;
import org.eclipse.egf.model.fprod.FprodPackage;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.egf.model.fprod.TaskContract;
import org.eclipse.egf.model.fprod.TaskContractContainer;
import org.eclipse.egf.model.types.FloatType;
import org.eclipse.egf.model.types.GeneratorAdapterFactoryType;
import org.eclipse.egf.model.types.IntegerType;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;

public class ContextTaskMemory extends TestCase {

  public static Test suite() {
    return new TestSuite(ContextTaskMemory.class);
  }

  public void testContractH1() throws Exception {

    Task task = FprodFactory.eINSTANCE.createTask();
    task.setValue("org.eclipse.egf.example.task.h1.H1"); //$NON-NLS-1$

    ActivityManagerProducer producer = EGFProducerPlugin.getActivityManagerProducer(task);

    IActivityManager manager = producer.createActivityManager(EGFCoreTestPlugin.getDefault().getBundle(), task);
    try {
      manager.invoke(new NullProgressMonitor());
    } catch (InvocationException ie) {
      return;
    }

    fail("InvocationException is expected"); //$NON-NLS-1$

  }

  public void testOutputContractClassNotTheSameH1() throws Exception {

    Task task = FprodFactory.eINSTANCE.createTask();
    task.setValue("org.eclipse.egf.example.task.h1.H1"); //$NON-NLS-1$

    TaskContractContainer contracts = FprodFactory.eINSTANCE.createTaskContractContainer();
    task.eSet(FprodPackage.Literals.TASK__ACTIVITY_CONTRACT_CONTAINER, contracts);

    TaskContract quantity = FprodFactory.eINSTANCE.createTaskContract();
    quantity.setName("quantity"); //$NON-NLS-1$
    quantity.setMode(ContractMode.IN);
    contracts.getActivityContracts().add(quantity);

    IntegerType quantityType = TypesFactory.eINSTANCE.createIntegerType();
    quantityType.setValue(100);
    quantity.eSet(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, quantityType);

    TaskContract price = FprodFactory.eINSTANCE.createTaskContract();
    price.setName("price"); //$NON-NLS-1$
    price.setMode(ContractMode.IN);
    contracts.getActivityContracts().add(price);

    FloatType priceType = TypesFactory.eINSTANCE.createFloatType();
    priceType.setValue(new Float("10.5")); //$NON-NLS-1$    
    price.eSet(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, priceType);

    TaskContract amount = FprodFactory.eINSTANCE.createTaskContract();
    amount.setName("amount"); //$NON-NLS-1$
    amount.setMode(ContractMode.OUT);
    contracts.getActivityContracts().add(amount);
    FloatType amountType = TypesFactory.eINSTANCE.createFloatType();
    amount.eSet(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, amountType);

    TaskContract generatorAdapterFactory = FprodFactory.eINSTANCE.createTaskContract();
    generatorAdapterFactory.setName("generatorAdapterFactory"); //$NON-NLS-1$
    generatorAdapterFactory.setMode(ContractMode.OUT);
    contracts.getActivityContracts().add(generatorAdapterFactory);

    GeneratorAdapterFactoryType generatorAdapterFactoryType = TypesFactory.eINSTANCE.createGeneratorAdapterFactoryType();
    generatorAdapterFactoryType.setValue("org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory"); //$NON-NLS-1$
    generatorAdapterFactory.eSet(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, generatorAdapterFactoryType);

    ITaskManager manager = TaskManagerFactory.createProductionManager(EGFCoreTestPlugin.getDefault().getBundle(), task);

    GeneratorAdapterFactory defaultValue = manager.getProductionContext().getOutputValue("generatorAdapterFactory", GeneratorAdapterFactory.class); //$NON-NLS-1$

    try {
      manager.invoke(new NullProgressMonitor());
    } catch (InvocationException ie) {
      return;
    }

    assertNotSame(manager.getProductionContext().getOutputValue("generatorAdapterFactory", GenModelGeneratorAdapterFactory.class), defaultValue); //$NON-NLS-1$

  }
}
