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

import org.eclipse.egf.core.platform.pde.IFactoryComponentConstants;

import org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand;
import org.eclipse.emf.common.util.URI;

/**
 * Base class to implement commands that deal with FactoryComponent extension-point.
 * @author fournier
 */
public class AbstractFactoryComponentExtensionCommand extends AbstractExtensionChangesCommand {
  
  /**
   * FactoryComponent URI.
   */
  private URI _factoryComponentURI;

  /**
   * Constructor.
   * @param factoryComponentURI_p
   */
  protected AbstractFactoryComponentExtensionCommand(URI factoryComponentURI_p) {
    _factoryComponentURI = factoryComponentURI_p;
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
   * Get the Factory Component URI.
   * @return
   */
  protected URI getFactoryComponentURI() {
    return _factoryComponentURI;
  }
  
}