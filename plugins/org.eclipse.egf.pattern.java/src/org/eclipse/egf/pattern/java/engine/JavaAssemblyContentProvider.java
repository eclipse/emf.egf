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

package org.eclipse.egf.pattern.java.engine;

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.common.java.AbstractJavaAssemblyContentProvider;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.utils.JavaMethodGenerationHelper;

/**
 * @author Thomas Guiu
 * 
 */
public class JavaAssemblyContentProvider extends AbstractJavaAssemblyContentProvider {

    public JavaAssemblyContentProvider(Pattern pattern) {
        super(pattern, new JavaMethodGenerationHelper("out")); //$NON-NLS-1$
    }

    @Override
    protected void call(MethodCall object) throws PatternException {
        javaMethodHelper.addCallStatement(object.getCalled());
        content.append(EGFCommonConstants.LINE_SEPARATOR);
    }

    @Override
    protected void addMethodBodies() throws PatternException {
        for (PatternMethod method : PatternHelper.getUserMethods(pattern)) {
            javaMethodHelper.addSignature(method);
            content.append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("{").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
            //            content.append("final IndexValue idx = new IndexValue(").append(javaMethodHelper.getBufferName()).append(".length());").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ $NON-NLS-2$
            content.append(getMethodContent(method)).append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("InternalPatternContext ictx = (InternalPatternContext) ctx;").append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("new Node.DataLeaf(ictx.getNode(), getClass(),\"").append(method.getName()).append("\", ").append(javaMethodHelper.getBufferName()).append(".toString());").append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("}").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$

        }

        PatternMethod conditionMethod = pattern.getConditionMethod();
        if (conditionMethod != null) {
            String methodContent = getMethodContent(conditionMethod);
            if (methodContent == null || "".equals(methodContent.trim())) { //$NON-NLS-1$
                if (pattern.getSuperPattern() == null || pattern.getSuperPattern().getConditionMethod() == null)
                    methodContent = "return true;"; //$NON-NLS-1$
                else
                    methodContent = null;
            }
            if (methodContent != null) {
                javaMethodHelper.addConditionSignature(conditionMethod);
                content.append(EGFCommonConstants.LINE_SEPARATOR);
                content.append("{").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
                content.append(methodContent).append(EGFCommonConstants.LINE_SEPARATOR);
                content.append("}").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
            }
        }
    }
}
