/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.pde.internal.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.egf.core.fcore.IResourceFcoreDelta;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;

public class ResourceFcoreDelta implements IResourceFcoreDelta {

    private UniqueEList<URI> _added = new UniqueEList<URI>();

    private UniqueEList<URI> _updated = new UniqueEList<URI>();

    private UniqueEList<URI> _removed = new UniqueEList<URI>();

    private HashMap<URI, URI> _moved = new HashMap<URI, URI>();

    private UniqueEList<IProject> _affectedProjects = new UniqueEList<IProject>();

    public ResourceFcoreDelta() {
        // Nothing to do
    }

    @SuppressWarnings("unchecked")
    public List<URI> getNewFcores() {
        return (List<URI>) _added.clone();
    }

    @SuppressWarnings("unchecked")
    public List<URI> getUpdatedFcores() {
        return (List<URI>) _updated.clone();
    }

    @SuppressWarnings("unchecked")
    public List<URI> getRemovedFcores() {
        return (List<URI>) _removed.clone();
    }

    @SuppressWarnings("unchecked")
    public Map<URI, URI> getMovedFcores() {
        return (Map<URI, URI>) _moved.clone();
    }

    protected boolean isEmpty() {
        return _added.size() == 0 && _updated.size() == 0 && _removed.size() == 0 && _moved.size() == 0 ? true : false;
    }

    public List<IProject> getAffectedProjects() {
        return _affectedProjects;
    }

    protected boolean addNewFcore(IPath path, IProject project) {
        _affectedProjects.add(project);
        return addNewFcore(path);
    }

    protected boolean addNewFcore(IPath path) {
        URI uri = URIHelper.getPlatformPluginURI(path);
        if (uri == null) {
            return false;
        }
        _affectedProjects.add(ProjectHelper.getProject(path));
        return _added.add(uri);
    }

    protected boolean addUpdatedFcore(IResourceDelta delta) {
        URI uri = URIHelper.getPlatformPluginURI(delta.getResource());
        if (uri == null) {
            return false;
        }
        _affectedProjects.add(delta.getResource().getProject());
        return _updated.add(uri);
    }

    protected boolean addRemovedFcore(IPath path) {
        URI uri = URIHelper.getPlatformPluginURI(path);
        if (uri == null) {
            return false;
        }
        _affectedProjects.add(ProjectHelper.getProject(path));
        return _removed.add(uri);
    }

    protected boolean addMovedFcore(IPath path, IPath newPath) {
        URI uri = URIHelper.getPlatformPluginURI(path);
        URI newURI = URIHelper.getPlatformPluginURI(newPath);
        if (uri == null || newURI == null) {
            return false;
        }
        // Process path
        _affectedProjects.add(ProjectHelper.getProject(path));
        // Process newPath
        _affectedProjects.add(ProjectHelper.getProject(newPath));
        // Add to moved
        _moved.put(uri, newURI);
        return true;
    }

}
