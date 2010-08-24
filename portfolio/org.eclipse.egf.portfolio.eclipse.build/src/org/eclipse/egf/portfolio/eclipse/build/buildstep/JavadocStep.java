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
 * A representation of the model object '<em><b>Javadoc Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep#getSources <em>Sources</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep#getIncludes <em>Includes</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep#getExcludes <em>Excludes</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getJavadocStep()
 * @model
 * @generated
 */
public interface JavadocStep extends Step {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Sources</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.egf.portfolio.eclipse.build.buildstep.SourceBuildLocation}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sources</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sources</em>' reference list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getJavadocStep_Sources()
     * @model required="true"
     * @generated
     */

    EList<SourceBuildLocation> getSources();







    /**
     * Returns the value of the '<em><b>Includes</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Includes</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Includes</em>' attribute list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getJavadocStep_Includes()
     * @model
     * @generated
     */

    EList<String> getIncludes();







    /**
     * Returns the value of the '<em><b>Excludes</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Excludes</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Excludes</em>' attribute list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getJavadocStep_Excludes()
     * @model
     * @generated
     */

    EList<String> getExcludes();







    /**
     * Returns the value of the '<em><b>Links</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Links</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Links</em>' attribute list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage#getJavadocStep_Links()
     * @model
     * @generated
     */

    EList<String> getLinks();





} // JavadocStep
