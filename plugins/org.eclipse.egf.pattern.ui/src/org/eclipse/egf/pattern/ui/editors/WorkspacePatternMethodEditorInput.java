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

package org.eclipse.egf.pattern.ui.editors;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IFileEditorInput;

/**
 * @author Thomas Guiu
 * 
 */
public class WorkspacePatternMethodEditorInput extends RuntimePatternMethodEditorInput implements IFileEditorInput {

    public WorkspacePatternMethodEditorInput(Resource resource, String fragment) {
        super(resource, fragment);

    }

    @Override
    public IStorage getStorage() throws CoreException {
        return getFile();
    }

    public IFile getFile() {
        IPlatformFcore platformFcore = EGFCorePlugin.getPlatformFcore(getResource());
        IProject project = platformFcore.getPlatformBundle().getProject();
        if (project == null)
            return null;
        PatternMethod patternMethod = getPatternMethod();
        IFile file;
        if (patternMethod == null)
            return project.getFile(path);
        file = project.getFile(patternMethod.getPatternFilePath().path());
        if (file.exists())
            return file;
        // this is a new method so we need to create the template file
        try {
            file.create(new ByteArrayInputStream(new byte[0]), true, null);
        } catch (CoreException e) {
            /*
             * all modifications of the recources that subclipse
             * touches do happen outside of eclipse own
             * control.Resources
             * are out of synch .
             */
            // Activator.getDefault().logError(e);
        }
        return file;
    }

}
