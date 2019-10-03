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

package org.eclipse.egf.portfolio.eclipse.build.builddeploy;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.Deployment;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hudson Deployment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getAssignedNode <em>Assigned Node</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getJdkName <em>Jdk Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getAntName <em>Ant Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getBuildId <em>Build Id</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getUserDeployServerUrl <em>User Deploy Server Url</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getUserDeployJobName <em>User Deploy Job Name</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getUsers <em>Users</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getTriggers <em>Triggers</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getGenerationLocation <em>Generation Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage#getHudsonDeployment()
 * @model
 * @generated
 */
public interface HudsonDeployment extends Deployment {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Assigned Node</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Assigned Node</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Assigned Node</em>' attribute.
     * @see #setAssignedNode(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage#getHudsonDeployment_AssignedNode()
     * @model
     * @generated
     */

    String getAssignedNode();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getAssignedNode <em>Assigned Node</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Assigned Node</em>' attribute.
     * @see #getAssignedNode()
     * @generated
     */

    void setAssignedNode(String value);







    /**
     * Returns the value of the '<em><b>Jdk Name</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Jdk Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Jdk Name</em>' attribute.
     * @see #setJdkName(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage#getHudsonDeployment_JdkName()
     * @model
     * @generated
     */

    String getJdkName();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getJdkName <em>Jdk Name</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Jdk Name</em>' attribute.
     * @see #getJdkName()
     * @generated
     */

    void setJdkName(String value);







    /**
     * Returns the value of the '<em><b>Ant Name</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ant Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ant Name</em>' attribute.
     * @see #setAntName(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage#getHudsonDeployment_AntName()
     * @model
     * @generated
     */

    String getAntName();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getAntName <em>Ant Name</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ant Name</em>' attribute.
     * @see #getAntName()
     * @generated
     */

    void setAntName(String value);







    /**
     * Returns the value of the '<em><b>Build Id</b></em>' attribute.
     * The default value is <code>"yyyyMMdd-HHmm"</code>.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Build Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Build Id</em>' attribute.
     * @see #setBuildId(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage#getHudsonDeployment_BuildId()
     * @model default="yyyyMMdd-HHmm"
     * @generated
     */

    String getBuildId();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getBuildId <em>Build Id</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Build Id</em>' attribute.
     * @see #getBuildId()
     * @generated
     */

    void setBuildId(String value);




    /**
     * Returns the value of the '<em><b>Enabled</b></em>' attribute.
     * The default value is <code>"true"</code>.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enabled</em>' attribute.
     * @see #setEnabled(boolean)
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage#getHudsonDeployment_Enabled()
     * @model default="true"
     * @generated
     */

    boolean isEnabled();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#isEnabled <em>Enabled</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enabled</em>' attribute.
     * @see #isEnabled()
     * @generated
     */

    void setEnabled(boolean value);




    /**
     * Returns the value of the '<em><b>User Deploy Server Url</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>User Deploy Server Url</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>User Deploy Server Url</em>' attribute.
     * @see #setUserDeployServerUrl(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage#getHudsonDeployment_UserDeployServerUrl()
     * @model
     * @generated
     */

    String getUserDeployServerUrl();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getUserDeployServerUrl <em>User Deploy Server Url</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>User Deploy Server Url</em>' attribute.
     * @see #getUserDeployServerUrl()
     * @generated
     */

    void setUserDeployServerUrl(String value);




    /**
     * Returns the value of the '<em><b>User Deploy Job Name</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>User Deploy Job Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>User Deploy Job Name</em>' attribute.
     * @see #setUserDeployJobName(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage#getHudsonDeployment_UserDeployJobName()
     * @model
     * @generated
     */

    String getUserDeployJobName();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getUserDeployJobName <em>User Deploy Job Name</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>User Deploy Job Name</em>' attribute.
     * @see #getUserDeployJobName()
     * @generated
     */

    void setUserDeployJobName(String value);




    /**
     * Returns the value of the '<em><b>Users</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.User}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Users</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Users</em>' containment reference list.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage#getHudsonDeployment_Users()
     * @model containment="true" resolveProxies="true"
     * @generated
     */

    EList<User> getUsers();







    /**
     * Returns the value of the '<em><b>Triggers</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.Trigger}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Triggers</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Triggers</em>' containment reference list.
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage#getHudsonDeployment_Triggers()
     * @model containment="true" resolveProxies="true"
     * @generated
     */

    EList<Trigger> getTriggers();







    /**
     * Returns the value of the '<em><b>Generation Location</b></em>' containment reference.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Generation Location</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Generation Location</em>' containment reference.
     * @see #setGenerationLocation(GenerationLocation)
     * @see org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage#getHudsonDeployment_GenerationLocation()
     * @model containment="true" resolveProxies="true"
     * @generated
     */

    GenerationLocation getGenerationLocation();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment#getGenerationLocation <em>Generation Location</em>}' containment reference.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Generation Location</em>' containment reference.
     * @see #getGenerationLocation()
     * @generated
     */

    void setGenerationLocation(GenerationLocation value);





} // HudsonDeployment
