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
package org.eclipse.egf.core.ui.internal.viewers;

import java.util.Arrays;

import org.eclipse.egf.core.ui.internal.observable.IListViewerObserver;
import org.eclipse.jface.viewers.AbstractListViewer;
import org.eclipse.jface.viewers.Viewer;


/**
 * This implementation of <code>IStructuredContentProvider</code> handles the case where the viewer input is a changing array of elements.<br>
 * This implementation is able to notify {@link IListViewerObserver} implementors that the viewer content has changed.
 * @author fournier
 */
public class ObservableArrayContentProvider extends AbstractObservableContentProvider {
  /**
   * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
   */
  public Object[] getElements(Object inputElement_p) {
    Object[] result = null;
    if (inputElement_p instanceof Object[]) {
      result = (Object[]) inputElement_p;
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.viewers.AbstractStructuredContentProvider#handleElementUpdated(org.eclipse.jface.viewers.Viewer,
   *      java.lang.Object, java.lang.Object)
   */
  @Override
  protected void handleElementUpdated(Viewer viewer_p, Object oldInput_p, Object newInput_p) {
    // Update given elements in the viewer.
    if (newInput_p instanceof Object[]) {
      Object[] elements = (Object[]) newInput_p;
      for (Object element : elements) {
        ((AbstractListViewer) viewer_p).refresh(element);
      }
      // Notify observers.
      notifyElementUpdated(Arrays.asList(elements));
    }
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.viewers.AbstractStructuredContentProvider#handleElementAdded(org.eclipse.jface.viewers.Viewer,
   *      java.lang.Object)
   */
  @Override
  protected void handleElementAdded(Viewer viewer_p, Object addedElements_p) {
    // Add given elements to the viewer.
    if (addedElements_p instanceof Object[]) {
      Object[] elements = (Object[]) addedElements_p;
      for (Object element : elements) {
        ((AbstractListViewer) viewer_p).add(element);
      }
      // Notify observers.
      notifyElementAdded(Arrays.asList(elements));
    }
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.viewers.AbstractStructuredContentProvider#handleElementRemoved(org.eclipse.jface.viewers.Viewer,
   *      java.lang.Object)
   */
  @Override
  protected void handleElementRemoved(Viewer viewer_p, Object removeElements_p) {
    // Remove given elements from the viewer.
    if (removeElements_p instanceof Object[]) {
      Object[] elements = (Object[]) removeElements_p;
      for (Object element : elements) {
        ((AbstractListViewer) viewer_p).remove(element);
      }
      // Notify observers.
      notifyElementRemoved(Arrays.asList(elements));
    }
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.viewers.AbstractStructuredContentProvider#handleViewer(org.eclipse.jface.viewers.Viewer)
   */
  @Override
  protected void handleViewer(Viewer viewer_p) {
    if (!(viewer_p instanceof AbstractListViewer)) {
      throw new IllegalArgumentException("Viewer must be an instanceof AbstractListViewer"); //$NON-NLS-1$
    }
  }
}
