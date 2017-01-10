/**
 * <copyright>
 *
 *  Copyright (c) 2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.portfolio.genchain.tools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.egf.core.domain.EgfResourceSet;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.ftask.tasks.DomainDrivenStrategyTask;
import org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement;
import org.eclipse.egf.portfolio.genchain.tools.utils.ActivityInvocationHelper;
import org.eclipse.egf.portfolio.genchain.tools.utils.FCMatcher;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * 
 * @author Thomas Guiu
 */
public class FcoreBuilderTask extends DomainDrivenStrategyTask {

	@Override
	protected void readContext(final ITaskProductionContext context, PatternContext ctx) throws InvocationException {

		super.readContext(context, ctx);
		// Create FC
		String name = (String) ctx.getValue(FcoreBuilderConstants.NAME);

		ResourceSet resourceSet = new EgfResourceSet();

		Collection<FactoryComponent> unusedFC = new ArrayList<FactoryComponent>();
		URI fcoreUri = URI.createPlatformResourceURI((String) ctx.getValue(FcoreBuilderConstants.FCORE_OUTPUT_PATH), true);
		FactoryComponent mainFC = null;

		Resource resource = null;
		try {
			resource = resourceSet.getResource(fcoreUri, true);
			for (EObject obj : resource.getContents()) {
				if (obj instanceof FactoryComponent) {
					FactoryComponent fc = (FactoryComponent) obj;
					if (FCMatcher.isLauncherFC(fc)) {
						mainFC = fc;
						ActivityInvocationHelper.clearOrchestration(fc);
					} else
						unusedFC.add(fc);
				}
			}

			// TODO match de fc,
		} catch (Exception e) {
			resource = resourceSet.createResource(fcoreUri);
		}

		if (mainFC == null) {
			mainFC = ActivityInvocationHelper.createDefaultFC(name + " Launcher"); //$NON-NLS-1$
			resource.getContents().add(mainFC);
		}

		Map<GenerationElement, FactoryComponent> fcs = new HashMap<GenerationElement, FactoryComponent>();
		fcs.put(null, mainFC);
		ctx.setValue(FcoreBuilderConstants.MAIN_FCORE, mainFC);
		ctx.setValue(FcoreBuilderConstants.CURRENT_FCORE, fcs);

		ctx.setValue(FcoreBuilderConstants.GENMODEL_URIS, new HashMap<String, URI>());
		ctx.setValue(FcoreBuilderConstants.UNUSED_FCORE, unusedFC);
		ctx.setValue(FcoreBuilderConstants.RESOURCE_SET, resourceSet);

	}

}
