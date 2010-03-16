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
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.core.EGFCorePlugin;
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
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public class CreateFcoreUtil {

  public void createFcoreFile(IFile genModelFile, IFile fcore) throws IOException {

    final IOException[] ioExceptions = new IOException[1];

    // Retrieve our editing domain
    final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
    // Feed our URIConverter
    URI platformPluginURI = URI.createPlatformPluginURI(fcore.getFullPath().toString(), false);
    URI platformResourceURI = URI.createPlatformResourceURI(fcore.getFullPath().toString(), true);
    editingDomain.getResourceSet().getURIConverter().getURIMap().put(platformPluginURI, platformResourceURI);

    URI genModelURI = URI.createPlatformResourceURI(genModelFile.getFullPath().toString(), true);

    // Create a resource for this file.
    final Resource fcoreResource = editingDomain.getResourceSet().createResource(platformPluginURI);

    // Compute ecore values
    Resource genModelResource = editingDomain.getResourceSet().getResource(genModelURI, true);
    GenModel genModel = (GenModel) genModelResource.getContents().get(0);
    IPath ecoreFullPath = genModelFile.getFullPath().removeLastSegments(1).append(genModel.getForeignModel().get(0));
    URI ecoreURI = URI.createPlatformResourceURI(ecoreFullPath.toString(), true);
    String modelPluginID = genModel.getModelPluginID();

    // Load target fcores
    URI emfWrapperResourceURI = URI.createPlatformPluginURI("/org.eclipse.egf.emf.wrapper/fcs/EMF_Wrapper.fcore", true); //$NON-NLS-1$
    Resource emfWrapperResource = editingDomain.getResourceSet().getResource(emfWrapperResourceURI, true);
    URI emfDocGenHtmlResourceURI = URI.createPlatformPluginURI("/org.eclipse.egf.emf.docgen.html/egf/EmfDocGenHtml.fcore", true); //$NON-NLS-1$
    Resource emfDocGenHtmlResource = editingDomain.getResourceSet().getResource(emfDocGenHtmlResourceURI, true);

    // Create Factory Component
    final FactoryComponent factoryComponent = FcoreFactory.eINSTANCE.createFactoryComponent();
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

    // Create Ecore domain
    DomainURI ecoreDomainURI = DomainFactory.eINSTANCE.createDomainURI();
    ecoreDomainURI.setUri(ecoreURI);
    domainViewpoint.getDomains().add(ecoreDomainURI);

    // Create production plan
    ProductionPlan productionPlan = FprodFactory.eINSTANCE.createProductionPlan();
    factoryComponent.setOrchestration(productionPlan);

    // Use independant tasks or the complete factory component
    boolean splitted = true;

    if (splitted) {
      // Create Orchestration parameter container
      OrchestrationParameterContainer orchestrationParameterContainer = FcoreFactory.eINSTANCE.createOrchestrationParameterContainer();
      productionPlan.setOrchestrationParameterContainer(orchestrationParameterContainer);

      // Create Orchestration parameter
      OrchestrationParameter orchestrationParameter = FcoreFactory.eINSTANCE.createOrchestrationParameter();
      orchestrationParameterContainer.getOrchestrationParameters().add(orchestrationParameter);

      // Use domain uri
      TypeDomainURI typeDomainURI = DomainFactory.eINSTANCE.createTypeDomainURI();
      typeDomainURI.setDomain(genModelDomainURI);
      orchestrationParameter.setType(typeDomainURI);

      // Create Emf Wrapper tasks invocations
      createTaskInvocation("_E0utcP-KEd6BleG0RKg98A", "_GjcSAP-KEd6BleG0RKg98A", emfWrapperResource, productionPlan, orchestrationParameter); //$NON-NLS-1$ //$NON-NLS-2$
      createTaskInvocation("_o5wBQADyEd-IF6GN14qe5g", "_x4zwsAEjEd-sEofCqqFtwA", emfWrapperResource, productionPlan, orchestrationParameter); //$NON-NLS-1$ //$NON-NLS-2$
      createTaskInvocation("_tWWIYADyEd-IF6GN14qe5g", "_xzsdcQDyEd-IF6GN14qe5g", emfWrapperResource, productionPlan, orchestrationParameter); //$NON-NLS-1$ //$NON-NLS-2$
      createTaskInvocation("_tv0_YADyEd-IF6GN14qe5g", "_x7JJQQDyEd-IF6GN14qe5g", emfWrapperResource, productionPlan, orchestrationParameter); //$NON-NLS-1$ //$NON-NLS-2$
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
    createEmfDocGenHtmlInvocation(emfWrapperResource, emfDocGenHtmlResource, productionPlan, ecoreDomainURI, modelPluginID);

    // Add factory component to the contents.
    editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
      @Override
      protected void doExecute() {
        fcoreResource.getContents().add(factoryComponent);
      }
    });

    // save fcore
    try {
      editingDomain.runExclusive(new Runnable() {
        public void run() {
          try {
            fcoreResource.save(Collections.EMPTY_MAP);
          } catch (IOException ioe) {
            ioExceptions[0] = ioe;
          }
        }
      });
    } catch (InterruptedException ie) {
      return;
    }

    // Rethrow exception if any
    if (ioExceptions[0] != null) {
      throw ioExceptions[0];
    }

    return;

  }

  private void createEmfDocGenHtmlInvocation(Resource emfWrapperResource, Resource emfDocGenHtmlResource, ProductionPlan productionPlan, DomainURI ecoreDomainURI, String modelPluginID) {
    FactoryComponent targetFactoryComponent = (FactoryComponent) emfDocGenHtmlResource.getEObject("_BxjIkAG0Ed-7fNNmMjB2jQ"); //$NON-NLS-1$
    ProductionPlanInvocation productionPlanInvocation = FprodFactory.eINSTANCE.createProductionPlanInvocation();
    productionPlan.getInvocations().add(productionPlanInvocation);
    productionPlanInvocation.setInvokedActivity(targetFactoryComponent);

    InvocationContractContainer invocationContractContainer = FcoreFactory.eINSTANCE.createInvocationContractContainer();
    productionPlanInvocation.setInvocationContractContainer(invocationContractContainer);

    FactoryComponentContract targetFactoryComponentContract1 = (FactoryComponentContract) emfDocGenHtmlResource.getEObject("_Yp4VcAprEd-7fqY_JLtg2w"); //$NON-NLS-1$
    InvocationContract invocationContract1 = FcoreFactory.eINSTANCE.createInvocationContract();
    invocationContractContainer.getInvocationContracts().add(invocationContract1);
    invocationContract1.setInvokedContract(targetFactoryComponentContract1);
    TypeDomainURI type1 = DomainFactory.eINSTANCE.createTypeDomainURI();
    type1.setDomain(ecoreDomainURI);
    invocationContract1.setType(type1);

    FactoryComponentContract targetFactoryComponentContract2 = (FactoryComponentContract) emfDocGenHtmlResource.getEObject("_7NKWkApbEd-pyqf4uNW3tw"); //$NON-NLS-1$
    InvocationContract invocationContract2 = FcoreFactory.eINSTANCE.createInvocationContract();
    invocationContractContainer.getInvocationContracts().add(invocationContract2);
    invocationContract2.setInvokedContract(targetFactoryComponentContract2);
    TypeString type2 = TypesFactory.eINSTANCE.createTypeString();
    type2.setValue(modelPluginID + ".doc"); //$NON-NLS-1$
    invocationContract2.setType(type2);

    FactoryComponentContract targetFactoryComponentContract3 = (FactoryComponentContract) emfDocGenHtmlResource.getEObject("_AvXa4ApcEd-pyqf4uNW3tw"); //$NON-NLS-1$
    InvocationContract invocationContract3 = FcoreFactory.eINSTANCE.createInvocationContract();
    invocationContractContainer.getInvocationContracts().add(invocationContract3);
    invocationContract3.setInvokedContract(targetFactoryComponentContract3);
    TypeString type3 = TypesFactory.eINSTANCE.createTypeString();
    type3.setValue("html"); //$NON-NLS-1$
    invocationContract3.setType(type3);
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
