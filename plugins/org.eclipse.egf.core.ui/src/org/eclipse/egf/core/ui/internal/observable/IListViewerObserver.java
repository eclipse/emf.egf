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
package org.eclipse.egf.core.ui.internal.observable;

import java.util.List;

import org.eclipse.jface.viewers.ListViewer;

/**
 * Implementor will be notified when elements are added or removed from a {@link ListViewer}.
 * @author fournier
 */
public interface IListViewerObserver {
  /**
   * Called when elements are added in a {@link ListViewer}.
   * @param elements_p
   *          the list of added elements.
   */
  public void elementAdded(List<Object> elements_p);

  /**
   * Called when elements are removed from a {@link ListViewer}.
   * @param elements_p
   *          the list of removed elements.
   */
  public void elementRemoved(List<Object> elements_p);

  /**
   * Called when elements are updated from a {@link ListViewer}.
   * @param elements_p
   *          the list of updated elements.
   */
  public void elementUpdated(List<Object> elements_p);

}
