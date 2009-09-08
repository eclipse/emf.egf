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
package org.eclipse.egf.core.ui.data.explorer.adapter;

import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.data.explorer.FactoryComponentWorkingSet;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.model.IWorkbenchAdapter;


/**
 * @author Guillaume Brocard
 */
public class FactoryComponentWorkingSetAdapter implements IWorkbenchAdapter {
  /**
   * Get the adapter for the platform working adapter for specified working set.
   * @param workingSet_p
   * @return can be null.
   */
  private IWorkbenchAdapter getPlatformWorkingSetAdapter(IWorkingSet workingSet_p) {
    IWorkbenchAdapter platformWorkingSetAdapter = (IWorkbenchAdapter) Platform.getAdapterManager().getAdapter(workingSet_p, IWorkbenchAdapter.class);
    return platformWorkingSetAdapter;
  }

  /**
   * @see org.eclipse.ui.model.IWorkbenchAdapter#getChildren(java.lang.Object)
   */
  public Object[] getChildren(Object object_p) {
    FactoryComponentWorkingSet workingSet = (FactoryComponentWorkingSet) object_p;
    return workingSet.getFactoryComponents().toArray();
  }

  /**
   * @see org.eclipse.ui.model.IWorkbenchAdapter#getImageDescriptor(java.lang.Object)
   */
  public ImageDescriptor getImageDescriptor(Object object_p) {
    ImageDescriptor result = null;
    FactoryComponentWorkingSet workingSet = (FactoryComponentWorkingSet) object_p;
    // Get its related platform working set.
    IWorkingSet platformWorkingSet = workingSet.getWorkingSet();
    // Get its adapter.
    IWorkbenchAdapter platformWorkingSetAdapter = getPlatformWorkingSetAdapter(platformWorkingSet);
    if (null != platformWorkingSetAdapter) {
      result = platformWorkingSetAdapter.getImageDescriptor(platformWorkingSet);
    }
    return result;
  }

  /**
   * @see org.eclipse.ui.model.IWorkbenchAdapter#getLabel(java.lang.Object)
   */
  public String getLabel(Object object_p) {
    String result = ICommonConstants.EMPTY_STRING;
    FactoryComponentWorkingSet workingSet = (FactoryComponentWorkingSet) object_p;
    // Get its related platform working set.
    IWorkingSet platformWorkingSet = workingSet.getWorkingSet();
    // Get its adapter.
    IWorkbenchAdapter platformWorkingSetAdapter = getPlatformWorkingSetAdapter(platformWorkingSet);
    if (null != platformWorkingSetAdapter) {
      result = platformWorkingSetAdapter.getLabel(platformWorkingSet);
    }
    return result;
  }

  /**
   * @see org.eclipse.ui.model.IWorkbenchAdapter#getParent(java.lang.Object)
   */
  public Object getParent(Object object_p) {
    // The parent is always the FactoryComponentInWorkspace object.
    return EgfUiActivator.getDefault().getFactoryComponentInWorkspaceInput();
  }
}