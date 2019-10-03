/**
 * <copyright>
 *
 *  Copyright (c) 2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.usecase.pattern.uc1;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;

/**
 * @author Benoit Langlois
 * 
 */

public class HelloWorld implements ITaskProduction {

    public void doExecute(ITaskProductionContext taskProductionContext, IProgressMonitor monitor) throws InvocationException {
        String value = taskProductionContext.getInputValue("value", String.class); //$NON-NLS-1$
        String outputMessage = new String("Hello " + value + "!"); //$NON-NLS-1$ //$NON-NLS-2$
        // Message on the default console
        System.out.println(outputMessage);
        // Message on the EGF console
        EGFCorePlugin.getDefault().logInfo(outputMessage);

    }

    public void postExecute(ITaskProductionContext taskProductionContext, IProgressMonitor monitor) throws InvocationException {
        // TODO Auto-generated method stub

    }

    public void preExecute(ITaskProductionContext taskProductionContext, IProgressMonitor monitor) throws InvocationException {
        // TODO Auto-generated method stub

    }

}
