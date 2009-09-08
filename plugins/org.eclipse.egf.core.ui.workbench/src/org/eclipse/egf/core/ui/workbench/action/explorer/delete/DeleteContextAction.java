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
package org.eclipse.egf.core.ui.workbench.action.explorer.delete;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.core.ui.workbench.Messages;
import org.eclipse.egf.model.Context;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;


/**
 * Implements an action to delete a context.
 * @author fournier
 */
public class DeleteContextAction extends DeleteModelElementAction {

  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public DeleteContextAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.explorer.delete.DeleteModelElementAction#getConfirmDeleteMessage()
   */
  @Override
  protected String[] getConfirmDeleteMessage() {
    String[] message = { Messages.DeleteContextAction_Message, ICommonConstants.EMPTY_STRING };
    return message;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return Context.class;
  }
}
