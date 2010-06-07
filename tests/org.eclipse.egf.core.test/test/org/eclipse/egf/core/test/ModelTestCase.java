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

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;

import test.ConsoleOutputTestResult;
import test.EGFTestCase;
import test.ExceptionTestResult;
import test.FileOutputTestResult;
import test.TestResult;
import test.ValidationErrorTestResult;

/**
 * @author Matthieu Helleboid
 * 
 */
public class ModelTestCase extends junit.framework.TestCase {

    private EGFTestCase testCase;

    public ModelTestCase(EGFTestCase testCase) {
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
            handleFileOutputTestResult(result);
        } catch (Exception e) {
            handleExceptionTestResult(result, e);
        } finally {
            System.setOut(out);
        }
    }

    private void handleFileOutputTestResult(TestResult result) {
        if (result instanceof FileOutputTestResult) {
            FileOutputTestResult fileOutputTestResult = (FileOutputTestResult) result;

            String expectedString = fileOutputTestResult.getText();
            String iFilePath = fileOutputTestResult.getIFilePath();
            IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(iFilePath));

            if (!file.exists())
                fail("The expected file " + iFilePath + " should exist"); //$NON-NLS-1$ //$NON-NLS-2$

            long fileLength = new File(file.getRawLocationURI()).length();
            // If both are null, it's ok
            if (expectedString == null && fileLength == 0)
                return;

            // If one is not null, it's not ok
            assertNotSame("The file " + iFilePath + " should not be empty.", fileLength, 0); //$NON-NLS-1$ //$NON-NLS-2$
            assertNotNull("The file " + iFilePath + " should be empty.", expectedString); //$NON-NLS-1$ //$NON-NLS-2$

            try {
                BufferedReader expectedReader = new BufferedReader(new StringReader(expectedString));
                BufferedReader resultReader = new BufferedReader(new InputStreamReader(file.getContents()));
                compareContent(expectedReader, resultReader);
            } catch (CoreException e) {
                fail("The expected file " + iFilePath + " cannot be read : " + e.getMessage()); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
    }

    private void handleConsoleOutputTestResult(ByteArrayOutputStream byteArrayOutputStream, TestResult result) {
        if (result instanceof ConsoleOutputTestResult) {
            ConsoleOutputTestResult consoleOutputTestResult = (ConsoleOutputTestResult) result;

            String expectedString = consoleOutputTestResult.getText();
            String resultString = byteArrayOutputStream.toString();

            // If both are null, it's ok
            if (expectedString == null && resultString == null)
                return;

            // If one is not null, it's not ok
            assertNotNull("There is no output but a result was expected <[" + expectedString + "]>", resultString); //$NON-NLS-1$ //$NON-NLS-2$
            assertNotNull("There is a output but no result was expected <[" + resultString + "]>", expectedString); //$NON-NLS-1$ //$NON-NLS-2$

            BufferedReader expectedReader = new BufferedReader(new StringReader(expectedString));
            BufferedReader resultReader = new BufferedReader(new StringReader(resultString));

            compareContent(expectedReader, resultReader);
        }
    }

    private void compareContent(BufferedReader expectedReader, BufferedReader resultReader) {
        // will compare line by line
        BufferedReader expectedStringReader = expectedReader;
        BufferedReader resultStringReader = resultReader;
        int line = 1;
        try {
            while (true) {
                String expectedStringLine = expectedStringReader.readLine();
                String resultStringLine = resultStringReader.readLine();

                // If both are null, it's ok
                if (expectedStringLine == null && resultStringLine == null)
                    return;

                assertEquals("at line " + line++, expectedStringLine, resultStringLine); //$NON-NLS-1$
            }
        } catch (Exception e) {
            fail(e.getMessage());
        } finally {
            try {
                expectedStringReader.close();
            } catch (IOException e) {
                fail(e.getMessage());
            }
            try {
                resultStringReader.close();
            } catch (IOException e) {
                fail(e.getMessage());
            }
        }
    }

    private void handleExceptionTestResult(TestResult result, Exception e) {
        if (result instanceof ExceptionTestResult) {
            ExceptionTestResult exceptionTestResult = (ExceptionTestResult) result;
            assertEquals(exceptionTestResult.getExceptionClass(), e.getClass());
            if (exceptionTestResult.getExceptionMessage() != null)
                assertEquals(exceptionTestResult.getExceptionMessage(), e.getMessage());
        } else if (result != null) {
            fail("No exceptionTestResult was attended : <[" + e.getClass().getName() + " " + e.getMessage() + "]>"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
    }

    private void handleValidationErrorTestResult(TestResult result, Diagnostic diagnostic) {
        if (result instanceof ValidationErrorTestResult) {
            ValidationErrorTestResult validationErrorTestResult = (ValidationErrorTestResult) result;
            assertEquals(validationErrorTestResult.getSeverity().getValue(), diagnostic.getSeverity());
        } else if (result != null) {
            fail("No validationErrorTestResult was attended : <[" + diagnostic.toString() + "]>"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    @SuppressWarnings("unchecked")
    private void runActivity(Activity activity, TestResult result) throws CoreException, InvocationException {
        Diagnostician diagnostician = new Diagnostician();
        if (activity == null)
            fail("Cannot execute a test if the activity is null."); //$NON-NLS-1$
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
