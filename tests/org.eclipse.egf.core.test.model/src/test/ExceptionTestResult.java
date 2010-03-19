/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exception Test Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.ExceptionTestResult#getExceptionClass <em>Exception Class</em>}</li>
 *   <li>{@link test.ExceptionTestResult#getExceptionMessage <em>Exception Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.TestPackage#getExceptionTestResult()
 * @model
 * @generated
 */
public interface ExceptionTestResult extends TestResult {
  /**
     * Returns the value of the '<em><b>Exception Class</b></em>' attribute.
     * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exception Class</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
     * @return the value of the '<em>Exception Class</em>' attribute.
     * @see #setExceptionClass(Class)
     * @see test.TestPackage#getExceptionTestResult_ExceptionClass()
     * @model required="true"
     * @generated
     */
  Class<?> getExceptionClass();

  /**
     * Sets the value of the '{@link test.ExceptionTestResult#getExceptionClass <em>Exception Class</em>}' attribute.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @param value the new value of the '<em>Exception Class</em>' attribute.
     * @see #getExceptionClass()
     * @generated
     */
  void setExceptionClass(Class<?> value);

  /**
     * Returns the value of the '<em><b>Exception Message</b></em>' attribute.
     * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exception Message</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
     * @return the value of the '<em>Exception Message</em>' attribute.
     * @see #setExceptionMessage(String)
     * @see test.TestPackage#getExceptionTestResult_ExceptionMessage()
     * @model
     * @generated
     */
  String getExceptionMessage();

  /**
     * Sets the value of the '{@link test.ExceptionTestResult#getExceptionMessage <em>Exception Message</em>}' attribute.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @param value the new value of the '<em>Exception Message</em>' attribute.
     * @see #getExceptionMessage()
     * @generated
     */
  void setExceptionMessage(String value);

} // ExceptionTestResult
