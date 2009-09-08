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
package org.eclipse.egf.common.ui.viewers;

import org.eclipse.jface.viewers.IStructuredContentProvider;

/**
 * Classes which implement this interface provide a method<br>
 * that allows to swap content elements to be stored in a specific order.
 * @author Guillaume Brocard
 */
public interface IOrderedContentProvider extends IStructuredContentProvider {
  /**
   * Swap elements according to given element positions.<br>
   * Element at <code>elementPosition1_p</code> is moved to <code>elementPosition2_p</code> and <br>
   * Element at <code>elementPosition2_p</code> is moved to <code>elementPosition1_p</code>.
   * @param elementPosition1_p
   * @param elementPosition2_p
   */
  public void swap(int elementPosition1_p, int elementPosition2_p);
}
