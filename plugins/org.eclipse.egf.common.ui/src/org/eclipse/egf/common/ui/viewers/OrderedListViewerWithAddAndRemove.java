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

import java.util.List;

import org.eclipse.egf.common.ui.toolkit.widgets.handler.SelectionChangedHandler;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;


/**
 * Ordered list viewer, with add and remove button handles.
 * @author Guillaume Brocard
 */
public abstract class OrderedListViewerWithAddAndRemove extends OrderedListViewer {
  /**
   * Add button data. Attached to the add button at creation time.
   */
  private static final Object ADD_BUTTON_DATA = new Object();
  /**
   * Remove button data. Attached to the remove button at creation time.
   */
  private static final Object REMOVE_BUTTON_DATA = new Object();

  /**
   * Constructor.
   * @param parent_p
   */
  public OrderedListViewerWithAddAndRemove(Composite parent_p) {
    super(parent_p);
  }

  /**
   * @see org.eclipse.egf.common.ui.viewers.OrderedListViewer#createExtraButtonData()
   */
  @Override
  protected List<ButtonData> createExtraButtonData() {
    List<ButtonData> result = super.createExtraButtonData();
    result.add(new ButtonData(Messages.OrderedListViewerWithAddAndRemove_AddButton_Label, SWT.PUSH, ADD_BUTTON_DATA, createAddButtonHandler()));
    result.add(new ButtonData(Messages.OrderedListViewerWithAddAndRemove_RemoveButton_Label, SWT.PUSH, REMOVE_BUTTON_DATA, createRemoveButtonHandler()));
    return result;
  }

  /**
   * Create add button handler.<br>
   * This implementation returns <b>null</b>.
   * @return null
   */
  protected SelectionChangedHandler createAddButtonHandler() {
    // Default implementation returns null.
    return null;
  }

  /**
   * Create remove button handler.<br>
   * This implementation returns <b>null</b>.
   * @return null
   */
  protected SelectionChangedHandler createRemoveButtonHandler() {
    // Default implementation returns null.
    return null;
  }

  /**
   * Get content handler instance.<br>
   * Implementor is advised to return the same reference each time this method is called.
   * @return A not null instance of {@link IContentHandler}.
   */
  protected abstract IContentHandler getContentHandler();

  /**
   * @see org.eclipse.egf.common.ui.viewers.OrderedListViewer#delegateButtonClicked(org.eclipse.swt.widgets.Button, java.lang.Object)
   */
  @Override
  protected void delegateButtonClicked(Button clickedButton_p, Object data_p) {
    IContentProvider contentProvider = getDecoratedViewer().getContentProvider();
    IContentHandler contentHandler = getContentHandler();
    if (ADD_BUTTON_DATA.equals(data_p)) {
      Object objectToAdd = (null != contentHandler) ? contentHandler.createNewElement() : null;
      contentProvider.inputChanged(getDecoratedViewer(), null, objectToAdd);
    } else if (REMOVE_BUTTON_DATA.equals(data_p)) {
      ISelection selection = getDecoratedViewer().getSelection();
      Object objectToRemove = (selection instanceof IStructuredSelection) ? ((IStructuredSelection) selection).getFirstElement() : null;
      if (null != contentHandler) {
        contentHandler.removeElement(objectToRemove);
      }
      contentProvider.inputChanged(getDecoratedViewer(), objectToRemove, null);
    }
  }
}
