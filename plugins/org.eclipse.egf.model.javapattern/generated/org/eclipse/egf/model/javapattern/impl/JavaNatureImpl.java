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
package org.eclipse.egf.model.javapattern.impl;

import org.eclipse.egf.model.javapattern.JavaNature;
import org.eclipse.egf.model.javapattern.JavaPatternPackage;
import org.eclipse.egf.model.pattern.impl.PatternNatureImpl;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Nature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class JavaNatureImpl extends PatternNatureImpl implements JavaNature {

    /**
     * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected int flags = 0;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected JavaNatureImpl() {
        super();
        setName("Java"); //$NON-NLS-1$
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return JavaPatternPackage.Literals.JAVA_NATURE;
    }

} // JavaNatureImpl
