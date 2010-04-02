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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.pattern.PatternPreferences;
import org.eclipse.egf.pattern.engine.AssemblyHelper;
import org.eclipse.egf.pattern.engine.PatternEngine;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.execution.ConsoleReporter;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.jet.JetPreferences;
import org.eclipse.egf.pattern.jet.Messages;
import org.eclipse.egf.pattern.utils.FileHelper;
import org.eclipse.egf.pattern.utils.ParameterTypeHelper;

/**
 * @author Thomas Guiu
 * 
 */
public class JetEngine extends PatternEngine {

    public JetEngine(Pattern pattern) throws PatternException {
        super(pattern);
    }

    @Override
    public void executeWithInjection(PatternContext context, Object... parameters) throws PatternException {
        doExecute(context, parameters);
    }

    @Override
    public void execute(PatternContext context) throws PatternException {

        setupExecutionReporter((InternalPatternContext) context);
        doExecute((InternalPatternContext) context, null);
    }

    private void doExecute(InternalPatternContext context, Object[] executionParameters) throws PatternException {
        try {
            Class<?> templateClass = loadTemplateClass(context);
            Object template = templateClass.newInstance();

            Class<?>[] parameterClasses = null;
            Object[] parameterValues = null;
            if (executionParameters == null) {
                parameterClasses = new Class<?>[] { Object.class };
                parameterValues = new Object[] { context };
            } else {
                int size = executionParameters == null ? 1 : executionParameters.length + 1;
                parameterClasses = new Class<?>[size];
                parameterValues = new Object[size];

                parameterClasses[0] = PatternContext.class;
                parameterValues[0] = context;
                for (int n = 0; n < executionParameters.length; n++) {
                    parameterClasses[n + 1] = Object.class;
                    parameterValues[n + 1] = executionParameters[n];
                }
            }
            Method method = templateClass.getMethod(JetAssemblyHelper.GENERATE_METHOD, parameterClasses);
            // the pattern is executed but we don't care about the result.
            method.invoke(template, parameterValues);
        } catch (InvocationTargetException e) {
            throw new PatternException(e.getCause());
        } catch (PatternException e) {
            throw e;
        } catch (Exception e) {
            throw new PatternException(e);
        }
    }

    private void setupExecutionReporter(InternalPatternContext context) throws PatternException {
        if (context.hasReporter())
            return;
        PatternExecutionReporter reporter = (PatternExecutionReporter) context.getValue(PatternContext.PATTERN_REPORTER);
        if (reporter == null)
            reporter = new ConsoleReporter();
        context.setReporter(reporter);
    }

    private Class<?> loadTemplateClass(InternalPatternContext context) throws PatternException, ClassNotFoundException {
        Pattern pattern = getPattern();
        if (pattern == null)
            throw new PatternException(Messages.assembly_error9);
        String templateClassName = JetNatureHelper.getTemplateClassName(pattern);
        if (templateClassName == null)
            throw new PatternException(Messages.assembly_error1);
        Class<?> templateClass = context.getBundle(getBundleId()).loadClass(templateClassName);
        return templateClass;
    }

    public void translate() throws PatternException {
        Pattern pattern = getPattern();
        if (pattern == null)
            throw new IllegalStateException();

        // **************************************************************************
        // 1 - put together all pt files
        AssemblyHelper helper = new JetAssemblyHelper(getPattern());
        String templatecontent = helper.visit();

        // 2 - compile the result
        String templateURI = "Pattern_" + pattern.getName() + " (" + pattern.getID() + ")";
        try {
            SkeletonJETCompiler compiler = new SkeletonJETCompiler(templateURI, new ByteArrayInputStream(templatecontent.getBytes()), JetPreferences.getEncoding());
            compiler.parse();
            if (pattern.getSuperPattern() != null) {
                Pattern parentPattern = pattern.getSuperPattern();
                ((SkeletonJETCompiler.CustomJETSkeleton) compiler.getSkeleton()).setParentClass(JetNatureHelper.getTemplateClassName(parentPattern));
            }
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            compiler.generate(outStream);

            String targetClassName = JetNatureHelper.getTemplateClassName(pattern);
            IPath outputPath = computeFilePath(targetClassName);
            IPlatformFcore platformFcore = PatternHelper.getPlatformFcore(getPattern());
            if (platformFcore == null)
                throw new PatternException(Messages.bind(Messages.assembly_error4, pattern.getName(), pattern.getID()));
            IProject project = platformFcore.getPlatformBundle().getProject();
            if (project == null)
                throw new PatternException(Messages.bind(Messages.assembly_error5, pattern.getName(), pattern.getID()));
            FileHelper.setContent(project.getFile(outputPath), getContent(new String(outStream.toByteArray())), false);

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
        // add new method call
        builder.append("generate(ctx");
        if (!getPattern().getAllParameters().isEmpty()) {
            for (PatternParameter parameter : pattern.getAllParameters()) {
                String local = PatternHelper.localizeName(parameter);
                builder.append(", ").append(local);
            }
        }
        builder.append(");");

        // add end of class code
        int startMethodIndex = content.indexOf(JetAssemblyHelper.START_METHOD_DECLARATION_MARKER, endIndex);
        int endMethodIndex = content.indexOf(JetAssemblyHelper.END_METHOD_DECLARATION_MARKER, endIndex);

        if (startMethodIndex != -1 && endMethodIndex != -1) {
            builder.append(content.substring(endIndex + JetAssemblyHelper.END_LOOP_MARKER.length(), startMethodIndex));
            builder.append(content.substring(endMethodIndex + JetAssemblyHelper.END_METHOD_DECLARATION_MARKER.length(), insertionIndex));
        } else
            builder.append(content.substring(endIndex + JetAssemblyHelper.END_LOOP_MARKER.length(), insertionIndex));

        // add pattern reporter stuff
        builder.append("public String generate(PatternContext ctx");
        if (!getPattern().getAllParameters().isEmpty()) {
            for (PatternParameter parameter : pattern.getAllParameters()) {
                String local = PatternHelper.localizeName(parameter);
                builder.append(", Object ").append(local);
            }
        }
        builder.append(") throws Exception  {").append(EGFCommonConstants.LINE_SEPARATOR);
        builder.append("InternalPatternContext ictx = (InternalPatternContext)ctx;").append(EGFCommonConstants.LINE_SEPARATOR);
        builder.append("int executionIndex = ictx.getExecutionBuffer().length();").append(EGFCommonConstants.LINE_SEPARATOR);
        // add orchestration statements
        builder.append(content.substring(startIndex + JetAssemblyHelper.START_LOOP_MARKER.length(), endIndex));

        builder.append(EGFCommonConstants.LINE_SEPARATOR);
        builder.append("String loop = ictx.getBuffer().toString();").append(EGFCommonConstants.LINE_SEPARATOR);
        if (!getPattern().getAllParameters().isEmpty()) {
            builder.append("if (ictx.useReporter()){").append(EGFCommonConstants.LINE_SEPARATOR);
            builder.append("    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));").append(EGFCommonConstants.LINE_SEPARATOR);

            builder.append("    Map<String, Object> parameterValues = new HashMap<String, Object>();").append(EGFCommonConstants.LINE_SEPARATOR);
            for (org.eclipse.egf.model.pattern.PatternParameter parameter : pattern.getAllParameters()) {
                String name = parameter.getName();
                // String type =
                // ParameterTypeHelper.INSTANCE.getTypeLiteral(parameter.getType());
                // builder.append(type).append(" ").append(parameter.getName()).append(" = (").append(type).append(")").append(local).append(";").append(EGFCommonConstants.LINE_SEPARATOR);
                builder.append("    parameterValues.put(\"").append(name).append("\", this.").append(name).append(");").append(EGFCommonConstants.LINE_SEPARATOR);
            }
            builder.append("    String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);").append(EGFCommonConstants.LINE_SEPARATOR);
            builder.append("    ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);").append(EGFCommonConstants.LINE_SEPARATOR);
            builder.append("    ictx.clearBuffer();}").append(EGFCommonConstants.LINE_SEPARATOR);
        }
        builder.append("return loop;").append(EGFCommonConstants.LINE_SEPARATOR);
        builder.append("} ").append(EGFCommonConstants.LINE_SEPARATOR);
        builder.append("").append(EGFCommonConstants.LINE_SEPARATOR);

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
                builder.insert(indexOf, "\nStringBuffer stringBuffer = new StringBuffer();\n");
                startVariable = builder.indexOf(JetAssemblyHelper.START_INIT_VARIABLE_MARKER);
                endVariable = builder.indexOf(JetAssemblyHelper.END_INIT_VARIABLE_MARKER);
                if (startVariable != -1 && endVariable != -1) {
                    builder.delete(startVariable, endVariable + JetAssemblyHelper.END_INIT_VARIABLE_MARKER.length());
                }
            }
        }

        // handle variable declarations and setters
        for (PatternVariable var : pattern.getVariables()) {
            String type = ParameterTypeHelper.INSTANCE.getTypeLiteral(var.getType());
            builder.append("protected ").append(type).append(" ").append(var.getName()).append(" = null;").append(EGFCommonConstants.LINE_SEPARATOR);
            builder.append("public void ").append(JavaMethodGenerationHelper.getSetterMethod(var)).append("(").append(type).append(" object) {").append(EGFCommonConstants.LINE_SEPARATOR);
            builder.append("this.").append(var.getName()).append(" = object;").append(EGFCommonConstants.LINE_SEPARATOR);
            builder.append("}").append(EGFCommonConstants.LINE_SEPARATOR);
        }

        // handle parameter declarations and setters
        for (PatternParameter var : pattern.getParameters()) {
            String type = ParameterTypeHelper.INSTANCE.getTypeLiteral(var.getType());
            builder.append("protected ").append(type).append(" ").append(var.getName()).append(" = null;").append(EGFCommonConstants.LINE_SEPARATOR);
            builder.append("public void ").append(JavaMethodGenerationHelper.getSetterMethod(var)).append("(").append(type).append(" object) {").append(EGFCommonConstants.LINE_SEPARATOR);
            builder.append("this.").append(var.getName()).append(" = object;").append(EGFCommonConstants.LINE_SEPARATOR);
            builder.append("}").append(EGFCommonConstants.LINE_SEPARATOR);
        }

        // handle getParameter() method declaration
        builder.append("public Map<String, Object> getParameters() {").append(EGFCommonConstants.LINE_SEPARATOR);
        builder.append("final Map<String, Object> parameters = new HashMap<String, Object>();").append(EGFCommonConstants.LINE_SEPARATOR);
        for (PatternParameter parameter : pattern.getAllParameters()) {
            String name = parameter.getName();
            builder.append("parameters.put(\"").append(name).append("\", this.").append(name).append(");").append(EGFCommonConstants.LINE_SEPARATOR);
        }
        builder.append("return parameters; }").append(EGFCommonConstants.LINE_SEPARATOR);

        // handle methods declarations
        if (startMethodIndex != -1 && endMethodIndex != -1) {
            builder.append(content.substring(startMethodIndex + JetAssemblyHelper.START_METHOD_DECLARATION_MARKER.length(), endMethodIndex));
        }

        builder.append(content.substring(insertionIndex));
        return builder.toString();
    }

    private IPath computeFilePath(String classname) {
        IPath result = new Path(PatternPreferences.getGenerationFolderName());
        String[] names = classname.split("\\.");
        for (String name : names) {
            result = result.append(name);
        }
        result = result.addFileExtension("java");
        return result;
    }

}
