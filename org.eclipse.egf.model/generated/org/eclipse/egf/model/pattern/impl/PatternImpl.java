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

import java.util.Collection;

import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Pattern</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.egf.model.pattern.impl.PatternImpl#getHeaderMethod
 * <em>Header Method</em>}</li>
 * <li>{@link org.eclipse.egf.model.pattern.impl.PatternImpl#getMethods <em>
 * Methods</em>}</li>
 * <li>{@link org.eclipse.egf.model.pattern.impl.PatternImpl#getFooterMethod
 * <em>Footer Method</em>}</li>
 * <li>{@link org.eclipse.egf.model.pattern.impl.PatternImpl#getSuperPattern
 * <em>Super Pattern</em>}</li>
 * <li>{@link org.eclipse.egf.model.pattern.impl.PatternImpl#getOrchestration
 * <em>Orchestration</em>}</li>
 * <li>{@link org.eclipse.egf.model.pattern.impl.PatternImpl#getParameters <em>
 * Parameters</em>}</li>
 * <li>{@link org.eclipse.egf.model.pattern.impl.PatternImpl#getNature <em>
 * Nature</em>}</li>
 * <li>{@link org.eclipse.egf.model.pattern.impl.PatternImpl#getVariables <em>
 * Variables</em>}</li>
 * <li>{@link org.eclipse.egf.model.pattern.impl.PatternImpl#getInitMethod <em>
 * Init Method</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PatternImpl extends PatternElementImpl implements Pattern {
    /**
     * The cached value of the '{@link #getHeaderMethod()
     * <em>Header Method</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getHeaderMethod()
     * @generated
     * @ordered
     */
    protected PatternMethod headerMethod;

    /**
     * The cached value of the '{@link #getMethods() <em>Methods</em>}'
     * containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMethods()
     * @generated
     * @ordered
     */
    protected EList<PatternMethod> methods;

    /**
     * The cached value of the '{@link #getFooterMethod()
     * <em>Footer Method</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getFooterMethod()
     * @generated
     * @ordered
     */
    protected PatternMethod footerMethod;

    /**
     * The cached value of the '{@link #getSuperPattern()
     * <em>Super Pattern</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getSuperPattern()
     * @generated
     * @ordered
     */
    protected Pattern superPattern;

    /**
     * The cached value of the '{@link #getOrchestration()
     * <em>Orchestration</em>}' containment reference list.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getOrchestration()
     * @generated
     * @ordered
     */
    protected EList<Call> orchestration;

    /**
     * The cached value of the '{@link #getParameters() <em>Parameters</em>}'
     * containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getParameters()
     * @generated
     * @ordered
     */
    protected EList<PatternParameter> parameters;

    /**
     * The cached value of the '{@link #getNature() <em>Nature</em>}'
     * containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getNature()
     * @generated
     * @ordered
     */
    protected PatternNature nature;

    /**
     * The cached value of the '{@link #getVariables() <em>Variables</em>}'
     * containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getVariables()
     * @generated
     * @ordered
     */
    protected EList<PatternVariable> variables;

    /**
     * The cached value of the '{@link #getInitMethod() <em>Init Method</em>}'
     * reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getInitMethod()
     * @generated
     * @ordered
     */
    protected PatternMethod initMethod;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PatternImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PatternPackage.Literals.PATTERN;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PatternMethod getHeaderMethod() {
        return headerMethod;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setHeaderMethod(PatternMethod newHeaderMethod) {
        PatternMethod oldHeaderMethod = headerMethod;
        headerMethod = newHeaderMethod;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN__HEADER_METHOD, oldHeaderMethod, headerMethod));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<PatternMethod> getMethods() {
        if (methods == null) {
            methods = new EObjectContainmentWithInverseEList<PatternMethod>(PatternMethod.class, this, PatternPackage.PATTERN__METHODS, PatternPackage.PATTERN_METHOD__PATTERN);
        }
        return methods;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Pattern getSuperPattern() {
        if (superPattern != null && superPattern.eIsProxy()) {
            InternalEObject oldSuperPattern = (InternalEObject) superPattern;
            superPattern = (Pattern) eResolveProxy(oldSuperPattern);
            if (superPattern != oldSuperPattern) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PatternPackage.PATTERN__SUPER_PATTERN, oldSuperPattern, superPattern));
            }
        }
        return superPattern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Pattern basicGetSuperPattern() {
        return superPattern;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setSuperPattern(Pattern newSuperPattern) {
        Pattern oldSuperPattern = superPattern;
        superPattern = newSuperPattern;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN__SUPER_PATTERN, oldSuperPattern, superPattern));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PatternMethod getFooterMethod() {
        return footerMethod;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setFooterMethod(PatternMethod newFooterMethod) {
        PatternMethod oldFooterMethod = footerMethod;
        footerMethod = newFooterMethod;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN__FOOTER_METHOD, oldFooterMethod, footerMethod));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<Call> getOrchestration() {
        if (orchestration == null) {
            orchestration = new EObjectContainmentWithInverseEList<Call>(Call.class, this, PatternPackage.PATTERN__ORCHESTRATION, PatternPackage.CALL__PATTERN);
        }
        return orchestration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<PatternParameter> getParameters() {
        if (parameters == null) {
            parameters = new EObjectContainmentEList<PatternParameter>(PatternParameter.class, this, PatternPackage.PATTERN__PARAMETERS);
        }
        return parameters;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PatternNature getNature() {
        return nature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetNature(PatternNature newNature, NotificationChain msgs) {
        PatternNature oldNature = nature;
        nature = newNature;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN__NATURE, oldNature, newNature);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setNature(PatternNature newNature) {
        if (newNature != nature) {
            NotificationChain msgs = null;
            if (nature != null)
                msgs = ((InternalEObject) nature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PatternPackage.PATTERN__NATURE, null, msgs);
            if (newNature != null)
                msgs = ((InternalEObject) newNature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PatternPackage.PATTERN__NATURE, null, msgs);
            msgs = basicSetNature(newNature, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN__NATURE, newNature, newNature));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<PatternVariable> getVariables() {
        if (variables == null) {
            variables = new EObjectContainmentEList<PatternVariable>(PatternVariable.class, this, PatternPackage.PATTERN__VARIABLES);
        }
        return variables;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public PatternMethod getInitMethod() {
        return initMethod;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setInitMethod(PatternMethod newInitMethod) {
        PatternMethod oldInitMethod = initMethod;
        initMethod = newInitMethod;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN__INIT_METHOD, oldInitMethod, initMethod));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public PatternMethod getMethod(String innerName) {
        for (PatternMethod method : getMethods()) {
            if (method.getName().equals(innerName))
                return method;
        }
        if (getSuperPattern() == null)
            return null;
        return getSuperPattern().getMethod(innerName);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<PatternParameter> getAllParameters() {
        BasicEList<PatternParameter> result = new BasicEList<PatternParameter>();
        result.addAll(getParameters());
        Pattern innerSuperPattern = getSuperPattern();
        while (innerSuperPattern != null) {
            result.addAll(innerSuperPattern.getParameters());
            innerSuperPattern = innerSuperPattern.getSuperPattern();
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<PatternVariable> getAllVariables() {
        BasicEList<PatternVariable> result = new BasicEList<PatternVariable>();
        result.addAll(getVariables());
        Pattern innerSuperPattern = getSuperPattern();
        while (innerSuperPattern != null) {
            result.addAll(innerSuperPattern.getVariables());
            innerSuperPattern = innerSuperPattern.getSuperPattern();
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<PatternMethod> getAllMethods() {
        BasicEList<PatternMethod> result = new BasicEList<PatternMethod>();
        result.addAll(getMethods());
        Pattern innerSuperPattern = getSuperPattern();
        while (innerSuperPattern != null) {
            result.addAll(innerSuperPattern.getMethods());
            innerSuperPattern = innerSuperPattern.getSuperPattern();
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public PatternParameter getParameter(String name) {
        for (PatternParameter param : getParameters()) {
            if (param.getName().equals(name))
                return param;
        }
        if (getSuperPattern() == null)
            return null;
        return getSuperPattern().getParameter(name);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case PatternPackage.PATTERN__METHODS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getMethods()).basicAdd(otherEnd, msgs);
        case PatternPackage.PATTERN__ORCHESTRATION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getOrchestration()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case PatternPackage.PATTERN__METHODS:
            return ((InternalEList<?>) getMethods()).basicRemove(otherEnd, msgs);
        case PatternPackage.PATTERN__ORCHESTRATION:
            return ((InternalEList<?>) getOrchestration()).basicRemove(otherEnd, msgs);
        case PatternPackage.PATTERN__PARAMETERS:
            return ((InternalEList<?>) getParameters()).basicRemove(otherEnd, msgs);
        case PatternPackage.PATTERN__NATURE:
            return basicSetNature(null, msgs);
        case PatternPackage.PATTERN__VARIABLES:
            return ((InternalEList<?>) getVariables()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case PatternPackage.PATTERN__HEADER_METHOD:
            return getHeaderMethod();
        case PatternPackage.PATTERN__METHODS:
            return getMethods();
        case PatternPackage.PATTERN__FOOTER_METHOD:
            return getFooterMethod();
        case PatternPackage.PATTERN__SUPER_PATTERN:
            if (resolve)
                return getSuperPattern();
            return basicGetSuperPattern();
        case PatternPackage.PATTERN__ORCHESTRATION:
            return getOrchestration();
        case PatternPackage.PATTERN__PARAMETERS:
            return getParameters();
        case PatternPackage.PATTERN__NATURE:
            return getNature();
        case PatternPackage.PATTERN__VARIABLES:
            return getVariables();
        case PatternPackage.PATTERN__INIT_METHOD:
            return getInitMethod();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case PatternPackage.PATTERN__HEADER_METHOD:
            setHeaderMethod((PatternMethod) newValue);
            return;
        case PatternPackage.PATTERN__METHODS:
            getMethods().clear();
            getMethods().addAll((Collection<? extends PatternMethod>) newValue);
            return;
        case PatternPackage.PATTERN__FOOTER_METHOD:
            setFooterMethod((PatternMethod) newValue);
            return;
        case PatternPackage.PATTERN__SUPER_PATTERN:
            setSuperPattern((Pattern) newValue);
            return;
        case PatternPackage.PATTERN__ORCHESTRATION:
            getOrchestration().clear();
            getOrchestration().addAll((Collection<? extends Call>) newValue);
            return;
        case PatternPackage.PATTERN__PARAMETERS:
            getParameters().clear();
            getParameters().addAll((Collection<? extends PatternParameter>) newValue);
            return;
        case PatternPackage.PATTERN__NATURE:
            setNature((PatternNature) newValue);
            return;
        case PatternPackage.PATTERN__VARIABLES:
            getVariables().clear();
            getVariables().addAll((Collection<? extends PatternVariable>) newValue);
            return;
        case PatternPackage.PATTERN__INIT_METHOD:
            setInitMethod((PatternMethod) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case PatternPackage.PATTERN__HEADER_METHOD:
            setHeaderMethod((PatternMethod) null);
            return;
        case PatternPackage.PATTERN__METHODS:
            getMethods().clear();
            return;
        case PatternPackage.PATTERN__FOOTER_METHOD:
            setFooterMethod((PatternMethod) null);
            return;
        case PatternPackage.PATTERN__SUPER_PATTERN:
            setSuperPattern((Pattern) null);
            return;
        case PatternPackage.PATTERN__ORCHESTRATION:
            getOrchestration().clear();
            return;
        case PatternPackage.PATTERN__PARAMETERS:
            getParameters().clear();
            return;
        case PatternPackage.PATTERN__NATURE:
            setNature((PatternNature) null);
            return;
        case PatternPackage.PATTERN__VARIABLES:
            getVariables().clear();
            return;
        case PatternPackage.PATTERN__INIT_METHOD:
            setInitMethod((PatternMethod) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case PatternPackage.PATTERN__HEADER_METHOD:
            return headerMethod != null;
        case PatternPackage.PATTERN__METHODS:
            return methods != null && !methods.isEmpty();
        case PatternPackage.PATTERN__FOOTER_METHOD:
            return footerMethod != null;
        case PatternPackage.PATTERN__SUPER_PATTERN:
            return superPattern != null;
        case PatternPackage.PATTERN__ORCHESTRATION:
            return orchestration != null && !orchestration.isEmpty();
        case PatternPackage.PATTERN__PARAMETERS:
            return parameters != null && !parameters.isEmpty();
        case PatternPackage.PATTERN__NATURE:
            return nature != null;
        case PatternPackage.PATTERN__VARIABLES:
            return variables != null && !variables.isEmpty();
        case PatternPackage.PATTERN__INIT_METHOD:
            return initMethod != null;
        }
        return super.eIsSet(featureID);
    }

} // PatternImpl
