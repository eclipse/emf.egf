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

import org.eclipse.egf.model.contract.type.ITypeHolder;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader;
import org.eclipse.egf.model.data.reader.descriptor.IContractElementDescriptor;


/**
 * Describe the content of a contract element read from an {@link IFactoryComponentReader} instance.
 * @author fournier
 */
public class ContractElementDescriptor extends AbstractDescriptor implements IContractElementDescriptor {
  private String _contractElementName;
  private List<String> _contractReferenceIds;
  private boolean _isMandatory;

  /**
   * Type holder instance.
   */
  private ITypeHolder _typeHolder;
  /**
   * Fully qualified type holder class name.
   */
  private String _typeHolderClassName;

  /**
   * Constructor.
   */
  public ContractElementDescriptor() {
    this(null);
  }

  /**
   * Constructor.
   * @param reader_p
   */
  public ContractElementDescriptor(IFactoryComponentReader reader_p) {
    super(reader_p);
    _contractReferenceIds = new ArrayList<String>(0);
  }

  /**
   * Get the contract element name.
   * @return
   */
  public String getContractElementName() {
    return _contractElementName;
  }

  /**
   * Set given contract element name.
   * @param contractElementName_p
   */
  public void setContractElementName(String contractElementName_p) {
    _contractElementName = contractElementName_p;
  }

  /**
   * Get the type holder.
   * @return
   */
  public ITypeHolder getTypeHolder() {
    return _typeHolder;
  }

  /**
   * Set given type holder.
   * @param typeHolder_p
   */
  public void setTypeHolder(ITypeHolder typeHolder_p) {
    _typeHolder = typeHolder_p;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IContractElementDescriptor#getTypeHolderClassName()
   */
  public String getTypeHolderClassName() {
    return _typeHolderClassName;
  }

  /**
   * Set type holder fully qualified class name.
   * @param typeHolderClassName_p fully qualified class name.
   */
  public void setTypeHolderClassName(String typeHolderClassName_p) {
    _typeHolderClassName = typeHolderClassName_p;
  }

  /**
   * Get the contract reference id list.
   * @return the contractReferenceIds
   */
  public List<String> getContractReferenceIds() {
    return _contractReferenceIds;
  }

  /**
   * Add given contractReference id.
   * @param contractReferenceId_p
   */
  public void addContractReferenceId(String contractReferenceId_p) {
    _contractReferenceIds.add(contractReferenceId_p);
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IContractElementDescriptor#isMandatory()
   */
  public boolean isMandatory() {
    return _isMandatory;
  }

  /**
   * Set the mandatory value.
   * @param isMandatory_p the mandatory value to set.
   */
  public void setMandatory(boolean isMandatory_p) {
    _isMandatory = isMandatory_p;
  }
}