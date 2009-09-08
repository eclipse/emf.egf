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
package org.eclipse.egf.core.ui.viewers;

import org.eclipse.egf.common.ui.constant.IUiCommonConstants;
import org.eclipse.egf.core.ui.data.ElementAdapterFactory;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.model.IWorkbenchAdapter;


/**
 * Base class to implement EMF adapters-based content provider.
 * @author fournier
 */
public abstract class AbstractAdaptedModelElementContentProvider implements ITreeContentProvider {
  /**
   * EMF adapters-base content provider.
   */
  private AdapterFactoryContentProvider _adapterFactoryContentProvider;
  /**
   * Reference to the viewer
   */
  private AbstractTreeViewer _viewer;
  /**
   * Keep a reference to the initial input.
   */
  private Object _initialInput;

  /**
   * Constructor.
   * @param adapterFactory_p the adapter factory used for providing views of the model.
   */
  public AbstractAdaptedModelElementContentProvider() {
    super();
    // Initialize EMF content provider.
    _adapterFactoryContentProvider = new AdapterFactoryContentProvider(getAdapterFactory());
  }

  /**
   * Return the adapter factory for this content provider.
   * @return a null instance.
   */
  protected abstract AdapterFactory getAdapterFactory();

  /**
   * Return the adapter factory content provider.
   * @return the adapterFactoryContentProvider
   */
  public AdapterFactoryContentProvider getAdapterFactoryContentProvider() {
    return _adapterFactoryContentProvider;
  }

  /**
   * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
   */
  public Object[] getChildren(Object parentElement_p) {
    Object[] elements = IUiCommonConstants.NO_ELEMENT;
    // If given argument is a NamedModelElementWithId, let's use the EMF adapter accordingly.
    if (parentElement_p instanceof NamedModelElementWithId) {
      elements = _adapterFactoryContentProvider.getChildren(parentElement_p);
    } else {
      // Try to find an adapter from the platform adapters mechanism.
      IWorkbenchAdapter adapter = ElementAdapterFactory.getWorkbenchAdapter(parentElement_p);
      if (null != adapter) {
        elements = adapter.getChildren(parentElement_p);
      }
    }
    return elements;
  }

  /**
   * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
   */
  public Object getParent(Object element_p) {
    Object parent = null;
    // If given argument is a NamedModelElementWithId, let's use the EMF adapter accordingly.
    if (element_p instanceof NamedModelElementWithId) {
      parent = _adapterFactoryContentProvider.getParent(element_p);
    } else {
      // Try to find an adapter from the platform adapters mechanism.
      IWorkbenchAdapter adapter = ElementAdapterFactory.getWorkbenchAdapter(element_p);
      if (null != adapter) {
        parent = adapter.getParent(element_p);
      }
    }
    return parent;
  }

  /**
   * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
   */
  public boolean hasChildren(Object element_p) {
    boolean hasChildren = false;
    // If given argument is a NamedModelElementWithId, let's use the EMF adapter accordingly.
    if (element_p instanceof NamedModelElementWithId) {
      hasChildren = _adapterFactoryContentProvider.hasChildren(element_p);
    } else {
      // Try to find an adapter from the platform adapters mechanism.
      IWorkbenchAdapter adapter = ElementAdapterFactory.getWorkbenchAdapter(element_p);
      if (null != adapter) {
        hasChildren = (adapter.getChildren(element_p).length > 0) ? true : false;
      }
    }
    return hasChildren;
  }

  /**
   * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
   */
  public Object[] getElements(Object inputElement_p) {
    Object[] elements = IUiCommonConstants.NO_ELEMENT;
    // If given argument is a NamedModelElementWithId, let's use the EMF adapter accordingly.
    if (inputElement_p instanceof NamedModelElementWithId) {
      elements = _adapterFactoryContentProvider.getElements(inputElement_p);
    } else {
      // Try to find an adapter from the platform adapters mechanism.
      IWorkbenchAdapter adapter = ElementAdapterFactory.getWorkbenchAdapter(inputElement_p);
      if (null != adapter) {
        elements = adapter.getChildren(inputElement_p);
      }
    }
    return elements;
  }

  /**
   * @see org.eclipse.jface.viewers.IContentProvider#dispose()
   */
  public void dispose() {
    _adapterFactoryContentProvider.dispose();
  }

  /**
   * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
   */
  public void inputChanged(Viewer viewer_p, Object oldInput_p, Object newInput_p) {
    // At first call, keep some data for later use.
    if (null == _viewer) {
      _viewer = (AbstractTreeViewer) viewer_p;
      _initialInput = newInput_p;
    } else if ((oldInput_p == _initialInput) && (null != newInput_p)) {
      // initial input has changed.
      _initialInput = newInput_p;
    }
    _adapterFactoryContentProvider.inputChanged(viewer_p, oldInput_p, newInput_p);
  }

  /**
   * Return the viewer that this content provider is running for.
   * @return the viewer
   */
  protected AbstractTreeViewer getViewer() {
    return _viewer;
  }

  /**
   * Return the initial input object.
   * @return the initialInput
   */
  protected Object getInitialInput() {
    return _initialInput;
  }

}