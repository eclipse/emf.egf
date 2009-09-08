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

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.ui.resource.BasicImageRegistry;
import org.eclipse.egf.core.data.helper.DataHelper;
import org.eclipse.egf.core.ui.data.ElementAdapterFactory;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.ui.navigator.IDescriptionProvider;


/**
 * Base class to implement EMF adapters-based label provider.
 * @author fournier
 */
public class AdaptedModelElementLabelProvider implements ILabelProvider, IDescriptionProvider {
  /**
   * EMF adapters-base label provider.
   */
  private AdapterFactoryLabelProvider _adapterFactoryLabelProvider;

  /**
   * @param adapterFactoryLabelProvider_p
   */
  public AdaptedModelElementLabelProvider(AdapterFactory adapterFactory_p) {
    // Initialize EMF label provider.
    _adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(adapterFactory_p);
  }

  /**
   * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
   */
  public Image getImage(Object element_p) {
    Image result = null;
    // If given argument is a NamedModelElementWithId, let's use the EMF adapter accordingly.
    if (element_p instanceof NamedModelElementWithId) {
      result = _adapterFactoryLabelProvider.getImage(element_p);
    } else {
      // Try to find an adapter from the platform adapters mechanism.
      IWorkbenchAdapter adapter = ElementAdapterFactory.getWorkbenchAdapter(element_p);
      // If one exists, get the image from it.
      if (null != adapter) {
        // Get the image descriptor.
        ImageDescriptor descriptor = adapter.getImageDescriptor(element_p);
        // If existing, try to get an image from it.
        if (null != descriptor) {
          // Get the image from the registry to avoid multiple instances.
          result = BasicImageRegistry.getInstance().getImage(descriptor);
        }
      }
    }
    return result;
  }

  /**
   * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
   */
  public String getText(Object element_p) {
    // Returned text must be not null.
    String text = ICommonConstants.EMPTY_STRING;
    // If given argument is a NamedModelElementWithId, let's use the EMF adapter accordingly.
    if (element_p instanceof NamedModelElementWithId) {
      text = _adapterFactoryLabelProvider.getText(element_p);
    } else {
      // Try to find an adapter from the platform adapters mechanism.
      IWorkbenchAdapter adapter = ElementAdapterFactory.getWorkbenchAdapter(element_p);
      if (null != adapter) {
        text = adapter.getLabel(element_p);
      }
    }
    return text;
  }

  /**
   * @see org.eclipse.ui.navigator.IDescriptionProvider#getDescription(java.lang.Object)
   */
  public String getDescription(Object element_p) {
    String description = null;
    if (element_p instanceof NamedModelElementWithId) {
      description = DataHelper.getDescription((NamedModelElementWithId) element_p);
      if (null != description) {
        // Replace line separator with white space character. The status line is not able to display multi-lines comment.
        description = description.replace(ICommonConstants.LINE_SEPARATOR, String.valueOf(ICommonConstants.WHITE_SPACE_CHARACTER));
        // Replace EOL character with white space character. The status line is not able to display multi-lines comment.
        description = description.replace(ICommonConstants.EOL_CHARACTER, ICommonConstants.WHITE_SPACE_CHARACTER);
      }
    }
    return description;
  }

  /**
   * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
   */
  public void addListener(ILabelProviderListener listener_p) {
    _adapterFactoryLabelProvider.addListener(listener_p);
  }

  /**
   * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
   */
  public void dispose() {
    _adapterFactoryLabelProvider.dispose();
  }

  /**
   * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
   */
  public boolean isLabelProperty(Object element_p, String property_p) {
    return _adapterFactoryLabelProvider.isLabelProperty(element_p, property_p);
  }

  /**
   * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
   */
  public void removeListener(ILabelProviderListener listener_p) {
    _adapterFactoryLabelProvider.removeListener(listener_p);
  }
}
