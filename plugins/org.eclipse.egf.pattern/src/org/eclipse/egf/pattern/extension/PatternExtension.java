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

package org.eclipse.egf.pattern.extension;

import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.helper.JavaHelper;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.engine.PatternEngine;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class PatternExtension {

    public static final String EXTENSION_ID = "org.eclipse.egf.pattern.extension"; //$NON-NLS-1$

    public abstract PatternNature getNature();

    public abstract PatternFactory getFactory();

    protected abstract AdapterFactory getAdapterFactory();

    protected abstract PatternEngine doCreateRunner(Pattern pattern) throws PatternException;

    public PatternEngine createEngine(Pattern pattern) throws PatternException {
        if (!matchNature(pattern))
            throw new PatternException(Messages.bind(Messages.extension_error2, getNature().eClass().getName(), pattern.getNature().eClass().getName()));
        return doCreateRunner(pattern);
    }

    protected abstract PatternInitializer doCreateInitializer(IProject project, Pattern pattern);

    public PatternInitializer createInitializer(IProject project, Pattern pattern) throws PatternException {
        if (!matchNature(pattern))
            throw new PatternException(Messages.bind(Messages.extension_error2, getNature().eClass().getName(), pattern.getNature().eClass().getName()));
        return doCreateInitializer(project, pattern);
    }

    public boolean matchNature(Pattern pattern) {
        if (pattern == null || pattern.getNature() == null)
            throw new IllegalArgumentException();
        if (getNature() == null)
            throw new IllegalStateException();

        return getNature().eClass().equals(pattern.getNature().eClass());
    }

    public final URL getImageURL() {
        IItemLabelProvider itemLabelProvider = (IItemLabelProvider) getAdapterFactory().adapt(getNature(), IItemLabelProvider.class);
        return (URL) itemLabelProvider.getImage(getNature());
    }

    /**
     * Tells if the pattern can be translated.
     * 
     * @return the reason who prevents the translation or null if there is no
     *         problem
     */
    public String canTranslate(Pattern pattern) {
        IProject project = PatternHelper.getProject(pattern);
        if (project == null)
            return Messages.assembly_error4;
        IFile file = project.getFile(pattern.getHeaderMethod().getPatternFilePath().path());
        if (!file.exists())
            return Messages.assembly_error5;
        return null; // no problem
    }

    /**
     * Tells if the pattern can be executed.
     * 
     * @return the reason who prevents the execution or null if there is no
     *         problem
     */
    public String canExecute(Pattern pattern) {
        // todo it should be in a validation rule...
        return null; // no problem
    }

    public abstract RefactoringManager getRefactoringManager();

    protected static void deleteJavaFile(IProject project, String packageName, String className) {
        if (project == null || packageName == null || className == null) {
            return;
        }
        // IJavaProject lookup
        IJavaProject javaProject = null;
        try {
            if (project.isAccessible() && project.hasNature(JavaCore.NATURE_ID)) {
                javaProject = JavaCore.create(project);
            }
            if (javaProject != null) {
                IPath path = new Path(org.eclipse.egf.common.helper.FileHelper.convertPackageNameToFolderPath(packageName));
                JavaHelper.deleteJavaFile(javaProject, path.append(PatternHelper.dropNonWordCharacter(className) + ".java"), false); //$NON-NLS-1$
            }
        } catch (Throwable t) {
            // Ignore
        } finally {
            try {
                javaProject.close();
            } catch (Throwable t) {
                // Ignore
            }
        }
    }

}
