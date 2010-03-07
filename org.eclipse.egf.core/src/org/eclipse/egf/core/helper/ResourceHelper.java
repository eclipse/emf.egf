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
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

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

  public static void reloadResources(Collection<Resource> resources) throws IOException {
    if (resources == null) {
      return;
    }
    // Track resourceSets as this been method could work with multiple resourceSets
    List<ResourceSet> resourceSets = new UniqueEList<ResourceSet>();
    // Unload resources
    for (Resource resource : resources) {
      resource.unload();
      if (resource.getResourceSet() != null) {
        resource.getResourceSet().getResources().remove(resource);
        resourceSets.add(resource.getResourceSet());
      }
    }
    // Update URI Converter
    for (ResourceSet resourceSet : resourceSets) {
      // Clear the previous URIConverter content
      resourceSet.getURIConverter().getURIMap().clear();
      // Assign a fresh platform aware URIConverter
      resourceSet.getURIConverter().getURIMap().putAll(EGFCorePlugin.computePlatformURIMap());
    }
    // Load Resource
    for (Resource resource : resources) {
      resource.load(Collections.EMPTY_MAP);
    }
  }

  public static boolean isRelated(Resource resource, URI uri) {
    Map<EObject, Collection<EStructuralFeature.Setting>> proxies = EcoreUtil.ProxyCrossReferencer.find(resource);
    for (EObject reference : proxies.keySet()) {
      if (reference instanceof InternalEObject == false) {
        continue;
      }
      InternalEObject internalEObject = (InternalEObject) reference;
      if (internalEObject.eProxyURI() == null) {
        continue;
      }
      if (internalEObject.eProxyURI().trimFragment().equals(uri)) {
        return true;
      }
    }
    return false;
  }
}
