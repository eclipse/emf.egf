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

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;

/**
 * 
 * @author Thomas Guiu
 */
public class FixPluginFileTask implements ITaskProduction, FcoreBuilderConstants {

    public void doExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
        String path = (String) productionContext.getInputValue(FCORE_OUTPUT_PATH, String.class);
        path = path.substring(path.indexOf("/") + 1);
        String name = (String) productionContext.getInputValue(PLUGIN_NAME, String.class);
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
        IFile file = project.getFile("plugin.xml");
        if (!file.exists()) {
            String data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<?eclipse version=\"3.2\"?>\n<plugin>" + "\n\t<extension\n\tpoint=\"org.eclipse.egf.core.fcore\">\n\t\t<fcore id=\"" + path + "\">\n\t" + "</fcore>\n</extension>\n</plugin>";
            try {
                file.create(new ByteArrayInputStream(data.getBytes()), true, null);
            } catch (CoreException e) {
                throw new InvocationException(e);
            }
        }
    }

    public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    }

    public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    }

}
