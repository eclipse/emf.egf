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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep#getLaunchConfigurationPath <em>Launch Configuration Path</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep#isCodeCoverage <em>Code Coverage</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getTestStep()
 * @model
 * @generated
 */
public interface TestStep extends Step {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Launch Configuration Path</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Launch Configuration Path</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Launch Configuration Path</em>' attribute.
     * @see #setLaunchConfigurationPath(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getTestStep_LaunchConfigurationPath()
     * @model required="true"
     * @generated
     */

    String getLaunchConfigurationPath();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep#getLaunchConfigurationPath <em>Launch Configuration Path</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Launch Configuration Path</em>' attribute.
     * @see #getLaunchConfigurationPath()
     * @generated
     */

    void setLaunchConfigurationPath(String value);







    /**
     * Returns the value of the '<em><b>Code Coverage</b></em>' attribute.
     * The default value is <code>"false"</code>.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Code Coverage</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Code Coverage</em>' attribute.
     * @see #setCodeCoverage(boolean)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getTestStep_CodeCoverage()
     * @model default="false"
     * @generated
     */

    boolean isCodeCoverage();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep#isCodeCoverage <em>Code Coverage</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Code Coverage</em>' attribute.
     * @see #isCodeCoverage()
     * @generated
     */

    void setCodeCoverage(boolean value);





} // TestStep
