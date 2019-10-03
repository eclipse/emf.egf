/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.query;

import org.eclipse.core.internal.registry.Handle;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointFactory;
import org.eclipse.egf.core.platform.pde.PlatformExtensionPointURI;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginElement;

/**
 * @author Thomas Guiu
 * 
 */
public class QueryFactory implements IPlatformExtensionPointFactory<QueryKind> {

    private static final String ID_ATTR = "id"; //$NON-NLS-1$

    private static final String CLASS_ATTR = "class"; //$NON-NLS-1$

    private static final String NAME_ATTR = "name"; //$NON-NLS-1$

    public QueryKind createExtensionPoint(IPlatformBundle platformBundle, Object object) {
        if (object instanceof IPluginElement) {
            return create(platformBundle, (IPluginElement) object);
        } else if (object instanceof IConfigurationElement) {
            return create(platformBundle, (IConfigurationElement) object);
        }
        throw new UnsupportedOperationException();
    }

    private QueryKind create(IPlatformBundle platformBundle, IPluginElement element) {
        if (element == null) {
            return null;
        }
        IPluginAttribute id = element.getAttribute(ID_ATTR);
        if (id == null || id.getValue() == null || id.getValue().trim().length() == 0) {
            return null;
        }
        IPluginAttribute className = element.getAttribute(CLASS_ATTR);
        if (className == null || className.getValue() == null || className.getValue().trim().length() == 0) {
            return null;
        }
        IPluginAttribute name = element.getAttribute(NAME_ATTR);
        if (name == null || name.getValue() == null || name.getValue().trim().length() == 0) {
            return null;
        }
        return new QueryKindImpl(platformBundle, id.getValue(), className.getValue(), name.getValue());
    }

    private QueryKind create(IPlatformBundle platformBundle, IConfigurationElement element) {
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
        String id = element.getAttribute(ID_ATTR);
        if (id == null || id.trim().length() == 0) {
            return null;
        }
        String className = element.getAttribute(CLASS_ATTR);
        if (className == null || className.trim().length() == 0) {
            return null;
        }
        String name = element.getAttribute(NAME_ATTR);
        if (name == null || name.trim().length() == 0) {
            return null;
        }
        return new QueryKindImpl(platformBundle, id, uniqueIdentifier, handleId, className, name);
    }

    private static class QueryKindImpl extends PlatformExtensionPointURI implements QueryKind {

        private final String _className;

        private final String _name;

        public QueryKindImpl(IPlatformBundle bundle, String id, String className, String name) {
            super(bundle, id);
            Assert.isNotNull(className);
            Assert.isLegal(className.trim().length() != 0);
            Assert.isNotNull(name);
            Assert.isLegal(name.trim().length() != 0);
            _className = className.trim();
            _name = name.trim();
        }

        public QueryKindImpl(IPlatformBundle bundle, String id, String uniqueIdentifier, int handleId, String className, String name) {
            super(bundle, id, uniqueIdentifier, handleId);
            Assert.isNotNull(className);
            Assert.isLegal(className.trim().length() != 0);
            Assert.isNotNull(name);
            Assert.isLegal(name.trim().length() != 0);
            _className = className.trim();
            _name = name.trim();
        }

        public String getClassName() {
            return _className;
        }

        public String getName() {
            return _name;
        }

        @Override
        public boolean equals(Object object) {
            if (super.equals(object) == false) {
                return false;
            }
            if (object instanceof QueryKind == false) {
                return false;
            }
            QueryKind queryKind = (QueryKind) object;
            if (queryKind.getClassName().equals(getClassName()) == false) {
                return false;
            }
            if (queryKind.getName().equals(getName()) == false) {
                return false;
            }
            return true;
        }

    }

}
