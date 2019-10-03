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

/**
 * @author Matthieu Helleboid
 * 
 */
public class MethodInfo {
    public enum MethodInfoType {
        MethodCall, SuperMethodCall, BackCall, PatternCall, Method
    }

    protected MethodInfoType methodInfoType;
    protected String name;
    protected String content;

    protected MethodInfo(MethodInfoType methodInfoType, String name, String content) {
        this.methodInfoType = methodInfoType;
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MethodInfoType getMethodInfoType() {
        return methodInfoType;
    }

    public void setMethodInfoType(MethodInfoType methodInfoType) {
        this.methodInfoType = methodInfoType;
    }

    @Override
    public String toString() {
        if (name != null)
            return name.toString();
        return super.toString();
    }
}
