/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.platform.resource;

import org.eclipse.core.resources.IResource;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.uri.URIHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
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

  public static Resource createResource(ResourceSet resourceSet, IResource resource) throws RuntimeException, WrappedException {
    return createResource(resourceSet, URIHelper.getPlatformURI(resource));
  }

  public static Resource createResource(ResourceSet resourceSet, URI uri) throws RuntimeException, WrappedException {
    if (resourceSet == null || uri == null) {
      return null;
    }
    // Clear the previous URIConverter content
    resourceSet.getURIConverter().getURIMap().clear();
    // Assign a fresh platform aware URIConverter
    resourceSet.getURIConverter().getURIMap().putAll(EGFPlatformPlugin.computePlatformURIMap());
    // Create
    return resourceSet.createResource(uri);
  }

  public static Resource loadResource(ResourceSet resourceSet, IResource resource) throws RuntimeException, WrappedException {
    return loadResource(resourceSet, URIHelper.getPlatformURI(resource));
  }

  public static Resource loadResource(ResourceSet resourceSet, URI uri) throws RuntimeException, WrappedException {
    if (resourceSet == null || uri == null) {
      return null;
    }
    // Clear the previous URIConverter content
    resourceSet.getURIConverter().getURIMap().clear();
    // Assign a fresh platform aware URIConverter
    resourceSet.getURIConverter().getURIMap().putAll(EGFPlatformPlugin.computePlatformURIMap());
    // Load or create
    return resourceSet.getResource(uri, true);
  }

}
