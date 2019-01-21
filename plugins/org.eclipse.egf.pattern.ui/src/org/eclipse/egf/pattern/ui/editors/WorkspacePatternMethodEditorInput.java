/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IFileEditorInput;

/**
 * @author Thomas Guiu
 */
public class WorkspacePatternMethodEditorInput extends RuntimePatternMethodEditorInput implements IFileEditorInput {

    private IFile _file;

    public WorkspacePatternMethodEditorInput(Resource resource, String fragment) {
        super(resource, fragment);
    }

    @Override
    public IStorage getStorage() throws CoreException {
        return getFile();
    }

    public IFile getFile() {
        if (_file != null) {
            return _file;
        }
        IProject project = EMFHelper.getProject(getResource());
        if (project == null) {
            return null;
        }
        _file = project.getFile(URIHelper.toPlatformProjectString(getPatternMethod().getPatternFilePath(), true));
        if (_file.exists()) {
            return _file;
        }
        // this is a new method so we need to create the template file
        try {
            _file.create(new ByteArrayInputStream(new byte[0]), true, null);
        } catch (CoreException e) {
            /*
             * all modifications of the recources that subclipse
             * touches do happen outside of eclipse own
             * control.Resources
             * are out of synch .
             */
            // Activator.getDefault().logError(e);
        }
        return _file;
    }

}
