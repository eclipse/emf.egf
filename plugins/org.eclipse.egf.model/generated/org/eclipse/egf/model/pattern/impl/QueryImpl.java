/**
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
 */
package org.eclipse.egf.model.pattern.impl;

import org.eclipse.egf.model.fcore.impl.ModelElementImpl;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Query</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.QueryImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.QueryImpl#getExtensionId <em>Extension Id</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.impl.QueryImpl#getQueryContext <em>Query Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class QueryImpl extends ModelElementImpl implements Query {
    /**
     * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected int flags = 0;

    /**
     * The default value of the '{@link #getExtensionId() <em>Extension Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExtensionId()
     * @generated
     * @ordered
     */
    protected static final String EXTENSION_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExtensionId() <em>Extension Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExtensionId()
     * @generated
     * @ordered
     */
    protected String extensionId = EXTENSION_ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getQueryContext() <em>Query Context</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQueryContext()
     * @generated
     * @ordered
     */
    protected EMap<String, String> queryContext;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExtensionId() {
        return extensionId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExtensionId(String newExtensionId) {
        String oldExtensionId = extensionId;
        extensionId = newExtensionId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.QUERY__EXTENSION_ID, oldExtensionId, extensionId));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, String> getQueryContext() {
        if (queryContext == null) {
            queryContext = new EcoreEMap<String, String>(PatternPackage.Literals.STRING2_STRING, String2StringImpl.class, this, PatternPackage.QUERY__QUERY_CONTEXT);
        }
        return queryContext;
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
        case PatternPackage.QUERY__QUERY_CONTEXT:
            return ((InternalEList<?>) getQueryContext()).basicRemove(otherEnd, msgs);
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
    @SuppressWarnings("all")
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case PatternPackage.QUERY__PARAMETER:
            return getParameter();
        case PatternPackage.QUERY__EXTENSION_ID:
            return getExtensionId();
        case PatternPackage.QUERY__QUERY_CONTEXT:
            if (coreType)
                return getQueryContext();
            else
                return getQueryContext().map();
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
        case PatternPackage.QUERY__EXTENSION_ID:
            setExtensionId((String) newValue);
            return;
        case PatternPackage.QUERY__QUERY_CONTEXT:
            ((EStructuralFeature.Setting) getQueryContext()).set(newValue);
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
        case PatternPackage.QUERY__EXTENSION_ID:
            setExtensionId(EXTENSION_ID_EDEFAULT);
            return;
        case PatternPackage.QUERY__QUERY_CONTEXT:
            getQueryContext().clear();
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
        case PatternPackage.QUERY__EXTENSION_ID:
            return EXTENSION_ID_EDEFAULT == null ? extensionId != null : !EXTENSION_ID_EDEFAULT.equals(extensionId);
        case PatternPackage.QUERY__QUERY_CONTEXT:
            return queryContext != null && !queryContext.isEmpty();
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
        result.append(" (extensionId: "); //$NON-NLS-1$
        result.append(extensionId);
        result.append(')');
        return result.toString();
    }

} // QueryImpl
