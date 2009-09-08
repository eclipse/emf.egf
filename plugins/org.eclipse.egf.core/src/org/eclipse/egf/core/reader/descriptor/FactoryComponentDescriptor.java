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

import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader;

/**
 * Describe the content of a factory component read from an {@link IFactoryComponentReader} instance.
 * @author fournier
 */
public class FactoryComponentDescriptor extends AbstractDescriptor implements IFactoryComponentDescriptor {
  private String _name;
  private String _domainPath;
  private String _contractId;
  private String _productionPlanId;

  /**
   * Constructor.
   */
  public FactoryComponentDescriptor() {
    this(null);
  }

  /**
   * Constructor.
   * @param reader_p
   */
  public FactoryComponentDescriptor(IFactoryComponentReader reader_p) {
    super(reader_p);
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentDescriptor#getName()
   */
  public String getName() {
    return _name;
  }

  /**
   * Set factory component name.
   * @param name_p the name to set
   */
  public void setName(String name_p) {
    _name = name_p;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentDescriptor#getDomainPath()
   */
  public String getDomainPath() {
    return _domainPath;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentDescriptor#getContractId()
   */
  public String getContractId() {
    return _contractId;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentDescriptor#getProductionPlanId()
   */
  public String getProductionPlanId() {
    return _productionPlanId;
  }

  /**
   * @param domainPath_p
   */
  public void setDomainPath(String domainPath_p) {
    _domainPath = domainPath_p;
  }

  /**
   * Set given contract id.
   * @param contractId_p
   */
  public void setContractId(String contractId_p) {
    _contractId = contractId_p;
  }

  /**
   * Set given production plan id.
   * @param productionPlanId_p
   */
  public void setProductionPlanId(String productionPlanId_p) {
    _productionPlanId = productionPlanId_p;
  }
}
