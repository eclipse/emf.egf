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

import org.eclipse.egf.core.ui.data.explorer.FactoryComponentInWorkspace;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.model.IWorkbenchAdapter;

/**
 * @author fournier
 */
public class FactoryComponentInWorkspaceAdapter implements IWorkbenchAdapter {
  /**
   * @see org.eclipse.ui.model.IWorkbenchAdapter#getChildren(java.lang.Object)
   */
  public Object[] getChildren(Object object_p) {
    FactoryComponentInWorkspace fcInWorkspace = (FactoryComponentInWorkspace) object_p;
    return fcInWorkspace.getFactoryComponents().toArray();
  }

  /**
   * @see org.eclipse.ui.model.IWorkbenchAdapter#getImageDescriptor(java.lang.Object)
   */
  public ImageDescriptor getImageDescriptor(Object object_p) {
    // Do nothing.
    return null;
  }

  /**
   * @see org.eclipse.ui.model.IWorkbenchAdapter#getLabel(java.lang.Object)
   */
  public String getLabel(Object o_p) {
    // Just to suppress at runtime a message with "No Label Provider for..."
    return Messages.FactoryComponentInWorkspaceAdapter_Label_Title;
  }

  /**
   * @see org.eclipse.ui.model.IWorkbenchAdapter#getParent(java.lang.Object)
   */
  public Object getParent(Object o_p) {
    // Do nothing.
    return null;
  }
}
