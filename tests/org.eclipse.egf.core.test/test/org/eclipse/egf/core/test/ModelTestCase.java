/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.MissingExtensionException;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;

import test.ConsoleOutputTestResult;
import test.ExceptionTestResult;
import test.TestCase;
import test.TestResult;
import test.ValidationErrorTestResult;

/**
 * @author Matthieu Helleboid
 * 
 */
public class ModelTestCase extends junit.framework.TestCase {

  private TestCase testCase;

  public ModelTestCase(TestCase testCase) {
    super(testCase.getName());
    this.testCase = testCase;
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }

  @Override
  protected void runTest() throws Throwable {
    PrintStream out = System.out;

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(byteArrayOutputStream));

    Activity activity = testCase.getActivity();
    TestResult result = testCase.getResult();

    try {
      runActivity(activity, result);
      handleConsoleOutputTestResult(byteArrayOutputStream, result);
    } catch (Exception e) {
      handleExceptionTestResult(result, e);
    } finally {
      System.setOut(out);
    }
  }

  private void handleConsoleOutputTestResult(ByteArrayOutputStream byteArrayOutputStream, TestResult result) {
    if (result instanceof ConsoleOutputTestResult) {
      ConsoleOutputTestResult consoleOutputTestResult = (ConsoleOutputTestResult) result;
      assertEquals(consoleOutputTestResult.getText(), byteArrayOutputStream.toString());
    } else if (result != null) {
      fail("No consoleOutputTestResult was attended"); //$NON-NLS-1$
    }
  }

  private void handleExceptionTestResult(TestResult result, Exception e) {
    if (result instanceof ExceptionTestResult) {
      ExceptionTestResult exceptionTestResult = (ExceptionTestResult) result;
      assertEquals(exceptionTestResult.getExceptionClass(), e.getClass());
      if (exceptionTestResult.getExceptionMessage() != null)
        assertEquals(exceptionTestResult.getExceptionMessage(), e.getMessage());
    } else if (result != null) {
      fail("No exceptionTestResult was attended"); //$NON-NLS-1$
    }
  }

  private void handleValidationErrorTestResult(TestResult result, Diagnostic diagnostic) {
    if (result instanceof ValidationErrorTestResult) {
      ValidationErrorTestResult validationErrorTestResult = (ValidationErrorTestResult) result;
      assertEquals(validationErrorTestResult.getSeverity().getValue(), diagnostic.getSeverity());
    } else if (result != null) {
      fail("No validationErrorTestResult was attended"); //$NON-NLS-1$
    }
  }

  private void runActivity(Activity activity, TestResult result) throws MissingExtensionException, InvocationException {
    Diagnostician diagnostician = new Diagnostician();
    Diagnostic diagnostic = diagnostician.validate(activity);

    if (diagnostic.getSeverity() != Diagnostic.OK)
      handleValidationErrorTestResult(result, diagnostic);

    ActivityManagerProducer producer = EGFProducerPlugin.getActivityManagerProducer(activity);

    IActivityManager manager = producer.createActivityManager(activity);

    try {
      manager.initializeContext();
      manager.invoke(new NullProgressMonitor());
    } finally {
      manager.dispose();
    }
  }
}