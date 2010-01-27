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
package org.eclipse.egf.pattern.ftask.tasks;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.pattern.strategy.modeldriven.ModelDrivenStrategy;

/**
 * @author Thomas Guiu
 */
public class ModelDrivenStrategyTask extends AbstractStrategyTask {

    public ModelDrivenStrategyTask() {
        super(new ModelDrivenStrategy());
    }

    public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
        super.preExecute(context, monitor);
        parameter = this; // must be non null
    }
}
