/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *
 * </copyright>
 * 
 */
package org.eclipse.egf.model.uri;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;


public class ModelSchemeAware extends URIHandlerImpl {
  
  @Override
  public URI deresolve(URI uri) {
    if (uri.isPlatformResource()) {
      return URI.createPlatformPluginURI(uri.toPlatformString(true), true).appendFragment(uri.fragment());
    } else if (uri.isPlatformPlugin() == false) {   
      return 
          uri.isPlatform() == false || (uri.segmentCount() > 0 && baseURI.segmentCount() > 0 && uri.segment(0).equals(baseURI.segment(0))) 
        ? super.deresolve(uri) 
        : uri;    
    }
    return uri;
  }  
  
}
