/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
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

    public void updateSpecialMethods(boolean overwrite) throws PatternException {
        for (PatternMethod method : pattern.getMethods()) {
            String methodName = method.getName();
            if (PatternFactory.isSpecialMethod(methodName)) {
                IFile outputFile = getFile(method);
                if (!overwrite && outputFile.exists())
                    continue;
                createFileContent(outputFile, method);
            }
        }

    }

    public void updateContent() throws PatternException {
    }

    private void createFileContent(IFile outputFile, PatternMethod method) throws PatternException {
        String content = null;
        if (method == pattern.getHeaderMethod())
            content = getHeaderContent(method);
        else if (method == pattern.getFooterMethod())
            content = getFooterContent(method);
        else if (method == pattern.getInitMethod())
            content = getInitContent(method);
        else if (method == pattern.getConditionMethod())
            content = getConditionContent(method);
        else
            content = getDefaultContent(method);
        try {
            FileHelper.setContent(outputFile, content == null ? "" : content, true);
        } catch (CoreException e) {
            throw new PatternException(e);

        }
    }

    protected abstract String getConditionContent(PatternMethod method) throws PatternException;

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

    public IProject getProject() {
        return project;
    }

    public Pattern getPattern() {
        return pattern;
    }

}
