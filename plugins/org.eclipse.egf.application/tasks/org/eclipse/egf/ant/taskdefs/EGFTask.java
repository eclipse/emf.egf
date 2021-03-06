/**
 * <copyright>
 * 
 * Copyright (c) 2004-2006 IBM Corporation and others.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * IBM - Initial API and implementation
 * 
 * </copyright>
 * 
 * $Id: EMFTask.java,v 1.5 2006/12/19 01:45:08 marcelop Exp $
 */
package org.eclipse.egf.ant.taskdefs;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.ant.core.AntCorePlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.codegen.util.CodeGenUtil;

/**
 * Base class for the tasks that are defined in this plugin. Provides common behavior
 * and facilities.
 * 
 * @since 2.1.0
 */
public abstract class EGFTask extends Task {

    /**
     * Throws a <tt>BuildException</tt> if <tt>expression</tt> is false.
     * 
     * @param message
     * @param expression
     * @throws BuildException
     */
    public static void assertTrue(String message, boolean expression) throws BuildException {
        if (expression == false) {
            throw new BuildException(message);
        }
    }

    protected IProgressMonitor getProgressMonitor() {
        try {
            if (getProject() != null) {
                IProgressMonitor progressMonitor = (IProgressMonitor) getProject().getReferences().get(AntCorePlugin.ECLIPSE_PROGRESS_MONITOR);
                if (progressMonitor != null) {
                    return progressMonitor;
                }
            }
        } catch (Exception e) {
            // Ignore
        }
        return new CodeGenUtil.EclipseUtil.StreamProgressMonitor(System.out);
    }

    @Override
    public final void execute() throws BuildException {
        checkAttributes();
        try {
            doExecute();
        } catch (Exception e) {
            if (e instanceof BuildException) {
                throw (BuildException) e;
            }
            throw new BuildException(e);
        }
    }

    /**
     * All the attribute checks should be performed in this method.
     * 
     * @throws BuildException
     */
    protected void checkAttributes() throws BuildException {
        // Subclasses may override this method
    }

    /**
     * Performs the task specific code.
     * 
     * @throws Exception
     */
    protected abstract void doExecute() throws Exception;

}
