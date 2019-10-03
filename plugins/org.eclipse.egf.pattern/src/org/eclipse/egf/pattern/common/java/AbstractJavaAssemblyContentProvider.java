/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.common.java;

import java.util.Map.Entry;

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.model.pattern.BackCall;
import org.eclipse.egf.model.pattern.InjectedContext;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.SuperCall;
import org.eclipse.egf.pattern.engine.AssemblyContentProvider;
import org.eclipse.egf.pattern.engine.AssemblyHelper;
import org.eclipse.egf.pattern.engine.ParameterMatcher;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.egf.pattern.utils.JavaMethodGenerationHelper;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class AbstractJavaAssemblyContentProvider extends AssemblyContentProvider {

    protected final JavaMethodGenerationHelper javaMethodHelper;

    public AbstractJavaAssemblyContentProvider(Pattern pattern, JavaMethodGenerationHelper helper) {
        super(pattern);
        this.javaMethodHelper = helper;
    }

    @Override
    protected void call(BackCall object) throws PatternException {
        content.append("{").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$

        content.append("final Map<String, Object> parameters = getParameters();").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("CallbackContext ctx_callback = new CallbackContext(ictx);").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$

        content.append("CallHelper.callBack(ctx_callback, parameters);").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("}").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
    }

    @Override
    protected void call(SuperCall call) throws PatternException {
        if (call.getPattern().getSuperPattern() == null)
            return;
        content.append("super.").append(AssemblyHelper.ORCHESTRATION_METHOD).append("(new SuperOrchestrationContext(ictx));").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
    protected void call(PatternInjectedCall call) throws PatternException {
        Pattern innerPattern = call.getCalled();
        String ctxName = "ctx_local";// + PatternHelper.generateID(); //$NON-NLS-1$
        content.append('{').append(EGFCommonConstants.LINE_SEPARATOR).append("ExecutionContext ").append(ctxName).append(" = new ExecutionContext(ictx);").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$
        content.append(ctxName).append(".setValue(").append("PatternContext.INJECTED_CONTEXT, ").append(call.getContext().getName()).append(");").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        String uri = EcoreUtil.getURI(innerPattern).toString();
        content.append("CallHelper.executeWithContextInjection(\"").append(uri).append("\", ").append(ctxName).append(");").append(EGFCommonConstants.LINE_SEPARATOR).append('}').append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

    @Override
    protected void call(PatternCall call) throws PatternException {
        Pattern innerPattern = call.getCalled();

        content.append("{").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("final Map<String, Object> parameters = new HashMap<String, Object>();").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        if (call.getParameterMatching().isEmpty()) {
            // try to match parameters
            ParameterMatcher matcher = ParameterMatcher.create(call.getPattern(), innerPattern);
            if (!matcher.matches())
                throw new PatternException(NLS.bind(EGFPatternMessages.assembly_error10, call.getPattern().getName()));
            for (PatternParameter key : matcher.getMatching().keySet()) {
                content.append("parameters.put(\"").append(key.getName()).append("\", this.").append(matcher.getMatching().get(key).getName()).append(");").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            }
        } else {
            for (Entry<InjectedContext, InjectedContext> binding : call.getParameterMatching()) {
                content.append("parameters.put(\"").append(binding.getKey().getName()).append("\", this.").append(binding.getValue().getName()).append(");").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            }
        }
        String ctxName = "ctx_local";// + PatternHelper.generateID(); //$NON-NLS-1$
        content.append("ExecutionContext ").append(ctxName).append(" = new ExecutionContext(ictx);").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$

        String uri = EcoreUtil.getURI(innerPattern).toString();
        content.append("CallHelper.executeWithParameterInjection(\"").append(uri).append("\", ").append(ctxName).append(", parameters);").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        content.append("}").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
    }

    @Override
    public void setContent(StringBuilder content) {
        super.setContent(content);
        javaMethodHelper.setContent(content);
    }

}
