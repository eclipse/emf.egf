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

package org.eclipse.egf.pattern.jet.engine;

import java.io.InputStream;
import java.util.Map;

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.emf.codegen.jet.JETCompiler;
import org.eclipse.emf.codegen.jet.JETCoreElement;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.codegen.jet.JETMark;
import org.eclipse.emf.codegen.jet.JETParser;
import org.eclipse.emf.codegen.jet.JETScriptletGenerator;
import org.eclipse.emf.codegen.jet.JETParser.Directive;

/**
 * @author Matthieu Helleboid
 * 
 */
public class ExtendedJetCompiler extends JETCompiler {

    private static final String EGF_PATTERN_CALL = "egf:patternCall"; //$NON-NLS-1$
    private static final String EGF_PATTERN_INJECTED_CALL = "egf:patternInjectedCall"; //$NON-NLS-1$
    private static final String N = EGFCommonConstants.LINE_SEPARATOR;

    public ExtendedJetCompiler(String templateURI, InputStream inputStream, String encoding) throws JETException {
        super(templateURI, inputStream, encoding);
    }

    @Override
    public void handleDirective(String directive, JETMark start, JETMark stop, Map<String, String> attributes) throws JETException {
        if (EGF_PATTERN_CALL.equals(directive)) {
            String patternId = attributes.get("patternId");
            String args = attributes.get("args");

            StringBuffer buffer = new StringBuffer();
            buffer.append("final Map<String, Object> parameters = new HashMap<String, Object>();"); //$NON-NLS-1$
            buffer.append(N);
            for (String arg : args.split(",")) {
                int indexOf = arg.indexOf(":");
                buffer.append("parameters.put(\"");
                buffer.append(arg.substring(indexOf + 1));
                buffer.append("\", ");
                buffer.append(arg.substring(0, indexOf));
                buffer.append(");");
                buffer.append(N);
            }
            buffer.append("CallHelper.executeWithParameterInjection(\"" + patternId + "\", new ExecutionContext((InternalPatternContext) ctx), parameters);"); //$NON-NLS-1$ //$NON-NLS-2$
            buffer.append(N);

            generators.add(new JETScriptletGenerator(buffer.toString().toCharArray()));

        } else if (EGF_PATTERN_INJECTED_CALL.equals(directive)) {
            String patternId = attributes.get("patternId");
            String toInject = attributes.get("toInject");

            String id = PatternHelper.generateID();

            StringBuffer buffer = new StringBuffer();
            buffer.append("ExecutionContext ctx_");
            buffer.append(id);
            buffer.append(" = new ExecutionContext((InternalPatternContext) ctx);");
            buffer.append(N);
            buffer.append("ctx_");
            buffer.append(id);
            buffer.append(".setValue(PatternContext.INJECTED_CONTEXT, ");
            buffer.append(toInject);
            buffer.append(");");
            buffer.append(N);
            buffer.append("CallHelper.executeWithContextInjection(\"");
            buffer.append(patternId);
            buffer.append("\", ctx_");
            buffer.append(id);
            buffer.append(");");
            buffer.append(N);

            generators.add(new JETScriptletGenerator(buffer.toString().toCharArray()));
        } else
            super.handleDirective(directive, start, stop, attributes);
    }

    @Override
    protected void parse(JETCoreElement[] coreElements, java.lang.Class<?>[] accept) throws JETException {
        Directive directive = (JETParser.Directive) coreElements[0];
        directive.getDirectives().add(EGF_PATTERN_INJECTED_CALL);
        directive.getDirectives().add(EGF_PATTERN_CALL);

        super.parse(coreElements, accept);
    }
}