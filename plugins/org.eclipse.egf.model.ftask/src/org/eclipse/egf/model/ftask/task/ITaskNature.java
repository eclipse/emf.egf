/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.model.ftask.task;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.ftask.Task;
import org.osgi.framework.Bundle;

/**
 * @author Thomas Guiu
 * 
 */
public interface ITaskNature {

    // TODO pas sur que le ctx en ITaskProductionContext soit une bonne idee
    public void invoke(Bundle bundle, ITaskProductionContext context, Task task, IProgressMonitor monitor) throws InvocationException;

    public boolean isLoadableImplementation(Task task, Map<Object, Object> context);

    public boolean isValidImplementation(Task task, Map<Object, Object> context);

}
