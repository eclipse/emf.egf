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

import java.util.ArrayList;

import org.eclipse.egf.common.ui.toolkit.widgets.handler.SelectionChangedHandler;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Table;


/**
 * A concrete viewer based on an SWT <code>List</code> control with 2 buttons on the right side to move up (or down) elements in the list.
 * @author Guillaume Brocard
 */
public class OrderedListViewer extends AbstractViewerWithButtons {
  /**
   * Constant that defines the 'Up' button data.
   */
  private static final Object UP_BUTTON_DATA = new Object();
  /**
   * Constant that defines the 'Down' button data.
   */
  private static final Object DOWN_BUTTON_DATA = new Object();
  /**
   * Button labels.
   */
  private static String[] __buttonsLabels = { Messages.SortedListViewer_UpButton_Title, Messages.SortedListViewer_DownButton_Title };
  /**
   * Button styles.
   */
  private static int[] __buttonsStyles = { SWT.PUSH, SWT.PUSH };
  /**
   * Default Viewer style bits constant: <code>SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER</code>.
   */
  private final static int DEFAULT_LIST_VIEWER_STYLE = SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER;

  /**
   * Selection changed handler used to control the up button.
   */
  private SelectionChangedHandler _selectionChangedHandlerForUpButton;
  /**
   * Selection changed handler used to control the down button.
   */
  private SelectionChangedHandler _selectionChangedHandlerForDownButton;

  /**
   * Constructor.
   * @param parent_p
   */
  public OrderedListViewer(Composite parent_p) {
    super(parent_p);
    // Set the button clicked listener.
    setButtonClickedListener(new IButtonClickedListener() {
      /**
       * @see org.eclipse.egf.common.ui.viewers.IButtonClickedListener#buttonClicked(org.eclipse.swt.widgets.Button, Object)
       */
      @SuppressWarnings("synthetic-access")
      public void buttonClicked(Button clickedButton_p, Object data_p) {
        // Get the selected element.
        StructuredViewer decoratedViewer = getDecoratedViewer();
        ISelection selection = decoratedViewer.getSelection();
        if (UP_BUTTON_DATA.equals(data_p) || DOWN_BUTTON_DATA.equals(data_p)) {
          // Precondition : selection must not be empty.
          if (selection.isEmpty()) {
            return;
          }
          // Get the position of the selected element.
          int selectionElementIndex = getSelectionIndex();
          // The 'element to swap with' position.
          int elementToSwapWithIndex = 0;
          // If button is either up or down one, go for a swap.
          if (UP_BUTTON_DATA.equals(data_p)) {
            elementToSwapWithIndex = selectionElementIndex - 1;
          } else if (DOWN_BUTTON_DATA.equals(data_p)) {
            elementToSwapWithIndex = selectionElementIndex + 1;
          }
          // Get the content provider.
          IContentProvider contentProvider = decoratedViewer.getContentProvider();
          if (contentProvider instanceof IOrderedContentProvider) {
            // Swap elements.
            ((IOrderedContentProvider) contentProvider).swap(selectionElementIndex, elementToSwapWithIndex);
          }
        } else {
          delegateButtonClicked(clickedButton_p, data_p);
        }
      }
    });
  }

  /**
   * Delegate button clicked event, if default listener implementation ain't enough.<br>
   * This implementation does nothing. Should be implemented by subclasses.
   * @param clickedButton_p
   * @param data_p
   */
  protected void delegateButtonClicked(Button clickedButton_p, Object data_p) {
    // Nothing to do.
  }

  /**
   * Initialize selection changed handlers to either enable or disable the up and down buttons.
   */
  private void initializeSelectionChangedHandlers() {
    _selectionChangedHandlerForUpButton = new SelectionChangedHandler() {
      /**
       * @see org.eclipse.egf.common.ui.toolkit.widgets.handler.SelectionChangedHandler#doHandleSelection(org.eclipse.jface.viewers.ISelection)
       */
      @Override
      protected boolean doHandleSelection(ISelection selection_p) {
        boolean result = false;
        // Get the selected index.
        int selectionIndex = getSelectionIndex();
        // Disable the up button when the first element is selected.
        result = (0 == selectionIndex) ? false : true;
        return result;
      }
    };
    _selectionChangedHandlerForDownButton = new SelectionChangedHandler() {
      /**
       * @see org.eclipse.egf.common.ui.toolkit.widgets.handler.SelectionChangedHandler#doHandleSelection(org.eclipse.jface.viewers.ISelection)
       */
      @Override
      protected boolean doHandleSelection(ISelection selection_p) {
        boolean result = false;
        // Get the selected index.
        int selectionIndex = getSelectionIndex();
        // Disable the down button when the last element is selected.
        result = (getElementCount() - 1 == selectionIndex) ? false : true;
        return result;
      }
    };
  }

  /**
   * Returns the zero-relative index of the element which is currently selected in the viewer.
   * @return
   */
  protected int getSelectionIndex() {
    int selectionIndex = -1;
    Control control = getUnderlyingViewerControl();
    if (control instanceof List) {
      List list = (List) control;
      selectionIndex = list.getSelectionIndex();
    } else if (control instanceof Table) {
      Table table = (Table) control;
      selectionIndex = table.getSelectionIndex();
    }
    return selectionIndex;
  }

  /**
   * Return the number of element contained in the viewer.
   * @return
   */
  protected int getElementCount() {
    int itemCount = -1;
    Control control = getUnderlyingViewerControl();
    if (control instanceof List) {
      List list = (List) control;
      itemCount = list.getItemCount();
    } else if (control instanceof Table) {
      Table table = (Table) control;
      itemCount = table.getItemCount();
    }
    return itemCount;
  }

  /**
   * Return the underlying control used by the current viewer. {@link #createViewer(Composite)}.
   * @return
   */
  protected Control getUnderlyingViewerControl() {
    return getDecoratedViewer().getControl();
  }

  /**
   * @see org.eclipse.egf.common.ui.viewers.AbstractViewerWithButtons#getButtonData()
   */
  @Override
  protected ButtonData[] createButtonData() {
    // Initialize selection handlers.
    initializeSelectionChangedHandlers();
    // Create extra button data.
    java.util.List<ButtonData> buttonData = createExtraButtonData();
    // Create the needed data used to create the UI buttons.
    buttonData.add(new ButtonData(__buttonsLabels[0], __buttonsStyles[0], UP_BUTTON_DATA, _selectionChangedHandlerForUpButton));
    buttonData.add(new ButtonData(__buttonsLabels[1], __buttonsStyles[1], DOWN_BUTTON_DATA, _selectionChangedHandlerForDownButton));
    return buttonData.toArray(new ButtonData[buttonData.size()]);
  }

  /**
   * Create extra button data, if needed, before up and down are added.<br>
   * Subclasses <b>must</b> call super when overriding this method.<br>
   * Default implementation provides with an empty, but not null, list of {@link ButtonData}.
   * @return
   */
  protected java.util.List<ButtonData> createExtraButtonData() {
    return new ArrayList<ButtonData>(0);
  }

  /**
   * Default viewer is {@link TableViewer} with one column (to support labels and icons).
   * @see org.eclipse.egf.common.ui.viewers.AbstractViewerWithButtons#createViewer(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected StructuredViewer createViewer(Composite composite_p) {
    TableViewer listViewer = new TableViewer(composite_p, DEFAULT_LIST_VIEWER_STYLE);
    // Get its control.
    Control control = listViewer.getControl();
    // Create and set its layout data.
    GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    control.setLayoutData(gridData);
    return listViewer;
  }
}