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

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.model.PatternException;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.templates.TemplateEngine;

/**
 * @author Guiu
 * 
 */
public abstract class TemplateInitializer extends PatternInitializer {

    private final TemplateEngine engine;

    public TemplateInitializer(IProject project, Pattern pattern, TemplateEngine engine) {
        super(project, pattern);
        this.engine = engine;
    }

    @Override
    protected final String getDefaultContent(PatternMethod method) throws PatternException {
        return runEngine(TemplateEngine.Templates.DEFAULT);
    }

    @Override
    protected final String getFooterContent(PatternMethod method) throws PatternException {
        return runEngine(TemplateEngine.Templates.FOOTER);
    }

    @Override
    protected final String getHeaderContent(PatternMethod method) throws PatternException {
        return runEngine(TemplateEngine.Templates.HEADER);
    }

    @Override
    protected final String getInitContent(PatternMethod method) throws PatternException {
        return runEngine(TemplateEngine.Templates.INIT);
    }

    private String runEngine(TemplateEngine.Templates template) throws PatternException {
        try {
            return engine.process(template, createContext());
        } catch (CoreException e) {
            throw new PatternException(e);
        } catch (IOException e) {
            throw new PatternException(e);
        }
    }

    protected abstract Map<String, String> createContext();

}
