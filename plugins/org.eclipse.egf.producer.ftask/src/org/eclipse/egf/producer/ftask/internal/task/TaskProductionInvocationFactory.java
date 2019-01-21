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
package org.eclipse.egf.producer.ftask.internal.task;

import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.producer.ftask.internal.invocation.TaskProductionInvocation;
import org.eclipse.egf.producer.ftask.invocation.ITaskProductionInvocation;
import org.eclipse.egf.producer.ftask.task.ITaskProductionInvocationFactory;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskProductionInvocationFactory implements ITaskProductionInvocationFactory {

    public ITaskProductionInvocation createInvocation(Bundle bundle, ITaskProductionContext context, Task taskJava) {
        return new TaskProductionInvocation(bundle, context, taskJava);
    }

}
