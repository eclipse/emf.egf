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

package org.eclipse.egf.pattern.java.engine;

import java.util.Map.Entry;

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.model.pattern.BackCall;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.SuperCall;
import org.eclipse.egf.pattern.engine.AssemblyContentProvider;
import org.eclipse.egf.pattern.engine.ParameterMatcher;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.java.Messages;
import org.eclipse.egf.pattern.utils.JavaMethodGenerationHelper;
import org.eclipse.egf.pattern.utils.ParameterTypeHelper;

/**
 * @author Thomas Guiu
 * 
 */
public class JavaAssemblyContentProvider extends AssemblyContentProvider {

    private static final JavaMethodGenerationHelper JAVA_METHOD_HELPER = new JavaMethodGenerationHelper("out");

    public JavaAssemblyContentProvider(Pattern pattern) {
        super(pattern);
    }

    @Override
    protected void call(MethodCall object) throws PatternException {
        content.append(JAVA_METHOD_HELPER.getCallStatement(object.getCalled())).append(EGFCommonConstants.LINE_SEPARATOR);

    }

    @Override
    protected void call(PatternCall call) throws PatternException {
        Pattern pattern = call.getCalled();

        if (call.getParameterMatching().isEmpty()) {
            // try to match parameters
            ParameterMatcher matcher = ParameterMatcher.create(call.getPattern(), pattern);
            if (!matcher.matches())
                throw new PatternException(Messages.bind(Messages.assembly_error7, call.getPattern().getName()));
            for (PatternParameter key : matcher.getMatching().keySet()) {
                String called = PatternHelper.uniqueName(key);
                content.append(ParameterTypeHelper.INSTANCE.getTypeLiteral(key.getType())).append(" ").append(called).append(" = ").append(matcher.getMatching().get(key).getName()).append(";").append(EGFCommonConstants.LINE_SEPARATOR);
            }
        } else {
            for (Entry<PatternParameter, PatternParameter> binding : call.getParameterMatching()) {
                String called = PatternHelper.uniqueName(binding.getKey());
                content.append(ParameterTypeHelper.INSTANCE.getTypeLiteral(binding.getKey().getType())).append(" ").append(called).append(" = ").append(binding.getValue().getName()).append(";").append(EGFCommonConstants.LINE_SEPARATOR);
            }
        }
        String ctxName = "ctx_" + PatternHelper.generateID();
        content.append("ExecutionContext ").append(ctxName).append(" = new ExecutionContext(ictx);").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("CallHelper.executeWithInjection(\"").append(pattern.getID()).append("\", ").append(ctxName);
        for (PatternParameter parameter : pattern.getAllParameters())
            content.append(", ").append(PatternHelper.uniqueName(parameter));

        content.append(");").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR);
    }

    @Override
    protected void call(BackCall object) throws PatternException {
        content.append("CallHelper.callBack(new CallbackContext(ictx)");
        for (org.eclipse.egf.model.pattern.PatternParameter parameter : pattern.getAllParameters()) {
            content.append(", ").append(parameter.getName());
        }
        content.append(");").append(EGFCommonConstants.LINE_SEPARATOR);
    }

    @Override
    protected void call(SuperCall object) throws PatternException {
        if (object.getPattern().getSuperPattern() == null)
            return;
        String ctxName = "ctx_" + PatternHelper.generateID();
        content.append("ExecutionContext ").append(ctxName).append(" = new ExecutionContext(ictx);").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("super.generate(").append(ctxName);
        for (org.eclipse.egf.model.pattern.PatternParameter parameter : pattern.getSuperPattern().getAllParameters()) {
            content.append(", ").append(parameter.getName());
        }
        content.append(");").append(EGFCommonConstants.LINE_SEPARATOR);
    }

    @Override
    protected void call(PatternInjectedCall call) throws PatternException {
        Pattern pattern = call.getCalled();
        String ctxName = "ctx_" + PatternHelper.generateID();
        content.append("ExecutionContext ").append(ctxName).append(" = new ExecutionContext(ictx);").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append(ctxName).append(".setValue(").append("PatternContext.INJECTED_CONTEXT, ").append(call.getContext().getName()).append(");").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("CallHelper.execute(\"").append(pattern.getID()).append("\", ").append(ctxName).append(");").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR);
    }

    @Override
    protected void addMethodBodies() throws PatternException {
        for (PatternMethod method : PatternHelper.getUserMethds(pattern)) {
            content.append(JAVA_METHOD_HELPER.getSignature(method)).append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("{").append(EGFCommonConstants.LINE_SEPARATOR);
            content.append(getMethodContent(method)).append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("}").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR);
        }
    }

}
