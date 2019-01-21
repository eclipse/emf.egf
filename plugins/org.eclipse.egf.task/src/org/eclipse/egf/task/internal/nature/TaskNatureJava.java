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

package org.eclipse.egf.task.internal.nature;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.ftask.task.ITaskNature;
import org.eclipse.egf.model.helper.ValidationHelper;
import org.eclipse.egf.task.EGFTaskPlugin;
import org.eclipse.egf.task.l10n.EGFTaskMessages;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Thomas Guiu
 * 
 */
public class TaskNatureJava implements ITaskNature {

    public void invoke(Bundle bundle, ITaskProductionContext context, Task task, IProgressMonitor monitor) throws InvocationException {
        ITaskProduction taskImpl = null;
        if (task == null || task.getImplementationValue() == null) {
            return;
        }
        String value = task.getImplementationValue().trim();
        try {
            taskImpl = (ITaskProduction) BundleHelper.instantiate(value, bundle);
        } catch (Exception e) {
            throw new InvocationException(new CoreException(EGFTaskPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, value, bundle.getSymbolicName()), e)));
        }
        SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFTaskMessages.Production_TaskJava_Invoke, value), 300);
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
        if (context == null || context.get(IEGFModelConstants.VALIDATE_TYPES) == Boolean.FALSE) {
            return true;
        }
        if (ValidationHelper.isValidClass(task, ITaskProduction.class, task.getImplementationValue(), context)) {
            return true;
        }
        return false;
    }

}
