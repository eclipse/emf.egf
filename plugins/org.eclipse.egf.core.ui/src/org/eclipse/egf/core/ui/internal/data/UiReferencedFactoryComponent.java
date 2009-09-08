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
package org.eclipse.egf.core.ui.internal.data;

import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.edit.IImageKeys;
import org.eclipse.egf.model.provider.FactoryComponentEditPlugin;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.swt.graphics.Image;


/**
 * Define an UI container for referenced factory component used in a Contract.
 * @author fournier
 */
public class UiReferencedFactoryComponent extends AbstractUiContainer {
  /**
   * Underlying factory component.
   */
  private FactoryComponent _underlyingFactoryComponent;

  /**
   * Constructor.
   * @param uiReferencedFactoryComponentContainer_p
   * @param name_p
   */
  public UiReferencedFactoryComponent(UiReferencedFactoryComponentContainer uiReferencedFactoryComponentContainer_p, FactoryComponent fc_p) {
    super(uiReferencedFactoryComponentContainer_p);
    _underlyingFactoryComponent = fc_p;
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.data.AbstractUiContainer#getText()
   */
  @Override
  public String getText() {
    return _underlyingFactoryComponent.getName();
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.data.AbstractUiContainer#getImage()
   */
  @Override
  public Image getImage() {
    return ExtendedImageRegistry.INSTANCE.getImage(FactoryComponentEditPlugin.INSTANCE.getImage(IImageKeys.IMG_FACTORY_COMPONENT_ID));
  }

  /**
   * Return the underlying factory component.
   * @return
   */
  public FactoryComponent getFactoryComponent() {
    return _underlyingFactoryComponent;
  }
}
