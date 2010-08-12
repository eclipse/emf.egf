/**
 * <copyright>
 *
 *  Copyright (c) 2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.domain.TypeDomainURI;
import org.eclipse.egf.model.fcore.Activity;
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

    public static DomainURI getDomain(DomainViewpoint dvp, URI uri) {
        for (Domain domain : dvp.getDomains()) {
            if (domain instanceof DomainURI) {
                DomainURI domainUri = (DomainURI) domain;
                if (uri.equals(domainUri.getUri())) {
                    return domainUri;
                }
            }
        }
        DomainURI domainURI = DomainFactory.eINSTANCE.createDomainURI();
        domainURI.setUri(uri);
        dvp.getDomains().add(domainURI);
        return domainURI;
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
            invocationContract.setInvokedContract(activity.getContract(entry.getKey()));
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

    public static void addInvocation(ProductionPlan pp, DomainURI genModelDomainURI, Activity activity) {
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

        TypeDomainURI typeDomainURI = DomainFactory.eINSTANCE.createTypeDomainURI();
        typeDomainURI.setDomain(genModelDomainURI);
        invocationContract.setType(typeDomainURI);
    }

    public static void addEEFInvocation(ProductionPlan pp, DomainURI genModelDomainURI, DomainURI eefDomainURI, Activity activity, String invocationName) {
        ProductionPlanInvocation eefGen = FprodFactory.eINSTANCE.createProductionPlanInvocation();
        eefGen.setName(invocationName);
        eefGen.setProductionPlan(pp);
        eefGen.setInvokedActivity(activity);

        InvocationContractContainer invocationContractContainer = FcoreFactory.eINSTANCE.createInvocationContractContainer();
        invocationContractContainer.setInvocation(eefGen);

        InvocationContract invocationContract = FcoreFactory.eINSTANCE.createInvocationContract();
        invocationContract.setInvocationContractContainer(invocationContractContainer);
        invocationContract.setInvokedContract(activity.getContracts().get(0));

        TypeDomainURI typeDomainURI = DomainFactory.eINSTANCE.createTypeDomainURI();
        typeDomainURI.setDomain(genModelDomainURI);
        invocationContract.setType(typeDomainURI);

        InvocationContract inContract = FcoreFactory.eINSTANCE.createInvocationContract();
        inContract.setInvocationContractContainer(invocationContractContainer);
        inContract.setInvokedContract(activity.getContracts().get(1));

        typeDomainURI = DomainFactory.eINSTANCE.createTypeDomainURI();
        typeDomainURI.setDomain(eefDomainURI);
        inContract.setType(typeDomainURI);
    }

}
