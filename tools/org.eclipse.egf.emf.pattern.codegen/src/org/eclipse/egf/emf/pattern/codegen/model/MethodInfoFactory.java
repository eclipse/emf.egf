/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.emf.pattern.codegen.model;

import org.eclipse.egf.emf.pattern.codegen.model.MethodInfo.MethodInfoType;

/**
 * @author Matthieu Helleboid
 * 
 */
public class MethodInfoFactory {
    public static MethodInfo createBackCall() {
        return new MethodInfo(MethodInfoType.BackCall, null, null);
    }

    public static MethodInfo createSuperMethodCall(String methodName) {
        return new MethodInfo(MethodInfoType.SuperMethodCall, methodName, null);
    }

    public static MethodInfo createMethodCall(String name, String content) {
        return new MethodInfo(MethodInfoType.MethodCall, name, content);
    }
    
    public static MethodInfo createMethod(String name, String content) {
        return new MethodInfo(MethodInfoType.Method, name, content);
    }

    public static MethodInfo createPatternCall(String name) {
        return new MethodInfo(MethodInfoType.PatternCall, name, null);
    }

}
