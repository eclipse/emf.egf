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

  private List<URI> _changed = new UniqueEList<URI>();

  private List<URI> _moved = new UniqueEList<URI>();

  private Map<URI, URI> _movedFrom = new HashMap<URI, URI>();

  public ResourceFcoreDelta() {
    // Nothing to do
  }

  public URI[] getChangedResourceFcores() {
    return _changed.toArray(new URI[_changed.size()]);
  }

  public URI[] getMovedResourceFcores() {
    return _moved.toArray(new URI[_moved.size()]);
  }

  public URI getMovedFromResourceFcore(URI resource) {
    return _movedFrom.get(resource);
  }

  protected boolean isEmpty() {
    return _changed.size() == 0 && _moved.size() == 0 ? true : false;
  }

  protected boolean storeChangedResourceFcore(URI resource) {
    if (resource == null) {
      return false;
    }
    return _changed.add(resource);
  }

  protected boolean storeMovedResourceFcore(URI resource, URI from) {
    if (resource == null || from == null) {
      return false;
    }
    _movedFrom.put(resource, from);
    return _moved.add(resource);
  }

}
