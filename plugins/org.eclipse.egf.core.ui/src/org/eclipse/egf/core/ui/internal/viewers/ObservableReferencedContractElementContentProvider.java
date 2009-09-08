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
import java.util.List;

import org.eclipse.egf.core.ui.internal.data.AbstractUiContainer;
import org.eclipse.egf.core.ui.internal.data.UiReferencedFactoryComponent;
import org.eclipse.egf.core.ui.internal.data.UiReferencedFactoryComponentContainer;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.Viewer;


/**
 * Implements the content provider for the right viewer of the ContractElementReferenceWizardPage.<br>
 * It handles a tree composed of factory components with contract elements as children.
 * @author fournier
 */
public class ObservableReferencedContractElementContentProvider extends AbstractObservableContentProvider implements ITreeContentProvider {
  /**
   * Initial input.
   */
  private UiReferencedFactoryComponentContainer _initialInput;

  /**
   * @see org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider#handleElementAdded(org.eclipse.jface.viewers.Viewer, java.lang.Object)
   */
  @Override
  protected void handleElementAdded(Viewer viewer_p, Object addedElements_p) {
    // Handling only the case of ContractElements.
    if (addedElements_p instanceof Object[]) {
      List<Object> addedContractElements = new ArrayList<Object>(0);
      // Get the tree viewer.
      AbstractTreeViewer abstractTreeViewer = ((AbstractTreeViewer) viewer_p);
      // Reveal ie added elements are to be made visible.
      List<Object> treePathElements = new ArrayList<Object>(1);
      for (Object element : (Object[]) addedElements_p) {
        // Check we got a contract element.
        if (element instanceof ContractElement) {
          ContractElement contractElement = (ContractElement) element;
          addedContractElements.add(contractElement);
          // Get the FactoryComponent container of the contract element.
          FactoryComponent fc = ModelHelper.getFactoryComponentContainer(contractElement);
          // Get the related UI referenced factory component.
          UiReferencedFactoryComponent uiReferencedFc = _initialInput.getUiReferencedFactoryComponent(fc);
          // If not found we should create a new child.
          if (null == uiReferencedFc) {
            // Create the child.
            uiReferencedFc = new UiReferencedFactoryComponent(_initialInput, fc);
            // Add it to the initial input
            _initialInput.addChild(uiReferencedFc);
            // Add it to the viewer.
            abstractTreeViewer.add(_initialInput, uiReferencedFc);
          }
          uiReferencedFc.addChild(element);
          // Add it to the viewer.
          abstractTreeViewer.add(uiReferencedFc, element);
          // Build tree path
          treePathElements.add(uiReferencedFc);
          treePathElements.add(element);
        }
      }
      // Notify observers.
      notifyElementAdded(addedContractElements);
      // Reveal ie added elements are to be made visible.
      abstractTreeViewer.setSelection(new TreeSelection(new TreePath(treePathElements.toArray())), true);
    } else if (addedElements_p instanceof UiReferencedFactoryComponentContainer) {
      // Case of the initial input.
      _initialInput = (UiReferencedFactoryComponentContainer) addedElements_p;
    }
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider#handleElementRemoved(org.eclipse.jface.viewers.Viewer,
   *      java.lang.Object)
   */
  @Override
  protected void handleElementRemoved(Viewer viewer_p, Object removedElements_p) {
    // Handling only the case of ContractElements.
    if (removedElements_p instanceof Object[]) {
      List<Object> removedContractElements = new ArrayList<Object>(0);
      for (Object element : (Object[]) removedElements_p) {
        // Check we got a contract element.
        if (element instanceof ContractElement) {
          ContractElement contractElement = (ContractElement) element;
          removedContractElements.add(contractElement);
          // Get the FactoryComponent container of the contract element.
          FactoryComponent fc = ModelHelper.getFactoryComponentContainer(contractElement);
          // Get the related UI referenced factory component.
          UiReferencedFactoryComponent uiReferencedFc = _initialInput.getUiReferencedFactoryComponent(fc);
          // Get the tree viewer.
          AbstractTreeViewer abstractTreeViewer = ((AbstractTreeViewer) viewer_p);
          // Must be not null : we are removing an existing contract element from the viewer.
          Object treeModelElementToRemove = null;
          if (null != uiReferencedFc) {
            uiReferencedFc.removeChild(element);
            // Test if the UI referenced factory component is empty, remove it.
            if (uiReferencedFc.isEmpty()) {
              // Remove it from the initial input.
              _initialInput.removeChild(uiReferencedFc);
              // Set the UI element to remove : the UI referenced factory component because it has no longer children.
              treeModelElementToRemove = uiReferencedFc;
            } else {
              // Set the UI element to remove : the contract element.
              treeModelElementToRemove = element;
            }
            // Remove it from the viewer.
            abstractTreeViewer.remove(treeModelElementToRemove);
          }
        }
      }
      // Notify observers.
      notifyElementRemoved(removedContractElements);
    }
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider#handleElementUpdated(org.eclipse.jface.viewers.Viewer,
   *      java.lang.Object, java.lang.Object)
   */
  @Override
  protected void handleElementUpdated(Viewer viewer_p, Object oldInput_p, Object newInput_p) {
    // Do nothing.
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.viewers.AbstractStructuredContentProvider#handleViewer(org.eclipse.jface.viewers.Viewer)
   */
  @Override
  protected void handleViewer(Viewer viewer_p) {
    if (!(viewer_p instanceof AbstractTreeViewer)) {
      throw new IllegalArgumentException("Viewer must be an instanceof AbstractTreeViewer"); //$NON-NLS-1$
    }
  }

  /**
   * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
   */
  public Object[] getElements(Object inputElement_p) {
    return getChildren(inputElement_p);
  }

  /**
   * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
   */
  public Object[] getChildren(Object parentElement_p) {
    Object[] result = null;
    if (parentElement_p instanceof AbstractUiContainer) {
      result = ((AbstractUiContainer) parentElement_p).getChildren();
    }
    return result;
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
}