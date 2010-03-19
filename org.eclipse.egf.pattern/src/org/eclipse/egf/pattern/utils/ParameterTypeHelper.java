/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.utils;

import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.ecore.EPackageHelper;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * 
 * @author Thomas Guiu
 * 
 */
public class ParameterTypeHelper {
    public static final ParameterTypeHelper INSTANCE = new ParameterTypeHelper();

    /**
     * Compute the literal value associated to the given type.<br/>
     * It can be a java classname or an uri to an EObject.
     * 
     * 
     */
    public String getTypeLiteral(String type) {
        if (type == null || "".equals(type))
            throw new IllegalArgumentException();
        int index = type.indexOf('#');
        if (index == -1)
            return type;
        EPackage ePackage = getEPackage(type, index);
        String nsURI = ePackage.getNsURI();
        String basePackage = EPackageHelper.getBasePackage(ePackage);
        if (basePackage == null)
            throw new IllegalStateException(Messages.bind(Messages.assembly_error7, type));

        if ("".equals(basePackage))
            return ePackage.getName() + "." + getClassName(type, index);
        return basePackage + "." + getClassName(type, index);
    }

    /**
     * load the type described in the string parameter.<br/>
     * It can be a java classname or an uri to an EObject.
     */
    public Object loadClass(String type) {
        if (type == null || "".equals(type))
            throw new IllegalArgumentException();
        int index = type.indexOf('#');
        if (index > 0) {
            return loadEClass(type, index);
        }
        try {
            return getClass().getClassLoader().loadClass(type);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    private EClass loadEClass(String type, int index) {
        String nsuri = getNsURI(type, index);
        String className = getClassName(type, index);

        EPackage ePackage = getEPackage(type, index);
        EClass eClassifier = (EClass) ePackage.getEClassifier(className);
        if (eClassifier == null)
            throw new IllegalStateException(Messages.bind(Messages.classloader_error3, className, nsuri));
        return eClassifier;
    }

    private EPackage getEPackage(String type, int index) {
        return EPackageHelper.REGISTRY.getEPackage(getNsURI(type, index));
    }

    private String getNsURI(String type, int index) {
        return type.substring(0, index);
    }

    private String getClassName(String type, int index) {
        String className = type.substring(index + 1);
        if (className.startsWith("//"))
            return className.substring(2);
        return className;
    }

    private ParameterTypeHelper() {
    }

}
