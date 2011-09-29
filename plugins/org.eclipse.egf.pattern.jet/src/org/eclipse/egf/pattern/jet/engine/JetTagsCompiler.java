/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.jet.engine;

import static org.eclipse.egf.pattern.jet.JetTagsConstants.ARGS;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.ARGS_SEPARATOR;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.EGF_PATTERN_CALL;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.EGF_PATTERN_INJECTED_CALL;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.LOGICAL_NAME;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.MATCH_SEPARATOR;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.PATTERN_ID;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.TO_INJECT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.jet.Messages;
import org.eclipse.emf.codegen.jet.JETCompiler;
import org.eclipse.emf.codegen.jet.JETCoreElement;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.codegen.jet.JETMark;
import org.eclipse.emf.codegen.jet.JETParser;
import org.eclipse.emf.codegen.jet.JETParser.Directive;
import org.eclipse.emf.codegen.jet.JETScriptletGenerator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;

/**
 * @author Matthieu Helleboid
 * 
 */
public class JetTagsCompiler extends JETCompiler {

    private static final String N = EGFCommonConstants.LINE_SEPARATOR;

    public JetTagsCompiler(String templateURI, InputStream inputStream, String encoding) throws JETException {
        super(templateURI, inputStream, encoding);
    }

    @Override
    public void handleDirective(String directive, JETMark start, JETMark stop, Map<String, String> attributes) throws JETException {
        if (EGF_PATTERN_CALL.equals(directive)) {
            String patternId = translateId(attributes.get(PATTERN_ID));
            String args = attributes.get(ARGS);

            StringBuffer buffer = new StringBuffer();
            buffer.append("{"); //$NON-NLS-1$
            buffer.append(N);
            addDirectiveComment(start, stop, buffer);
            buffer.append(N);
            buffer.append("InternalPatternContext ictx = (InternalPatternContext) ctx;").append(N); //$NON-NLS-1$
            buffer.append("new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());").append(N); //$NON-NLS-1$
            buffer.append("stringBuffer.setLength(0);").append(N).append(N); //$NON-NLS-1$

            buffer.append("final Map<String, Object> callParameters"); //$NON-NLS-1$
            buffer.append(" = new HashMap<String, Object>();"); //$NON-NLS-1$
            buffer.append(N);
            if (args != null) {
                for (String arg : args.split(ARGS_SEPARATOR)) {
                    int indexOf = arg.indexOf(MATCH_SEPARATOR);
                    buffer.append("callParameters"); //$NON-NLS-1$
                    buffer.append(".put(\""); //$NON-NLS-1$
                    buffer.append(arg.substring(indexOf + 1));
                    buffer.append("\", "); //$NON-NLS-1$
                    buffer.append(arg.substring(0, indexOf));
                    buffer.append(");"); //$NON-NLS-1$
                    buffer.append(N);
                }
            }
            buffer.append("CallHelper.executeWithParameterInjection(\""); //$NON-NLS-1$ 
            buffer.append(patternId);
            buffer.append("\", new ExecutionContext((InternalPatternContext) ctx), callParameters"); //$NON-NLS-1$ 
            buffer.append(");"); //$NON-NLS-1$
            buffer.append(N);
            buffer.append("stringBuffer.setLength(0);").append(N); //$NON-NLS-1$
            buffer.append("}"); //$NON-NLS-1$
            buffer.append(N);

            addGenerator(new JETScriptletGenerator(buffer.toString().toCharArray()));
        } else if (EGF_PATTERN_INJECTED_CALL.equals(directive)) {
            String patternId = translateId(attributes.get(PATTERN_ID));
            String toInject = attributes.get(TO_INJECT);

            StringBuffer buffer = new StringBuffer();
            buffer.append("{"); //$NON-NLS-1$
            buffer.append(N);
            addDirectiveComment(start, stop, buffer);
            buffer.append(N);
            buffer.append("InternalPatternContext ictx = (InternalPatternContext) ctx;").append(N); //$NON-NLS-1$
            buffer.append("new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());").append(N); //$NON-NLS-1$
            buffer.append("stringBuffer.setLength(0);").append(N).append(N); //$NON-NLS-1$
            buffer.append("ExecutionContext callCtx"); //$NON-NLS-1$
            buffer.append(" = new ExecutionContext((InternalPatternContext) ctx);"); //$NON-NLS-1$
            buffer.append(N);
            buffer.append("callCtx"); //$NON-NLS-1$
            buffer.append(".setValue(PatternContext.INJECTED_CONTEXT, "); //$NON-NLS-1$
            buffer.append(toInject);
            buffer.append(");"); //$NON-NLS-1$
            buffer.append(N);
            buffer.append("CallHelper.executeWithContextInjection(\""); //$NON-NLS-1$
            buffer.append(patternId);
            buffer.append("\", callCtx"); //$NON-NLS-1$
            buffer.append(");"); //$NON-NLS-1$
            buffer.append(N);
            buffer.append("stringBuffer.setLength(0);").append(N); //$NON-NLS-1$
            buffer.append("}"); //$NON-NLS-1$
            buffer.append(N);

            addGenerator(new JETScriptletGenerator(buffer.toString().toCharArray()));
        }

        super.handleDirective(directive, start, stop, attributes);
    }

    private void addDirectiveComment(JETMark start, JETMark stop, StringBuffer buffer) {
        BufferedReader bufferedReader = null;
        try {
            char[] chars = reader.getChars(start, stop);
            bufferedReader = new BufferedReader(new StringReader(new String(chars)));
            String line = ""; //$NON-NLS-1$
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append("//"); //$NON-NLS-1$
                buffer.append(line);
                buffer.append("\n"); //$NON-NLS-1$
            }
        } catch (IOException e) {
            // ignore me
        } finally {
            if (bufferedReader != null)
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    // ignore me
                }
        }
    }

    protected String translateId(String id) throws JETException {
        if (id != null && id.contains(LOGICAL_NAME)) {
            URI uri = URI.createURI(id);
            String fragment = uri.fragment().substring(LOGICAL_NAME.length() + 1);
            PatternHelper patternHelper = PatternHelper.createCollector();
            List<Pattern> patterns = patternHelper.getPatterns(uri.trimFragment());
            for (Pattern pattern : patterns) {
                StringBuilder buffer = new StringBuilder();
                buffer.append(PatternHelper.getFullLibraryName(pattern));
                buffer.append("."); //$NON-NLS-1$
                buffer.append(pattern.getName());
                if (buffer.toString().equals(fragment)) {
                    return uri.trimFragment().appendFragment(pattern.getID()).toString();
                }
            }
            throw new JETException(NLS.bind(Messages.assembly_error9, id));
        }
        return id;
    }

    @Override
    protected void parse(JETCoreElement[] coreElements, java.lang.Class<?>[] accept) throws JETException {
        Directive directive = (JETParser.Directive) coreElements[0];
        directive.getDirectives().add(EGF_PATTERN_INJECTED_CALL);
        directive.getDirectives().add(EGF_PATTERN_CALL);

        super.parse(coreElements, accept);
    }
}
