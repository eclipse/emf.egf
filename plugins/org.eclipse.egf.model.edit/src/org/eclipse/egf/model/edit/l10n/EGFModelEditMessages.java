/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 * Thales Corporate Services S.A.S
 */
package org.eclipse.egf.model.edit.l10n;

import org.eclipse.osgi.util.NLS;

public class EGFModelEditMessages {

    private static final String BUNDLE_NAME = "org.eclipse.egf.model.edit.l10n.messages"; //$NON-NLS-1$

    private EGFModelEditMessages() {
        // Do not instantiate
    }

    static {
        // load message values from bundle file
        NLS.initializeMessages(BUNDLE_NAME, EGFModelEditMessages.class);
    }

    public static String RemovePatternMethodCommand_execute;

    public static String PatternRemovePatternMethodCommand_execute_exception;

    public static String RemovePatternCommand_execute;

    public static String PatternLibraryRemovePatternCommand_execute_exception;

    public static String RemovePatternCommand_execute_exception;

    public static String RestorePatternCommand_execute;

    public static String PatternLibraryRestorePatternCommand_execute_exception;

    public static String RestorePatternCommand_execute_exception;

    public static String RestorePatternMethodCommand_execute;

    public static String PatternRestorePatternMethodCommand_execute_exception;

    public static String CopyPatternTemplateCommand_execute;

    public static String CopyPatternTemplatesCommand_execute_exception;

    public static String CopyPatternTemplateCommand_execute_exception;

    public static String CopyPatternTemplateCommand_no_input_exception;

}
