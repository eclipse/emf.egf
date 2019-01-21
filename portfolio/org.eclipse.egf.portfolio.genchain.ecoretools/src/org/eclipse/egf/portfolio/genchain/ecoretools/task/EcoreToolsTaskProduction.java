/**
 * <copyright>
 *
 *  Copyright (c) 2014 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.portfolio.genchain.ecoretools.task;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.portfolio.genchain.ecoretools.operation.CreateEcoreTools2RepresentationOperation;
import org.eclipse.emf.common.util.URI;

/**
 * 
 * @author Boubekeur Zendagui
 */
public class EcoreToolsTaskProduction implements ITaskProduction {

	
	public void doExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {

	}

	public void postExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
		URI ecoreUri = productionContext.getInputValue("model", URI.class);
		String fileName = productionContext.getInputValue("fileName", String.class);

		CreateEcoreTools2RepresentationOperation operation = new CreateEcoreTools2RepresentationOperation(ecoreUri, fileName);
		try {
			operation.run(monitor);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void preExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {

	}

}
