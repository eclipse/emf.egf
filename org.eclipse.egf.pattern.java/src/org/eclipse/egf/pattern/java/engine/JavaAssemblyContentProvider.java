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

package org.eclipse.egf.pattern.java.engine;

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.common.java.AbstractJavaAssemblyContentProvider;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.java.Messages;
import org.eclipse.egf.pattern.utils.JavaMethodGenerationHelper;

/**
 * @author Thomas Guiu
 * 
 */
public class JavaAssemblyContentProvider extends AbstractJavaAssemblyContentProvider {

    public JavaAssemblyContentProvider(Pattern pattern) {
        super(pattern, new JavaMethodGenerationHelper("out"));
    }

    @Override
    protected void call(MethodCall object) throws PatternException {
        javaMethodHelper.addCallStatement(object.getCalled());
        content.append(EGFCommonConstants.LINE_SEPARATOR);
    }

    @Override
    protected void call(PatternInjectedCall call) throws PatternException {
        Pattern pattern = call.getCalled();
        String className = JavaNatureHelper.getClassName(pattern);
        if (className == null)
            throw new PatternException(Messages.assembly_error1);

        super.call(call);
    }

    @Override
    protected void addMethodBodies() throws PatternException {
        for (PatternMethod method : PatternHelper.getUserMethods(pattern)) {
            javaMethodHelper.addSignature(method);
            content.append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("{").append(EGFCommonConstants.LINE_SEPARATOR);
            content.append(getMethodContent(method)).append(EGFCommonConstants.LINE_SEPARATOR);
            content.append("}").append(EGFCommonConstants.LINE_SEPARATOR).append(EGFCommonConstants.LINE_SEPARATOR);
        }
    }

}
