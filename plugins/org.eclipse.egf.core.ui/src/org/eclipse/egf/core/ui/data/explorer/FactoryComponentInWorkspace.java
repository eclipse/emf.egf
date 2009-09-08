/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.ui.data.explorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.pde.EgfPdeActivator;

/**
 * @author fournier
 */
public class FactoryComponentInWorkspace implements IAdaptable {
  /**
   * Factory components located in the current workspace.
   */
  private Set<FactoryComponent> _factoryComponents;

  /**
   * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
   */
  @SuppressWarnings("unchecked")
  public Object getAdapter(Class adapter_p) {
    return Platform.getAdapterManager().getAdapter(this, adapter_p);
  }

  /**
   * Get all existing factory components in the workspace.
   * @return a shallow copy of the internal collection.
   */
  public Collection<FactoryComponent> getFactoryComponents() {
    if (null == _factoryComponents) {
      _factoryComponents = new HashSet<FactoryComponent>(EgfPdeActivator.getDefault().getFactoryComponentsInWorkspace());
    }
    return new ArrayList<FactoryComponent>(_factoryComponents);
  }

  /**
   * Add given factory component to this factory components container.
   * @param factoryComponent_p
   * @return <code>true</code>if given factory component was not already contained.
   */
  public boolean addFactoryComponent(FactoryComponent factoryComponent_p) {
    if (null == _factoryComponents) {
      _factoryComponents = new HashSet<FactoryComponent>(1);
    }
    return _factoryComponents.add(factoryComponent_p);
  }

  /**
   * Remove given factory component from this factory components container.
   * @param factoryComponent_p
   */
  public void removeFactoryComponent(FactoryComponent factoryComponent_p) {
    // Remove it from internal factory components in workspace set.
    if (null != _factoryComponents) {
      _factoryComponents.remove(factoryComponent_p);
    }
    // The factory component registry has its own listener, so let it do its job !!!
  }
}
