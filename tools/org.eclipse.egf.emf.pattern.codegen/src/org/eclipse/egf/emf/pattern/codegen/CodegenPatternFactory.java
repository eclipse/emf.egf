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

package org.eclipse.egf.emf.pattern.codegen;

import org.eclipse.egf.emf.pattern.codegen.model.JetSubPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.MethodInfo;
import org.eclipse.egf.emf.pattern.codegen.model.PatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.VariableInfo;
import org.eclipse.egf.emf.pattern.codegen.model.MethodInfo.MethodInfoType;
import org.eclipse.egf.model.pattern.BackCall;
import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.pattern.extension.PatternExtensionFactory;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenPatternFactory {

    protected PatternInfo patternInfo;

    protected Resource emfPatternBaseResource;

    protected CodegenEGFHelper codegenEGFHelper;

    protected PatternExtensionFactory patternFactory;

    protected CodegenPatternHelper codegenPatternHelper;

    public CodegenPatternFactory(PatternExtensionFactory patternFactory, Resource emfPatternBaseResource, CodegenEGFHelper codegenEGFHelper, PatternInfo patternInfo, CodegenPatternHelper codegenPatternHelper) {
        this.patternFactory = patternFactory;
        this.emfPatternBaseResource = emfPatternBaseResource;
        this.codegenEGFHelper = codegenEGFHelper;
        this.patternInfo = patternInfo;
        this.codegenPatternHelper = codegenPatternHelper;
    }

    public Pattern createPattern() {
        PatternLibrary library = codegenEGFHelper.getPatternLibrary(patternInfo.getPartType(), patternInfo.getLibraryName());
        Pattern pattern = patternFactory.createPattern(library, patternInfo.getName());
        pattern.setDescription(patternInfo.getDescription());
        codegenEGFHelper.fixXmiId(pattern, patternInfo.getPartType());

        removeBodyMethod(pattern);

        if (patternInfo instanceof JetSubPatternInfo) {
            JetSubPatternInfo jetSubPatternInfo = (JetSubPatternInfo) patternInfo;
            for (VariableInfo variableInfo : jetSubPatternInfo.getVariableInfos()) {
                PatternParameter parameter = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
                parameter.setName(variableInfo.getName());
                parameter.setType(variableInfo.getType());
                pattern.getParameters().add(parameter);
            } 
        } else {
            String superPatternName = codegenPatternHelper.getSuperPatternName(patternInfo);
            Pattern superPattern = codegenPatternHelper.findPattern(emfPatternBaseResource, superPatternName);
            pattern.setSuperPattern(superPattern);
        }

        for (MethodInfo methodInfo : patternInfo.getMethods()) {
            if (methodInfo == null)
                continue;

            String methodName = methodInfo.getName();

            switch (methodInfo.getMethodInfoType()) {
            case BackCall:
                BackCall backCall = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createBackCall();
                pattern.getOrchestration().add(backCall);
                break;

            case SuperMethodCall:
                PatternMethod superMethod = pattern.getMethod(methodName);
                if (superMethod == null)
                    throw new IllegalStateException("Could not found superMethod " + methodName); //$NON-NLS-1$

                MethodCall superMethodCall = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createMethodCall();
                superMethodCall.setCalled(superMethod);
                pattern.getOrchestration().add(superMethodCall);
                break;

            case Method:
            case MethodCall:
                PatternMethod method = null;

                for (PatternMethod patternMethod : pattern.getMethods()) {
                    if (patternMethod.getName().equals(methodName))
                        method = patternMethod;
                }

                if (method == null) {
                    method = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
                    pattern.getMethods().add(method);
                    method.setName(methodName);
                }

                if (MethodInfoType.MethodCall == methodInfo.getMethodInfoType() && !isMethodCalledInOrchestration(pattern, method)) {
                    MethodCall methodCall = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createMethodCall();
                    methodCall.setCalled(method);
                    pattern.getOrchestration().add(methodCall);
                }
                break;

            case PatternCall:
                PatternCall patternCall = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternCall();
                Pattern calledPattern = codegenPatternHelper.findPattern(emfPatternBaseResource, methodName);
                patternCall.setCalled(calledPattern);

                PatternParameter parameter = pattern.getParameter("parameter"); //$NON-NLS-1$
                PatternParameter argument = calledPattern.getParameter("argument"); //$NON-NLS-1$

                patternCall.getParameterMatching().put(argument, parameter);
                pattern.getOrchestration().add(patternCall);
                break;

            default:
                throw new IllegalStateException("Unknown methodInfoType"); //$NON-NLS-1$
            }
        }

        for (PatternMethod patternMethod : pattern.getMethods()) {
            codegenEGFHelper.fixXmiId(patternMethod, patternInfo.getPartType());
            patternMethod.setPatternFilePath(patternFactory.createURI(patternMethod));
        }

        return pattern;
    }

    protected void removeBodyMethod(Pattern pattern) {
        PatternMethod bodyMethod = null;
        for (PatternMethod patternMethod : pattern.getMethods()) {
            if (PatternExtensionFactory.BODY_METHOD_NAME.equals(patternMethod.getName()))
                bodyMethod = patternMethod;
        }
        if (bodyMethod != null)
            pattern.getMethods().remove(bodyMethod);
    }

    protected boolean isMethodCalledInOrchestration(Pattern pattern, PatternMethod method) {
        while (pattern != null) {
            for (Call call : pattern.getOrchestration()) {
                if (call instanceof MethodCall) {
                    MethodCall methodCall = (MethodCall) call;
                    if (methodCall.getCalled().getName().equals(method.getName()))
                        return true;
                }
            }
            pattern = pattern.getSuperPattern();
        }
        return false;

    }
}
