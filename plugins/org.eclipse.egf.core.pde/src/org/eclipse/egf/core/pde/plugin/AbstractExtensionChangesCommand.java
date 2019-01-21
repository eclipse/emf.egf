/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.pde.plugin;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.core.pde.helper.ExtensionHelper;
import org.eclipse.pde.core.plugin.IExtensions;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;

/**
 * Base class to implement a command that performs plug-in changes in extension
 * part.<br>
 * Changes can be an extension adding operation.
 * 
 * @author fournier
 */
public abstract class AbstractExtensionChangesCommand extends AbstractChangesCommand {

    public AbstractExtensionChangesCommand(IProject project) throws CoreException {
        super(project);
    }

    /**
     * Create extension for extension-point id returned by {@link #getExtensionPointId()}.
     * 
     * @return
     */
    protected IPluginExtension createExtension() throws CoreException {
        // Create a new extension matching extension-point id.
        return ExtensionHelper.createExtension(getPluginModelBase(), getExtensionPointId());
    }

    /**
     * Remove extension point according to the result of {@link #getExtensionPointId()}.
     */
    protected void removeExtensionElement() throws CoreException {
        // Retrieve the extension.
        IPluginExtension[] pluginExtensions = ExtensionHelper.getPluginExtension(getExtensions(), getExtensionPointId());
        if (pluginExtensions == null) {
            return;
        }
        for (IPluginExtension pluginExtension : pluginExtensions) {
            boolean removed = false;
            IPluginElement[] pluginElements = ExtensionHelper.getPluginElement(pluginExtension, getExtensionChildName());
            if (pluginElements == null) {
                continue;
            }
            for (IPluginElement pluginElement : pluginElements) {
                // Look up for the one related to given element name.
                IPluginAttribute pluginAttribute = pluginElement.getAttribute(getExtensionChildAttribute());
                if (pluginAttribute != null && matchValue(pluginAttribute.getValue())) {
                    pluginExtension.remove(pluginElement);
                    removed = true;
                }
            }
            // Is the element removed ?
            if (removed == false) {
                continue;
            }
            int childCount = pluginExtension.getChildCount();
            if (childCount == 0) {
                // Remove it.
                getExtensions().remove(pluginExtension);
            }
        }
    }

    /**
     * Get a child for given id in extension matching {@link #getExtensionPointId()}, {@link #getExtensionChildName()} and {@link #getExtensionChildIdAttribute()}.
     * 
     * @param value
     * @return null if
     */
    protected IPluginElement createExtensionElement() throws CoreException {
        IPluginElement pluginElement = null;
        // Get the extension.
        IPluginExtension[] pluginExtensions = ExtensionHelper.getPluginExtension(getExtensions(), getExtensionPointId());
        if (pluginExtensions == null) {
            return null;
        }
        // Check if an extension is already containing the searched element?
        // Loop over retrieved extensions to seek for a plug-in element with specified id attribute and id value.
        // We stop when the first one is found
        LOOP: for (int i = 0; i < pluginExtensions.length; i++) {
            // Retrieve contained element.
            IPluginElement[] pluginElements = ExtensionHelper.getPluginElement(pluginExtensions[i], getExtensionChildName());
            if (pluginElements != null) {
                for (IPluginElement innerPluginElement : pluginElements) {
                    // Look up for the one related to given element name.
                    IPluginAttribute pluginAttribute = innerPluginElement.getAttribute(getExtensionChildAttribute());
                    if (pluginAttribute != null && matchValue(pluginAttribute.getValue())) {
                        pluginElement = innerPluginElement;
                        break LOOP;
                    }
                }
            }
        }
        // If the plug-in element is not found, create a new extension with its
        // extension element.
        if (pluginElement == null) {
            // Extension doesn't exist yet, let's create it.
            IPluginExtension extension = null;
            if (pluginExtensions != null && pluginExtensions.length > 0) {
                extension = pluginExtensions[0];
            }
            if (extension == null) {
                extension = createExtension();
            }
            // Create the element.
            pluginElement = ExtensionHelper.createPluginElement(extension, getExtensionChildName());
            if (pluginElement != null) {
                // Set it its id.
                pluginElement.setAttribute(getExtensionChildAttribute(), getValue().toString());
            }
        }
        return pluginElement;
    }

    /**
     * Returns the extensions matching the given extension point id.
     * 
     * @param extensionPointId
     * @return
     */
    protected IPluginExtension[] getExtensions(String extensionPointId) {
        // Get the portion of plug-in responsible for extensions and
        // extension-points and get the extension.
        return ExtensionHelper.getPluginExtension(getExtensions(), extensionPointId);
    }

    /**
     * Get {@link IExtensions} instance from plug-in object.
     * 
     * @return
     */
    protected IExtensions getExtensions() {
        IPluginModelBase pluginModelBase = getPluginModelBase();
        if (pluginModelBase == null) {
            return null;
        }
        return pluginModelBase.getExtensions();
    }

    /**
     * matching rule for values
     * 
     * @return
     */
    protected abstract boolean matchValue(String value);

    /**
     * Get the extension point id.
     * 
     * @return
     */
    protected abstract String getExtensionPointId();

    /**
     * Get the children's node name for the extension.
     * 
     * @return
     */
    protected abstract String getExtensionChildName();

    /**
     * Get the children's attribute for the extension.
     * 
     * @return
     */
    protected abstract String getExtensionChildAttribute();

    /**
     * Get the value
     * 
     * @return
     */
    protected abstract Object getValue();

}
