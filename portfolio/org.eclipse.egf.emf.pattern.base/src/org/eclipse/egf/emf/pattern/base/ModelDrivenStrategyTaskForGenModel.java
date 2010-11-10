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

package org.eclipse.egf.emf.pattern.base;

import java.util.List;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.ftask.tasks.ModelDrivenStrategyTask;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;

/**
 * @author Matthieu Helleboid
 * 
 */
public class ModelDrivenStrategyTaskForGenModel extends ModelDrivenStrategyTask {

    @Override
    protected void readContext(ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        super.readContext(context, ctx);
        @SuppressWarnings("rawtypes")
        List objects = (List) ctx.getValue(PatternContext.DOMAIN_OBJECTS);
        for (Object object : objects) {
            if (object instanceof GenModel) {
                GenModel genModel = (GenModel) object;
                genModel.reconcile();
                genModel.setCanGenerate(true);
                genModel.setValidateModel(true);
                genModel.diagnose();
                genModel.validate();
            }
        }
    }

}
