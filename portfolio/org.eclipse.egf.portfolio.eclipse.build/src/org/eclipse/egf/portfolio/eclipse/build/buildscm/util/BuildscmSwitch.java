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

package org.eclipse.egf.portfolio.eclipse.build.buildscm.util;

import java.util.List;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.SCM;

import org.eclipse.egf.portfolio.eclipse.build.builddeploy.GenerationLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.*;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.AbstractBuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.PatternBuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.SourceBuildLocation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmPackage
 * @generated
 */
public class BuildscmSwitch<T> {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
	 * The cached model package
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected static BuildscmPackage modelPackage;

    /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public BuildscmSwitch() {
		if (modelPackage == null) {
			modelPackage = BuildscmPackage.eINSTANCE;
		}
	}

    /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

				/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

				/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
    
				protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case BuildscmPackage.SVN: {
				SVN svn = (SVN)theEObject;
				T result = caseSVN(svn);
				if (result == null) result = caseSCM(svn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BuildscmPackage.SVN_LOCATION: {
				SVNLocation svnLocation = (SVNLocation)theEObject;
				T result = caseSVNLocation(svnLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BuildscmPackage.SVN_BUILD_LOCATION: {
				SVNBuildLocation svnBuildLocation = (SVNBuildLocation)theEObject;
				T result = caseSVNBuildLocation(svnBuildLocation);
				if (result == null) result = caseSourceBuildLocation(svnBuildLocation);
				if (result == null) result = casePatternBuildLocation(svnBuildLocation);
				if (result == null) result = caseAbstractBuildLocation(svnBuildLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BuildscmPackage.SVN_GENERATION_LOCATION: {
				SVNGenerationLocation svnGenerationLocation = (SVNGenerationLocation)theEObject;
				T result = caseSVNGenerationLocation(svnGenerationLocation);
				if (result == null) result = caseGenerationLocation(svnGenerationLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BuildscmPackage.GIT: {
				GIT git = (GIT)theEObject;
				T result = caseGIT(git);
				if (result == null) result = caseSCM(git);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BuildscmPackage.GIT_LOCATION: {
				GITLocation gitLocation = (GITLocation)theEObject;
				T result = caseGITLocation(gitLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BuildscmPackage.GIT_BUILD_LOCATION: {
				GITBuildLocation gitBuildLocation = (GITBuildLocation)theEObject;
				T result = caseGITBuildLocation(gitBuildLocation);
				if (result == null) result = caseSourceBuildLocation(gitBuildLocation);
				if (result == null) result = casePatternBuildLocation(gitBuildLocation);
				if (result == null) result = caseAbstractBuildLocation(gitBuildLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BuildscmPackage.GIT_GENERATION_LOCATION: {
				GITGenerationLocation gitGenerationLocation = (GITGenerationLocation)theEObject;
				T result = caseGITGenerationLocation(gitGenerationLocation);
				if (result == null) result = caseGenerationLocation(gitGenerationLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>SVN</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SVN</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseSVN(SVN object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>SVN Location</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SVN Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseSVNLocation(SVNLocation object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>SVN Build Location</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SVN Build Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseSVNBuildLocation(SVNBuildLocation object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>SVN Generation Location</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SVN Generation Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseSVNGenerationLocation(SVNGenerationLocation object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>GIT</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GIT</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseGIT(GIT object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>GIT Location</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GIT Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseGITLocation(GITLocation object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>GIT Build Location</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GIT Build Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseGITBuildLocation(GITBuildLocation object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>GIT Generation Location</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GIT Generation Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseGITGenerationLocation(GITGenerationLocation object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>SCM</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCM</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseSCM(SCM object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Build Location</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Build Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseAbstractBuildLocation(AbstractBuildLocation object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Build Location</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Build Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T casePatternBuildLocation(PatternBuildLocation object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Source Build Location</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Build Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseSourceBuildLocation(SourceBuildLocation object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Generation Location</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generation Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseGenerationLocation(GenerationLocation object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
    
				public T defaultCase(EObject object) {
		return null;
	}

} //BuildscmSwitch
