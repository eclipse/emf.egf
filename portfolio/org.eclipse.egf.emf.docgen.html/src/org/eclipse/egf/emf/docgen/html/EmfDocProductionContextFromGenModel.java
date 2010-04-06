/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.emf.docgen.html;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * @author Matthieu Helleboid
 *
 */
public class EmfDocProductionContextFromGenModel implements ITaskProduction {

    public void doExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
        URI genModelURI = productionContext.getInputValue("genModelURI", URI.class);
        
        ResourceSetImpl resourceSet = new ResourceSetImpl();
        Resource genModelResource = resourceSet.getResource(genModelURI, true);
        GenModel genModel = (GenModel) genModelResource.getContents().get(0);

        URI ecoreURI = genModelURI.trimSegments(1).appendSegment(genModel.getForeignModel().get(0));

        productionContext.setOutputValue("docEcoreURI", ecoreURI);
        productionContext.setOutputValue("docProjectName", genModel.getModelPluginID() + ".doc");
    }

    public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    }

    public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    }

}