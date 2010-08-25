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
 * A representation of the model object '<em><b>Publish Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep#getComponent <em>Component</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep#isSigning <em>Signing</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep#isGenerateSources <em>Generate Sources</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getPublishStep()
 * @model
 * @generated
 */
public interface PublishStep extends Step {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Component</b></em>' reference.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Component</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Component</em>' reference.
     * @see #setComponent(Component)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getPublishStep_Component()
     * @model required="true"
     * @generated
     */

    Component getComponent();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep#getComponent <em>Component</em>}' reference.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Component</em>' reference.
     * @see #getComponent()
     * @generated
     */

    void setComponent(Component value);







    /**
     * Returns the value of the '<em><b>Signing</b></em>' attribute.
     * The default value is <code>"false"</code>.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Signing</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Signing</em>' attribute.
     * @see #setSigning(boolean)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getPublishStep_Signing()
     * @model default="false"
     * @generated
     */

    boolean isSigning();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep#isSigning <em>Signing</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Signing</em>' attribute.
     * @see #isSigning()
     * @generated
     */

    void setSigning(boolean value);







    /**
     * Returns the value of the '<em><b>Generate Sources</b></em>' attribute.
     * The default value is <code>"true"</code>.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Generate Sources</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Generate Sources</em>' attribute.
     * @see #setGenerateSources(boolean)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getPublishStep_GenerateSources()
     * @model default="true"
     * @generated
     */

    boolean isGenerateSources();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep#isGenerateSources <em>Generate Sources</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Generate Sources</em>' attribute.
     * @see #isGenerateSources()
     * @generated
     */

    void setGenerateSources(boolean value);





} // PublishStep