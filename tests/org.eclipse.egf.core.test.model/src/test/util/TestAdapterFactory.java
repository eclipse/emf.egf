/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see test.TestPackage
 * @generated
 */
public class TestAdapterFactory extends AdapterFactoryImpl {
  /**
     * The cached model package.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  protected static TestPackage modelPackage;

  /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public TestAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = TestPackage.eINSTANCE;
        }
    }

  /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
  @Override
  public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

  /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  protected TestSwitch<Adapter> modelSwitch =
    new TestSwitch<Adapter>() {
            @Override
            public Adapter caseTest(Test object) {
                return createTestAdapter();
            }
            @Override
            public Adapter caseTestSuite(TestSuite object) {
                return createTestSuiteAdapter();
            }
            @Override
            public Adapter caseTestCase(TestCase object) {
                return createTestCaseAdapter();
            }
            @Override
            public Adapter caseTestResult(TestResult object) {
                return createTestResultAdapter();
            }
            @Override
            public Adapter caseExceptionTestResult(ExceptionTestResult object) {
                return createExceptionTestResultAdapter();
            }
            @Override
            public Adapter caseValidationErrorTestResult(ValidationErrorTestResult object) {
                return createValidationErrorTestResultAdapter();
            }
            @Override
            public Adapter caseConsoleOutputTestResult(ConsoleOutputTestResult object) {
                return createConsoleOutputTestResultAdapter();
            }
            @Override
            public Adapter caseEGFTestCase(EGFTestCase object) {
                return createEGFTestCaseAdapter();
            }
            @Override
            public Adapter caseFileOutputTestResult(FileOutputTestResult object) {
                return createFileOutputTestResultAdapter();
            }
            @Override
            public Adapter caseOutputTestResult(OutputTestResult object) {
                return createOutputTestResultAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

  /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
  @Override
  public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


  /**
     * Creates a new adapter for an object of class '{@link test.Test <em>Test</em>}'.
     * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
     * @return the new adapter.
     * @see test.Test
     * @generated
     */
  public Adapter createTestAdapter() {
        return null;
    }

  /**
     * Creates a new adapter for an object of class '{@link test.TestSuite <em>Suite</em>}'.
     * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
     * @return the new adapter.
     * @see test.TestSuite
     * @generated
     */
  public Adapter createTestSuiteAdapter() {
        return null;
    }

  /**
     * Creates a new adapter for an object of class '{@link test.TestCase <em>Case</em>}'.
     * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
     * @return the new adapter.
     * @see test.TestCase
     * @generated
     */
  public Adapter createTestCaseAdapter() {
        return null;
    }

  /**
     * Creates a new adapter for an object of class '{@link test.TestResult <em>Result</em>}'.
     * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
     * @return the new adapter.
     * @see test.TestResult
     * @generated
     */
  public Adapter createTestResultAdapter() {
        return null;
    }

  /**
     * Creates a new adapter for an object of class '{@link test.ExceptionTestResult <em>Exception Test Result</em>}'.
     * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
     * @return the new adapter.
     * @see test.ExceptionTestResult
     * @generated
     */
  public Adapter createExceptionTestResultAdapter() {
        return null;
    }

  /**
     * Creates a new adapter for an object of class '{@link test.ValidationErrorTestResult <em>Validation Error Test Result</em>}'.
     * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
     * @return the new adapter.
     * @see test.ValidationErrorTestResult
     * @generated
     */
  public Adapter createValidationErrorTestResultAdapter() {
        return null;
    }

  /**
     * Creates a new adapter for an object of class '{@link test.ConsoleOutputTestResult <em>Console Output Test Result</em>}'.
     * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
     * @return the new adapter.
     * @see test.ConsoleOutputTestResult
     * @generated
     */
  public Adapter createConsoleOutputTestResultAdapter() {
        return null;
    }

  /**
     * Creates a new adapter for an object of class '{@link test.EGFTestCase <em>EGF Test Case</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see test.EGFTestCase
     * @generated
     */
    public Adapter createEGFTestCaseAdapter() {
        return null;
    }

/**
     * Creates a new adapter for an object of class '{@link test.FileOutputTestResult <em>File Output Test Result</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see test.FileOutputTestResult
     * @generated
     */
	public Adapter createFileOutputTestResultAdapter() {
        return null;
    }

/**
     * Creates a new adapter for an object of class '{@link test.OutputTestResult <em>Output Test Result</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see test.OutputTestResult
     * @generated
     */
	public Adapter createOutputTestResultAdapter() {
        return null;
    }

/**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
  public Adapter createEObjectAdapter() {
        return null;
    }

} //TestAdapterFactory
