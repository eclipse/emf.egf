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

package org.eclipse.egf.portfolio.eclipse.build.buildscm.impl;

import org.eclipse.egf.portfolio.eclipse.build.builddeploy.impl.GenerationLocationImpl;

import org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNGenerationLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SVN Generation Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.impl.SVNGenerationLocationImpl#getSvnLocation <em>Svn Location</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SVNGenerationLocationImpl extends GenerationLocationImpl implements SVNGenerationLocation {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
	 * The cached value of the '{@link #getSvnLocation() <em>Svn Location</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSvnLocation()
	 * @generated
	 * @ordered
	 */
    protected SVNLocation svnLocation;



    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected SVNGenerationLocationImpl() {

		super();

	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return BuildscmPackage.Literals.SVN_GENERATION_LOCATION;
	}





    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */

    public SVNLocation getSvnLocation() {

		if (svnLocation != null && svnLocation.eIsProxy()) {
			InternalEObject oldSvnLocation = (InternalEObject)svnLocation;
			svnLocation = (SVNLocation)eResolveProxy(oldSvnLocation);
			if (svnLocation != oldSvnLocation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BuildscmPackage.SVN_GENERATION_LOCATION__SVN_LOCATION, oldSvnLocation, svnLocation));
			}
		}
		return svnLocation;
	}



    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */

    public SVNLocation basicGetSvnLocation() {

		return svnLocation;
	}



    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */

    public void setSvnLocation(SVNLocation newSvnLocation) {

		SVNLocation oldSvnLocation = svnLocation;
		svnLocation = newSvnLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildscmPackage.SVN_GENERATION_LOCATION__SVN_LOCATION, oldSvnLocation, svnLocation));

	}




    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BuildscmPackage.SVN_GENERATION_LOCATION__SVN_LOCATION:
				if (resolve) return getSvnLocation();
				return basicGetSvnLocation();
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
			case BuildscmPackage.SVN_GENERATION_LOCATION__SVN_LOCATION:
				setSvnLocation((SVNLocation)newValue);
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
			case BuildscmPackage.SVN_GENERATION_LOCATION__SVN_LOCATION:
				setSvnLocation((SVNLocation)null);
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
			case BuildscmPackage.SVN_GENERATION_LOCATION__SVN_LOCATION:
				return svnLocation != null;
		}
		return super.eIsSet(featureID);
	}



} //SVNGenerationLocationImpl
