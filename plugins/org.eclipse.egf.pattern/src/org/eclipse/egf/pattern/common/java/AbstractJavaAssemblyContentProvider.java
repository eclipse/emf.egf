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

package org.eclipse.egf.pattern.common.java;

import java.util.Map.Entry;

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.model.pattern.BackCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.SuperCall;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.engine.AssemblyContentProvider;
import org.eclipse.egf.pattern.engine.AssemblyHelper;
import org.eclipse.egf.pattern.engine.ParameterMatcher;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.utils.JavaMethodGenerationHelper;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
        content.append("{").append(EGFCommonConstants.LINE_SEPARATOR);
        // content.append("index = ictx.getBuffer().length();").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("ictx.setExecutionCurrentIndex(ictx.getBuffer().length());").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("ictx.getExecutionBuffer().append(ictx.getBuffer());").append(EGFCommonConstants.LINE_SEPARATOR);

        content.append("final Map<String, Object> parameters = getParameters();").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("CallbackContext ctx_callback = new CallbackContext(ictx);").append(EGFCommonConstants.LINE_SEPARATOR);

        content.append("CallHelper.callBack(ctx_callback, parameters);").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("}").append(EGFCommonConstants.LINE_SEPARATOR);
    }

    @Override
    protected void call(SuperCall call) throws PatternException {
        if (call.getPattern().getSuperPattern() == null)
            return;
        content.append("super.").append(AssemblyHelper.ORCHESTRATION_METHOD).append("(new SuperOrchestrationContext(ictx));").append(EGFCommonConstants.LINE_SEPARATOR);
    }

    @Override
    protected void call(PatternInjectedCall call) throws PatternException {
        Pattern pattern = call.getCalled();
        String ctxName = "ctx_" + PatternHelper.generateID();
        content.append("ExecutionContext ").append(ctxName).append(" = new ExecutionContext(ictx);").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append(ctxName).append(".setValue(").append("PatternContext.INJECTED_CONTEXT, ").append(call.getContext().getName()).append(");").append(EGFCommonConstants.LINE_SEPARATOR);
        String uri = EcoreUtil.getURI(pattern).toString();
        content.append("CallHelper.executeWithContextInjection(\"").append(uri).append("\", ").append(ctxName).append(");").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR);
    }

    @Override
    protected void call(PatternCall call) throws PatternException {
        Pattern pattern = call.getCalled();

        content.append("{").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("final Map<String, Object> parameters = new HashMap<String, Object>();").append(EGFCommonConstants.LINE_SEPARATOR);
        if (call.getParameterMatching().isEmpty()) {
            // try to match parameters
            ParameterMatcher matcher = ParameterMatcher.create(call.getPattern(), pattern);
            if (!matcher.matches())
                throw new PatternException(Messages.bind(Messages.assembly_error10, call.getPattern().getName()));
            for (PatternParameter key : matcher.getMatching().keySet()) {
                content.append("parameters.put(\"").append(key.getName()).append("\", this.").append(matcher.getMatching().get(key).getName()).append(");").append(EGFCommonConstants.LINE_SEPARATOR);
            }
        } else {
            for (Entry<PatternParameter, PatternParameter> binding : call.getParameterMatching()) {
                content.append("parameters.put(\"").append(binding.getKey().getName()).append("\", this.").append(binding.getValue().getName()).append(");").append(EGFCommonConstants.LINE_SEPARATOR);
            }
        }
        String ctxName = "ctx_" + PatternHelper.generateID();
        content.append("ExecutionContext ").append(ctxName).append(" = new ExecutionContext(ictx);").append(EGFCommonConstants.LINE_SEPARATOR);

        String uri = EcoreUtil.getURI(pattern).toString();
        content.append("CallHelper.executeWithParameterInjection(\"").append(uri).append("\", ").append(ctxName).append(", parameters);").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("}").append(EGFCommonConstants.LINE_SEPARATOR);
    }

    public void setContent(StringBuilder content) {
        super.setContent(content);
        javaMethodHelper.setContent(content);
    }

}
