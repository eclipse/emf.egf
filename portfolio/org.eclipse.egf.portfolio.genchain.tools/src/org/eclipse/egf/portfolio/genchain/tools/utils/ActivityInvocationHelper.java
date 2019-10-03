/**
 * <copyright>
 *
 *  Copyright (c) 2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.genchain.tools.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.model.domain.TypeDomain;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.InvocationContractContainer;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.egf.model.fprod.FprodFactory;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.egf.model.pattern.PatternFactory;
import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * 
 * @author Thomas Guiu
 */
public class ActivityInvocationHelper {
    public static final String GENERATION_EXTENSION_PARAMETER_NAME = "generation extension";

    public static void clearOrchestration(FactoryComponent fc) {
        ProductionPlan pp = (ProductionPlan) fc.getOrchestration();
        for (Object obj : pp.getInvocations().toArray())
            EcoreUtil.delete((EObject) obj, true);
    }

    public static FactoryComponent createDefaultFC(String name) {
        FactoryComponent fc = FcoreFactory.eINSTANCE.createFactoryComponent();
        fc.setName(name);

        // Create Production plan
        ProductionPlan pp = FprodFactory.eINSTANCE.createProductionPlan();
        fc.setOrchestration(pp);

        // Create Parameter container
        pp.setOrchestrationParameterContainer(FcoreFactory.eINSTANCE.createOrchestrationParameterContainer());
        final OrchestrationParameter parameter = FcoreFactory.eINSTANCE.createOrchestrationParameter();
        parameter.setName(GENERATION_EXTENSION_PARAMETER_NAME);
        parameter.setType(PatternFactory.eINSTANCE.createTypePatternSubstitution());
        pp.getOrchestrationParameterContainer().getOrchestrationParameters().add(parameter);

        // Create viewpoint container
        ViewpointContainer viewpointContainer = FcoreFactory.eINSTANCE.createViewpointContainer();
        fc.setViewpointContainer(viewpointContainer);

        // Create domainviewpoint
        DomainViewpoint domainViewpoint = DomainFactory.eINSTANCE.createDomainViewpoint();
        viewpointContainer.getViewpoints().add(domainViewpoint);

        return fc;
    }

    public static void addInvocation(ProductionPlan pp, Activity activity) {
        addInvocation(pp, activity, new HashMap<String, Type>());
    }

    public static void addInvocation(ProductionPlan pp, Activity activity, Map<String, Type> contract2type) {
        addInvocation(pp, activity, contract2type, new HashMap<String, OrchestrationParameter>());
    }

    public static EMFDomain getDomain(DomainViewpoint dvp, URI uri) {
        for (Domain domain : dvp.getDomains()) {
            if (domain instanceof EMFDomain) {
                EMFDomain emfDomain = (EMFDomain) domain;
                if (uri.equals(emfDomain.getUri())) {
                    return emfDomain;
                }
            }
        }
        EMFDomain emfDomain = DomainFactory.eINSTANCE.createEMFDomain();
        emfDomain.setUri(uri);
        dvp.getDomains().add(emfDomain);
        return emfDomain;
    }

    public static void addInvocation(ProductionPlan pp, Activity activity, Map<String, Type> contract2type, Map<String, OrchestrationParameter> contract2parameter) {
        ProductionPlanInvocation productionPlanInvocation = FprodFactory.eINSTANCE.createProductionPlanInvocation();
        productionPlanInvocation.setName(activity.getName() + " invocation");
        productionPlanInvocation.setProductionPlan(pp);
        productionPlanInvocation.setInvokedActivity(activity);

        InvocationContractContainer invocationContractContainer = FcoreFactory.eINSTANCE.createInvocationContractContainer();
        invocationContractContainer.setInvocation(productionPlanInvocation);

        for (Entry<String, Type> entry : contract2type.entrySet()) {
            InvocationContract invocationContract = FcoreFactory.eINSTANCE.createInvocationContract();
            invocationContractContainer.getInvocationContracts().add(invocationContract);
            // invocationContract.setInvocationContractContainer(invocationContractContainer);
            final Contract contract = activity.getContract(entry.getKey());
            if (contract == null)
                throw new IllegalStateException();
            invocationContract.setInvokedContract(contract);
            invocationContract.setType(entry.getValue());
        }

        for (Entry<String, OrchestrationParameter> entry : contract2parameter.entrySet()) {
            InvocationContract invocationContract = FcoreFactory.eINSTANCE.createInvocationContract();
            invocationContractContainer.getInvocationContracts().add(invocationContract);
            // invocationContract.setInvocationContractContainer(invocationContractContainer);
            invocationContract.setInvokedContract(activity.getContract(entry.getKey()));
            invocationContract.setOrchestrationParameter(entry.getValue());
        }

    }

    public static void addInvocation(ProductionPlan pp, EMFDomain genModelEMFDomain, Activity activity) {
        ProductionPlanInvocation productionPlanInvocation = FprodFactory.eINSTANCE.createProductionPlanInvocation();
        productionPlanInvocation.setName(activity.getName() + " invocation");
        productionPlanInvocation.setProductionPlan(pp);
        productionPlanInvocation.setInvokedActivity(activity);

        InvocationContractContainer invocationContractContainer = FcoreFactory.eINSTANCE.createInvocationContractContainer();
        invocationContractContainer.setInvocation(productionPlanInvocation);

        InvocationContract invocationContract = FcoreFactory.eINSTANCE.createInvocationContract();
        invocationContractContainer.getInvocationContracts().add(invocationContract);
        // invocationContract.setInvocationContractContainer(invocationContractContainer);
        invocationContract.setInvokedContract(activity.getContracts().get(0));

        TypeDomain typeEMFDomain = DomainFactory.eINSTANCE.createTypeDomain();
        typeEMFDomain.setDomain(genModelEMFDomain);
        invocationContract.setType(typeEMFDomain);
    }

    public static void addEEFInvocation(ProductionPlan pp, EMFDomain genModelEMFDomain, EMFDomain eefEMFDomain, Activity activity, String invocationName) {
        ProductionPlanInvocation eefGen = FprodFactory.eINSTANCE.createProductionPlanInvocation();
        eefGen.setName(invocationName);
        eefGen.setProductionPlan(pp);
        eefGen.setInvokedActivity(activity);

        InvocationContractContainer invocationContractContainer = FcoreFactory.eINSTANCE.createInvocationContractContainer();
        invocationContractContainer.setInvocation(eefGen);

        InvocationContract invocationContract = FcoreFactory.eINSTANCE.createInvocationContract();
        invocationContract.setInvocationContractContainer(invocationContractContainer);
        invocationContract.setInvokedContract(activity.getContracts().get(0));

        TypeDomain typeEMFDomain = DomainFactory.eINSTANCE.createTypeDomain();
        typeEMFDomain.setDomain(genModelEMFDomain);
        invocationContract.setType(typeEMFDomain);

        InvocationContract inContract = FcoreFactory.eINSTANCE.createInvocationContract();
        inContract.setInvocationContractContainer(invocationContractContainer);
        inContract.setInvokedContract(activity.getContracts().get(1));

        typeEMFDomain = DomainFactory.eINSTANCE.createTypeDomain();
        typeEMFDomain.setDomain(eefEMFDomain);
        inContract.setType(typeEMFDomain);
    }

}
