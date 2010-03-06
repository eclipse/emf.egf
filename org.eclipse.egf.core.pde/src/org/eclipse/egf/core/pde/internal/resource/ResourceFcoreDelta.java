/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.core.pde.internal.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.core.fcore.IResourceFcoreDelta;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;

public class ResourceFcoreDelta implements IResourceFcoreDelta {

  private List<URI> _updated = new UniqueEList<URI>();

  private List<URI> _moved = new UniqueEList<URI>();

  private Map<URI, URI> _movedFrom = new HashMap<URI, URI>();

  public ResourceFcoreDelta() {
    // Nothing to do
  }

  public URI[] getUpdatedResourceFcores() {
    return _updated.toArray(new URI[_updated.size()]);
  }

  public URI[] getMovedResourceFcores() {
    return _moved.toArray(new URI[_moved.size()]);
  }

  public URI getMovedFromResourceFcore(URI resource) {
    return _movedFrom.get(resource);
  }

  protected boolean isEmpty() {
    return _updated.size() == 0 && _moved.size() == 0 ? true : false;
  }

  protected boolean storeUpdatedResourceFcore(URI uri) {
    if (uri == null) {
      return false;
    }
    return _updated.add(uri);
  }

  protected boolean storeMovedResourceFcore(URI uri, URI from) {
    if (uri == null || from == null) {
      return false;
    }
    _movedFrom.put(uri, from);
    return _moved.add(uri);
  }

}
