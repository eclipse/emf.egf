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
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getProfile <em>Profile</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getResultSteps <em>Result Steps</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getUpdateSiteUrls <em>Update Site Urls</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getFeatureNames <em>Feature Names</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getProductNames <em>Product Names</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#isInstallResultStepsSourceFeatures <em>Install Result Steps Source Features</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getP2_os <em>P2 os</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getP2_ws <em>P2 ws</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getP2_arch <em>P2 arch</em>}</li>
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
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getInstallStep_Id()
     * @model required="true"
     * @generated
     */

    String getId();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getId <em>Id</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */

    void setId(String value);




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




    /**
     * Returns the value of the '<em><b>Install Result Steps Source Features</b></em>' attribute.
     * The default value is <code>"false"</code>.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Install Result Steps Source Features</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Install Result Steps Source Features</em>' attribute.
     * @see #setInstallResultStepsSourceFeatures(boolean)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getInstallStep_InstallResultStepsSourceFeatures()
     * @model default="false"
     * @generated
     */

    boolean isInstallResultStepsSourceFeatures();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#isInstallResultStepsSourceFeatures <em>Install Result Steps Source Features</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Install Result Steps Source Features</em>' attribute.
     * @see #isInstallResultStepsSourceFeatures()
     * @generated
     */

    void setInstallResultStepsSourceFeatures(boolean value);




    /**
     * Returns the value of the '<em><b>P2 os</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>P2 os</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>P2 os</em>' attribute.
     * @see #setP2_os(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getInstallStep_P2_os()
     * @model
     * @generated
     */

    String getP2_os();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getP2_os <em>P2 os</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>P2 os</em>' attribute.
     * @see #getP2_os()
     * @generated
     */

    void setP2_os(String value);




    /**
     * Returns the value of the '<em><b>P2 ws</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>P2 ws</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>P2 ws</em>' attribute.
     * @see #setP2_ws(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getInstallStep_P2_ws()
     * @model
     * @generated
     */

    String getP2_ws();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getP2_ws <em>P2 ws</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>P2 ws</em>' attribute.
     * @see #getP2_ws()
     * @generated
     */

    void setP2_ws(String value);




    /**
     * Returns the value of the '<em><b>P2 arch</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>P2 arch</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>P2 arch</em>' attribute.
     * @see #setP2_arch(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getInstallStep_P2_arch()
     * @model
     * @generated
     */

    String getP2_arch();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep#getP2_arch <em>P2 arch</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>P2 arch</em>' attribute.
     * @see #getP2_arch()
     * @generated
     */

    void setP2_arch(String value);





} // InstallStep
