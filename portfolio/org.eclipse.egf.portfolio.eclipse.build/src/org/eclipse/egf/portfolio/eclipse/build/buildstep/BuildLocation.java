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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Build Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocation#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocation#getBuildStep <em>Build Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getBuildLocation()
 * @model abstract="true"
 * @generated
 */
public interface BuildLocation extends EObject {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Pattern</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Pattern</em>' attribute.
     * @see #setPattern(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getBuildLocation_Pattern()
     * @model
     * @generated
     */

    String getPattern();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocation#getPattern <em>Pattern</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pattern</em>' attribute.
     * @see #getPattern()
     * @generated
     */

    void setPattern(String value);







    /**
     * Returns the value of the '<em><b>Build Step</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#getBuildLocations <em>Build Locations</em>}'.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Build Step</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Build Step</em>' container reference.
     * @see #setBuildStep(BuildStep)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getBuildLocation_BuildStep()
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep#getBuildLocations
     * @model opposite="buildLocations" required="true" transient="false"
     * @generated
     */

    BuildStep getBuildStep();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocation#getBuildStep <em>Build Step</em>}' container reference.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Build Step</em>' container reference.
     * @see #getBuildStep()
     * @generated
     */

    void setBuildStep(BuildStep value);





} // BuildLocation
