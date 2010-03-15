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
package org.eclipse.egf.ftask.producer.internal.manager;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.manager.TaskManagerFactory;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.ftask.FtaskPackage;
import org.eclipse.egf.model.ftask.Task;
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
    protected IActivityManager<Task> doCreateActivityManager(Activity activity) throws InvocationException {
        return TaskManagerFactory.createProductionManager((Task) activity);
    }

    @Override
    protected IActivityManager<Task> doCreateActivityManager(Bundle bundle, Activity activity) throws InvocationException {
        return TaskManagerFactory.createProductionManager(bundle, (Task) activity);
    }

    @Override
    protected <T extends Invocation> IActivityManager<Task> doCreateActivityManager(IModelElementManager<T, InvocationContract> parent, Activity activity) throws InvocationException {
        return TaskManagerFactory.createProductionManager(parent, (Task) activity);
    }

}
