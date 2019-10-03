/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import test.*;
import test.ConsoleOutputTestResult;
import test.ExceptionTestResult;
import test.Test;
import test.TestCase;
import test.TestPackage;
import test.TestResult;
import test.TestSuite;
import test.ValidationErrorTestResult;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see test.TestPackage
 * @generated
 */
public class TestSwitch<T> {
  /**
     * The cached model package
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  protected static TestPackage modelPackage;

  /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public TestSwitch() {
        if (modelPackage == null) {
            modelPackage = TestPackage.eINSTANCE;
        }
    }

  /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
  public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

  /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
  protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

  /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
  protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case TestPackage.TEST: {
                Test test = (Test)theEObject;
                T result = caseTest(test);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TestPackage.TEST_SUITE: {
                TestSuite testSuite = (TestSuite)theEObject;
                T result = caseTestSuite(testSuite);
                if (result == null) result = caseTest(testSuite);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TestPackage.TEST_CASE: {
                TestCase testCase = (TestCase)theEObject;
                T result = caseTestCase(testCase);
                if (result == null) result = caseTest(testCase);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TestPackage.TEST_RESULT: {
                TestResult testResult = (TestResult)theEObject;
                T result = caseTestResult(testResult);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TestPackage.EXCEPTION_TEST_RESULT: {
                ExceptionTestResult exceptionTestResult = (ExceptionTestResult)theEObject;
                T result = caseExceptionTestResult(exceptionTestResult);
                if (result == null) result = caseTestResult(exceptionTestResult);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TestPackage.VALIDATION_ERROR_TEST_RESULT: {
                ValidationErrorTestResult validationErrorTestResult = (ValidationErrorTestResult)theEObject;
                T result = caseValidationErrorTestResult(validationErrorTestResult);
                if (result == null) result = caseTestResult(validationErrorTestResult);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TestPackage.CONSOLE_OUTPUT_TEST_RESULT: {
                ConsoleOutputTestResult consoleOutputTestResult = (ConsoleOutputTestResult)theEObject;
                T result = caseConsoleOutputTestResult(consoleOutputTestResult);
                if (result == null) result = caseOutputTestResult(consoleOutputTestResult);
                if (result == null) result = caseTestResult(consoleOutputTestResult);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TestPackage.EGF_TEST_CASE: {
                EGFTestCase egfTestCase = (EGFTestCase)theEObject;
                T result = caseEGFTestCase(egfTestCase);
                if (result == null) result = caseTestCase(egfTestCase);
                if (result == null) result = caseTest(egfTestCase);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TestPackage.FILE_OUTPUT_TEST_RESULT: {
                FileOutputTestResult fileOutputTestResult = (FileOutputTestResult)theEObject;
                T result = caseFileOutputTestResult(fileOutputTestResult);
                if (result == null) result = caseOutputTestResult(fileOutputTestResult);
                if (result == null) result = caseTestResult(fileOutputTestResult);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case TestPackage.OUTPUT_TEST_RESULT: {
                OutputTestResult outputTestResult = (OutputTestResult)theEObject;
                T result = caseOutputTestResult(outputTestResult);
                if (result == null) result = caseTestResult(outputTestResult);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

  /**
     * Returns the result of interpreting the object as an instance of '<em>Test</em>'.
     * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Test</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
  public T caseTest(Test object) {
        return null;
    }

  /**
     * Returns the result of interpreting the object as an instance of '<em>Suite</em>'.
     * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Suite</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
  public T caseTestSuite(TestSuite object) {
        return null;
    }

  /**
     * Returns the result of interpreting the object as an instance of '<em>Case</em>'.
     * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Case</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
  public T caseTestCase(TestCase object) {
        return null;
    }

  /**
     * Returns the result of interpreting the object as an instance of '<em>Result</em>'.
     * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Result</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
  public T caseTestResult(TestResult object) {
        return null;
    }

  /**
     * Returns the result of interpreting the object as an instance of '<em>Exception Test Result</em>'.
     * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Exception Test Result</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
  public T caseExceptionTestResult(ExceptionTestResult object) {
        return null;
    }

  /**
     * Returns the result of interpreting the object as an instance of '<em>Validation Error Test Result</em>'.
     * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Validation Error Test Result</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
  public T caseValidationErrorTestResult(ValidationErrorTestResult object) {
        return null;
    }

  /**
     * Returns the result of interpreting the object as an instance of '<em>Console Output Test Result</em>'.
     * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Console Output Test Result</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
  public T caseConsoleOutputTestResult(ConsoleOutputTestResult object) {
        return null;
    }

  /**
     * Returns the result of interpreting the object as an instance of '<em>EGF Test Case</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EGF Test Case</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEGFTestCase(EGFTestCase object) {
        return null;
    }

/**
     * Returns the result of interpreting the object as an instance of '<em>File Output Test Result</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>File Output Test Result</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseFileOutputTestResult(FileOutputTestResult object) {
        return null;
    }

/**
     * Returns the result of interpreting the object as an instance of '<em>Output Test Result</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Output Test Result</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseOutputTestResult(OutputTestResult object) {
        return null;
    }

/**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
  public T defaultCase(EObject object) {
        return null;
    }

} //TestSwitch
