/**
 * 
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
 * 
 */
package org.eclipse.egf.model.types.impl;

import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.core.platform.loader.BundleClassLoaderFactory;
import org.eclipse.egf.core.platform.loader.IBundleClassLoader;
import org.eclipse.egf.model.types.TypeClass;
import org.eclipse.egf.model.types.TypesException;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.types.impl.TypeClassImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeClassImpl extends TypeAbstractClassImpl implements TypeClass {

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected Class<?> type;

    /**
     * The flag representing whether the Type attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected static final int TYPE_ESETFLAG = 1 << 0;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeClassImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TypesPackage.Literals.TYPE_CLASS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetType() {
        return (flags & TYPE_ESETFLAG) != 0;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TypesPackage.TYPE_CLASS__TYPE:
                return getType();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case TypesPackage.TYPE_CLASS__TYPE:
                return isSetType();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (type: "); //$NON-NLS-1$
        if ((flags & TYPE_ESETFLAG) != 0)
            result.append(type);
        else
            result.append("<unset>"); //$NON-NLS-1$
        result.append(')');
        return result.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    @SuppressWarnings("unchecked")
    public Class<?> getType() {
        if (type == null) {
            // Ignore
            if (getValue() == null || getValue().trim().length() == 0) {
                return null;
            }
            IPlatformFcore fcore = null;
            if (eResource() != null && eResource() instanceof IPlatformFcoreProvider) {
                fcore = ((IPlatformFcoreProvider) eResource()).getIPlatformFcore();
            }
            // Runtime or memory
            if (fcore == null || fcore.isRuntime()) {
                try {
                    // Runtime
                    if (fcore == null) {
                        type = Class.forName(getValue().trim());
                    } else {
                        type = fcore.getBundle().loadClass(getValue().trim());
                    }
                    return type;
                } catch (Throwable t) {
                    throw new TypesException(t);
                }
            }
            // Target or Workspace
            try {
                if (fcore.getBundle() != null) {
                    type = fcore.getBundle().loadClass(getValue().trim());
                } else {
                    IBundleClassLoader loader = BundleClassLoaderFactory.getBundleClassLoader(fcore.getPluginModelBase());
                    type = loader.loadClass(getValue().trim());
                }
            } catch (Throwable t) {
                throw new TypesException(t);
            }
        }
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public void setValue(String newValue) {
        super.setValue(newValue);
        type = null;
    }

} // TypeClassImpl
