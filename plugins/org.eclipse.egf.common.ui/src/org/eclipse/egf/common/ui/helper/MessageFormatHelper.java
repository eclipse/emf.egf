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

import org.eclipse.egf.common.helper.StringHelper;

/**
 * Provides services to format messages rendered in UI.<br>
 * 
 * @author fournier
 */
public class MessageFormatHelper {
  /**
   * Format given message with given arguments
   * 
   * @param notFormatedMessage_p
   * @param arguments_p
   * @return a formatted message
   * @since 1.2.0_M2 : use 
   */
  public static String formatMessage(String notFormatedMessage_p, Object[] arguments_p) {
    return StringHelper.formatMessage(notFormatedMessage_p, arguments_p);
  }
}
