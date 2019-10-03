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

package org.eclipse.egf.pattern.utils;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.emf.common.util.URI;
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
public class RuntimeParameterTypeHelper {

    public static final RuntimeParameterTypeHelper INSTANCE = new RuntimeParameterTypeHelper();

    /**
     * load the type described in the string parameter.<br/>
     * It can be a java classname or an uri to an EObject.
     */
    public Object loadClass(String type) {
        if (type == null || type.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        // Java Type
        int index = type.indexOf('#');
        if (index == -1) {
            try {
                return getClass().getClassLoader().loadClass(type);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException(e);
            }
        }
        // URI Type
        return loadEClass(type);
    }

    private Object loadEClass(String type) {
        String instanceClassName = EMFHelper.getInstanceClassName(getEPackage(type), URI.createURI(type));
        if (instanceClassName == null) {
            return null;
        }
        Class<?> clazz = null;
        try {
            clazz = getClass().getClassLoader().loadClass(instanceClassName);
        } catch (ClassNotFoundException cnfe) {
            // Just Ignore
        }
        if (clazz == null) {
            throw new IllegalStateException(NLS.bind(EGFPatternMessages.classloader_error3, instanceClassName, type));
        }
        return clazz;
    }

    private EPackage getEPackage(String type) {
        EditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
        EObject eObject = editingDomain.getResourceSet().getEObject(URI.createURI(type), true);
        if (eObject == null) {
            throw new IllegalStateException(NLS.bind(EGFPatternMessages.assembly_error7, type));
        }
        return EMFHelper.getEPackage(eObject);
    }

    private RuntimeParameterTypeHelper() {
        // Prevent instantiation
    }

}
