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

import org.eclipse.egf.model.Type;

/**
 * Describe the content of a context element read from an {@link IFactoryComponentReader} instance.
 * @author fournier
 */
public interface IContextElementDescriptor extends ITypedDescriptor {
  /**
   * Get the contract reference id.
   * @return can be null.
   */
  public String getContractReferenceId();

  /**
   * Set given contract reference id.
   * @param contractReferenceId_p
   */
  public void setContractReferenceId(String contractReferenceId_p);

  /**
   * Get the key
   * @return can be null.
   */
  public String getKey();

  /**
   * Get the readable value.
   * @return
   */
  public String getReadableValue();

  /**
   * Get value direct type.
   * @return
   */
  public Type getType();

  /**
   * Return the id of the plug-in that defines this context element description.
   * @return null if description is loaded from the workspace.
   */
  public String getPluginId();
}
