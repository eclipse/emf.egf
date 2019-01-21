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
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.model.pattern.template.TemplateModelFileHelper;
import org.eclipse.egf.pattern.EGFPatternPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IStorageEditorInput;

/**
 * @author Thomas Guiu
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
            try {
                return TemplateModelFileHelper.getInputStream(getPatternMethod());
            } catch (IOException e) {
                EGFPatternPlugin.getDefault().logError(e);
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

        @SuppressWarnings("rawtypes")
        public Object getAdapter(Class adapter) {
            return null;
        }

    }

}
