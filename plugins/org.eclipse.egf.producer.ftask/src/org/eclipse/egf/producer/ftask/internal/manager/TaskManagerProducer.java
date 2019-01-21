/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.producer.ftask.internal.manager;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.ftask.FtaskPackage;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.producer.ftask.manager.TaskManagerFactory;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.egf.producer.manager.IModelElementManager;
import org.eclipse.emf.ecore.EClass;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskManagerProducer extends ActivityManagerProducer<Task> {

    @Override
    public EClass getActivity() {
        return FtaskPackage.Literals.TASK;
    }

    @Override
    protected IActivityManager<Task> doCreateActivityManager(Task task) throws InvocationException {
        return TaskManagerFactory.createProductionManager(task);
    }

    @Override
    protected IActivityManager<Task> doCreateActivityManager(Bundle bundle, Task task) throws InvocationException {
        return TaskManagerFactory.createProductionManager(bundle, task);
    }

    @Override
    protected <T extends Invocation> IActivityManager<Task> doCreateActivityManager(IModelElementManager<T, InvocationContract> parent, Task task) throws InvocationException {
        return TaskManagerFactory.createProductionManager(parent, task);
    }

}
