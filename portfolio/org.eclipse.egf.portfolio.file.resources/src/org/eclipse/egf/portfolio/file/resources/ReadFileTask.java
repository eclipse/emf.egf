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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
public class ReadFileTask implements ITaskProduction {

    public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
        // Nothing to do
    }

    public void doExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
        String contents = new String();
        String projectName = productionContext.getInputValue(FileConstants.PROJECT_NAME_CONTRACT, String.class);
        String folder = productionContext.getInputValue(FileConstants.FOLDER_CONTRACT, String.class);
        String fileName = productionContext.getInputValue(FileConstants.FILE_NAME_CONTRACT, String.class);

        BufferedReader bufferedReader = null;
        try {
            IFile file = FileUtil.getExistingFile(projectName, folder, fileName);
            if (file.exists()) {
                StringBuffer stringBuffer = new StringBuffer();
                bufferedReader = new BufferedReader(new InputStreamReader(file.getContents()));
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line);
                    stringBuffer.append("\n"); //$NON-NLS-1$
                }
                contents = stringBuffer.toString();
            }
        } catch (Throwable t) {
            if (t instanceof CoreException) {
                throw new InvocationException(t);
            }
            throw new InvocationException(new CoreException(EGFFileResourcesActivator.getDefault().newStatus(IStatus.ERROR, "Unexpected Exception", t))); //$NON-NLS-1$
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    // Ignore
                }
            }
        }
        productionContext.setOutputValue(FileConstants.CONTENTS_NAME_CONTRACT, contents);

    }

    public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
        // Nothing to do
    }

}
