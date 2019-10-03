/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.portfolio.eclipse.build;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;

/**
 * @author Matthieu Helleboid
 * 
 */
public class BuildWorkspace implements ITaskProduction {

    public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    }

    public void doExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
        IWorkspace ws = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot wsRoot = ws.getRoot();

        IProgressMonitor progressMonitor = new NullProgressMonitor();

        try {
            wsRoot.refreshLocal(IResource.DEPTH_INFINITE, progressMonitor);
            ws.build(IncrementalProjectBuilder.CLEAN_BUILD, progressMonitor);
            ws.build(IncrementalProjectBuilder.FULL_BUILD, progressMonitor);
            ws.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, progressMonitor);
            ws.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, progressMonitor);
            ws.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, progressMonitor);
            ws.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, progressMonitor);
            ws.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, progressMonitor);
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }

    public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    }

}
