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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Chain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ChainImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ChainImpl#getJobs <em>Jobs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChainImpl extends ItemImpl implements Chain {
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
     * The cached value of the '{@link #getJobs() <em>Jobs</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getJobs()
     * @generated
     * @ordered
     */
    protected EList<Job> jobs;



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ChainImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildcorePackage.Literals.CHAIN;
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
            eNotify(new ENotificationImpl(this, Notification.SET, BuildcorePackage.CHAIN__NAME, oldName, name));

    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<Job> getJobs() {

        if (jobs == null) {
            jobs = new EObjectContainmentEList.Resolving<Job>(Job.class, this, BuildcorePackage.CHAIN__JOBS);
        }
        return jobs;
    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BuildcorePackage.CHAIN__JOBS:
                return ((InternalEList<?>)getJobs()).basicRemove(otherEnd, msgs);
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
            case BuildcorePackage.CHAIN__NAME:
                return getName();
            case BuildcorePackage.CHAIN__JOBS:
                return getJobs();
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
            case BuildcorePackage.CHAIN__NAME:
                setName((String)newValue);
                return;
            case BuildcorePackage.CHAIN__JOBS:
                getJobs().clear();
                getJobs().addAll((Collection<? extends Job>)newValue);
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
            case BuildcorePackage.CHAIN__NAME:
                setName(NAME_EDEFAULT);
                return;
            case BuildcorePackage.CHAIN__JOBS:
                getJobs().clear();
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
            case BuildcorePackage.CHAIN__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case BuildcorePackage.CHAIN__JOBS:
                return jobs != null && !jobs.isEmpty();
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
        result.append(')');
        return result.toString();
    }


} //ChainImpl
