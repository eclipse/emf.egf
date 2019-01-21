/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.emf.wrapper;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.emf.docgen.html.util.FcoreUtil;
import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.domain.TypeDomain;
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

    // Load target fcores
    URI emfWrapperResourceURI = URI.createPlatformPluginURI("/org.eclipse.egf.emf.wrapper/fcs/EMF_Wrapper.fcore", true); //$NON-NLS-1$
    Resource emfWrapperResource = editingDomain.getResourceSet().getResource(emfWrapperResourceURI, true);

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
    EMFDomain genModelEMFDomain = DomainFactory.eINSTANCE.createEMFDomain();
    genModelEMFDomain.setUri(genModelURI);
    domainViewpoint.getDomains().add(genModelEMFDomain);

    // Create production plan
    ProductionPlan productionPlan = FprodFactory.eINSTANCE.createProductionPlan();
    factoryComponent.setOrchestration(productionPlan);

    // Use independant tasks or the complete factory component
    boolean splitted = true;

    if (splitted) {
      // Create Emf Wrapper tasks invocations
      createTaskInvocation("_E0utcP-KEd6BleG0RKg98A", "_GjcSAP-KEd6BleG0RKg98A", emfWrapperResource, productionPlan, genModelEMFDomain); //$NON-NLS-1$ //$NON-NLS-2$
      createTaskInvocation("_o5wBQADyEd-IF6GN14qe5g", "_x4zwsAEjEd-sEofCqqFtwA", emfWrapperResource, productionPlan, genModelEMFDomain); //$NON-NLS-1$ //$NON-NLS-2$
      createTaskInvocation("_tWWIYADyEd-IF6GN14qe5g", "_xzsdcQDyEd-IF6GN14qe5g", emfWrapperResource, productionPlan, genModelEMFDomain); //$NON-NLS-1$ //$NON-NLS-2$
      createTaskInvocation("_tv0_YADyEd-IF6GN14qe5g", "_x7JJQQDyEd-IF6GN14qe5g", emfWrapperResource, productionPlan, genModelEMFDomain); //$NON-NLS-1$ //$NON-NLS-2$
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

      TypeDomain typeEMFDomain = DomainFactory.eINSTANCE.createTypeDomain();
      typeEMFDomain.setDomain(genModelEMFDomain);
      invocationContract.setType(typeEMFDomain);
    }

    // Create emf doc html generation
    FcoreUtil.createEmfDocGenHtmlInvocation(editingDomain, productionPlan, genModelEMFDomain);

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

  private void createTaskInvocation(String targetTaskId, String targetTaskContract, Resource targetActivityResource, ProductionPlan productionPlan, EMFDomain genModelEMFDomain) {
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

    TypeDomain typeEMFDomain = DomainFactory.eINSTANCE.createTypeDomain();
    typeEMFDomain.setDomain(genModelEMFDomain);
    invocationContract.setType(typeEMFDomain);
  }
}
