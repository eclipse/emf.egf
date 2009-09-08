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
 * Describe the content of a factory component invocation read from an {@link IFactoryComponentReader} instance.
 * @author fournier
 */
public interface IFactoryComponentInvocationDescriptor extends ITypedDescriptor {
  /**
   * Get the factory component configuration name.
   */
  public String getName();
  /**
   * Get the referenced factory component id.
   * @return
   */
  public String getReferencedFactoryComponentId();

  /**
   * Get the task factory id.
   * @return
   */
  public String getTaskFactoryId();

  /**
   * Get the context id.
   * @return the contextId
   */
  public String getContextId();
}
