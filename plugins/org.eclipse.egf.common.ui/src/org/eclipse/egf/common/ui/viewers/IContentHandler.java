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

/**
 * Viewer content handler.<br>
 * Allows to handle displayed elements life-cycle.
 * @author Guillaume Brocard
 */
public interface IContentHandler {
  /**
   * Create a new element.
   * @return
   */
  public Object createNewElement();

  /**
   * Remove given element from handled ones.
   * @param element_p
   */
  public void removeElement(Object element_p);
}
