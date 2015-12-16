/**
 * Copyright (c) 2015 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
    	context.setOutputValue("result", "Hello from workspace");    
    }

    public void postExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
    }

}
