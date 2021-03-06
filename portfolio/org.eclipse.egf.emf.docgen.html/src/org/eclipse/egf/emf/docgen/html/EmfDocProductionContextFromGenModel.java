/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.emf.docgen.html;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.domain.EgfResourceSet;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.domain.DomainException;
import org.eclipse.egf.domain.emf.EMFDomainHelper;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Matthieu Helleboid
 * 
 */
public class EmfDocProductionContextFromGenModel implements ITaskProduction {

	public void doExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
		URI genModelURI = productionContext.getInputValue("genModelURI", EMFDomain.class).getUri(); //$NON-NLS-1$

		ResourceSet resourceSet = new EgfResourceSet();
		Resource genModelResource = resourceSet.getResource(genModelURI, true);
		GenModel genModel = (GenModel) genModelResource.getContents().get(0);

		EMFDomain emfDomain = DomainFactory.eINSTANCE.createEMFDomain();
		emfDomain.setUri(genModelURI.trimSegments(1).appendSegment(genModel.getForeignModel().get(0)));
		try {
			new EMFDomainHelper().loadDomain(emfDomain);
		} catch (DomainException e) {
			throw new InvocationException(e);
		}

		productionContext.setOutputValue("docEcoreURI", emfDomain); //$NON-NLS-1$
		productionContext.setOutputValue("docProjectName", genModel.getModelPluginID() + ".doc"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
		// Nothing to do
	}

	public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
		// Nothing to do
	}

}
