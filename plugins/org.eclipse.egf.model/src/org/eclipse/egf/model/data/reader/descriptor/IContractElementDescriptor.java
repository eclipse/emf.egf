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

import org.eclipse.egf.model.contract.type.ITypeHolder;


/**
 * Describe the content of a contract element read from an {@link IFactoryComponentReader} instance.
 * @author fournier
 */
public interface IContractElementDescriptor extends ITypedDescriptor {
  /**
   * Get the contract element name.
   * @return
   */
  public String getContractElementName();

  /**
   * Get the type holder instance.
   * @return null if the container factory component is located in the workspace.
   */
  public ITypeHolder getTypeHolder();

  /**
   * Get the concrete type holder class name.<br>
   * @see #getTypeHolder()
   * @return fully qualified class name; can not be null.
   */
  public String getTypeHolderClassName();

  /**
   * Get the contract reference id list.
   * @return the contractReferenceIds
   */
  public List<String> getContractReferenceIds();

  /**
   * Returns whether or not the underlying contract element is mandatory.
   * @return
   */
  public boolean isMandatory();
}