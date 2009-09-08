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

import org.eclipse.egf.common.ui.toolkit.widgets.handler.SelectionChangedHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;


/**
 * A viewer skeleton with add and remove buttons at the right side.
 * @author Guillaume Brocard
 */
public abstract class ViewerWithAddAndRemove extends AbstractViewerWithButtons {
  /**
   * Add button data.
   */
  public static final String ADD_BUTTON_DATA = "LV_ADD"; //$NON-NLS-1$
  /**
   * Remove button data.
   */
  public static final String REMOVE_BUTTON_DATA = "LV_REMOVE"; //$NON-NLS-1$

  /**
   * Default constructor.<br>
   * Need to call {@link #init(Composite)} explicitly.
   */
  protected ViewerWithAddAndRemove() {
    super();
  }

  /**
   * Constructor.
   * @param parent_p
   */
  protected ViewerWithAddAndRemove(Composite parent_p) {
    super(parent_p);
  }

  /**
   * @see org.eclipse.egf.common.ui.viewers.AbstractViewerWithButtons#createButtonData()
   */
  @Override
  protected ButtonData[] createButtonData() {
    // Add and remove button.
    return new ButtonData[] { new ButtonData(Messages.OrderedListViewerWithAddAndRemove_AddButton_Label, SWT.PUSH, ADD_BUTTON_DATA, createAddHandler()),
                             new ButtonData(Messages.OrderedListViewerWithAddAndRemove_RemoveButton_Label, SWT.PUSH, REMOVE_BUTTON_DATA, createRemoveHandler()) };
  }

  /**
   * Create add button handler.
   * @return Default implementation returns null, meaning button is always enabled.
   */
  protected SelectionChangedHandler createAddHandler() {
    return null;
  }

  /**
   * Create remove button handler.
   * @return Default implementation returns null, meaning button is always enabled.
   */
  protected SelectionChangedHandler createRemoveHandler() {
    return null;
  }
}
