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

import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Deployment;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Job;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.SCM;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Job</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl#getScms <em>Scms</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl#getDeployment <em>Deployment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JobImpl extends AbstractStepContainerImpl implements Job {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


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
     * The cached value of the '{@link #getDeployment() <em>Deployment</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDeployment()
     * @generated
     * @ordered
     */
    protected Deployment deployment;


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

    public Deployment getDeployment() {

        return deployment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public NotificationChain basicSetDeployment(Deployment newDeployment, NotificationChain msgs) {

        Deployment oldDeployment = deployment;
        deployment = newDeployment;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BuildcorePackage.JOB__DEPLOYMENT, oldDeployment, newDeployment);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }

        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setDeployment(Deployment newDeployment) {

        if (newDeployment != deployment) {
            NotificationChain msgs = null;
            if (deployment != null)
                msgs = ((InternalEObject)deployment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BuildcorePackage.JOB__DEPLOYMENT, null, msgs);
            if (newDeployment != null)
                msgs = ((InternalEObject)newDeployment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BuildcorePackage.JOB__DEPLOYMENT, null, msgs);
            msgs = basicSetDeployment(newDeployment, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildcorePackage.JOB__DEPLOYMENT, newDeployment, newDeployment));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BuildcorePackage.JOB__SCMS:
                return basicSetScms(null, msgs);
            case BuildcorePackage.JOB__DEPLOYMENT:
                return basicSetDeployment(null, msgs);
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
            case BuildcorePackage.JOB__SCMS:
                return getScms();
            case BuildcorePackage.JOB__DEPLOYMENT:
                return getDeployment();
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
            case BuildcorePackage.JOB__SCMS:
                setScms((SCM)newValue);
                return;
            case BuildcorePackage.JOB__DEPLOYMENT:
                setDeployment((Deployment)newValue);
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
            case BuildcorePackage.JOB__SCMS:
                setScms((SCM)null);
                return;
            case BuildcorePackage.JOB__DEPLOYMENT:
                setDeployment((Deployment)null);
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
            case BuildcorePackage.JOB__SCMS:
                return scms != null;
            case BuildcorePackage.JOB__DEPLOYMENT:
                return deployment != null;
        }
        return super.eIsSet(featureID);
    }


} //JobImpl
