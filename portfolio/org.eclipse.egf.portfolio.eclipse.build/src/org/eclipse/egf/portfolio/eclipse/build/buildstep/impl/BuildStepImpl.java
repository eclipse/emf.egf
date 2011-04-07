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
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildStepImpl#getCleanBeforeBuild <em>Clean Before Build</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.BuildStepImpl#isAllPlatforms <em>All Platforms</em>}</li>
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
     * The default value of the '{@link #getCleanBeforeBuild() <em>Clean Before Build</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCleanBeforeBuild()
     * @generated
     * @ordered
     */
    protected static final CLEAN_TYPE CLEAN_BEFORE_BUILD_EDEFAULT = CLEAN_TYPE.RESULT;

    /**
     * The cached value of the '{@link #getCleanBeforeBuild() <em>Clean Before Build</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCleanBeforeBuild()
     * @generated
     * @ordered
     */
    protected CLEAN_TYPE cleanBeforeBuild = CLEAN_BEFORE_BUILD_EDEFAULT;



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

    public CLEAN_TYPE getCleanBeforeBuild() {

        return cleanBeforeBuild;
    }



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setCleanBeforeBuild(CLEAN_TYPE newCleanBeforeBuild) {

        CLEAN_TYPE oldCleanBeforeBuild = cleanBeforeBuild;
        cleanBeforeBuild = newCleanBeforeBuild == null ? CLEAN_BEFORE_BUILD_EDEFAULT : newCleanBeforeBuild;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.BUILD_STEP__CLEAN_BEFORE_BUILD, oldCleanBeforeBuild, cleanBeforeBuild));

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
            case BuildstepPackage.BUILD_STEP__CLEAN_BEFORE_BUILD:
                return getCleanBeforeBuild();
            case BuildstepPackage.BUILD_STEP__ALL_PLATFORMS:
                return isAllPlatforms();
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
            case BuildstepPackage.BUILD_STEP__CLEAN_BEFORE_BUILD:
                setCleanBeforeBuild((CLEAN_TYPE)newValue);
                return;
            case BuildstepPackage.BUILD_STEP__ALL_PLATFORMS:
                setAllPlatforms((Boolean)newValue);
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
            case BuildstepPackage.BUILD_STEP__CLEAN_BEFORE_BUILD:
                setCleanBeforeBuild(CLEAN_BEFORE_BUILD_EDEFAULT);
                return;
            case BuildstepPackage.BUILD_STEP__ALL_PLATFORMS:
                setAllPlatforms(ALL_PLATFORMS_EDEFAULT);
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
            case BuildstepPackage.BUILD_STEP__CLEAN_BEFORE_BUILD:
                return cleanBeforeBuild != CLEAN_BEFORE_BUILD_EDEFAULT;
            case BuildstepPackage.BUILD_STEP__ALL_PLATFORMS:
                return allPlatforms != ALL_PLATFORMS_EDEFAULT;
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
        result.append(" (cleanBeforeBuild: ");
        result.append(cleanBeforeBuild);
        result.append(", allPlatforms: ");
        result.append(allPlatforms);
        result.append(')');
        return result.toString();
    }


} //BuildStepImpl
