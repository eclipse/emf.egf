/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.utils;

import org.eclipse.egf.model.fcore.NamedModelElement;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.extension.PatternFactory;

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
        content.append("method_").append(called.getName()).append("(new StringBuffer(), ictx);"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    public void addSignature(PatternMethod called) {
        content.append("protected void method_").append(called.getName()).append("(final StringBuffer ").append(bufferName).append(", final PatternContext ctx)throws Exception "); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

    public void addConditionSignature(PatternMethod called) {
        content.append("public boolean ").append(PatternFactory.PRECONDITION_METHOD_NAME).append("(PatternContext ctx) throws Exception "); //$NON-NLS-1$ //$NON-NLS-2$
    }

    public void setContent(StringBuilder content) {
        this.content = content;
    }

    public static String getSetterMethod(NamedModelElement paramOrVariable) {
        String name = paramOrVariable.getName();
        return "set_" + name; //$NON-NLS-1$
    }

    public String getBufferName() {
        return bufferName;
    }

}
