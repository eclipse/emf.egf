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
import java.util.Iterator;
import java.util.List;

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
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.Contract;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ContractElementReference;
import org.eclipse.egf.model.ProductionPlan;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.widgets.Composite;


/**
 * Implements the contract element reference page, where the end-user can select the contract element dependencies to other contract elements.
 * @author fournier
 */
public class ContractElementReferenceWizardPage extends AbstractModelElementWizardPage {
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
  public ContractElementReferenceWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public ContractElementReferenceWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.ContractElementWizardPage_Title;
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
   */
  @Override
  public IWizardPage getNextPage() {
    // No next page.
    return null;
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
    _treeTransferViewer = new TransferTreeViewer(parent_p, TRANSFER_TREE_STYLE);
    // Set a selection changed handler to enable buttons only when ContractElement objects are selected.
    SelectionChangedHandler handler = new SelectionChangedHandler() {
      /**
       * @see org.eclipse.egf.common.ui.toolkit.widgets.handler.SelectionChangedHandler#doHandleSelection(org.eclipse.jface.viewers.ISelection)
       */
      @Override
      protected boolean doHandleSelection(ISelection selection_p) {
        boolean result = true;
        // Selection must be a structured selection.
        if (selection_p instanceof StructuredSelection) {
          StructuredSelection selection = (StructuredSelection) selection_p;
          Iterator<?> selectedObjects = selection.iterator();
          // Iterate over the selected objects to check that every object is a kind of ContractElement.
          while (selectedObjects.hasNext() && result) {
            Object selectedObject = selectedObjects.next();
            if (!(selectedObject instanceof ContractElement)) {
              result = false;
            }
          }
        } else {
          result = false;
        }
        return result;
      }
    };
    _treeTransferViewer.setSelectionChangedHandler(handler, TRANSFER_BUTTONS);
    // Set specific property on the right viewer of the treeTransferViewer
    final AbstractTreeViewer rightViewer = (AbstractTreeViewer) _treeTransferViewer.getRightViewer();
    // Set a property for always expand all nodes.
    rightViewer.setAutoExpandLevel(AbstractTreeViewer.ALL_LEVELS);
    ViewerSorter defaultViewerSorter = new ViewerSorter();
    rightViewer.setSorter(defaultViewerSorter);
    // Set specific property on the left viewer of the treeTransferViewer
    _treeTransferViewer.getLeftViewer().setSorter(defaultViewerSorter);
    // Handle right viewer initialization
    Collection<ContractElement> referencedContractElements = handleRightViewerInitialization();
    // Filter the other referenced contract elements from sibling contract elements.
    handleSiblingContractElements(referencedContractElements);
    // Filter the referenced contract element from context elements defined in the same factory component.
    handleSiblingContext(referencedContractElements);
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
   * Handle the referenced contract elements from the context contained in the production plan and its factory component invocations of current factory component (the one that hosts
   * this contract element).
   * @param referencedContractElements_p
   */
  private void handleSiblingContext(Collection<ContractElement> referencedContractElements_p) {
    // Get the factory component that hosts the contract which contains this contract element.
    FactoryComponent fc = ModelHelper.getFactoryComponentContainer(getParent());
    // Get the production plan of the retrieved factory component.
    ProductionPlan productionPlan = ModelHelper.getProductionPlan(fc);
    // Get the production plan context.
    Context context = productionPlan.getContext();
    // Get the referenced contract elements for the production plan context.
    referencedContractElements_p.addAll(DataHelper.getReferencedContractElementsFor(context));
    List<FactoryComponentInvocation> fcInvocations = productionPlan.getFactoryComponentInvocations();
    // Loop over its factory component invocation context.
    for (FactoryComponentInvocation fcInvocation : fcInvocations) {
      context = fcInvocation.getContext();
      // Get the referenced contract elements for the current factory component invocation context.
      referencedContractElements_p.addAll(DataHelper.getReferencedContractElementsFor(context));
    }
  }

  /**
   * Handle sibling contract elements to filter their contract element references.
   * @param referencedContractElements_p
   */
  private void handleSiblingContractElements(Collection<ContractElement> referencedContractElements_p) {
    Contract contract = (Contract) getParent();
    referencedContractElements_p.addAll(DataHelper.getReferencedContractElementsFor(contract));
  }

  /**
   * Handle the left viewer initialization.
   * @return
   */
  protected IContentProvider handleLeftViewerInitialization(Collection<ContractElement> referencedContractElementList_p) {
    // Set content and label providers for the left viewer.
    _treeTransferViewer.setLeftLabelProvider(_decoratedLabelProvider);
    ColumnViewerToolTipSupport.enableFor((TreeViewer) _treeTransferViewer.getLeftViewer());
    // Set a content provider that handles a contract with children as factory components with children as contract elements
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
  protected Collection<ContractElement> handleRightViewerInitialization() {
    _treeTransferViewer.setRightLabelProvider(_decoratedLabelProvider);
    ColumnViewerToolTipSupport.enableFor((TreeViewer) _treeTransferViewer.getRightViewer());
    // Create a content provider that is able to notify UI changes.
    ObservableReferencedContractElementContentProvider observableContentProvider = new ObservableReferencedContractElementContentProvider();
    // Set the content provider.
    _treeTransferViewer.setRightContentProvider(observableContentProvider);
    // Create the initial input for the right viewer.
    Collection<ContractElement> referencedContractElements = DataHelper.getReferencedContractElementsFor(getContractElement());
    UiReferencedFactoryComponentContainer initialInput =
                                              new UiReferencedFactoryComponentContainer(referencedContractElements.toArray(new ContractElement[referencedContractElements
                                                  .size()]));
    _treeTransferViewer.setRightInput(initialInput);
    ContractElementListObserver contractElementListObserver = new ContractElementListObserver();
    // Add an observer on our content provider.
    observableContentProvider.addListViewerObserver(contractElementListObserver);
    // Returned the already used contract element references.
    return referencedContractElements;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getCompleteStatus()
   */
  @Override
  protected boolean getCompleteStatus() {
    String errorMessage = null;
    // First rule : check there is at least one contract element reference.
    boolean result = hasAtLeastOneContractReference();
    if (!result) {
      errorMessage = Messages.ContractElementTypeWizardPage_ErrorMessage_1;
    } else {
      // Second rule : Every referenced contract element has the same type?
      result = checkEveryReferencedContractElementHasSameType();
      if (!result) {
        errorMessage = Messages.ContractElementTypeWizardPage_ErrorMessage_2;
      }
    }
    // Set the wizard page error message, if one field is not validated.
    setErrorMessage(errorMessage);
    return result;
  }

  /**
   * Check if every referenced contract element has the same type.
   * @return
   */
  private boolean checkEveryReferencedContractElementHasSameType() {
    boolean result = true;
    String typeHolderName = null;
    ContractElement contractElement = getContractElement();
    Iterator<ContractElementReference> iterator = contractElement.getContractElementReferences().iterator();
    while (iterator.hasNext() && result) {
      ContractElementReference contractElementReference = iterator.next();
      // Get the type holder class name.
      String currentTypeHolderClassName = contractElementReference.getReferencedContractElement().getContractType().getTypeHolderClassName();
      if (null == typeHolderName) {
        typeHolderName = currentTypeHolderClassName;
      } else {
        // Compare current type holder class name with previous contract element reference one.
        result = typeHolderName.equals(currentTypeHolderClassName);
      }
    }
    // Set the type on current contract element.
    if (result) {
      ModelHelper.setContractType(contractElement, typeHolderName);
    }
    return result;
  }

  /**
   * Check if the contract element has at least one reference.
   * @return
   */
  private boolean hasAtLeastOneContractReference() {
    return !getContractElement().getContractElementReferences().isEmpty();
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
      // List of contract element references.
      EList<ContractElementReference> contractElementReferences = getContractElement().getContractElementReferences();
      // Loop over element to add them in lists.
      for (Object element : elements_p) {
        // Get the referenced contract element.
        ContractElement referencedContractElement = (ContractElement) element;
        // Create a contract element reference for referenced contract element.
        ContractElementReference contractElementReference = ModelHelper.createContractElementReferenceBasedOn(referencedContractElement);
        // Add it to the reference objects.
        contractElementReferences.add(contractElementReference);
      }
      // Update the wizard page.
      updateButtons();
    }

    /**
     * @see org.eclipse.egf.core.ui.internal.observable.IListViewerObserver#elementRemoved(java.util.List)
     */
    public void elementRemoved(List<Object> elements_p) {
      // List of contract element references.
      EList<ContractElementReference> contractElementReferences = getContractElement().getContractElementReferences();
      // Loop over element to remove them from lists.
      for (Object element : elements_p) {
        // Get the referenced contract element.
        ContractElement referencedContractElement = (ContractElement) element;
        // Removing a contract element reference that refers this referenced contract element.
        Iterator<ContractElementReference> iterator = contractElementReferences.iterator();
        while (iterator.hasNext()) {
          ContractElementReference contractElementReference = iterator.next();
          // Resolve it in case of.
          DataHelper.resolveContractElement(contractElementReference);
          if (referencedContractElement == contractElementReference.getReferencedContractElement()) {
            // Contract element reference to remove is retrieved.
            // Remove it from contract element reference list.
            iterator.remove();
          }
        }
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
   * Return the handled contract element.
   * @return
   */
  protected ContractElement getContractElement() {
    return (ContractElement) getModelElement();
  }

  /**
   * @see org.eclipse.jface.dialogs.DialogPage#dispose()
   */
  @Override
  public void dispose() {
    super.dispose();
    _treeTransferViewer.dispose();
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getHelpContextId()
   */
  @Override
  protected String getHelpContextId() {
    return IHelpContextIds.NEW_CONTRACT_ELEMENT_REFERENCE_WIZARD_PAGE;
  }
}
