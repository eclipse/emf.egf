/**
 * <copyright>
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

package org.eclipse.egf.pattern.jet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.Collections;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.model.PatternContext;
import org.eclipse.egf.model.PatternException;
import org.eclipse.egf.model.jetpattern.JetNature;
import org.eclipse.egf.model.jetpattern.impl.JetRunnerImpl;
import org.eclipse.egf.pattern.FileHelper_to_be_upgraded;
import org.eclipse.egf.pattern.PatternHelper;
import org.eclipse.egf.pattern.PatternPreferences;
import org.eclipse.egf.pattern.Registry_to_be_upgraded;
import org.eclipse.egf.pattern.execution.WorkspacePluginClassLoader;
import org.eclipse.emf.codegen.jet.JETCompiler;
import org.eclipse.emf.codegen.jet.JETSkeleton;

/**
 * @author Guiu
 * 
 *         Temp class ...
 */
public class JetRunner_to_be_moved_to_model1 extends JetRunnerImpl {

    public void run(PatternContext context) throws PatternException {
        if (getPattern() == null)
            throw new IllegalStateException();
        String templateClassName = ((JetNature) getPattern().getNature()).getTemplateClassName();
        if (templateClassName == null)
            throw new IllegalStateException("Pattern class is null");
        try {

            Class<?> templateClass = new WorkspacePluginClassLoader(Registry_to_be_upgraded.getProjectName(getPattern())).loadClass(templateClassName);
            Method method = templateClass.getMethod("generate", Object.class);
            Object template = templateClass.newInstance();
            // the pattern is executed but we don't care about the result.
            // TODO initialiser le context
            method.invoke(template, context);
        } catch (Exception e) {
            throw new PatternException(e);
        }

    }

    public void translate() throws PatternException {
        if (getPattern() == null)
            throw new IllegalStateException();

        // **************************************************************************
        // 1 - put together all pt files
        PatternHelper helper = new JetPatternHelper(getPattern());
        String templatecontent = helper.visit();

        // 2 - compile the result
        String templateURI = "uri_test";
        try {
            JETCompiler compiler = new JETCompiler(templateURI, new ByteArrayInputStream(templatecontent.getBytes()), JetPreferences.getEncoding());
            compiler.parse();
            // Quick hack for debug
            // compiler.getSkeleton().addImports("java.util.* org.eclipse.emf.ecore.* ");
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            compiler.generate(outStream);

            String targetClassName = getTargetClassName(compiler.getSkeleton());
            IPath outputPath = computeFilePath(targetClassName);
            FileHelper_to_be_upgraded.setContent(Registry_to_be_upgraded.getProjectName(getPattern()), outputPath, new ByteArrayInputStream(outStream.toByteArray()));
            {
                // TODO: modifier le model ça va compliquer les choses .. mais
                // où mettre le nom de la classe ?
                ((JetNature) getPattern().getNature()).setTemplateClassName(targetClassName);
                getPattern().eResource().save(Collections.EMPTY_MAP);
            }

        } catch (Exception e) {
            throw new PatternException(e);
        }
    }

    private String getTargetClassName(JETSkeleton skeleton) {
        String packageName = skeleton.getPackageName();
        if (packageName == null || "".equals(packageName))
            return skeleton.getClassName();
        return packageName + '.' + skeleton.getClassName();
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
