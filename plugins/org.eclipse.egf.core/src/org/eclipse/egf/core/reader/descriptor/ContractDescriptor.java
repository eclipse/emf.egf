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
package org.eclipse.egf.core.reader.descriptor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader;
import org.eclipse.egf.model.data.reader.descriptor.IContractDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IContractElementDescriptor;


/**
 * Describe the content of a contract read from an {@link IFactoryComponentReader} instance.
 * @author fournier
 */
public class ContractDescriptor extends AbstractDescriptor implements IContractDescriptor {
  private List<IContractElementDescriptor> _contractElementDescriptors;

  /**
   * Constructor.
   */
  public ContractDescriptor() {
    this(null);
  }

  /**
   * Constructor.
   * @param reader_p
   */
  public ContractDescriptor(IFactoryComponentReader reader_p) {
    super(reader_p);
    _contractElementDescriptors = new ArrayList<IContractElementDescriptor>(0);
  }

  /**
   * Get the contract element descriptors.
   * @return the contractElementDescriptors
   */
  public List<IContractElementDescriptor> getContractElementDescriptors() {
    return _contractElementDescriptors;
  }

  /**
   * Add given contract element descriptor.
   * @param contractElementDescriptor_p
   */
  public void addContractElementDescriptor(IContractElementDescriptor contractElementDescriptor_p) {
    _contractElementDescriptors.add(contractElementDescriptor_p);
  }
}
