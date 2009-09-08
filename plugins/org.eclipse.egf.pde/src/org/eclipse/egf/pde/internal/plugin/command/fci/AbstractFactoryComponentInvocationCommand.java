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
package org.eclipse.egf.pde.internal.plugin.command.fci;

import org.eclipse.egf.core.extensionpoint.IFactoryComponentInvocationConstants;
import org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand;


/**
 * Base class to implement command that deal with factoryComponentInvocation extension-point.
 * @author fournier
 */
public abstract class AbstractFactoryComponentInvocationCommand extends AbstractExtensionChangesCommand {
  /**
   * FactoryComponent configuration id value.
   */
  private String _factoryComponentInvocationId;

  /**
   * Constructor.
   * @param factoryComponentInvocationId_p
   */
  protected AbstractFactoryComponentInvocationCommand(String factoryComponentInvocationId_p) {
    _factoryComponentInvocationId = factoryComponentInvocationId_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionChildName()
   */
  @Override
  protected String getExtensionChildName() {
    return IFactoryComponentInvocationConstants.FACTORY_COMPONENT_INVOCATION_EXTENSION_CHILD;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionPointId()
   */
  @Override
  protected String getExtensionPointId() {
    return IFactoryComponentInvocationConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID;
  }

  /**
   * Get the factory component invocation id.
   * @return
   */
  protected String getFactoryComponentInvocationId() {
    return _factoryComponentInvocationId;
  }
}