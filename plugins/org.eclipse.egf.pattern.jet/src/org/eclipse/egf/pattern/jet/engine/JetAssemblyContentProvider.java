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

package org.eclipse.egf.pattern.jet.engine;

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.model.pattern.BackCall;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.SuperCall;
import org.eclipse.egf.pattern.common.java.AbstractJavaAssemblyContentProvider;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.utils.JavaMethodGenerationHelper;

/**
 * @author Thomas Guiu
 * 
 */
public class JetAssemblyContentProvider extends AbstractJavaAssemblyContentProvider {

    public JetAssemblyContentProvider(Pattern pattern) {
        super(pattern, new JavaMethodGenerationHelper("stringBuffer")); //$NON-NLS-1$

    }

    @Override
    protected void call(PatternCall call) throws PatternException {
        content.append("<%"); //$NON-NLS-1$
        super.call(call);
        content.append("%>").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
    }

    @Override
    protected void call(BackCall object) throws PatternException {
        content.append("<%"); //$NON-NLS-1$
        super.call(object);
        content.append("%>").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
    }

    @Override
    protected void call(SuperCall call) throws PatternException {
        content.append("<%"); //$NON-NLS-1$
        super.call(call);
        content.append("%>").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
    }

    @Override
    protected void call(PatternInjectedCall call) throws PatternException {
        content.append("<%"); //$NON-NLS-1$
        super.call(call);
        content.append("%>").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
    }

    @Override
    protected void call(MethodCall object) throws PatternException {
        content.append("<%").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        javaMethodHelper.addCallStatement(object.getCalled());
        content.append("%>").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
    }

    @Override
    protected void addMethodBodies() throws PatternException {
        content.append("<%").append(JetAssemblyHelper.START_METHOD_DECLARATION_MARKER).append("%>").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$
        for (PatternMethod method : PatternHelper.getUserMethods(pattern)) {
            content.append("<%"); //$NON-NLS-1$
            javaMethodHelper.addSignature(method);
            content.append("{").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
            //            content.append("final IndexValue idx = new IndexValue(").append(javaMethodHelper.getBufferName()).append(".length());").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ $NON-NLS-2$
            content.append("%>"); //$NON-NLS-1$
            content.append(getMethodContent(method));
            content.append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("<%InternalPatternContext ictx = (InternalPatternContext) ctx;").append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("new Node.DataLeaf(ictx.getNode(), getClass(), \"").append(method.getName()).append("\", ").append(javaMethodHelper.getBufferName()).append(".toString());").append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("}%>").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
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
                content.append("<%"); //$NON-NLS-1$
                javaMethodHelper.addConditionSignature(conditionMethod);
                content.append(EGFCommonConstants.LINE_SEPARATOR);
                content.append("{").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
                content.append(methodContent).append(EGFCommonConstants.LINE_SEPARATOR);
                content.append("}%>").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
            }
        }

        content.append("<%").append(JetAssemblyHelper.END_METHOD_DECLARATION_MARKER).append("%>").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$
    }
}
