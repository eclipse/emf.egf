/*******************************************************************************
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.pde.internal.extension;

import org.eclipse.egf.core.fcore.IPlatformFcoreConstants;
import org.eclipse.egf.core.pde.plugin.AbstractExtensionChangesCommand;
import org.eclipse.emf.common.util.URI;

/**
 * Base class to implement commands that deal with 'fcore' extension-point.
 * 
 * @author fournier
 */
public class AbstractFcoreExtensionCommand extends AbstractExtensionChangesCommand {

  /**
   * Fcore URI.
   */
  private URI _uri;

  /**
   * Constructor.
   * 
   * @param factoryComponentURI_p
   */
  protected AbstractFcoreExtensionCommand(URI uri_p) {
    _uri = uri_p;
  }

  /**
   * @see org.eclipse.egf.core.pde.plugin.AbstractExtensionChangesCommand#getExtensionChildName()
   */
  @Override
  protected String getExtensionChildName() {
    return IPlatformFcoreConstants.FCORE_EXTENSION_CHILD;
  }

  /**
   * @see org.eclipse.egf.core.pde.plugin.AbstractExtensionChangesCommand#getExtensionPointId()
   */
  @Override
  protected String getExtensionPointId() {
    return IPlatformFcoreConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID;
  }

  /**
   * Get the Fcore URI.
   * 
   * @return
   */
  protected URI getURI() {
    return _uri;
  }

}