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
package org.eclipse.egf.core.internal.genmodel;

import org.eclipse.egf.core.genmodel.IPlatformGenModel;
import org.eclipse.egf.core.genmodel.IPlatformGenModelConstants;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointFactory;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginElement;

/**
 * @author Xavier Maysonnave
 * 
 */
public final class PlatformGenModelFactory implements IPlatformExtensionPointFactory<IPlatformGenModel> {

    public IPlatformGenModel createExtensionPoint(IPlatformBundle platformBundle, IPluginElement pluginElement) {
        if (pluginElement == null) {
            return null;
        }
        // platform:/plugin/org.eclipse.emf.ecore/schema/generated_package.exsd
        if (IPlatformGenModelConstants.PACKAGE_EXTENSION_CHILD.equals(pluginElement.getName()) == false) {
            return null;
        }
        // the uri attribute is mandatory
        IPluginAttribute uri = pluginElement.getAttribute(IPlatformGenModelConstants.PACKAGE_ATT_URI);
        if (uri == null || uri.getValue() == null || uri.getValue().trim().length() == 0) {
            return null;
        }
        // the class attribute is mandatory
        IPluginAttribute className = pluginElement.getAttribute(IPlatformGenModelConstants.PACKAGE_ATT_CLASS);
        if (className == null || className.getValue() == null || className.getValue().trim().length() == 0) {
            return null;
        }
        // the genModel attribute is optional
        IPluginAttribute genModel = pluginElement.getAttribute(IPlatformGenModelConstants.PACKAGE_ATT_GENMODEL);
        // Create an IPlatformGenModel
        return new PlatformGenModel(platformBundle, uri.getValue(), className.getValue(), genModel != null ? genModel.getValue() : null);
    }

}
