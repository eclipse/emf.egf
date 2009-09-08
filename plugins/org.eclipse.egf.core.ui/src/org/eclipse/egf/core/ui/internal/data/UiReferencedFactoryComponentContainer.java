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

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.ContractElement;
import org.eclipse.egf.model.data.helper.ModelHelper;


/**
 * Define an UI container for UI Referenced factory component used in a Contract.
 * @author fournier
 */
public class UiReferencedFactoryComponentContainer extends AbstractUiContainer {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(UiReferencedFactoryComponentContainer.class.getPackage().getName());
  private Map<FactoryComponent, UiReferencedFactoryComponent> _referencedFactoryComponentMap;

  /**
   * Constructor.
   * @param parent_p
   * @param children_p
   */
  public UiReferencedFactoryComponentContainer(ContractElement[] contractElements_p) {
    super(null);
    _referencedFactoryComponentMap = new HashMap<FactoryComponent, UiReferencedFactoryComponent>(0);
    // Loop over the list of contract elements to create UiReferencedFactoryComponents.
    for (ContractElement contractElement : contractElements_p) {
      // Get the factory component container of a contract element.
      FactoryComponent fc = ModelHelper.getFactoryComponentContainer(contractElement);
      // Get related UI referenced factory component.
      UiReferencedFactoryComponent uiReferencedFc = _referencedFactoryComponentMap.get(fc);
      // If not found, create it.
      if (null == uiReferencedFc) {
        uiReferencedFc = new UiReferencedFactoryComponent(this, fc);
        _referencedFactoryComponentMap.put(fc, uiReferencedFc);
      }
      // Add the contract element as a child of the UI referenced factory component.
      uiReferencedFc.addChild(contractElement);
    }
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.data.AbstractUiContainer#addChild(java.lang.Object)
   */
  @Override
  public boolean addChild(Object child_p) {
    boolean result = false;
    // Precondition
    if (!(child_p instanceof UiReferencedFactoryComponent)) {
      StringBuilder loggerMessage = new StringBuilder("UiReferencedFactoryComponentContainer.addChild(..) _ "); //$NON-NLS-1$
      loggerMessage.append("UiReferencedFactoryComponentContainer only accepts UiReferencedFactoryComponent as children"); //$NON-NLS-1$
      __logger.error(loggerMessage.toString());
      return result;
    }
    UiReferencedFactoryComponent uiReferencedFc = (UiReferencedFactoryComponent) child_p;
    _referencedFactoryComponentMap.put(uiReferencedFc.getFactoryComponent(), uiReferencedFc);
    result = true;
    return result;
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.data.AbstractUiContainer#isEmpty()
   */
  @Override
  public boolean isEmpty() {
    return _referencedFactoryComponentMap.isEmpty();
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.data.AbstractUiContainer#removeChild(java.lang.Object)
   */
  @Override
  public boolean removeChild(Object child_p) {
    boolean result = false;
    // Precondition
    if (!(child_p instanceof UiReferencedFactoryComponent)) {
      StringBuilder loggerMessage = new StringBuilder("UiReferencedFactoryComponentContainer.removeChild(..) _ "); //$NON-NLS-1$
      loggerMessage.append("UiReferencedFactoryComponentContainer only accepts UiReferencedFactoryComponent as children"); //$NON-NLS-1$
      __logger.error(loggerMessage.toString());
      return result;
    }
    UiReferencedFactoryComponent uiReferencedFc = (UiReferencedFactoryComponent) child_p;
    UiReferencedFactoryComponent removedElement = _referencedFactoryComponentMap.remove(uiReferencedFc.getFactoryComponent());
    // Ensure remove element is the same reference than given one.
    result = (uiReferencedFc == removedElement) ? true : false;
    return result;
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.data.AbstractUiContainer#getChildren()
   */
  @Override
  public Object[] getChildren() {
    return _referencedFactoryComponentMap.values().toArray(new UiReferencedFactoryComponent[_referencedFactoryComponentMap.size()]);
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.data.AbstractUiContainer#hasChildren()
   */
  @Override
  public boolean hasChildren() {
    return !_referencedFactoryComponentMap.isEmpty();
  }

  /**
   * Get the {@link UiReferencedFactoryComponent} for given factory component.
   * @param factoryComponent_p
   * @return
   */
  public UiReferencedFactoryComponent getUiReferencedFactoryComponent(FactoryComponent factoryComponent_p) {
    return _referencedFactoryComponentMap.get(factoryComponent_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.internal.data.AbstractUiContainer#getText()
   */
  @Override
  public String getText() {
    return ICommonConstants.EMPTY_STRING;
  }
}
