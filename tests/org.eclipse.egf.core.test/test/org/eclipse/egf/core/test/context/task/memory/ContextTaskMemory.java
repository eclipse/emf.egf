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
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.ftask.FtaskFactory;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.types.TypeClass;
import org.eclipse.egf.model.types.TypeCollection;
import org.eclipse.egf.model.types.TypeFloat;
import org.eclipse.egf.model.types.TypeInteger;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.ftask.manager.TaskManagerFactory;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.emf.codegen.merge.java.JMerger;

public class ContextTaskMemory extends TestCase {

    public static Test suite() {
        return new TestSuite(ContextTaskMemory.class);
    }

    public void testContractH1() throws Exception {

        Task task = FtaskFactory.eINSTANCE.createTask();
        task.setImplementation("org.eclipse.egf.example.task.h1.H1"); //$NON-NLS-1$
        task.setKind("java"); //$NON-NLS-1$

        ActivityManagerProducer<Task> producer = EGFProducerPlugin.getActivityManagerProducer(task);

        IActivityManager<?> manager = producer.createActivityManager(EGFCoreTestPlugin.getDefault().getBundle(), task);
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

        Task task = FtaskFactory.eINSTANCE.createTask();
        task.setImplementation("org.eclipse.egf.example.task.h1.H1"); //$NON-NLS-1$
        task.setKind("java"); //$NON-NLS-1$

        ContractContainer contracts = FcoreFactory.eINSTANCE.createContractContainer();
        task.eSet(FcorePackage.Literals.ACTIVITY__CONTRACT_CONTAINER, contracts);

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

        Contract jmerger = FcoreFactory.eINSTANCE.createContract();
        jmerger.setName("jmerger"); //$NON-NLS-1$
        jmerger.setMode(ContractMode.OUT);
        contracts.getContracts().add(jmerger);

        TypeClass jmergerType = TypesFactory.eINSTANCE.createTypeClass();
        jmergerType.setValue("org.eclipse.emf.codegen.merge.java.JMerger"); //$NON-NLS-1$
        jmerger.eSet(FcorePackage.Literals.CONTRACT__TYPE, jmergerType);

        // Beware, we use the test plugin bundle here, the manifest should
        // import the bundle who contains the task
        // Otherwise it will fail to load it
        IActivityManager<Task> manager = TaskManagerFactory.createProductionManager(EGFCoreTestPlugin.getDefault().getBundle(), task);

        JMerger defaultValue = null;

        try {
            manager.initializeContext();
            defaultValue = manager.getProductionContext().getOutputValue("jmerger", JMerger.class); //$NON-NLS-1$      
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

        assertNotSame(manager.getProductionContext().getOutputValue("jmerger", JMerger.class), defaultValue); //$NON-NLS-1$

    }
}
