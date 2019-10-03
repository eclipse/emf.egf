/**
 * <copyright>
 * 
 * Copyright (c) 2011 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.portfolio.task.acceleo3.engine;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.ftask.task.ITaskNature;
import org.eclipse.egf.portfolio.task.acceleo3.Activator;
import org.eclipse.egf.portfolio.task.acceleo3.Messages;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * Represents a new Acceleo Task Nature.
 * @author Florian Barbin 
 * 
 */
public class Acceleo3TaskNature implements ITaskNature {

	public void invoke(Bundle bundle, ITaskProductionContext context,
			Task task, IProgressMonitor monitor) throws InvocationException {
		if (task == null || task.getImplementationValue() == null) {
            return;
        }
        String value = task.getImplementationValue().trim();
        Acceleo3ScriptEngine engine = new Acceleo3ScriptEngine();
        try {
            SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(Messages.Production_TaskAcceleo3_Invoke, value), 300);
            engine.executeAcceleo3Task(value, context, subMonitor);
        } catch (Exception e) {
            throw new InvocationException(new CoreException(Activator.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, value, bundle.getSymbolicName()), e)));
        }

	}

	public boolean isLoadableImplementation(Task task,
			Map<Object, Object> context) {
		return true;
	}

	public boolean isValidImplementation(Task task, Map<Object, Object> context) {
		return true;
	}

}
