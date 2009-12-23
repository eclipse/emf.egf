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

package org.eclipse.egf.core.platform.internal.pde;

import java.util.List;

import org.eclipse.emf.common.util.UniqueEList;

import org.eclipse.egf.core.platform.pde.IPlatformFactoryComponent;
import org.eclipse.egf.core.platform.pde.IPlatformFactoryComponentDelta;


public class PlatformFactoryComponentDelta implements IPlatformFactoryComponentDelta {

  private List<IPlatformFactoryComponent> _added = new UniqueEList<IPlatformFactoryComponent>();

  private List<IPlatformFactoryComponent> _removed = new UniqueEList<IPlatformFactoryComponent>(); 
  

  public PlatformFactoryComponentDelta() {
    // Nothing to do
  }

  public IPlatformFactoryComponent[] getAddedPlatformFactoryComponents() {
    return _added.toArray(new IPlatformFactoryComponent [_added.size()]);
  }

  public IPlatformFactoryComponent[] getRemovedPlatformFactoryComponents() {
    return _removed.toArray(new IPlatformFactoryComponent [_removed.size()]);
  }
    
  protected boolean isEmpty() {
    return _added.size() == 0 && _removed.size() == 0 ? true : false;
  }
    
  protected boolean storeAddedPlatformFactoryComponent(IPlatformFactoryComponent model) {
    if (model == null) {
      return false;
    }
    return _added.add(model);
  }
  
  protected boolean storeRemovedPlatformFactoryComponent(IPlatformFactoryComponent model) {
    if (model == null) {
      return false;
    }
    return _removed.add(model);
  }

}
