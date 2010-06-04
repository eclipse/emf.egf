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
 * 
 */
package org.eclipse.egf.core.platform.uri;

import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;

public class PlatformURIHandler extends URIHandlerImpl {

  private URI _basePluginURI;

  @Override
  public URI resolve(URI uri) {
    // Always normalize uri to a non encoded platform:/plugin when applicable
    if (uri.isPlatformPlugin() || uri.isPlatformResource()) {
      // Platform
      if (uri.isPlatformPlugin()) {
        String pathName = URI.decode(uri.toString().substring(URIHelper.PLATFORM_PLUGIN_URI.toString().length(), uri.toString().length()));
        URI decodedURI = URI.createPlatformPluginURI(pathName, false);
        return decodedURI;
      }
      // Resource
      String pathName = URI.decode(uri.toString().substring(URIHelper.PLATFORM_RESOURCE_URI.toString().length(), uri.toString().length()));
      URI decodedURI = URI.createPlatformPluginURI(pathName, false);
      return decodedURI;
    }
    // Default behavior
    return resolve && uri.isRelative() && uri.hasRelativePath() ? uri.resolve(baseURI) : uri;
  }

  @Override
  public URI deresolve(URI uri) {
    // The resolver always transform a platform:/resource to a platform:/plugin scheme
    // so we don't need to process platform:/resource when deresolved
    if (uri.isPlatformPlugin()) {
      // Platform
      URI deresolve = uri.deresolve(_basePluginURI);
      if (deresolve.isCurrentDocumentReference()) {
        return deresolve;
      }
      String fragment = uri.fragment();
      // pathName is not encoded at this stage, the resolver always decode
      String pathName = uri.trimFragment().toString().substring(URIHelper.PLATFORM_PLUGIN_URI.toString().length(), uri.trimFragment().toString().length());
      URI encodedURI = URI.createPlatformPluginURI(pathName, true);
      if (fragment != null) {
        encodedURI = encodedURI.appendFragment(fragment);
      }
      return encodedURI;
    }
    return uri.isPlatform() == false || (uri.segmentCount() > 0 && baseURI.segmentCount() > 0 && uri.segment(0).equals(baseURI.segment(0))) ? super.deresolve(uri) : uri;
  }

  @Override
  public void setBaseURI(URI uri) {
    super.setBaseURI(uri);
    _basePluginURI = URI.createPlatformPluginURI(baseURI.toPlatformString(true), false);
  }

}
