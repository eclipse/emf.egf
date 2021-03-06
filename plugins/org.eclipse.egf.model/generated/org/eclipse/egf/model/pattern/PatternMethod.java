/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.pattern;

import org.eclipse.egf.model.fcore.NamedModelElement;
import org.eclipse.emf.common.util.URI;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.PatternMethod#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.PatternMethod#getPatternFilePath <em>Pattern File Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.pattern.PatternPackage#getPatternMethod()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='MandatoryName ValidURI ValidPatternFilePath'"
 * @generated
 */
public interface PatternMethod extends NamedModelElement {

    /**
     * Returns the value of the '<em><b>Pattern</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.pattern.Pattern#getMethods <em>Methods</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Pattern</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Pattern</em>' container reference.
     * @see #setPattern(Pattern)
     * @see org.eclipse.egf.model.pattern.PatternPackage#getPatternMethod_Pattern()
     * @see org.eclipse.egf.model.pattern.Pattern#getMethods
     * @model opposite="methods" resolveProxies="false" required="true" transient="false"
     * @generated
     */
    Pattern getPattern();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.pattern.PatternMethod#getPattern <em>Pattern</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pattern</em>' container reference.
     * @see #getPattern()
     * @generated
     */
    void setPattern(Pattern value);

    /**
     * Returns the value of the '<em><b>Pattern File Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Pattern File Path</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Pattern File Path</em>' attribute.
     * @see #setPatternFilePath(URI)
     * @see org.eclipse.egf.model.pattern.PatternPackage#getPatternMethod_PatternFilePath()
     * @model dataType="org.eclipse.egf.model.types.URI" required="true"
     * @generated
     */
    URI getPatternFilePath();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.pattern.PatternMethod#getPatternFilePath <em>Pattern File Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pattern File Path</em>' attribute.
     * @see #getPatternFilePath()
     * @generated
     */
    void setPatternFilePath(URI value);

} // PatternMethod
