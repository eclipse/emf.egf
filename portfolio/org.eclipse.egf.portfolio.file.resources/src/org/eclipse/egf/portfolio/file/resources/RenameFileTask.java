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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;

/**
 * @author Benoit Langlois
 *
 */
public class RenameFileTask implements ITaskProduction {

    public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
        // Nothing to do
    }

    public void doExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
        String projectName = productionContext.getInputValue(FileConstants.PROJECT_NAME_CONTRACT, String.class);
        String folder = productionContext.getInputValue(FileConstants.FOLDER_CONTRACT, String.class);
        String fileName = productionContext.getInputValue(FileConstants.FILE_NAME_CONTRACT, String.class);
        String newFolder = productionContext.getInputValue(FileConstants.NEW_FOLDER_CONTRACT, String.class);
        String newFileName = productionContext.getInputValue(FileConstants.NEW_FILE_NAME_CONTRACT, String.class);

        // Not implemented
        //		try {
        //			IFile file = FileUtil.getExistingFile(projectName, folder, fileName);
        //			if (file.exists()) {
        //				IFile newFile = FileUtil.getExistingFile(projectName, folder, newFileName);
        //				if (newFile.exists()) {
        //					newFile.delete(false, false, null);
        //				}
        //				...
        //			}
        //		} catch (Exception e) {
        //			EGFFileResourcesActivator.getDefault().logError(e);
        //		}
    }

    public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
        // Nothing to do
    }

}
