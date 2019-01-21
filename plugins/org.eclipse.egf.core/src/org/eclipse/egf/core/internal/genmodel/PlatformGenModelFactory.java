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
package org.eclipse.egf.core.internal.genmodel;

import org.eclipse.core.internal.registry.Handle;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
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

    public IPlatformGenModel createExtensionPoint(IPlatformBundle platformBundle, Object object) {
        if (object instanceof IPluginElement) {
            return create(platformBundle, (IPluginElement) object);
        } else if (object instanceof IConfigurationElement) {
            return create(platformBundle, (IConfigurationElement) object);
        }
        throw new UnsupportedOperationException();
    }

    private IPlatformGenModel create(IPlatformBundle platformBundle, IPluginElement element) {
        if (element == null) {
            return null;
        }
        // platform:/plugin/org.eclipse.emf.ecore/schema/generated_package.exsd
        if (IPlatformGenModelConstants.PACKAGE_EXTENSION_CHILD.equals(element.getName()) == false) {
            return null;
        }
        // the 'uri' attribute is mandatory
        IPluginAttribute uri = element.getAttribute(IPlatformGenModelConstants.PACKAGE_ATT_URI);
        if (uri == null || uri.getValue() == null || uri.getValue().trim().length() == 0) {
            return null;
        }
        // the 'class' attribute is mandatory
        IPluginAttribute className = element.getAttribute(IPlatformGenModelConstants.PACKAGE_ATT_CLASS);
        if (className == null || className.getValue() == null || className.getValue().trim().length() == 0) {
            return null;
        }
        // the 'genModel' attribute is optional
        IPluginAttribute genModel = element.getAttribute(IPlatformGenModelConstants.PACKAGE_ATT_GENMODEL);
        // Create an IPlatformGenModel
        return new PlatformGenModel(platformBundle, uri.getValue(), className.getValue(), genModel != null ? genModel.getValue() : null);
    }

    private IPlatformGenModel create(IPlatformBundle platformBundle, IConfigurationElement element) {
        if (element == null) {
            return null;
        }
        // Store identifier
        IExtension declaringExtension = element.getDeclaringExtension();
        String uniqueIdentifier = declaringExtension.getUniqueIdentifier();
        int handleId = -1;
        if (declaringExtension instanceof Handle) {
            handleId = ((Handle) declaringExtension).getId();
        }
        // platform:/plugin/org.eclipse.emf.ecore/schema/generated_package.exsd
        if (IPlatformGenModelConstants.PACKAGE_EXTENSION_CHILD.equals(element.getName()) == false) {
            return null;
        }
        // the 'uri' attribute is mandatory
        String uri = element.getAttribute(IPlatformGenModelConstants.PACKAGE_ATT_URI);
        if (uri == null || uri.trim().length() == 0) {
            return null;
        }
        // the 'class' attribute is mandatory
        String className = element.getAttribute(IPlatformGenModelConstants.PACKAGE_ATT_CLASS);
        if (className == null || className.trim().length() == 0) {
            return null;
        }
        // the 'genModel' attribute is optional
        String genModel = element.getAttribute(IPlatformGenModelConstants.PACKAGE_ATT_GENMODEL);
        // Create an IPlatformGenModel
        return new PlatformGenModel(platformBundle, uri, uniqueIdentifier, handleId, className, genModel);
    }

}
