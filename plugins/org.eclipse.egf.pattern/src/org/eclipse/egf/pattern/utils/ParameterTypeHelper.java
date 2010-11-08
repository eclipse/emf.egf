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

package org.eclipse.egf.pattern.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.egf.common.loader.IClassLoader;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.epackage.IProxyEObject;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginModelBase;

/**
 * 
 * @author Thomas Guiu
 * 
 */
public class ParameterTypeHelper {

    public static final ParameterTypeHelper INSTANCE = new ParameterTypeHelper();

    private Map<URI, IProxyEObject> _proxies = new HashMap<URI, IProxyEObject>();

    private Map<IPluginModelBase, IClassLoader> _loaders = new HashMap<IPluginModelBase, IClassLoader>();

    private ParameterTypeHelper() {
        // Prevent instantiation
    }

    public String getSourceTypeLiteral(String type) {
        return getTypeLiteral(type, true);
    }

    public String getBinaryTypeLiteral(String type) {
        return getTypeLiteral(type, false);
    }

    public void clearProxies() {
        _proxies.clear();
        _loaders.clear();
    }

    /**
     * Compute the literal value associated to the given type.<br/>
     * It can be a java classname or an uri to an EObject. 
     * 
     */
    private String getTypeLiteral(String type, boolean handleInnerClass) {
        if (type == null || type.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        // Java Type
        int index = type.indexOf('#');
        if (index == -1) {
            return handleInnerClass ? type.replace('$', '.') : type;
        }
        // Locate already loaded type
        URI uri = URI.createURI(type.trim());
        if (_proxies.containsKey(uri)) {
            return _proxies.get(uri).getInstanceClassName();
        }
        // URI Type
        IProxyEObject proxy = EGFCorePlugin.getTargetPlatformIProxyEObject(uri, _loaders);
        if (proxy == null) {
            throw new IllegalStateException(NLS.bind(EGFPatternMessages.assembly_error7, uri));
        }
        if (proxy.getInstanceClassName() == null) {
            throw new IllegalStateException(NLS.bind(EGFPatternMessages.assembly_error7, uri));
        }
        _proxies.put(uri, proxy);
        return proxy.getInstanceClassName();
    }

}
