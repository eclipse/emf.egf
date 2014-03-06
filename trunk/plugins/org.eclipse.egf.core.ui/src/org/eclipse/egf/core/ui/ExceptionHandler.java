/*******************************************************************************
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.ui;

import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * The default exception handler shows an error dialog when one of its handle
 * methods
 * is called. If the passed exception is a <code>CoreException</code> an error
 * dialog
 * pops up showing the exception's status information. For a
 * <code>InvocationTargetException</code> a normal message dialog pops up
 * showing the exception's message. Additionally the exception
 * is written to the platform log.
 */
public class ExceptionHandler {

    private static ExceptionHandler __exceptionHandler = new ExceptionHandler();

    /**
     * Logs the given exception using the platform's logging mechanism.
     * 
     * @param message
     *            the message
     * @param throwable
     *            the throwable to log
     */
    public static void log(Throwable throwable, String message) {
        EGFCoreUIPlugin.getDefault().logError(message, throwable);
    }

    /**
     * Handles the given <code>CoreException</code>. The workbench shell is used
     * as a parent
     * for the dialog window.
     * 
     * @param ce
     *            the <code>CoreException</code> to be handled
     * @param title
     *            the dialog window's window title
     * @param message
     *            message to be displayed by the dialog window
     */
    public static void handle(CoreException ce, String title, String message) {
        handle(ce, EGFCoreUIPlugin.getActiveWorkbenchShell(), title, message);
    }

    /**
     * Handles the given <code>IStatus</code>. The workbench shell is used as a
     * parent for the
     * dialog window.
     * 
     * @param status
     *            the <code>IStatus</code> to be handled
     * @param title
     *            the dialog window's window title
     * @param message
     *            message to be displayed by the dialog window
     * @since 3.5
     */
    public static void handle(IStatus status, String title, String message) {
        __exceptionHandler.perform(status, EGFCoreUIPlugin.getActiveWorkbenchShell(), title, message);
    }

    /**
     * Handles the given <code>CoreException</code>.
     * 
     * @param ce
     *            the <code>CoreException</code> to be handled
     * @param parent
     *            the dialog window's parent shell
     * @param title
     *            the dialog window's window title
     * @param message
     *            message to be displayed by the dialog window
     */
    public static void handle(CoreException ce, Shell parent, String title, String message) {
        __exceptionHandler.perform(ce, parent, title, message);
    }

    /**
     * Handles the given <code>InvocationTargetException</code>. The workbench
     * shell is used
     * as a parent for the dialog window.
     * 
     * @param ce
     *            the <code>InvocationTargetException</code> to be handled
     * @param title
     *            the dialog window's window title
     * @param message
     *            message to be displayed by the dialog window
     */
    public static void handle(InvocationTargetException ce, String title, String message) {
        handle(ce, EGFCoreUIPlugin.getActiveWorkbenchShell(), title, message);
    }

    /**
     * Handles the given <code>InvocationTargetException</code>.
     * 
     * @param ite
     *            the <code>InvocationTargetException</code> to be handled
     * @param parent
     *            the dialog window's parent shell
     * @param title
     *            the dialog window's window title
     * @param message
     *            message to be displayed by the dialog window
     */
    public static void handle(InvocationTargetException ite, Shell parent, String title, String message) {
        __exceptionHandler.perform(ite, parent, title, message);
    }

    // ---- Hooks for subclasses to control exception handling
    // ------------------------------------

    protected void perform(IStatus status, Shell shell, String title, String message) {
        EGFCoreUIPlugin.getDefault().log(status);
        ErrorDialog.openError(shell, title, message, status);
    }

    protected void perform(CoreException e, Shell shell, String title, String message) {
        EGFCoreUIPlugin.getDefault().logError(e);
        IStatus status = e.getStatus();
        if (status != null) {
            ErrorDialog.openError(shell, title, message, status);
        } else {
            displayMessageDialog(e.getMessage(), shell, title, message);
        }
    }

    protected void perform(InvocationTargetException e, Shell shell, String title, String message) {
        Throwable target = e.getTargetException();
        if (target instanceof CoreException) {
            perform((CoreException) target, shell, title, message);
        } else {
            EGFCoreUIPlugin.getDefault().logError(e);
            if (e.getMessage() != null && e.getMessage().length() > 0) {
                displayMessageDialog(e.getMessage(), shell, title, message);
            } else {
                displayMessageDialog(target.getMessage(), shell, title, message);
            }
        }
    }

    // ---- Helper methods
    // -----------------------------------------------------------------------

    private void displayMessageDialog(String exceptionMessage, Shell shell, String title, String message) {
        StringWriter msg = new StringWriter();
        if (message != null) {
            msg.write(message);
            msg.write("\n\n"); //$NON-NLS-1$
        }
        if (exceptionMessage == null || exceptionMessage.length() == 0) {
            msg.write(CoreUIMessages.ExceptionDialog_seeErrorLogMessage);
        } else {
            msg.write(exceptionMessage);
        }
        MessageDialog.openError(shell, title, msg.toString());
    }

}
