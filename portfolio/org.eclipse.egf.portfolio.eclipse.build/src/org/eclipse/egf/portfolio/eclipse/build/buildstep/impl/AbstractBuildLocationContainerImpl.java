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

import java.util.Collection;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.AbstractBuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.AbstractBuildLocationContainer;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Build Location Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.AbstractBuildLocationContainerImpl#getBuildLocations <em>Build Locations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractBuildLocationContainerImpl extends EObjectImpl implements AbstractBuildLocationContainer {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The cached value of the '{@link #getBuildLocations() <em>Build Locations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBuildLocations()
     * @generated
     * @ordered
     */
    protected EList<AbstractBuildLocation> buildLocations;



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AbstractBuildLocationContainerImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildstepPackage.Literals.ABSTRACT_BUILD_LOCATION_CONTAINER;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<AbstractBuildLocation> getBuildLocations() {

        if (buildLocations == null) {
            buildLocations = new EObjectContainmentEList.Resolving<AbstractBuildLocation>(AbstractBuildLocation.class, this, BuildstepPackage.ABSTRACT_BUILD_LOCATION_CONTAINER__BUILD_LOCATIONS);
        }
        return buildLocations;
    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BuildstepPackage.ABSTRACT_BUILD_LOCATION_CONTAINER__BUILD_LOCATIONS:
                return ((InternalEList<?>)getBuildLocations()).basicRemove(otherEnd, msgs);
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
            case BuildstepPackage.ABSTRACT_BUILD_LOCATION_CONTAINER__BUILD_LOCATIONS:
                return getBuildLocations();
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
            case BuildstepPackage.ABSTRACT_BUILD_LOCATION_CONTAINER__BUILD_LOCATIONS:
                getBuildLocations().clear();
                getBuildLocations().addAll((Collection<? extends AbstractBuildLocation>)newValue);
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
            case BuildstepPackage.ABSTRACT_BUILD_LOCATION_CONTAINER__BUILD_LOCATIONS:
                getBuildLocations().clear();
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
            case BuildstepPackage.ABSTRACT_BUILD_LOCATION_CONTAINER__BUILD_LOCATIONS:
                return buildLocations != null && !buildLocations.isEmpty();
        }
        return super.eIsSet(featureID);
    }



} //AbstractBuildLocationContainerImpl
