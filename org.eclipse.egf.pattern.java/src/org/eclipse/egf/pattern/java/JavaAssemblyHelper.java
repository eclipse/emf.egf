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

package org.eclipse.egf.pattern.java;

import java.util.Map.Entry;

import org.eclipse.egf.common.constant.CharacterConstants;
import org.eclipse.egf.model.PatternException;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.pattern.ParameterMatcher;
import org.eclipse.egf.pattern.PatternHelper;
import org.eclipse.egf.pattern.execution.AssemblyHelper;

/**
 * @author Thomas Guiu
 */
public class JavaAssemblyHelper extends AssemblyHelper {

    public static final String GENERATE_METHOD = "generate";
    public static final String START_MARKER = "//Start of work";
    public static final String END_MARKER = "//End of work";

    public JavaAssemblyHelper(Pattern pattern) {
        super(pattern);
    }

    @Override
    protected void call(PatternCall call) throws PatternException {
        Pattern pattern = call.getCalled();
        String templateClassName = JavaNatureHelper.getClassName(pattern);
        if (templateClassName == null)
            throw new PatternException(Messages.assembly_error1);

        if (call.getParameterMatching().isEmpty()) {
            // try to match parameters
            ParameterMatcher matcher = ParameterMatcher.create(call.getPattern(), pattern);
            if (!matcher.matches())
                throw new PatternException(Messages.bind(Messages.assembly_error7, call.getPattern().getName()));
            for (PatternParameter key : matcher.getMatching().keySet()) {
                String called = PatternHelper.uniqueName(key);
                content.append(key.getType()).append(" ").append(called).append(" = ").append(matcher.getMatching().get(key).getName()).append(";").append(CharacterConstants.LINE_SEPARATOR);
            }
        } else {
            for (Entry<PatternParameter, PatternParameter> binding : call.getParameterMatching()) {
                String called = PatternHelper.uniqueName(binding.getKey());
                content.append(binding.getKey().getType()).append(" ").append(called).append(" = ").append(binding.getValue().getName()).append(";").append(CharacterConstants.LINE_SEPARATOR);
            }
        }
        String ctxName = "ctx_" + PatternHelper.uniqueName(pattern);
        content.append("PatternContext ").append(ctxName).append(" = new PatternContext(ctx);").append(CharacterConstants.LINE_SEPARATOR);
        content.append(ctxName).append(".setValue(\"key\", \"value\");").append(CharacterConstants.LINE_SEPARATOR);
        content.append(" new ").append(templateClassName).append("().").append(GENERATE_METHOD).append(" (").append(ctxName);
        for (PatternParameter parameter : pattern.getParameters())
            content.append(", ").append(PatternHelper.uniqueName(parameter));

        content.append(");");
    }

    protected void addVariable(Pattern pattern) throws PatternException {
        content.append(START_MARKER).append(CharacterConstants.LINE_SEPARATOR);
        for (PatternVariable var : pattern.getVariables()) {
            content.append("EObject ").append(var.getName()).append(" = null;").append(CharacterConstants.LINE_SEPARATOR);
        }
        super.addVariable(pattern);

    }

    @Override
    protected void visitOrchestration(Pattern pattern) throws PatternException {
        super.visitOrchestration(pattern);
        content.append(END_MARKER).append(CharacterConstants.LINE_SEPARATOR);
    }

    /**
     * TODO quick work to validate the whole process, needs a plugable way to
     * add this stuff. TODO query is not supported yet.
     */
    @Override
    protected void handleParameters(int insertionIndex) {
        // 1 - Add pre block at insertionIndex
        StringBuilder localContent = new StringBuilder(300);
        localContent.append("").append(CharacterConstants.LINE_SEPARATOR).append(CharacterConstants.LINE_SEPARATOR);

        for (PatternParameter parameter : pattern.getParameters()) {
            localContent.append("Collection<EObject> ").append(parameter.getName()).append("Collection = new ArrayList<EObject>(); //TODO Query;").append(CharacterConstants.LINE_SEPARATOR);
        }

        localContent.append(CharacterConstants.LINE_SEPARATOR).append(CharacterConstants.LINE_SEPARATOR);

        // create a loop per parameter
        for (PatternParameter parameter : pattern.getParameters()) {
            String local = PatternHelper.localizeName(parameter);
            localContent.append("for (EObject ").append(local).append(" : ").append(parameter.getName()).append("Collection ) {").append(CharacterConstants.LINE_SEPARATOR);
        }

        localContent.append(CharacterConstants.LINE_SEPARATOR);

        content.insert(insertionIndex, localContent);

        // 2 - Add post block at current index
        content.append(CharacterConstants.LINE_SEPARATOR);

        for (int i = 0; i < pattern.getParameters().size(); i++)
            content.append("}").append(CharacterConstants.LINE_SEPARATOR);
        content.append(CharacterConstants.LINE_SEPARATOR);

        // 3- Add additional code for parameter names handling
        int startIndex = content.indexOf(START_MARKER);
        if (startIndex == -1)
            throw new IllegalStateException(Messages.assembly_error2);

        localContent.setLength(0);
        localContent.append(CharacterConstants.LINE_SEPARATOR);
        for (org.eclipse.egf.model.pattern.PatternParameter parameter : pattern.getParameters()) {
            String local = PatternHelper.localizeName(parameter);
            localContent.append(parameter.getType()).append(" ").append(parameter.getName()).append(" = (").append(parameter.getType()).append(")").append(local).append(";").append(CharacterConstants.LINE_SEPARATOR);
        }
        content.insert(startIndex + START_MARKER.length(), localContent);
    }
}
