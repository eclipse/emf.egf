/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.pattern;

import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Pattern Substitution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.TypePatternSubstitution#getSubstitutions <em>Substitutions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.pattern.PatternPackage#getTypePatternSubstitution()
 * @model
 * @generated
 */
public interface TypePatternSubstitution extends Type {

    /**
     * Returns the value of the '<em><b>Substitutions</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.egf.model.pattern.Substitution}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Substitutions</em>' map isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Substitutions</em>' containment reference list.
     * @see org.eclipse.egf.model.pattern.PatternPackage#getTypePatternSubstitution_Substitutions()
     * @model containment="true"
     * @generated
     */
    EList<Substitution> getSubstitutions();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation" required="true" TBounds="org.eclipse.emf.ecore.EJavaObject"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (Class<T>) org.eclipse.egf.model.pattern.TypePatternSubstitution.class;'"
     * @generated
     */
    <T extends Object> Class<T> getType();

} // TypePatternSubstitution
