/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.pattern;

import org.eclipse.egf.model.fcore.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.PatternElement#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.pattern.PatternPackage#getPatternElement()
 * @model abstract="true"
 * @generated
 */
public interface PatternElement extends ModelElement {
    /**
     * Returns the value of the '<em><b>Container</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.pattern.PatternLibrary#getElements <em>Elements</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Container</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Container</em>' container reference.
     * @see #setContainer(PatternLibrary)
     * @see org.eclipse.egf.model.pattern.PatternPackage#getPatternElement_Container()
     * @see org.eclipse.egf.model.pattern.PatternLibrary#getElements
     * @model opposite="elements" resolveProxies="false" transient="false"
     * @generated
     */
    PatternLibrary getContainer();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.pattern.PatternElement#getContainer <em>Container</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Container</em>' container reference.
     * @see #getContainer()
     * @generated
     */
    void setContainer(PatternLibrary value);

} // PatternElement
