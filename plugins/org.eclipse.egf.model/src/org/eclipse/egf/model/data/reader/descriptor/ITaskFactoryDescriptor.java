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
 * Describe the content of a task factory read from an {@link IFactoryComponentReader} instance.
 * @author fournier
 */
public interface ITaskFactoryDescriptor extends ITypedDescriptor {
  /**
   * Get the task factory instance.
   * @return null if the container factory component is located in the workspace.
   */
  public Object getTaskFactory();

  /**
   * Get the task factory class name.<br>
   * The task factory class name must be the same that the one got from the task factory instance (if existing).
   * @see #getTaskFactory()
   * @return fully qualified class name; can not be null.
   */
  public String getTaskFactoryClass();
}
