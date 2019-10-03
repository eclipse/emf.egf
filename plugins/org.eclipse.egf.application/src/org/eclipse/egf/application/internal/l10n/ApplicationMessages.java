/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.application.internal.l10n;

import org.eclipse.osgi.util.NLS;

public class ApplicationMessages {

    private static final String BUNDLE_NAME = "org.eclipse.egf.application.internal.l10n.messages"; //$NON-NLS-1$

    private ApplicationMessages() {
        // Do not instantiate
    }

    static {
        // load message values from bundle file
        NLS.initializeMessages(BUNDLE_NAME, ApplicationMessages.class);
    }

    public static String ActivityApplication_Arguments_Usage;

    public static String ActivityApplication_Invalid_URI_Argument;

    public static String ActivityApplication_EObject_Loading_Error;

    public static String ActivityApplication_Invalid_Activity_Argument;

    public static String ActivityRunner_Run;

    public static String ActivityRunner_NullActivity;

    public static String ActivityRunner_Exception;

    public static String ActivityRunner_PreInvokeProblems_message;

    public static String ActivityRunner_PostInvokeProblems_message;

    public static String EGFTaskLaunchConfigurationDelegate_error_no_socket;

    public static String NestedActivity_Invalid_URI_Attribute;

    public static String NestedActivity_EObject_Loading_Error;

    public static String NestedActivity_Invalid_Activity_Argument;

}
