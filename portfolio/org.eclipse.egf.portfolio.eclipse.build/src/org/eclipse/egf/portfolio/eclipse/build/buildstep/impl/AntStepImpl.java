/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v2.0
 *    which accompanies this distribution, and is available at
 *    https://www.eclipse.org/legal/epl-v2.0
 *
 *    SPDX-License-Identifier: EPL-2.0
 * 
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.buildstep.impl;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepImpl;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ant Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.AntStepImpl#getTargetName <em>Target Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.AntStepImpl#getXml <em>Xml</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.AntStepImpl#isRunInEclipse <em>Run In Eclipse</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AntStepImpl extends StepImpl implements AntStep {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The default value of the '{@link #getTargetName() <em>Target Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetName()
     * @generated
     * @ordered
     */
    protected static final String TARGET_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTargetName() <em>Target Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetName()
     * @generated
     * @ordered
     */
    protected String targetName = TARGET_NAME_EDEFAULT;




    /**
     * The default value of the '{@link #getXml() <em>Xml</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXml()
     * @generated
     * @ordered
     */
    protected static final String XML_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getXml() <em>Xml</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXml()
     * @generated
     * @ordered
     */
    protected String xml = XML_EDEFAULT;




    /**
     * The default value of the '{@link #isRunInEclipse() <em>Run In Eclipse</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRunInEclipse()
     * @generated
     * @ordered
     */
    protected static final boolean RUN_IN_ECLIPSE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isRunInEclipse() <em>Run In Eclipse</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRunInEclipse()
     * @generated
     * @ordered
     */
    protected boolean runInEclipse = RUN_IN_ECLIPSE_EDEFAULT;



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AntStepImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildstepPackage.Literals.ANT_STEP;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getTargetName() {

        return targetName;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setTargetName(String newTargetName) {

        String oldTargetName = targetName;
        targetName = newTargetName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.ANT_STEP__TARGET_NAME, oldTargetName, targetName));

    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getXml() {

        return xml;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setXml(String newXml) {

        String oldXml = xml;
        xml = newXml;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.ANT_STEP__XML, oldXml, xml));

    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public boolean isRunInEclipse() {

        return runInEclipse;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setRunInEclipse(boolean newRunInEclipse) {

        boolean oldRunInEclipse = runInEclipse;
        runInEclipse = newRunInEclipse;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.ANT_STEP__RUN_IN_ECLIPSE, oldRunInEclipse, runInEclipse));

    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuildstepPackage.ANT_STEP__TARGET_NAME:
                return getTargetName();
            case BuildstepPackage.ANT_STEP__XML:
                return getXml();
            case BuildstepPackage.ANT_STEP__RUN_IN_ECLIPSE:
                return isRunInEclipse();
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
            case BuildstepPackage.ANT_STEP__TARGET_NAME:
                setTargetName((String)newValue);
                return;
            case BuildstepPackage.ANT_STEP__XML:
                setXml((String)newValue);
                return;
            case BuildstepPackage.ANT_STEP__RUN_IN_ECLIPSE:
                setRunInEclipse((Boolean)newValue);
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
            case BuildstepPackage.ANT_STEP__TARGET_NAME:
                setTargetName(TARGET_NAME_EDEFAULT);
                return;
            case BuildstepPackage.ANT_STEP__XML:
                setXml(XML_EDEFAULT);
                return;
            case BuildstepPackage.ANT_STEP__RUN_IN_ECLIPSE:
                setRunInEclipse(RUN_IN_ECLIPSE_EDEFAULT);
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
            case BuildstepPackage.ANT_STEP__TARGET_NAME:
                return TARGET_NAME_EDEFAULT == null ? targetName != null : !TARGET_NAME_EDEFAULT.equals(targetName);
            case BuildstepPackage.ANT_STEP__XML:
                return XML_EDEFAULT == null ? xml != null : !XML_EDEFAULT.equals(xml);
            case BuildstepPackage.ANT_STEP__RUN_IN_ECLIPSE:
                return runInEclipse != RUN_IN_ECLIPSE_EDEFAULT;
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
        result.append(" (targetName: ");
        result.append(targetName);
        result.append(", xml: ");
        result.append(xml);
        result.append(", runInEclipse: ");
        result.append(runInEclipse);
        result.append(')');
        return result.toString();
    }


} //AntStepImpl
