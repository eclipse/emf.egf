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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;

/**
 * 
 * @author Thomas Guiu
 */
public class ReadBuildModelTask implements ITaskProduction, FcoreBuilderConstants {

    public void doExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
        String name = (String) productionContext.getInputValue(PLUGIN_NAME, String.class);
        String modelName = (String) productionContext.getInputValue(MODEL_NAME, String.class);
        productionContext.setOutputValue(FCORE_OUTPUT_PATH, name + "/model/" + modelName + ".fcore");
    }

    public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
        // TODO Auto-generated method stub

    }

    public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
        // TODO Auto-generated method stub

    }

}
