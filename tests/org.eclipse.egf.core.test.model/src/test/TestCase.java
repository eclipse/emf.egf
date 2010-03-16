/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test;

import org.eclipse.egf.model.fcore.Activity;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.TestCase#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.TestPackage#getTestCase()
 * @model abstract="true"
 * @generated
 */
public interface TestCase extends Test {

  /**
     * Returns the value of the '<em><b>Result</b></em>' containment reference.
     * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
     * @return the value of the '<em>Result</em>' containment reference.
     * @see #setResult(TestResult)
     * @see test.TestPackage#getTestCase_Result()
     * @model containment="true"
     * @generated
     */
  TestResult getResult();

  /**
     * Sets the value of the '{@link test.TestCase#getResult <em>Result</em>}' containment reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @param value the new value of the '<em>Result</em>' containment reference.
     * @see #getResult()
     * @generated
     */
  void setResult(TestResult value);
} // TestCase
