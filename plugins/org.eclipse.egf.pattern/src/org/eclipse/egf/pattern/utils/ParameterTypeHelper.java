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
import org.eclipse.egf.pattern.EGFPatternPlugin;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
        if (type == null || "".equals(type)) //$NON-NLS-1$
            throw new IllegalArgumentException();
        int index = type.indexOf('#');
        if (index == -1) {
            return handleInnerClass ? type.replace('$', '.') : type;
        }

        EPackage ePackage = getEPackage(type, index);
        // String nsURI = ePackage.getNsURI();
        String basePackage = EGFPatternPlugin.getEPackageHelper().getBasePackage(ePackage);
        if (basePackage == null)
            throw new IllegalStateException(NLS.bind(EGFPatternMessages.assembly_error7, type));

        if ("".equals(basePackage)) //$NON-NLS-1$
            return ePackage.getName() + "." + getClassName(type, index); //$NON-NLS-1$
        return basePackage + "." + getClassName(type, index); //$NON-NLS-1$
    }

    /**
     * load the type described in the string parameter.<br/>
     * It can be a java classname or an uri to an EObject.
     */
    public Object loadClass(String type) {
        if (type == null || "".equals(type)) //$NON-NLS-1$
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
        String className = getClassName(type, index);
        EPackage ePackage = getEPackage(type, index);
        EClass eClassifier = (EClass) ePackage.getEClassifier(className);
        if (eClassifier == null)
            throw new IllegalStateException(NLS.bind(EGFPatternMessages.classloader_error3, className, getNsURI(type, index)));
        return eClassifier;
    }

    private EPackage getEPackage(String type, int index) {
        EditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
        EObject eObject = editingDomain.getResourceSet().getEObject(URI.createURI(type), true);
        if (eObject == null) {
            throw new IllegalStateException(NLS.bind(EGFPatternMessages.assembly_error7, type));
        }
        return EGFPatternPlugin.getEPackageHelper().getEPackage(eObject);
        // return EPackageHelper.REGISTRY.getEPackage(getNsURI(type, index));
    }

    private String getNsURI(String type, int index) {
        return type.substring(0, index);
    }

    private String getClassName(String type, int index) {
        String className = type.substring(index + 1);
        if (className.startsWith("//")) //$NON-NLS-1$
            return className.substring(2);
        return className;
    }

    private ParameterTypeHelper() {
        // Prevent instantiation
    }

}
