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

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.ftask.FtaskPackage;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.producer.context.ActivityProductionContextProducer;
import org.eclipse.emf.ecore.EClass;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskProductionContextProducer extends ActivityProductionContextProducer<Task> {

    @Override
    public EClass getActivity() {
        return FtaskPackage.Literals.TASK;
    }

    @Override
    protected ITaskProductionContext doCreateActivityProductionContext(ProjectBundleSession projectBundleSession, Activity activity) throws InvocationException {
        return ProducerFtaskContextFactory.createContext(projectBundleSession, (Task) activity);
    }

    @Override
    protected ITaskProductionContext doCreateActivityProductionContext(IProductionContext<Invocation, InvocationContract> parent, ProjectBundleSession projectBundleSession, Activity activity) throws InvocationException {
        return ProducerFtaskContextFactory.createContext(parent, projectBundleSession, (Task) activity);
    }

}
