/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.jet.engine;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.pattern.common.java.AbstractJavaEngine;
import org.eclipse.egf.pattern.engine.AssemblyHelper;
import org.eclipse.egf.pattern.jet.JetPreferences;
import org.eclipse.egf.pattern.utils.JavaMethodGenerationHelper;
import org.eclipse.egf.pattern.utils.ParameterTypeHelper;

/**
 * @author Thomas Guiu
 * 
 */
public class JetEngine extends AbstractJavaEngine {

    public JetEngine(Pattern pattern) throws PatternException {
        super(pattern);
    }

    @Override
    public void translate() throws PatternException {
        Pattern pattern = getPattern();

        // **************************************************************************
        // 1 - put together all pt files
        AssemblyHelper helper = new JetAssemblyHelper(getPattern(), new JetAssemblyContentProvider(getPattern()));
        String templatecontent = helper.visit();

        // 2 - compile the result
        String templateURI = "Pattern_" + pattern.getName() + " (" + pattern.getID() + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        try {
            SkeletonJETCompiler compiler = new SkeletonJETCompiler(templateURI, new ByteArrayInputStream(templatecontent.getBytes()), JetPreferences.getEncoding(EMFHelper.getProject(getPattern().eResource())));
            compiler.parse();
            if (pattern.getSuperPattern() != null) {
                Pattern parentPattern = pattern.getSuperPattern();
                ((SkeletonJETCompiler.CustomJETSkeleton) compiler.getSkeleton()).setParentClass(JetNatureHelper.getTemplateClassName(parentPattern));
            }
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            compiler.generate(outStream);

            String targetClassName = JetNatureHelper.getTemplateClassName(pattern);
            String content = getContent(new String(outStream.toByteArray()));
            IPath outputPath = computeFilePath(targetClassName);

            writeContent(pattern, outputPath, content);
        } catch (PatternException e) {
            throw e;
        } catch (Exception e) {
            throw new PatternException(e);
        }
    }

    private String getContent(String content) {

        StringBuilder builder = new StringBuilder(content.length() + 500);
        int startIndex = content.indexOf(JetAssemblyHelper.START_LOOP_MARKER);
        int endIndex = content.indexOf(JetAssemblyHelper.END_LOOP_MARKER);
        int insertionIndex = content.lastIndexOf('}');
        if (startIndex == -1 || endIndex == -1 || insertionIndex == -1)
            return content;
        // add start of class code
        builder.append(content.substring(0, startIndex));

        Pattern pattern = getPattern();
        // add call to orchestration
        if (pattern.getConditionMethod() != null) {
            builder.append("if (preCondition(ctx)) "); //$NON-NLS-1$
            builder.append(EGFCommonConstants.LINE_SEPARATOR);
        }
        builder.append('{').append(EGFCommonConstants.LINE_SEPARATOR);

        builder.append("ctx.setNode(new Node.Container(currentNode, getClass()));").append(EGFCommonConstants.LINE_SEPARATOR);
        builder.append(AssemblyHelper.ORCHESTRATION_METHOD).append("(ctx);").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        builder.append('}').append(EGFCommonConstants.LINE_SEPARATOR);

        // add end of class code
        int startMethodIndex = content.indexOf(JetAssemblyHelper.START_METHOD_DECLARATION_MARKER, endIndex);
        int endMethodIndex = content.indexOf(JetAssemblyHelper.END_METHOD_DECLARATION_MARKER, endIndex);

        if (startMethodIndex != -1 && endMethodIndex != -1) {
            builder.append(content.substring(endIndex + JetAssemblyHelper.END_LOOP_MARKER.length(), startMethodIndex));
            builder.append(content.substring(endMethodIndex + JetAssemblyHelper.END_METHOD_DECLARATION_MARKER.length(), insertionIndex));
        } else
            builder.append(content.substring(endIndex + JetAssemblyHelper.END_LOOP_MARKER.length(), insertionIndex));

        // add pattern reporter stuff
        builder.append("public String ").append(AssemblyHelper.ORCHESTRATION_METHOD).append("(PatternContext ctx) throws Exception  {").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$
        builder.append("InternalPatternContext ictx = (InternalPatternContext)ctx;").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        // add orchestration statements
        builder.append(content.substring(startIndex + JetAssemblyHelper.START_LOOP_MARKER.length(), endIndex));

        builder.append(EGFCommonConstants.LINE_SEPARATOR);
        builder.append("String loop = Node.flattenWithoutCallback(ictx.getNode());").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        boolean hasParameter = !getPattern().getAllParameters().isEmpty();
        builder.append("if (ictx.useReporter()){").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$

        if (hasParameter) {
            builder.append("    Map<String, Object> parameterValues = new HashMap<String, Object>();").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
            for (org.eclipse.egf.model.pattern.PatternParameter parameter : pattern.getAllParameters()) {
                String name = parameter.getName();
                // String type =
                // ParameterTypeHelper.INSTANCE.getTypeLiteral(parameter.getType());
                // builder.append(type).append(" ").append(parameter.getName()).append(" = (").append(type).append(")").append(local).append(";").append(EGFCommonConstants.LINE_SEPARATOR);
                builder.append("    parameterValues.put(\"").append(name).append("\", this.").append(name).append(");").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            }
            builder.append("    String outputWithCallBack = Node.flatten(ictx.getNode());").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
            builder.append("    ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        }
        builder.append("    ;}").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        builder.append("return loop;").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        builder.append("} ").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        builder.append("").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$

        // Handle variable initialization and fields
        int startVariable = content.indexOf(JetAssemblyHelper.START_INIT_VARIABLE_MARKER);
        int endVariable = content.indexOf(JetAssemblyHelper.END_INIT_VARIABLE_MARKER);
        if (startVariable != -1 && endVariable != -1) {
            int indexOf = builder.indexOf(JetAssemblyHelper.CONSTRUCTOR_MARKER);
            if (indexOf != -1) {
                CharSequence sequence = content.subSequence(startVariable + JetAssemblyHelper.START_INIT_VARIABLE_MARKER.length(), endVariable);
                indexOf += JetAssemblyHelper.CONSTRUCTOR_MARKER.length();
                builder.insert(indexOf, sequence);
                // TODO filter sequence instead of using a workaround...
                builder.insert(indexOf, "\nStringBuffer stringBuffer = new StringBuffer();\n"); //$NON-NLS-1$
                startVariable = builder.indexOf(JetAssemblyHelper.START_INIT_VARIABLE_MARKER);
                endVariable = builder.indexOf(JetAssemblyHelper.END_INIT_VARIABLE_MARKER);
                if (startVariable != -1 && endVariable != -1) {
                    builder.delete(startVariable, endVariable + JetAssemblyHelper.END_INIT_VARIABLE_MARKER.length());
                }
            }
        }

        // handle variable declarations and setters
        for (PatternVariable var : pattern.getVariables()) {
            String type = ParameterTypeHelper.INSTANCE.getSourceTypeLiteral(var.getType());
            builder.append("protected ").append(type).append(" ").append(var.getName()).append(" = null;").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            builder.append("public void ").append(JavaMethodGenerationHelper.getSetterMethod(var)).append("(").append(type).append(" object) {").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            builder.append("this.").append(var.getName()).append(" = object;").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$
            builder.append("}").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        }

        // handle parameter declarations and setters
        for (PatternParameter var : pattern.getParameters()) {
            String type = ParameterTypeHelper.INSTANCE.getSourceTypeLiteral(var.getType());
            builder.append("protected ").append(type).append(" ").append(var.getName()).append(" = null;").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            builder.append("public void ").append(JavaMethodGenerationHelper.getSetterMethod(var)).append("(").append(type).append(" object) {").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            builder.append("this.").append(var.getName()).append(" = object;").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$
            builder.append("}").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        }

        // handle getParameter() method declaration
        builder.append("public Map<String, Object> getParameters() {").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        builder.append("final Map<String, Object> parameters = new HashMap<String, Object>();").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$
        for (PatternParameter parameter : pattern.getAllParameters()) {
            String name = parameter.getName();
            builder.append("parameters.put(\"").append(name).append("\", this.").append(name).append(");").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
        builder.append("return parameters; }").append(EGFCommonConstants.LINE_SEPARATOR); //$NON-NLS-1$

        // handle methods declarations
        if (startMethodIndex != -1 && endMethodIndex != -1) {
            builder.append(content.substring(startMethodIndex + JetAssemblyHelper.START_METHOD_DECLARATION_MARKER.length(), endMethodIndex));
        }

        builder.append(content.substring(insertionIndex));
        return builder.toString();
    }

    @Override
    public String getUnderlyingClassname() throws PatternException {
        return JetNatureHelper.getTemplateClassName(getPattern());
    }

}
