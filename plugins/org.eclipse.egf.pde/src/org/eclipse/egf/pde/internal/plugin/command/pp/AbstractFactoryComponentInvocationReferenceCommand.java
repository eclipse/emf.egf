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
package org.eclipse.egf.pde.internal.plugin.command.pp;

import org.eclipse.egf.common.helper.ExtensionPointHelper;

/**
 * @author fournier
 */
public abstract class AbstractFactoryComponentInvocationReferenceCommand extends AbstractProductionPlanCommand {
  /**
   * FactoryComponentInvocation id value.
   */
  private String _factoryComponentInvocationId;

  protected AbstractFactoryComponentInvocationReferenceCommand(String productionPlanId_p, String factoryComponentInvocationId_p) {
    super(productionPlanId_p);
    _factoryComponentInvocationId = factoryComponentInvocationId_p;
  }

  /**
   * Get the id attribute for the FactoryComponentInvocation child.
   * @return
   */
  protected String getIdAttribute() {
    return ExtensionPointHelper.ATT_ID;
  }

  /**
   * Get the value of the FactoryComponentInvocation id attribute.
   * @return
   */
  protected String getIdAttributeValue() {
    return _factoryComponentInvocationId;
  }
}
