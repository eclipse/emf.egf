/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.emf.pattern;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.domain.TypeDomainURI;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.InvocationContractContainer;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.egf.model.fprod.FprodFactory;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * @author Matthieu Helleboid
 * 
 */
public class FcoreUtil {

    protected IProject fcoreProject;

    protected Resource fcoreResource;
    protected Resource emfPatternResource;

    protected URI genModelURI;
    protected DomainURI genModelDomainURI;
    protected ProductionPlan productionPlan;

    private IFile genModelFile;

    protected class CreateCommand extends RecordingCommand {

        protected Exception exception;
        protected IProgressMonitor monitor;

        public CreateCommand(TransactionalEditingDomain domain, IProgressMonitor monitor) {
            super(domain);
            this.monitor = monitor;
        }

        @Override
        protected void doExecute() {
            // Create Factory Component
            FactoryComponent factoryComponent = FcoreFactory.eINSTANCE.createFactoryComponent();
            factoryComponent.setName(genModelFile.getName() + " EMF Pattern"); //$NON-NLS-1$

            fcoreResource.getContents().add(factoryComponent);

            // Create viewpoint container
            ViewpointContainer viewpointContainer = FcoreFactory.eINSTANCE.createViewpointContainer();
            factoryComponent.setViewpointContainer(viewpointContainer);

            // Create domainviewpoint
            DomainViewpoint domainViewpoint = DomainFactory.eINSTANCE.createDomainViewpoint();
            viewpointContainer.getViewpoints().add(domainViewpoint);

            // Create Genmodel domain
            genModelDomainURI = DomainFactory.eINSTANCE.createDomainURI();
            genModelDomainURI.setUri(genModelURI);
            domainViewpoint.getDomains().add(genModelDomainURI);

            // Create production plan
            productionPlan = FprodFactory.eINSTANCE.createProductionPlan();
            factoryComponent.setOrchestration(productionPlan);

            for (EObject eObject : emfPatternResource.getContents()) {
                if (eObject instanceof FactoryComponent) {
                    FactoryComponent targetFactoryComponent = (FactoryComponent) eObject;
                    for (PartType partType : PartType.values()) {
                        String name = PartType.getFactoryComponentName(partType);
                        if (name.equals(targetFactoryComponent.getName())) {
                            ProductionPlanInvocation productionPlanInvocation = FprodFactory.eINSTANCE.createProductionPlanInvocation();
                            productionPlanInvocation.setProductionPlan(productionPlan);
                            productionPlanInvocation.setInvokedActivity(targetFactoryComponent);

                            productionPlanInvocation.setName(name + " invocation"); //$NON-NLS-1$
                            InvocationContractContainer invocationContractContainer = FcoreFactory.eINSTANCE.createInvocationContractContainer();
                            invocationContractContainer.setInvocation(productionPlanInvocation);

                            InvocationContract invocationContract = FcoreFactory.eINSTANCE.createInvocationContract();
                            invocationContract.setInvocationContractContainer(invocationContractContainer);
                            invocationContract.setInvokedContract(targetFactoryComponent.getContracts().get(0));

                            TypeDomainURI typeDomainURI = DomainFactory.eINSTANCE.createTypeDomainURI();
                            typeDomainURI.setDomain(genModelDomainURI);
                            invocationContract.setType(typeDomainURI);
                        }
                    }
                }
            }
        }
    }

    public void createFcoreFile(IFile genModelFile, IFile fcoreFile, final IProgressMonitor monitor) throws Exception {
        this.genModelFile = genModelFile;

        final IOException[] ioExceptions = new IOException[1];

        // Retrieve our editing domain
        TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);

        // Feed our URIConverter
        URI platformPluginURI = URI.createPlatformPluginURI(fcoreFile.getFullPath().toString(), false);
        URI platformResourceURI = URI.createPlatformResourceURI(fcoreFile.getFullPath().toString(), true);
        editingDomain.getResourceSet().getURIConverter().getURIMap().put(platformPluginURI, platformResourceURI);

        genModelURI = URI.createPlatformResourceURI(genModelFile.getFullPath().toString(), true);
        // Create a resource for this file.
        fcoreResource = editingDomain.getResourceSet().createResource(platformPluginURI);

        URI emfPatternResourceURI = URI.createPlatformPluginURI("/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore", true); //$NON-NLS-1$
        emfPatternResource = editingDomain.getResourceSet().getResource(emfPatternResourceURI, true);

        // Add factory component to the contents.
        CreateCommand createCommand = new CreateCommand(editingDomain, monitor);
        editingDomain.getCommandStack().execute(createCommand);
        if (createCommand.exception != null)
            throw createCommand.exception;

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
}