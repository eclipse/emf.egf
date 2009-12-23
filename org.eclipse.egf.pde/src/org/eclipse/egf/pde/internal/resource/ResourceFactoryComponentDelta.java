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

package org.eclipse.egf.pde.internal.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.core.platform.resource.IResourceFactoryComponentDelta;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;


public class ResourceFactoryComponentDelta implements IResourceFactoryComponentDelta {

  private List<URI> _added = new UniqueEList<URI>();

  private List<URI> _removed = new UniqueEList<URI>(); 
  
  private List<URI> _changed = new UniqueEList<URI>();
  
  private List<URI> _moved = new UniqueEList<URI>();
  
  private Map<URI, URI> _movedFrom = new HashMap<URI, URI>();  
  

  public ResourceFactoryComponentDelta() {
    // Nothing to do
  }

  public URI[] getAddedResourceFactoryComponents() {
    return _added.toArray(new URI [_added.size()]);
  }

  public URI[] getRemovedResourceFactoryComponents() {
    return _removed.toArray(new URI [_removed.size()]);
  }
  
  public URI[] getChangedResourceFactoryComponents() {
    return _changed.toArray(new URI [_changed.size()]);
  } 
  
  public URI[] getMovedResourceFactoryComponents() {
    return _moved.toArray(new URI [_moved.size()]);
  }
  
  public URI getMovedFromResourceFactoryComponent(URI resource) {
    return _movedFrom.get(resource);
  }    
    
  protected boolean isEmpty() {
    return _added.size() == 0 && _removed.size() == 0  && _changed.size() == 0 && _moved.size() == 0 ? true : false;
  }
    
  protected boolean storeAddedResourceFactoryComponent(URI resource) {
    if (resource == null) {
      return false;
    }
    return _added.add(resource);
  }
  
  protected boolean storeRemovedResourceFactoryComponent(URI resource) {
    if (resource == null) {
      return false;
    }
    return _removed.add(resource);
  }
  
  protected boolean storeChangedResourceFactoryComponent(URI resource) {
    if (resource == null) {
      return false;
    }
    return _changed.add(resource);
  }
  
  protected boolean storeMovedResourceFactoryComponent(URI resource, URI from) {
    if (resource == null || from == null) {
      return false;
    }
    _movedFrom.put(resource, from);
    return _moved.add(resource);
  }    

}
