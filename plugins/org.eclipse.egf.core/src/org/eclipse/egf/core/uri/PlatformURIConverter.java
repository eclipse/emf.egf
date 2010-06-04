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
package org.eclipse.egf.core.uri;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.URIMappingRegistryImpl;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.IPluginModelListener;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.PluginModelDelta;

/**
 * @author Xavier Maysonnave
 * 
 */
public class PlatformURIConverter extends ExtensibleURIConverterImpl implements IPluginModelListener, IResourceChangeListener {

    private static volatile PlatformURIConverter __platformURIConverter;

    // Use a lock object, this will prevent us against
    // a lock against the PlatformManager instance
    private static Object __lock = new Object();

    public static PlatformURIConverter getInstance() {
        if (__platformURIConverter == null) {
            synchronized (__lock) {
                if (__platformURIConverter == null) {
                    __platformURIConverter = new PlatformURIConverter();
                }
            }
        }
        return __platformURIConverter;
    }

    private class ResourceDeltaVisitor implements IResourceDeltaVisitor {

        protected boolean _affected = false;

        public boolean visit(IResourceDelta delta) throws CoreException {
            // nothing to process
            if (_affected == true) {
                return false;
            }
            // Process file
            if (delta.getResource().getType() != IResource.PROJECT) {
                return true;
            }
            if (delta.getKind() == IResourceDelta.ADDED) {
                if ((delta.getFlags() & IResourceDelta.MOVED_FROM) == 0) {
                    _affected = true;
                }
            } else if (delta.getKind() == IResourceDelta.REMOVED) {
                _affected = true;
            }
            return false;

        }

        public boolean isAffected() {
            return _affected;
        }

    }

    private PlatformURIConverter() {
        PDECore.getDefault().getModelManager().addPluginModelListener(this);
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
        loadURIMap();
    }

    public void modelsChanged(PluginModelDelta delta) {
        // Lock PlatformURIConverter
        synchronized (__lock) {
            loadURIMap();
        }
    }

    public void resourceChanged(IResourceChangeEvent event) {
        // Lock PlatformURIConverter
        synchronized (__lock) {
            ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
            try {
                event.getDelta().accept(visitor);
                if (visitor.isAffected()) {
                    loadURIMap();
                }
            } catch (CoreException ce) {
                EGFCorePlugin.getDefault().logError("PlatformURIConverter.resourceChanged(..) _", ce); //$NON-NLS-1$
                loadURIMap();
            }
        }
    }

    @Override
    public URI normalize(URI uri) {
        // Lock PlatformURIConverter
        synchronized (__lock) {
            return super.normalize(uri);
        }
    }

    @Override
    public OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException {
        return super.createOutputStream(uri, options);
    }

    @Override
    public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
        return super.createInputStream(uri, options);
    }

    @Override
    public void delete(URI uri, Map<?, ?> options) throws IOException {
        super.delete(uri, options);
    }

    @Override
    public Map<String, ?> contentDescription(URI uri, Map<?, ?> options) throws IOException {
        return super.contentDescription(uri, options);
    }

    @Override
    public boolean exists(URI uri, Map<?, ?> options) {
        return super.exists(uri, options);
    }

    @Override
    public Map<String, ?> getAttributes(URI uri, Map<?, ?> options) {
        return super.getAttributes(uri, options);
    }

    @Override
    public void setAttributes(URI uri, Map<String, ?> attributes, Map<?, ?> options) throws IOException {
        super.setAttributes(uri, attributes, options);
    }

    /**
     * Returns the internal version of the URI map.
     * This version do not delegate to the emf global registry
     * 
     * @return the internal version of the URI map.
     */
    @Override
    protected URIMap getInternalURIMap() {
        if (uriMap == null) {
            URIMappingRegistryImpl mappingRegistryImpl = new URIMappingRegistryImpl();
            uriMap = (URIMap) mappingRegistryImpl.map();
        }

        return uriMap;
    }

    /**
     * Dispose.
     */
    public void dispose() {
        // Lock PlatformURIConverter
        synchronized (__lock) {
            ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
            PDECore.getDefault().getModelManager().removePluginModelListener(this);
            getURIMap().clear();
        }
    }

    private void loadURIMap() {
        // Clear the previous URIMap content
        getURIMap().clear();
        // Assign a fresh URIMap content
        getURIMap().putAll(computePlatformResourceToPlatformPluginMap());
        getURIMap().putAll(computePlatformPluginToPlatformResourceMap());
    }

    // Looking for workspace projects
    public static Map<URI, URI> computePlatformPluginToPlatformResourceMap() {
        // Build maps
        Map<URI, URI> pluginToResource = new HashMap<URI, URI>();
        for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
            if (project == null) {
                continue;
            }
            String bundleId = BundleHelper.getBundleId(project);
            if (bundleId != null) {
                pluginToResource.put(URI.createPlatformPluginURI(bundleId + "/", false), URI.createPlatformResourceURI(bundleId + "/", false)); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
        return pluginToResource;
    }

    // Looking for target active models
    public static Map<URI, URI> computePlatformResourceToPlatformPluginMap() {
        // Build maps
        Map<URI, URI> resourceToPlugin = new HashMap<URI, URI>();
        for (IPluginModelBase base : PluginRegistry.getActiveModels(true)) {
            if (base == null) {
                continue;
            }
            String bundleId = BundleHelper.getBundleId(base);
            if (bundleId == null) {
                continue;
            }
            if (base.getUnderlyingResource() == null) {
                resourceToPlugin.put(URI.createPlatformResourceURI(bundleId + "/", false), URI.createPlatformPluginURI(bundleId + "/", false)); //$NON-NLS-1$ //$NON-NLS-2$          
            }
        }
        return resourceToPlugin;
    }

}
