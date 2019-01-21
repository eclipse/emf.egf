/**
 * Copyright (c) 2015 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.example.task.h4;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;

public class H4 implements ITaskProduction {

    public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
    }

    public void doExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
    	context.setOutputValue("result", "Hello from runtime");    
    }

    public void postExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
    }

}
