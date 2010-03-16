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
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.egf.model.fprod.FprodFactory;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class CreateFcoreUtil {

  public void createFcoreFile(IFile genModelFile, IPath fcoreFullPath) throws IOException {
    URI genModelURI = URI.createPlatformResourceURI(genModelFile.getFullPath().toString(), true);
    IFile fcoreFile = ResourcesPlugin.getWorkspace().getRoot().getFile(fcoreFullPath);

    ResourceSetImpl resourceSet = new ResourceSetImpl();
    Resource fcoreResource = ResourceHelper.createResource(resourceSet, fcoreFile);

    // Load target fcores
    URI emfWrapperResourceURI = URI.createPlatformPluginURI("/org.eclipse.egf.emf.wrapper/fcs/EMF_Wrapper.fcore", true); //$NON-NLS-1$
    Resource emfWrapperResource = ResourceHelper.loadResource(resourceSet, emfWrapperResourceURI);
    URI emfDocGenHtmlResourceURI = URI.createPlatformPluginURI("/org.eclipse.egf.emf.docgen.html/egf/EmfDocGenHtml.fcore", true); //$NON-NLS-1$
    Resource emfDocGenHtmlResource = ResourceHelper.loadResource(resourceSet, emfDocGenHtmlResourceURI);

    // Create Factory Component
    FactoryComponent factoryComponent = FcoreFactory.eINSTANCE.createFactoryComponent();
    factoryComponent.setName(genModelFile.getName() + " EMF Wrapper"); //$NON-NLS-1$

    // Create viewpoint container
    ViewpointContainer viewpointContainer = FcoreFactory.eINSTANCE.createViewpointContainer();
    factoryComponent.setViewpointContainer(viewpointContainer);

    // Create domainviewpoint
    DomainViewpoint domainViewpoint = DomainFactory.eINSTANCE.createDomainViewpoint();
    viewpointContainer.getViewpoints().add(domainViewpoint);

    // Create Genmodel domain
    DomainURI genModelDomainURI = DomainFactory.eINSTANCE.createDomainURI();
    genModelDomainURI.setUri(genModelURI);
    domainViewpoint.getDomains().add(genModelDomainURI);

    // Create production plan
    ProductionPlan productionPlan = FprodFactory.eINSTANCE.createProductionPlan();
    factoryComponent.setOrchestration(productionPlan);

    // Use independant tasks or the complete factory component
    boolean splitted = true;

    if (splitted) {
      // Create Emf Wrapper tasks invocations
      createTaskInvocation("_E0utcP-KEd6BleG0RKg98A", "_GjcSAP-KEd6BleG0RKg98A", emfWrapperResource, productionPlan, genModelDomainURI); //$NON-NLS-1$ //$NON-NLS-2$
      createTaskInvocation("_o5wBQADyEd-IF6GN14qe5g", "_x4zwsAEjEd-sEofCqqFtwA", emfWrapperResource, productionPlan, genModelDomainURI); //$NON-NLS-1$ //$NON-NLS-2$
      createTaskInvocation("_tWWIYADyEd-IF6GN14qe5g", "_xzsdcQDyEd-IF6GN14qe5g", emfWrapperResource, productionPlan, genModelDomainURI); //$NON-NLS-1$ //$NON-NLS-2$
      createTaskInvocation("_tv0_YADyEd-IF6GN14qe5g", "_x7JJQQDyEd-IF6GN14qe5g", emfWrapperResource, productionPlan, genModelDomainURI); //$NON-NLS-1$ //$NON-NLS-2$
    } else {
      FactoryComponent targetFactoryComponent = (FactoryComponent) emfWrapperResource.getEObject("_9LH9AAEkEd-sEofCqqFtwA"); //$NON-NLS-1$
      ProductionPlanInvocation productionPlanInvocation = FprodFactory.eINSTANCE.createProductionPlanInvocation();
      productionPlan.getInvocations().add(productionPlanInvocation);
      productionPlanInvocation.setInvokedActivity(targetFactoryComponent);

      InvocationContractContainer invocationContractContainer = FcoreFactory.eINSTANCE.createInvocationContractContainer();
      productionPlanInvocation.setInvocationContractContainer(invocationContractContainer);

      FactoryComponentContract targetFactoryComponentContract = (FactoryComponentContract) emfWrapperResource.getEObject("_1Cin4AQ7Ed-C2pVDwEnEWQ"); //$NON-NLS-1$
      InvocationContract invocationContract = FcoreFactory.eINSTANCE.createInvocationContract();
      invocationContractContainer.getInvocationContracts().add(invocationContract);
      invocationContract.setInvokedContract(targetFactoryComponentContract);

      TypeDomainURI typeDomainURI = DomainFactory.eINSTANCE.createTypeDomainURI();
      typeDomainURI.setDomain(genModelDomainURI);
      invocationContract.setType(typeDomainURI);
    }

    // Create emf doc html generation
    createEmfDocGenHtmlInvocation(emfWrapperResource, emfDocGenHtmlResource, productionPlan, genModelDomainURI);

    // Save created Fcore
    fcoreResource.getContents().add(factoryComponent);
    fcoreResource.save(Collections.EMPTY_MAP);
  }

  private void createEmfDocGenHtmlInvocation(Resource emfWrapperResource, Resource emfDocGenHtmlResource, ProductionPlan productionPlan, DomainURI genModelDomainURI) {
    // Task EmfDocProductionContextFromGenModel
    Task task = (Task) emfDocGenHtmlResource.getEObject("_yw92cBurEd-jaIqWGhF8eQ"); //$NON-NLS-1$
    ProductionPlanInvocation taskProductionPlanInvocation = FprodFactory.eINSTANCE.createProductionPlanInvocation();
    productionPlan.getInvocations().add(taskProductionPlanInvocation);
    taskProductionPlanInvocation.setInvokedActivity(task);

    InvocationContractContainer taskInvocationContractContainer = FcoreFactory.eINSTANCE.createInvocationContractContainer();
    taskProductionPlanInvocation.setInvocationContractContainer(taskInvocationContractContainer);

    Contract taskContract1 = (Contract) emfDocGenHtmlResource.getEObject("_A4ZrMBusEd-jaIqWGhF8eQ"); //$NON-NLS-1$
    InvocationContract taskInvocationContract1 = FcoreFactory.eINSTANCE.createInvocationContract();
    taskInvocationContractContainer.getInvocationContracts().add(taskInvocationContract1);
    taskInvocationContract1.setInvokedContract(taskContract1);
    TypeDomainURI typeDomainURI = DomainFactory.eINSTANCE.createTypeDomainURI();
    typeDomainURI.setDomain(genModelDomainURI);
    taskInvocationContract1.setType(typeDomainURI);

    Contract taskContract2 = (Contract) emfDocGenHtmlResource.getEObject("_Do1LcBusEd-jaIqWGhF8eQ"); //$NON-NLS-1$
    InvocationContract taskInvocationContract2 = FcoreFactory.eINSTANCE.createInvocationContract();
    taskInvocationContractContainer.getInvocationContracts().add(taskInvocationContract2);
    taskInvocationContract2.setInvokedContract(taskContract2);

    Contract taskContract3 = (Contract) emfDocGenHtmlResource.getEObject("_EAYIwBusEd-jaIqWGhF8eQ"); //$NON-NLS-1$
    InvocationContract taskInvocationContract3 = FcoreFactory.eINSTANCE.createInvocationContract();
    taskInvocationContractContainer.getInvocationContracts().add(taskInvocationContract3);
    taskInvocationContract3.setInvokedContract(taskContract3);

    // FC EmfDocGenHtml
    FactoryComponent fc = (FactoryComponent) emfDocGenHtmlResource.getEObject("_BxjIkAG0Ed-7fNNmMjB2jQ"); //$NON-NLS-1$
    ProductionPlanInvocation fcProductionPlanInvocation = FprodFactory.eINSTANCE.createProductionPlanInvocation();
    productionPlan.getInvocations().add(fcProductionPlanInvocation);
    fcProductionPlanInvocation.setInvokedActivity(fc);

    InvocationContractContainer invocationContractContainer = FcoreFactory.eINSTANCE.createInvocationContractContainer();
    fcProductionPlanInvocation.setInvocationContractContainer(invocationContractContainer);

    FactoryComponentContract fcContract1 = (FactoryComponentContract) emfDocGenHtmlResource.getEObject("_Yp4VcAprEd-7fqY_JLtg2w"); //$NON-NLS-1$
    InvocationContract fcInvocationContract1 = FcoreFactory.eINSTANCE.createInvocationContract();
    invocationContractContainer.getInvocationContracts().add(fcInvocationContract1);
    fcInvocationContract1.setInvokedContract(fcContract1);

    FactoryComponentContract fcContract2 = (FactoryComponentContract) emfDocGenHtmlResource.getEObject("_7NKWkApbEd-pyqf4uNW3tw"); //$NON-NLS-1$
    InvocationContract fcInvocationContract2 = FcoreFactory.eINSTANCE.createInvocationContract();
    invocationContractContainer.getInvocationContracts().add(fcInvocationContract2);
    fcInvocationContract2.setInvokedContract(fcContract2);

    FactoryComponentContract fcContract3 = (FactoryComponentContract) emfDocGenHtmlResource.getEObject("_AvXa4ApcEd-pyqf4uNW3tw"); //$NON-NLS-1$
    InvocationContract fcInvocationContract3 = FcoreFactory.eINSTANCE.createInvocationContract();
    invocationContractContainer.getInvocationContracts().add(fcInvocationContract3);
    fcInvocationContract3.setInvokedContract(fcContract3);
    TypeString typeString = TypesFactory.eINSTANCE.createTypeString();
    typeString.setValue("html"); //$NON-NLS-1$
    fcInvocationContract3.setType(typeString);

    // Assign source
    fcInvocationContract1.setSourceInvocationContract(taskInvocationContract2);
    fcInvocationContract2.setSourceInvocationContract(taskInvocationContract3);

  }

  private void createTaskInvocation(String targetTaskId, String targetTaskContract, Resource targetActivityResource, ProductionPlan productionPlan, DomainURI genModelDomainURI) {
    Task modelTask = (Task) targetActivityResource.getEObject(targetTaskId);
    ProductionPlanInvocation productionPlanInvocation = FprodFactory.eINSTANCE.createProductionPlanInvocation();
    productionPlan.getInvocations().add(productionPlanInvocation);
    productionPlanInvocation.setInvokedActivity(modelTask);

    InvocationContractContainer invocationContractContainer = FcoreFactory.eINSTANCE.createInvocationContractContainer();
    productionPlanInvocation.setInvocationContractContainer(invocationContractContainer);

    Contract targetContract = (Contract) targetActivityResource.getEObject(targetTaskContract);
    InvocationContract invocationContract = FcoreFactory.eINSTANCE.createInvocationContract();
    invocationContractContainer.getInvocationContracts().add(invocationContract);
    invocationContract.setInvokedContract(targetContract);

    TypeDomainURI typeDomainURI = DomainFactory.eINSTANCE.createTypeDomainURI();
    typeDomainURI.setDomain(genModelDomainURI);
    invocationContract.setType(typeDomainURI);
  }
}
