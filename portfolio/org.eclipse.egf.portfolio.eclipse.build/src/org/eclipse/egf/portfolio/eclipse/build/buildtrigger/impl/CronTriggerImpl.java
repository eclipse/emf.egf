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

package org.eclipse.egf.portfolio.eclipse.build.buildtrigger.impl;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.TriggerImpl;

import org.eclipse.egf.portfolio.eclipse.build.buildtrigger.BuildtriggerPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildtrigger.CronTrigger;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cron Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildtrigger.impl.CronTriggerImpl#getPlanning <em>Planning</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CronTriggerImpl extends TriggerImpl implements CronTrigger {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The default value of the '{@link #getPlanning() <em>Planning</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPlanning()
     * @generated
     * @ordered
     */
    protected static final String PLANNING_EDEFAULT = "00 06 * * *";

    /**
     * The cached value of the '{@link #getPlanning() <em>Planning</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPlanning()
     * @generated
     * @ordered
     */
    protected String planning = PLANNING_EDEFAULT;



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CronTriggerImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildtriggerPackage.Literals.CRON_TRIGGER;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getPlanning() {

        return planning;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setPlanning(String newPlanning) {

        String oldPlanning = planning;
        planning = newPlanning;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildtriggerPackage.CRON_TRIGGER__PLANNING, oldPlanning, planning));

    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuildtriggerPackage.CRON_TRIGGER__PLANNING:
                return getPlanning();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case BuildtriggerPackage.CRON_TRIGGER__PLANNING:
                setPlanning((String)newValue);
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
            case BuildtriggerPackage.CRON_TRIGGER__PLANNING:
                setPlanning(PLANNING_EDEFAULT);
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
            case BuildtriggerPackage.CRON_TRIGGER__PLANNING:
                return PLANNING_EDEFAULT == null ? planning != null : !PLANNING_EDEFAULT.equals(planning);
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
        result.append(" (planning: ");
        result.append(planning);
        result.append(')');
        return result.toString();
    }


} //CronTriggerImpl
