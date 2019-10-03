/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension;

import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ecore Tools Generation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsGeneration#getFileName <em>File Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsExtensionPackage#getEcoreToolsGeneration()
 * @model
 * @generated
 */
public interface EcoreToolsGeneration extends EcoreElement {
	/**
	 * Returns the value of the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Name</em>' attribute.
	 * @see #setFileName(String)
	 * @see org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsExtensionPackage#getEcoreToolsGeneration_FileName()
	 * @model
	 * @generated
	 */
	String getFileName();

	/**
	 * Sets the value of the '{@link org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsGeneration#getFileName <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Name</em>' attribute.
	 * @see #getFileName()
	 * @generated
	 */
	void setFileName(String value);

} // EcoreToolsGeneration
