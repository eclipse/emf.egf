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

import java.util.Map;

import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl.Container;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Query</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.QueryImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.QueryImpl#getDelegateClass <em>Delegate Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class QueryImpl extends Container implements Query {
    /**
     * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    protected int eFlags = 0;

    /**
     * The default value of the '{@link #getDelegateClass() <em>Delegate Class</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getDelegateClass()
     * @generated
     * @ordered
     */
    protected static final String DELEGATE_CLASS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDelegateClass() <em>Delegate Class</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getDelegateClass()
     * @generated
     * @ordered
     */
    protected String delegateClass = DELEGATE_CLASS_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected QueryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PatternPackage.Literals.QUERY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public PatternParameter getParameter() {
        if (eContainerFeatureID() != PatternPackage.QUERY__PARAMETER)
            return null;
        return (PatternParameter) eContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParameter(PatternParameter newParameter, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newParameter, PatternPackage.QUERY__PARAMETER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setParameter(PatternParameter newParameter) {
        if (newParameter != eInternalContainer() || (eContainerFeatureID() != PatternPackage.QUERY__PARAMETER && newParameter != null)) {
            if (EcoreUtil.isAncestor(this, newParameter))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParameter != null)
                msgs = ((InternalEObject) newParameter).eInverseAdd(this, PatternPackage.PATTERN_PARAMETER__QUERY, PatternParameter.class, msgs);
            msgs = basicSetParameter(newParameter, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.QUERY__PARAMETER, newParameter, newParameter));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getDelegateClass() {
        return delegateClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setDelegateClass(String newDelegateClass) {
        String oldDelegateClass = delegateClass;
        delegateClass = newDelegateClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.QUERY__DELEGATE_CLASS, oldDelegateClass, delegateClass));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Map<String, String> getQueryContext() {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case PatternPackage.QUERY__PARAMETER:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetParameter((PatternParameter) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case PatternPackage.QUERY__PARAMETER:
            return basicSetParameter(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case PatternPackage.QUERY__PARAMETER:
            return eInternalContainer().eInverseRemove(this, PatternPackage.PATTERN_PARAMETER__QUERY, PatternParameter.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case PatternPackage.QUERY__PARAMETER:
            return getParameter();
        case PatternPackage.QUERY__DELEGATE_CLASS:
            return getDelegateClass();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case PatternPackage.QUERY__PARAMETER:
            setParameter((PatternParameter) newValue);
            return;
        case PatternPackage.QUERY__DELEGATE_CLASS:
            setDelegateClass((String) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case PatternPackage.QUERY__PARAMETER:
            setParameter((PatternParameter) null);
            return;
        case PatternPackage.QUERY__DELEGATE_CLASS:
            setDelegateClass(DELEGATE_CLASS_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case PatternPackage.QUERY__PARAMETER:
            return getParameter() != null;
        case PatternPackage.QUERY__DELEGATE_CLASS:
            return DELEGATE_CLASS_EDEFAULT == null ? delegateClass != null : !DELEGATE_CLASS_EDEFAULT.equals(delegateClass);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (delegateClass: "); //$NON-NLS-1$
        result.append(delegateClass);
        result.append(')');
        return result.toString();
    }

} // QueryImpl
