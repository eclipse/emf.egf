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
package org.eclipse.egf.pde.emf.reader.descriptor;

import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.emf.common.util.URI;


/**
 * @author brocard
 */
public interface IEmfExtensionDescriptor extends IDescriptor {
  /**
   * Get generated package data as defined by emf generated package extension.
   * @return
   */
  public Couple<String, URI> getGeneratedPackage();
}
