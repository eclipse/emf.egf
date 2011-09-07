/**
 * <copyright>
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * </copyright>
 */

package org.eclipse.egf.pattern.common.java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.egf.core.pattern.PatternFolders;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.pattern.engine.AssemblyHelper;
import org.eclipse.egf.pattern.engine.PatternEngine;
import org.eclipse.egf.pattern.execution.ConsoleReporter;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.extension.PatternFactory;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.egf.pattern.utils.JavaMethodGenerationHelper;
import org.eclipse.egf.pattern.utils.ParameterTypeHelper;
import org.eclipse.egf.pattern.utils.TemplateFileHelper;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.osgi.util.NLS;
import org.eclipse.text.edits.TextEdit;

/**
 * @author Thomas Guiu
 */
public abstract class AbstractJavaEngine extends PatternEngine {

    public AbstractJavaEngine(Pattern pattern) throws PatternException {
        super(pattern);
    }

    @Override
    public final void executeWithInjection(PatternContext context, Map<PatternParameter, Object> parameters) throws PatternException {
        setupExecutionReporter((InternalPatternContext) context);
        doExecute((InternalPatternContext) context, AssemblyHelper.ORCHESTRATION_METHOD, parameters);
    }

    @Override
    public boolean checkCondition(PatternContext context, Map<PatternParameter, Object> parameters) throws PatternException {
        Object result = doExecute((InternalPatternContext) context, PatternFactory.PRECONDITION_METHOD_NAME, parameters);
        return Boolean.TRUE.equals(result);
    }

    @Override
    public final void execute(PatternContext context) throws PatternException {
        setupExecutionReporter((InternalPatternContext) context);
        doExecute((InternalPatternContext) context, AssemblyHelper.GENERATE_METHOD, null);
    }

    private Object doExecute(InternalPatternContext context, String methodName, Map<PatternParameter, Object> parameters) throws PatternException {
        try {
            Class<?> templateClass = loadTemplateClass(context, getUnderlyingClassname());
            Object template = templateClass.newInstance();
            Class<?>[] parameterClasses = new Class<?>[1];
            Object[] parameterValues = new Object[] { context };

            if (AssemblyHelper.GENERATE_METHOD.equals(methodName)) {
                parameterClasses[0] = Object.class;
            } else if (AssemblyHelper.ORCHESTRATION_METHOD.equals(methodName)) {
                parameterClasses[0] = PatternContext.class;
            } else if (PatternFactory.PRECONDITION_METHOD_NAME.equals(methodName)) {
                parameterClasses = new Class<?>[0];
                parameterValues = new Object[0];
            } else
                throw new IllegalStateException();

            if (AssemblyHelper.ORCHESTRATION_METHOD.equals(methodName) || PatternFactory.PRECONDITION_METHOD_NAME.equals(methodName)) {
                // setting up the state of the pattern
                Class<?>[] setterClasses = new Class<?>[1];
                Object[] setterValues = new Object[1];
                for (Map.Entry<PatternParameter, Object> entry : parameters.entrySet()) {
                    String setterMethod = JavaMethodGenerationHelper.getSetterMethod(entry.getKey());
                    String type = ParameterTypeHelper.INSTANCE.getBinaryTypeLiteral(entry.getKey().getType());
                    setterClasses[0] = loadTemplateClass(context, type);
                    setterValues[0] = entry.getValue();
                    Method method = templateClass.getMethod(setterMethod, setterClasses);
                    method.invoke(template, setterValues);
                }
            }

            // finally execute the pattern call
            Method method = null;
            try {
                method = templateClass.getMethod(methodName, parameterClasses);
            } catch (NoSuchMethodException e) {
                if (PatternFactory.PRECONDITION_METHOD_NAME.equals(methodName))
                    return Boolean.TRUE;
                throw e;
            }
            // the pattern is executed but we don't care about the result
            return method.invoke(template, parameterValues);
        } catch (InvocationTargetException e) {
            throw new PatternException(e.getCause());
        } catch (PatternException e) {
            throw e;
        } catch (Exception e) {
            throw new PatternException(e);
        }

    }

    private void setupExecutionReporter(InternalPatternContext context) {
        if (context.hasReporter())
            return;
        PatternExecutionReporter reporter = (PatternExecutionReporter) context.getValue(PatternContext.PATTERN_REPORTER);
        if (reporter == null)
            reporter = new ConsoleReporter();
        context.setReporter(reporter);
    }

    protected IPath computeFilePath(String classname) {
        if (classname == null || "".equals(classname)) //$NON-NLS-1$
            throw new IllegalArgumentException();

        IPath result = new Path(PatternFolders.getGenerationFolderName());
        String[] names = classname.split("\\."); //$NON-NLS-1$
        for (String name : names) {
            result = result.append(name);
        }
        result = result.addFileExtension("java"); //$NON-NLS-1$
        return result;
    }

    protected Class<?> loadTemplateClass(InternalPatternContext context, String type) throws PatternException, ClassNotFoundException {
        if (type == null)
            throw new PatternException(EGFPatternMessages.assembly_error1);
        Class<?> templateClass = context.getBundle(getBundleId()).loadClass(type);
        return templateClass;
    }

    protected void writeContent(Pattern pattern, IPath outputPath, String content) throws Exception {
        IProject project = EMFHelper.getProject(pattern.eResource());
        if (project == null) {
            throw new PatternException(NLS.bind(EGFCommonMessages.No_associated_project, EcoreUtil.getURI(pattern)));
        }
        // format code
        IJavaProject javaProject = JavaCore.create(project);
        if (javaProject != null) {
            Map<?, ?> options = javaProject.getOptions(true);
            CodeFormatter codeFormatter = ToolFactory.createCodeFormatter(options);
            IDocument doc = new Document(content);
            TextEdit edit = codeFormatter.format(CodeFormatter.K_COMPILATION_UNIT, doc.get(), 0, doc.get().length(), 0, null);
            if (edit != null) {
                edit.apply(doc);
                content = doc.get();
            }
        }

        TemplateFileHelper.setContent(project.getFile(outputPath), content, false);
    }
}
