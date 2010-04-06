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
package org.eclipse.egf.core.helper;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.EFSURIHandlerImpl;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ReadOnlyURIConverter extends ExtensibleURIConverterImpl {

  @Override
  @SuppressWarnings("unchecked")
  public Map<String, ?> getAttributes(URI uri, Map<?, ?> options) {
    URI normalizedURI = normalize(uri);
    URIHandler uriHandler = getURIHandler(normalizedURI);
    if (uriHandler instanceof EFSURIHandlerImpl) {
      Map<String, Object> attributes = (Map<String, Object>) super.getAttributes(uri, options);
      if (attributes.get(URIConverter.ATTRIBUTE_READ_ONLY) != null) {
        attributes.put(URIConverter.ATTRIBUTE_READ_ONLY, Boolean.TRUE);
      }
    }
    return super.getAttributes(uri, options);
  }

}
