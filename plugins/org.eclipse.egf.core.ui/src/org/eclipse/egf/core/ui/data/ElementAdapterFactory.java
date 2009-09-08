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
package org.eclipse.egf.core.ui.data;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.egf.common.adapter.AbstractAdapterFactory;
import org.eclipse.egf.common.adapter.AdapterDescriptor;
import org.eclipse.egf.core.ui.data.explorer.FactoryComponentInWorkspace;
import org.eclipse.egf.core.ui.data.explorer.FactoryComponentWorkingSet;
import org.eclipse.egf.core.ui.data.explorer.FactoryComponentWorkingSetManager;
import org.eclipse.egf.core.ui.data.explorer.adapter.FactoryComponentInWorkspaceAdapter;
import org.eclipse.egf.core.ui.data.explorer.adapter.FactoryComponentWorkingSetAdapter;
import org.eclipse.egf.core.ui.data.explorer.adapter.FactoryComponentWorkingSetManagerAdapter;
import org.eclipse.egf.core.ui.data.fc.FactoryComponentInPlatform;
import org.eclipse.egf.core.ui.data.fc.adapter.FactoryComponentInPlatformAdapter;
import org.eclipse.ui.model.IWorkbenchAdapter;


/**
 * Adapter factory for non EMF objects.
 * @author fournier
 */
public class ElementAdapterFactory extends AbstractAdapterFactory {
  /**
   * Map of <ModelObject class, AdapterDescriptor>.
   */
  private static Map<Class<?>, AdapterDescriptor> __adapters = new HashMap<Class<?>, AdapterDescriptor>();

  static {
    __adapters.put(FactoryComponentInWorkspace.class, new AdapterDescriptor(FactoryComponentInWorkspaceAdapter.class));
    __adapters.put(FactoryComponentInPlatform.class, new AdapterDescriptor(FactoryComponentInPlatformAdapter.class));
    __adapters.put(FactoryComponentWorkingSetManager.class, new AdapterDescriptor(FactoryComponentWorkingSetManagerAdapter.class));
    __adapters.put(FactoryComponentWorkingSet.class, new AdapterDescriptor(FactoryComponentWorkingSetAdapter.class));
  }

  /**
   * @see org.eclipse.egf.common.adapter.AbstractAdapterFactory#getAdapters()
   */
  @Override
  protected Map<Class<?>, AdapterDescriptor> getAdapters() {
    return __adapters;
  }

  /**
   * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
   */
  @SuppressWarnings("unchecked")
  public Class[] getAdapterList() {
    return new Class[] { IWorkbenchAdapter.class };
  }

  /**
   * Get workbench adapter for given object.
   * @param object_p
   * @return IWorkbenchAdapter
   */
  public static IWorkbenchAdapter getWorkbenchAdapter(Object object_p) {
    return (IWorkbenchAdapter) getPlatformAdapter(object_p, IWorkbenchAdapter.class);
  }
}
