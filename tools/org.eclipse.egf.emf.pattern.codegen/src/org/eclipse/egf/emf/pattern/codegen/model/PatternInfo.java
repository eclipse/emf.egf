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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Matthieu Helleboid
 * 
 */
public class PatternInfo extends AbstractInfo {

    protected String name;
    protected String description;
    protected String libraryName;
    protected String methodName;
    protected String parameterType;
    protected String parameterName;
    protected List<VariableInfo> variableInfos = new ArrayList<VariableInfo>();
    protected List<MethodInfo> methods = new ArrayList<MethodInfo>();

    public PatternInfo() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public List<MethodInfo> getMethods() {
        return methods;
    }

    public void setMethods(List<MethodInfo> methods) {
        this.methods = methods;
    }

    public List<VariableInfo> getVariableInfos() {
        return variableInfos;
    }

    public void setVariableInfos(List<VariableInfo> variableInfos) {
        this.variableInfos = variableInfos;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    @Override
    protected Map<String, Object> getToStringProperties() {
        Map<String, Object> toStringProperties = super.getToStringProperties();
        toStringProperties.put("name", name); //$NON-NLS-1$
        toStringProperties.put("methodName", methodName); //$NON-NLS-1$
        toStringProperties.put("parameterType", parameterType); //$NON-NLS-1$
        toStringProperties.put("parameterName", parameterName); //$NON-NLS-1$
        return toStringProperties;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(super.toString());

        stringBuffer.append("  <Variables>"); //$NON-NLS-1$
        stringBuffer.append("\n"); //$NON-NLS-1$

        for (VariableInfo variableInfo : variableInfos) {
            stringBuffer.append("    "); //$NON-NLS-1$
            stringBuffer.append(variableInfo.toString());
            stringBuffer.append("\n"); //$NON-NLS-1$
        }

        stringBuffer.append("  </Variables>"); //$NON-NLS-1$
        stringBuffer.append("\n"); //$NON-NLS-1$

        return stringBuffer.toString();
    }
}