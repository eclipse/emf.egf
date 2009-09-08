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
package org.eclipse.egf.model.contract.type;

import org.eclipse.egf.common.misc.ISelectionHandler;

/**
 * Based class to implement type holders.
 * @author Guillaume Brocard
 */
public abstract class AbstractTypeHolder implements ITypeHolder {
  
  /**
   * Default implementation returns null.
   * @see org.eclipse.egf.model.contract.type.ITypeHolder#getSelectionDialog()
   */
  public String getSelectionDialog() {
    // Do nothing.
    return null;
  }

  /**
   * Default implementation returns null.
   * @see org.eclipse.egf.model.contract.type.ITypeHolder#getSelectionHandler()
   */
  public ISelectionHandler getSelectionHandler() {
    // Do nothing.
    return null;
  }
  
}
