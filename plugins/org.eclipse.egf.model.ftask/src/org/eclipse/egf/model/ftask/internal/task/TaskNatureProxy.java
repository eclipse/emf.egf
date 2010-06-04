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

import org.eclipse.core.internal.registry.Handle;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.model.EGFFtaskPlugin;
import org.eclipse.egf.model.ftask.task.ITaskNature;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskNatureProxy {

    private String _uniqueIdentifier;

    private int _handleId = -1;

    private ITaskNature _taskNature;

    /**
     * @return the _uniqueIdentifier
     */
    public String getUniqueIdentifier() {
        return _uniqueIdentifier;
    }

    /**
     * @param uniqueIdentifier
     *            the _uniqueIdentifier to set
     */
    public void setUniqueIdentifier(String uniqueIdentifier) {
        _uniqueIdentifier = uniqueIdentifier;
    }

    /**
     * @return the _handleId
     */
    public int getHandleId() {
        return _handleId;
    }

    /**
     * @param handleId
     *            the _handleId to set
     */
    public void setHandleId(int handleId) {
        _handleId = handleId;
    }

    /**
     * @return the _taskNature
     */
    public ITaskNature getTaskNature() {
        return _taskNature;
    }

    /**
     * @param taskNature
     *            the _taskNature to set
     */
    public void setTaskNature(ITaskNature taskNature) {
        _taskNature = taskNature;
    }

    public String getKind() {
        if (_taskNature != null) {
            if (_taskNature.getKind() != null) {
                return _taskNature.getKind().trim();
            }
        }
        return null;
    }

    /**
     * Creates a new factory proxy based on the given configuration element.
     * Returns the new proxy, or null if the element could not be created.
     */
    public static TaskNatureProxy createProxy(IConfigurationElement element) {
        // Store indentifier
        IExtension declaringExtension = element.getDeclaringExtension();
        String uniqueIdentifier = declaringExtension.getUniqueIdentifier();
        int handleId = -1;
        if (declaringExtension instanceof Handle) {
            handleId = ((Handle) declaringExtension).getId();
        }
        try {
            // see platform:/plugin/org.eclipse.egf.model.ftask/org.eclipse.egf.model.ftask.task.exsd
            String extension = ExtensionPointHelper.getAttributeValue(element, TaskNatureRegistry.INVOKER_ATT_CLASS);
            // Ignore
            if (extension == null || extension.trim().length() == 0) {
                return null;
            }
            extension = extension.trim();
            // 'class' attribute is mandatory
            Object object = element.createExecutableExtension(TaskNatureRegistry.INVOKER_ATT_CLASS);
            if (object == null) {
                return null;
            }
            if (object instanceof ITaskNature == false) {
                EGFFtaskPlugin.getPlugin().logError(NLS.bind("Wrong Class {0}", object.getClass().getName())); //$NON-NLS-1$
                EGFFtaskPlugin.getPlugin().logInfo(NLS.bind("Class should be an implementation of ''{0}''.", ITaskNature.class.getName()), 1); //$NON-NLS-1$
                EGFFtaskPlugin.getPlugin().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(element)), 1); //$NON-NLS-1$
                EGFFtaskPlugin.getPlugin().logInfo(NLS.bind("Extension-Point ''{0}''", element.getName()), 1); //$NON-NLS-1$
                EGFFtaskPlugin.getPlugin().logInfo(NLS.bind("extension ''{0}''", extension), 1); //$NON-NLS-1$
                return null;
            }
            ITaskNature taskNature = (ITaskNature) object;
            if (taskNature.getKind() == null || taskNature.getKind().trim().length() == 0) {
                return null;
            }
            TaskNatureProxy proxy = new TaskNatureProxy();
            proxy.setUniqueIdentifier(uniqueIdentifier);
            proxy.setHandleId(handleId);
            proxy.setTaskNature(taskNature);
            return proxy;
        } catch (CoreException e) {
            EGFFtaskPlugin.getPlugin().logError(e);
        }
        return null;
    }

    public TaskNatureProxy() {
        // Nothing to do
    }

    public boolean originatesFrom(IExtension extension) {
        String id = extension.getUniqueIdentifier();
        if (id != null) { // match by public ID declared in XML
            return id.equals(_uniqueIdentifier);
        }
        if (extension instanceof Handle == false) {
            return false; // should never happen
        }
        return (_handleId == ((Handle) extension).getId());
    }

}
