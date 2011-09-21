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

package org.eclipse.egf.portfolio.eclipse.build.buildstep.impl;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepImpl;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.TestStepImpl#getLaunchConfigurationPath <em>Launch Configuration Path</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.TestStepImpl#isCodeCoverage <em>Code Coverage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestStepImpl extends StepImpl implements TestStep {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The default value of the '{@link #getLaunchConfigurationPath() <em>Launch Configuration Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLaunchConfigurationPath()
     * @generated
     * @ordered
     */
    protected static final String LAUNCH_CONFIGURATION_PATH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLaunchConfigurationPath() <em>Launch Configuration Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLaunchConfigurationPath()
     * @generated
     * @ordered
     */
    protected String launchConfigurationPath = LAUNCH_CONFIGURATION_PATH_EDEFAULT;




    /**
     * The default value of the '{@link #isCodeCoverage() <em>Code Coverage</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isCodeCoverage()
     * @generated
     * @ordered
     */
    protected static final boolean CODE_COVERAGE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isCodeCoverage() <em>Code Coverage</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isCodeCoverage()
     * @generated
     * @ordered
     */
    protected boolean codeCoverage = CODE_COVERAGE_EDEFAULT;



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TestStepImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildstepPackage.Literals.TEST_STEP;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getLaunchConfigurationPath() {

        return launchConfigurationPath;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setLaunchConfigurationPath(String newLaunchConfigurationPath) {

        String oldLaunchConfigurationPath = launchConfigurationPath;
        launchConfigurationPath = newLaunchConfigurationPath;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.TEST_STEP__LAUNCH_CONFIGURATION_PATH, oldLaunchConfigurationPath, launchConfigurationPath));

    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public boolean isCodeCoverage() {

        return codeCoverage;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setCodeCoverage(boolean newCodeCoverage) {

        boolean oldCodeCoverage = codeCoverage;
        codeCoverage = newCodeCoverage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.TEST_STEP__CODE_COVERAGE, oldCodeCoverage, codeCoverage));

    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuildstepPackage.TEST_STEP__LAUNCH_CONFIGURATION_PATH:
                return getLaunchConfigurationPath();
            case BuildstepPackage.TEST_STEP__CODE_COVERAGE:
                return isCodeCoverage();
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
            case BuildstepPackage.TEST_STEP__LAUNCH_CONFIGURATION_PATH:
                setLaunchConfigurationPath((String)newValue);
                return;
            case BuildstepPackage.TEST_STEP__CODE_COVERAGE:
                setCodeCoverage((Boolean)newValue);
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
            case BuildstepPackage.TEST_STEP__LAUNCH_CONFIGURATION_PATH:
                setLaunchConfigurationPath(LAUNCH_CONFIGURATION_PATH_EDEFAULT);
                return;
            case BuildstepPackage.TEST_STEP__CODE_COVERAGE:
                setCodeCoverage(CODE_COVERAGE_EDEFAULT);
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
            case BuildstepPackage.TEST_STEP__LAUNCH_CONFIGURATION_PATH:
                return LAUNCH_CONFIGURATION_PATH_EDEFAULT == null ? launchConfigurationPath != null : !LAUNCH_CONFIGURATION_PATH_EDEFAULT.equals(launchConfigurationPath);
            case BuildstepPackage.TEST_STEP__CODE_COVERAGE:
                return codeCoverage != CODE_COVERAGE_EDEFAULT;
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
        result.append(" (launchConfigurationPath: ");
        result.append(launchConfigurationPath);
        result.append(", codeCoverage: ");
        result.append(codeCoverage);
        result.append(')');
        return result.toString();
    }


} //TestStepImpl
