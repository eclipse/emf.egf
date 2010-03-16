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
    private StringBuilder content;

    public JavaMethodGenerationHelper(String bufferName) {
        this.bufferName = bufferName;
    }

    public void addCallStatement(PatternMethod called) {
        content.append("method_").append(called.getName()).append("(ictx.getBuffer(), ictx");
        Pattern pattern = called.getPattern();
        if (!pattern.getAllParameters().isEmpty()) {
            for (PatternParameter parameter : pattern.getAllParameters()) {
                content.append(", ").append(parameter.getName());
            }
        }
        content.append(");");
    }

    public void addSignature(PatternMethod called) {
        content.append("protected void method_").append(called.getName()).append("(final StringBuffer ").append(bufferName).append(", final PatternContext ctx");
        Pattern pattern = called.getPattern();
        if (!pattern.getAllParameters().isEmpty()) {
            for (PatternParameter parameter : pattern.getAllParameters()) {
                String type = ParameterTypeHelper.INSTANCE.getTypeLiteral(parameter.getType());
                content.append(", final ").append(type).append(" ").append(parameter.getName());
            }
        }
        content.append(")throws Exception ");
    }

    public void setContent(StringBuilder content) {
        this.content = content;
    }
}
