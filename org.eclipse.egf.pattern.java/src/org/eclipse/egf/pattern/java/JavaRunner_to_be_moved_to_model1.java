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

package org.eclipse.egf.pattern.java;

import java.lang.reflect.Method;
import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.core.platform.pde.IPlatformFactoryComponent;
import org.eclipse.egf.model.PatternContext;
import org.eclipse.egf.model.PatternException;
import org.eclipse.egf.model.javapattern.JavaNature;
import org.eclipse.egf.model.javapattern.impl.JavaRunnerImpl;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.FileHelper_to_be_upgraded;
import org.eclipse.egf.pattern.PatternHelper;
import org.eclipse.egf.pattern.PatternPreferences;
import org.eclipse.egf.pattern.execution.WorkspaceAndPluginClassLoader;

/**
 * @author Guiu
 * 
 *         Temp class ...
 */
public class JavaRunner_to_be_moved_to_model1 extends JavaRunnerImpl {

    public JavaRunner_to_be_moved_to_model1(Pattern pattern) {
        setPattern(pattern);
    }

    public void run(PatternContext context) throws PatternException {
        if (getPattern() == null)
            throw new IllegalStateException();
        String templateClassName = ((JavaNature) getPattern().getNature()).getClassName();
        if (templateClassName == null)
            throw new IllegalStateException("Pattern class is null");
        try {

            Class<?> templateClass = new WorkspaceAndPluginClassLoader(PatternHelper.getPlatformFactoryComponent(getPattern())).loadClass(templateClassName);
            Method method = templateClass.getMethod("generate", Object.class);
            Object template = templateClass.newInstance();
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
        PatternHelper helper = new JavaPatternHelper(getPattern());
        String templatecontent = helper.visit();

        // 2 - put the result in the right file
        try {

            IPlatformFactoryComponent platformFactoryComponent = PatternHelper.getPlatformFactoryComponent(getPattern());
            if (platformFactoryComponent == null)
                throw new PatternException("Cannot get platformFactoryComponent related to pattern: " + pattern.getName() + " (Id: " + pattern.getID() + ").");
            IProject project = platformFactoryComponent.getPlatformPlugin().getProject();
            if (project == null)
                throw new PatternException("Cannot get project related to pattern: " + pattern.getName() + " (Id: " + pattern.getID() + ").");
            // TODO
            String classname = "MyLib.child";
            IPath outputPath = computeFilePath(classname);
            FileHelper_to_be_upgraded.setContent(project.getFile(outputPath), templatecontent);
            {
                // TODO: modifier le model ça va compliquer les choses .. mais
                // où mettre le nom de la classe ?
                ((JavaNature) getPattern().getNature()).setClassName(classname);
                getPattern().eResource().save(Collections.EMPTY_MAP);
            }
        } catch (PatternException e) {
            throw e;
        } catch (Exception e) {
            throw new PatternException(e);
        }

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
