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

package org.eclipse.egf.portfolio.file.resources;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;

/**
 * @author Benoit Langlois
 *
 */
public class EclipseDeleteFileTask implements ITaskProduction {

    public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
        // Nothing to do
    }

    public void doExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
        String projectName = productionContext.getInputValue(FileConstants.PROJECT_NAME_CONTRACT, String.class);
        String folder = productionContext.getInputValue(FileConstants.FOLDER_CONTRACT, String.class);
        String fileName = productionContext.getInputValue(FileConstants.FILE_NAME_CONTRACT, String.class);
        try {
            IFile file = FileUtil.getExistingFile(projectName, folder, fileName);
            if (file.exists()) {
                file.delete(false, true, monitor);
            }
        } catch (Throwable t) {
            if (t instanceof CoreException) {
                throw new InvocationException(t);
            }
            throw new InvocationException(new CoreException(EGFFileResourcesActivator.getDefault().newStatus(IStatus.ERROR, "Unexpected Exception", t))); //$NON-NLS-1$
        }
    }

    public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
        // Nothing to do
    }

}
