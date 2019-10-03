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
 * A representation of the model object '<em><b>Build Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#getComponents <em>Components</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#isAllPlatforms <em>All Platforms</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#isNoBuildersInvocation <em>No Builders Invocation</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#getSkipComponentsRegex <em>Skip Components Regex</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getBuildStep()
 * @model
 * @generated
 */
public interface BuildStep extends Step, AbstractBuildLocationContainer {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Components</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.Component}.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.Component#getBuildStep <em>Build Step</em>}'.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Components</em>' containment reference list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getBuildStep_Components()
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.Component#getBuildStep
     * @model opposite="buildStep" containment="true" resolveProxies="true"
     * @generated
     */

    EList<Component> getComponents();







    /**
     * Returns the value of the '<em><b>All Platforms</b></em>' attribute.
     * The default value is <code>"false"</code>.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>All Platforms</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>All Platforms</em>' attribute.
     * @see #setAllPlatforms(boolean)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getBuildStep_AllPlatforms()
     * @model default="false"
     * @generated
     */

    boolean isAllPlatforms();







    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#isAllPlatforms <em>All Platforms</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>All Platforms</em>' attribute.
     * @see #isAllPlatforms()
     * @generated
     */

    void setAllPlatforms(boolean value);







    /**
     * Returns the value of the '<em><b>No Builders Invocation</b></em>' attribute.
     * The default value is <code>"false"</code>.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>No Builders Invocation</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>No Builders Invocation</em>' attribute.
     * @see #setNoBuildersInvocation(boolean)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getBuildStep_NoBuildersInvocation()
     * @model default="false"
     * @generated
     */

    boolean isNoBuildersInvocation();







    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#isNoBuildersInvocation <em>No Builders Invocation</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>No Builders Invocation</em>' attribute.
     * @see #isNoBuildersInvocation()
     * @generated
     */

    void setNoBuildersInvocation(boolean value);







    /**
     * Returns the value of the '<em><b>Skip Components Regex</b></em>' attribute.
     * The default value is <code>".*\\.source"</code>.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Skip Components Regex</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Skip Components Regex</em>' attribute.
     * @see #setSkipComponentsRegex(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getBuildStep_SkipComponentsRegex()
     * @model default=".*\\.source"
     * @generated
     */

    String getSkipComponentsRegex();







    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#getSkipComponentsRegex <em>Skip Components Regex</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Skip Components Regex</em>' attribute.
     * @see #getSkipComponentsRegex()
     * @generated
     */

    void setSkipComponentsRegex(String value);





} // BuildStep
