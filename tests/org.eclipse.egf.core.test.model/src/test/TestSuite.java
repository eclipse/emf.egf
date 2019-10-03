/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Suite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.TestSuite#getTests <em>Tests</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.TestPackage#getTestSuite()
 * @model
 * @generated
 */
public interface TestSuite extends Test {
  /**
     * Returns the value of the '<em><b>Tests</b></em>' containment reference list.
     * The list contents are of type {@link test.Test}.
     * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tests</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
     * @return the value of the '<em>Tests</em>' containment reference list.
     * @see test.TestPackage#getTestSuite_Tests()
     * @model containment="true"
     * @generated
     */
  EList<Test> getTests();

} // TestSuite
