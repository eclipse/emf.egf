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
import org.eclipse.egf.pattern.jet.Messages;
import org.eclipse.egf.pattern.utils.JavaMethodGenerationHelper;

/**
 * @author Thomas Guiu
 * 
 */
public class JetAssemblyContentProvider extends AbstractJavaAssemblyContentProvider {

    public JetAssemblyContentProvider(Pattern pattern) {
        super(pattern, new JavaMethodGenerationHelper("stringBuffer"));

    }

    @Override
    protected void call(PatternCall call) throws PatternException {
        content.append("<%");
        super.call(call);
        content.append("%>").append(EGFCommonConstants.LINE_SEPARATOR);
    }

    @Override
    protected void call(BackCall object) throws PatternException {
        content.append("<%");
        super.call(object);
        content.append("%>").append(EGFCommonConstants.LINE_SEPARATOR);
    }

    @Override
    protected void call(SuperCall call) throws PatternException {
        content.append("<%");
        super.call(call);
        content.append("%>").append(EGFCommonConstants.LINE_SEPARATOR);
    }

    @Override
    protected void call(PatternInjectedCall call) throws PatternException {
        Pattern pattern = call.getCalled();
        String templateClassName = JetNatureHelper.getTemplateClassName(pattern);
        if (templateClassName == null)
            throw new PatternException(Messages.assembly_error1);

        content.append("<%");
        super.call(call);
        content.append("%>").append(EGFCommonConstants.LINE_SEPARATOR);
    }

    @Override
    protected void call(MethodCall object) throws PatternException {
        content.append("<%").append(EGFCommonConstants.LINE_SEPARATOR);
        javaMethodHelper.addCallStatement(object.getCalled());
        content.append("%>").append(EGFCommonConstants.LINE_SEPARATOR);
    }

    @Override
    protected void addMethodBodies() throws PatternException {
        content.append("<%").append(JetAssemblyHelper.START_METHOD_DECLARATION_MARKER).append("%>").append(EGFCommonConstants.LINE_SEPARATOR);
        for (PatternMethod method : PatternHelper.getUserMethods(pattern)) {
            content.append("<%");
            javaMethodHelper.addSignature(method);
            content.append("{").append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("%>");
            content.append(getMethodContent(method));
            content.append("<%}%>").append(EGFCommonConstants.LINE_SEPARATOR);
        }
        content.append("<%").append(JetAssemblyHelper.END_METHOD_DECLARATION_MARKER).append("%>").append(EGFCommonConstants.LINE_SEPARATOR);
    }
}
