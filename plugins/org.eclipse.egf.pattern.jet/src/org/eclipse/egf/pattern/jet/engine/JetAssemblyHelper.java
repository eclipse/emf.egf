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

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.egf.pattern.common.java.BaseJavaAssemblyHelper;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.egf.pattern.utils.ParameterTypeHelper;

/**
 * @author Thomas Guiu
 * 
 */
public class JetAssemblyHelper extends BaseJavaAssemblyHelper {

    public JetAssemblyHelper(Pattern pattern, JetAssemblyContentProvider contentProvider) {
        super(pattern, contentProvider);
    }

    @Override
    protected void beginOrchestration() throws PatternException {
        content.append("<%"); //$NON-NLS-1$
        content.append("InternalPatternContext ctx = (InternalPatternContext)argument;").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("Map<String, String> queryCtx = null;").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("IQuery.ParameterDescription paramDesc = null;").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("Node.Container currentNode = ctx.getNode();").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("%>"); //$NON-NLS-1$
        super.beginOrchestration();
        content.append("<%").append(START_LOOP_MARKER).append("%>"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
    protected void endOrchestration() throws PatternException {
        content.append("<%").append(END_LOOP_MARKER).append("%>"); //$NON-NLS-1$ //$NON-NLS-2$
        if (pattern.getAllParameters().isEmpty()) {
            content.append("<%ctx.setNode(currentNode);").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$  
            content.append("if (ctx.useReporter()){").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
            content.append("    ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
            content.append("}%>").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
            return;
        }
        // 1 - Add pre block at insertionIndex
        StringBuilder localContent = new StringBuilder(300);
        localContent.append("<%").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$

        for (PatternParameter parameter : pattern.getAllParameters()) {
            appendQueryCode(localContent, parameter);
        }

        localContent.append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR);

        // create a loop per parameter
        for (PatternParameter parameter : pattern.getAllParameters()) {
            String local = PatternHelper.localizeName(parameter);
            localContent.append("for (Object ").append(local).append(" : ").append(getParameterListName(parameter)).append(" ) {").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
        localContent.append(EGFCommonConstants.LINE_SEPARATOR);
        for (org.eclipse.egf.model.pattern.PatternParameter parameter : pattern.getAllParameters()) {
            String local = PatternHelper.localizeName(parameter);
            String type = ParameterTypeHelper.INSTANCE.getSourceTypeLiteral(parameter.getType());
            localContent.append("this.").append(parameter.getName()).append(" = (").append(type).append(")").append(local).append(";").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        }

        localContent.append(EGFCommonConstants.LINE_SEPARATOR).append("%>"); //$NON-NLS-1$

        content.insert(orchestrationIndex, localContent);

        // 2 - Add post block at current index
        content.append("<%").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$

        for (int i = 0; i < pattern.getAllParameters().size(); i++)
            content.append("}").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("ctx.setNode(currentNode);").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$  
        content.append("if (ctx.useReporter()){").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("    ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        content.append("}%>"); //$NON-NLS-1$

        // 3- Add additional code for parameter names handling
        int startIndex = content.indexOf(START_LOOP_MARKER);
        if (startIndex == -1)
            throw new PatternException(EGFPatternMessages.assembly_error2);

        // localContent.setLength(0);
        // localContent.append(EGFCommonConstants.LINE_SEPARATOR);
        // localContent.append("Map<String, Object> parameterValues = new HashMap<String, Object>();").append(EGFCommonConstants.LINE_SEPARATOR);
        // for (org.eclipse.egf.model.pattern.PatternParameter parameter :
        // pattern.getAllParameters()) {
        // String local = PatternHelper.localizeName(parameter);
        // String type =
        // ParameterTypeHelper.INSTANCE.getTypeLiteral(parameter.getType());
        // localContent.append(type).append(" ").append(parameter.getName()).append(" = (").append(type).append(")").append(local).append(";").append(EGFCommonConstants.LINE_SEPARATOR);
        // localContent.append("parameterValues.put(\"").append(parameter.getName()).append("\", ").append(local).append(");").append(EGFCommonConstants.LINE_SEPARATOR);
        // }
        // content.insert(startIndex + START_LOOP_MARKER.length(),
        // localContent);
    }

    private String getParameterListName(PatternParameter parameter) {
        return parameter.getName() + "List"; //$NON-NLS-1$
    }

    @SuppressWarnings("unused")
    private void appendQueryCode(StringBuilder localContent, PatternParameter parameter) throws PatternException {
        Query query = parameter.getQuery();
        if (query == null) {
            // there is no query, so this pattern can only be called by another
            // (i.e. it's an entry point in execution)
            localContent.append("List<Object> ").append(getParameterListName(parameter)).append(" = null;").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$
            localContent.append("//this pattern can only be called by another (i.e. it's not an entry point in execution)").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
            return;
        }
        localContent.append("paramDesc = new IQuery.ParameterDescription(\"").append(parameter.getName()).append("\", \"").append(parameter.getType()).append("\");").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        localContent.append("queryCtx = new HashMap<String, String>();").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        if (query.getQueryContext() != null) {
            for (String key : query.getQueryContext().keySet()) {
                localContent.append("queryCtx.put(\"").append(key).append("\", \"").append(query.getQueryContext().get(key)).append("\");").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            }
        }
        localContent.append("List<Object> ").append(getParameterListName(parameter)).append(" = "); //$NON-NLS-1$ //$NON-NLS-2$
        localContent.append("QueryHelper.load(ctx, \"").append(query.getExtensionId()).append("\").execute(paramDesc, queryCtx, ctx);").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
    protected void addVariableInitialization() throws PatternException {
        content.append("<%").append(START_INIT_VARIABLE_MARKER).append("%>"); //$NON-NLS-1$ //$NON-NLS-2$
        content.append(contentHelper.getMethodContent(pattern.getInitMethod()));
        content.append("<%").append(END_INIT_VARIABLE_MARKER).append("%>"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    public static final String START_METHOD_DECLARATION_MARKER = "//Start of methods"; //$NON-NLS-1$

    public static final String END_METHOD_DECLARATION_MARKER = "//End of methods"; //$NON-NLS-1$

    public static final String START_LOOP_MARKER = "//Start of work"; //$NON-NLS-1$

    public static final String END_LOOP_MARKER = "//End of work"; //$NON-NLS-1$

    public static final String START_INIT_VARIABLE_MARKER = "//Start of init"; //$NON-NLS-1$

    public static final String END_INIT_VARIABLE_MARKER = "//End of init"; //$NON-NLS-1$

    public static final String CONSTRUCTOR_MARKER = "//Here is the constructor"; //$NON-NLS-1$

}
