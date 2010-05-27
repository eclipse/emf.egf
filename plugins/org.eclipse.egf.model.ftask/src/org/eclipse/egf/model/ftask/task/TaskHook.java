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
package org.eclipse.egf.model.ftask.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.EGFFtaskPlugin;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.ftask.l10n.EGFFtaskMessages;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Thomas Guiu
 * 
 */
public interface TaskHook {

    // TODO pas sur que le ctx en ITaskProductionContext soit une bonne idee
    public void invoke(Bundle bundle, ITaskProductionContext context, Task task, IProgressMonitor monitor) throws InvocationException;

    public String getKind();

    public boolean isLoadableImplementation(Task task, Map<Object, Object> context);

    public boolean isValidImplementation(Task task, Map<Object, Object> context);

    /**
     * Define a constant for the Task extension-point id.
     */
    public static String EXTENSION_ID = "org.eclipse.egf.model.ftask.task"; //$NON-NLS-1$

    /**
     * Define a constant for the 'class' attribute.
     */
    public static final String INVOKER_ATT_CLASS = "class"; //$NON-NLS-1$    

    class Helper {

        public List<String> getKinds() {
            return new ArrayList<String>(kind2hooks.keySet());
        }

        public TaskHook getHook(Task task) throws InvocationException {
            if (task == null) {
                throw new InvocationException(EGFFtaskMessages.missing_task_message);
            }
            if (task.getKindValue() == null || task.getKindValue().trim().length() == 0) {
                throw new InvocationException(NLS.bind(EGFFtaskMessages.missing_kind_message, EMFHelper.getText(task)));
            }
            TaskHook taskHook = kind2hooks.get(task.getKindValue().trim());
            if (taskHook == null) {
                throw new InvocationException(NLS.bind(EGFFtaskMessages.missing_hook_message, task.getKindValue().trim()));
            }
            return taskHook;
        }

        private Helper() {
            for (IConfigurationElement element : Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID)) {
                try {
                    // Extension retrieval
                    String extension = ExtensionPointHelper.getAttributeValue(element, INVOKER_ATT_CLASS);
                    // Ignore
                    if (extension == null || extension.trim().length() == 0) {
                        continue;
                    }
                    extension = extension.trim();
                    Object object = element.createExecutableExtension(INVOKER_ATT_CLASS);
                    if (object == null) {
                        continue;
                    }
                    if (object instanceof TaskHook == false) {
                        EGFFtaskPlugin.getPlugin().logError(NLS.bind("Wrong Class {0}", object.getClass().getName())); //$NON-NLS-1$
                        EGFFtaskPlugin.getPlugin().logInfo(NLS.bind("Class should be an implementation of ''{0}''.", TaskHook.class.getName()), 1); //$NON-NLS-1$
                        EGFFtaskPlugin.getPlugin().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(element)), 1); //$NON-NLS-1$
                        EGFFtaskPlugin.getPlugin().logInfo(NLS.bind("Extension-Point ''{0}''", element.getName()), 1); //$NON-NLS-1$
                        EGFFtaskPlugin.getPlugin().logInfo(NLS.bind("extension ''{0}''", extension), 1); //$NON-NLS-1$
                        continue;
                    }
                    TaskHook contributor = (TaskHook) object;
                    if (contributor.getKind() == null || contributor.getKind().trim().length() == 0) {
                        continue;
                    }
                    String kind = contributor.getKind().trim();
                    if (kind2hooks.get(kind) != null) {
                        EGFFtaskPlugin.getPlugin().logError(NLS.bind("Duplicate Kind ''{0}''", kind)); //$NON-NLS-1$
                        EGFFtaskPlugin.getPlugin().logInfo(NLS.bind("Extension-Point ''{0}''", element.getName()), 1); //$NON-NLS-1$
                        EGFFtaskPlugin.getPlugin().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(element)), 1); //$NON-NLS-1$            
                    }
                    kind2hooks.put(contributor.getKind(), contributor);
                } catch (CoreException e) {
                    EGFFtaskPlugin.getPlugin().logError(e);
                }
            }

        }

        private final Map<String, TaskHook> kind2hooks = new HashMap<String, TaskHook>();
    }

    Helper HELPER = new Helper();
}
