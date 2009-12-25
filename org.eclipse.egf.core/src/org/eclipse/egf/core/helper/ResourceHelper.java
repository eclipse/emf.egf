/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.helper;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.resources.IResource;
import org.eclipse.egf.common.uri.URIHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ResourceHelper {

  private ResourceHelper() {
    // Prevent instantiation
  }

  public static Resource createResource(ResourceSet resourceSet, IResource resource) {
    return createResource(resourceSet, URIHelper.getPlatformURI(resource));
  }

  public static Resource createResource(ResourceSet resourceSet, URI uri) {
    if (resourceSet == null || uri == null) {
      return null;
    }
    // Clear the previous URIConverter content
    resourceSet.getURIConverter().getURIMap().clear();
    // Assign a fresh platform aware URIConverter
    resourceSet.getURIConverter().getURIMap().putAll(EGFCorePlugin.computePlatformURIMap());
    // Create
    return resourceSet.createResource(uri);
  }

  public static Resource loadResource(ResourceSet resourceSet, IResource resource) {
    return loadResource(resourceSet, URIHelper.getPlatformURI(resource));
  }

  public static Resource loadResource(ResourceSet resourceSet, URI uri) {
    if (resourceSet == null || uri == null) {
      return null;
    }
    // Clear the previous URIConverter content
    resourceSet.getURIConverter().getURIMap().clear();
    // Assign a fresh platform aware URIConverter
    resourceSet.getURIConverter().getURIMap().putAll(EGFCorePlugin.computePlatformURIMap());
    // Load or create
    return resourceSet.getResource(uri, true);
  }

  public static void loadResource(Resource resource) throws IOException {
    if (resource == null) {
      return;
    }
    if (resource.getResourceSet() != null) {
      // Clear the previous URIConverter content
      resource.getResourceSet().getURIConverter().getURIMap().clear();
      // Assign a fresh platform aware URIConverter
      resource.getResourceSet().getURIConverter().getURIMap().putAll(EGFCorePlugin.computePlatformURIMap());
    }
    // Load
    resource.load(Collections.EMPTY_MAP);
  }

  public static void reloadResources(ResourceSet resourceSet, Collection<Resource> resources) {
    if (resourceSet == null || resources == null || resources.size() == 0) {
      return;
    }
    Collection<URI> uris = new UniqueEList<URI>(resources.size());
    // Unload resources and store URIs
    for (Resource resource : resources) {
      URI uri = resource.getURI();
      uris.add(uri);
      resource.unload();
      resourceSet.getResources().remove(resource);
    }
    // Clear the previous URIConverter content
    resourceSet.getURIConverter().getURIMap().clear();
    // Assign a fresh platform aware URIConverter
    resourceSet.getURIConverter().getURIMap().putAll(EGFCorePlugin.computePlatformURIMap());
    // Load Resource
    for (URI uri : uris) {
      resourceSet.getResource(uri, true);
    }
  }

}
