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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.pattern.PatternPackage
 * @generated
 */
public interface PatternFactory extends EFactory {

    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    PatternFactory eINSTANCE = org.eclipse.egf.model.pattern.impl.PatternFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Pattern</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Pattern</em>'.
     * @generated
     */
    Pattern createPattern();

    /**
     * Returns a new object of class '<em>Method</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Method</em>'.
     * @generated
     */
    PatternMethod createPatternMethod();

    /**
     * Returns a new object of class '<em>Parameter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Parameter</em>'.
     * @generated
     */
    PatternParameter createPatternParameter();

    /**
     * Returns a new object of class '<em>Library</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Library</em>'.
     * @generated
     */
    PatternLibrary createPatternLibrary();

    /**
     * Returns a new object of class '<em>Viewpoint</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Viewpoint</em>'.
     * @generated
     */
    PatternViewpoint createPatternViewpoint();

    /**
     * Returns a new object of class '<em>Call</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Call</em>'.
     * @generated
     */
    PatternCall createPatternCall();

    /**
     * Returns a new object of class '<em>Super Call</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Super Call</em>'.
     * @generated
     */
    SuperCall createSuperCall();

    /**
     * Returns a new object of class '<em>Method Call</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Method Call</em>'.
     * @generated
     */
    MethodCall createMethodCall();

    /**
     * Returns a new object of class '<em>Variable</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Variable</em>'.
     * @generated
     */
    PatternVariable createPatternVariable();

    /**
     * Returns a new object of class '<em>Injected Call</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Injected Call</em>'.
     * @generated
     */
    PatternInjectedCall createPatternInjectedCall();

    /**
     * Returns a new object of class '<em>Basic Query</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Basic Query</em>'.
     * @generated
     */
    BasicQuery createBasicQuery();

    /**
     * Returns a new object of class '<em>String Query</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>String Query</em>'.
     * @generated
     */
    StringQuery createStringQuery();

    /**
     * Returns a new object of class '<em>Custom Query</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Custom Query</em>'.
     * @generated
     */
    CustomQuery createCustomQuery();

    /**
     * Returns a new object of class '<em>Type Pattern Execution Reporter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Type Pattern Execution Reporter</em>'.
     * @generated
     */
    TypePatternExecutionReporter createTypePatternExecutionReporter();

    /**
     * Returns a new object of class '<em>Back Call</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Back Call</em>'.
     * @generated
     */
    BackCall createBackCall();

    /**
     * Returns a new object of class '<em>Type Pattern Call Back Handler</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Type Pattern Call Back Handler</em>'.
     * @generated
     */
    TypePatternCallBackHandler createTypePatternCallBackHandler();

    /**
     * Returns a new object of class '<em>Type Pattern Domain Visitor</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Type Pattern Domain Visitor</em>'.
     * @generated
     */
    TypePatternDomainVisitor createTypePatternDomainVisitor();

    /**
     * Returns a new object of class '<em>Type Pattern List</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Type Pattern List</em>'.
     * @generated
     */
    TypePatternList createTypePatternList();

    /**
     * Returns a new object of class '<em>Type Pattern Substitution</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Type Pattern Substitution</em>'.
     * @generated
     */
    TypePatternSubstitution createTypePatternSubstitution();

    /**
     * Returns a new object of class '<em>Substitution</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Substitution</em>'.
     * @generated
     */
    Substitution createSubstitution();

    /**
     * Returns an instance of data type '<em>Context</em>' corresponding the given literal.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal a literal of the data type.
     * @return a new instance value of the data type.
     * @generated
     */
    PatternContext createPatternContext(String literal);

    /**
     * Returns a literal representation of an instance of data type '<em>Context</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param instanceValue an instance value of the data type.
     * @return a literal representation of the instance value.
     * @generated
     */
    String convertPatternContext(PatternContext instanceValue);

    /**
     * Returns an instance of data type '<em>Exception</em>' corresponding the given literal.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal a literal of the data type.
     * @return a new instance value of the data type.
     * @generated
     */
    PatternException createPatternException(String literal);

    /**
     * Returns a literal representation of an instance of data type '<em>Exception</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param instanceValue an instance value of the data type.
     * @return a literal representation of the instance value.
     * @generated
     */
    String convertPatternException(PatternException instanceValue);

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    PatternPackage getPatternPackage();

} // PatternFactory
