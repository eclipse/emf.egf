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

import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Viewpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.PatternViewpoint#getLibraries <em>Libraries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.pattern.PatternPackage#getPatternViewpoint()
 * @model
 * @generated
 */
public interface PatternViewpoint extends Viewpoint {

    /**
     * Returns the value of the '<em><b>Libraries</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.egf.model.pattern.PatternLibrary}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Libraries</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Libraries</em>' containment reference list.
     * @see org.eclipse.egf.model.pattern.PatternPackage#getPatternViewpoint_Libraries()
     * @model containment="true"
     * @generated
     */
    EList<PatternLibrary> getLibraries();

} // PatternViewpoint
