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
package org.eclipse.egf.core.ui.internal.viewers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.core.data.helper.DataHelper;
import org.eclipse.egf.model.AbstractFactoryComponentFactory;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.Contract;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.ProductionPlan;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;


/**
 * Implements the content provider for the left viewer of the ContractElementReferenceWizardPage.<br>
 * It handles a tree composed of factory components with contract elements as children.
 * @author fournier
 */
public class PossibleContractElementReferenceTreeContentProvider extends AbstractStructuredContentProvider implements ITreeContentProvider {
  /**
   * Initial input.
   */
  private Object _initialInput;

  private Set<ContractElement> _removedContractElements;

  /**
   * Constructor.
   * @param removedContractElements_p initial set of contract elements to remove.
   */
  public PossibleContractElementReferenceTreeContentProvider(Collection<ContractElement> removedContractElements_p) {
    _removedContractElements = new HashSet<ContractElement>(removedContractElements_p);
  }

  /**
   * Return a collection of possible contract elements for given factory component according to given filtered contract elements.
   * @param fc_p
   * @param filteredContractElements_p
   * @return
   */
  private Collection<ContractElement> getPossibleReferencedContractElements(FactoryComponent fc_p, Set<ContractElement> filteredContractElements_p) {
    Collection<ContractElement> possibleReferencedContractElements = DataHelper.getPossibleReferencedContractElement(fc_p);
    // Remove from the returned collection the internal up-to-date removed contract element set.
    possibleReferencedContractElements.removeAll(_removedContractElements);
    return possibleReferencedContractElements;
  }

  /**
   * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
   */
  public Object[] getChildren(Object parentElement_p) {
    Object[] result = null;
    // Object can be an factory component as initial input.
    if (parentElement_p instanceof FactoryComponent) {
      Collection<ContractElement> possibleReferencedContractElements = getPossibleReferencedContractElements((FactoryComponent) parentElement_p, _removedContractElements);
      result = possibleReferencedContractElements.toArray(new ContractElement[possibleReferencedContractElements.size()]);
    } else if (parentElement_p instanceof Contract) { // Object can be a contract as initial input.
      result = handleContractAsInitialInput((Contract) parentElement_p);
    } else if (parentElement_p instanceof Context) { // Object can be a context as initial input.
      result = handleContextAsInitialInput((Context) parentElement_p);
    }
    return result;
  }

  /**
   * Handle the case where a context is the initial input.
   * @param parentElement_p
   * @return can be null
   */
  private Object[] handleContextAsInitialInput(Context context_p) {
    Object[] result = null;
    FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer(context_p);
    // Get the parent (i.e its container) of the context.
    AbstractFactoryComponentFactory contextContainer = (AbstractFactoryComponentFactory) context_p.eContainer();
    Collection<FactoryComponent> referencedFcs = null;
    // Is this context container an FactoryComponentInvocation ?
    if (contextContainer instanceof FactoryComponentInvocation) {
      // Get all referenced factory components by the factory component that contains this contract.
      referencedFcs = DataHelper.getReferencedFactoryComponentsBy(fcContainer);
      // If the context is contained by a factory component invocation,
      // we only keep the referenced factory component for this context.
      FactoryComponentInvocation fcInvocation = (FactoryComponentInvocation) contextContainer;
      // Get the referenced factory component for this factory component invocation.
      FactoryComponent referencedFc = CoreActivator.getDefault().getFactoryComponent(fcInvocation.getFactoryComponentId());
      // Retain only this factory component.
      referencedFcs.retainAll(Collections.singletonList(referencedFc));
    } else if (contextContainer instanceof ProductionPlan) { // Is this context container a ProductionPlan ?
      // If the context is contained by a Production Plan,
      // we only reference the contract elements defined in the same factory component.
      referencedFcs = new ArrayList<FactoryComponent>(0);
      referencedFcs.add(fcContainer);
    }
    // Filter referenced factory component with existing contract element references.
    filterReferencedFcs(referencedFcs);
    result = referencedFcs.toArray(new FactoryComponent[referencedFcs.size()]);
    return result;
  }

  /**
   * Handle the case where a contract is the initial input.
   * @param parentElement_p
   * @return can be null
   */
  private Object[] handleContractAsInitialInput(Contract contract_p) {
    Object[] result;
    // Get all referenced factory component by the factory component that contains this contract.
    Collection<FactoryComponent> referencedFcs = DataHelper.getReferencedFactoryComponentsBy(ModelHelper.getFactoryComponentContainer(contract_p));
    // Filter referenced factory components with existing contract element references.
    filterReferencedFcs(referencedFcs);
    result = referencedFcs.toArray(new FactoryComponent[referencedFcs.size()]);
    return result;
  }

  /**
   * Filter given collection of FactoryComponent with existing contract element references.
   * @param referencedFcs_p
   */
  private void filterReferencedFcs(Collection<FactoryComponent> referencedFcs_p) {
    Iterator<FactoryComponent> filteredFcs = referencedFcs_p.iterator();
    while (filteredFcs.hasNext()) {
      FactoryComponent currentFc = filteredFcs.next();
      // Filter factory components that only have removed contract elements.
      Collection<ContractElement> possibleReferencedContractElements = getPossibleReferencedContractElements(currentFc, _removedContractElements);
      if (possibleReferencedContractElements.isEmpty()) {
        // Filter that current factory component.
        filteredFcs.remove();
      }
    }
  }

  /**
   * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
   */
  public Object getParent(Object element_p) {
    Object result = null;
    if (element_p instanceof ContractElement) {
      result = ModelHelper.getFactoryComponentContainer((ContractElement) element_p);
    } else if (element_p instanceof FactoryComponent) {
      result = _initialInput;
    }
    return result;
  }

  /**
   * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
   */
  public boolean hasChildren(Object element_p) {
    // Get children.
    Object[] children = getChildren(element_p);
    boolean result = (null != children) ? true : false;
    return result;
  }

  /**
   * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
   */
  public Object[] getElements(Object inputElement_p) {
    return getChildren(inputElement_p);
  }

  /**
   * @see org.eclipse.jface.viewers.IContentProvider#dispose()
   */
  public void dispose() {
    // Do nothing.
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.viewers.AbstractStructuredContentProvider#handleElementUpdated(org.eclipse.jface.viewers.Viewer,
   *      java.lang.Object, java.lang.Object)
   */
  @Override
  protected void handleElementUpdated(Viewer viewer_p, Object oldInput_p, Object newInput_p) {
    // Do nothing.
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.viewers.AbstractStructuredContentProvider#handleElementAdded(org.eclipse.jface.viewers.Viewer,
   *      java.lang.Object)
   */
  @Override
  protected void handleElementAdded(Viewer viewer_p, Object addedElements_p) {
    // Handling only the case of ContractElements.
    if (addedElements_p instanceof Object[]) {
      for (Object contractElement : (Object[]) addedElements_p) {
        // Check we got a contract element.
        if (contractElement instanceof ContractElement) {
          // Get the parent of the contract element : here in this tree: it is its factory component container.
          // Add it in the tree viewer.
          AbstractTreeViewer abstractTreeViewer = ((AbstractTreeViewer) viewer_p);
          Object fcParent = getParent(contractElement);
          // Add the contract element parent in case it does not exist yet (if already existing, it is handled by the tree viewer).
          abstractTreeViewer.add(_initialInput, fcParent);
          // Add the contract element itself.
          abstractTreeViewer.add(fcParent, contractElement);
          // Remove it from the internal removed contract element set.
          _removedContractElements.remove(contractElement);
        }
      }
    } else if ((addedElements_p instanceof Contract) || (addedElements_p instanceof Context)) {
      // Case of the initial input.
      _initialInput = addedElements_p;
    }
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.viewers.AbstractStructuredContentProvider#handleElementRemoved(org.eclipse.jface.viewers.Viewer,
   *      java.lang.Object)
   */
  @Override
  protected void handleElementRemoved(Viewer viewer_p, Object removedElements_p) {
    // Handling only the case of ContractElements.
    if (removedElements_p instanceof Object[]) {
      // Find the content type.
      Object[] removedElements = (Object[]) removedElements_p;
      // To successfully remove element in a tree viewer, removed elements must not be the selected ones.
      // Set a new empty selection.
      AbstractTreeViewer abstractTreeViewer = ((AbstractTreeViewer) viewer_p);
      for (Object removedElement : removedElements) {
        // Check we got a contract element.
        if (removedElement instanceof ContractElement) {
          ContractElement removedContractElement = (ContractElement) removedElement;
          // Remove elements.
          abstractTreeViewer.remove(removedElement);
          // Add it to the internal removed contract element set.
          _removedContractElements.add(removedContractElement);
          // Retrieve the parent element of that removed contract element ie an FactoryComponent.
          FactoryComponent fcParent = (FactoryComponent) getParent(removedContractElement);
          // Filter factory components that only have removed contract elements.
          Collection<ContractElement> possibleReferencedContractElements = getPossibleReferencedContractElements(fcParent, _removedContractElements);
          if (possibleReferencedContractElements.isEmpty()) {
            // Filter that factory component because it does not have any children anymore.
            abstractTreeViewer.remove(fcParent);
          }
        }
      }
    }
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.viewers.AbstractStructuredContentProvider#handleViewer(org.eclipse.jface.viewers.Viewer)
   */
  @Override
  protected void handleViewer(Viewer viewer_p) {
    if (!(viewer_p instanceof AbstractTreeViewer)) {
      throw new IllegalArgumentException("Viewer must be an instanceof AbstractTreeViewer"); //$NON-NLS-1$
    }
  }
}
