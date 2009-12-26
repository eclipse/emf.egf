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
package org.eclipse.egf.fprod.producer.activity;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.internal.manager.TaskManagerFactory;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fprod.FprodFactory;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.egf.producer.activity.ActivityProducer;
import org.eclipse.egf.producer.manager.IModelElementProducerManager;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskProducer extends ActivityProducer {

  private static final Task __task = FprodFactory.eINSTANCE.createTask();

  private final TaskManagerFactory _manager = new TaskManagerFactory();

  @Override
  public Task getActivity() {
    return __task;
  }

  @Override
  protected IModelElementProducerManager doCreateManager(Activity activity) throws InvocationException {
    return _manager.createProductionManager((Task) activity);
  }

  @Override
  protected IModelElementProducerManager doCreateManager(Bundle bundle, Activity activity) throws InvocationException {
    return _manager.createProductionManager(bundle, (Task) activity);
  }

}
