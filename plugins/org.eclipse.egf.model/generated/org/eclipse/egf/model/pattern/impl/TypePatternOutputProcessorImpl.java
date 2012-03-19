/**
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.pattern.impl;

import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.TypePatternOutputProcessor;
import org.eclipse.egf.model.types.impl.TypeListImpl;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Type Pattern Output Processor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TypePatternOutputProcessorImpl extends TypeListImpl implements TypePatternOutputProcessor {
    /**
     * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected int flags = 0;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypePatternOutputProcessorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PatternPackage.Literals.TYPE_PATTERN_OUTPUT_PROCESSOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public <T extends Object> Class<T> getType() {
        return (Class<T>) org.eclipse.egf.model.pattern.DomainVisitor.class;
    }

} // TypePatternOutputProcessorImpl
