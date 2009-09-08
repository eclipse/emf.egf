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

import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader;
import org.eclipse.egf.model.data.reader.descriptor.IContractElementReferenceDescriptor;

/**
 * Describe the content of a contract element reference read from an {@link IFactoryComponentReader} instance.
 * @author fournier
 */
public class ContractElementReferenceDescriptor extends AbstractDescriptor implements IContractElementReferenceDescriptor {
  private String _contractElementName;
  private String _contractElementId;
  private String _referencedFcId;

  /**
   * Constructor.
   */
  public ContractElementReferenceDescriptor() {
    this(null);
  }

  /**
   * Constructor.
   * @param reader_p
   */
  public ContractElementReferenceDescriptor(IFactoryComponentReader reader_p) {
    super(reader_p);
  }

  /**
   * Get the contract element id.
   * @return
   */
  public String getContractElementId() {
    return _contractElementId;
  }

  /**
   * Get the contract element name.
   * @deprecated
   * @return
   */
  public String getContractElementName() {
    return _contractElementName;
  }

  /**
   * Set given contract element id.
   * @param contractElementId_p
   */
  public void setContractElementId(String contractElementId_p) {
    _contractElementId = contractElementId_p;
  }

  /**
   * Set given contract element name.
   * @deprecated
   * @param contractElementName_p
   */
  public void setContractElementName(String contractElementName_p) {
    _contractElementName = contractElementName_p;
  }

  /**
   * Get the referenced factory component id.
   * @return
   */
  public String getReferencedFcId() {
    return _referencedFcId;
  }

  /**
   * Set given referenced factory component id.
   * @param referencedFcId_p
   */
  public void setReferencedFcId(String referencedFcId_p) {
    _referencedFcId = referencedFcId_p;
  }
}
