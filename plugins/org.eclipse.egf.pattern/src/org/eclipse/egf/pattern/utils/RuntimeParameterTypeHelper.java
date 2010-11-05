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

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.EGFCorePlugin;
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
        String className = ParameterTypeHelper.getClassName(type, index);
        EPackage ePackage = getEPackage(type, index);
        EClass eClassifier = (EClass) ePackage.getEClassifier(className);
        if (eClassifier == null) {
            throw new IllegalStateException(NLS.bind(EGFPatternMessages.classloader_error3, className, getNsURI(type, index)));
        }
        return eClassifier;
    }

    private EPackage getEPackage(String type, int index) {
        EditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
        EObject eObject = editingDomain.getResourceSet().getEObject(URI.createURI(type), true);
        if (eObject == null) {
            throw new IllegalStateException(NLS.bind(EGFPatternMessages.assembly_error7, type));
        }
        return EMFHelper.getEPackage(eObject);
    }

    private String getNsURI(String type, int index) {
        return type.substring(0, index);
    }

    private RuntimeParameterTypeHelper() {
        // Prevent instantiation
    }

}
