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
package org.eclipse.egf.fprod.producer.internal.context;

import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.fprod.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.egf.producer.context.IInvocationProductionContext;
import org.eclipse.egf.producer.internal.context.ActivityProductionContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskProductionContext extends ActivityProductionContext implements ITaskProductionContext {

  public TaskProductionContext(Task element, ProjectBundleSession projectBundleSession) {
    super(element, projectBundleSession);
  }

  public TaskProductionContext(IInvocationProductionContext parent, Task element, ProjectBundleSession projectBundleSession) {
    super(parent, element, projectBundleSession);
  }

  @Override
  public Task getElement() {
    return (Task) super.getElement();
  }

}
