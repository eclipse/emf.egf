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
package org.eclipse.egf.core.internal.fcore;

import org.eclipse.core.internal.registry.Handle;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreConstants;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointFactory;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginElement;

/**
 * @author Xavier Maysonnave
 * 
 */
public final class PlatformFcoreFactory implements IPlatformExtensionPointFactory<IPlatformFcore> {

    public IPlatformFcore createExtensionPoint(IPlatformBundle platformBundle, Object object) {
        if (object instanceof IPluginElement) {
            return create(platformBundle, (IPluginElement) object);
        } else if (object instanceof IConfigurationElement) {
            return create(platformBundle, (IConfigurationElement) object);
        }
        throw new UnsupportedOperationException();
    }

    private IPlatformFcore create(IPlatformBundle platformBundle, IPluginElement element) {
        if (element == null) {
            return null;
        }
        // platform:/plugin/org.eclipse.egf.core/schema/fcore.exsd
        if (IPlatformFcoreConstants.FCORE_EXTENSION_CHILD.equals(element.getName()) == false) {
            return null;
        }
        // 'id' attribute is mandatory
        IPluginAttribute id = element.getAttribute(IPlatformFcoreConstants.FCORE_ATT_ID);
        if (id == null || id.getValue() == null || id.getValue().trim().length() == 0) {
            return null;
        }
        return new PlatformFcore(platformBundle, id.getValue());
    }

    private IPlatformFcore create(IPlatformBundle platformBundle, IConfigurationElement element) {
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
        // see platform:/plugin/org.eclipse.egf.core/schema/fcore.exsd
        if (IPlatformFcoreConstants.FCORE_EXTENSION_CHILD.equals(element.getName()) == false) {
            return null;
        }
        String id = element.getAttribute(IPlatformFcoreConstants.FCORE_ATT_ID);
        // 'id' attribute is mandatory
        if (id == null || id.trim().length() == 0) {
            return null;
        }
        return new PlatformFcore(platformBundle, id, uniqueIdentifier, handleId);
    }

}
