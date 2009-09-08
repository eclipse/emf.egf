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
package org.eclipse.egf.core.ui.data.fc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.model.FactoryComponent;

/**
 * @author Guillaume Brocard
 */
public class FactoryComponentInPlatform implements IAdaptable {
  /**
   * All factory components located in the running Eclipse instance.
   */
  private List<FactoryComponent> _factoryComponents;

  /**
   * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
   */
  @SuppressWarnings("unchecked")
  public Object getAdapter(Class adapter_p) {
    return Platform.getAdapterManager().getAdapter(this, adapter_p);
  }

  /**
   * Get all existing factory components in the running Eclipse instance.
   * @return a shallow copy of the internal collection.
   */
  public Collection<FactoryComponent> getFactoryComponents() {
    if (null == _factoryComponents) {
      _factoryComponents = new ArrayList<FactoryComponent>(CoreActivator.getDefault().getFactoryComponentsInPlatform());
    }
    return new ArrayList<FactoryComponent>(_factoryComponents);
  }
}