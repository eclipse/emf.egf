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
package org.eclipse.egf.ftask.producer.internal.task;

import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.internal.invocation.TaskJavaProductionInvocation;
import org.eclipse.egf.ftask.producer.invocation.ITaskJavaProductionInvocation;
import org.eclipse.egf.ftask.producer.task.ITaskJavaProductionInvocationFactory;
import org.eclipse.egf.model.ftask.TaskJava;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskJavaProductionInvocationFactory implements ITaskJavaProductionInvocationFactory {

  public ITaskJavaProductionInvocation createInvocation(Bundle bundle, ITaskProductionContext context, TaskJava taskJava) {
    return new TaskJavaProductionInvocation(bundle, context, taskJava);
  }

}
