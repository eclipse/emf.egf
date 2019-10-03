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
package org.eclipse.egf.producer.ftask.internal.context;

import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.producer.internal.context.ActivityProductionContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskProductionContext extends ActivityProductionContext<Task> implements ITaskProductionContext {

    public TaskProductionContext(ProjectBundleSession projectBundleSession, Task element, String name) {
        super(projectBundleSession, element, name);
    }

    public TaskProductionContext(IProductionContext<Invocation, InvocationContract> parent, ProjectBundleSession projectBundleSession, Task element, String name) {
        super(parent, projectBundleSession, element, name);
    }

}
