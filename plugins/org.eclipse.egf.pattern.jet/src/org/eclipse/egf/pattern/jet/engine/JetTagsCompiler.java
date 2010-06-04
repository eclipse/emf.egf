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

import static org.eclipse.egf.pattern.jet.JetTagsConstants.ARGS;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.ARGS_SEPARATOR;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.EGF_PATTERN_CALL;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.EGF_PATTERN_INJECTED_CALL;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.LOGICAL_NAME;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.MATCH_SEPARATOR;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.PATTERN_ID;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.TO_INJECT;

import java.io.InputStream;
import java.util.Map;

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.emf.codegen.jet.JETCompiler;
import org.eclipse.emf.codegen.jet.JETCoreElement;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.codegen.jet.JETMark;
import org.eclipse.emf.codegen.jet.JETParser;
import org.eclipse.emf.codegen.jet.JETScriptletGenerator;
import org.eclipse.emf.codegen.jet.JETParser.Directive;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

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

            String blockId = PatternHelper.generateID();

            StringBuffer buffer = new StringBuffer();
            buffer.append("final Map<String, Object> parameters_"); //$NON-NLS-1$
            buffer.append(blockId);
            buffer.append(" = new HashMap<String, Object>();"); //$NON-NLS-1$
            buffer.append(N);
            if (args != null) {
                for (String arg : args.split(ARGS_SEPARATOR)) {
                    int indexOf = arg.indexOf(MATCH_SEPARATOR);
                    buffer.append("parameters_"); //$NON-NLS-1$
                    buffer.append(blockId);
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
            buffer.append("\", new ExecutionContext((InternalPatternContext) ctx), parameters_"); //$NON-NLS-1$ 
            buffer.append(blockId);
            buffer.append(");"); //$NON-NLS-1$
            buffer.append(N);

            addGenerator(new JETScriptletGenerator(buffer.toString().toCharArray()));
        } else if (EGF_PATTERN_INJECTED_CALL.equals(directive)) {
            String patternId = translateId(attributes.get(PATTERN_ID));
            String toInject = attributes.get(TO_INJECT);

            String blockId = PatternHelper.generateID();

            StringBuffer buffer = new StringBuffer();
            buffer.append("ExecutionContext ctx_"); //$NON-NLS-1$
            buffer.append(blockId);
            buffer.append(" = new ExecutionContext((InternalPatternContext) ctx);"); //$NON-NLS-1$
            buffer.append(N);
            buffer.append("ctx_"); //$NON-NLS-1$
            buffer.append(blockId);
            buffer.append(".setValue(PatternContext.INJECTED_CONTEXT, "); //$NON-NLS-1$
            buffer.append(toInject);
            buffer.append(");"); //$NON-NLS-1$
            buffer.append(N);
            buffer.append("CallHelper.executeWithContextInjection(\""); //$NON-NLS-1$
            buffer.append(patternId);
            buffer.append("\", ctx_"); //$NON-NLS-1$
            buffer.append(blockId);
            buffer.append(");"); //$NON-NLS-1$
            buffer.append(N);

            addGenerator(new JETScriptletGenerator(buffer.toString().toCharArray()));
        }

        super.handleDirective(directive, start, stop, attributes);
    }

    protected String translateId(String id) {
        if (id != null && id.contains(LOGICAL_NAME)) {
            URI uri = URI.createURI(id);
            String fragment = uri.fragment().substring(LOGICAL_NAME.length() + 1);
            TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
            Resource resource = editingDomain.getResourceSet().getResource(uri.trimFragment(), true);
            TreeIterator<EObject> treeIterator = resource.getAllContents();
            while (treeIterator.hasNext()) {
                EObject eObject = treeIterator.next();
                if (eObject instanceof Pattern) {
                    Pattern pattern = (Pattern) eObject;
                    StringBuilder buffer = new StringBuilder();
                    buffer.append(PatternHelper.getFullLibraryName(pattern));
                    buffer.append("."); //$NON-NLS-1$
                    buffer.append(pattern.getName());
                    if (buffer.toString().equals(fragment)) {
                        return uri.trimFragment().appendFragment(pattern.getID()).toString();
                    }
                }
            }
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