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

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;

/**
 * 
 * @author Thomas Guiu
 * 
 */

public class PatternEditorInput implements IEditorInput, IFileEditorInput {

    public static final String PATTERN_ID = "patternId"; //$NON-NLS-1$

    public static final String RESSOURCE_URI = "uri"; //$NON-NLS-1$

    protected static class EclipseUtil {

        public static Object getAdapter(Class<?> adapter, URI uri) {
            if ((adapter == IFile.class || adapter == IResource.class) && uri.isPlatformResource()) {
                return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
            }
            return null;
        }

        public static boolean exists(URI uri) {
            if (uri.isPlatformResource()) {
                return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true))).exists();
            }
            return false;
        }
    }

    private final PatternPersistableElement persistable = new PatternPersistableElement();

    private final String id;

    private final Resource resource;

    private IFile file;

    // Add for test read only mode --start;
    private boolean isReadOnly = false;

    public void setReadOnly(boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
    }

    // Add for test read only mode --end;

    public PatternEditorInput(Resource resource, String id) {
        if (id == null || resource == null) {
            throw new IllegalArgumentException();
        }
        this.resource = resource;
        this.id = id;
    }

    /**
     * Returns <b>true</b> only if the URI represents a file and if this file exists.
     * 
     * @see org.eclipse.ui.IEditorInput#exists()
     */
    public boolean exists() {
        if (getURI().isFile()) {
            return new File(getURI().toFileString()).exists();
        }
        return EclipseUtil.exists(getURI());
    }

    public boolean isReadOnly() {
        return isReadOnly || getFile() == null;
    }

    public Pattern getPattern() {
        return (Pattern) getResource().getEObject(id);
    }

    public Resource getResource() {
        return resource;
    }

    public String getID() {
        return id;
    }

    public URI getURI() {
        if (getPattern() != null) {
            return EGFCorePlugin.getPlatformURIConverter().normalize(EcoreUtil.getURI(getPattern()));
        }
        return EGFCorePlugin.getPlatformURIConverter().normalize(getResource().getURI());
    }

    public ImageDescriptor getImageDescriptor() {
        return null;
    }

    public String getName() {
        if (getPattern() == null)
            return ""; //$NON-NLS-1$
        return getPattern().getName();
    }

    public IPersistableElement getPersistable() {
        return persistable;
    }

    public String getToolTipText() {
        return getURI().toString();
    }

    @SuppressWarnings("unchecked")
    public Object getAdapter(Class adapter) {
        Object result = EclipseUtil.getAdapter(adapter, getURI());
        if (result != null) {
            return result;
        }
        return null;
    }

    @Override
    public boolean equals(Object object) {
        return this == object || object instanceof PatternEditorInput && getURI().equals(((PatternEditorInput) object).getURI());
    }

    private class PatternPersistableElement implements IPersistableElement {

        public void saveState(IMemento memento) {
            if (getPattern() != null) {
                memento.putString(PATTERN_ID, getID());
                memento.putString(RESSOURCE_URI, resource.getURI().toString());
            }
        }

        public String getFactoryId() {
            return "org.eclipse.egf.pattern.ui.pattern.factory.id"; //$NON-NLS-1$
        }

    }

    public IFile getFile() {
        if (file == null) {
            file = (IFile) EclipseUtil.getAdapter(IFile.class, getURI());
        }
        return file;
    }

    public IStorage getStorage() {
        return getFile();
    }

}
