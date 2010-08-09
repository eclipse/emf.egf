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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.egf.core.domain.EGFResourceSet;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.ftask.tasks.ModelDrivenStrategyTask;
import org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement;
import org.eclipse.egf.portfolio.genchain.tools.utils.ActivityInvocationHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * 
 * @author Thomas Guiu
 */
public class FcoreBuilderTask extends ModelDrivenStrategyTask {
    protected void readContext(final ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        super.readContext(context, ctx);
        // Creqte FC
        String name = (String) ctx.getValue(FcoreBuilderConstants.NAME);

        FactoryComponent fc = ActivityInvocationHelper.createDefaultFC(name + " Launcher");

        EGFResourceSet resourceSet = new EGFResourceSet();

        String path = (String) ctx.getValue(FcoreBuilderConstants.FCORE_OUTPUT_PATH);
        Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(path, true));
        resource.getContents().add(fc);
        ctx.setValue(FcoreBuilderConstants.MAIN_FCORE, fc);
        ctx.setValue(FcoreBuilderConstants.RESOURCE_SET, resourceSet);

        Map<GenerationElement, FactoryComponent> fcs = new HashMap<GenerationElement, FactoryComponent>();
        fcs.put(null, fc);
        ctx.setValue(FcoreBuilderConstants.CURRENT_FCORE, fcs);

        ctx.setValue(FcoreBuilderConstants.GENMODEL_URIS, new HashMap<EmfGeneration, URI>());
    }

}
