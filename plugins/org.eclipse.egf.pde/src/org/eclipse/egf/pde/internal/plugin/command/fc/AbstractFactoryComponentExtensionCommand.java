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
package org.eclipse.egf.pde.internal.plugin.command.fc;

import org.eclipse.egf.core.extensionpoint.IFactoryComponentConstants;
import org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand;

/**
 * Base class to implement commands that deal with FactoryComponent extension-point.
 * @author fournier
 */
public class AbstractFactoryComponentExtensionCommand extends AbstractExtensionChangesCommand {
  /**
   * FactoryComponent id value.
   */
  private String _factoryComponentId;

  /**
   * Constructor.
   * @param factoryComponentId_p
   */
  protected AbstractFactoryComponentExtensionCommand(String factoryComponentId_p) {
    _factoryComponentId = factoryComponentId_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionChildName()
   */
  @Override
  protected String getExtensionChildName() {
    return IFactoryComponentConstants.FACTORY_COMPONENT_EXTENSION_CHILD;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionPointId()
   */
  @Override
  protected String getExtensionPointId() {
    return IFactoryComponentConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID;
  }

  /**
   * Get the factory component id.
   * @return
   */
  protected String getFactoryComponentId() {
    return _factoryComponentId;
  }
}