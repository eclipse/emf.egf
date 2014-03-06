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
package org.eclipse.egf.producer.ftask.internal.context;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.ftask.Task;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProducerFtaskContextFactory {

    private ProducerFtaskContextFactory() {
        // Prevent Instantiation
    }

    // Task

    public static ITaskProductionContext createContext(ProjectBundleSession projectBundleSession, Task element) {
        return new TaskProductionContext(projectBundleSession, element, EMFHelper.getText(element));
    }

    public static ITaskProductionContext createContext(IProductionContext<Invocation, InvocationContract> parent, ProjectBundleSession projectBundleSession, Task element) {
        return new TaskProductionContext(parent, projectBundleSession, element, EMFHelper.getText(element));
    }

}
