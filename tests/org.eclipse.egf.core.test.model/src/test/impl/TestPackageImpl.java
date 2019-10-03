/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test.impl;

import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import test.ConsoleOutputTestResult;
import test.EGFTestCase;
import test.ExceptionTestResult;
import test.FileOutputTestResult;
import test.OutputTestResult;
import test.Test;
import test.TestCase;
import test.TestFactory;
import test.TestPackage;
import test.TestResult;
import test.TestSuite;
import test.ValidationErrorSeverity;
import test.ValidationErrorTestResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestPackageImpl extends EPackageImpl implements TestPackage {
  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private EClass testEClass = null;

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private EClass testSuiteEClass = null;

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private EClass testCaseEClass = null;

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private EClass testResultEClass = null;

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private EClass exceptionTestResultEClass = null;

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private EClass validationErrorTestResultEClass = null;

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private EClass consoleOutputTestResultEClass = null;

  /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass egfTestCaseEClass = null;

/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass fileOutputTestResultEClass = null;

/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass outputTestResultEClass = null;

/**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private EEnum validationErrorSeverityEEnum = null;

  /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see test.TestPackage#eNS_URI
     * @see #init()
     * @generated
     */
  private TestPackageImpl() {
        super(eNS_URI, TestFactory.eINSTANCE);
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private static boolean isInited = false;

  /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link TestPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
  public static TestPackage init() {
        if (isInited) return (TestPackage)EPackage.Registry.INSTANCE.getEPackage(TestPackage.eNS_URI);

        // Obtain or create and register package
        TestPackageImpl theTestPackage = (TestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TestPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        FcorePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theTestPackage.createPackageContents();

        // Initialize created meta-data
        theTestPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theTestPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(TestPackage.eNS_URI, theTestPackage);
        return theTestPackage;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public EClass getTest() {
        return testEClass;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public EAttribute getTest_Name() {
        return (EAttribute)testEClass.getEStructuralFeatures().get(0);
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public EClass getTestSuite() {
        return testSuiteEClass;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public EReference getTestSuite_Tests() {
        return (EReference)testSuiteEClass.getEStructuralFeatures().get(0);
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public EClass getTestCase() {
        return testCaseEClass;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public EReference getTestCase_Result() {
        return (EReference)testCaseEClass.getEStructuralFeatures().get(0);
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public EClass getTestResult() {
        return testResultEClass;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public EClass getExceptionTestResult() {
        return exceptionTestResultEClass;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public EAttribute getExceptionTestResult_ExceptionClass() {
        return (EAttribute)exceptionTestResultEClass.getEStructuralFeatures().get(0);
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public EAttribute getExceptionTestResult_ExceptionMessage() {
        return (EAttribute)exceptionTestResultEClass.getEStructuralFeatures().get(1);
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public EClass getValidationErrorTestResult() {
        return validationErrorTestResultEClass;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public EAttribute getValidationErrorTestResult_Severity() {
        return (EAttribute)validationErrorTestResultEClass.getEStructuralFeatures().get(0);
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public EClass getConsoleOutputTestResult() {
        return consoleOutputTestResultEClass;
    }

  /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEGFTestCase() {
        return egfTestCaseEClass;
    }

/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEGFTestCase_Activity() {
        return (EReference)egfTestCaseEClass.getEStructuralFeatures().get(0);
    }

/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getFileOutputTestResult() {
        return fileOutputTestResultEClass;
    }

/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getFileOutputTestResult_IFilePath() {
        return (EAttribute)fileOutputTestResultEClass.getEStructuralFeatures().get(0);
    }

/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOutputTestResult() {
        return outputTestResultEClass;
    }

/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getOutputTestResult_Text() {
        return (EAttribute)outputTestResultEClass.getEStructuralFeatures().get(0);
    }

/**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public EEnum getValidationErrorSeverity() {
        return validationErrorSeverityEEnum;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public TestFactory getTestFactory() {
        return (TestFactory)getEFactoryInstance();
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private boolean isCreated = false;

  /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        testEClass = createEClass(TEST);
        createEAttribute(testEClass, TEST__NAME);

        testSuiteEClass = createEClass(TEST_SUITE);
        createEReference(testSuiteEClass, TEST_SUITE__TESTS);

        testCaseEClass = createEClass(TEST_CASE);
        createEReference(testCaseEClass, TEST_CASE__RESULT);

        testResultEClass = createEClass(TEST_RESULT);

        exceptionTestResultEClass = createEClass(EXCEPTION_TEST_RESULT);
        createEAttribute(exceptionTestResultEClass, EXCEPTION_TEST_RESULT__EXCEPTION_CLASS);
        createEAttribute(exceptionTestResultEClass, EXCEPTION_TEST_RESULT__EXCEPTION_MESSAGE);

        validationErrorTestResultEClass = createEClass(VALIDATION_ERROR_TEST_RESULT);
        createEAttribute(validationErrorTestResultEClass, VALIDATION_ERROR_TEST_RESULT__SEVERITY);

        consoleOutputTestResultEClass = createEClass(CONSOLE_OUTPUT_TEST_RESULT);

        egfTestCaseEClass = createEClass(EGF_TEST_CASE);
        createEReference(egfTestCaseEClass, EGF_TEST_CASE__ACTIVITY);

        fileOutputTestResultEClass = createEClass(FILE_OUTPUT_TEST_RESULT);
        createEAttribute(fileOutputTestResultEClass, FILE_OUTPUT_TEST_RESULT__IFILE_PATH);

        outputTestResultEClass = createEClass(OUTPUT_TEST_RESULT);
        createEAttribute(outputTestResultEClass, OUTPUT_TEST_RESULT__TEXT);

        // Create enums
        validationErrorSeverityEEnum = createEEnum(VALIDATION_ERROR_SEVERITY);
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private boolean isInitialized = false;

  /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        FcorePackage theFcorePackage = (FcorePackage)EPackage.Registry.INSTANCE.getEPackage(FcorePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        testSuiteEClass.getESuperTypes().add(this.getTest());
        testCaseEClass.getESuperTypes().add(this.getTest());
        exceptionTestResultEClass.getESuperTypes().add(this.getTestResult());
        validationErrorTestResultEClass.getESuperTypes().add(this.getTestResult());
        consoleOutputTestResultEClass.getESuperTypes().add(this.getOutputTestResult());
        egfTestCaseEClass.getESuperTypes().add(this.getTestCase());
        fileOutputTestResultEClass.getESuperTypes().add(this.getOutputTestResult());
        outputTestResultEClass.getESuperTypes().add(this.getTestResult());

        // Initialize classes and features; add operations and parameters
        initEClass(testEClass, Test.class, "Test", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTest_Name(), ecorePackage.getEString(), "name", null, 1, 1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(testSuiteEClass, TestSuite.class, "TestSuite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTestSuite_Tests(), this.getTest(), null, "tests", null, 0, -1, TestSuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(testCaseEClass, TestCase.class, "TestCase", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTestCase_Result(), this.getTestResult(), null, "result", null, 0, 1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(testResultEClass, TestResult.class, "TestResult", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(exceptionTestResultEClass, ExceptionTestResult.class, "ExceptionTestResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        EGenericType g1 = createEGenericType(ecorePackage.getEJavaClass());
        EGenericType g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        initEAttribute(getExceptionTestResult_ExceptionClass(), g1, "exceptionClass", null, 1, 1, ExceptionTestResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getExceptionTestResult_ExceptionMessage(), ecorePackage.getEString(), "exceptionMessage", null, 0, 1, ExceptionTestResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(validationErrorTestResultEClass, ValidationErrorTestResult.class, "ValidationErrorTestResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getValidationErrorTestResult_Severity(), this.getValidationErrorSeverity(), "severity", null, 1, 1, ValidationErrorTestResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(consoleOutputTestResultEClass, ConsoleOutputTestResult.class, "ConsoleOutputTestResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(egfTestCaseEClass, EGFTestCase.class, "EGFTestCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEGFTestCase_Activity(), theFcorePackage.getActivity(), null, "activity", null, 1, 1, EGFTestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(fileOutputTestResultEClass, FileOutputTestResult.class, "FileOutputTestResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFileOutputTestResult_IFilePath(), ecorePackage.getEString(), "iFilePath", null, 1, 1, FileOutputTestResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(outputTestResultEClass, OutputTestResult.class, "OutputTestResult", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getOutputTestResult_Text(), ecorePackage.getEString(), "text", null, 1, 1, OutputTestResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(validationErrorSeverityEEnum, ValidationErrorSeverity.class, "ValidationErrorSeverity");
        addEEnumLiteral(validationErrorSeverityEEnum, ValidationErrorSeverity.INFO);
        addEEnumLiteral(validationErrorSeverityEEnum, ValidationErrorSeverity.WARNING);
        addEEnumLiteral(validationErrorSeverityEEnum, ValidationErrorSeverity.ERROR);

        // Create resource
        createResource(eNS_URI);
    }

} //TestPackageImpl
