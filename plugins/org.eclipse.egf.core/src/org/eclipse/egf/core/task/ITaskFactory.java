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
package org.eclipse.egf.core.task;

/**
 * A task factory provides a method to create a task.
 * @author fournier
 */
public interface ITaskFactory {
  /**
   * Create a task that performs a concrete processing.
   * @return a not null {@link AbstractTask} instance.
   */
  public AbstractTask createTask();
}
