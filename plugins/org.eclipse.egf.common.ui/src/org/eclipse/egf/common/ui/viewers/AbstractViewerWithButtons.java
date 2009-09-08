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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;


/**
 * Base class to implement a viewer with buttons located on the right side(e.g to change list elements order).
 * @author Guillaume Brocard
 */
public abstract class AbstractViewerWithButtons {
  /**
   * Buttons located on the right side of this viewer.
   */
  private Button[] _buttons;
  /**
   * Button data related to created buttons on the right side of this viewer.
   */
  protected ButtonData[] _buttonData;
  /**
   * Composite that hosts the viewer and the composite that contains the buttons.
   */
  private Composite _composite;
  /**
   * The decorated viewer.
   */
  protected StructuredViewer _decoratedViewer;
  /**
   * Listener called when a button is clicked.
   */
  private IButtonClickedListener _buttonClickedListener;
  /**
   * Selection listener used to update buttons according selection changes.
   */
  private ISelectionChangedListener _viewerSelectionChangedListener;

  /**
   * Default constructor.<br>
   * Need to call {@link #init(Composite)} explicitly in implementation.
   */
  protected AbstractViewerWithButtons() {
    // Does nothing.
  }

  /**
   * Constructor with no information on buttons.<br>
   * Calls {@link #getButtonData()} to resolve buttons information.
   * @param parent_p
   */
  protected AbstractViewerWithButtons(Composite parent_p) {
    init(parent_p);
  }

  /**
   * Initialize viewer content.
   * @param parent_p
   */
  protected void init(Composite parent_p) {
    // Create the internal composite.
    _composite = createInternalComposite(parent_p);
    // Create the decorated viewer.
    _decoratedViewer = createViewer(_composite);
    // Called when the selection changes in the viewer.
    _viewerSelectionChangedListener = new ISelectionChangedListener() {
      /**
       * @see ISelectionChangedListener#selectionChanged(SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        // Handle the selection itself.
        ISelection selection = event_p.getSelection();
        // Precondition: the selection must not be empty.
        if (selection.isEmpty()) {
          return;
        }
        updateButtons(selection);
      }
    };
    // Add the selection listener on the created viewer.
    _decoratedViewer.addSelectionChangedListener(_viewerSelectionChangedListener);
    // Get button data.
    createButtons(_composite, createButtonData());
  }

  /**
   * Is viewer editable ?
   * If not, buttons are disabled.
   * @return
   */
  protected boolean isEditable() {
    return true;
  }

  /**
   * Update the buttons enablement property.
   * @param selection_p
   */
  protected void updateButtons(ISelection selection_p) {
    // Loop over each one to handle the new selection.
    for (ButtonData buttonData : _buttonData) {
      SelectionChangedHandler selectionChangedHandler = buttonData.getSelectionChangedHandler();
      if (null != selectionChangedHandler) {
        selectionChangedHandler.handleSelection(selection_p);
      }
    }
  }

  /**
   * Create button data, that is an array of {@link ButtonData}, descriptors for buttons to create.
   * @return must not return <code>null</code> or an empty array.
   */
  protected abstract ButtonData[] createButtonData();

  /**
   * Create a viewer which is decorated with buttons on the right side.
   * @param composite_p
   */
  protected abstract StructuredViewer createViewer(Composite composite_p);

  /**
   * Create the composite that hosts all widgets and viewer.
   * @param parent_p
   */
  private Composite createInternalComposite(Composite parent_p) {
    Composite composite = new Composite(parent_p, SWT.NONE);
    // Install a layout manager, all widgets are displayed on 2 columns.
    composite.setLayout(new GridLayout(2, false));
    // Set its layout.
    GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    composite.setLayoutData(gridData);
    return composite;
  }

  /**
   * Create buttons if provided.
   * @param parent_p
   * @param buttonData_p
   */
  private void createButtons(Composite parent_p, ButtonData[] buttonData_p) {
    // Preconditions.
    if ((null == buttonData_p) || (buttonData_p.length == 0)) {
      return;
    }
    // Create a button container.
    Composite buttonContainer = new Composite(parent_p, SWT.NONE);
    // Set button composite activation.
    buttonContainer.setEnabled(isEditable());
    // create its layout.
    GridLayout layout = new GridLayout(1, false);
    layout.marginWidth = layout.marginHeight = 0;
    // Set the created layout.
    buttonContainer.setLayout(layout);
    // Create and set its layout data.
    GridData gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, true);
    buttonContainer.setLayoutData(gridData);
    // Create the buttons.
    _buttonData = buttonData_p;
    _buttons = new Button[buttonData_p.length];
    SelectionAdapter listener = new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetDefaultSelected(SelectionEvent e_p) {
        buttonSelected(e_p);
      }

      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        buttonSelected(e_p);
      }

      private void buttonSelected(SelectionEvent e) {
        AbstractViewerWithButtons.this.buttonSelected((Button) e.widget, e.widget.getData());
      }
    };
    // Loop over given label
    for (int i = 0; i < buttonData_p.length; i++) {
      ButtonData buttonData = buttonData_p[i];
      String label = buttonData.getLabel();
      int style = buttonData.getStyle();
      if (null != label) {
        Button button = createButton(buttonContainer, label, style);
        button.addSelectionListener(listener);
        // Set user data.
        button.setData(buttonData.getData());
        // Add the created button to the selection changed handler if any.
        SelectionChangedHandler handler = buttonData.getSelectionChangedHandler();
        if (null != handler) {
          handler.addControl(button);
        }
        _buttons[i] = button;
      } else {
        createEmptySpace(buttonContainer, 1);
      }
    }
  }

  /**
   * Called when a button is selected.
   * @param selectedButton_p
   * @param data_p user data
   */
  protected void buttonSelected(Button selectedButton_p, Object data_p) {
    // Notify the listener if any.
    if (null != _buttonClickedListener) {
      _buttonClickedListener.buttonClicked(selectedButton_p, data_p);
    }
    // Update buttons state.
    ISelection selection = _decoratedViewer.getSelection();
    updateButtons(selection);
  }

  /**
   * Create a button.
   * @param parent_p
   * @param label_p
   * @param style_p
   * @return a not null {@link Button}
   */
  protected Button createButton(Composite parent_p, String label_p, int style_p) {
    Button button = new Button(parent_p, SWT.PUSH | style_p); // at least, PUSH is set.
    button.setText(label_p);
    GridData gridData = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
    button.setLayoutData(gridData);
    return button;
  }

  /**
   * Create an empty space.
   * @param parent_p
   * @param span_p
   * @return
   */
  protected Label createEmptySpace(Composite parent_p, int span_p) {
    Label label = new Label(parent_p, SWT.NULL);
    GridData gridData = new GridData(SWT.FILL, SWT.BEGINNING, true, true);// new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
    gridData.horizontalSpan = span_p;
    gridData.widthHint = 0;
    gridData.heightHint = 0;
    label.setLayoutData(gridData);
    return label;
  }

  /**
   * Return the decorated viewer.
   * @return the decoratedViewer
   */
  public StructuredViewer getDecoratedViewer() {
    return _decoratedViewer;
  }

  /**
   * Set the listener that is called when a button is clicked.
   * @param buttonClickedListener_p.
   */
  public void setButtonClickedListener(IButtonClickedListener buttonClickedListener_p) {
    _buttonClickedListener = buttonClickedListener_p;
  }

  /**
   * Button data.<br>
   * Facade to a button creation for this viewer.<br>
   * Label and style are mandatory to create a new widget.<br>
   * The given user data is set to the created button widget, if not null.
   * @author Guillaume Brocard
   */
  public class ButtonData {
    /**
     * The button label.
     */
    private String _label;
    /**
     * The button style.
     */
    private int _style;
    /**
     * The user data, set as data for corresponding button.
     */
    private Object _data;
    /**
     * Handler called when the selection changes inside the viewer hosted by the {@link AbstractViewerWithButtons}.
     */
    private SelectionChangedHandler _selectionChangedHandler;

    /**
     * Button data constructor.
     * @param label_p The label of the future button.
     * @param style_p The style of the future button.
     * @param data_p The user data of the future button, can be null.
     * @param selectionChangedHandler_p The selection changed handler called when selection changes in the {@link AbstractViewerWithButtons}.
     */
    public ButtonData(String label_p, int style_p, Object data_p, SelectionChangedHandler selectionChangedHandler_p) {
      _label = label_p;
      _style = style_p;
      _data = data_p;
      _selectionChangedHandler = selectionChangedHandler_p;
    }

    /**
     * Get button label.
     * @return
     */
    protected String getLabel() {
      return _label;
    }

    /**
     * Get button style.
     * @return
     */
    protected int getStyle() {
      return _style;
    }

    /**
     * Get user data.
     * @return
     */
    protected Object getData() {
      return _data;
    }

    /**
     * Get the selection changed handler.
     * @return
     */
    protected SelectionChangedHandler getSelectionChangedHandler() {
      return _selectionChangedHandler;
    }
  }
}