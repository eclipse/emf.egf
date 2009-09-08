/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *
 * </copyright>
 * 
 */
package org.eclipse.egf.core.ui.contract.type;

import org.eclipse.egf.common.misc.ISelectionHandler;
import org.eclipse.egf.core.ui.dialogs.GenModelSelectionDialog;
import org.eclipse.egf.core.ui.dialogs.GenModelSelectionHandler;
import org.eclipse.egf.model.contract.type.StringTypeHolder;


/**
 * @author Xavier Maysonnave
 */
public class GenModelTypeHolder extends StringTypeHolder {
  
  /* (non-Javadoc)
   * @see org.eclipse.egf.model.contract.type.AbstractTypeHolder#getSelectionDialog()
   */
  @Override
  public String getSelectionDialog() {
    return GenModelSelectionDialog.class.getName();
  }
  
  /**
   * @see org.eclipse.egf.model.contract.type.AbstractTypeHolder#getSelectionHandler()
   */
  @Override
  public ISelectionHandler getSelectionHandler() {
    return new GenModelSelectionHandler();
  }  

}
