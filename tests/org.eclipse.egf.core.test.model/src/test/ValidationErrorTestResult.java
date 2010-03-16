/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Validation Error Test Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.ValidationErrorTestResult#getSeverity <em>Severity</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.TestPackage#getValidationErrorTestResult()
 * @model
 * @generated
 */
public interface ValidationErrorTestResult extends TestResult {
  /**
     * Returns the value of the '<em><b>Severity</b></em>' attribute.
     * The literals are from the enumeration {@link test.ValidationErrorSeverity}.
     * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Severity</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
     * @return the value of the '<em>Severity</em>' attribute.
     * @see test.ValidationErrorSeverity
     * @see #setSeverity(ValidationErrorSeverity)
     * @see test.TestPackage#getValidationErrorTestResult_Severity()
     * @model required="true"
     * @generated
     */
  ValidationErrorSeverity getSeverity();

  /**
     * Sets the value of the '{@link test.ValidationErrorTestResult#getSeverity <em>Severity</em>}' attribute.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @param value the new value of the '<em>Severity</em>' attribute.
     * @see test.ValidationErrorSeverity
     * @see #getSeverity()
     * @generated
     */
  void setSeverity(ValidationErrorSeverity value);

} // ValidationErrorTestResult
