/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    All rights reserved. This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v1.0
 *    which accompanies this distribution, and is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 *   
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.buildcore.impl;

import java.util.Collection;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Job;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.SCM;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Step;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Trigger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Job</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl#getSteps <em>Steps</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl#getScms <em>Scms</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl#getTriggers <em>Triggers</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl#isEnabled <em>Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JobImpl extends ItemImpl implements Job {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;




    /**
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;




    /**
     * The cached value of the '{@link #getSteps() <em>Steps</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSteps()
     * @generated
     * @ordered
     */
    protected EList<Step> steps;




    /**
     * The cached value of the '{@link #getScms() <em>Scms</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScms()
     * @generated
     * @ordered
     */
    protected SCM scms;




    /**
     * The cached value of the '{@link #getTriggers() <em>Triggers</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTriggers()
     * @generated
     * @ordered
     */
    protected EList<Trigger> triggers;




    /**
     * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnabled()
     * @generated
     * @ordered
     */
    protected static final boolean ENABLED_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnabled()
     * @generated
     * @ordered
     */
    protected boolean enabled = ENABLED_EDEFAULT;






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected JobImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildcorePackage.Literals.JOB;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getName() {

        return name;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setName(String newName) {

        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildcorePackage.JOB__NAME, oldName, name));

    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getDescription() {

        return description;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setDescription(String newDescription) {

        String oldDescription = description;
        description = newDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildcorePackage.JOB__DESCRIPTION, oldDescription, description));

    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<Step> getSteps() {

        if (steps == null) {
            steps = new EObjectContainmentWithInverseEList<Step>(Step.class, this, BuildcorePackage.JOB__STEPS, BuildcorePackage.STEP__JOB);
        }
        return steps;
    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public SCM getScms() {

        return scms;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public NotificationChain basicSetScms(SCM newScms, NotificationChain msgs) {

        SCM oldScms = scms;
        scms = newScms;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BuildcorePackage.JOB__SCMS, oldScms, newScms);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }

        return msgs;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setScms(SCM newScms) {

        if (newScms != scms) {
            NotificationChain msgs = null;
            if (scms != null)
                msgs = ((InternalEObject)scms).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BuildcorePackage.JOB__SCMS, null, msgs);
            if (newScms != null)
                msgs = ((InternalEObject)newScms).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BuildcorePackage.JOB__SCMS, null, msgs);
            msgs = basicSetScms(newScms, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildcorePackage.JOB__SCMS, newScms, newScms));

    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<Trigger> getTriggers() {

        if (triggers == null) {
            triggers = new EObjectContainmentEList<Trigger>(Trigger.class, this, BuildcorePackage.JOB__TRIGGERS);
        }
        return triggers;
    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public boolean isEnabled() {

        return enabled;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setEnabled(boolean newEnabled) {

        boolean oldEnabled = enabled;
        enabled = newEnabled;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildcorePackage.JOB__ENABLED, oldEnabled, enabled));

    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BuildcorePackage.JOB__STEPS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSteps()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BuildcorePackage.JOB__STEPS:
                return ((InternalEList<?>)getSteps()).basicRemove(otherEnd, msgs);
            case BuildcorePackage.JOB__SCMS:
                return basicSetScms(null, msgs);
            case BuildcorePackage.JOB__TRIGGERS:
                return ((InternalEList<?>)getTriggers()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuildcorePackage.JOB__NAME:
                return getName();
            case BuildcorePackage.JOB__DESCRIPTION:
                return getDescription();
            case BuildcorePackage.JOB__STEPS:
                return getSteps();
            case BuildcorePackage.JOB__SCMS:
                return getScms();
            case BuildcorePackage.JOB__TRIGGERS:
                return getTriggers();
            case BuildcorePackage.JOB__ENABLED:
                return isEnabled();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case BuildcorePackage.JOB__NAME:
                setName((String)newValue);
                return;
            case BuildcorePackage.JOB__DESCRIPTION:
                setDescription((String)newValue);
                return;
            case BuildcorePackage.JOB__STEPS:
                getSteps().clear();
                getSteps().addAll((Collection<? extends Step>)newValue);
                return;
            case BuildcorePackage.JOB__SCMS:
                setScms((SCM)newValue);
                return;
            case BuildcorePackage.JOB__TRIGGERS:
                getTriggers().clear();
                getTriggers().addAll((Collection<? extends Trigger>)newValue);
                return;
            case BuildcorePackage.JOB__ENABLED:
                setEnabled((Boolean)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case BuildcorePackage.JOB__NAME:
                setName(NAME_EDEFAULT);
                return;
            case BuildcorePackage.JOB__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case BuildcorePackage.JOB__STEPS:
                getSteps().clear();
                return;
            case BuildcorePackage.JOB__SCMS:
                setScms((SCM)null);
                return;
            case BuildcorePackage.JOB__TRIGGERS:
                getTriggers().clear();
                return;
            case BuildcorePackage.JOB__ENABLED:
                setEnabled(ENABLED_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case BuildcorePackage.JOB__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case BuildcorePackage.JOB__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
            case BuildcorePackage.JOB__STEPS:
                return steps != null && !steps.isEmpty();
            case BuildcorePackage.JOB__SCMS:
                return scms != null;
            case BuildcorePackage.JOB__TRIGGERS:
                return triggers != null && !triggers.isEmpty();
            case BuildcorePackage.JOB__ENABLED:
                return enabled != ENABLED_EDEFAULT;
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
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(", description: ");
        result.append(description);
        result.append(", enabled: ");
        result.append(enabled);
        result.append(')');
        return result.toString();
    }


} //JobImpl
