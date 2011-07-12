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

package org.eclipse.egf.portfolio.eclipse.build.buildstep;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.Step;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Install Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getProfile <em>Profile</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getResultSteps <em>Result Steps</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getUpdateSiteUrls <em>Update Site Urls</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getFeatureNames <em>Feature Names</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getProductNames <em>Product Names</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getInstallStep()
 * @model
 * @generated
 */
public interface InstallStep extends Step {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getInstallStep_Name()
     * @model required="true"
     * @generated
     */

    String getName();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getName <em>Name</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */

    void setName(String value);




    /**
     * Returns the value of the '<em><b>Profile</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Profile</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Profile</em>' attribute.
     * @see #setProfile(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getInstallStep_Profile()
     * @model required="true"
     * @generated
     */

    String getProfile();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getProfile <em>Profile</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Profile</em>' attribute.
     * @see #getProfile()
     * @generated
     */

    void setProfile(String value);




    /**
     * Returns the value of the '<em><b>Result Steps</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStep}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Result Steps</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Result Steps</em>' reference list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getInstallStep_ResultSteps()
     * @model
     * @generated
     */

    EList<ResultStep> getResultSteps();







    /**
     * Returns the value of the '<em><b>Update Site Urls</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Update Site Urls</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Update Site Urls</em>' attribute list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getInstallStep_UpdateSiteUrls()
     * @model
     * @generated
     */

    EList<String> getUpdateSiteUrls();




    /**
     * Returns the value of the '<em><b>Feature Names</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Feature Names</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Feature Names</em>' attribute list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getInstallStep_FeatureNames()
     * @model
     * @generated
     */

    EList<String> getFeatureNames();




    /**
     * Returns the value of the '<em><b>Product Names</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Product Names</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Product Names</em>' attribute list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getInstallStep_ProductNames()
     * @model
     * @generated
     */

    EList<String> getProductNames();





} // InstallStep
