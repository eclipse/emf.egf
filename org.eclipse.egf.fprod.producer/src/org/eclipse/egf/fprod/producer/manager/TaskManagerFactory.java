/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.fprod.producer.manager;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.internal.manager.TaskManager;
import org.eclipse.egf.model.fprod.Task;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskManagerFactory {

  private TaskManagerFactory() {
    // Prevent Instantiation
  }

  public static ITaskManager createProductionManager(Task task) throws InvocationException {
    return new TaskManager(task);
  }

  public static ITaskManager createProductionManager(Bundle bundle, Task task) {
    return new TaskManager(bundle, task);
  }

}
