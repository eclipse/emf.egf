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

import org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepImpl;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.SourceBuildLocation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Javadoc Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.JavadocStepImpl#getSources <em>Sources</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.JavadocStepImpl#getIncludes <em>Includes</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.JavadocStepImpl#getExcludes <em>Excludes</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.JavadocStepImpl#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavadocStepImpl extends StepImpl implements JavadocStep {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The cached value of the '{@link #getSources() <em>Sources</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSources()
     * @generated
     * @ordered
     */
    protected EList<SourceBuildLocation> sources;




    /**
     * The cached value of the '{@link #getIncludes() <em>Includes</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIncludes()
     * @generated
     * @ordered
     */
    protected EList<String> includes;




    /**
     * The cached value of the '{@link #getExcludes() <em>Excludes</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExcludes()
     * @generated
     * @ordered
     */
    protected EList<String> excludes;




    /**
     * The cached value of the '{@link #getLinks() <em>Links</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLinks()
     * @generated
     * @ordered
     */
    protected EList<String> links;



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected JavadocStepImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildstepPackage.Literals.JAVADOC_STEP;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<SourceBuildLocation> getSources() {

        if (sources == null) {
            sources = new EObjectResolvingEList<SourceBuildLocation>(SourceBuildLocation.class, this, BuildstepPackage.JAVADOC_STEP__SOURCES);
        }
        return sources;
    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<String> getIncludes() {

        if (includes == null) {
            includes = new EDataTypeUniqueEList<String>(String.class, this, BuildstepPackage.JAVADOC_STEP__INCLUDES);
        }
        return includes;
    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<String> getExcludes() {

        if (excludes == null) {
            excludes = new EDataTypeUniqueEList<String>(String.class, this, BuildstepPackage.JAVADOC_STEP__EXCLUDES);
        }
        return excludes;
    }






    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<String> getLinks() {

        if (links == null) {
            links = new EDataTypeUniqueEList<String>(String.class, this, BuildstepPackage.JAVADOC_STEP__LINKS);
        }
        return links;
    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuildstepPackage.JAVADOC_STEP__SOURCES:
                return getSources();
            case BuildstepPackage.JAVADOC_STEP__INCLUDES:
                return getIncludes();
            case BuildstepPackage.JAVADOC_STEP__EXCLUDES:
                return getExcludes();
            case BuildstepPackage.JAVADOC_STEP__LINKS:
                return getLinks();
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
            case BuildstepPackage.JAVADOC_STEP__SOURCES:
                getSources().clear();
                getSources().addAll((Collection<? extends SourceBuildLocation>)newValue);
                return;
            case BuildstepPackage.JAVADOC_STEP__INCLUDES:
                getIncludes().clear();
                getIncludes().addAll((Collection<? extends String>)newValue);
                return;
            case BuildstepPackage.JAVADOC_STEP__EXCLUDES:
                getExcludes().clear();
                getExcludes().addAll((Collection<? extends String>)newValue);
                return;
            case BuildstepPackage.JAVADOC_STEP__LINKS:
                getLinks().clear();
                getLinks().addAll((Collection<? extends String>)newValue);
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
            case BuildstepPackage.JAVADOC_STEP__SOURCES:
                getSources().clear();
                return;
            case BuildstepPackage.JAVADOC_STEP__INCLUDES:
                getIncludes().clear();
                return;
            case BuildstepPackage.JAVADOC_STEP__EXCLUDES:
                getExcludes().clear();
                return;
            case BuildstepPackage.JAVADOC_STEP__LINKS:
                getLinks().clear();
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
            case BuildstepPackage.JAVADOC_STEP__SOURCES:
                return sources != null && !sources.isEmpty();
            case BuildstepPackage.JAVADOC_STEP__INCLUDES:
                return includes != null && !includes.isEmpty();
            case BuildstepPackage.JAVADOC_STEP__EXCLUDES:
                return excludes != null && !excludes.isEmpty();
            case BuildstepPackage.JAVADOC_STEP__LINKS:
                return links != null && !links.isEmpty();
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
        result.append(" (includes: ");
        result.append(includes);
        result.append(", excludes: ");
        result.append(excludes);
        result.append(", links: ");
        result.append(links);
        result.append(')');
        return result.toString();
    }


} //JavadocStepImpl
