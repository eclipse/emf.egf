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
package org.eclipse.egf.core.platform.pde;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.egf.common.helper.BundleHelper;
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
public class PlatformURIConverter extends ExtensibleURIConverterImpl implements IPluginModelListener {

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

  private PlatformURIConverter() {
    PDECore.getDefault().getModelManager().addPluginModelListener(this);
    loadURIMap();
  }

  public void modelsChanged(PluginModelDelta delta) {
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
    PDECore.getDefault().getModelManager().removePluginModelListener(this);
    getURIMap().clear();
  }

  private void loadURIMap() {
    // Clear the previous URIMap content
    getURIMap().clear();
    // Assign a fresh URIMap content
    getURIMap().putAll(computePlatformURIMap());
  }

  public static Map<URI, URI> computePlatformURIMap() {
    return computePlatformPluginToPlatformResourceMap();
  }

  /**
   * Computes a map from <code>platform:/plugin/&lt;plugin-id>/</code> {@link URI} to
   * <code>platform:/resource/&lt;plugin-location>/</code> URI
   * for each plugin project in the workspace. This allows each plugin from
   * the runtime to be {@link org.eclipse.emf.ecore.resource.URIConverter#getURIMap()
   * redirected} to its active version in the workspace.
   * and
   * Computes a map from <code>platform:/resource/&lt;plugin-location>/</code> {@link URI} to
   * <code>platform:/plugin/&lt;plugin-id>/</code> URI for each
   * URI in the collection of the form
   * <code>platform:/plugin/&lt;plugin-id>/...</code>. This allows each plugin
   * to be {@link org.eclipse.emf.ecore.resource.URIConverter#getURIMap()
   * treated} as if it were a project in the workspace. If the workspace
   * already contains a project for the plugin location, no mapping is
   * produced.
   * 
   * @return a map from plugin URIs to resource URIs.
   * @see org.eclipse.emf.ecore.resource.URIConverter#getURIMap()
   * @see URI
   */
  public static Map<URI, URI> computePlatformPluginToPlatformResourceMap() {
    // Build maps
    Map<URI, URI> pluginToResource = new HashMap<URI, URI>();
    Map<URI, URI> resourceToPlugin = new HashMap<URI, URI>();
    for (IPluginModelBase base : PluginRegistry.getActiveModels(true)) {
      if (base != null) {
        String bundleId = BundleHelper.getBundleId(base);
        if (bundleId != null) {
          if (base.getUnderlyingResource() != null) {
            pluginToResource.put(URI.createPlatformPluginURI(bundleId + "/", false), URI.createPlatformResourceURI(bundleId + "/", true)); //$NON-NLS-1$ //$NON-NLS-2$
          } else {
            resourceToPlugin.put(URI.createPlatformResourceURI(bundleId + "/", false), URI.createPlatformPluginURI(bundleId + "/", false)); //$NON-NLS-1$ //$NON-NLS-2$          
          }
        }
      }
    }
    // Assign Maps
    Map<URI, URI> result = new HashMap<URI, URI>(pluginToResource.size() + resourceToPlugin.size());
    result.putAll(pluginToResource);
    result.putAll(resourceToPlugin);
    return result;
  }

}
