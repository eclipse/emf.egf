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

package org.eclipse.egf.emf.pattern.codegen;

import static org.eclipse.egf.emf.pattern.codegen.CodegenFcoreUtil.N;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.emf.pattern.codegen.jet.CodegenJetPatternHelper;
import org.eclipse.egf.emf.pattern.codegen.model.GIFPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.JetPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.JetSubPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.MethodInfo;
import org.eclipse.egf.emf.pattern.codegen.model.MethodInfoFactory;
import org.eclipse.egf.emf.pattern.codegen.model.PatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.VariableInfo;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenPatternMethodContentResolver {

    public static final String DO_GENERATE = "doGenerate"; //$NON-NLS-1$

    protected static final String SET_REPORTER_VARIABLES = "setReporterVariables"; //$NON-NLS-1$

    protected static final String PRE_CONDITION = "preCondition"; //$NON-NLS-1$

    protected static final String SET_ARGUMENT = "setArgument"; //$NON-NLS-1$

    protected static final String ENSURE_PROJECT_EXISTS = "ensureProjectExists"; //$NON-NLS-1$

    protected static final String PRE_GENERATE = "preGenerate"; //$NON-NLS-1$

    protected static final String POST_GENERATE = "postGenerate"; //$NON-NLS-1$

    protected static final String ARGUMENTS = "arguments"; //$NON-NLS-1$

    protected IProject codegenProject;

    protected CodegenPatternHelper codegenPatternHelper;

    protected Resource emfPatternBaseResource;

    protected CodegenJetPatternHelper codegenJetPatternHelper;

    public CodegenPatternMethodContentResolver(IProject codegenProject, CodegenPatternHelper codegenPatternHelper, Resource emfPatternBaseResource, CodegenJetPatternHelper codegenJetPatternHelper) {
        this.codegenProject = codegenProject;
        this.codegenPatternHelper = codegenPatternHelper;
        this.emfPatternBaseResource = emfPatternBaseResource;
        this.codegenJetPatternHelper = codegenJetPatternHelper;
    }

    public void computeMethodsContent(JetPatternInfo jetPatternInfo) {
        JetContentProvider contentProvider = new JetContentProvider(jetPatternInfo);
        addMethodInfo(jetPatternInfo, contentProvider.createSetReporterVariablesMethod());
        addMethodInfo(jetPatternInfo, contentProvider.createSetArgumentMethod());
        addMethodInfo(jetPatternInfo, contentProvider.createPreConditionMethod());
        addMethodInfo(jetPatternInfo, contentProvider.createEnsureProjectExistsMethod());
        addMethodInfo(jetPatternInfo, MethodInfoFactory.createSuperMethodCall(PRE_GENERATE));
        addMethodInfo(jetPatternInfo, contentProvider.createDoGenerateMethod());
        addMethodInfo(jetPatternInfo, MethodInfoFactory.createBackCall());
        addMethodInfo(jetPatternInfo, MethodInfoFactory.createSuperMethodCall(POST_GENERATE));
    }

    public void computeMethodsContent(JetSubPatternInfo patternInfo) {
        JetSubContentProvider contentProvider = new JetSubContentProvider(patternInfo);
        addMethodInfo(patternInfo, contentProvider.createDoGenerateMethod());
    }

    public void computeMethodsContent(GIFPatternInfo patternInfo) {
        GIFContentProvider contentProvider = new GIFContentProvider(patternInfo);
        addMethodInfo(patternInfo, contentProvider.createPreConditionMethod());
        addMethodInfo(patternInfo, contentProvider.createEnsureProjectExistsMethod());
        addMethodInfo(patternInfo, MethodInfoFactory.createSuperMethodCall(PRE_GENERATE));
        addMethodInfo(patternInfo, contentProvider.createDoGenerateMethod());
        addMethodInfo(patternInfo, MethodInfoFactory.createBackCall());
        addMethodInfo(patternInfo, MethodInfoFactory.createSuperMethodCall(POST_GENERATE));
    }

    protected void addMethodInfo(PatternInfo patternInfo, MethodInfo setReporterVariablesMethod) {
        patternInfo.getMethods().add(setReporterVariablesMethod);
    }

    protected class JetSubContentProvider extends ContentProvider {

        protected JetSubPatternInfo jetSubPatternInfo;

        public JetSubContentProvider(JetSubPatternInfo jetSubPatternInfo) {
            super(jetSubPatternInfo);
            this.jetSubPatternInfo = jetSubPatternInfo;
        }

        public MethodInfo createDoGenerateMethod() {
            String name = DO_GENERATE;
            String content = codegenJetPatternHelper.getContent(jetSubPatternInfo.getSection());
            return MethodInfoFactory.createMethodCall(name, content);
        }
    }

    protected class GIFContentProvider extends ContentProvider {

        protected GIFPatternInfo gifPatternInfo;

        public GIFContentProvider(GIFPatternInfo gifPatternInfo) {
            super(gifPatternInfo);
            this.gifPatternInfo = gifPatternInfo;
        }

        public MethodInfo createDoGenerateMethod() {
            String name = DO_GENERATE;

            StringBuffer buffer = new StringBuffer();
            buffer.append("<%"); //$NON-NLS-1$
            buffer.append(N);
            addParameterDeclaration(buffer);
            buffer.append(N);

            try {
                BufferedReader reader = new BufferedReader(new StringReader(gifPatternInfo.getMethodContent()));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    if (line.trim().startsWith("message")) { //$NON-NLS-1$
                        continue;
                    }

                    if (line.trim().startsWith("monitor")) { //$NON-NLS-1$
                        continue;
                    }

                    if (line.trim().startsWith("generate")) { //$NON-NLS-1$
                        line = getGenerateLine();
                    }

                    buffer.append(line);
                    buffer.append(N);
                }
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }

            buffer.append("%>"); //$NON-NLS-1$
            String content = buffer.toString();

            content = replaceAbstractGeneratorAdapterCalls(content);
            return MethodInfoFactory.createMethodCall(name, content);
        }

        protected String getGenerateLine() {
            StringBuffer lineBuffer = new StringBuffer();
            lineBuffer.append("new CodegenGeneratorAdapter(parameter).generateGIF("); //$NON-NLS-1$
            lineBuffer.append("\""); //$NON-NLS-1$
            lineBuffer.append(gifPatternInfo.getGifPath());
            lineBuffer.append("\""); //$NON-NLS-1$
            for (VariableInfo variableInfo : patternInfo.getVariableInfos()) {
                lineBuffer.append(", "); //$NON-NLS-1$
                lineBuffer.append(variableInfo.getValue());
            }
            lineBuffer.append(");"); //$NON-NLS-1$
            return lineBuffer.toString();
        }
    }

    protected class JetContentProvider extends ContentProvider {

        protected JetPatternInfo jetPatternInfo;

        public JetContentProvider(JetPatternInfo jetPatternInfo) {
            super(jetPatternInfo);
            this.jetPatternInfo = jetPatternInfo;
        }

        public MethodInfo createSetArgumentMethod() {
            String name = SET_ARGUMENT;

            StringBuffer buffer = new StringBuffer();
            buffer.append("<%"); //$NON-NLS-1$
            buffer.append(N);
            addParameterDeclaration(buffer);
            buffer.append(N);
            addJetArgumentAssignment(buffer);
            buffer.append(N);
            buffer.append("%>"); //$NON-NLS-1$
            String content = buffer.toString();

            return MethodInfoFactory.createMethodCall(name, content);
        }

        @Override
        protected void addCanGenerateAssigment(StringBuffer buffer) {
            super.addCanGenerateAssigment(buffer);
            buffer.append(N);
            buffer.append("canGenerate = canGenerate && "); //$NON-NLS-1$
            if (jetPatternInfo.getCondition() == null)
                buffer.append("true"); //$NON-NLS-1$
            else
                buffer.append(jetPatternInfo.getCondition());
            buffer.append(";"); //$NON-NLS-1$
        }

        protected MethodInfo createSetReporterVariablesMethod() {
            String name = SET_REPORTER_VARIABLES;

            StringBuffer buffer = new StringBuffer();
            buffer.append("<%"); //$NON-NLS-1$
            buffer.append(N);
            addParameterDeclaration(buffer);
            buffer.append(N);
            addVariables(buffer);
            buffer.append(N);
            buffer.append("%>"); //$NON-NLS-1$
            String content = buffer.toString();

            content = replaceAbstractGeneratorAdapterCalls(content);
            return MethodInfoFactory.createMethodCall(name, content);
        }

        protected MethodInfo createDoGenerateMethod() {
            String name = DO_GENERATE;

            String content = codegenJetPatternHelper.getContent(jetPatternInfo.getSection());

            return MethodInfoFactory.createMethodCall(name, content);
        }

        protected StringBuffer getPatternHeaderCall(String headerName) {
            String patternHeaderName = "Header" + headerName.substring(0, 1).toUpperCase() + headerName.substring(1).toLowerCase(); //$NON-NLS-1$
            String patternHeaderId = codegenPatternHelper.findPattern(emfPatternBaseResource, patternHeaderName).getID();

            StringBuffer lineBuffer = new StringBuffer();
            lineBuffer.append("<%"); //$NON-NLS-1$
            lineBuffer.append(N);
            lineBuffer.append("final Map<String, Object> parameters = new HashMap<String, Object>();"); //$NON-NLS-1$
            lineBuffer.append(N);
            lineBuffer.append("parameters.put(\"argument\", parameter);"); //$NON-NLS-1$
            lineBuffer.append(N);
            lineBuffer.append("CallHelper.executeWithInjection(\"" + patternHeaderId + "\", new ExecutionContext((InternalPatternContext) ctx), parameters);"); //$NON-NLS-1$ //$NON-NLS-2$
            lineBuffer.append(N);
            lineBuffer.append("%>"); //$NON-NLS-1$

            return lineBuffer;
        }

        protected void addJetArgumentAssignment(StringBuffer buffer) {
            // add jet arguments handling
            for (VariableInfo variableInfo : patternInfo.getVariableInfos()) {
                if (ARGUMENTS.equals(variableInfo.getName())) {
                    if ("null".equals(variableInfo.getValue())) { //$NON-NLS-1$
                        buffer.append("argument = parameter;"); //$NON-NLS-1$
                    } else {
                        buffer.append("argument = ((Object[]) "); //$NON-NLS-1$
                        buffer.append(variableInfo.getValue());
                        buffer.append(")[0];"); //$NON-NLS-1$
                    }
                }
            }
        }
    }

    protected class ContentProvider {

        protected PatternInfo patternInfo;

        public ContentProvider(PatternInfo patternInfo) {
            this.patternInfo = patternInfo;
        }

        protected String replaceAbstractGeneratorAdapterCalls(String content) {
            // replace AbstractGeneratorAdapter calls
            content = content.replace("toURI", "new CodegenGeneratorAdapter(parameter).toURI"); //$NON-NLS-1$ //$NON-NLS-2$
            content = content.replace("exists", "new CodegenGeneratorAdapter(parameter).exists"); //$NON-NLS-1$ //$NON-NLS-2$
            return content;
        }

        protected void addParameterDeclaration(StringBuffer buffer) {
            buffer.append(patternInfo.getParameterType());
            buffer.append(" "); //$NON-NLS-1$
            buffer.append(patternInfo.getParameterName());
            buffer.append(" = parameter;"); //$NON-NLS-1$
        }

        protected void addVariables(StringBuffer buffer) {
            boolean addN = false;
            for (VariableInfo variableInfo : patternInfo.getVariableInfos()) {
                if (!ARGUMENTS.equals(variableInfo.getName())) {
                    if (addN)
                        buffer.append(N);
                    buffer.append(variableInfo.getName());
                    buffer.append(" = "); //$NON-NLS-1$
                    buffer.append(variableInfo.getValue());
                    buffer.append(";"); //$NON-NLS-1$
                    addN = true;
                }
            }
        }

        protected MethodInfo createPreConditionMethod() {
            String name = PRE_CONDITION;

            StringBuffer buffer = new StringBuffer();
            addParameterDeclaration(buffer);
            buffer.append(N);
            buffer.append("genModel = parameter.getGenModel();"); //$NON-NLS-1$
            buffer.append(N);
            addCanGenerateAssigment(buffer);
            buffer.append(N);
            buffer.append("return canGenerate;"); //$NON-NLS-1$
            String content = buffer.toString();

            content = replaceAbstractGeneratorAdapterCalls(content);
            return MethodInfoFactory.createMethod(name, content);
        }

        protected MethodInfo createEnsureProjectExistsMethod() {
            String name = ENSURE_PROJECT_EXISTS;

            StringBuffer buffer = new StringBuffer();
            buffer.append("<%"); //$NON-NLS-1$
            buffer.append(N);
            addEnsureProjectExists(buffer);
            buffer.append(N);
            buffer.append("%>"); //$NON-NLS-1$
            String content = buffer.toString();

            return MethodInfoFactory.createMethodCall(name, content);
        }

        protected void addCanGenerateAssigment(StringBuffer buffer) {
            buffer.append("boolean canGenerate = "); //$NON-NLS-1$
            buffer.append("new CodegenGeneratorAdapter(parameter).canGenerate("); //$NON-NLS-1$
            buffer.append("\"org.eclipse.emf.codegen.ecore.genmodel.generator."); //$NON-NLS-1$
            buffer.append(patternInfo.getPartType());
            buffer.append("Project\");"); //$NON-NLS-1$
        }

        protected void addEnsureProjectExists(StringBuffer buffer) {
            // add ensure project exists
            buffer.append("new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.get"); //$NON-NLS-1$
            buffer.append(patternInfo.getPartType());
            buffer.append("Directory(), genModel, GenBaseGeneratorAdapter."); //$NON-NLS-1$
            buffer.append(patternInfo.getPartType().toString().toUpperCase());
            buffer.append("_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());"); //$NON-NLS-1$
        }
    }
}
