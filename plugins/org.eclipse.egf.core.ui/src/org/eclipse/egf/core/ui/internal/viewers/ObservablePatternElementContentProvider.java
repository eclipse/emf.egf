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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.egf.common.ui.constant.IUiCommonConstants;
import org.eclipse.egf.common.ui.viewers.IOrderedContentProvider;
import org.eclipse.jface.viewers.AbstractTableViewer;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;


/**
 * Implements the content provider for the pattern library production orchestration wizard page.
 * @author Guillaume Brocard
 */
public class ObservablePatternElementContentProvider extends AbstractObservableContentProvider implements IOrderedContentProvider {
  /**
   * List of elements used as initial input.
   */
  private List<Object> _initialInput;
  /**
   * Reference to the viewer that uses this content provider.
   */
  private Viewer _viewer;

  /**
   * @see org.eclipse.egf.common.ui.toolkit.viewers.DefaultListContentProvider#handleViewer(org.eclipse.jface.viewers.Viewer)
   */
  @Override
  protected void handleViewer(Viewer viewer_p) {
    if (null == _viewer) {
      _viewer = viewer_p;
    }
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider#handleElementAdded(org.eclipse.jface.viewers.Viewer, java.lang.Object)
   */
  @SuppressWarnings("unchecked")
  @Override
  protected void handleElementAdded(Viewer viewer_p, Object addedElements_p) {
    // Check if given added element is a List ie the initial input.
    if (addedElements_p instanceof List) {
      // Keep a reference on this given initial input.
      _initialInput = (List<Object>) addedElements_p;
    } else {
      // Add given added elements in the initial input.
      _initialInput.add(addedElements_p);
      // Add elements in the viewer.
      AbstractTableViewer abstractListViewer = ((AbstractTableViewer) viewer_p);
      abstractListViewer.add(addedElements_p);
      updateOrchestration();
    }
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider#handleElementRemoved(org.eclipse.jface.viewers.Viewer,
   *      java.lang.Object)
   */
  @Override
  protected void handleElementRemoved(Viewer viewer_p, Object removedElement_p) {
    // Precondition : removedElements must not be the initial input.
    // This case only happens when closing the dialog.
    if (_initialInput == removedElement_p) {
      return;
    }
    // Remove given removed elements from the initial input.
    _initialInput.remove(removedElement_p);
    // Remove elements from the viewer.
    AbstractTableViewer viewer = ((AbstractTableViewer) viewer_p);
    viewer.remove(removedElement_p);
    // Notify removed elements.
    updateOrchestration();
  }

  /**
   * Update the orchestration according to initial input modifications.
   */
  private void updateOrchestration() {
    notifyElementUpdated(new ArrayList<Object>(_initialInput));
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider#handleElementUpdated(org.eclipse.jface.viewers.Viewer,
   *      java.lang.Object, java.lang.Object)
   */
  @Override
  protected void handleElementUpdated(Viewer viewer_p, Object oldInput_p, Object newInput_p) {
    ((StructuredViewer) viewer_p).refresh(oldInput_p);
    // Notify updated elements.
    notifyElementUpdated(Collections.singletonList(oldInput_p));
  }

  /**
   * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
   */
  public Object[] getElements(Object inputElement_p) {
    Object[] result = null;
    if (null != _initialInput) {
      result = _initialInput.toArray();
    } else {
      result = IUiCommonConstants.NO_ELEMENT;
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.common.ui.viewers.IOrderedContentProvider#swap(int, int)
   */
  public void swap(int elementPosition1_p, int elementPosition2_p) {
    Collections.swap(_initialInput, elementPosition1_p, elementPosition2_p);
    // Refresh the viewer.
    getViewer().refresh();
    updateOrchestration();
  }

  /**
   * Return the viewer that uses this content provider.
   * @return
   */
  protected Viewer getViewer() {
    return _viewer;
  }
}