/**
² * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern.java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.constant.CharacterConstants;
import org.eclipse.egf.core.platform.pde.IPlatformFactoryComponent;
import org.eclipse.egf.model.PatternContext;
import org.eclipse.egf.model.PatternException;
import org.eclipse.egf.model.javapattern.impl.JavaEngineImpl;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.pattern.PatternHelper;
import org.eclipse.egf.pattern.PatternPreferences;
import org.eclipse.egf.pattern.execution.AssemblyHelper;
import org.eclipse.egf.pattern.execution.FileHelper_to_be_upgraded;
import org.eclipse.egf.pattern.execution.WorkspaceAndPluginClassLoader;

/**
 * @author Guiu
 * 
 *         Temp class ...
 */
public class JavaRunner_to_be_moved_to_model1 extends JavaEngineImpl {

    public JavaRunner_to_be_moved_to_model1(Pattern pattern) {
        setPattern(pattern);
    }

    public void execute(PatternContext context) throws PatternException {
        if (getPattern() == null)
            throw new IllegalStateException();
        String templateClassName = JavaNatureHelper.getClassName(pattern);
        if (templateClassName == null)
            throw new IllegalStateException(Messages.assembly_error3);
        try {

            Class<?> templateClass = new WorkspaceAndPluginClassLoader(PatternHelper.getPlatformFactoryComponent(getPattern())).loadClass(templateClassName);
            Method method = templateClass.getMethod("generate", Object.class);
            Object template = templateClass.newInstance();
            method.invoke(template, context);
        } catch (InvocationTargetException e) {
            throw new PatternException(e.getCause());
        } catch (Exception e) {
            throw new PatternException(e);
        }
    }

    public void translate() throws PatternException {
        if (getPattern() == null)
            throw new IllegalStateException();

        // **************************************************************************
        // 1 - put together all pt files
        AssemblyHelper helper = new JavaAssemblyHelper(getPattern());
        String templatecontent = helper.visit();

        // 2 - put the result in the right file
        try {

            IPlatformFactoryComponent platformFactoryComponent = PatternHelper.getPlatformFactoryComponent(getPattern());
            if (platformFactoryComponent == null)
                throw new PatternException(Messages.bind(Messages.assembly_error4, pattern.getName(), pattern.getID()));
            IProject project = platformFactoryComponent.getPlatformPlugin().getProject();
            if (project == null)
                throw new PatternException(Messages.bind(Messages.assembly_error5, pattern.getName(), pattern.getID()));
            // TODO
            String classname = JavaNatureHelper.getClassName(pattern);
            IPath outputPath = computeFilePath(classname);
            FileHelper_to_be_upgraded.setContent(project.getFile(outputPath), getContent(templatecontent));
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

        // add new method call
        builder.append("generate(tmpCollector, (PatternContext)argument");
        if (!getPattern().getParameters().isEmpty()) {
            for (PatternParameter parameter : pattern.getParameters()) {
                String local = PatternHelper.localizeName(parameter);
                builder.append(", ").append(local);
            }
        }
        builder.append(");");

        // add end of class code
        builder.append(content.substring(endIndex + JavaAssemblyHelper.END_MARKER.length(), insertionIndex));

        // add new method body
        builder.append("public void generate(StringBuilder out, PatternContext ctx");
        if (!getPattern().getParameters().isEmpty()) {
            for (PatternParameter parameter : pattern.getParameters()) {
                String local = PatternHelper.localizeName(parameter);
                builder.append(", Object ").append(local);
            }
        }
        builder.append(") {").append(CharacterConstants.LINE_SEPARATOR);
        builder.append(content.substring(startIndex + JavaAssemblyHelper.START_MARKER.length(), endIndex));

        builder.append("} ").append(CharacterConstants.LINE_SEPARATOR);
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

}
