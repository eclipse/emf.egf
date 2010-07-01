/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.task.internal.nature;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.ftask.task.ITaskNature;
import org.osgi.framework.Bundle;

/**
 * @author Thomas Guiu
 * 
 */
public class TaskNatureRuby implements ITaskNature {

    public void invoke(Bundle bundle, ITaskProductionContext context, Task task, IProgressMonitor monitor) throws InvocationException {
        ITaskProduction taskImpl = null;
        if (task == null || task.getImplementationValue() == null) {
            return;
        }
        String value = task.getImplementationValue().trim();

        // TODO run the interpreter with the parameters given by the contracts
        // values.
        // TODO give the input value to the process and get back the return
        // values (if any)
    }

    public boolean isLoadableImplementation(Task task, Map<Object, Object> context) {
        return true;
    }

    public boolean isValidImplementation(Task task, Map<Object, Object> context) {
        return false;
    }

}
