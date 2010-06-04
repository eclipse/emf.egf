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
package org.eclipse.egf.model.ftask.internal.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.EGFFtaskPlugin;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.ftask.l10n.EGFFtaskMessages;
import org.eclipse.egf.model.ftask.task.ITaskNature;
import org.eclipse.egf.model.ftask.task.ITaskNatureRegistry;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public final class TaskNatureRegistry implements ITaskNatureRegistry {

    private Map<String, ITaskNature> _natures;

    /**
     * Define a constant for the Task extension-point id.
     */
    public static final String EXTENSION_ID = "org.eclipse.egf.model.ftask.task"; //$NON-NLS-1$

    /**
     * Define a constant for the 'class' attribute.
     */
    public static final String INVOKER_ATT_CLASS = "class"; //$NON-NLS-1$    

    public List<String> getKinds() {
        return new ArrayList<String>(_natures.keySet());
    }

    public ITaskNature getTaskNature(Task task) throws InvocationException {
        if (task == null) {
            throw new InvocationException(EGFFtaskMessages.missing_task_message);
        }
        if (task.getKindValue() == null || task.getKindValue().trim().length() == 0) {
            throw new InvocationException(NLS.bind(EGFFtaskMessages.missing_kind_message, EMFHelper.getText(task)));
        }
        ITaskNature taskNature = _natures.get(task.getKindValue().trim());
        if (taskNature == null) {
            throw new InvocationException(NLS.bind(EGFFtaskMessages.missing_nature_message, task.getKindValue().trim()));
        }
        return taskNature;
    }

    public TaskNatureRegistry() {
        initialize();
    }

    private void initialize() {
        if (_natures != null) {
            return;
        }
        _natures = new HashMap<String, ITaskNature>();
        for (IConfigurationElement element : Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID)) {
            try {
                // see platform:/plugin/org.eclipse.egf.model.ftask/org.eclipse.egf.model.ftask.task.exsd
                String extension = ExtensionPointHelper.getAttributeValue(element, INVOKER_ATT_CLASS);
                // Ignore
                if (extension == null || extension.trim().length() == 0) {
                    continue;
                }
                extension = extension.trim();
                // 'class' attribute is mandatory
                Object object = element.createExecutableExtension(INVOKER_ATT_CLASS);
                if (object == null) {
                    continue;
                }
                if (object instanceof ITaskNature == false) {
                    EGFFtaskPlugin.getPlugin().logError(NLS.bind("Wrong Class {0}", object.getClass().getName())); //$NON-NLS-1$
                    EGFFtaskPlugin.getPlugin().logInfo(NLS.bind("Class should be an implementation of ''{0}''.", ITaskNature.class.getName()), 1); //$NON-NLS-1$
                    EGFFtaskPlugin.getPlugin().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(element)), 1); //$NON-NLS-1$
                    EGFFtaskPlugin.getPlugin().logInfo(NLS.bind("Extension-Point ''{0}''", element.getName()), 1); //$NON-NLS-1$
                    EGFFtaskPlugin.getPlugin().logInfo(NLS.bind("extension ''{0}''", extension), 1); //$NON-NLS-1$
                    continue;
                }
                ITaskNature taskNature = (ITaskNature) object;
                if (taskNature.getKind() == null || taskNature.getKind().trim().length() == 0) {
                    continue;
                }
                String kind = taskNature.getKind().trim();
                if (_natures.get(kind) != null) {
                    EGFFtaskPlugin.getPlugin().logError(NLS.bind("Duplicate Kind ''{0}''", kind)); //$NON-NLS-1$
                    EGFFtaskPlugin.getPlugin().logInfo(NLS.bind("Extension-Point ''{0}''", element.getName()), 1); //$NON-NLS-1$
                    EGFFtaskPlugin.getPlugin().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(element)), 1); //$NON-NLS-1$            
                }
                _natures.put(kind, taskNature);
            } catch (CoreException e) {
                EGFFtaskPlugin.getPlugin().logError(e);
            }
        }
    }

    public void dispose() {
        _natures = null;
    }

}
