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
import org.eclipse.egf.model.data.reader.descriptor.IProductionPlanDescriptor;


/**
 * Describe the content of a production plan read from an {@link IFactoryComponentReader} instance.
 * @author fournier
 */
public class ProductionPlanDescriptor extends AbstractDescriptor implements IProductionPlanDescriptor {
  private List<String> _fcInvocationIds;
  private String _contextId;

  /**
   * Constructor.
   */
  public ProductionPlanDescriptor() {
    this(null);
  }

  /**
   * Constructor.
   * @param reader_p
   */
  public ProductionPlanDescriptor(IFactoryComponentReader reader_p) {
    super(reader_p);
    _fcInvocationIds = new ArrayList<String>(0);
  }

  /**
   * Add given factory component invocation id.
   * @param fcInvocationId_p
   */
  public void addFactoryComponentInvocationId(String fcInvocationId_p) {
    _fcInvocationIds.add(fcInvocationId_p);
  }

  /**
   * Get factory component invocation id list.
   * @return the factoryComponentInvocationIds
   */
  public List<String> getFactoryComponentInvocationIds() {
    return _fcInvocationIds;
  }

  /**
   * Get the context id.
   * @return the contextId
   */
  public String getContextId() {
    return _contextId;
  }

  /**
   * Set the specified context id.
   * @param contextId_p the contextId to set
   */
  public void setContextId(String contextId_p) {
    _contextId = contextId_p;
  }
}
