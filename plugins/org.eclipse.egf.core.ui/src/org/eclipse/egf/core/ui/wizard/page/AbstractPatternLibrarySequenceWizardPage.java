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
package org.eclipse.egf.core.ui.wizard.page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.egf.common.ui.toolkit.widgets.handler.SelectionChangedHandler;
import org.eclipse.egf.common.ui.viewers.IContentHandler;
import org.eclipse.egf.common.ui.viewers.OrderedListViewer;
import org.eclipse.egf.common.ui.viewers.OrderedListViewerWithAddAndRemove;
import org.eclipse.egf.core.ui.internal.dialogs.ModelElementSelectionDialog;
import org.eclipse.egf.core.ui.internal.observable.IListViewerObserver;
import org.eclipse.egf.core.ui.internal.viewers.ObservablePatternElementContentProvider;
import org.eclipse.egf.core.ui.viewers.AdaptedModelElementLabelProvider;
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;


/**
 * Base class to implement the pattern library wizard page that allows the end-user to select production orchestration<br>
 * and the runtime orchestration.
 * @author Guillaume Brocard
 */
public abstract class AbstractPatternLibrarySequenceWizardPage extends AbstractModelElementWizardPage implements IListViewerObserver {
  /**
   * Defines the viewer height in chars.
   */
  private static final int VIEWER_HEIGHT_IN_CHARS = 10;
  /**
   * Defines the viewer width in chars.
   */
  private static final int VIEWER_WIDTH_IN_CHARS = 60;
  /**
   * List viewer used to display the contained pattern elements.
   */
  private OrderedListViewer _orderedViewer;
  /**
   * Content handler
   */
  private IContentHandler _runtimeSequenceContentHandler;

  /**
   * Constructor.
   * @param pageName_p
   */
  protected AbstractPatternLibrarySequenceWizardPage(String pageName_p) {
    super(pageName_p);
    initializeContentHandler();
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public AbstractPatternLibrarySequenceWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
    initializeContentHandler();
  }

  /**
   * Initialize content handler used to drive the pattern element selection dialog.
   */
  private void initializeContentHandler() {
    _runtimeSequenceContentHandler = new IContentHandler() {
      /**
       * @see org.eclipse.egf.common.ui.viewers.IContentHandler#createNewElement()
       */
      public Object createNewElement() {
        Object pattern = null;
        // Create a dialog to select a pattern element to add.
        ModelElementSelectionDialog selectionDialog = new ModelElementSelectionDialog(getShell());
        // Set title.
        selectionDialog.setTitle(Messages.AbstractPatternLibrarySequenceWizardPage_PatternElementSelectionDialog_Title);
        // Set message.
        selectionDialog.setMessage(Messages.AbstractPatternLibrarySequenceWizardPage_PatternElementSelectionDialog_Message);
        // Set single selection mode.
        selectionDialog.setMultipleSelection(false);
        // Set the elements displayed in the dialog.
        selectionDialog.setElements(getDisplayedPatternElements());
        // Open it.
        if (IDialogConstants.OK_ID == selectionDialog.open()) {
          // Get selected object.
          Object[] selection = selectionDialog.getResult();
          if (null != selection && selection.length > 0) {
            // We are not in multi selection context.
            pattern = selection[0];
          }
        }
        return pattern;
      }

      /**
       * Return the displayed pattern elements. Return the element
       * @return a not null list.
       */
      private List<? extends NamedModelElementWithId> getDisplayedPatternElements() {
        // Get the pattern element contained elements.
        // Clone the list because, some elements can be filtered in the UI.
        List<AbstractPatternElement> containedElements = new ArrayList<AbstractPatternElement>(getPatternLibrary().getPatternElements());
        // Remove filtered elements.
        containedElements.removeAll(getFilteredPatternElements());
        return containedElements;
      }

      /**
       * @see org.eclipse.egf.common.ui.viewers.IContentHandler#removeElement(java.lang.Object)
       */
      public void removeElement(Object element_p) {
        // Do nothing.
      }
    };
  }

  /**
   * Return the filtered pattern elements when adding a new one from the 'add' button.<br>
   * Default implementation returns an empty list.
   * @return a not null {@link List}.
   */
  protected List<Object> getFilteredPatternElements() {
    // Do nothing.
    return Collections.emptyList();
  }

  /**
   * Create the ordered viewer.
   * @param parent_p
   * @return a not null {@link OrderedListViewer} instance.
   */
  protected OrderedListViewer createOrderedViewer(Composite parent_p) {
    return new OrderedListViewerWithAddAndRemove(parent_p) {
      /**
       * @see org.eclipse.egf.common.ui.viewers.OrderedListViewerWithAddAndRemove#getContentHandler()
       */
      @SuppressWarnings("synthetic-access")
      @Override
      protected IContentHandler getContentHandler() {
        return _runtimeSequenceContentHandler;
      }

      /**
       * @see org.eclipse.egf.common.ui.viewers.OrderedListViewerWithAddAndRemove#createRemoveButtonHandler()
       */
      @Override
      protected SelectionChangedHandler createRemoveButtonHandler() {
        return new SelectionChangedHandler() {
          /**
           * @see org.eclipse.egf.common.ui.toolkit.widgets.handler.SelectionChangedHandler#doHandleSelection(org.eclipse.jface.viewers.ISelection)
           */
          @Override
          protected boolean doHandleSelection(ISelection selection_p) {
            return !selection_p.isEmpty();
          }
        };
      }
    };
  }

  protected void initializeOrderedViewer(StructuredViewer decoratedViewer) {
    // Tweak the UI to get something nice when a library has a lot of patterns.
    GridData data = (GridData) decoratedViewer.getControl().getLayoutData();
    data.widthHint = convertWidthInCharsToPixels(VIEWER_WIDTH_IN_CHARS);
    data.heightHint = convertHeightInCharsToPixels(VIEWER_HEIGHT_IN_CHARS);
    // Set it a label provider.
    decoratedViewer.setLabelProvider(new AdaptedModelElementLabelProvider(getAdapterFactory()));
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#createPageArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createPageArea(Composite parent_p) {
    // Create the ordered viewer.
    _orderedViewer = createOrderedViewer(parent_p);
    // Get the decorated viewer and initialize it.
    StructuredViewer decoratedViewer = _orderedViewer.getDecoratedViewer();
    initializeOrderedViewer(decoratedViewer);
    // Set it a content provider.
    ObservablePatternElementContentProvider observablePatternElementContentProvider = new ObservablePatternElementContentProvider();
    observablePatternElementContentProvider.addListViewerObserver(this);
    decoratedViewer.setContentProvider(observablePatternElementContentProvider);
    // Set the initial input.
    List<Object> patternElementsOrder = getPatternElementsOrder();
    decoratedViewer.setInput(patternElementsOrder);
  }

  /**
   * Return the list of {@link AbstractPatternElement} ordered as defined by the end-user.
   * @return
   */
  protected List<Object> getPatternElementsOrder() {
    List<Object> result = new ArrayList<Object>(0);
    // Get the production orchestration.
    String orchestration = getOrchestrationValue();
    // If defined, use it to create the list of pattern elements displayed in the viewer.
    if (null != orchestration && orchestration.length() > 0) {
      result = getPatternElements(orchestration);
    }
    return result;
  }

  /**
   * Return the orchestration value.
   * @return
   */
  protected abstract String getOrchestrationValue();

  /**
   * Return the list of pattern element for given orchestration value.
   * @param orchestrationValue_p a not null string.
   * @return a not null list.
   */
  protected abstract List<Object> getPatternElements(String orchestrationValue_p);

  /**
   * @see org.eclipse.egf.core.ui.internal.observable.IListViewerObserver#elementAdded(java.util.List)
   */
  public void elementAdded(List<Object> elements_p) {
    // Do nothing.
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.observable.IListViewerObserver#elementRemoved(java.util.List)
   */
  public void elementRemoved(List<Object> elements_p) {
    // Do nothing.
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getCompleteStatus()
   */
  @Override
  protected boolean getCompleteStatus() {
    return true;
  }

  /**
   * Get pattern elements for handled pattern library.
   * @return
   */
  protected List<AbstractPatternElement> getPatternElements() {
    return getPatternLibrary().getPatternElements();
  }

  /**
   * Get the handled pattern library.
   * @return
   */
  protected PatternLibrary getPatternLibrary() {
    return (PatternLibrary) getModelElement();
  }
}