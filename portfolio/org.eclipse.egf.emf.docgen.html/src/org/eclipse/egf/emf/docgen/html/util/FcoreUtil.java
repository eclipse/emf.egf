/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.emf.docgen.html.util;

import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.model.domain.TypeDomain;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.InvocationContractContainer;
import org.eclipse.egf.model.fprod.FprodFactory;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author Matthieu Helleboid
 *
 */
public class FcoreUtil {

    public static void createEmfDocGenHtmlInvocation(EditingDomain editingDomain, ProductionPlan productionPlan, EMFDomain genModelEMFDomain) {
        URI emfDocGenHtmlResourceURI = URI.createPlatformPluginURI("/org.eclipse.egf.emf.docgen.html/egf/EmfDocGenHtml.fcore", true); //$NON-NLS-1$
        Resource emfDocGenHtmlResource = editingDomain.getResourceSet().getResource(emfDocGenHtmlResourceURI, true);
    
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
        TypeDomain typeEMFDomain = DomainFactory.eINSTANCE.createTypeDomain();
        typeEMFDomain.setDomain(genModelEMFDomain);
        taskInvocationContract1.setType(typeEMFDomain);
    
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

}
