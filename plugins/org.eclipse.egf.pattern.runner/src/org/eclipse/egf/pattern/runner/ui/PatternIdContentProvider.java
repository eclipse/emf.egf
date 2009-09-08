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
package org.eclipse.egf.pattern.runner.ui;

import java.util.List;

import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;


/**
 * Pattern id content provider.
 * @author Guillaume Brocard
 */
class PatternIdContentProvider extends AbstractStructuredContentProvider implements ITreeContentProvider {
  /**
   * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
   */
  public Object[] getElements(Object inputElement_p) {
    return getChildren(inputElement_p);
  }

  /**
   * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
   */
  public Object[] getChildren(Object parentElement_p) {
    IDescriptor descriptor = (IDescriptor) parentElement_p;
    return descriptor.getChildren().toArray();
  }

  /**
   * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
   */
  public Object getParent(Object element_p) {
    IDescriptor descriptor = (IDescriptor) element_p;
    return descriptor.getParent();
  }

  /**
   * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
   */
  public boolean hasChildren(Object element_p) {
    IDescriptor descriptor = (IDescriptor) element_p;
    List<IDescriptor> children = descriptor.getChildren();
    return ((null != children) && (0 < children.size()));
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider#handleElementAdded(org.eclipse.jface.viewers.Viewer,
   *      java.lang.Object)
   */
  @Override
  protected void handleElementAdded(Viewer viewer_p, Object addedElements_p) {
    // Nothing to do.
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider#handleElementRemoved(org.eclipse.jface.viewers.Viewer,
   *      java.lang.Object)
   */
  @Override
  protected void handleElementRemoved(Viewer viewer_p, Object removedElements_p) {
    // Nothing to do.
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider#handleElementUpdated(org.eclipse.jface.viewers.Viewer,
   *      java.lang.Object, java.lang.Object)
   */
  @Override
  protected void handleElementUpdated(Viewer viewer_p, Object oldInput_p, Object newInput_p) {
    // Nothing to do.
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider#handleViewer(org.eclipse.jface.viewers.Viewer)
   */
  @Override
  protected void handleViewer(Viewer viewer_p) {
    // Nothing to do.
  }

  /**
   * @see org.eclipse.jface.viewers.IContentProvider#dispose()
   */
  public void dispose() {
    // Nothing to do.
  }
}