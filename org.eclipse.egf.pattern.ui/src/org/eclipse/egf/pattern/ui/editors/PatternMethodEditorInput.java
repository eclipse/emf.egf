/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;

/**
 * 
 * @author Thomas Guiu
 * 
 */

public class PatternMethodEditorInput implements IFileEditorInput {
    public static final String PATTERN_METHOD_ID = "methodId";
    public static final String RESSOURCE_URI = "uri";

    private final PatternPersistableElement persistable = new PatternPersistableElement();
    private final String fragment;
    private final Resource resource;

    public PatternMethodEditorInput(Resource resource, String fragment) {
        this.resource = resource;
        this.fragment = fragment;
    }

    public boolean exists() {

        return true;
    }

    public PatternMethod getPatternMethod() {
        return (PatternMethod) resource.getEObject(fragment);
    }

    public Resource getResource() {
        return resource;
    }

    public ImageDescriptor getImageDescriptor() {

        return null;
    }

    public String getName() {

        return getPatternMethod().getName();
    }

    public IPersistableElement getPersistable() {

        return persistable;
    }

    public String getToolTipText() {

        return Messages.input_tooltip;
    }

    public Object getAdapter(Class adapter) {

        return null;
    }

    private class PatternPersistableElement implements IPersistableElement {
        public void saveState(IMemento memento) {
            memento.putString(PATTERN_METHOD_ID, getPatternMethod().getID());
            memento.putString(RESSOURCE_URI, resource.getURI().toString());
        }

        public String getFactoryId() {

            return "org.eclipse.egf.pattern.ui.pattern.factory.id";
        }

    }

    public IFile getFile() {
        IPlatformFcore platformFcore = EGFCorePlugin.getPlatformFcore(getResource());
        IProject project = platformFcore.getPlatformBundle().getProject();
        return project.getFile(getPatternMethod().getPatternFilePath().path());
    }

    public IStorage getStorage() throws CoreException {

        return getFile();
    }
}
