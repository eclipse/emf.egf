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

package org.eclipse.egf.emf.pattern.codegen;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.emf.pattern.codegen.model.MethodInfo;
import org.eclipse.egf.emf.pattern.codegen.model.PatternInfo;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.jet.extension.JetPatternInitializer;
import org.eclipse.egf.pattern.templates.TemplateEngine;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenPatternInitializer {

    public static class ContentProvider {

        protected PatternInfo patternInfo;

        public ContentProvider(PatternInfo patternInfo) {
            super();
            this.patternInfo = patternInfo;
        }

        protected String getContent(PatternMethod method) throws PatternException {
            for (MethodInfo methodInfo : patternInfo.getMethods()) {
                if (methodInfo.getName() != null && methodInfo.getName().equals(method.getName()))
                    return methodInfo.getContent();
            }
            return null;
        }
    }

    public static class CodegenJetPatternInitializer extends JetPatternInitializer {

        protected ContentProvider contentProvider;

        public CodegenJetPatternInitializer(IProject project, Pattern pattern, TemplateEngine engine, ContentProvider contentProvider) {
            super(project, pattern, engine);
            this.contentProvider = contentProvider;
        }

        @Override
        protected String getConditionContent(PatternMethod method) throws PatternException {
            String content = contentProvider.getContent(method);
            if (content != null)
                return content;
            return super.getConditionContent(method);
        }
        
        @Override
        protected String getDefaultContent(PatternMethod method) throws PatternException {
            String content = contentProvider.getContent(method);
            if (content == null)
                throw new IllegalStateException("no content found"); //$NON-NLS-1$
            return content;
        }
    }
}
