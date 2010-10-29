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
import org.eclipse.egf.core.epackage.EPackageWrapper;
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
     * 
     */
    private String getTypeLiteral(String type, boolean handleInnerClass) {
        if (type == null || type.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        int index = type.indexOf('#');
        if (index == -1) {
            return handleInnerClass ? type.replace('$', '.') : type;
        }
        String basePackage = EGFCorePlugin.getTargetPlatformBasePackage(URI.createURI(type));
        if (basePackage == null) {
            throw new IllegalStateException(NLS.bind(EGFPatternMessages.assembly_error7, type));
        }
        if (basePackage.trim().length() == 0) {
            EPackageWrapper wrapper = EGFCorePlugin.getTargetPlatformEPackageWrapper(URI.createURI(type));
            if (wrapper == null) {
                throw new IllegalStateException(NLS.bind(EGFPatternMessages.assembly_error7, type));
            }
            return wrapper.getName() + "." + getClassName(type, index); //$NON-NLS-1$
        }
        return basePackage + "." + getClassName(type, index); //$NON-NLS-1$
    }

    public static String getClassName(String type, int index) {
        String className = type.substring(index + 1);
        if (className.startsWith("//")) { //$NON-NLS-1$
            return className.substring(2);
        }
        return className;
    }

    private ParameterTypeHelper() {
        // Prevent instantiation
    }

}
