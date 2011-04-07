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
 * A representation of the model object '<em><b>Build Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#getBuildLocations <em>Build Locations</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#getComponents <em>Components</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#getCleanBeforeBuild <em>Clean Before Build</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#isAllPlatforms <em>All Platforms</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getBuildStep()
 * @model
 * @generated
 */
public interface BuildStep extends Step {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Build Locations</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocation}.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocation#getBuildStep <em>Build Step</em>}'.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Build Locations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Build Locations</em>' containment reference list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getBuildStep_BuildLocations()
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocation#getBuildStep
     * @model opposite="buildStep" containment="true"
     * @generated
     */

    EList<BuildLocation> getBuildLocations();







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
     * @model opposite="buildStep" containment="true"
     * @generated
     */

    EList<Component> getComponents();







    /**
     * Returns the value of the '<em><b>Clean Before Build</b></em>' attribute.
     * The default value is <code>"Result"</code>.
     * The literals are from the enumeration {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Clean Before Build</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Clean Before Build</em>' attribute.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE
     * @see #setCleanBeforeBuild(CLEAN_TYPE)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getBuildStep_CleanBeforeBuild()
     * @model default="Result"
     * @generated
     */

    CLEAN_TYPE getCleanBeforeBuild();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#getCleanBeforeBuild <em>Clean Before Build</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Clean Before Build</em>' attribute.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE
     * @see #getCleanBeforeBuild()
     * @generated
     */

    void setCleanBeforeBuild(CLEAN_TYPE value);







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





} // BuildStep
