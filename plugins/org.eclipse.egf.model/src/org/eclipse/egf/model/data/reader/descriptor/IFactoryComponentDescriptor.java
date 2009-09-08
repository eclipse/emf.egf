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
 * Describe the content of a factory component read from an {@link IFactoryComponentReader} instance.
 * @author fournier
 */
public interface IFactoryComponentDescriptor extends ITypedDescriptor {
  /**
   * Get the factory component name.
   * @return
   */
  public String getName();

  /**
   * Get the domain path.
   * @return
   */
  public String getDomainPath();

  /**
   * Get the contract id.
   * @return
   */
  public String getContractId();

  /**
   * Get the production plan id.
   * @return
   */
  public String getProductionPlanId();
}
