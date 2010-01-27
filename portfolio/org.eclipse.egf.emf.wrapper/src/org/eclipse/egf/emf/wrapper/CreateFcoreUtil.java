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
package org.eclipse.egf.emf.wrapper;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.core.helper.ResourceHelper;
import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.domain.TypeDomainURI;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.InvocationContractContainer;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fcore.OrchestrationParameterContainer;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.egf.model.fprod.FprodFactory;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.egf.model.ftask.TaskJava;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class CreateFcoreUtil {

  public void createFcoreFile(IFile genModelFile, IPath fcoreFullPath) throws IOException {
    URI genModelURI = URI.createPlatformResourceURI(genModelFile.getFullPath().toString(), true);
    IFile fcoreFile = ResourcesPlugin.getWorkspace().getRoot().getFile(fcoreFullPath);

    ResourceSetImpl resourceSet = new ResourceSetImpl();
    Resource fcoreResource = ResourceHelper.createResource(resourceSet, fcoreFile);
    URI targetActivityResourceURI = URI.createPlatformPluginURI("/org.eclipse.egf.emf.wrapper/fcs/EMF_Wrapper.fcore", true); //$NON-NLS-1$
    Resource targetActivityResource = ResourceHelper.loadResource(resourceSet, targetActivityResourceURI);

    FactoryComponent factoryComponent = FcoreFactory.eINSTANCE.createFactoryComponent();
    factoryComponent.setName(genModelFile.getName() + " EMF Wrapper"); //$NON-NLS-1$

    ViewpointContainer viewpointContainer = FcoreFactory.eINSTANCE.createViewpointContainer();
    factoryComponent.setViewpointContainer(viewpointContainer);

    DomainViewpoint domainViewpoint = DomainFactory.eINSTANCE.createDomainViewpoint();
    DomainURI domainURI = DomainFactory.eINSTANCE.createDomainURI();
    domainURI.setUri(genModelURI);
    domainViewpoint.getDomains().add(domainURI);
    viewpointContainer.getViewpoints().add(domainViewpoint);

    ProductionPlan productionPlan = FprodFactory.eINSTANCE.createProductionPlan();
    factoryComponent.setOrchestration(productionPlan);

    boolean splitted = true;

    if (splitted) {
      OrchestrationParameterContainer orchestrationParameterContainer = FcoreFactory.eINSTANCE.createOrchestrationParameterContainer();
      productionPlan.setOrchestrationParameterContainer(orchestrationParameterContainer);

      OrchestrationParameter orchestrationParameter = FcoreFactory.eINSTANCE.createOrchestrationParameter();
      orchestrationParameterContainer.getOrchestrationParameters().add(orchestrationParameter);

      TypeDomainURI typeDomainURI = DomainFactory.eINSTANCE.createTypeDomainURI();
      typeDomainURI.setDomain(domainURI);
      orchestrationParameter.setType(typeDomainURI);

      createTaskInvocation("_E0utcP-KEd6BleG0RKg98A", "_GjcSAP-KEd6BleG0RKg98A", targetActivityResource, productionPlan, orchestrationParameter); //$NON-NLS-1$ //$NON-NLS-2$
      createTaskInvocation("_o5wBQADyEd-IF6GN14qe5g", "_x4zwsAEjEd-sEofCqqFtwA", targetActivityResource, productionPlan, orchestrationParameter); //$NON-NLS-1$ //$NON-NLS-2$
      createTaskInvocation("_tWWIYADyEd-IF6GN14qe5g", "_xzsdcQDyEd-IF6GN14qe5g", targetActivityResource, productionPlan, orchestrationParameter); //$NON-NLS-1$ //$NON-NLS-2$
      createTaskInvocation("_tv0_YADyEd-IF6GN14qe5g", "_x7JJQQDyEd-IF6GN14qe5g", targetActivityResource, productionPlan, orchestrationParameter); //$NON-NLS-1$ //$NON-NLS-2$
    } else {
      FactoryComponent targetFactoryComponent = (FactoryComponent) targetActivityResource.getEObject("_9LH9AAEkEd-sEofCqqFtwA"); //$NON-NLS-1$
      ProductionPlanInvocation productionPlanInvocation = FprodFactory.eINSTANCE.createProductionPlanInvocation();
      productionPlan.getInvocations().add(productionPlanInvocation);
      productionPlanInvocation.setInvokedActivity(targetFactoryComponent);

      InvocationContractContainer invocationContractContainer = FcoreFactory.eINSTANCE.createInvocationContractContainer();
      productionPlanInvocation.setInvocationContractContainer(invocationContractContainer);

      FactoryComponentContract targetFactoryComponentContract = (FactoryComponentContract) targetActivityResource.getEObject("_1Cin4AQ7Ed-C2pVDwEnEWQ"); //$NON-NLS-1$
      InvocationContract invocationContract = FcoreFactory.eINSTANCE.createInvocationContract();
      invocationContractContainer.getInvocationContracts().add(invocationContract);
      invocationContract.setInvokedContract(targetFactoryComponentContract);

      TypeDomainURI typeDomainURI = DomainFactory.eINSTANCE.createTypeDomainURI();
      typeDomainURI.setDomain(domainURI);
      invocationContract.setType(typeDomainURI);
    }

    fcoreResource.getContents().add(factoryComponent);
    fcoreResource.save(Collections.EMPTY_MAP);
  }

  private void createTaskInvocation(String targetTaskId, String targetTaskContract, Resource targetActivityResource, ProductionPlan productionPlan, OrchestrationParameter orchestrationParameter) {
    TaskJava modelTask = (TaskJava) targetActivityResource.getEObject(targetTaskId);
    ProductionPlanInvocation productionPlanInvocation = FprodFactory.eINSTANCE.createProductionPlanInvocation();
    productionPlan.getInvocations().add(productionPlanInvocation);
    productionPlanInvocation.setInvokedActivity(modelTask);

    InvocationContractContainer invocationContractContainer = FcoreFactory.eINSTANCE.createInvocationContractContainer();
    productionPlanInvocation.setInvocationContractContainer(invocationContractContainer);

    Contract targetContract = (Contract) targetActivityResource.getEObject(targetTaskContract);
    InvocationContract invocationContract = FcoreFactory.eINSTANCE.createInvocationContract();
    invocationContractContainer.getInvocationContracts().add(invocationContract);
    invocationContract.setInvokedContract(targetContract);
    invocationContract.setOrchestrationParameter(orchestrationParameter);
  }
}
