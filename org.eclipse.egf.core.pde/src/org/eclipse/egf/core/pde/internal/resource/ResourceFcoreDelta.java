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
package org.eclipse.egf.core.pde.internal.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.core.fcore.IResourceFcoreDelta;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;

public class ResourceFcoreDelta implements IResourceFcoreDelta {

  private UniqueEList<URI> _added = new UniqueEList<URI>();

  private UniqueEList<URI> _updated = new UniqueEList<URI>();

  private UniqueEList<URI> _removed = new UniqueEList<URI>();

  private HashMap<URI, URI> _moved = new HashMap<URI, URI>();

  public ResourceFcoreDelta() {
    // Nothing to do
  }

  @SuppressWarnings("unchecked")
  public List<URI> getNewFcores() {
    return (List<URI>) _added.clone();
  }

  @SuppressWarnings("unchecked")
  public List<URI> getUpdatedFcores() {
    return (List<URI>) _updated.clone();
  }

  @SuppressWarnings("unchecked")
  public List<URI> getRemovedFcores() {
    return (List<URI>) _removed.clone();
  }

  @SuppressWarnings("unchecked")
  public Map<URI, URI> getMovedFcores() {
    return (Map<URI, URI>) _moved.clone();
  }

  protected boolean isEmpty() {
    return _added.size() == 0 && _updated.size() == 0 && _removed.size() == 0 && _moved.size() == 0 ? true : false;
  }

  protected boolean addNewFcore(URI uri) {
    if (uri == null) {
      return false;
    }
    return _added.add(uri);
  }

  protected boolean addUpdatedFcore(URI uri) {
    if (uri == null) {
      return false;
    }
    return _updated.add(uri);
  }

  protected boolean addRemovedFcore(URI uri) {
    if (uri == null) {
      return false;
    }
    return _removed.add(uri);
  }

  protected boolean addMovedFcore(URI uri, URI newURI) {
    if (uri == null || newURI == null) {
      return false;
    }
    _moved.put(uri, newURI);
    return true;
  }

}
