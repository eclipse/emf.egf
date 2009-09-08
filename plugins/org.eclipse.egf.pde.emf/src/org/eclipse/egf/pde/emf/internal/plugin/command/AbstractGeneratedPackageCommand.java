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
package org.eclipse.egf.pde.emf.internal.plugin.command;

import org.eclipse.egf.common.constant.IEMFConstants;
import org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand;


/**
 * Base class to implement commands that deal with the <code>org.eclipse.emf.ecore.generated_package</code> extension in plug-ins.
 * @author Guillaume Brocard
 */
public abstract class AbstractGeneratedPackageCommand extends AbstractExtensionChangesCommand {
  /**
   * An URI that uniquely identifies an Ecore package.
   */
  private String _uri;

  /**
   * Constructor.
   * @param uri_p An URI that uniquely identifies an Ecore package.
   */
  public AbstractGeneratedPackageCommand(String uri_p) {
    _uri = uri_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionChildName()
   */
  @Override
  protected String getExtensionChildName() {
    return IEMFConstants.GENERATED_PACKAGE_EXTENSION_POINT_CHILD;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionPointId()
   */
  @Override
  protected String getExtensionPointId() {
    return IEMFConstants.GENERATED_PACKAGE_EXTENSION_POINT_FULL_ID;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionChildIdAttribute()
   */
  @Override
  protected String getExtensionChildIdAttribute() {
    return IEMFConstants.GENERATED_PACKAGE_EXTENSION_POINT_ATT_URI;
  }

  /**
   * Get the URI.
   * @return a String that uniquely identifies an Ecore package.
   */
  protected String getUri() {
    return _uri;
  }
}
