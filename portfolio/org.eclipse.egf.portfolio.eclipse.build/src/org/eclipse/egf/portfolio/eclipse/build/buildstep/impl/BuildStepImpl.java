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

import java.util.Collection;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepImpl;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.Component;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Build Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildStepImpl#getBuildLocations <em>Build Locations</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildStepImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildStepImpl#isAllPlatforms <em>All Platforms</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildStepImpl#isNoBuildersInvocation <em>No Builders Invocation</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildStepImpl#getSkipComponentsRegex <em>Skip Components Regex</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BuildStepImpl extends StepImpl implements BuildStep {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The cached value of the '{@link #getBuildLocations() <em>Build Locations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBuildLocations()
     * @generated
     * @ordered
     */
    protected EList<BuildLocation> buildLocations;




    /**
     * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getComponents()
     * @generated
     * @ordered
     */
    protected EList<Component> components;




    /**
     * The default value of the '{@link #isAllPlatforms() <em>All Platforms</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAllPlatforms()
     * @generated
     * @ordered
     */
    protected static final boolean ALL_PLATFORMS_EDEFAULT = false;


    /**
     * The cached value of the '{@link #isAllPlatforms() <em>All Platforms</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAllPlatforms()
     * @generated
     * @ordered
     */
    protected boolean allPlatforms = ALL_PLATFORMS_EDEFAULT;



    /**
     * The default value of the '{@link #isNoBuildersInvocation() <em>No Builders Invocation</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNoBuildersInvocation()
     * @generated
     * @ordered
     */
    protected static final boolean NO_BUILDERS_INVOCATION_EDEFAULT = false;


    /**
     * The cached value of the '{@link #isNoBuildersInvocation() <em>No Builders Invocation</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNoBuildersInvocation()
     * @generated
     * @ordered
     */
    protected boolean noBuildersInvocation = NO_BUILDERS_INVOCATION_EDEFAULT;


    /**
     * The default value of the '{@link #getSkipComponentsRegex() <em>Skip Components Regex</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSkipComponentsRegex()
     * @generated
     * @ordered
     */
    protected static final String SKIP_COMPONENTS_REGEX_EDEFAULT = ".*\\.source";


    /**
     * The cached value of the '{@link #getSkipComponentsRegex() <em>Skip Components Regex</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSkipComponentsRegex()
     * @generated
     * @ordered
     */
    protected String skipComponentsRegex = SKIP_COMPONENTS_REGEX_EDEFAULT;


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BuildStepImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildstepPackage.Literals.BUILD_STEP;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<BuildLocation> getBuildLocations() {

        if (buildLocations == null) {
            buildLocations = new EObjectContainmentWithInverseEList<BuildLocation>(BuildLocation.class, this, BuildstepPackage.BUILD_STEP__BUILD_LOCATIONS, BuildstepPackage.BUILD_LOCATION__BUILD_STEP);
        }
        return buildLocations;
    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<Component> getComponents() {

        if (components == null) {
            components = new EObjectContainmentWithInverseEList<Component>(Component.class, this, BuildstepPackage.BUILD_STEP__COMPONENTS, BuildstepPackage.COMPONENT__BUILD_STEP);
        }
        return components;
    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public boolean isAllPlatforms() {

        return allPlatforms;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setAllPlatforms(boolean newAllPlatforms) {

        boolean oldAllPlatforms = allPlatforms;
        allPlatforms = newAllPlatforms;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.BUILD_STEP__ALL_PLATFORMS, oldAllPlatforms, allPlatforms));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public boolean isNoBuildersInvocation() {

        return noBuildersInvocation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setNoBuildersInvocation(boolean newNoBuildersInvocation) {

        boolean oldNoBuildersInvocation = noBuildersInvocation;
        noBuildersInvocation = newNoBuildersInvocation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.BUILD_STEP__NO_BUILDERS_INVOCATION, oldNoBuildersInvocation, noBuildersInvocation));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getSkipComponentsRegex() {

        return skipComponentsRegex;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setSkipComponentsRegex(String newSkipComponentsRegex) {

        String oldSkipComponentsRegex = skipComponentsRegex;
        skipComponentsRegex = newSkipComponentsRegex;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.BUILD_STEP__SKIP_COMPONENTS_REGEX, oldSkipComponentsRegex, skipComponentsRegex));

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
            case BuildstepPackage.BUILD_STEP__BUILD_LOCATIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getBuildLocations()).basicAdd(otherEnd, msgs);
            case BuildstepPackage.BUILD_STEP__COMPONENTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getComponents()).basicAdd(otherEnd, msgs);
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
            case BuildstepPackage.BUILD_STEP__BUILD_LOCATIONS:
                return ((InternalEList<?>)getBuildLocations()).basicRemove(otherEnd, msgs);
            case BuildstepPackage.BUILD_STEP__COMPONENTS:
                return ((InternalEList<?>)getComponents()).basicRemove(otherEnd, msgs);
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
            case BuildstepPackage.BUILD_STEP__BUILD_LOCATIONS:
                return getBuildLocations();
            case BuildstepPackage.BUILD_STEP__COMPONENTS:
                return getComponents();
            case BuildstepPackage.BUILD_STEP__ALL_PLATFORMS:
                return isAllPlatforms();
            case BuildstepPackage.BUILD_STEP__NO_BUILDERS_INVOCATION:
                return isNoBuildersInvocation();
            case BuildstepPackage.BUILD_STEP__SKIP_COMPONENTS_REGEX:
                return getSkipComponentsRegex();
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
            case BuildstepPackage.BUILD_STEP__BUILD_LOCATIONS:
                getBuildLocations().clear();
                getBuildLocations().addAll((Collection<? extends BuildLocation>)newValue);
                return;
            case BuildstepPackage.BUILD_STEP__COMPONENTS:
                getComponents().clear();
                getComponents().addAll((Collection<? extends Component>)newValue);
                return;
            case BuildstepPackage.BUILD_STEP__ALL_PLATFORMS:
                setAllPlatforms((Boolean)newValue);
                return;
            case BuildstepPackage.BUILD_STEP__NO_BUILDERS_INVOCATION:
                setNoBuildersInvocation((Boolean)newValue);
                return;
            case BuildstepPackage.BUILD_STEP__SKIP_COMPONENTS_REGEX:
                setSkipComponentsRegex((String)newValue);
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
            case BuildstepPackage.BUILD_STEP__BUILD_LOCATIONS:
                getBuildLocations().clear();
                return;
            case BuildstepPackage.BUILD_STEP__COMPONENTS:
                getComponents().clear();
                return;
            case BuildstepPackage.BUILD_STEP__ALL_PLATFORMS:
                setAllPlatforms(ALL_PLATFORMS_EDEFAULT);
                return;
            case BuildstepPackage.BUILD_STEP__NO_BUILDERS_INVOCATION:
                setNoBuildersInvocation(NO_BUILDERS_INVOCATION_EDEFAULT);
                return;
            case BuildstepPackage.BUILD_STEP__SKIP_COMPONENTS_REGEX:
                setSkipComponentsRegex(SKIP_COMPONENTS_REGEX_EDEFAULT);
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
            case BuildstepPackage.BUILD_STEP__BUILD_LOCATIONS:
                return buildLocations != null && !buildLocations.isEmpty();
            case BuildstepPackage.BUILD_STEP__COMPONENTS:
                return components != null && !components.isEmpty();
            case BuildstepPackage.BUILD_STEP__ALL_PLATFORMS:
                return allPlatforms != ALL_PLATFORMS_EDEFAULT;
            case BuildstepPackage.BUILD_STEP__NO_BUILDERS_INVOCATION:
                return noBuildersInvocation != NO_BUILDERS_INVOCATION_EDEFAULT;
            case BuildstepPackage.BUILD_STEP__SKIP_COMPONENTS_REGEX:
                return SKIP_COMPONENTS_REGEX_EDEFAULT == null ? skipComponentsRegex != null : !SKIP_COMPONENTS_REGEX_EDEFAULT.equals(skipComponentsRegex);
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
        result.append(" (allPlatforms: ");
        result.append(allPlatforms);
        result.append(", noBuildersInvocation: ");
        result.append(noBuildersInvocation);
        result.append(", skipComponentsRegex: ");
        result.append(skipComponentsRegex);
        result.append(')');
        return result.toString();
    }


} //BuildStepImpl
