/**
 * ² * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern.java.engine;

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
import org.eclipse.egf.pattern.PatternPreferences;
import org.eclipse.egf.pattern.engine.AssemblyHelper;
import org.eclipse.egf.pattern.engine.PatternEngine;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.execution.ConsoleReporter;
import org.eclipse.egf.pattern.java.Messages;
import org.eclipse.egf.pattern.utils.FileHelper;

/**
 * @author Thomas Guiu
 * 
 */
public class JavaEngine extends PatternEngine {

    public JavaEngine(Pattern pattern) throws PatternException {
        super(pattern);
    }

    public void translate() throws PatternException {
        Pattern pattern = getPattern();
        if (pattern == null)
            throw new IllegalStateException();

        // **************************************************************************
        // 1 - put together all pt files
        AssemblyHelper helper = new JavaAssemblyHelper(pattern);
        String templatecontent = helper.visit();

        // 2 - put the result in the right file
        try {

            IPlatformFcore platformFactoryComponent = PatternHelper.getPlatformFcore(pattern);
            if (platformFactoryComponent == null)
                throw new PatternException(Messages.bind(Messages.assembly_error4, pattern.getName(), pattern.getID()));
            IProject project = platformFactoryComponent.getPlatformBundle().getProject();
            if (project == null)
                throw new PatternException(Messages.bind(Messages.assembly_error5, pattern.getName(), pattern.getID()));
            // TODO
            String classname = JavaNatureHelper.getClassName(pattern);
            IPath outputPath = computeFilePath(classname);
            FileHelper.setContent(project.getFile(outputPath), getContent(templatecontent));
        } catch (PatternException e) {
            throw e;
        } catch (Exception e) {
            throw new PatternException(e);
        }

    }

    private String getContent(String content) {
        StringBuilder builder = new StringBuilder(content.length() + 500);
        int startIndex = content.indexOf(JavaAssemblyHelper.START_MARKER);
        int endIndex = content.indexOf(JavaAssemblyHelper.END_MARKER);
        int insertionIndex = content.lastIndexOf('}');
        if (startIndex == -1 || endIndex == -1 || insertionIndex == -1)
            return content;
        // add start of class code
        builder.append(content.substring(0, startIndex));

        Pattern pattern = getPattern();
        // add new method call
        builder.append("String loop = generate((PatternContext)argument");
        if (!getPattern().getAllParameters().isEmpty()) {
            for (PatternParameter parameter : pattern.getAllParameters()) {
                String local = PatternHelper.localizeName(parameter);
                builder.append(", ").append(local);
            }
        }
        builder.append(");");

        // add end of class code
        builder.append(content.substring(endIndex + JavaAssemblyHelper.END_MARKER.length(), insertionIndex));

        // add new method body
        builder.append("public String generate(PatternContext ctx");
        if (!getPattern().getParameters().isEmpty()) {
            for (PatternParameter parameter : pattern.getParameters()) {
                String local = PatternHelper.localizeName(parameter);
                builder.append(", Object ").append(local);
            }
        }
        builder.append(") throws Exception {").append(EGFCommonConstants.LINE_SEPARATOR);
        builder.append("final StringBuffer out = new StringBuffer();").append(EGFCommonConstants.LINE_SEPARATOR);
        builder.append("PatternCallReporter callReporter =  new PatternCallReporter(out);").append(EGFCommonConstants.LINE_SEPARATOR);
        builder.append(content.substring(startIndex + JavaAssemblyHelper.START_MARKER.length(), endIndex)).append(EGFCommonConstants.LINE_SEPARATOR);

        builder.append("String loop = out.toString();").append(EGFCommonConstants.LINE_SEPARATOR);
        if (!getPattern().getAllParameters().isEmpty())
            builder.append("ctx.getReporter().loopFinished(loop, ctx, parameterValues);").append(EGFCommonConstants.LINE_SEPARATOR);
        builder.append("return loop;").append(EGFCommonConstants.LINE_SEPARATOR);
        builder.append("} ").append(EGFCommonConstants.LINE_SEPARATOR);
        builder.append(content.substring(insertionIndex));

        return builder.toString();
    }

    private IPath computeFilePath(String classname) {
        if (classname == null || "".equals(classname))
            throw new IllegalArgumentException();

        IPath result = new Path(PatternPreferences.getGenerationFolderName());
        String[] names = classname.split("\\.");
        for (String name : names) {
            result = result.append(name);
        }
        result = result.addFileExtension("java");
        return result;
    }

    @Override
    public void executeWithInjection(PatternContext context, Object... parameters) throws PatternException {
        doExecute(context, parameters);
    }

    @Override
    public void execute(PatternContext context) throws PatternException {

        setupExecutionReporter(context);
        doExecute(context, null);
    }

    private void doExecute(PatternContext context, Object[] executionParameters) throws PatternException {
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
            Method method = templateClass.getMethod(JavaAssemblyHelper.GENERATE_METHOD, parameterClasses);
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

    private void setupExecutionReporter(PatternContext context) throws PatternException {
        PatternExecutionReporter reporter = null;
        String classname = (String) context.getValue(PatternContext.PATTERN_REPORTER);
        if (classname == null)
            reporter = new ConsoleReporter();
        else {
            try {
                Class<?> templateClass = context.getBundle(getBundleId()).loadClass(classname);
                reporter = (PatternExecutionReporter) templateClass.newInstance();
            } catch (Exception e) {
                throw new PatternException(e);
            }
        }
        context.setReporter(reporter);
    }

    private Class<?> loadTemplateClass(PatternContext context) throws PatternException, ClassNotFoundException {
        Pattern pattern = getPattern();
        if (pattern == null)
            throw new PatternException(Messages.assembly_error9);
        String templateClassName = JavaNatureHelper.getClassName(pattern);
        if (templateClassName == null)
            throw new PatternException(Messages.assembly_error1);
        Class<?> templateClass = context.getBundle(getBundleId()).loadClass(templateClassName);
        return templateClass;
    }

}
