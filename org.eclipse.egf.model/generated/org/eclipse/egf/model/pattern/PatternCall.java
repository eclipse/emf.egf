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

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.PatternCall#getParameterMatching <em>Parameter Matching</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.pattern.PatternPackage#getPatternCall()
 * @model
 * @generated
 */
public interface PatternCall extends AbstractPatternCall {
    /**
     * Returns the value of the '<em><b>Parameter Matching</b></em>' map.
     * The key is of type {@link org.eclipse.egf.model.pattern.PatternParameter},
     * and the value is of type {@link org.eclipse.egf.model.pattern.PatternParameter},
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter Matching</em>' reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter Matching</em>' map.
     * @see org.eclipse.egf.model.pattern.PatternPackage#getPatternCall_ParameterMatching()
     * @model mapType="org.eclipse.egf.model.pattern.Paramerter2ParameterMap<org.eclipse.egf.model.pattern.PatternParameter, org.eclipse.egf.model.pattern.PatternParameter>"
     * @generated
     */
    EMap<PatternParameter, PatternParameter> getParameterMatching();

} // PatternCall
