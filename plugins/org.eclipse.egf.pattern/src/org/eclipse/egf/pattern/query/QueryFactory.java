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

package org.eclipse.egf.pattern.query;

import org.eclipse.core.runtime.Assert;
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

    public QueryKind createExtensionPoint(IPlatformBundle platformBundle, IPluginElement pluginElement) {
        if (pluginElement == null) {
            return null;
        }
        IPluginAttribute id = pluginElement.getAttribute(ID_ATTR);
        if (id == null || id.getValue() == null || id.getValue().trim().length() == 0) {
            return null;
        }
        IPluginAttribute className = pluginElement.getAttribute(CLASS_ATTR);
        if (className == null || className.getValue() == null || className.getValue().trim().length() == 0) {
            return null;
        }
        IPluginAttribute name = pluginElement.getAttribute(NAME_ATTR);
        if (name == null || name.getValue() == null || name.getValue().trim().length() == 0) {
            return null;
        }
        return new QueryKindImpl(platformBundle, id.getValue(), className.getValue(), name.getValue());
    }

    private static class QueryKindImpl extends PlatformExtensionPointURI implements QueryKind {

        private final String className;

        private final String name;

        public QueryKindImpl(IPlatformBundle bundle, String id, String className, String name) {
            super(bundle, id);
            Assert.isNotNull(className);
            Assert.isLegal(className.trim().length() != 0);
            Assert.isNotNull(name);
            Assert.isLegal(name.trim().length() != 0);
            this.className = className.trim();
            this.name = name.trim();
        }

        public String getClassName() {
            return className;
        }

        public String getName() {
            return name;
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
