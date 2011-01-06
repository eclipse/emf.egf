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

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.epackage.IProxyEObject;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;

/**
 * 
 * @author Thomas Guiu
 * 
 */
public class ParameterTypeHelper {

    public static final ParameterTypeHelper INSTANCE = new ParameterTypeHelper();

    private ParameterTypeHelper() {
    }

    public String getSourceTypeLiteral(String type) {
        return getTypeLiteral(type, true);
    }

    public String getBinaryTypeLiteral(String type) {
        return getTypeLiteral(type, false);
    }

    /**
     * Compute the literal value associated to the given type.<br/>
     * It can be a java classname or an uri to an EObject.
     * 
     */
    private String getTypeLiteral(String type, boolean handleInnerClass) {
        // clearProxies();
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

        // URI Type
        IProxyEObject proxy = EGFCorePlugin.getTargetPlatformIProxyEObject(uri);
        if (proxy == null) {
            throw new IllegalStateException(NLS.bind(EGFPatternMessages.assembly_error7, uri));
        }
        if (proxy.getInstanceClassName() == null) {
            throw new IllegalStateException(NLS.bind(EGFPatternMessages.assembly_error7, uri));
        }
        return proxy.getInstanceClassName();
    }
}
