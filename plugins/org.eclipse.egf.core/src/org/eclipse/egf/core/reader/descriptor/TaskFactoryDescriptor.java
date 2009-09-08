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

import org.eclipse.egf.core.task.ITaskFactory;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader;
import org.eclipse.egf.model.data.reader.descriptor.ITaskFactoryDescriptor;


/**
 * Describe the content of a task factory read from an {@link IFactoryComponentReader} instance.
 * @author fournier
 */
public class TaskFactoryDescriptor extends AbstractDescriptor implements ITaskFactoryDescriptor {
  /**
   * Task factory instance.
   */
  private ITaskFactory _taskFactory;

  /**
   * Fully qualified concrete task factory class name. Must be the same that the one contained in ITaskFactory instance.
   */
  private String _taskFactoryClass;

  /**
   * Constructor.
   */
  public TaskFactoryDescriptor() {
    this(null);
  }

  /**
   * Constructor.
   * @param reader_p
   */
  public TaskFactoryDescriptor(IFactoryComponentReader reader_p) {
    super(reader_p);
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.ITaskFactoryDescriptor#getTaskFactory()
   */
  public ITaskFactory getTaskFactory() {
    return _taskFactory;
  }

  /**
   * Set given task factory.
   * @param taskFactory_p
   */
  public void setTaskFactory(ITaskFactory taskFactory_p) {
    _taskFactory = taskFactory_p;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.ITaskFactoryDescriptor#getTaskFactoryClass()
   */
  public String getTaskFactoryClass() {
    return _taskFactoryClass;
  }

  /**
   * Set given class name.
   * @param taskFactoryClass_p fully qualified class name.
   */
  public void setTaskFactoryClass(String taskFactoryClass_p) {
    _taskFactoryClass = taskFactoryClass_p;
  }

}
