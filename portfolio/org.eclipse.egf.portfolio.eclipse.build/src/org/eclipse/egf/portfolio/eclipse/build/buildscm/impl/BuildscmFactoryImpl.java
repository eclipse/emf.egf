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

package org.eclipse.egf.portfolio.eclipse.build.buildscm.impl;

import org.eclipse.egf.portfolio.eclipse.build.buildscm.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BuildscmFactoryImpl extends EFactoryImpl implements BuildscmFactory {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static BuildscmFactory init() {
		try {
			BuildscmFactory theBuildscmFactory = (BuildscmFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/egf/1.0.0/buildscm"); 
			if (theBuildscmFactory != null) {
				return theBuildscmFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BuildscmFactoryImpl();
	}

    /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public BuildscmFactoryImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BuildscmPackage.SVN: return createSVN();
			case BuildscmPackage.SVN_LOCATION: return createSVNLocation();
			case BuildscmPackage.SVN_BUILD_LOCATION: return createSVNBuildLocation();
			case BuildscmPackage.SVN_GENERATION_LOCATION: return createSVNGenerationLocation();
			case BuildscmPackage.GIT: return createGIT();
			case BuildscmPackage.GIT_LOCATION: return createGITLocation();
			case BuildscmPackage.GIT_BUILD_LOCATION: return createGITBuildLocation();
			case BuildscmPackage.GIT_GENERATION_LOCATION: return createGITGenerationLocation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case BuildscmPackage.SVN_PROTOCOL:
				return createSVNProtocolFromString(eDataType, initialValue);
			case BuildscmPackage.GIT_PROTOCOL:
				return createGITProtocolFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case BuildscmPackage.SVN_PROTOCOL:
				return convertSVNProtocolToString(eDataType, instanceValue);
			case BuildscmPackage.GIT_PROTOCOL:
				return convertGITProtocolToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SVN createSVN() {
		SVNImpl svn = new SVNImpl();
		return svn;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SVNLocation createSVNLocation() {
		SVNLocationImpl svnLocation = new SVNLocationImpl();
		return svnLocation;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SVNBuildLocation createSVNBuildLocation() {
		SVNBuildLocationImpl svnBuildLocation = new SVNBuildLocationImpl();
		return svnBuildLocation;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SVNGenerationLocation createSVNGenerationLocation() {
		SVNGenerationLocationImpl svnGenerationLocation = new SVNGenerationLocationImpl();
		return svnGenerationLocation;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public GIT createGIT() {
		GITImpl git = new GITImpl();
		return git;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public GITLocation createGITLocation() {
		GITLocationImpl gitLocation = new GITLocationImpl();
		return gitLocation;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public GITBuildLocation createGITBuildLocation() {
		GITBuildLocationImpl gitBuildLocation = new GITBuildLocationImpl();
		return gitBuildLocation;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public GITGenerationLocation createGITGenerationLocation() {
		GITGenerationLocationImpl gitGenerationLocation = new GITGenerationLocationImpl();
		return gitGenerationLocation;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SVNProtocol createSVNProtocolFromString(EDataType eDataType, String initialValue) {
		SVNProtocol result = SVNProtocol.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String convertSVNProtocolToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public GITProtocol createGITProtocolFromString(EDataType eDataType, String initialValue) {
		GITProtocol result = GITProtocol.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String convertGITProtocolToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public BuildscmPackage getBuildscmPackage() {
		return (BuildscmPackage)getEPackage();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
    @Deprecated
    public static BuildscmPackage getPackage() {
		return BuildscmPackage.eINSTANCE;
	}

} //BuildscmFactoryImpl
