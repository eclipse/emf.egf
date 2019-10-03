/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see test.TestFactory
 * @model kind="package"
 * @generated
 */
public interface TestPackage extends EPackage {
  /**
     * The package name.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  String eNAME = "test";

  /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  String eNS_URI = "http://www.eclipse.org/egf/1.0.0/test";

  /**
     * The package namespace name.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  String eNS_PREFIX = "test";

  /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  TestPackage eINSTANCE = test.impl.TestPackageImpl.init();

  /**
     * The meta object id for the '{@link test.Test <em>Test</em>}' class.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see test.Test
     * @see test.impl.TestPackageImpl#getTest()
     * @generated
     */
  int TEST = 0;

  /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TEST__NAME = 0;

  /**
     * The number of structural features of the '<em>Test</em>' class.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TEST_FEATURE_COUNT = 1;

  /**
     * The meta object id for the '{@link test.impl.TestSuiteImpl <em>Suite</em>}' class.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see test.impl.TestSuiteImpl
     * @see test.impl.TestPackageImpl#getTestSuite()
     * @generated
     */
  int TEST_SUITE = 1;

  /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TEST_SUITE__NAME = TEST__NAME;

  /**
     * The feature id for the '<em><b>Tests</b></em>' containment reference list.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TEST_SUITE__TESTS = TEST_FEATURE_COUNT + 0;

  /**
     * The number of structural features of the '<em>Suite</em>' class.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TEST_SUITE_FEATURE_COUNT = TEST_FEATURE_COUNT + 1;

  /**
     * The meta object id for the '{@link test.impl.TestCaseImpl <em>Case</em>}' class.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see test.impl.TestCaseImpl
     * @see test.impl.TestPackageImpl#getTestCase()
     * @generated
     */
  int TEST_CASE = 2;

  /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TEST_CASE__NAME = TEST__NAME;

  /**
     * The feature id for the '<em><b>Result</b></em>' containment reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TEST_CASE__RESULT = TEST_FEATURE_COUNT + 0;

  /**
     * The number of structural features of the '<em>Case</em>' class.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TEST_CASE_FEATURE_COUNT = TEST_FEATURE_COUNT + 1;

  /**
     * The meta object id for the '{@link test.impl.TestResultImpl <em>Result</em>}' class.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see test.impl.TestResultImpl
     * @see test.impl.TestPackageImpl#getTestResult()
     * @generated
     */
  int TEST_RESULT = 3;

  /**
     * The number of structural features of the '<em>Result</em>' class.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TEST_RESULT_FEATURE_COUNT = 0;


  /**
     * The meta object id for the '{@link test.impl.ExceptionTestResultImpl <em>Exception Test Result</em>}' class.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see test.impl.ExceptionTestResultImpl
     * @see test.impl.TestPackageImpl#getExceptionTestResult()
     * @generated
     */
  int EXCEPTION_TEST_RESULT = 4;

  /**
     * The feature id for the '<em><b>Exception Class</b></em>' attribute.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXCEPTION_TEST_RESULT__EXCEPTION_CLASS = TEST_RESULT_FEATURE_COUNT + 0;

  /**
     * The feature id for the '<em><b>Exception Message</b></em>' attribute.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXCEPTION_TEST_RESULT__EXCEPTION_MESSAGE = TEST_RESULT_FEATURE_COUNT + 1;

  /**
     * The number of structural features of the '<em>Exception Test Result</em>' class.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXCEPTION_TEST_RESULT_FEATURE_COUNT = TEST_RESULT_FEATURE_COUNT + 2;

  /**
     * The meta object id for the '{@link test.impl.ValidationErrorTestResultImpl <em>Validation Error Test Result</em>}' class.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see test.impl.ValidationErrorTestResultImpl
     * @see test.impl.TestPackageImpl#getValidationErrorTestResult()
     * @generated
     */
  int VALIDATION_ERROR_TEST_RESULT = 5;

  /**
     * The feature id for the '<em><b>Severity</b></em>' attribute.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int VALIDATION_ERROR_TEST_RESULT__SEVERITY = TEST_RESULT_FEATURE_COUNT + 0;

  /**
     * The number of structural features of the '<em>Validation Error Test Result</em>' class.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int VALIDATION_ERROR_TEST_RESULT_FEATURE_COUNT = TEST_RESULT_FEATURE_COUNT + 1;

  /**
     * The meta object id for the '{@link test.impl.OutputTestResultImpl <em>Output Test Result</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see test.impl.OutputTestResultImpl
     * @see test.impl.TestPackageImpl#getOutputTestResult()
     * @generated
     */
	int OUTPUT_TEST_RESULT = 9;

		/**
     * The feature id for the '<em><b>Text</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OUTPUT_TEST_RESULT__TEXT = TEST_RESULT_FEATURE_COUNT + 0;

		/**
     * The number of structural features of the '<em>Output Test Result</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OUTPUT_TEST_RESULT_FEATURE_COUNT = TEST_RESULT_FEATURE_COUNT + 1;

		/**
     * The meta object id for the '{@link test.impl.ConsoleOutputTestResultImpl <em>Console Output Test Result</em>}' class.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see test.impl.ConsoleOutputTestResultImpl
     * @see test.impl.TestPackageImpl#getConsoleOutputTestResult()
     * @generated
     */
  int CONSOLE_OUTPUT_TEST_RESULT = 6;

  /**
     * The feature id for the '<em><b>Text</b></em>' attribute.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONSOLE_OUTPUT_TEST_RESULT__TEXT = OUTPUT_TEST_RESULT__TEXT;

  /**
     * The number of structural features of the '<em>Console Output Test Result</em>' class.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONSOLE_OUTPUT_TEST_RESULT_FEATURE_COUNT = OUTPUT_TEST_RESULT_FEATURE_COUNT + 0;

  /**
     * The meta object id for the '{@link test.impl.EGFTestCaseImpl <em>EGF Test Case</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see test.impl.EGFTestCaseImpl
     * @see test.impl.TestPackageImpl#getEGFTestCase()
     * @generated
     */
    int EGF_TEST_CASE = 7;

/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EGF_TEST_CASE__NAME = TEST_CASE__NAME;

/**
     * The feature id for the '<em><b>Result</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EGF_TEST_CASE__RESULT = TEST_CASE__RESULT;

/**
     * The feature id for the '<em><b>Activity</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EGF_TEST_CASE__ACTIVITY = TEST_CASE_FEATURE_COUNT + 0;

/**
     * The number of structural features of the '<em>EGF Test Case</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EGF_TEST_CASE_FEATURE_COUNT = TEST_CASE_FEATURE_COUNT + 1;

/**
     * The meta object id for the '{@link test.impl.FileOutputTestResultImpl <em>File Output Test Result</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see test.impl.FileOutputTestResultImpl
     * @see test.impl.TestPackageImpl#getFileOutputTestResult()
     * @generated
     */
	int FILE_OUTPUT_TEST_RESULT = 8;

/**
     * The feature id for the '<em><b>Text</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FILE_OUTPUT_TEST_RESULT__TEXT = OUTPUT_TEST_RESULT__TEXT;

/**
     * The feature id for the '<em><b>IFile Path</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FILE_OUTPUT_TEST_RESULT__IFILE_PATH = OUTPUT_TEST_RESULT_FEATURE_COUNT + 0;

/**
     * The number of structural features of the '<em>File Output Test Result</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FILE_OUTPUT_TEST_RESULT_FEATURE_COUNT = OUTPUT_TEST_RESULT_FEATURE_COUNT + 1;

/**
     * The meta object id for the '{@link test.ValidationErrorSeverity <em>Validation Error Severity</em>}' enum.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see test.ValidationErrorSeverity
     * @see test.impl.TestPackageImpl#getValidationErrorSeverity()
     * @generated
     */
  int VALIDATION_ERROR_SEVERITY = 10;


  /**
     * Returns the meta object for class '{@link test.Test <em>Test</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for class '<em>Test</em>'.
     * @see test.Test
     * @generated
     */
  EClass getTest();

  /**
     * Returns the meta object for the attribute '{@link test.Test#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see test.Test#getName()
     * @see #getTest()
     * @generated
     */
  EAttribute getTest_Name();

  /**
     * Returns the meta object for class '{@link test.TestSuite <em>Suite</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for class '<em>Suite</em>'.
     * @see test.TestSuite
     * @generated
     */
  EClass getTestSuite();

  /**
     * Returns the meta object for the containment reference list '{@link test.TestSuite#getTests <em>Tests</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Tests</em>'.
     * @see test.TestSuite#getTests()
     * @see #getTestSuite()
     * @generated
     */
  EReference getTestSuite_Tests();

  /**
     * Returns the meta object for class '{@link test.TestCase <em>Case</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for class '<em>Case</em>'.
     * @see test.TestCase
     * @generated
     */
  EClass getTestCase();

  /**
     * Returns the meta object for the containment reference '{@link test.TestCase#getResult <em>Result</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Result</em>'.
     * @see test.TestCase#getResult()
     * @see #getTestCase()
     * @generated
     */
  EReference getTestCase_Result();

  /**
     * Returns the meta object for class '{@link test.TestResult <em>Result</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for class '<em>Result</em>'.
     * @see test.TestResult
     * @generated
     */
  EClass getTestResult();

  /**
     * Returns the meta object for class '{@link test.ExceptionTestResult <em>Exception Test Result</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for class '<em>Exception Test Result</em>'.
     * @see test.ExceptionTestResult
     * @generated
     */
  EClass getExceptionTestResult();

  /**
     * Returns the meta object for the attribute '{@link test.ExceptionTestResult#getExceptionClass <em>Exception Class</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Exception Class</em>'.
     * @see test.ExceptionTestResult#getExceptionClass()
     * @see #getExceptionTestResult()
     * @generated
     */
  EAttribute getExceptionTestResult_ExceptionClass();

  /**
     * Returns the meta object for the attribute '{@link test.ExceptionTestResult#getExceptionMessage <em>Exception Message</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Exception Message</em>'.
     * @see test.ExceptionTestResult#getExceptionMessage()
     * @see #getExceptionTestResult()
     * @generated
     */
  EAttribute getExceptionTestResult_ExceptionMessage();

  /**
     * Returns the meta object for class '{@link test.ValidationErrorTestResult <em>Validation Error Test Result</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for class '<em>Validation Error Test Result</em>'.
     * @see test.ValidationErrorTestResult
     * @generated
     */
  EClass getValidationErrorTestResult();

  /**
     * Returns the meta object for the attribute '{@link test.ValidationErrorTestResult#getSeverity <em>Severity</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Severity</em>'.
     * @see test.ValidationErrorTestResult#getSeverity()
     * @see #getValidationErrorTestResult()
     * @generated
     */
  EAttribute getValidationErrorTestResult_Severity();

  /**
     * Returns the meta object for class '{@link test.ConsoleOutputTestResult <em>Console Output Test Result</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for class '<em>Console Output Test Result</em>'.
     * @see test.ConsoleOutputTestResult
     * @generated
     */
  EClass getConsoleOutputTestResult();

  /**
     * Returns the meta object for class '{@link test.EGFTestCase <em>EGF Test Case</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>EGF Test Case</em>'.
     * @see test.EGFTestCase
     * @generated
     */
    EClass getEGFTestCase();

/**
     * Returns the meta object for the reference '{@link test.EGFTestCase#getActivity <em>Activity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Activity</em>'.
     * @see test.EGFTestCase#getActivity()
     * @see #getEGFTestCase()
     * @generated
     */
    EReference getEGFTestCase_Activity();

/**
     * Returns the meta object for class '{@link test.FileOutputTestResult <em>File Output Test Result</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>File Output Test Result</em>'.
     * @see test.FileOutputTestResult
     * @generated
     */
	EClass getFileOutputTestResult();

/**
     * Returns the meta object for the attribute '{@link test.FileOutputTestResult#getIFilePath <em>IFile Path</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>IFile Path</em>'.
     * @see test.FileOutputTestResult#getIFilePath()
     * @see #getFileOutputTestResult()
     * @generated
     */
	EAttribute getFileOutputTestResult_IFilePath();

/**
     * Returns the meta object for class '{@link test.OutputTestResult <em>Output Test Result</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Output Test Result</em>'.
     * @see test.OutputTestResult
     * @generated
     */
	EClass getOutputTestResult();

/**
     * Returns the meta object for the attribute '{@link test.OutputTestResult#getText <em>Text</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Text</em>'.
     * @see test.OutputTestResult#getText()
     * @see #getOutputTestResult()
     * @generated
     */
	EAttribute getOutputTestResult_Text();

/**
     * Returns the meta object for enum '{@link test.ValidationErrorSeverity <em>Validation Error Severity</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Validation Error Severity</em>'.
     * @see test.ValidationErrorSeverity
     * @generated
     */
  EEnum getValidationErrorSeverity();

  /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
  TestFactory getTestFactory();

  /**
     * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
     * @generated
     */
  interface Literals {
    /**
         * The meta object literal for the '{@link test.Test <em>Test</em>}' class.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @see test.Test
         * @see test.impl.TestPackageImpl#getTest()
         * @generated
         */
    EClass TEST = eINSTANCE.getTest();

    /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    EAttribute TEST__NAME = eINSTANCE.getTest_Name();

    /**
         * The meta object literal for the '{@link test.impl.TestSuiteImpl <em>Suite</em>}' class.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @see test.impl.TestSuiteImpl
         * @see test.impl.TestPackageImpl#getTestSuite()
         * @generated
         */
    EClass TEST_SUITE = eINSTANCE.getTestSuite();

    /**
         * The meta object literal for the '<em><b>Tests</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    EReference TEST_SUITE__TESTS = eINSTANCE.getTestSuite_Tests();

    /**
         * The meta object literal for the '{@link test.impl.TestCaseImpl <em>Case</em>}' class.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @see test.impl.TestCaseImpl
         * @see test.impl.TestPackageImpl#getTestCase()
         * @generated
         */
    EClass TEST_CASE = eINSTANCE.getTestCase();

    /**
         * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    EReference TEST_CASE__RESULT = eINSTANCE.getTestCase_Result();

    /**
         * The meta object literal for the '{@link test.impl.TestResultImpl <em>Result</em>}' class.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @see test.impl.TestResultImpl
         * @see test.impl.TestPackageImpl#getTestResult()
         * @generated
         */
    EClass TEST_RESULT = eINSTANCE.getTestResult();

    /**
         * The meta object literal for the '{@link test.impl.ExceptionTestResultImpl <em>Exception Test Result</em>}' class.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @see test.impl.ExceptionTestResultImpl
         * @see test.impl.TestPackageImpl#getExceptionTestResult()
         * @generated
         */
    EClass EXCEPTION_TEST_RESULT = eINSTANCE.getExceptionTestResult();

    /**
         * The meta object literal for the '<em><b>Exception Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    EAttribute EXCEPTION_TEST_RESULT__EXCEPTION_CLASS = eINSTANCE.getExceptionTestResult_ExceptionClass();

    /**
         * The meta object literal for the '<em><b>Exception Message</b></em>' attribute feature.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    EAttribute EXCEPTION_TEST_RESULT__EXCEPTION_MESSAGE = eINSTANCE.getExceptionTestResult_ExceptionMessage();

    /**
         * The meta object literal for the '{@link test.impl.ValidationErrorTestResultImpl <em>Validation Error Test Result</em>}' class.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @see test.impl.ValidationErrorTestResultImpl
         * @see test.impl.TestPackageImpl#getValidationErrorTestResult()
         * @generated
         */
    EClass VALIDATION_ERROR_TEST_RESULT = eINSTANCE.getValidationErrorTestResult();

    /**
         * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    EAttribute VALIDATION_ERROR_TEST_RESULT__SEVERITY = eINSTANCE.getValidationErrorTestResult_Severity();

    /**
         * The meta object literal for the '{@link test.impl.ConsoleOutputTestResultImpl <em>Console Output Test Result</em>}' class.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @see test.impl.ConsoleOutputTestResultImpl
         * @see test.impl.TestPackageImpl#getConsoleOutputTestResult()
         * @generated
         */
    EClass CONSOLE_OUTPUT_TEST_RESULT = eINSTANCE.getConsoleOutputTestResult();

    /**
         * The meta object literal for the '{@link test.impl.EGFTestCaseImpl <em>EGF Test Case</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see test.impl.EGFTestCaseImpl
         * @see test.impl.TestPackageImpl#getEGFTestCase()
         * @generated
         */
        EClass EGF_TEST_CASE = eINSTANCE.getEGFTestCase();

    /**
         * The meta object literal for the '<em><b>Activity</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EGF_TEST_CASE__ACTIVITY = eINSTANCE.getEGFTestCase_Activity();

    /**
         * The meta object literal for the '{@link test.impl.FileOutputTestResultImpl <em>File Output Test Result</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see test.impl.FileOutputTestResultImpl
         * @see test.impl.TestPackageImpl#getFileOutputTestResult()
         * @generated
         */
		EClass FILE_OUTPUT_TEST_RESULT = eINSTANCE.getFileOutputTestResult();

				/**
         * The meta object literal for the '<em><b>IFile Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute FILE_OUTPUT_TEST_RESULT__IFILE_PATH = eINSTANCE.getFileOutputTestResult_IFilePath();

				/**
         * The meta object literal for the '{@link test.impl.OutputTestResultImpl <em>Output Test Result</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see test.impl.OutputTestResultImpl
         * @see test.impl.TestPackageImpl#getOutputTestResult()
         * @generated
         */
		EClass OUTPUT_TEST_RESULT = eINSTANCE.getOutputTestResult();

				/**
         * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute OUTPUT_TEST_RESULT__TEXT = eINSTANCE.getOutputTestResult_Text();

				/**
         * The meta object literal for the '{@link test.ValidationErrorSeverity <em>Validation Error Severity</em>}' enum.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @see test.ValidationErrorSeverity
         * @see test.impl.TestPackageImpl#getValidationErrorSeverity()
         * @generated
         */
    EEnum VALIDATION_ERROR_SEVERITY = eINSTANCE.getValidationErrorSeverity();

  }

} //TestPackage
