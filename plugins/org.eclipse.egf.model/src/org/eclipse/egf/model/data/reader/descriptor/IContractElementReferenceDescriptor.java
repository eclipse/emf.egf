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

/**
 * Describe the content of a contract element reference read from an {@link IFactoryComponentReader} instance.
 * @author fournier
 */
public interface IContractElementReferenceDescriptor extends ITypedDescriptor {
  /**
   * Get the contract element id.
   * @return
   */
  public String getContractElementId();

  /**
   * Get the contract element name.
   * @deprecated
   * @return
   */
  public String getContractElementName();

  /**
   * Get the reference factory component id.
   * @return
   */
  public String getReferencedFcId();

  /**
   * Set given referenced factory component id.
   * @param referencedFcId_p
   */
  public void setReferencedFcId(String referencedFcId_p);
}
