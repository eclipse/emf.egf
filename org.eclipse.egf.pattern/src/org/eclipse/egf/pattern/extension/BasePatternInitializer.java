/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern.extension;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.utils.FileHelper;
import org.eclipse.emf.common.util.URI;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class BasePatternInitializer implements PatternInitializer {

    private final IProject project;
    private final Pattern pattern;

    public BasePatternInitializer(IProject project, Pattern pattern) {
        this.project = project;
        this.pattern = pattern;
    }

    public void initContent() throws PatternException {
        for (PatternMethod method : pattern.getMethods()) {
            IFile outputFile = getFile(method);
            createFileContent(outputFile, method);
        }
    }

    public void updateContent() throws PatternException {
        for (PatternMethod method : pattern.getMethods()) {
            String methodName = method.getName();
            if (PatternFactory.HEADER_METHOD_NAME.equals(methodName) || PatternFactory.FOOTER_METHOD_NAME.equals(methodName)) {
                IFile outputFile = getFile(method);
                if (outputFile.exists()) {
                    copeyToHistoryFolder(outputFile);
                }
                createFileContent(outputFile, method);
            }
        }
    }

    private void createFileContent(IFile outputFile, PatternMethod method) throws PatternException {
        String content = null;
        if (method == pattern.getHeaderMethod())
            content = getHeaderContent(method);
        else if (method == pattern.getFooterMethod())
            content = getFooterContent(method);
        else if (method == pattern.getInitMethod())
            content = getInitContent(method);
        else
            content = getDefaultContent(method);
        try {
            FileHelper.setContent(outputFile, content == null ? "" : content);
        } catch (CoreException e) {
            throw new PatternException(e);

        }
    }

    private void copeyToHistoryFolder(IFile outputFile) {
        String location = outputFile.getLocation().toString();
        int locationIndex = location.lastIndexOf("/");
        String historyLocation = location.substring(0, locationIndex) + "/_bak/";

        // Find the file folder of history files, if not exist, create one,
        // otherwise, delete all the files in it.
        File historyFileFolder = new File(historyLocation);
        String fileName = outputFile.getName();
        if (!historyFileFolder.exists()) {
            historyFileFolder.mkdir();
        } else {
            deleteFile(historyLocation, fileName);
        }

        String fullPath = outputFile.getFullPath().toString();
        int fullPathIndex = fullPath.lastIndexOf("/");
        String historyFilePath = fullPath.substring(0, fullPathIndex) + "/_bak/" + fileName;

        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        try {
            root.refreshLocal(IResource.DEPTH_INFINITE, null);
            IPath path = new Path(historyFilePath);
            outputFile.copy(path, true, null);
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }

    private void deleteFile(String location, String fileName) {
        File file = new File(location + fileName);
        if (file.exists()) {
            file.delete();
        }
    }

    protected abstract String getHeaderContent(PatternMethod method) throws PatternException;

    protected abstract String getFooterContent(PatternMethod method) throws PatternException;

    protected abstract String getInitContent(PatternMethod method) throws PatternException;

    protected abstract String getDefaultContent(PatternMethod method) throws PatternException;

    /**
     * @param project
     * @param method
     * @return
     */
    public IFile getFile(PatternMethod method) {
        URI patternFilePath = method.getPatternFilePath();
        if (patternFilePath == null)
            throw new IllegalStateException(Messages.bind(Messages.initializer_error1, method.getName()));

        IFile file = project.getFile(patternFilePath.toFileString());
        if (file == null)
            throw new IllegalStateException(Messages.bind(Messages.initializer_error2, method.getName()));
        return file;
    }

}
