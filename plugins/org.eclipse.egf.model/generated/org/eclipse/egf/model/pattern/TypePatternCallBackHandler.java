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

import org.eclipse.egf.model.types.TypeAbstractClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Pattern Call Back Handler</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.egf.model.pattern.PatternPackage#getTypePatternCallBackHandler()
 * @model
 * @generated
 */
public interface TypePatternCallBackHandler extends TypeAbstractClass {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation" required="true" TBounds="org.eclipse.emf.ecore.EJavaObject"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (Class<T>) org.eclipse.egf.model.pattern.CallBackHandler.class;'"
     * @generated
     */
    <T extends Object> Class<T> getType();

} // TypePatternCallBackHandler
