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
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.Activator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IStorageEditorInput;

/**
 * @author Thomas Guiu
 * 
 */
public class RuntimePatternMethodEditorInput extends AbstractPatternMethodEditorInput implements IStorageEditorInput {

    public RuntimePatternMethodEditorInput(Resource resource, String fragment) {
        super(resource, fragment);
    }

    public IStorage getStorage() throws CoreException {
        return new MyStorage();
    }

    private class MyStorage implements IStorage {

        public InputStream getContents() throws CoreException {
            IPlatformFcore platformFcore = EGFCorePlugin.getPlatformFcore(getResource());
            PatternMethod patternMethod = getPatternMethod();
            try {
                return platformFcore.getPlatformBundle().getBundle().getEntry(patternMethod.getPatternFilePath().path()).openStream();
            } catch (IOException e) {
                Activator.getDefault().logError(e);
                return new ByteArrayInputStream(e.toString().getBytes());
            }
        }

        public IPath getFullPath() {
            return null;
        }

        public String getName() {
            return null;
        }

        public boolean isReadOnly() {
            return true;
        }

        @SuppressWarnings("unchecked")
        public Object getAdapter(Class adapter) {
            return null;
        }

    }

}
