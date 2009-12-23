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

package org.eclipse.egf.pattern.jet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.PatternException;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.pattern.PatternHelper;
import org.eclipse.egf.pattern.PatternPreferences;
import org.eclipse.egf.pattern.execution.AssemblyHelper;
import org.eclipse.emf.ecore.EClass;

/**
 * @author Thomas Guiu
 * 
 */
public class JetAssemblyHelper extends AssemblyHelper {

    public static final String GENERATE_METHOD = "generate";
    public static final String START_MARKER = "//Start of work";
    public static final String END_MARKER = "//End of work";

    public JetAssemblyHelper(Pattern pattern) {
        super(pattern);
    }

    @Override
    protected void call(Pattern pattern) throws PatternException {
        String templateClassName = JetNatureHelper.getTemplateClassName(pattern);
        if (templateClassName == null)
            throw new PatternException(Messages.assembly_error1);

        content.append("<%");
        content.append(" new ").append(templateClassName).append("().").append(GENERATE_METHOD).append("(stringBuffer, ctx");
        for (PatternParameter parameter : pattern.getParameters())
            content.append(", ").append(parameter.getName());

        content.append(");");
        content.append("%>");
    }

    @Override
    protected void visitOrchestration(Pattern pattern) throws PatternException {
        content.append("<%").append(START_MARKER).append("%>");
        super.visitOrchestration(pattern);
        content.append("<%").append(END_MARKER).append("%>");
    }

    /**
     * TODO quick work to validate the whole process, needs a plugable way to
     * add this stuff. TODO query is not supported yet.
     */
    @Override
    protected void handleParameters(int insertionIndex) {
        // 1 - Add pre block at insertionIndex
        StringBuilder localContent = new StringBuilder(300);
        localContent.append("<%").append(PatternPreferences.NL);
        localContent.append("").append(PatternPreferences.NL).append(PatternPreferences.NL);

        Map<String, List<String>> aliases = new HashMap<String, List<String>>();
        for (List<String> names : parameterAlias) {
            aliases.put(names.get(0), names);
        }

        for (PatternParameter parameter : pattern.getParameters()) {
            localContent.append("Collection<EObject> ").append(parameter.getName()).append("Collection = new ArrayList<EObject>(); //TODO Query;").append(PatternPreferences.NL);
        }

        localContent.append(PatternPreferences.NL).append(PatternPreferences.NL);

        // create a loop per parameter
        for (PatternParameter parameter : pattern.getParameters()) {
            String local = PatternHelper.localizeName(parameter);
            localContent.append("for (EObject ").append(local).append(" : ").append(parameter.getName()).append("Collection ) {").append(PatternPreferences.NL);
        }

        localContent.append(PatternPreferences.NL).append("%>");

        content.insert(insertionIndex, localContent);

        // 2 - Add post block at current index
        content.append("<%").append(PatternPreferences.NL);

        for (int i = 0; i < parameterAlias.size(); i++)
            content.append("}").append(PatternPreferences.NL);
        content.append(PatternPreferences.NL).append("%>");

        // 3- Add additional code for parameter names handling
        int startIndex = content.indexOf(START_MARKER);
        if (startIndex == -1)
            throw new IllegalStateException(Messages.assembly_error2);

        localContent.setLength(0);
        localContent.append(PatternPreferences.NL);
        for (org.eclipse.egf.model.pattern.PatternParameter parameter : pattern.getParameters()) {
            List<String> alias = aliases.get(parameter.getName());
            String local = PatternHelper.localizeName(parameter);
            EClass pEClass = parameter.getType().eClass();
            for (String name : alias) {
                localContent.append(pEClass.getName()).append(" ").append(name).append(" = (").append(pEClass.getName()).append(")").append(local).append(";").append(PatternPreferences.NL);
            }
        }
        content.insert(startIndex + START_MARKER.length(), localContent);
    }
}
