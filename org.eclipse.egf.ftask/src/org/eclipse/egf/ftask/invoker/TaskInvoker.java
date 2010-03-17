/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.ftask.invoker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.Activator;
import org.eclipse.egf.ftask.Messages;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.ftask.Task;
import org.osgi.framework.Bundle;

/**
 * @author Thomas Guiu
 * 
 */
public interface TaskInvoker {

  // TODO pas sur que le ctx en ITaskProductionContext soit une bonne idee
  void invoke(Bundle bundle, ITaskProductionContext context, Task task, IProgressMonitor monitor) throws InvocationException;

  String getKind();

  String EXTENSION_ID = "org.eclipse.egf.ftask.invoker"; //$NON-NLS-1$

  class Helper {

    public List<String> getAvailableKinds() {
      return new ArrayList<String>(kind2invokers.keySet());
    }

    public TaskInvoker getInvoker(Task task) throws InvocationException {
      TaskInvoker taskInvoker = kind2invokers.get(task.getKind());
      if (taskInvoker == null) {
        throw new InvocationException(Messages.bind(Messages.missing_invoker_message, task.getKind()));
      }
      return taskInvoker;
    }

    private Helper() {
      for (IConfigurationElement element : Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID)) {
        try {
          TaskInvoker contributor = (TaskInvoker) element.createExecutableExtension("class"); //$NON-NLS-1$
          kind2invokers.put(contributor.getKind(), contributor);
        } catch (CoreException e) {
          Activator.getDefault().logError(e);
        }
      }

    }

    private final Map<String, TaskInvoker> kind2invokers = new HashMap<String, TaskInvoker>();
  }

  Helper HELPER = new Helper();
}
