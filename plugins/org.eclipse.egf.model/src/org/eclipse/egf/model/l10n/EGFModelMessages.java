/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * IBM Corporation - initial API and implementation
 * Thales Corporate Services S.A.S
 */
package org.eclipse.egf.model.l10n;

import org.eclipse.osgi.util.NLS;

public class EGFModelMessages {

    private static final String BUNDLE_NAME = "org.eclipse.egf.model.l10n.messages"; //$NON-NLS-1$

    private EGFModelMessages() {
        // Do not instantiate
    }

    static {
        // load message values from bundle file
        NLS.initializeMessages(BUNDLE_NAME, EGFModelMessages.class);
    }

    public static String fileHelper_error3;

    public static String fileHelper_error4;

    public static String fileHelper_error5;

    public static String fileHelper_error6;

    public static String fileHelper_error7;

    public static String fileHelper_error8;

    // filename management
    public static String PatternFilename_error1;

    public static String PatternFilename_error2;

    public static String PatternFilename_error3;

    public static String PatternFilename_error4;

    public static String FcoreResource_processor;

    public static String FcoreResource_processors_execute_exception;

    public static String FcoreResource_processor_execute_exception;

}
