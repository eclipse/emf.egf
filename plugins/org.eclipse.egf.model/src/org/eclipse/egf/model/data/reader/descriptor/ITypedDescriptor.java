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
package org.eclipse.egf.model.data.reader.descriptor;

import org.eclipse.egf.common.descriptor.IDescriptor;

/**
 * Interface to implement a typed descriptor.
 * @author fournier
 */
public interface ITypedDescriptor extends IDescriptor {
  /**
   * Get the descriptor identifier.
   * @return a not null string.
   */
  public String getId();

  /**
   * Get the description.
   * @return can be null.
   */
  public String getDescription();

  /**
   * Get the factory component reader that creates this descriptor.
   * @return
   */
  public IFactoryComponentReader getFactoryComponentReader();
}
