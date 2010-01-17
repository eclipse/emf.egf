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
 * @author Guiu
 * 
 */
public abstract class PatternInitializer {

    private final IProject project;
    private final Pattern pattern;

    public PatternInitializer(IProject project, Pattern pattern) {
        this.project = project;
        this.pattern = pattern;
    }

    public void initContent() throws PatternException {

        for (PatternMethod method : pattern.getMethods()) {
            IFile outputFile = getFile(method);
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
    protected IFile getFile(PatternMethod method) {
        URI patternFilePath = method.getPatternFilePath();
        if (patternFilePath == null)
            throw new IllegalStateException(Messages.bind(Messages.initializer_error1, method.getName()));

        IFile file = project.getFile(patternFilePath.toFileString());
        if (file == null)
            throw new IllegalStateException(Messages.bind(Messages.initializer_error2, method.getName()));
        return file;
    }

}
