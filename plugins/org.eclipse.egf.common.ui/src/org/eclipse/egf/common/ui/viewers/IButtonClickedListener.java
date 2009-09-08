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

import org.eclipse.swt.widgets.Button;

/**
 * Classes which implement this interface provide methods<br>
 * that deal with the event that is generated when a button, located in AbstractViewerWithButtons viewer, is clicked.
 * @see AbstractViewerWithButtons
 * @author Guillaume Brocard
 */
public interface IButtonClickedListener {
  /**
   * Sent when a button in {@link AbstractViewerWithButtons} is clicked.
   * @param clickedButton_p the clicked button.
   * @param data_p the button's user data.
   */
  public void buttonClicked(Button clickedButton_p, Object data_p);
}