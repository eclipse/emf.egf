/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.misc;

/**
 * Handle selected object to get their string representation.<br>
 * Implementors must provide a default constructor (i.e the one without argument).
 * @author Guillaume Brocard
 */
public interface ISelectionHandler {
  
  /**
   * Handle given selected object.
   * @param selectedObject_p
   * @return a string representation for given selected object.
   */
  public String handleSelection(Object selectedObject_p);
  
}
