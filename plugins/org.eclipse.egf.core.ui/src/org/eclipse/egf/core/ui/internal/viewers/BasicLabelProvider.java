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

import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.internal.data.AbstractUiContainer;
import org.eclipse.egf.core.ui.viewers.AdaptedModelElementLabelProvider;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;


/**
 * Basic label provider that handles {@link NamedModelElementWithId} and {@link AbstractUiContainer} objects.
 * @author fournier
 */
public class BasicLabelProvider extends LabelProvider {
  /**
   * Label provider to use when given element is an instance of {@link NamedModelElementWithId}.
   */
  private ILabelProvider _adaptedLabelProvider;

  /**
   * Constructor.
   */
  public BasicLabelProvider() {
    _adaptedLabelProvider = new AdaptedModelElementLabelProvider(EgfUiActivator.getDefault().getEditingDomainInReadOnly().getAdapterFactory());
  }

  /**
   * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
   */
  @Override
  public String getText(Object element_p) {
    String result = null;
    if (element_p instanceof NamedModelElementWithId) {
      result = _adaptedLabelProvider.getText(element_p);
    } else if (element_p instanceof AbstractUiContainer) {
      result = ((AbstractUiContainer) element_p).getText();
    }
    return result;
  }

  /**
   * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
   */
  @Override
  public Image getImage(Object element_p) {
    Image result = null;
    if (element_p instanceof NamedModelElementWithId) {
      result = _adaptedLabelProvider.getImage(element_p);
    } else if (element_p instanceof AbstractUiContainer) {
      result = ((AbstractUiContainer) element_p).getImage();
    } else {
      result = super.getImage(element_p);
    }
    return result;
  }
}
