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
package org.eclipse.egf.core.test.factorycomponent.memory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.core.domain.RuntimePlatformResourceSet;
import org.eclipse.egf.core.test.EGFCoreTestPlugin;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.InvocationContractContainer;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fcore.OrchestrationParameterContainer;
import org.eclipse.egf.model.fprod.FprodFactory;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.types.TypeFloat;
import org.eclipse.egf.model.types.TypeInteger;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.egf.producer.manager.FactoryComponentManagerFactory;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osgi.framework.Bundle;

public class ContextFactoryComponentMemory extends TestCase {

    private Bundle _bundle;

    public static Test suite() {
        return new TestSuite(ContextFactoryComponentMemory.class);
    }

    @Override
    protected void setUp() throws Exception {
        assertNotNull(EGFCoreTestPlugin.getDefault());
        _bundle = EGFCoreTestPlugin.getDefault().getBundle();
        assertNotNull(_bundle);
    }

    public void testInvokeFC1() throws Exception {

        ResourceSet resourceSet = new RuntimePlatformResourceSet();

        FactoryComponent fc = FcoreFactory.eINSTANCE.createFactoryComponent();
        fc.setName("FC1"); //$NON-NLS-1$

        ContractContainer contracts = FcoreFactory.eINSTANCE.createContractContainer();
        fc.eSet(FcorePackage.Literals.ACTIVITY__CONTRACT_CONTAINER, contracts);

        FactoryComponentContract price = FcoreFactory.eINSTANCE.createFactoryComponentContract();
        price.setName("price"); //$NON-NLS-1$
        price.setMode(ContractMode.IN);
        contracts.getContracts().add(price);

        TypeFloat priceType = TypesFactory.eINSTANCE.createTypeFloat();
        priceType.setValue(new Float("11.0")); //$NON-NLS-1$    
        price.eSet(FcorePackage.Literals.CONTRACT__TYPE, priceType);

        FactoryComponentContract amount = FcoreFactory.eINSTANCE.createFactoryComponentContract();
        amount.setName("amount"); //$NON-NLS-1$
        amount.setMode(ContractMode.OUT);
        contracts.getContracts().add(amount);

        TypeFloat amountType = TypesFactory.eINSTANCE.createTypeFloat();
        amount.eSet(FcorePackage.Literals.CONTRACT__TYPE, amountType);

        // Production Plan
        ProductionPlan pp = FprodFactory.eINSTANCE.createProductionPlan();
        fc.eSet(FcorePackage.Literals.FACTORY_COMPONENT__ORCHESTRATION, pp);

        // OrchestrationParameterContainer
        OrchestrationParameterContainer orchestrationParameterContainer = FcoreFactory.eINSTANCE.createOrchestrationParameterContainer();
        pp.eSet(FcorePackage.Literals.ORCHESTRATION__ORCHESTRATION_PARAMETER_CONTAINER, orchestrationParameterContainer);

        OrchestrationParameter stock = FcoreFactory.eINSTANCE.createOrchestrationParameter();
        stock.setName("stock"); //$NON-NLS-1$
        orchestrationParameterContainer.getOrchestrationParameters().add(stock);

        TypeInteger stockType = TypesFactory.eINSTANCE.createTypeInteger();
        stockType.setValue(new Integer("10")); //$NON-NLS-1$    
        stock.eSet(FcorePackage.Literals.ORCHESTRATION_PARAMETER__TYPE, stockType);

        // ProductionPlanInvocation
        ProductionPlanInvocation productionPlanInvocation = FprodFactory.eINSTANCE.createProductionPlanInvocation();
        Task task = (Task) resourceSet.getEObject(URI.createURI("platform:/plugin/org.eclipse.egf.example.task.h1/egf/task_h1.fcore#1Zvd4LdCEd6AWpPtW_wFiQ"), true); //$NON-NLS-1$
        productionPlanInvocation.eSet(FcorePackage.Literals.INVOCATION__INVOKED_ACTIVITY, task);
        pp.getInvocations().add(productionPlanInvocation);

        // InvocationContractContainer
        InvocationContractContainer invocationContractContainer = FcoreFactory.eINSTANCE.createInvocationContractContainer();
        productionPlanInvocation.eSet(FcorePackage.Literals.INVOCATION__INVOCATION_CONTRACT_CONTAINER, invocationContractContainer);

        InvocationContract quantityInvocationContract = FcoreFactory.eINSTANCE.createInvocationContract();
        invocationContractContainer.getInvocationContracts().add(quantityInvocationContract);
        Contract quantityInvokedContract = (Contract) resourceSet.getEObject(URI.createURI("platform:/plugin/org.eclipse.egf.example.task.h1/egf/task_h1.fcore#_sZPqULpOEd6O-6ob3O13Lw"), true); //$NON-NLS-1$
        quantityInvocationContract.eSet(FcorePackage.Literals.INVOCATION_CONTRACT__INVOKED_CONTRACT, quantityInvokedContract);
        quantityInvocationContract.eSet(FcorePackage.Literals.INVOCATION_CONTRACT__ORCHESTRATION_PARAMETER, stock);

        InvocationContract priceInvocationContract = FcoreFactory.eINSTANCE.createInvocationContract();
        invocationContractContainer.getInvocationContracts().add(priceInvocationContract);
        Contract priceInvokedContract = (Contract) resourceSet.getEObject(URI.createURI("platform:/plugin/org.eclipse.egf.example.task.h1/egf/task_h1.fcore#_xfSXELpOEd6O-6ob3O13Lw"), true); //$NON-NLS-1$
        priceInvocationContract.eSet(FcorePackage.Literals.INVOCATION_CONTRACT__INVOKED_CONTRACT, priceInvokedContract);
        priceInvocationContract.eSet(FcorePackage.Literals.INVOCATION_CONTRACT__FACTORY_COMPONENT_CONTRACT, price);

        InvocationContract amountInvocationContract = FcoreFactory.eINSTANCE.createInvocationContract();
        invocationContractContainer.getInvocationContracts().add(amountInvocationContract);
        Contract amountInvokedContract = (Contract) resourceSet.getEObject(URI.createURI("platform:/plugin/org.eclipse.egf.example.task.h1/egf/task_h1.fcore#_2vwLILpOEd6O-6ob3O13Lw"), true); //$NON-NLS-1$
        amountInvocationContract.eSet(FcorePackage.Literals.INVOCATION_CONTRACT__INVOKED_CONTRACT, amountInvokedContract);
        amountInvocationContract.eSet(FcorePackage.Literals.INVOCATION_CONTRACT__FACTORY_COMPONENT_CONTRACT, amount);

        // Beware, we use the test plugin bundle here, the manifest should import the bundle who contains the task
        // Otherwise it will fail to load it
        IActivityManager<FactoryComponent> manager = FactoryComponentManagerFactory.createProductionManager(_bundle, fc);

        try {
            manager.initializeContext();
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

        assertEquals(new Float("110"), manager.getProductionContext().getOutputValue("amount", Float.class)); //$NON-NLS-1$ //$NON-NLS-2$

    }
}
