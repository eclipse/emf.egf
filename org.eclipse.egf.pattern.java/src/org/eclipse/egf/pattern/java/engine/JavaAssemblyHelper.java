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
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.egf.model.pattern.SuperCall;
import org.eclipse.egf.pattern.engine.AssemblyHelper;
import org.eclipse.egf.pattern.engine.ParameterMatcher;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.java.Messages;
import org.eclipse.egf.pattern.utils.ParameterTypeHelper;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Thomas Guiu
 */
public class JavaAssemblyHelper extends AssemblyHelper {

    public static final String GENERATE_METHOD = "generate";
    public static final String START_MARKER = "//Start of work";
    public static final String END_MARKER = "//End of work";

    public static final String CONSTRUCTOR_MARKER = "//Here is the constructor";

    public JavaAssemblyHelper(Pattern pattern) {
        super(pattern);
    }

    @Override
    protected void call(BackCall call) throws PatternException {
        content.append("CallHelper.callBack(ctx");
        for (org.eclipse.egf.model.pattern.PatternParameter parameter : pattern.getAllParameters()) {
            content.append(", ").append(parameter.getName());
        }
        content.append(");").append(EGFCommonConstants.LINE_SEPARATOR);
    }

    @Override
    protected void call(SuperCall object) throws PatternException {
        throw new IllegalStateException("not implemented");
    }

    @Override
    protected void call(PatternInjectedCall call) throws PatternException {
        Pattern pattern = call.getCalled();

        String ctxName = "ctx_" + EcoreUtil.generateUUID();
        content.append("PatternContext ").append(ctxName).append(" = new PatternContext(ctx);").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append(ctxName).append(".setReporter(callReporter);").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append(ctxName).append(".setValue(").append("PatternContext.INJECTED_CONTEXT, ").append(call.getContext().getName()).append(");").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("EngineHelper.execute(\"").append(pattern.getID()).append("\", ").append(ctxName).append(");").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR);
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
        String ctxName = "ctx_" + EcoreUtil.generateUUID();
        content.append("PatternContext ").append(ctxName).append(" = new PatternContext(ctx);").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append(ctxName).append(".setReporter(callReporter);").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append(ctxName).append(".setValue(\"key\", \"value\");").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("EngineHelper.executeWithInjection(\"").append(pattern.getID()).append("\", ").append(ctxName);
        for (PatternParameter parameter : pattern.getAllParameters())
            content.append(", ").append(PatternHelper.uniqueName(parameter));

        content.append(");").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR);
    }

    @Override
    protected void addVariableInitialization() throws PatternException {
        int indexOf = content.indexOf(CONSTRUCTOR_MARKER);
        if (indexOf == -1)
            throw new IllegalStateException();
        content.insert(indexOf + CONSTRUCTOR_MARKER.length() + 1, getMethodContent(pattern.getInitMethod()));
    }

    @Override
    protected void beginOrchestration() throws PatternException {
        content.append("InternalPatternContext ctx = (InternalPatternContext)argument;").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("IQuery.ParameterDescription paramDesc = null;").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("Map<String, String> queryCtx = null;").append(EGFCommonConstants.LINE_SEPARATOR);
        super.beginOrchestration();

        if (!pattern.getAllParameters().isEmpty()) {

            for (PatternParameter parameter : pattern.getAllParameters()) {
                appendQueryCode(content, parameter);
            }

            content.append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR);

            // create a loop per parameter
            for (PatternParameter parameter : pattern.getAllParameters()) {
                String local = PatternHelper.localizeName(parameter);
                content.append("for (Object ").append(local).append(" : ").append(getParameterListName(parameter)).append(" ) {").append(EGFCommonConstants.LINE_SEPARATOR);
            }

            content.append(EGFCommonConstants.LINE_SEPARATOR);

            content.append("generate((PatternContext)argument");
            for (PatternParameter parameter : pattern.getAllParameters()) {
                String local = PatternHelper.localizeName(parameter);
                content.append(", ").append(local);
            }
            content.append(");").append(EGFCommonConstants.LINE_SEPARATOR);

            // 2 - Add post block at current index
            for (int i = 0; i < pattern.getAllParameters().size(); i++)
                content.append("}").append(EGFCommonConstants.LINE_SEPARATOR);
        } else
            content.append("generate((PatternContext)argument);").append(EGFCommonConstants.LINE_SEPARATOR);

        content.append("if (ctx.useReporter()){").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("    ctx.clearBuffer();}").append(EGFCommonConstants.LINE_SEPARATOR);
        // end of method generate (Object argument)
        content.append("}").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR);

        // add new method body
        content.append("public String generate(PatternContext ctx");
        if (!pattern.getAllParameters().isEmpty()) {
            for (PatternParameter parameter : pattern.getAllParameters()) {
                String local = PatternHelper.localizeName(parameter);
                content.append(", Object ").append(local);
            }
        }
        content.append(") throws Exception {").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("InternalPatternContext ictx = (InternalPatternContext)ctx;").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("int executionIndex = ictx.getExecutionBuffer().length();").append(EGFCommonConstants.LINE_SEPARATOR);
    }

    /**
     * TODO quick work to validate the whole process, needs a plugable way to
     * add this stuff.
     */
    @Override
    protected void endOrchestration() throws PatternException {
        content.append(END_MARKER).append(EGFCommonConstants.LINE_SEPARATOR);
        if (pattern.getAllParameters().isEmpty()) {
            content.append("ctx.getReporter().executionFinished(collector.toString(), ctx);").append(EGFCommonConstants.LINE_SEPARATOR);
            return;
        }
        // 1 - Add pre block at insertionIndex
        StringBuilder localContent = new StringBuilder(300);
        localContent.append("").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR);

        content.append(EGFCommonConstants.LINE_SEPARATOR).append("String loop = ictx.getBuffer().toString();").append(EGFCommonConstants.LINE_SEPARATOR);
        if (!pattern.getAllParameters().isEmpty()) {
            content.append("if (ictx.useReporter()){").append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));").append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("Map<String, Object> parameterValues = new HashMap<String, Object>();").append(EGFCommonConstants.LINE_SEPARATOR);
            for (org.eclipse.egf.model.pattern.PatternParameter parameter : pattern.getAllParameters()) {
                content.append("parameterValues.put(\"").append(parameter.getName()).append("\", this.").append(parameter.getName()).append(");").append(EGFCommonConstants.LINE_SEPARATOR);
            }
            content.append("    String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);").append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("    ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);").append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("    ictx.clearBuffer();}").append(EGFCommonConstants.LINE_SEPARATOR);
        }
        content.append("return loop;").append(EGFCommonConstants.LINE_SEPARATOR);
        // end of method generate(PatternContext ctx, ...)
        content.append("}").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR);

        localContent.append(EGFCommonConstants.LINE_SEPARATOR);

        content.insert(orchestrationIndex, localContent);

        // 2 - Add post block at current index
        content.append(EGFCommonConstants.LINE_SEPARATOR);

        for (int i = 0; i < pattern.getAllParameters().size(); i++)
            content.append("}").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("ctx.getReporter().executionFinished(collector.toString(), ctx);").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append(EGFCommonConstants.LINE_SEPARATOR);

        // 3- Add additional code for parameter names handling
        int startIndex = content.indexOf(START_MARKER);
        if (startIndex == -1)
            throw new PatternException(Messages.assembly_error2);

        localContent.setLength(0);
        localContent.append(EGFCommonConstants.LINE_SEPARATOR);
        localContent.append("Map<String, Object> parameterValues = new HashMap<String, Object>();").append(EGFCommonConstants.LINE_SEPARATOR);
        for (org.eclipse.egf.model.pattern.PatternParameter parameter : pattern.getAllParameters()) {
            String local = PatternHelper.localizeName(parameter);
            String type = ParameterTypeHelper.INSTANCE.getTypeLiteral(parameter.getType());
            localContent.append(type).append(" ").append(parameter.getName()).append(" = (").append(type).append(")").append(local).append(";").append(EGFCommonConstants.LINE_SEPARATOR);
            localContent.append("parameterValues.put(\"").append(parameter.getName()).append("\", ").append(local).append(");").append(EGFCommonConstants.LINE_SEPARATOR);
        }
        content.insert(startIndex + START_MARKER.length(), localContent);
    }

    private String getParameterListName(PatternParameter parameter) {
        return parameter.getName() + "List";
    }

    private void appendQueryCode(StringBuilder localContent, PatternParameter parameter) throws PatternException {
        Query query = parameter.getQuery();
        if (query == null) {
            // there is no query, so this pattern can only be called by another
            // (i.e. it's an entry point in execution)
            localContent.append("List<Object> ").append(getParameterListName(parameter)).append(" = null;").append(EGFCommonConstants.LINE_SEPARATOR);
            localContent.append("//this pattern can only be called by another (i.e. it's not an entry point in execution)").append(EGFCommonConstants.LINE_SEPARATOR);
            return;
        }
        localContent.append("paramDesc = new IQuery.ParameterDescription(\"").append(parameter.getName()).append("\", \"").append(parameter.getType()).append("\");").append(EGFCommonConstants.LINE_SEPARATOR);
        localContent.append("queryCtx = new HashMap<String, String>();").append(EGFCommonConstants.LINE_SEPARATOR);
        if (query != null && query.getQueryContext() != null) {
            for (String key : query.getQueryContext().keySet()) {
                localContent.append("queryCtx.put(\"").append(key).append("\", \"").append(query.getQueryContext().get(key)).append("\");").append(EGFCommonConstants.LINE_SEPARATOR);
            }
        }

        localContent.append("List<Object> ").append(getParameterListName(parameter)).append(" = ");
        localContent.append("QueryHelper.load(ctx, \"").append(query.getExtensionId()).append("\").execute(paramDesc, queryCtx, ctx);").append(EGFCommonConstants.LINE_SEPARATOR);
    }

}
