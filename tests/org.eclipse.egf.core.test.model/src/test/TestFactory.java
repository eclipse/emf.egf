/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see test.TestPackage
 * @generated
 */
public interface TestFactory extends EFactory {
  /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  TestFactory eINSTANCE = test.impl.TestFactoryImpl.init();

  /**
     * Returns a new object of class '<em>Suite</em>'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return a new object of class '<em>Suite</em>'.
     * @generated
     */
  TestSuite createTestSuite();

  /**
     * Returns a new object of class '<em>Exception Test Result</em>'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return a new object of class '<em>Exception Test Result</em>'.
     * @generated
     */
  ExceptionTestResult createExceptionTestResult();

  /**
     * Returns a new object of class '<em>Validation Error Test Result</em>'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return a new object of class '<em>Validation Error Test Result</em>'.
     * @generated
     */
  ValidationErrorTestResult createValidationErrorTestResult();

  /**
     * Returns a new object of class '<em>Console Output Test Result</em>'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return a new object of class '<em>Console Output Test Result</em>'.
     * @generated
     */
  ConsoleOutputTestResult createConsoleOutputTestResult();

  /**
     * Returns a new object of class '<em>EGF Test Case</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>EGF Test Case</em>'.
     * @generated
     */
    EGFTestCase createEGFTestCase();

/**
     * Returns a new object of class '<em>File Output Test Result</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>File Output Test Result</em>'.
     * @generated
     */
	FileOutputTestResult createFileOutputTestResult();

/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
  TestPackage getTestPackage();

} //TestFactory
