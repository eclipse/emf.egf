/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.ftask.producer.manager;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.internal.manager.TaskManager;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.egf.producer.manager.IModelElementManager;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskManagerFactory {

    private TaskManagerFactory() {
        // Prevent Instantiation
    }

    public static IActivityManager<Task> createProductionManager(Task Task) throws InvocationException {
        return new TaskManager(Task);
    }

    public static IActivityManager<Task> createProductionManager(Bundle bundle, Task Task) throws InvocationException {
        return new TaskManager(bundle, Task);
    }

    public static <T extends Invocation> IActivityManager<Task> createProductionManager(IModelElementManager<T, InvocationContract> parent, Task Task) throws InvocationException {
        return new TaskManager(parent, Task);
    }

}
