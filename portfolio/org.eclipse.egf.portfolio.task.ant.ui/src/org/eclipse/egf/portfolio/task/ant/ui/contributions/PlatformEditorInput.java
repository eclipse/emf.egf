/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.portfolio.task.ant.ui.contributions;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.core.platform.uri.TargetPlatformURIConverter;
import org.eclipse.egf.task.ui.EGFTaskUIPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IStorageEditorInput;

class PlatformEditorInput implements IStorageEditorInput {

    private final URI uri;

    public PlatformEditorInput(String path) {
        uri = URI.createURI(path);
    }

    public IStorage getStorage() throws CoreException {
        return new MyStorage();
    }

    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class adapter) {
        return null;
    }

    public boolean exists() {

        return true;
    }

    public ImageDescriptor getImageDescriptor() {

        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PlatformEditorInput) {
            PlatformEditorInput input = (PlatformEditorInput) obj;
            return input.uri.equals(uri);
        }
        return super.equals(obj);
    }

    public String getName() {
        return uri.lastSegment();
    }

    public IPersistableElement getPersistable() {
        return null;
    }

    public String getToolTipText() {
        return uri.path();
    }

    private class MyStorage implements IStorage {

        public InputStream getContents() throws CoreException {
            try {
                TargetPlatformURIConverter converter = new TargetPlatformURIConverter();
                final BufferedReader reader = new BufferedReader(new InputStreamReader(converter.createInputStream(uri)));
                StringBuilder builder = new StringBuilder(1000);
                String readLine = reader.readLine();
                while (readLine != null) {
                    builder.append(readLine).append(EGFCommonConstants.LINE_SEPARATOR);
                    readLine = reader.readLine();
                }
                return new ByteArrayInputStream(builder.toString().getBytes());
            } catch (Exception e) {
                throw new CoreException(new Status(IStatus.ERROR, EGFTaskUIPlugin.getDefault().getPluginID(), e.getMessage(), e));
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
