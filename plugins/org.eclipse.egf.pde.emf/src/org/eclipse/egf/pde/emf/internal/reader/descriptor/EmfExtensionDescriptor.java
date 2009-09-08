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
package org.eclipse.egf.pde.emf.internal.reader.descriptor;

import org.eclipse.egf.common.descriptor.GenericDescriptor;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.pde.emf.reader.descriptor.IEmfExtensionDescriptor;
import org.eclipse.emf.common.util.URI;


/**
 * @author brocard
 */
public class EmfExtensionDescriptor extends GenericDescriptor implements IEmfExtensionDescriptor {
  /**
   * Generated package data.
   */
  private Couple<String, URI> _generatedPackage;

  /**
   * @see org.eclipse.egf.pde.emf.reader.descriptor.IEmfExtensionDescriptor#getGeneratedPackage()
   */
  public Couple<String, URI> getGeneratedPackage() {
    return _generatedPackage;
  }

  /**
   * @param generatedPackage_p
   *          the generatedPackage to set
   */
  public void setGeneratedPackage(Couple<String, URI> generatedPackage_p) {
    _generatedPackage = generatedPackage_p;
  }
}
