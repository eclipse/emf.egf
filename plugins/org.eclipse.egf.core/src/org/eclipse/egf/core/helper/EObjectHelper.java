/**
 * Copyright (c) 2004, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 */
package org.eclipse.egf.core.helper;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EObjectHelper {

  private EObjectHelper() {
    // Prevent instantiation
  }

  public static EObject loadEObject(ResourceSet resourceSet, EObject eObject) {
    if (resourceSet == null || eObject == null) {
      return null;
    }
    return loadEObject(resourceSet, EcoreUtil.getURI(eObject));
  }

  public static EObject loadEObject(ResourceSet resourceSet, URI uri) {
    if (resourceSet == null || uri == null) {
      return null;
    }
    // Assign a platform aware URIConverter
    resourceSet.setURIConverter(EGFCorePlugin.getPlatformURIConverter());
    // Load
    return resourceSet.getEObject(uri, true);
  }

}
