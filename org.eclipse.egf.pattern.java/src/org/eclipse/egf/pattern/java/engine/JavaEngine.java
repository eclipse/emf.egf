/**
 * ² * <copyright>
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

package org.eclipse.egf.pattern.java.engine;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;
import org.eclipse.egf.pattern.PatternPreferences;
import org.eclipse.egf.pattern.engine.AssemblyHelper;
import org.eclipse.egf.pattern.engine.PatternEngine;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.execution.ConsoleReporter;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.java.Messages;
import org.eclipse.egf.pattern.utils.FileHelper;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

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
        AssemblyHelper helper = new JavaAssemblyHelper(pattern, new JavaAssemblyContentProvider(pattern));
        String templatecontent = helper.visit();

        if (getPattern().getSuperPattern() != null) {
            Document document = new Document(templatecontent);
            ASTParser parser = ASTParser.newParser(AST.JLS3);
            parser.setKind(ASTParser.K_COMPILATION_UNIT);
            parser.setSource(document.get().toCharArray());
            CompilationUnit cu = (CompilationUnit) parser.createAST(null);
            cu.recordModifications();
            if ((cu.getFlags() & ASTNode.MALFORMED) == 0) {
                TypeDeclaration type = (TypeDeclaration) cu.types().get(0);
                String parentClassName = JavaNatureHelper.getClassName(getPattern().getSuperPattern());
                AST ast = type.getAST();
                SimpleType newSimpleType = ast.newSimpleType(ast.newName(parentClassName));
                type.setSuperclassType(newSimpleType);
            }
            TextEdit rewrite = cu.rewrite(document, null);
            try {
                rewrite.apply(document);
            } catch (BadLocationException e1) {
                throw new PatternException(e1);
            }
            templatecontent = document.get();
        }

        // 2 - put the result in the right file
        try {

            IPlatformFcore platformFactoryComponent = PatternHelper.getPlatformFcore(pattern);
            if (platformFactoryComponent == null)
                throw new PatternException(Messages.bind(Messages.assembly_error4, pattern.getName(), pattern.getID()));
            IProject project = platformFactoryComponent.getPlatformBundle().getProject();
            if (project == null)
                throw new PatternException(Messages.bind(Messages.assembly_error5, pattern.getName(), pattern.getID()));
            String classname = JavaNatureHelper.getClassName(pattern);
            IPath outputPath = computeFilePath(classname);
            FileHelper.setContent(project.getFile(outputPath), templatecontent);
        } catch (PatternException e) {
            throw e;
        } catch (Exception e) {
            throw new PatternException(e);
        }

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
        setupExecutionReporter((InternalPatternContext) context);
        doExecute(context, parameters);
    }

    @Override
    public void execute(PatternContext context) throws PatternException {

        setupExecutionReporter((InternalPatternContext) context);
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

    private void setupExecutionReporter(InternalPatternContext context) throws PatternException {
        if (context.hasReporter())
            return;
        PatternExecutionReporter reporter = (PatternExecutionReporter) context.getValue(PatternContext.PATTERN_REPORTER);
        if (reporter == null)
            reporter = new ConsoleReporter();
        context.setReporter(reporter);
    }

    private Class<?> loadTemplateClass(PatternContext context) throws PatternException, ClassNotFoundException {
        Pattern pattern = getPattern();
        if (pattern == null)
            throw new PatternException(Messages.assembly_error9);
        String templateClassName = JavaNatureHelper.getClassName(pattern);
        if (templateClassName == null)
            throw new PatternException(Messages.assembly_error1);
        Class<?> templateClass = ((InternalPatternContext) context).getBundle(getBundleId()).loadClass(templateClassName);
        return templateClass;
    }

}
