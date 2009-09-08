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
package org.eclipse.egf.pattern.ui.internal.editor.page;

import org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;


/**
 * Abstract pattern page content provider.<br>
 * Stands for a structured content provider.<br>
 * Disable behaviors such as being called on object removal with initial input when closing the view, or possible calls to add/remove/update when the provider
 * is disposed (not observed yet).<br>
 * Also give access to initial input and viewer.<br>
 * getInitialInput() and getViewer() methods should be overridden by implementor so as to return correct type (@since java 1.5).
 * @author Guillaume Brocard
 */
public abstract class AbstractPatternPageContentProvider extends AbstractStructuredContentProvider {
  /**
   * Is provider disposed ?
   */
  private volatile boolean _isDisposed;
  /**
   * Initial input reminder.
   */
  private Object _initialInput;
  /**
   * Viewer reminder.
   */
  private Viewer _viewer;

  /**
   * @see org.eclipse.jface.viewers.IContentProvider#dispose()
   */
  public void dispose() {
    _isDisposed = true;
    doDispose();
  }

  /**
   * Get viewer.
   * @return
   */
  protected Viewer getViewer() {
    return _viewer;
  }

  /**
   * Get initial input.
   * @return
   */
  protected Object getInitialInput() {
    return _initialInput;
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
   */
  @Override
  public void inputChanged(Viewer viewer_p, Object oldInput_p, Object newInput_p) {
    // A new input has been set at the viewer level, reinitialize known one.
    if ((null != oldInput_p) && (null != newInput_p) && (newInput_p != oldInput_p)) {
      _initialInput = newInput_p;
    }
    super.inputChanged(viewer_p, oldInput_p, newInput_p);
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider#handleElementAdded(org.eclipse.jface.viewers.Viewer, java.lang.Object)
   */
  @Override
  protected void handleElementAdded(Viewer viewer_p, Object addedElements_p) {
    // Precondition.
    if (isDisposed()) {
      return;
    }
    // Set initial input.
    if (null == _initialInput) {
      _initialInput = addedElements_p;
    } else {
      doHandleElementsAdded(addedElements_p);
    }
  }

  /**
   * Do handle added elements.<br>
   * If there should be only one element of a given type in added elements, use {@link #getElement(Object, Class)} to get it.
   * @param addedElements_p
   */
  protected abstract void doHandleElementsAdded(Object addedElements_p);

  /**
   * @see org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider#handleElementRemoved(org.eclipse.jface.viewers.Viewer,
   *      java.lang.Object)
   */
  @Override
  protected void handleElementRemoved(Viewer viewer_p, Object removedElements_p) {
    // Preconditions.
    if (isDisposed() || (_initialInput == removedElements_p)) {
      return;
    }
    doHandleElementsRemoved(removedElements_p);
  }

  /**
   * Do handle removed elements.<br>
   * If there should be only one element of a given type in removed elements, use {@link #getElement(Object, Class)} to get it.
   * @param removedElements_p
   */
  protected abstract void doHandleElementsRemoved(Object removedElements_p);

  /**
   * @see org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider#handleElementUpdated(org.eclipse.jface.viewers.Viewer,
   *      java.lang.Object, java.lang.Object)
   */
  @Override
  protected void handleElementUpdated(Viewer viewer_p, Object oldInput_p, Object newInput_p) {
    // Precondition.
    if (isDisposed()) {
      return;
    }
    doHandleElementUpdated(oldInput_p, newInput_p);
  }

  /**
   * Do update element.<br>
   * If there should be only one element of a given type in updated elements, use {@link #getElement(Object, Class)} to get it.
   * @param oldInput_p
   * @param newInput_p
   */
  protected abstract void doHandleElementUpdated(Object oldInput_p, Object newInput_p);

  /**
   * @see org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider#handleViewer(org.eclipse.jface.viewers.Viewer)
   */
  @Override
  protected void handleViewer(Viewer viewer_p) {
    if (null == _viewer) {
      _viewer = viewer_p;
    }
  }

  /**
   * Get first element from elements_p that is of given type.
   * @param elements_p
   * @param elementType_p
   * @return
   */
  protected Object getElement(Object elements_p, Class<?> elementType_p) {
    Object result = null;
    // Precondition.
    if (null == elementType_p) {
      return result;
    }
    // Is element of correct type ?
    if (elementType_p.isInstance(elements_p)) {
      result = elements_p;
    } else if (elements_p instanceof Object[]) {
      // If not, and element is an array, then iterate over its elements.
      Object[] results = (Object[]) elements_p;
      // Stop at first correct encountered element.
      for (int i = 0; (i < results.length) && (null == result); i++) {
        result = getElement(results[i], elementType_p);
      }
    }
    return result;
  }

  /**
   * Is provider disposed ?
   * @return
   */
  protected boolean isDisposed() {
    return _isDisposed;
  }

  /**
   * Do dispose provider.
   */
  protected abstract void doDispose();
}
