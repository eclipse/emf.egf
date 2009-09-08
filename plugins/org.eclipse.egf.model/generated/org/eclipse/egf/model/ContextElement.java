/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.model;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Context Element</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.ContextElement#getContractElementReference <em>Contract Element Reference</em>}</li>
 *   <li>{@link org.eclipse.egf.model.ContextElement#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.egf.model.ContextElement#getReadableValue <em>Readable Value</em>}</li>
 *   <li>{@link org.eclipse.egf.model.ContextElement#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.egf.model.ContextElement#getContractReferenceId <em>Contract Reference Id</em>}</li>
 *   <li>{@link org.eclipse.egf.model.ContextElement#getContextType <em>Context Type</em>}</li>
 *   <li>{@link org.eclipse.egf.model.ContextElement#getPluginId <em>Plugin Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.ModelPackage#getContextElement()
 * @model
 * @generated
 */
public interface ContextElement extends NamedModelElementWithId {
  /**
   * Returns the value of the '<em><b>Contract Element Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contract Element Reference</em>' containment reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contract Element Reference</em>' containment reference.
   * @see #setContractElementReference(ContractElementReference)
   * @see org.eclipse.egf.model.ModelPackage#getContextElement_ContractElementReference()
   * @model containment="true"
   * @generated
   */
  ContractElementReference getContractElementReference();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.ContextElement#getContractElementReference <em>Contract Element Reference</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Contract Element Reference</em>' containment reference.
   * @see #getContractElementReference()
   * @generated
   */
  void setContractElementReference(ContractElementReference value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(Object)
   * @see org.eclipse.egf.model.ModelPackage#getContextElement_Value()
   * @model
   * @generated
   */
  Object getValue();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.ContextElement#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(Object value);

  /**
   * Returns the value of the '<em><b>Readable Value</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> If value is a
   * stringValue then readableValue is equals to value.<br>
   * Else if value is a classValue then readableValue is equals to the fully class name according to value attribute content. <!-- end-model-doc -->
   * @return the value of the '<em>Readable Value</em>' attribute.
   * @see #setReadableValue(String)
   * @see org.eclipse.egf.model.ModelPackage#getContextElement_ReadableValue()
   * @model required="true"
   * @generated
   */
  String getReadableValue();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.ContextElement#getReadableValue <em>Readable Value</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param value the new value of the '<em>Readable Value</em>' attribute.
   * @see #getReadableValue()
   * @generated
   */
  void setReadableValue(String value);

  /**
   * Returns the value of the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Key</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Key</em>' attribute.
   * @see #setKey(String)
   * @see org.eclipse.egf.model.ModelPackage#getContextElement_Key()
   * @model
   * @generated
   */
  String getKey();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.ContextElement#getKey <em>Key</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Key</em>' attribute.
   * @see #getKey()
   * @generated
   */
  void setKey(String value);

  /**
   * Returns the value of the '<em><b>Contract Reference Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contract Reference Id</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contract Reference Id</em>' attribute.
   * @see #setContractReferenceId(String)
   * @see org.eclipse.egf.model.ModelPackage#getContextElement_ContractReferenceId()
   * @model
   * @generated
   */
  String getContractReferenceId();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.ContextElement#getContractReferenceId <em>Contract Reference Id</em>}' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Contract Reference Id</em>' attribute.
   * @see #getContractReferenceId()
   * @generated
   */
  void setContractReferenceId(String value);

  /**
   * Returns the value of the '<em><b>Context Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Context Type</em>' containment reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Context Type</em>' containment reference.
   * @see #setContextType(Type)
   * @see org.eclipse.egf.model.ModelPackage#getContextElement_ContextType()
   * @model containment="true"
   * @generated
   */
  Type getContextType();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.ContextElement#getContextType <em>Context Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Context Type</em>' containment reference.
   * @see #getContextType()
   * @generated
   */
  void setContextType(Type value);

  /**
   * Returns the value of the '<em><b>Plugin Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Plugin Id</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Plugin Id</em>' attribute.
   * @see #setPluginId(String)
   * @see org.eclipse.egf.model.ModelPackage#getContextElement_PluginId()
   * @model
   * @generated
   */
  String getPluginId();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.ContextElement#getPluginId <em>Plugin Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * @param value the new value of the '<em>Plugin Id</em>' attribute.
   * @see #getPluginId()
   * @generated
   */
  void setPluginId(String value);

} // ContextElement
