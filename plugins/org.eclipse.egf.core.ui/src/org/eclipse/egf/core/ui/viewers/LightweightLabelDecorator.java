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

import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.IImageKeys;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;


/**
 * Specific label provider that handle model element decoration.
 * @author Guillaume Brocard
 */
public class LightweightLabelDecorator implements ILightweightLabelDecorator {
  private ImageDescriptor _requiredImage;

  /**
   * @see org.eclipse.jface.viewers.ILightweightLabelDecorator#decorate(java.lang.Object, org.eclipse.jface.viewers.IDecoration)
   */
  public void decorate(Object element_p, IDecoration decoration_p) {
    // The plugin.xml (via decorator extension) define the enablement. 
    // Only the ContractElement model element is decorated.
    // Ensure that in checking given object type.
    if (element_p instanceof ContractElement) {
      ContractElement contractElement = (ContractElement) element_p;
      // Add an overlay if the contract element is mandatory.
      if (contractElement.isMandatory()) {
        decoration_p.addOverlay(getRequiredDecorationImage());
      }
    }
  }

  /**
   * Return the image for the decoration that should be used to cue the user that a field is required.
   * @return a not null image.
   */
  private ImageDescriptor getRequiredDecorationImage() {
    // Lazy loading pattern.
    if (null == _requiredImage) {
      _requiredImage = EgfUiActivator.getDefault().getImageDescriptor(IImageKeys.IMG_REQUIRED_FIELD_CUE);
    }
    return _requiredImage;
  }

  /**
   * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
   */
  public void addListener(ILabelProviderListener listener_p) {
    // Do nothing.
  }

  /**
   * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
   */
  public void dispose() {
    // Do nothing.
  }

  /**
   * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
   */
  public boolean isLabelProperty(Object element_p, String property_p) {
    // Do nothing.
    return false;
  }

  /**
   * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
   */
  public void removeListener(ILabelProviderListener listener_p) {
    // Do nothing.
  }
}
