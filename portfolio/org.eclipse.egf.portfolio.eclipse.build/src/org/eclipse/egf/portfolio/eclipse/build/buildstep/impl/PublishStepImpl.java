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

import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.Component;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Publish Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.PublishStepImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.PublishStepImpl#isSigning <em>Signing</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.PublishStepImpl#isGenerateSources <em>Generate Sources</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.PublishStepImpl#isGenerateDropins <em>Generate Dropins</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PublishStepImpl extends ResultStepImpl implements PublishStep {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getComponent()
     * @generated
     * @ordered
     */
    protected Component component;




    /**
     * The default value of the '{@link #isSigning() <em>Signing</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSigning()
     * @generated
     * @ordered
     */
    protected static final boolean SIGNING_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isSigning() <em>Signing</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSigning()
     * @generated
     * @ordered
     */
    protected boolean signing = SIGNING_EDEFAULT;




    /**
     * The default value of the '{@link #isGenerateSources() <em>Generate Sources</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isGenerateSources()
     * @generated
     * @ordered
     */
    protected static final boolean GENERATE_SOURCES_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isGenerateSources() <em>Generate Sources</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isGenerateSources()
     * @generated
     * @ordered
     */
    protected boolean generateSources = GENERATE_SOURCES_EDEFAULT;



    /**
     * The default value of the '{@link #isGenerateDropins() <em>Generate Dropins</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isGenerateDropins()
     * @generated
     * @ordered
     */
    protected static final boolean GENERATE_DROPINS_EDEFAULT = false;


    /**
     * The cached value of the '{@link #isGenerateDropins() <em>Generate Dropins</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isGenerateDropins()
     * @generated
     * @ordered
     */
    protected boolean generateDropins = GENERATE_DROPINS_EDEFAULT;



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PublishStepImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildstepPackage.Literals.PUBLISH_STEP;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public Component getComponent() {

        if (component != null && component.eIsProxy()) {
            InternalEObject oldComponent = (InternalEObject)component;
            component = (Component)eResolveProxy(oldComponent);
            if (component != oldComponent) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, BuildstepPackage.PUBLISH_STEP__COMPONENT, oldComponent, component));
            }
        }
        return component;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public Component basicGetComponent() {

        return component;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setComponent(Component newComponent) {

        Component oldComponent = component;
        component = newComponent;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.PUBLISH_STEP__COMPONENT, oldComponent, component));

    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public boolean isSigning() {

        return signing;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setSigning(boolean newSigning) {

        boolean oldSigning = signing;
        signing = newSigning;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.PUBLISH_STEP__SIGNING, oldSigning, signing));

    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public boolean isGenerateSources() {

        return generateSources;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setGenerateSources(boolean newGenerateSources) {

        boolean oldGenerateSources = generateSources;
        generateSources = newGenerateSources;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.PUBLISH_STEP__GENERATE_SOURCES, oldGenerateSources, generateSources));

    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public boolean isGenerateDropins() {

        return generateDropins;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setGenerateDropins(boolean newGenerateDropins) {

        boolean oldGenerateDropins = generateDropins;
        generateDropins = newGenerateDropins;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.PUBLISH_STEP__GENERATE_DROPINS, oldGenerateDropins, generateDropins));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuildstepPackage.PUBLISH_STEP__COMPONENT:
                if (resolve) return getComponent();
                return basicGetComponent();
            case BuildstepPackage.PUBLISH_STEP__SIGNING:
                return isSigning();
            case BuildstepPackage.PUBLISH_STEP__GENERATE_SOURCES:
                return isGenerateSources();
            case BuildstepPackage.PUBLISH_STEP__GENERATE_DROPINS:
                return isGenerateDropins();
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
            case BuildstepPackage.PUBLISH_STEP__COMPONENT:
                setComponent((Component)newValue);
                return;
            case BuildstepPackage.PUBLISH_STEP__SIGNING:
                setSigning((Boolean)newValue);
                return;
            case BuildstepPackage.PUBLISH_STEP__GENERATE_SOURCES:
                setGenerateSources((Boolean)newValue);
                return;
            case BuildstepPackage.PUBLISH_STEP__GENERATE_DROPINS:
                setGenerateDropins((Boolean)newValue);
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
            case BuildstepPackage.PUBLISH_STEP__COMPONENT:
                setComponent((Component)null);
                return;
            case BuildstepPackage.PUBLISH_STEP__SIGNING:
                setSigning(SIGNING_EDEFAULT);
                return;
            case BuildstepPackage.PUBLISH_STEP__GENERATE_SOURCES:
                setGenerateSources(GENERATE_SOURCES_EDEFAULT);
                return;
            case BuildstepPackage.PUBLISH_STEP__GENERATE_DROPINS:
                setGenerateDropins(GENERATE_DROPINS_EDEFAULT);
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
            case BuildstepPackage.PUBLISH_STEP__COMPONENT:
                return component != null;
            case BuildstepPackage.PUBLISH_STEP__SIGNING:
                return signing != SIGNING_EDEFAULT;
            case BuildstepPackage.PUBLISH_STEP__GENERATE_SOURCES:
                return generateSources != GENERATE_SOURCES_EDEFAULT;
            case BuildstepPackage.PUBLISH_STEP__GENERATE_DROPINS:
                return generateDropins != GENERATE_DROPINS_EDEFAULT;
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
        result.append(" (signing: ");
        result.append(signing);
        result.append(", generateSources: ");
        result.append(generateSources);
        result.append(", generateDropins: ");
        result.append(generateDropins);
        result.append(')');
        return result.toString();
    }


} //PublishStepImpl
