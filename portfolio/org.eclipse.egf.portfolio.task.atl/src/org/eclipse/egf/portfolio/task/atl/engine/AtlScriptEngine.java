/**
 * <copyright>
 * 
 * Copyright (c) 2009-2011 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.portfolio.task.atl.engine;

import java.net.URL;
import java.util.Collections;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.core.service.CoreService;

/**
 * @author Florian Barbin
 * 
 */

public class AtlScriptEngine {

	public void executeAtlTask(String value,
			ITaskProductionContext productionContext, SubMonitor subMonitor)
			throws InvocationException {
		URI metaModelURI = productionContext.getInputValue("metaModelURI",
				URI.class);
		URI modelIN = productionContext.getInputValue("modelIN", URI.class);

		URI modelOUT = productionContext.getInputValue("modelOUT", URI.class);

		URI asmURI = URI.createURI(value);
		try {
			URL asmURL = new URL(asmURI.toString());
			IInjector injector = CoreService.getInjector("EMF");
			IExtractor extractor = CoreService.getExtractor("EMF");

			// Defaults
			ModelFactory factory = CoreService.getModelFactory("EMF");

			// Metamodels
			IReferenceModel umlMetamodel = factory.newReferenceModel();
			injector.inject(umlMetamodel, metaModelURI.toString());
			IReferenceModel outMetamodel = factory
					.getBuiltInResource("RefiningTrace.ecore");
			
			// Getting launcher
			ILauncher launcher = null;
			launcher = CoreService.getLauncher("EMF-specific VM");
			launcher.initialize(Collections.<String, Object> emptyMap());

			// Creating models
			IModel refiningTraceModel = factory.newModel(outMetamodel);
			IModel umlModel = factory.newModel(umlMetamodel);
			
			// Loading existing model
			injector.inject(umlModel, modelIN.toString());
			
			// Launching

			launcher.addOutModel(refiningTraceModel, "refiningTrace",
					"RefiningTrace");
			launcher.addInOutModel(umlModel, "IN", "UML");

			launcher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(),
					Collections.<String, Object> emptyMap(), asmURL
							.openStream());

			// Saving model
			extractor.extract(umlModel, modelOUT.toString());
		} catch (Exception e) {
			throw new InvocationException(e.getMessage());
		}

	}

}
