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

package org.eclipse.egf.task.internal.hook;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.ftask.task.TaskHook;
import org.eclipse.egf.model.helper.ValidationHelper;
import org.eclipse.egf.task.EGFTaskPlugin;
import org.eclipse.egf.task.l10n.EGFTaskMessages;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Thomas Guiu
 * 
 */
public class TaskJavaHook implements TaskHook {

    public void invoke(Bundle bundle, ITaskProductionContext context, Task task, IProgressMonitor monitor) throws InvocationException {
        ITaskProduction taskImpl = null;
        if (task == null || task.getImplementationValue() == null) {
            return;
        }
        try {
            taskImpl = (ITaskProduction) BundleHelper.instantiate(task.getImplementationValue().trim(), bundle);
        } catch (Exception e) {
            throw new InvocationException(NLS.bind(EGFTaskMessages.Production_TaskJava_InvocationException, task.getName() != null ? task.getName() : task), e);
        }
        SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFTaskMessages.Production_TaskJava_Invoke, task.getName()), 300);
        taskImpl.preExecute(context, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
        subMonitor.worked(100);
        if (subMonitor.isCanceled()) {
            throw new OperationCanceledException();
        }
        taskImpl.doExecute(context, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
        subMonitor.worked(100);
        if (subMonitor.isCanceled()) {
            throw new OperationCanceledException();
        }
        taskImpl.postExecute(context, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
        subMonitor.worked(100);
        if (subMonitor.isCanceled()) {
            throw new OperationCanceledException();
        }
    }

    public String getKind() {
        return EGFTaskPlugin.KIND_JAVA;
    }

    public boolean isLoadableImplementation(Task task, Map<Object, Object> context) {
        if (task == null) {
            return false;
        }
        if (ValidationHelper.isLoadableClass(task, task.getImplementationValue(), context)) {
            return true;
        }
        return false;
    }

    public boolean isValidImplementation(Task task, Map<Object, Object> context) {
        if (task == null) {
            return false;
        }
        if (ValidationHelper.isValidClass(task, ITaskProduction.class, task.getImplementationValue(), context)) {
            return true;
        }
        return false;
    }

}
