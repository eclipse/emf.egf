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
package org.eclipse.egf.model.fcore;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contract Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fcore.ContractValue#getContract <em>Contract</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.ContractValue#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.egf.model.fcore.ContractValue#getPluginId <em>Plugin Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fcore.FcorePackage#getContractValue()
 * @model
 * @generated
 */
public interface ContractValue extends ContextValue {
    /**
     * Returns the value of the '<em><b>Contract</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Contract</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Contract</em>' reference.
     * @see #setContract(Contract)
     * @see org.eclipse.egf.model.fcore.FcorePackage#getContractValue_Contract()
     * @model required="true"
     * @generated
     */
    Contract getContract();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.fcore.ContractValue#getContract <em>Contract</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Contract</em>' reference.
     * @see #getContract()
     * @generated
     */
    void setContract(Contract value);

    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * If value is a stringValue then readableValue is equals to value.<br>
     * Else if  value is a classValue then readableValue is equals to the fully class name according to value attribute content. 
     * 
     * <!-- end-model-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see org.eclipse.egf.model.fcore.FcorePackage#getContractValue_Value()
     * @model required="true"
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.fcore.ContractValue#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(String value);

    /**
     * Returns the value of the '<em><b>Plugin Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Plugin Id</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Plugin Id</em>' attribute.
     * @see #setPluginId(String)
     * @see org.eclipse.egf.model.fcore.FcorePackage#getContractValue_PluginId()
     * @model
     * @generated
     */
    String getPluginId();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.fcore.ContractValue#getPluginId <em>Plugin Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Plugin Id</em>' attribute.
     * @see #getPluginId()
     * @generated
     */
    void setPluginId(String value);

} // ContractValue
