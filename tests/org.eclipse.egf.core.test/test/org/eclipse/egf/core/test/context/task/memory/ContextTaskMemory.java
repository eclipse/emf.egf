/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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
import org.eclipse.egf.ftask.producer.manager.TaskManagerFactory;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.ftask.FtaskFactory;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.types.TypeCollection;
import org.eclipse.egf.model.types.TypeFloat;
import org.eclipse.egf.model.types.TypeGeneratorAdapterFactory;
import org.eclipse.egf.model.types.TypeInteger;
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

        Task taskJava = FtaskFactory.eINSTANCE.createTask();
        taskJava.setImplementation("org.eclipse.egf.example.task.h1.H1"); //$NON-NLS-1$
        taskJava.setKind("java");

        ActivityManagerProducer<Task> producer = EGFProducerPlugin.getActivityManagerProducer(taskJava);

        IActivityManager<?> manager = producer.createActivityManager(EGFCoreTestPlugin.getDefault().getBundle(), taskJava);
        try {
            manager.initializeContext();
            manager.invoke(new NullProgressMonitor());
        } catch (InvocationException ie) {
            return;
        } catch (Exception e) {
            EGFCoreTestPlugin.getDefault().logError(e);
            fail(e.getMessage());
            return;
        } finally {
            try {
                manager.dispose();
            } catch (Exception e) {
                EGFCoreTestPlugin.getDefault().logError(e);
                fail(e.getMessage());
                return;
            }
        }

        fail("InvocationException is expected"); //$NON-NLS-1$

    }

    public void testOutputContractClassNotTheSameH1() throws Exception {

        Task taskJava = FtaskFactory.eINSTANCE.createTask();
        taskJava.setImplementation("org.eclipse.egf.example.task.h1.H1"); //$NON-NLS-1$
        taskJava.setKind("java");

        ContractContainer contracts = FcoreFactory.eINSTANCE.createContractContainer();
        taskJava.eSet(FcorePackage.Literals.ACTIVITY__CONTRACT_CONTAINER, contracts);

        Contract quantity = FcoreFactory.eINSTANCE.createContract();
        quantity.setName("quantity"); //$NON-NLS-1$
        quantity.setMode(ContractMode.IN);
        contracts.getContracts().add(quantity);

        TypeInteger quantityType = TypesFactory.eINSTANCE.createTypeInteger();
        quantityType.setValue(100);
        quantity.eSet(FcorePackage.Literals.CONTRACT__TYPE, quantityType);

        Contract price = FcoreFactory.eINSTANCE.createContract();
        price.setName("price"); //$NON-NLS-1$
        price.setMode(ContractMode.IN);
        contracts.getContracts().add(price);

        TypeFloat priceType = TypesFactory.eINSTANCE.createTypeFloat();
        priceType.setValue(new Float("10.5")); //$NON-NLS-1$    
        price.eSet(FcorePackage.Literals.CONTRACT__TYPE, priceType);

        Contract parameters = FcoreFactory.eINSTANCE.createContract();
        parameters.setName("parameters"); //$NON-NLS-1$
        parameters.setMode(ContractMode.IN_OUT);
        contracts.getContracts().add(parameters);

        TypeCollection parametersType = TypesFactory.eINSTANCE.createTypeCollection();
        parametersType.setValue("java.util.ArrayList"); //$NON-NLS-1$
        parameters.eSet(FcorePackage.Literals.CONTRACT__TYPE, parametersType);

        Contract amount = FcoreFactory.eINSTANCE.createContract();
        amount.setName("amount"); //$NON-NLS-1$
        amount.setMode(ContractMode.OUT);
        contracts.getContracts().add(amount);

        TypeFloat amountType = TypesFactory.eINSTANCE.createTypeFloat();
        amount.eSet(FcorePackage.Literals.CONTRACT__TYPE, amountType);

        Contract generatorAdapterFactory = FcoreFactory.eINSTANCE.createContract();
        generatorAdapterFactory.setName("generatorAdapterFactory"); //$NON-NLS-1$
        generatorAdapterFactory.setMode(ContractMode.OUT);
        contracts.getContracts().add(generatorAdapterFactory);

        TypeGeneratorAdapterFactory generatorAdapterFactoryType = TypesFactory.eINSTANCE.createTypeGeneratorAdapterFactory();
        generatorAdapterFactoryType.setValue("org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory"); //$NON-NLS-1$
        generatorAdapterFactory.eSet(FcorePackage.Literals.CONTRACT__TYPE, generatorAdapterFactoryType);

        IActivityManager<Task> manager = TaskManagerFactory.createProductionManager(EGFCoreTestPlugin.getDefault().getBundle(), taskJava);

        GeneratorAdapterFactory defaultValue = null;

        try {
            manager.initializeContext();
            defaultValue = manager.getProductionContext().getOutputValue("generatorAdapterFactory", GeneratorAdapterFactory.class); //$NON-NLS-1$      
            manager.invoke(new NullProgressMonitor());
        } catch (Exception e) {
            EGFCoreTestPlugin.getDefault().logError(e);
            fail(e.getMessage());
            return;
        } finally {
            try {
                manager.dispose();
            } catch (Exception e) {
                EGFCoreTestPlugin.getDefault().logError(e);
                fail(e.getMessage());
                return;
            }
        }

        assertNotSame(manager.getProductionContext().getOutputValue("generatorAdapterFactory", GenModelGeneratorAdapterFactory.class), defaultValue); //$NON-NLS-1$

    }
}
