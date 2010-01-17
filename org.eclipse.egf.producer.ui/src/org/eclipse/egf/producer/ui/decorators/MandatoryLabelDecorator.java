/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.producer.ui.decorators;

import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.IEGFCoreUIImages;
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

/**
 * Decorate ActivityContract with an overlay to enlight mandatory contract.
 * 
 * @author Xavier Maysonnave
 */
public class MandatoryLabelDecorator implements ILightweightLabelDecorator {

  private ImageDescriptor _mandatoryImage;

  /**
   * @see org.eclipse.jface.viewers.ILightweightLabelDecorator#decorate(java.lang.Object,
   *      org.eclipse.jface.viewers.IDecoration)
   */
  public void decorate(Object element, IDecoration decoration) {
    if (element instanceof ActivityContract) {
      ActivityContract contract = (ActivityContract) element;
      if (contract.isMandatory()) {
        decoration.addOverlay(getMandatoryImage());
      }
    }
  }

  /**
   * Return the image for the decoration that should be used to cue the user that a field is
   * required.
   * 
   * @return a not null image.
   */
  private ImageDescriptor getMandatoryImage() {
    if (_mandatoryImage == null) {
      _mandatoryImage = EGFCoreUIPlugin.getDefault().getImageDescriptor(IEGFCoreUIImages.IMG_MANDATORY);
    }
    return _mandatoryImage;
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
    _mandatoryImage = null;
  }

  /**
   * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object,
   *      java.lang.String)
   */
  public boolean isLabelProperty(Object element_p, String property_p) {
    return false;
  }

  /**
   * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
   */
  public void removeListener(ILabelProviderListener listener_p) {
    // Do nothing.
  }
}
