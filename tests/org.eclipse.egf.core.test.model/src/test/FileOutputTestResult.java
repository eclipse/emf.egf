/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Output Test Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.FileOutputTestResult#getIFilePath <em>IFile Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.TestPackage#getFileOutputTestResult()
 * @model
 * @generated
 */
public interface FileOutputTestResult extends OutputTestResult {
	/**
     * Returns the value of the '<em><b>IFile Path</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IFile Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>IFile Path</em>' attribute.
     * @see #setIFilePath(String)
     * @see test.TestPackage#getFileOutputTestResult_IFilePath()
     * @model required="true"
     * @generated
     */
	String getIFilePath();

	/**
     * Sets the value of the '{@link test.FileOutputTestResult#getIFilePath <em>IFile Path</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>IFile Path</em>' attribute.
     * @see #getIFilePath()
     * @generated
     */
	void setIFilePath(String value);

} // FileOutputTestResult
