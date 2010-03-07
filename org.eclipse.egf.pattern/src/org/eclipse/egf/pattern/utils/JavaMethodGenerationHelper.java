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

package org.eclipse.egf.pattern.utils;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternParameter;

/**
 * @author Thomas Guiu
 * 
 */
public class JavaMethodGenerationHelper {

    private final String bufferName;

    public JavaMethodGenerationHelper(String bufferName) {
        this.bufferName = bufferName;
    }

    public String getCallStatement(PatternMethod called) {
        StringBuilder builder = new StringBuilder(200);
        builder.append("method_").append(called.getName()).append("(ictx.getCallReporter().getBuffer(), ictx");
        Pattern pattern = called.getPattern();
        if (!pattern.getAllParameters().isEmpty()) {
            for (PatternParameter parameter : pattern.getAllParameters()) {
                builder.append(", ").append(parameter.getName());
            }
        }
        builder.append(");");
        return builder.toString();
    }

    public String getSignature(PatternMethod called) {
        StringBuilder builder = new StringBuilder(200);
        builder.append("protected void method_").append(called.getName()).append("(StringBuffer ").append(bufferName).append(", PatternContext ctx");
        Pattern pattern = called.getPattern();
        if (!pattern.getAllParameters().isEmpty()) {
            for (PatternParameter parameter : pattern.getAllParameters()) {
                String type = ParameterTypeHelper.INSTANCE.getTypeLiteral(parameter.getType());
                builder.append(", ").append(type).append(" ").append(parameter.getName());
            }
        }
        builder.append(")throws Exception ");
        return builder.toString();
    }

}
