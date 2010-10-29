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
package org.eclipse.egf.core.platform.uri;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointDelta;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;

/**
 * @author Xavier Maysonnave
 * 
 */
public class RuntimePlatformURIConverter extends ExtensibleURIConverterImpl implements IPlatformExtensionPointListener {

    // Use a lock object, this will prevent us against
    // a lock against the PlatformManager instance
    private Object __lock = new Object();

    public RuntimePlatformURIConverter() {
        super();
        EGFPlatformPlugin.getRuntimePlatformManager().addPlatformExtensionPointListener(this);
        getURIMap().putAll(initializeURIMap());
    }

    public void platformExtensionPointChanged(IPlatformExtensionPointDelta delta) {
        // Lock PlatformURIConverter
        synchronized (__lock) {
            loadURIMap();
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
        // Lock PlatformURIConverter
        synchronized (__lock) {
            return super.createOutputStream(uri, options);
        }
    }

    @Override
    public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
        // Lock PlatformURIConverter
        synchronized (__lock) {
            return super.createInputStream(uri, options);
        }
    }

    @Override
    public void delete(URI uri, Map<?, ?> options) throws IOException {
        // Lock PlatformURIConverter
        synchronized (__lock) {
            super.delete(uri, options);
        }
    }

    @Override
    public Map<String, ?> contentDescription(URI uri, Map<?, ?> options) throws IOException {
        // Lock PlatformURIConverter
        synchronized (__lock) {
            return super.contentDescription(uri, options);
        }
    }

    @Override
    public boolean exists(URI uri, Map<?, ?> options) {
        // Lock PlatformURIConverter
        synchronized (__lock) {
            return super.exists(uri, options);
        }
    }

    @Override
    public Map<String, ?> getAttributes(URI uri, Map<?, ?> options) {
        // Lock PlatformURIConverter
        synchronized (__lock) {
            return super.getAttributes(uri, options);
        }
    }

    @Override
    public void setAttributes(URI uri, Map<String, ?> attributes, Map<?, ?> options) throws IOException {
        // Lock PlatformURIConverter
        synchronized (__lock) {
            super.setAttributes(uri, attributes, options);
        }
    }

    /**
     * Dispose.
     */
    public void dispose() {
        // Lock PlatformURIConverter
        synchronized (__lock) {
            EGFPlatformPlugin.getRuntimePlatformManager().removePlatformExtensionPointListener(this);
            getURIMap().clear();
        }
    }

    private void loadURIMap() {
        getURIMap().clear();
        getURIMap().putAll(initializeURIMap());
    }

    private Map<URI, URI> initializeURIMap() {
        Map<URI, URI> urimap = new HashMap<URI, URI>();
        for (IPlatformBundle bundle : EGFPlatformPlugin.getRuntimePlatformManager().getPlatformBundles()) {
            if (bundle == null) {
                continue;
            }
            String bundleId = bundle.getBundleId();
            if (bundleId == null) {
                continue;
            }
            urimap.put(URI.createPlatformResourceURI(bundleId + "/", false), URI.createPlatformPluginURI(bundleId + "/", false)); //$NON-NLS-1$ //$NON-NLS-2$          
        }
        return urimap;
    }

}
