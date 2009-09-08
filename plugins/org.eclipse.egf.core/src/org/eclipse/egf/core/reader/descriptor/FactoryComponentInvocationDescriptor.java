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

import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentInvocationDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader;

/**
 * Describe the content of an factory component invocation read from an {@link IFactoryComponentReader} instance.
 * @author fournier
 */
public class FactoryComponentInvocationDescriptor extends AbstractDescriptor implements IFactoryComponentInvocationDescriptor {
  private String _name;
  private String _referencedFactoryComponentId;
  private String _taskFactoryId;
  private String _contextId;

  /**
   * Constructor.
   */
  public FactoryComponentInvocationDescriptor() {
    this(null);
  }

  /**
   * Constructor.
   * @param reader_p
   */
  public FactoryComponentInvocationDescriptor(IFactoryComponentReader reader_p) {
    super(reader_p);
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentInvocationDescriptor#getName()
   */
  public String getName() {
    return _name;
  }

  /**
   * Get the referenced factory component id.
   * @return
   */
  public String getReferencedFactoryComponentId() {
    return _referencedFactoryComponentId;
  }

  /**
   * Get the task factory id.
   * @return
   */
  public String getTaskFactoryId() {
    return _taskFactoryId;
  }

  /**
   * Get the context id.
   * @return the contextId
   */
  public String getContextId() {
    return _contextId;
  }

  /**
   * Set given factory component invocation name.
   * @param fcInvocationName_p
   */
  public void setName(String fcInvocationName_p) {
    _name = fcInvocationName_p;
  }

  /**
   * Set given referenced factory component id.
   * @param referencedFcId_p
   */
  public void setReferencedFactoryComponentId(String referencedFcId_p) {
    _referencedFactoryComponentId = referencedFcId_p;
  }

  /**
   * Set given task factory id.
   * @param taskFactoryId_p
   */
  public void setTaskFactoryId(String taskFactoryId_p) {
    _taskFactoryId = taskFactoryId_p;
  }

  /**
   * Set given context id.
   * @param contextId_p
   */
  public void setContextId(String contextId_p) {
    _contextId = contextId_p;
  }
}
