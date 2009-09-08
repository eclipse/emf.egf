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

import java.util.List;

/**
 * Describe the content of a contract read from an {@link IFactoryComponentReader} instance.
 * @author fournier
 */
public interface IContractDescriptor extends ITypedDescriptor {
  /**
   * Get the contract element descriptors.
   * @return the contractElementDescriptors
   */
  public List<IContractElementDescriptor> getContractElementDescriptors();
}
