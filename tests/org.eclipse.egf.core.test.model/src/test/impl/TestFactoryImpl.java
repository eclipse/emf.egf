/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import test.*;
import test.ConsoleOutputTestResult;
import test.ExceptionTestResult;
import test.TestCase;
import test.TestFactory;
import test.TestPackage;
import test.TestSuite;
import test.ValidationErrorSeverity;
import test.ValidationErrorTestResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestFactoryImpl extends EFactoryImpl implements TestFactory {
  /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public static TestFactory init() {
        try {
            TestFactory theTestFactory = (TestFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/egf/1.0.0/test"); 
            if (theTestFactory != null) {
                return theTestFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new TestFactoryImpl();
    }

  /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public TestFactoryImpl() {
        super();
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case TestPackage.TEST_SUITE: return createTestSuite();
            case TestPackage.EXCEPTION_TEST_RESULT: return createExceptionTestResult();
            case TestPackage.VALIDATION_ERROR_TEST_RESULT: return createValidationErrorTestResult();
            case TestPackage.CONSOLE_OUTPUT_TEST_RESULT: return createConsoleOutputTestResult();
            case TestPackage.EGF_TEST_CASE: return createEGFTestCase();
            case TestPackage.FILE_OUTPUT_TEST_RESULT: return createFileOutputTestResult();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case TestPackage.VALIDATION_ERROR_SEVERITY:
                return createValidationErrorSeverityFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case TestPackage.VALIDATION_ERROR_SEVERITY:
                return convertValidationErrorSeverityToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public TestSuite createTestSuite() {
        TestSuiteImpl testSuite = new TestSuiteImpl();
        return testSuite;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public ExceptionTestResult createExceptionTestResult() {
        ExceptionTestResultImpl exceptionTestResult = new ExceptionTestResultImpl();
        return exceptionTestResult;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public ValidationErrorTestResult createValidationErrorTestResult() {
        ValidationErrorTestResultImpl validationErrorTestResult = new ValidationErrorTestResultImpl();
        return validationErrorTestResult;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public ConsoleOutputTestResult createConsoleOutputTestResult() {
        ConsoleOutputTestResultImpl consoleOutputTestResult = new ConsoleOutputTestResultImpl();
        return consoleOutputTestResult;
    }

  /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EGFTestCase createEGFTestCase() {
        EGFTestCaseImpl egfTestCase = new EGFTestCaseImpl();
        return egfTestCase;
    }

/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FileOutputTestResult createFileOutputTestResult() {
        FileOutputTestResultImpl fileOutputTestResult = new FileOutputTestResultImpl();
        return fileOutputTestResult;
    }

/**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public ValidationErrorSeverity createValidationErrorSeverityFromString(EDataType eDataType, String initialValue) {
        ValidationErrorSeverity result = ValidationErrorSeverity.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public String convertValidationErrorSeverityToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public TestPackage getTestPackage() {
        return (TestPackage)getEPackage();
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
  @Deprecated
  public static TestPackage getPackage() {
        return TestPackage.eINSTANCE;
    }

} //TestFactoryImpl
