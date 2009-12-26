/**
 * <copyright>
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

package org.eclipse.egf.pattern.jet.engine;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.constant.CharacterConstants;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.pattern.PatternPreferences;
import org.eclipse.egf.pattern.engine.AssemblyHelper;
import org.eclipse.egf.pattern.engine.PatternEngine;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.jet.JetPreferences;
import org.eclipse.egf.pattern.jet.Messages;
import org.eclipse.egf.pattern.utils.FileHelper;
import org.eclipse.emf.codegen.jet.JETCompiler;

/**
 * @author Guiu
 * 
 */
public class JetEngine extends PatternEngine {

    public JetEngine(Pattern pattern) throws PatternException {
        super(pattern);
    }

    public void execute(PatternContext context) throws PatternException {
        Pattern pattern = getPattern();
        if (pattern == null)
            throw new IllegalStateException();
        String templateClassName = JetNatureHelper.getTemplateClassName(pattern);
        if (templateClassName == null)
            throw new IllegalStateException(Messages.assembly_error1);

        try {
            Class<?> templateClass = context.getBundle(getBundleId()).loadClass(templateClassName);
            Method method = templateClass.getMethod(JetAssemblyHelper.GENERATE_METHOD, Object.class);
            Object template = templateClass.newInstance();
            // the pattern is executed but we don't care about the result.
            method.invoke(template, context);
        } catch (InvocationTargetException e) {
            throw new PatternException(e.getCause());
        } catch (PatternException e) {
            throw e;
        } catch (Exception e) {
            throw new PatternException(e);
        }

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
            JETCompiler compiler = new JETCompiler(templateURI, new ByteArrayInputStream(templatecontent.getBytes()), JetPreferences.getEncoding());
            compiler.parse();
            // Quick hack for debug
            // compiler.getSkeleton().addImports("java.util.* org.eclipse.emf.ecore.* ");
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
            FileHelper.setContent(project.getFile(outputPath), getContent(new String(outStream.toByteArray())));

        } catch (PatternException e) {
            throw e;
        } catch (Exception e) {
            throw new PatternException(e);
        }
    }

    private String getContent(String content) {
        StringBuilder builder = new StringBuilder(content.length() + 500);
        int startIndex = content.indexOf(JetAssemblyHelper.START_MARKER);
        int endIndex = content.indexOf(JetAssemblyHelper.END_MARKER);
        int insertionIndex = content.lastIndexOf('}');
        if (startIndex == -1 || endIndex == -1 || insertionIndex == -1)
            return content;
        // add start of class code
        builder.append(content.substring(0, startIndex));

        Pattern pattern = getPattern();
        // add new method call
        builder.append("generate(stringBuffer, ctx");
        if (!getPattern().getAllParameters().isEmpty()) {
            for (PatternParameter parameter : pattern.getAllParameters()) {
                String local = PatternHelper.localizeName(parameter);
                builder.append(", ").append(local);
            }
        }
        builder.append(");");

        // add end of class code
        builder.append(content.substring(endIndex + JetAssemblyHelper.END_MARKER.length(), insertionIndex));

        // add new method body
        builder.append("public void generate(final StringBuffer stringBuffer, PatternContext ctx");
        if (!getPattern().getAllParameters().isEmpty()) {
            for (PatternParameter parameter : pattern.getAllParameters()) {
                String local = PatternHelper.localizeName(parameter);
                builder.append(", Object ").append(local);
            }
        }
        builder.append(") {").append(CharacterConstants.LINE_SEPARATOR);
        builder.append(content.substring(startIndex + JetAssemblyHelper.START_MARKER.length(), endIndex));

        builder.append("} ").append(CharacterConstants.LINE_SEPARATOR);
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
