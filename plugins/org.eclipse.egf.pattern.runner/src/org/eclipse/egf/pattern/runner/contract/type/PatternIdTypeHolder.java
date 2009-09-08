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
package org.eclipse.egf.pattern.runner.contract.type;

import org.eclipse.egf.common.misc.ISelectionHandler;
import org.eclipse.egf.model.contract.type.StringTypeHolder;
import org.eclipse.egf.pattern.runner.ui.PatternSelectionDialog;
import org.eclipse.egf.pattern.runner.ui.PatternSelectionHandler;


/**
 * Provides an implementation to have a string type holder that is able to select its value from a dialog.
 * @author Guillaume Brocard
 */
public class PatternIdTypeHolder extends StringTypeHolder {
  
  /**
   * @see org.eclipse.egf.model.contract.type.AbstractTypeHolder#getSelectionDialog()
   */
  @Override
  public String getSelectionDialog() {
    return PatternSelectionDialog.class.getName();
  }

  /**
   * @see org.eclipse.egf.model.contract.type.AbstractTypeHolder#getSelectionHandler()
   */
  @Override
  public ISelectionHandler getSelectionHandler() {
    return new PatternSelectionHandler();
  }
  
}
