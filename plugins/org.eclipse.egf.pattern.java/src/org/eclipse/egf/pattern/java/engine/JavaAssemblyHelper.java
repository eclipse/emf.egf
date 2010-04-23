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

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.egf.pattern.engine.AssemblyHelper;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.utils.ParameterTypeHelper;

/**
 * @author Thomas Guiu
 */
public class JavaAssemblyHelper extends AssemblyHelper {

    public static final String GENERATE_METHOD = "generate";

    public static final String CONSTRUCTOR_MARKER = "//Here is the constructor";

    public JavaAssemblyHelper(Pattern pattern, JavaAssemblyContentProvider contentProvider) {
        super(pattern, contentProvider);
    }

    @Override
    protected void addVariableInitialization() throws PatternException {
        int indexOf = content.indexOf(CONSTRUCTOR_MARKER);
        if (indexOf == -1)
            throw new IllegalStateException();
        content.insert(indexOf + CONSTRUCTOR_MARKER.length() + 1, contentHelper.getMethodContent(pattern.getInitMethod()));
    }

    @Override
    protected void beginOrchestration() throws PatternException {
        content.append("public void generate (Object argument) throws Exception {").append(EGFCommonConstants.LINE_SEPARATOR);
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
            for (org.eclipse.egf.model.pattern.PatternParameter parameter : pattern.getAllParameters()) {
                String local = PatternHelper.localizeName(parameter);
                String type = ParameterTypeHelper.INSTANCE.getTypeLiteral(parameter.getType());
                content.append("this.").append(parameter.getName()).append(" = (").append(type).append(")").append(local).append(";").append(EGFCommonConstants.LINE_SEPARATOR);
            }

            content.append(EGFCommonConstants.LINE_SEPARATOR);

            content.append(AssemblyHelper.ORCHESTRATION_METHOD).append("((PatternContext)argument);").append(EGFCommonConstants.LINE_SEPARATOR);

            // 2 - Add post block at current index
            for (int i = 0; i < pattern.getAllParameters().size(); i++)
                content.append("}").append(EGFCommonConstants.LINE_SEPARATOR);
        } else
            content.append(AssemblyHelper.ORCHESTRATION_METHOD).append("((PatternContext)argument);").append(EGFCommonConstants.LINE_SEPARATOR);

        content.append("if (ctx.useReporter()){").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("    ctx.clearBuffer();}").append(EGFCommonConstants.LINE_SEPARATOR);
        // end of method generate (Object argument)
        content.append("}").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR);

        // add new method body
        content.append("public String ").append(AssemblyHelper.ORCHESTRATION_METHOD).append("(PatternContext ctx) throws Exception {").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("InternalPatternContext ictx = (InternalPatternContext)ctx;").append(EGFCommonConstants.LINE_SEPARATOR);
        content.append("int executionIndex = ictx.getExecutionBuffer().length();").append(EGFCommonConstants.LINE_SEPARATOR);
    }

    /**
     * TODO quick work to validate the whole process, needs a plugable way to
     * add this stuff.
     */
    @Override
    protected void endOrchestration() throws PatternException {

        content.append(EGFCommonConstants.LINE_SEPARATOR).append("String loop = ictx.getBuffer().toString();").append(EGFCommonConstants.LINE_SEPARATOR);
        if (!pattern.getAllParameters().isEmpty()) {
            content.append("if (ictx.useReporter()){").append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));").append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("    ictx.setExecutionCurrentIndex(0);").append(EGFCommonConstants.LINE_SEPARATOR);
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
