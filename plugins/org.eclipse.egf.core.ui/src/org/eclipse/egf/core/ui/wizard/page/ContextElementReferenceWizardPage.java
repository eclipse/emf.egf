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

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.egf.common.ui.toolkit.viewers.AbstractTransferViewer;
import org.eclipse.egf.common.ui.toolkit.viewers.TransferTreeViewer;
import org.eclipse.egf.common.ui.toolkit.widgets.handler.SelectionChangedHandler;
import org.eclipse.egf.core.data.helper.DataHelper;
import org.eclipse.egf.core.ui.internal.data.UiReferencedFactoryComponentContainer;
import org.eclipse.egf.core.ui.internal.help.IHelpContextIds;
import org.eclipse.egf.core.ui.internal.observable.IListViewerObserver;
import org.eclipse.egf.core.ui.internal.viewers.CustomTooltipLabelProvider;
import org.eclipse.egf.core.ui.internal.viewers.DecoratedModelLabelProvider;
import org.eclipse.egf.core.ui.internal.viewers.ObservableReferencedContractElementContentProvider;
import org.eclipse.egf.core.ui.internal.viewers.PossibleContractElementReferenceTreeContentProvider;
import org.eclipse.egf.core.ui.wizard.ContextElementWizard;
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.ContextElement;
import org.eclipse.egf.model.Contract;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;


/**
 * Implements the context element reference wizard page.
 * @author fournier
 */
public class ContextElementReferenceWizardPage extends AbstractModelElementWizardPage {
  /**
   * TreeViewer style bits constant.
   */
  private final static int TREE_VIEWER_STYLE = SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER;
  /**
   * Log4j reference logger.
   */
  protected static final Logger __logger = Logger.getLogger(ContextElementReferenceWizardPage.class.getPackage().getName());
  /**
   * Remove the 'addAll'& 'removeAll' buttons.
   */
  private final int TRANSFER_BUTTONS = AbstractTransferViewer.ALL_BUTTONS & ~AbstractTransferViewer.ADD_ALL_BUTTON & ~AbstractTransferViewer.REMOVE_ALL_BUTTON;
  /**
   * Transfer tree style.
   */
  private final int TRANSFER_TREE_STYLE = AbstractTransferViewer.SINGLE_SELECTION_VIEWER | TRANSFER_BUTTONS;
  /**
   * TransferViewer used to select referenced contract elements.
   */
  protected AbstractTransferViewer _treeTransferViewer;
  /**
   * Label provider used in the transfer viewer.
   */
  private ILabelProvider _decoratedLabelProvider;

  /**
   * Constructor.
   * @param pageName_p
   */
  public ContextElementReferenceWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public ContextElementReferenceWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#createPageArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createPageArea(Composite parent_p) {
    _decoratedLabelProvider = new CustomTooltipLabelProvider(new DecoratedModelLabelProvider());
    // Create the transfer viewer.
    createTransferViewer(parent_p);
  }

  /**
   * Create the transfer viewer.
   * @param parent_p
   */
  private void createTransferViewer(Composite parent_p) {
    _treeTransferViewer = new TransferTreeViewer(parent_p, TRANSFER_TREE_STYLE, TREE_VIEWER_STYLE, TREE_VIEWER_STYLE);
    // Initialization of selection changed handler.
    initializeHandlers(_treeTransferViewer);
    // Set specific property on the right viewer of the treeTransferViewer
    AbstractTreeViewer rightViewer = (AbstractTreeViewer) _treeTransferViewer.getRightViewer();
    ViewerSorter defaultViewerSorter = new ViewerSorter();
    rightViewer.setSorter(defaultViewerSorter);
    // Set specific property on the left viewer of the treeTransferViewer
    _treeTransferViewer.getLeftViewer().setSorter(defaultViewerSorter);
    // Set a property for always expand all nodes.
    rightViewer.setAutoExpandLevel(AbstractTreeViewer.ALL_LEVELS);
    // Handle right viewer initialization
    ContractElement referencedContractElement = handleRightViewerInitialization();
    // Filter its own contract element reference.
    Set<ContractElement> referencedContractElements = new HashSet<ContractElement>(0);
    if (null != referencedContractElement) {
      referencedContractElements.add(referencedContractElement);
    }
    // Filter the other referenced contract elements from the contract of parent factory component.
    handleSiblingContract(referencedContractElements);
    // Filter the other referenced contract elements from sibling context elements.
    handleSiblingContextElements(referencedContractElements);
    // Handle left viewer initialization
    handleLeftViewerInitialization(referencedContractElements);
    // Update transfer viewer layout to get something nice in asynch way to be sure data are loaded before layout the UI.
    parent_p.getDisplay().asyncExec(new Runnable() {
      /**
       * @see java.lang.Runnable#run()
       */
      public void run() {
        Composite control = (Composite) _treeTransferViewer.getControl();
        control.layout();
      }
    });
  }

  /**
   * Handle the referenced contract elements from contract elements contained in the contract of current factory component (the one that hosts this context element).
   * @param referencedContractElements_p
   */
  private void handleSiblingContract(Collection<ContractElement> referencedContractElements_p) {
    // Get the factory component that hosts the context which contains this context element.
    FactoryComponent fc = ModelHelper.getFactoryComponentContainer(getParent());
    // Get the contract of the retrieved factory component.
    Contract contract = ModelHelper.getContract(fc);
    // Retrieve the referenced contract elements from the retrieved contract.
    referencedContractElements_p.addAll(DataHelper.getReferencedContractElementsFor(contract));
  }

  /**
   * Handle sibling context elements to filter their contract element reference.
   * @param referencedContractElements_p
   */
  private void handleSiblingContextElements(Collection<ContractElement> referencedContractElements_p) {
    Context context = (Context) getParent();
    referencedContractElements_p.addAll(DataHelper.getReferencedContractElementsFor(context));
  }

  /**
   * Initialize handlers on given
   * @param treeTransferViewer_p
   */
  protected void initializeHandlers(AbstractTransferViewer transferViewer_p) {
    // Set a selection changes handler to enable buttons only when ContractElement objects are selected.
    SelectionChangedHandler handler = new TypedSelectionChangedHandler() {
      /**
       * @see org.eclipse.egf.core.ui.wizard.page.ContextElementReferenceWizardPage.TypedSelectionChangedHandler#handleInitialCondition()
       */
      @Override
      protected boolean handleInitialCondition() {
        // The contract element reference must be null to enable the 'add Selected Object' button.
        return (null == getContextElement().getContractElementReference());
      }
    };
    // Set this handler on the 'add selected object'...
    transferViewer_p.setSelectionChangedHandler(handler, AbstractTransferViewer.ADD_SELECTED_BUTTON);
    //
    //
    handler = new TypedSelectionChangedHandler() {
      /**
       * @see org.eclipse.egf.core.ui.wizard.page.ContextElementReferenceWizardPage.TypedSelectionChangedHandler#handleInitialCondition()
       */
      @Override
      protected boolean handleInitialCondition() {
        // The contract element reference must be not null to enable the 'remove Selected Object' button.
        return (null != getContextElement().getContractElementReference());
      }
    };
    // Set this handler on the 'remove selected object'...
    transferViewer_p.setSelectionChangedHandler(handler, AbstractTransferViewer.REMOVE_SELECTED_BUTTON);
  }

  /**
   * Handle the left viewer initialization.
   * @return
   */
  protected IContentProvider handleLeftViewerInitialization(Collection<ContractElement> referencedContractElementList_p) {
    _treeTransferViewer.setLeftLabelProvider(_decoratedLabelProvider);
    ColumnViewerToolTipSupport.enableFor((TreeViewer) _treeTransferViewer.getLeftViewer());
    // Set a content provider that handles a context with children as factory components with children as contract elements
    PossibleContractElementReferenceTreeContentProvider possibleContractElementReferenceTreeContentProvider =
                                                                                                              new PossibleContractElementReferenceTreeContentProvider(
                                                                                                                                                                      referencedContractElementList_p);
    _treeTransferViewer.setLeftContentProvider(possibleContractElementReferenceTreeContentProvider);
    _treeTransferViewer.setLeftInput(getParent()); // parent is a Contract.
    return possibleContractElementReferenceTreeContentProvider;
  }

  /**
   * Handle the right viewer initialization.
   */
  protected ContractElement handleRightViewerInitialization() {
    // Set content and label providers for the right viewer.
    // Set the label provider.
    _treeTransferViewer.setRightLabelProvider(_decoratedLabelProvider);
    ColumnViewerToolTipSupport.enableFor((TreeViewer) _treeTransferViewer.getRightViewer());
    // Create a content provider that is able to notify UI changes.
    ObservableReferencedContractElementContentProvider observableContentProvider = new ObservableReferencedContractElementContentProvider();
    // Set the content provider.
    _treeTransferViewer.setRightContentProvider(observableContentProvider);
    // Create the initial input for the right viewer.
    ContractElement referencedContractElement = DataHelper.getReferencedContractElementFor(getContextElement());
    ContractElement[] referencedContractElementArray = null;
    if (null != referencedContractElement) {
      referencedContractElementArray = new ContractElement[1];
      referencedContractElementArray[0] = referencedContractElement;
    } else {
      referencedContractElementArray = new ContractElement[0];
    }
    UiReferencedFactoryComponentContainer initialInput = new UiReferencedFactoryComponentContainer(referencedContractElementArray);
    _treeTransferViewer.setRightInput(initialInput);
    ContractElementListObserver contractElementListObserver = new ContractElementListObserver();
    // Add an observer on our content provider.
    observableContentProvider.addListViewerObserver(contractElementListObserver);
    // Returned the already used contract element references.
    return referencedContractElement;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getCompleteStatus()
   */
  @Override
  protected boolean getCompleteStatus() {
    // We can't finish in this page.
    return false;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.ContextElementWizardPage_Title;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getHelpContextId()
   */
  @Override
  protected String getHelpContextId() {
    return IHelpContextIds.NEW_CONTEXT_ELEMENT_REFERENCE_WIZARD_PAGE;
  }

  /**
   * Return the handled context element.
   * @return
   */
  protected ContextElement getContextElement() {
    return (ContextElement) getModelElement();
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
   */
  @Override
  public boolean canFlipToNextPage() {
    ContextElement contextElement = getContextElement();
    ContractElement referencedContractElement = DataHelper.getReferencedContractElementFor(contextElement);
    // If the referenced contract element is set, we can flip to next page.
    boolean canFlipToNextPage = (null != referencedContractElement);
    // If we can flip to the next page, it means this page is complete and valid.
    if (canFlipToNextPage) {
      // Reset to null the type, because we are based on a contract element reference.
      contextElement.setContextType(null);
      // Reset to null the key, because we are based on a contract element reference.
      contextElement.setKey(null);
    }
    return canFlipToNextPage;
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
   */
  @Override
  public IWizardPage getNextPage() {
    IWizard wizard = getWizard();
    ContextElementValueWizardPage nextPage = (ContextElementValueWizardPage) wizard.getPage(ContextElementWizard.CONTEXT_ELEMENT_VALUE_PAGE);
    // Update the context element type
    ContractElement referencedContractElement = DataHelper.getReferencedContractElementFor(getContextElement());
    nextPage.updateContextElementType(referencedContractElement.getContractType().getTypeHolderClassName());
    return nextPage;
  }

  /**
   * Implement a list observer for contract element reference.
   * @author fournier
   */
  class ContractElementListObserver implements IListViewerObserver {
    /**
     * @see org.eclipse.egf.core.ui.internal.observable.IListViewerObserver#elementAdded(java.util.List)
     */
    public void elementAdded(List<Object> elements_p) {
      // Get the first referenced contract element of given list.
      ContractElement referencedContractElement = (ContractElement) elements_p.get(0);
      // Create a contract element reference for referenced contract element.
      ContractElementReference contractElementReference = ModelHelper.createContractElementReferenceBasedOn(referencedContractElement);
      // Set it as the reference object.
      getContextElement().setContractElementReference(contractElementReference);
      // Update the wizard page.
      updateButtons();
    }

    /**
     * @see org.eclipse.egf.core.ui.internal.observable.IListViewerObserver#elementRemoved(java.util.List)
     */
    public void elementRemoved(List<Object> elements_p) {
      // Get the first referenced contract element of given list.
      ContextElement contextElement = getContextElement();
      ContractElement referencedContractElementToRemove = (ContractElement) elements_p.get(0);
      // Get the registered contract reference element.
      ContractElement referencedContractElement = DataHelper.getReferencedContractElementFor(contextElement);
      if (referencedContractElementToRemove == referencedContractElement) {
        // Reset to null the object reference.
        contextElement.setContractElementReference(null);
        // Reset to null the object reference id, because the instance is lazy loaded from this id (if the instance is null).
        contextElement.setContractReferenceId(null);
      } else {
        StringBuilder loggerMessage = new StringBuilder("ContractElementListObserver.elementRemoved(..) _ "); //$NON-NLS-1$
        loggerMessage.append("Failed to remove the ContractElementReference for context element:"); //$NON-NLS-1$
        loggerMessage.append(contextElement.getId());
        __logger.warn(loggerMessage.toString());
      }
      // Update the wizard page.
      updateButtons();
    }

    /**
     * @see org.eclipse.egf.core.ui.internal.observable.IListViewerObserver#elementUpdated(java.util.List)
     */
    public void elementUpdated(List<Object> elements_p) {
      // Update the wizard page.
      updateButtons();
    }
  }

  /**
   * Base class to implement selection changed handler for the context element reference wizard page.
   * @author Guillaume Brocard
   */
  abstract class TypedSelectionChangedHandler extends SelectionChangedHandler {
    /**
     * @see org.eclipse.egf.common.ui.toolkit.widgets.handler.SelectionChangedHandler#doHandleSelection(org.eclipse.jface.viewers.ISelection)
     */
    @Override
    protected boolean doHandleSelection(ISelection selection_p) {
      // Handle initial condition.
      boolean result = handleInitialCondition();
      // Selection must be a structured selection.
      if (selection_p instanceof StructuredSelection) {
        StructuredSelection selection = (StructuredSelection) selection_p;
        Iterator<?> selectedObjects = selection.iterator();
        // Iterate over the selected objects to check that every object is a kind of ContractElement.
        while (selectedObjects.hasNext() && result) {
          Object selectedObject = selectedObjects.next();
          result = (selectedObject instanceof ContractElement);
        }
      }
      return result;
    }

    /**
     * Handle initial condition.
     * @return
     */
    protected abstract boolean handleInitialCondition();
  }
}