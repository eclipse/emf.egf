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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IRegistryEventListener;
import org.eclipse.core.runtime.RegistryFactory;
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
public final class TaskNatureRegistry implements ITaskNatureRegistry, IRegistryEventListener {

    private Map<String, TaskNatureProxy> _natures;

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
        String kind = task.getKindValue().trim();
        TaskNatureProxy taskNatureProxy = _natures.get(kind);
        ITaskNature taskNature = null;
        if (taskNatureProxy != null) {
            taskNature = taskNatureProxy.getTaskNature();
        }
        if (taskNature == null) {
            throw new InvocationException(NLS.bind(EGFFtaskMessages.missing_nature_message, kind));
        }
        return taskNature;
    }

    public TaskNatureRegistry() {
        initialize();
        RegistryFactory.getRegistry().addListener(this, EXTENSION_ID);
    }

    private void initialize() {
        if (_natures != null) {
            return;
        }
        _natures = new HashMap<String, TaskNatureProxy>();
        IExtensionPoint point = RegistryFactory.getRegistry().getExtensionPoint(EXTENSION_ID);
        if (point != null) {
            for (IExtension extension : point.getExtensions()) {
                for (IConfigurationElement element : extension.getConfigurationElements()) {
                    registerTaskNature(element);
                }
            }
        }
    }

    private void registerTaskNature(IConfigurationElement element) {
        if (element == null) {
            return;
        }
        TaskNatureProxy taskNatureProxy = TaskNatureProxy.createProxy(element);
        if (taskNatureProxy != null) {
            if (_natures.get(taskNatureProxy.getKind()) != null) {
                EGFFtaskPlugin.getPlugin().logError(NLS.bind("Duplicate Kind ''{0}''", taskNatureProxy.getKind())); //$NON-NLS-1$
                EGFFtaskPlugin.getPlugin().logInfo(NLS.bind("Extension-Point ''{0}''", element.getName()), 1); //$NON-NLS-1$
                EGFFtaskPlugin.getPlugin().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(element)), 1); //$NON-NLS-1$            
            }
            _natures.put(taskNatureProxy.getKind(), taskNatureProxy);
        }
    }

    public void added(IExtension[] extensions) {
        if (extensions == null) {
            return;
        }
        for (IExtension extension : extensions) {
            for (IConfigurationElement element : extension.getConfigurationElements()) {
                registerTaskNature(element);
            }
        }
    }

    public void removed(IExtension[] extensions) {
        for (int i = 0; i < extensions.length; i++) {
            for (Iterator<TaskNatureProxy> it = _natures.values().iterator(); it.hasNext();) {
                TaskNatureProxy proxy = it.next();
                if (proxy.originatesFrom(extensions[i])) {
                    it.remove();
                }
            }
        }
    }

    public void added(IExtensionPoint[] extensionPoints) {
        // Nothing to do
    }

    public void removed(IExtensionPoint[] extensionPoints) {
        // Nothing to do
    }

    public void dispose() {
        RegistryFactory.getRegistry().removeListener(this);
        _natures = null;
    }

}
