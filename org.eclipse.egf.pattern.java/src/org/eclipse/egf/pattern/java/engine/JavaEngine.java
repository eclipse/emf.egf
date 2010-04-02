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

package org.eclipse.egf.pattern.java.engine;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.common.java.AbstractJavaEngine;
import org.eclipse.egf.pattern.engine.AssemblyHelper;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.java.Messages;
import org.eclipse.egf.pattern.utils.FileHelper;

/**
 * @author Thomas Guiu
 * 
 */
public class JavaEngine extends AbstractJavaEngine {

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

        // 2 - add additional code to the class
        JavaTranslationEnhancer enhancer = new JavaTranslationEnhancer(pattern);
        templatecontent = enhancer.enhance(templatecontent);

        // 3 - put the result in the right file
        try {

            IPlatformFcore platformFactoryComponent = PatternHelper.getPlatformFcore(pattern);
            if (platformFactoryComponent == null)
                throw new PatternException(Messages.bind(Messages.assembly_error4, pattern.getName(), pattern.getID()));
            IProject project = platformFactoryComponent.getPlatformBundle().getProject();
            if (project == null)
                throw new PatternException(Messages.bind(Messages.assembly_error5, pattern.getName(), pattern.getID()));
            String classname = JavaNatureHelper.getClassName(pattern);
            IPath outputPath = computeFilePath(classname);
            FileHelper.setContent(project.getFile(outputPath), templatecontent, false);
        } catch (PatternException e) {
            throw e;
        } catch (Exception e) {
            throw new PatternException(e);
        }

    }

    @Override
    protected String getPatternClassname() throws PatternException {

        return JavaNatureHelper.getClassName(getPattern());
    }

}
