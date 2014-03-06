/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.ftask.producer.invocation;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface ITaskProduction {

    /**
     * Pre execute this task.
     * 
     * @param monitor
     */
    public void preExecute(final ITaskProductionContext productionContext, final IProgressMonitor monitor) throws InvocationException;

    /**
     * Do execute this task.
     * 
     * @param monitor
     */
    public void doExecute(final ITaskProductionContext productionContext, final IProgressMonitor monitor) throws InvocationException;

    /**
     * Post execute this task.
     * 
     * @param monitor
     */
    public void postExecute(final ITaskProductionContext productionContext, final IProgressMonitor monitor) throws InvocationException;

}
