/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.platform.uri;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ArchiveURIHandlerImpl;
import org.eclipse.emf.ecore.resource.impl.EFSURIHandlerImpl;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.FileURIHandlerImpl;
import org.eclipse.emf.ecore.resource.impl.PlatformResourceURIHandlerImpl;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.IPluginModelListener;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.PluginModelDelta;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TargetPlatformURIConverter extends ExtensibleURIConverterImpl implements IPluginModelListener {

	/**
	 * The global default read only list of URI handlers.
	 */
	private static List<URIHandler> getDefaultHandlers() {
		return Collections.unmodifiableList(Arrays.asList(new URIHandler[] { new PlatformResourceURIHandlerImpl(), new FileURIHandlerImpl(), new EFSURIHandlerImpl(), new ArchiveURIHandlerImpl(), new TargetPlatformURIHandlerImpl() }));
	}

	// Use a lock object, this will prevent us against
	// a lock against the PlatformManager instance
	private Object __lock = new Object();

	public TargetPlatformURIConverter() {
		super(getDefaultHandlers(), ContentHandler.Registry.INSTANCE.contentHandlers());
		PDECore.getDefault().getModelManager().addPluginModelListener(this);
		getURIMap().putAll(initializeURIMap());
	}

	public void modelsChanged(PluginModelDelta event) {
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
	 * Returns the internal version of the URI map.
	 * This version do not delegate to the emf global registry
	 * 
	 * @return the internal version of the URI map.
	 */
	//	@Override
	//	protected URIMap getInternalURIMap() {
	//		if (uriMap == null) {
	//			URIMappingRegistryImpl mappingRegistryImpl = new URIMappingRegistryImpl();
	//			uriMap = (URIMap) mappingRegistryImpl.map();
	//		}
	//		return uriMap;
	//	}

	/**
	 * Dispose.
	 */
	public void dispose() {
		// Lock PlatformURIConverter
		synchronized (__lock) {
			PDECore.getDefault().getModelManager().removePluginModelListener(this);
			getURIMap().clear();
		}
	}

	private void loadURIMap() {
		getURIMap().clear();
		getURIMap().putAll(initializeURIMap());
	}

	private Map<URI, URI> initializeURIMap() {
		Map<URI, URI> urimap = new HashMap<URI, URI>();
		for (IPluginModelBase base : PluginRegistry.getActiveModels(true)) {
			if (base == null) {
				continue;
			}
			String bundleId = BundleHelper.getBundleId(base);
			if (bundleId == null) {
				continue;
			}
			if (base.getUnderlyingResource() == null) {
				urimap.put(URI.createPlatformResourceURI(bundleId + "/", false), URI.createPlatformPluginURI(bundleId + "/", false)); //$NON-NLS-1$ //$NON-NLS-2$    
				//				System.out.println(URI.createPlatformResourceURI(bundleId + "/", false) + " --> " + URI.createPlatformPluginURI(bundleId + "/", false));
			} else {
				urimap.put(URI.createPlatformPluginURI(bundleId + "/", false), URI.createPlatformResourceURI(bundleId + "/", false)); //$NON-NLS-1$ //$NON-NLS-2$
				//				System.out.println(URI.createPlatformPluginURI(bundleId + "/", false) + " --> " + URI.createPlatformResourceURI(bundleId + "/", false));
			}
		}
		return urimap;
	}

}
