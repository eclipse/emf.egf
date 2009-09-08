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
package org.eclipse.egf.common.ui.toolkit.viewers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.egf.common.ui.toolkit.internal.UI;
import org.eclipse.egf.common.ui.toolkit.widgets.handler.SelectionChangedHandler;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;


/**
 * Base class to implement a transfer viewer that allows the end-user to transfer objects between a left {@link StructuredViewer} and a right
 * {@link StructuredViewer}.<br>
 * This viewer provides the end-user with different buttons to add, add all, remove and remove all objects from a viewer to another one.<br>
 * Theses different buttons can be displayed or not, depending on style provided in the constructor. The enable state of theses buttons can be controlled by
 * {@link SelectionChangedHandler}.<br>
 * Under the viewers, a status text field is displayed to provide contextual information related to viewers' selection. This status field can be displayed or
 * not, depending on style provided in the constructor.<br>
 * <p>
 * Implementors must have to provide {@link IContentProvider} and {@link ILabelProvider}.
 * @author D. GATIBELZA
 */
public abstract class AbstractTransferViewer extends Viewer {
  // The logger.
  private static Logger _logger = Logger.getLogger(AbstractTransferViewer.class.getPackage().getName());

  /**
   * Style constant for displaying the status text field.
   */
  public static final int STATUS_TEXT_FIELD = 1 << 1;
  /**
   * Style constant for displaying the 'addAll' button.
   */
  public static final int ADD_ALL_BUTTON = 1 << 2;
  /**
   * Style constant for displaying the 'addSelected' button.
   */
  public static final int ADD_SELECTED_BUTTON = 1 << 3;
  /**
   * Style constant for displaying the 'removeSelected' button.
   */
  public static final int REMOVE_SELECTED_BUTTON = 1 << 4;
  /**
   * Style constant for displaying the 'removeAll' button.
   */
  public static final int REMOVE_ALL_BUTTON = 1 << 5;
  /**
   * Style constant for having only one selection available in both viewers.<br>
   * Hence, select an element in the left viewer can deselect previous selection is the right viewer.
   */
  public static final int SINGLE_SELECTION_VIEWER = 1 << 6;
  /**
   * Style constant for displaying all default buttons.
   */
  public static final int ALL_BUTTONS = ADD_ALL_BUTTON | ADD_SELECTED_BUTTON | REMOVE_SELECTED_BUTTON | REMOVE_ALL_BUTTON;
  /**
   * Style constant for displaying all default widgets.
   */
  public static final int ALL_WIDGETS = STATUS_TEXT_FIELD | ALL_BUTTONS;

  // Style field.
  private int _style;
  // Composite that host every widgets and viewers.
  private Composite _composite;
  // The bottom status control.
  private Text _statusBar;
  // Buttons.
  private Composite _buttonsPanel;
  private Button _addAllBtn;
  private Button _addSelectedBtn;
  private Button _removeSelectedBtn;
  private Button _removeAllBtn;
  // Left structured viewer.
  protected StructuredViewer _leftViewer;
  private int _leftViewerStyleBits;
  // Right structured viewer.
  protected StructuredViewer _rightViewer;
  private int _rightViewerStyleBits;
  // Listener registered on each button. It performs the action due to the end-user click.
  private SelectionListener _buttonClickedListener;
  // The listener is registered on both viewers and listens to selection changes.
  private ISelectionChangedListener _viewerSelectionChangedListener;
  // List of selection handler used to manage buttons states, those handlers are applied independently for a new selection event coming from both viewers.
  private List<SelectionChangedHandler> _selectionChangedHandlersForBothViewers;
  // List of selection handler used to manage buttons states, those handlers are applied for a new selection event coming from the left viewer.
  private List<SelectionChangedHandler> _selectionChangedHandlersForLeftViewer;
  // List of selection handler used to manage buttons states, those handlers are applied for a new selection event coming from the right viewer.
  private List<SelectionChangedHandler> _selectionChangedHandlersForRightViewer;

  /**
   * Constructs the abstract implementation of the transfer viewers.
   * @param parent_p The parent composite.
   * @param style_p The style constant is used to determine which widgets are displayed.<br>
   *          {@link #ADD_ALL_BUTTON}, {@link #ADD_SELECTED_BUTTON}, {@link #REMOVE_SELECTED_BUTTON}, {@link #REMOVE_ALL_BUTTON}, {@link #ALL_WIDGETS},
   *          {@link #ALL_BUTTONS}.<br>
   *          If {@link SWT#NONE} is used, style is automatically set to {@link #ALL_WIDGETS}.
   * @param leftViewerStyleBits_p style bits constant used for the left viewer.
   * @param rightViewerStyleBits_p style bits constant used for the right viewer.
   */
  protected AbstractTransferViewer(Composite parent_p, int style_p, int leftViewerStyleBits_p, int rightViewerStyleBits_p) {
    // Store the style of this viewer.
    if (SWT.NONE == style_p) {
      _style = ALL_WIDGETS;
    } else {
      _style = style_p;
    }
    // Initialize the selection changed handlers.
    _selectionChangedHandlersForBothViewers = new ArrayList<SelectionChangedHandler>(0);
    _selectionChangedHandlersForLeftViewer = new ArrayList<SelectionChangedHandler>(0);
    _selectionChangedHandlersForRightViewer = new ArrayList<SelectionChangedHandler>(0);
    // Store the left viewer style.
    _leftViewerStyleBits = leftViewerStyleBits_p;
    // Store the right viewer style.
    _rightViewerStyleBits = rightViewerStyleBits_p;
    // Finally, create the viewer.
    createViewer(parent_p);
  }

  // Create the contained viewers.
  private void createViewer(Composite parent_p) {
    createInternalComposite(parent_p);
    // Initialization of the common listeners.
    initializeListeners();
    // Create the left viewer.
    createLeftViewer(_composite);
    // The middle buttons area.
    createButtonArea(_composite);
    // Create the right viewer.
    createRightViewer(_composite);
    // Create the status text field.
    createStatusTextField(_composite);
  }

  // Create the composite that hosts all widgets and viewers.
  private void createInternalComposite(Composite parent_p) {
    _composite = new Composite(parent_p, SWT.NONE);
    // Install a layout manager, all widgets are displayed on 3 columns.
    _composite.setLayout(new GridLayout(3, false));
    // Set its layout.
    GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    _composite.setLayoutData(gridData);
  }

  // Create the left viewer.
  private void createLeftViewer(Composite parent_p) {
    // If the left viewer is not already set, delegate its creation.
    if (null == _leftViewer) {
      // Create the left viewer from delegated method.
      _leftViewer = doLeftViewer(parent_p);
    }
    // Layout it.
    layoutViewer(_leftViewer, Messages.getString("AbstractTransferViewer.list.available.tooltip")); //$NON-NLS-1$
  }

  // Create the right viewer.
  private void createRightViewer(Composite parent_p) {
    // If the right viewer is not already set, delegate its creation.
    if (null == _rightViewer) {
      // Create the right viewer from delegated method.
      _rightViewer = doRightViewer(parent_p);
    }
    layoutViewer(_rightViewer, Messages.getString("AbstractTransferViewer.list.selected.tooltip")); //$NON-NLS-1$
  }

  /**
   * Create the button area.
   * @param parent_p The parent composite.
   */
  protected void createButtonArea(Composite parent_p) {
    // The panel.
    _buttonsPanel = new Composite(parent_p, SWT.NONE);
    GridData gdData = new GridData();
    gdData.widthHint = UI.convertHorizontalDLUsToPixels(_buttonsPanel, IDialogConstants.BUTTON_WIDTH);
    gdData.verticalAlignment = GridData.CENTER;
    gdData.grabExcessVerticalSpace = true;
    _buttonsPanel.setLayoutData(gdData);

    // Sets the panel layout.
    GridLayout buttonsLayout = new GridLayout(1, true);
    _buttonsPanel.setLayout(buttonsLayout);

    // Adds buttons according to the style.
    if ((ADD_ALL_BUTTON & _style) != 0) {
      _addAllBtn = createButton(_buttonsPanel, ">>", Messages.getString("AbstractTransferViewer.addallelements.tooltip")); //$NON-NLS-1$  //$NON-NLS-2$
    }
    if ((ADD_SELECTED_BUTTON & _style) != 0) {
      _addSelectedBtn = createButton(_buttonsPanel, ">", Messages.getString("AbstractTransferViewer.addselectedelements.tooltip")); //$NON-NLS-1$  //$NON-NLS-2$
    }
    if ((REMOVE_SELECTED_BUTTON & _style) != 0) {
      _removeSelectedBtn = createButton(_buttonsPanel, "<", Messages.getString("AbstractTransferViewer.removeselectedelements.tooltip")); //$NON-NLS-1$ //$NON-NLS-2$
    }
    if ((REMOVE_ALL_BUTTON & _style) != 0) {
      _removeAllBtn = createButton(_buttonsPanel, "<<", Messages.getString("AbstractTransferViewer.removeallelements.tooltip")); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  // Create the status text field according to the style.
  private void createStatusTextField(Composite parent_p) {
    // Adds the status text field, if the style constant is set.
    if ((STATUS_TEXT_FIELD & _style) != 0) {
      _statusBar = new Text(parent_p, SWT.READ_ONLY | SWT.BORDER);
      _statusBar.setEditable(false);
      GridData gdData = new GridData();
      gdData.horizontalAlignment = SWT.FILL;
      gdData.grabExcessHorizontalSpace = true;
      gdData.horizontalSpan = 3;
      _statusBar.setLayoutData(gdData);
    }
  }

  // Initialize the different listeners used within this viewer component.
  private void initializeListeners() {
    // Called when the end-user clicks on a button.
    _buttonClickedListener = new SelectionAdapter() {
      /**
       * @see SelectionAdapter#widgetSelected(SelectionEvent)
       */
      @SuppressWarnings("synthetic-access")
      @Override
      public void widgetSelected(SelectionEvent event_p) {
        Widget button = event_p.widget;
        handleButtonClicked(button);
      }
    };
    // Called when the selection changed in both left and right viewers.
    _viewerSelectionChangedListener = new ISelectionChangedListener() {
      /**
       * @see ISelectionChangedListener#selectionChanged(SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        // Handle the viewers selection mode.
        handleViewersSelectionMode(event_p);
        // Handle the selection itself.
        ISelection selection = event_p.getSelection();
        if (!selection.isEmpty()) {
          // Update the buttons state according to the selection.
          updateButtons(selection, event_p.getSelectionProvider());

          // Gets the last element of the current selection.
          IStructuredSelection structSelection = (IStructuredSelection) selection;
          Object lastSelected = structSelection.toList().get(structSelection.size() - 1);

          // Updates the status line.
          ContentViewer source = (ContentViewer) event_p.getSource();
          ILabelProvider labelProvider = (ILabelProvider) source.getLabelProvider();
          updateStatusLine(labelProvider.getText(lastSelected));
        }
      }
    };

    // Called when the internal composite is layout.
    _composite.addControlListener(new ControlAdapter() {
      /**
       * @see org.eclipse.swt.events.ControlAdapter#controlResized(org.eclipse.swt.events.ControlEvent)
       */
      @Override
      public void controlResized(ControlEvent event_p) {
        Control leftControl = _leftViewer.getControl();
        Point leftViewerSize = leftControl.computeSize(SWT.DEFAULT, SWT.DEFAULT);
        Control rightControl = _rightViewer.getControl();
        Point rightViewerSize = rightControl.computeSize(SWT.DEFAULT, SWT.DEFAULT);
        int width = Math.max(leftViewerSize.x, rightViewerSize.x);
        GridData gd = (GridData) leftControl.getLayoutData();
        gd.widthHint = width;
        gd = (GridData) rightControl.getLayoutData();
        gd.widthHint = width;
      }
    });
  }

  // Layouts the specified viewer.
  private void layoutViewer(StructuredViewer viewer_p, String tooltip_p) {
    // Precondition.
    if (null == viewer_p) {
      return;
    }
    // Improve performances.
    viewer_p.setUseHashlookup(true);
    // Updates viewer control.
    Control control = viewer_p.getControl();
    control.setToolTipText(tooltip_p);
    viewer_p.addSelectionChangedListener(_viewerSelectionChangedListener);
    // Sets the viewer layout data.
    GridData gdData = new GridData();
    gdData.horizontalAlignment = SWT.FILL;
    gdData.verticalAlignment = SWT.FILL;
    gdData.grabExcessHorizontalSpace = true;
    gdData.grabExcessVerticalSpace = true;
    control.setLayoutData(gdData);
  }

  // Creates and layout a single button.
  private Button createButton(Composite parent_p, String text_p, String tooltip_p) {
    Button button = new Button(parent_p, SWT.CENTER);
    GridData gdData = new GridData();
    gdData.horizontalAlignment = SWT.FILL;
    gdData.grabExcessHorizontalSpace = true;

    button.setLayoutData(gdData);
    button.setText(text_p);
    button.setToolTipText(tooltip_p);
    button.addSelectionListener(_buttonClickedListener);

    return button;
  }

  // Handle button click. It performs changes between viewers according to the selected button given as argument.
  // This method is not intended to be overridden.
  // To manage the buttons differently, please override doHandle'ButtonName' methods (e.g doHanldeAddAllButton).
  private void handleButtonClicked(Widget button_p) {
    boolean somethingWasDone = false;
    if (button_p == _addAllBtn) {
      somethingWasDone = doHandleAddAllButton();
    } else if (button_p == _addSelectedBtn) {
      somethingWasDone = doHandleAddSelectedButton();
    } else if (button_p == _removeSelectedBtn) {
      somethingWasDone = doHandleRemoveSelectedButton();
    } else if (button_p == _removeAllBtn) {
      somethingWasDone = doHandleRemoveAllButton();
    } else {
      _logger.warn("Unsupported source button :" + button_p); //$NON-NLS-1$
    }

    // Layout the the composite because objects are transfered from a viewer to the other one.
    if (somethingWasDone) {
      doLayout();
    }
  }

  /**
   * Layouts the transfer viewer control.
   */
  protected void doLayout() {
    _composite.layout();
  }

  /**
   * Handle the "Add all" button click.
   * @return <code>True</code> if a change occurs else <code>false</code>.
   */
  protected boolean doHandleAddAllButton() {
    boolean changed = false;
    Object input = _leftViewer.getInput();
    if (null != input) {
      changed = true;

      _leftViewer.setInput(null);
      _rightViewer.setInput(input);
    }
    return changed;
  }

  /**
   * Handle the "Add selected" button click.
   * @return <code>True</code> if a change occurs else <code>false</code>.
   */
  protected boolean doHandleAddSelectedButton() {
    boolean changed = false;
    ISelection leftSelection = _leftViewer.getSelection();
    if (!leftSelection.isEmpty()) {
      changed = true;

      IStructuredSelection structuredSelection = (IStructuredSelection) leftSelection;
      Object[] elements = structuredSelection.toArray();
      _leftViewer.getContentProvider().inputChanged(_leftViewer, elements, null);
      _rightViewer.getContentProvider().inputChanged(_rightViewer, null, elements);
    }
    return changed;
  }

  /**
   * Handle the "Remove selected" button click.
   * @return <code>True</code> if a change occurs else <code>false</code>.
   */
  protected boolean doHandleRemoveSelectedButton() {
    boolean changed = false;
    ISelection rightSelection = _rightViewer.getSelection();
    if (!rightSelection.isEmpty()) {
      changed = true;

      IStructuredSelection structuredSelection = (IStructuredSelection) rightSelection;
      Object[] elements = structuredSelection.toArray();
      _leftViewer.getContentProvider().inputChanged(_leftViewer, null, elements);
      _rightViewer.getContentProvider().inputChanged(_rightViewer, elements, null);
    }
    return changed;
  }

  /**
   * Handle the "Remove all" button click.
   * @return <code>True</code> if a change occurs else <code>false</code>.
   */
  protected boolean doHandleRemoveAllButton() {
    boolean changed = false;

    Object input = _rightViewer.getInput();
    if (null != input) {
      changed = true;

      _rightViewer.setInput(null);
      _leftViewer.setInput(input);
    }
    return changed;
  }

  /**
   * Update the status text field.
   * @param text_p The text field.
   */
  protected void updateStatusLine(String text_p) {
    if (null != _statusBar) {
      _statusBar.setText(text_p);
    }
  }

  /**
   * Update buttons through provided selection changed handlers.
   * @param selection_p The selection.
   * @param selectionProvider_p The selection provider.
   */
  protected void updateButtons(ISelection selection_p, ISelectionProvider selectionProvider_p) {
    List<SelectionChangedHandler> handlersForSelectionProvider = null;
    // Get the selection changed handlers for appropriate viewer : the one that the selection is coming from.
    if (selectionProvider_p == _leftViewer) {
      handlersForSelectionProvider = _selectionChangedHandlersForLeftViewer;
    } else if (selectionProvider_p == _rightViewer) {
      handlersForSelectionProvider = _selectionChangedHandlersForRightViewer;
    }
    // Notify selection changed handlers if at least one is registered for the selection provider.
    notifySelectionChangedHandler(selection_p, handlersForSelectionProvider);
    // Notify selection changed handlers if at least one is registered for both viewers.
    notifySelectionChangedHandler(selection_p, _selectionChangedHandlersForBothViewers);
  }

  /**
   * Notify given list of selection changed handler with specified selection.
   * @param selection_p The selection.
   * @param handlers_p The selection handlers.
   */
  private void notifySelectionChangedHandler(ISelection selection_p, List<SelectionChangedHandler> handlers_p) {
    if (null != handlers_p) {
      for (SelectionChangedHandler handler : handlers_p) {
        handler.handleSelection(selection_p);
      }
    }
  }

  /**
   * Handle viewers selection mode depending on the style provided at construction time.<br>
   * If style is set to {@link #SINGLE_SELECTION_VIEWER}, the selection is revealed in only one viewer ie the selection in the other viewer is unset.
   * @param event_p The selection changed event.
   */
  protected void handleViewersSelectionMode(SelectionChangedEvent event_p) {
    // If single selection viewer is set, handle the new given selection only if this one is not empty.
    // Indeed, the call to 'disableSelectionViewer.setSelection(StructuredSelection.EMPTY)' is reentrant.
    if (0 != (_style & SINGLE_SELECTION_VIEWER) && !event_p.getSelection().isEmpty()) {
      // It must be one of the two viewers : left or right.
      ISelectionProvider selectionProvider = event_p.getSelectionProvider();
      // If the originator of the new selection is the left viewer, disable the selection in the right viewer.
      StructuredViewer disableSelectionViewer = null;
      Button buttonDrivenByOppositeViewer = null;
      if (selectionProvider == _leftViewer) {
        disableSelectionViewer = _rightViewer;
        // Selection is coming from the left viewer, the button linked to the opposite viewer is 'removeSelectedBtn'.
        buttonDrivenByOppositeViewer = _removeSelectedBtn;
      }
      // If the originator of the new selection is the left viewer, disable the selection in the right viewer.
      else if (selectionProvider == _rightViewer) {
        disableSelectionViewer = _leftViewer;
        // Selection is coming from the right viewer, the button linked to the opposite viewer is 'addSelectedBtn'.
        buttonDrivenByOppositeViewer = _addSelectedBtn;
      }
      // Disable the button driven by the opposite viewer.
      if (null != buttonDrivenByOppositeViewer) {
        buttonDrivenByOppositeViewer.setEnabled(false);
      }
      // Disable the selection on the appropriate viewer if it has a non empty selection.
      if (!disableSelectionViewer.getSelection().isEmpty()) {
        disableSelectionViewer.setSelection(StructuredSelection.EMPTY);
      }
    }
  }

  /**
   * Does the right viewer.
   * @param composite_p This composite.
   * @return The right viewer.
   */
  protected abstract StructuredViewer doRightViewer(Composite composite_p);

  /**
   * Does the left viewer.
   * @param composite_p This composite.
   * @return The left composite.
   */
  protected abstract StructuredViewer doLeftViewer(Composite composite_p);

  // ////////////////////// ---- Public API ---- ////////////////////////
  /**
   * Set a selection changed handler used to compute enable state of given button.
   * @param handler_p The selection changed handler.
   * @param buttonStyleConstant_p The button style.
   */
  public void setSelectionChangedHandler(SelectionChangedHandler handler_p, int buttonStyleConstant_p) {
    // Register the given selection changed handler according to style constant.
    if ((null != _addAllBtn) && (ADD_ALL_BUTTON & buttonStyleConstant_p) != 0) {
      handler_p.addControl(_addAllBtn);
      _selectionChangedHandlersForBothViewers.add(handler_p);
    }
    if ((null != _removeAllBtn) && (REMOVE_ALL_BUTTON & buttonStyleConstant_p) != 0) {
      handler_p.addControl(_removeAllBtn);
      _selectionChangedHandlersForBothViewers.add(handler_p);
    }
    if ((null != _addSelectedBtn) && (ADD_SELECTED_BUTTON & buttonStyleConstant_p) != 0) {
      handler_p.addControl(_addSelectedBtn);
      _selectionChangedHandlersForLeftViewer.add(handler_p);
    }
    if ((null != _removeSelectedBtn) && (REMOVE_SELECTED_BUTTON & buttonStyleConstant_p) != 0) {
      handler_p.addControl(_removeSelectedBtn);
      _selectionChangedHandlersForRightViewer.add(handler_p);
    }
  }

  /**
   * Gets the left content provider.
   * @return The left content provider or <code>null</code>.
   */
  public IContentProvider getLeftContentProvider() {
    IContentProvider provider = null;
    if (null != _leftViewer) {
      provider = _leftViewer.getContentProvider();
    }
    return provider;
  }

  /**
   * Gets the left viewer input.
   * @return The left viewer input or <code>null</code>.
   */
  public Object getLeftInput() {
    Object object = null;
    if (null != _leftViewer) {
      object = _leftViewer.getInput();
    }
    return object;
  }

  /**
   * Gets the left viewer.
   * @return The left viewer.
   */
  public StructuredViewer getLeftViewer() {
    return _leftViewer;
  }

  /**
   * Gets the label provider for the left viewer.
   * @return The label provider or <code>null</code>.
   */
  public IBaseLabelProvider getLeftLabelProvider() {
    IBaseLabelProvider provider = null;
    if (null != _leftViewer) {
      provider = _leftViewer.getLabelProvider();
    }
    return provider;
  }

  /**
   * Sets the content provider for the left viewer.
   * @param provider_p The content provider.
   */
  public void setLeftContentProvider(IContentProvider provider_p) {
    _leftViewer.setContentProvider(provider_p);
  }

  /**
   * Sets the left viewer input.
   * @param input_p The input to set.
   */
  public void setLeftInput(Object input_p) {
    _leftViewer.setInput(input_p);
  }

  /**
   * Sets the label provider for the left viewer.
   * @param provider_p The label provider.
   */
  public void setLeftLabelProvider(ILabelProvider provider_p) {
    _leftViewer.setLabelProvider(provider_p);
  }

  /**
   * Gets the right content provider.
   * @return the right content provider or <code>null</code>.
   */
  public IContentProvider getRightContentProvider() {
    IContentProvider provider = null;
    if (null != _rightViewer) {
      provider = _rightViewer.getContentProvider();
    }
    return provider;
  }

  /**
   * Gets the right viewer input.
   * @return The right viewer input or <code>null</code>.
   */
  public Object getRightInput() {
    Object object = null;
    if (null != _rightViewer) {
      object = _rightViewer.getInput();
    }
    return object;
  }

  /**
   * Gets the right viewer.
   * @return the right viewer.
   */
  public StructuredViewer getRightViewer() {
    return _rightViewer;
  }

  /**
   * Gets the label provider for the right viewer.
   * @return The label provider or <code>null</code>.
   */
  public IBaseLabelProvider getRightLabelProvider() {
    IBaseLabelProvider provider = null;
    if (null != _rightViewer) {
      provider = _rightViewer.getLabelProvider();
    }
    return provider;
  }

  /**
   * Sets the content provider for the right viewer.
   * @param provider_p The content provider
   */
  public void setRightContentProvider(IContentProvider provider_p) {
    _rightViewer.setContentProvider(provider_p);
  }

  /**
   * Sets the right viewer input.
   * @param input_p The input.
   */
  public void setRightInput(Object input_p) {
    _rightViewer.setInput(input_p);
  }

  /**
   * Sets the label provider for the right viewer.
   * @param provider_p The label provider.
   */
  public void setRightLabelProvider(ILabelProvider provider_p) {
    _rightViewer.setLabelProvider(provider_p);
  }

  /**
   * @see Widget#dispose()
   */
  public void dispose() {
    // Dispose the composite that hosts everything.
    if (null != _composite && !_composite.isDisposed()) {
      _composite.dispose();
      _composite = null;
    }
    _buttonClickedListener = null;
    _addAllBtn = null;
    _addSelectedBtn = null;
    _removeSelectedBtn = null;
    _removeAllBtn = null;
    if (null != _leftViewer) {
      _leftViewer.removeSelectionChangedListener(_viewerSelectionChangedListener);
    }
    if (null != _rightViewer) {
      _rightViewer.removeSelectionChangedListener(_viewerSelectionChangedListener);
    }
    _viewerSelectionChangedListener = null;
  }

  /**
   * Gets the viewer control.
   * @return The viewer control.
   */
  @Override
  public Control getControl() {
    return _composite;
  }

  /**
   * Does nothing. <b>Use the {@link #getLeftInput()} and {@link #getRightInput()} methods instead of this one.</b>
   */
  @Override
  public Object getInput() {
    // Do nothing.
    return null;
  }

  /**
   * Do nothing.
   * @return null
   * @see org.eclipse.jface.viewers.Viewer#getSelection()
   */
  @Override
  public ISelection getSelection() {
    return null;
  }

  /**
   * @see org.eclipse.jface.viewers.Viewer#refresh()
   */
  @Override
  public void refresh() {
    _leftViewer.refresh();
    _rightViewer.refresh();
  }

  /**
   * Does nothing. <b>Use the {@link #setLeftInput(Object)} and {@link #setRightInput(Object)} methods instead of this one.</b>
   */
  @Override
  public void setInput(Object input_p) {
    // Do nothing.
  }

  /**
   * Do nothing.
   * @see org.eclipse.jface.viewers.Viewer#setSelection(org.eclipse.jface.viewers.ISelection, boolean)
   */
  @Override
  public void setSelection(ISelection selection_p, boolean reveal_p) {
    // Do nothing.
  }

  /**
   * Returns the style bit constant used for the left viewer.
   * @return The left viewer style bits.
   */
  protected int getLeftViewerStyleBits() {
    return _leftViewerStyleBits;
  }

  /**
   * Returns the style bit constant used for the right viewer.
   * @return The right viewer style bits.
   */
  protected int getRightViewerStyleBits() {
    return _rightViewerStyleBits;
  }

  /**
   * Sets the specified buttons enabled or not. The style supports OR'ed defined button style constants.
   * @param buttonStyle_p The button style.
   * @param enable_p <code>True</code> to enable button(s) else <code>false</code>.
   * @see #ADD_ALL_BUTTON
   * @see #ADD_SELECTED_BUTTON
   * @see #REMOVE_SELECTED_BUTTON
   * @see #REMOVE_ALL_BUTTON
   */
  public void setButtonEnabled(int buttonStyle_p, boolean enable_p) {
    if (0 != (buttonStyle_p & ADD_ALL_BUTTON)) {
      _addAllBtn.setEnabled(enable_p);
    }
    if (0 != (buttonStyle_p & ADD_SELECTED_BUTTON)) {
      _addSelectedBtn.setEnabled(enable_p);
    }
    if (0 != (buttonStyle_p & REMOVE_SELECTED_BUTTON)) {
      _removeSelectedBtn.setEnabled(enable_p);
    }
    if (0 != (buttonStyle_p & REMOVE_ALL_BUTTON)) {
      _removeAllBtn.setEnabled(enable_p);
    }
  }

  /**
   * Checks is the specified button is enabled or not. The style does not support OR'ed defined button style constants.
   * @param buttonStyle_p The button style.
   * @return <code>True</code> if the specified button is enabled else <code>false</code>.
   * @see #ADD_ALL_BUTTON
   * @see #ADD_SELECTED_BUTTON
   * @see #REMOVE_SELECTED_BUTTON
   * @see #REMOVE_ALL_BUTTON
   */
  public boolean isButtonEnabled(int buttonStyle_p) {
    boolean enabled = true;
    switch (buttonStyle_p) {
      case ADD_ALL_BUTTON: {
        enabled = _addAllBtn.isEnabled();
        break;
      }
      case ADD_SELECTED_BUTTON: {
        enabled = _addSelectedBtn.isEnabled();
        break;
      }
      case REMOVE_SELECTED_BUTTON: {
        enabled = _removeSelectedBtn.isEnabled();
        break;
      }
      case REMOVE_ALL_BUTTON: {
        enabled = _removeAllBtn.isEnabled();
        break;
      }
    }
    return enabled;
  }

  /**
   * Return the buttons container.
   * @return a not null {@link Composite}.
   */
  public Composite getButtonsContainer() {
    return _buttonsPanel;
  }
}