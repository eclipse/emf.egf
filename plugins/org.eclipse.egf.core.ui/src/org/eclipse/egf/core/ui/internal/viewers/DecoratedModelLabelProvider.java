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

import org.eclipse.egf.core.ui.internal.data.AbstractUiContainer;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;


/**
 * Decorated label provider that handles {@link NamedModelElementWithId} and {@link AbstractUiContainer} objects.
 * @author Guillaume Brocard
 */
public class DecoratedModelLabelProvider implements ILabelProvider {
  /**
   * Delegated label provider.
   */
  private DecoratingLabelProvider _decoratingLabelProvider;

  /**
   * Constructor.
   */
  public DecoratedModelLabelProvider() {
    _decoratingLabelProvider = new DecoratingLabelProvider(new BasicLabelProvider(), PlatformUI.getWorkbench().getDecoratorManager());
  }

  /**
   * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
   */
  public Image getImage(Object element_p) {
    return _decoratingLabelProvider.getImage(element_p);
  }

  /**
   * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
   */
  public String getText(Object element_p) {
    return _decoratingLabelProvider.getText(element_p);
  }

  /**
   * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
   */
  public void addListener(ILabelProviderListener listener_p) {
    _decoratingLabelProvider.addListener(listener_p);
  }

  /**
   * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
   */
  public void dispose() {
    _decoratingLabelProvider.dispose();
  }

  /**
   * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
   */
  public boolean isLabelProperty(Object element_p, String property_p) {
    return _decoratingLabelProvider.isLabelProperty(element_p, property_p);
  }

  /**
   * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
   */
  public void removeListener(ILabelProviderListener listener_p) {
    _decoratingLabelProvider.removeListener(listener_p);
  }
}