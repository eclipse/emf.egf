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

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.PatternHelper;
import org.eclipse.egf.pattern.PatternPreferences;
import org.eclipse.emf.ecore.EClass;

/**
 * @author Guiu
 * 
 */
public class JetPatternHelper extends PatternHelper {

    public JetPatternHelper(Pattern pattern) {
        super(pattern);
    }

    // TODO quick work to validate the whole process, needs a plugable way to
    // add this stuff
    // TODO query is not supported yet

    @Override
    protected void handleParameters(int insertionIndex) {
        // 1 - Add pre block at insertionIndex
        StringBuilder localContent = new StringBuilder(300);
        localContent.append("<%").append(PatternPreferences.NL);
        localContent.append("org.eclipse.egf.model.PatternContext ctx = (org.eclipse.egf.model.PatternContext)argument;").append(PatternPreferences.NL);
        localContent.append("").append(PatternPreferences.NL).append(PatternPreferences.NL);

        Map<String, List<String>> aliases = new HashMap<String, List<String>>();
        for (List<String> names : parameterAlias) {
            aliases.put(names.get(0), names);
        }

        for (org.eclipse.egf.model.pattern.PatternParameter parameter : pattern.getParameters()) {
            localContent.append("Collection<EObject> ").append(parameter.getName()).append("Collection = new ArrayList<EObject>(); //TODO Query;").append(PatternPreferences.NL);
        }

        localContent.append(PatternPreferences.NL).append(PatternPreferences.NL);

        for (org.eclipse.egf.model.pattern.PatternParameter parameter : pattern.getParameters()) {
            EClass pEClass = parameter.getType().eClass();
            String pTypeName = /* pEClass.getEPackage().getName() + "." + */pEClass.getName();
            String local = parameter.getName() + "Parameter";
            localContent.append("for (EObject ").append(local).append(" : ").append(parameter.getName()).append("Collection ) {").append(PatternPreferences.NL);
            List<String> alias = aliases.get(parameter.getName());
            for (String name : alias) {
                localContent.append(pTypeName).append(" ").append(name).append(" = (").append(pTypeName).append(")").append(local).append(";").append(PatternPreferences.NL);
            }

        }
        localContent.append(PatternPreferences.NL).append("%>");
        content.insert(insertionIndex, localContent);

        // 2 - Add post block at current index
        content.append("<%").append(PatternPreferences.NL);
        for (int i = 0; i < parameterAlias.size(); i++)
            content.append("}").append(PatternPreferences.NL);
        content.append(PatternPreferences.NL).append("%>");

    }

}
