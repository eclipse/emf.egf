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

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.ftask.task.ITaskNature;
import org.eclipse.egf.task.EGFTaskPlugin;
import org.eclipse.egf.task.engine.JRubyScriptEngine;
import org.eclipse.egf.task.l10n.EGFTaskMessages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Thomas Guiu
 * 
 */
public class TaskNatureRuby implements ITaskNature {

    public void invoke(Bundle bundle, ITaskProductionContext context, Task task, IProgressMonitor monitor) throws InvocationException {
        if (task == null || task.getImplementationValue() == null) {
            return;
        }

        String value = task.getImplementationValue().trim();
        // Get the interpreter library paths
        String loadInterpreterPath = ""; //$NON-NLS-1$

        // TODO acces to preference value in non-UI context
        // if
        // (!EGFTaskUIPlugin.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_BOOLEAN))
        // {
        // loadInterpreterPath =
        // EGFTaskUIPlugin.getDefault().getPreferenceStore().getString(PreferenceConstants.P_RUBY_LIBRARIES);
        // }
        JRubyScriptEngine engine = new JRubyScriptEngine(loadInterpreterPath);

        SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFTaskMessages.Production_TaskRuby_Invoke, value), 300);
        try {
            engine.executeRubyTask(value, context, subMonitor);
        } catch (IOException e) {
            throw new InvocationException(new CoreException(EGFTaskPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, value, bundle.getSymbolicName()), e)));
        }
    }

    public boolean isLoadableImplementation(Task task, Map<Object, Object> context) {
        return true;
    }

    public boolean isValidImplementation(Task task, Map<Object, Object> context) {
        boolean match = checkRubyImplementation(task.getImplementationValue().trim(), EGFTaskPlugin.KIND_RUBY);
        if (!match) {
            return false;
        }
        if (task == null) {
            return false;
        }
        if (context == null || context.get(IEGFModelConstants.VALIDATE_TYPES) == Boolean.FALSE) {
            return true;
        }
        return true;
    }

    /**
     * Check the whether the implementation is a file path.
     * 
     * @param implementation
     * @param kind
     * 
     * @return true: implementation is a file path./ false:implementation is
     *         not a file path.
     */
    public boolean checkRubyImplementation(String implementation, String kind) {
        if (implementation == null || implementation.isEmpty())
            return false;

        URI platformURI = URI.createURI(implementation);
        boolean isPlatformPlugin = platformURI.isPlatformPlugin();
        if ((kind.equals(EGFTaskPlugin.KIND_RUBY) && !isPlatformPlugin)) {
            return false;
        }

        Path path = new Path(platformURI.toPlatformString(true));
        IResource findMember = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
        if (findMember == null)
            return false;

        return true;
    }
}
