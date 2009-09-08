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
import java.util.List;

import org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider;
import org.eclipse.egf.core.ui.internal.observable.IListViewerObserver;


/**
 * Base class to implement an observable content provider.<br>
 * An observable content provider notifies {@link IListViewerObserver} when elements are added, removed or updated.
 * @author Guillaume Brocard
 */
public abstract class AbstractObservableContentProvider extends AbstractStructuredContentProvider {
  /**
   * List of observers.
   */
  private List<IListViewerObserver> _listViewerObservers;

  protected AbstractObservableContentProvider() {
    _listViewerObservers = new ArrayList<IListViewerObserver>(0);
  }

  /**
   * Add given listener to the list of {@link IListViewerObserver} notified when viewer content changes.
   * @param listViewerObserver_p
   */
  public void addListViewerObserver(IListViewerObserver listViewerObserver_p) {
    _listViewerObservers.add(listViewerObserver_p);
  }

  /**
   * Remove given listener from the list of {@link IListViewerObserver} notified when viewer content changes.
   * @param listViewerObserver_p
   */
  public void removeListViewerObserver(IListViewerObserver listViewerObserver_p) {
    _listViewerObservers.remove(listViewerObserver_p);
  }

  /**
   * Notify list viewer observers that elements are added.
   * @param addedElements_p
   */
  protected void notifyElementAdded(List<Object> addedElements_p) {
    // Notify observers.
    for (IListViewerObserver observer : _listViewerObservers) {
      observer.elementAdded(addedElements_p);
    }
  }

  /**
   * Notify list viewer observers that elements are removed.
   * @param removedElements_p
   */
  protected void notifyElementRemoved(List<Object> removedElements_p) {
    // Notify observers.
    for (IListViewerObserver observer : _listViewerObservers) {
      observer.elementRemoved(removedElements_p);
    }
  }

  /**
   * Notify list viewer observers that elements are updated.
   * @param updatedElements_p
   */
  protected void notifyElementUpdated(List<Object> updatedElements_p) {
    // Notify observers.
    for (IListViewerObserver observer : _listViewerObservers) {
      observer.elementUpdated(updatedElements_p);
    }
  }

  /**
   * @see org.eclipse.jface.viewers.IContentProvider#dispose()
   */
  public void dispose() {
    // Cleaning the observers.
    _listViewerObservers.clear();
  }
}
