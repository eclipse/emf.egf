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

package org.eclipse.egf.pattern.java.extension;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.model.javapattern.provider.JavaPatternItemProviderAdapterFactory;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.engine.PatternEngine;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.extension.BasePatternInitializer;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.extension.PatternFactory;
import org.eclipse.egf.pattern.extension.PatternInitializer;
import org.eclipse.egf.pattern.extension.RefactoringManager;
import org.eclipse.egf.pattern.java.engine.JavaEngine;
import org.eclipse.egf.pattern.java.engine.JavaNatureHelper;
import org.eclipse.egf.pattern.utils.FileHelper;
import org.eclipse.emf.common.notify.AdapterFactory;

/**
 * @author Thomas Guiu
 * 
 */
public class JavaPatternExtension extends PatternExtension implements RefactoringManager {

    private static final PatternNature NATURE = org.eclipse.egf.model.javapattern.JavaPatternFactory.eINSTANCE.createJavaNature();

    private final PatternFactory factory = new JavaPatternFactory();

    @Override
    public PatternNature getNature() {
        return NATURE;
    }

    @Override
    public PatternEngine doCreateRunner(Pattern pattern) throws PatternException {
        return new JavaEngine(pattern);
    }

    @Override
    public PatternFactory getFactory() {
        return factory;
    }

    @Override
    public String canTranslate(Pattern pattern) {

        String canTranslate = super.canTranslate(pattern);
        if (canTranslate == null) {
            try {
                JavaNatureHelper.getClassName(pattern);
            } catch (PatternException e) {
                return e.getMessage();
            }
        }
        return canTranslate;
    }

    @Override
    protected PatternInitializer doCreateInitializer(IProject project, Pattern pattern) {

        return new JavaPatternInitializer(project, pattern);
    }

    @Override
    protected AdapterFactory getAdapterFactory() {

        return new JavaPatternItemProviderAdapterFactory();
    }

    @Override
    public RefactoringManager getRefactoringManager() {

        return this;
    }

    public void renamePattern(Pattern pattern, String oldName, String newName) throws PatternException {
        IProject project = PatternHelper.getProject(pattern);
        BasePatternInitializer initializer = (BasePatternInitializer) doCreateInitializer(project, pattern);
        PatternMethod method = pattern.getHeaderMethod();
        IFile methodFile = initializer.getFile(method);
        try {
            String content = FileHelper.getFileContent(methodFile);
            // Update the header if the class has the default name, do nothing
            // the user has changed the class name
            String regex = "public[\\s]*class[\\s]*" + PatternHelper.dropNonWordCharacter(oldName) + "[\\s]*\\{"; //$NON-NLS-1$ //$NON-NLS-2$
            String replacement = "public class " + PatternHelper.dropNonWordCharacter(newName) + " {"; //$NON-NLS-1$ //$NON-NLS-2$
            String newContent = content.replaceAll(regex, replacement);
            if (newContent == null)
                throw new PatternException(Messages.refactoring_error1);
            regex = "public[\\s]*" + PatternHelper.dropNonWordCharacter(oldName) + "[\\s]*\\(\\)[\\s]*\\{"; //$NON-NLS-1$ //$NON-NLS-2$
            replacement = "public " + PatternHelper.dropNonWordCharacter(newName) + "() {"; //$NON-NLS-1$ //$NON-NLS-2$
            newContent = newContent.replaceAll(regex, replacement);
            if (newContent == null)
                throw new PatternException(Messages.refactoring_error1);
            FileHelper.setContent(methodFile, newContent);
            // Delete previous generated java file
            PatternExtension.deleteJavaFile(project, JavaNatureHelper.getPackageName(pattern), oldName);
        } catch (java.util.regex.PatternSyntaxException e) {
            throw new PatternException(e);
        } catch (CoreException e) {
            throw new PatternException(e);
        } catch (IOException e) {
            throw new PatternException(e);
        }
    }

    public void renameLibrary(PatternLibrary lib, String oldName, String newName) throws PatternException {
        // TODO
    }

}
