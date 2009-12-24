/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.pattern.impl;

import org.eclipse.egf.model.PatternContext;
import org.eclipse.egf.model.PatternException;
import org.eclipse.egf.model.factorycomponent.impl.ModelElementImpl;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternEngine;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Engine</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.PatternEngineImpl#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PatternEngineImpl extends ModelElementImpl implements PatternEngine {
    /**
     * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    protected int eFlags = 0;

    /**
     * The cached value of the '{@link #getPattern() <em>Pattern</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getPattern()
     * @generated
     * @ordered
     */
    protected Pattern pattern;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected PatternEngineImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PatternPackage.Literals.PATTERN_ENGINE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Pattern getPattern() {
        if (pattern != null && pattern.eIsProxy()) {
            InternalEObject oldPattern = (InternalEObject) pattern;
            pattern = (Pattern) eResolveProxy(oldPattern);
            if (pattern != oldPattern) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PatternPackage.PATTERN_ENGINE__PATTERN, oldPattern, pattern));
            }
        }
        return pattern;
    }

    protected void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Pattern basicGetPattern() {
        return pattern;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void execute(PatternContext context) throws PatternException {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void translate() throws PatternException {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case PatternPackage.PATTERN_ENGINE__PATTERN:
            if (resolve)
                return getPattern();
            return basicGetPattern();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case PatternPackage.PATTERN_ENGINE__PATTERN:
            return pattern != null;
        }
        return super.eIsSet(featureID);
    }

} // PatternEngineImpl
