/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Substitution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.Substitution#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.Substitution#getIncoming <em>Incoming</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.pattern.PatternPackage#getSubstitution()
 * @model
 * @generated
 */
public interface Substitution extends EObject {
    /**
     * Returns the value of the '<em><b>Outgoing</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Outgoing</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Outgoing</em>' reference.
     * @see #setOutgoing(Pattern)
     * @see org.eclipse.egf.model.pattern.PatternPackage#getSubstitution_Outgoing()
     * @model
     * @generated
     */
    Pattern getOutgoing();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.pattern.Substitution#getOutgoing <em>Outgoing</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Outgoing</em>' reference.
     * @see #getOutgoing()
     * @generated
     */
    void setOutgoing(Pattern value);

    /**
     * Returns the value of the '<em><b>Incoming</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.egf.model.pattern.Pattern}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Incoming</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Incoming</em>' reference list.
     * @see org.eclipse.egf.model.pattern.PatternPackage#getSubstitution_Incoming()
     * @model
     * @generated
     */
    EList<Pattern> getIncoming();

} // Substitution
