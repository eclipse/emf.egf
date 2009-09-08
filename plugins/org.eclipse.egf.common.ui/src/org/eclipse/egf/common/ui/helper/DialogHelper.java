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
package org.eclipse.egf.common.ui.helper;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * Provides services to easily display dialogs to the end-user.
 * @author fournier
 */
public class DialogHelper {
  /**
   * Show a confirmation dialog to the end-user.
   * @return
   */
  public static boolean openDeleteConfirmationDialog(Shell parent_p, Object[] arguments_p) {
    return openDeleteConfirmationDialog(parent_p, Messages.DeleteElementActionConfirmDialog_Message, arguments_p);
  }

  /**
   * Show a delete confirmation dialog to the end-user using a customized message.
   * @param parent_p
   * @param messageToFormat_p
   * @param arguments_p
   * @return
   */
  public static boolean openDeleteConfirmationDialog(Shell parent_p, String messageToFormat_p, Object[] arguments_p) {
    String formatedMessage = MessageFormatHelper.formatMessage(messageToFormat_p, arguments_p);
    boolean confirmed = MessageDialog.openQuestion(parent_p, Messages.DeleteElementActionConfirmDialog_Title, formatedMessage);
    return confirmed;
  }
}
