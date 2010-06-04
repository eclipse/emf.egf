/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.common.l10n;

import org.eclipse.osgi.util.NLS;

public class EGFCommonMessages {

    private static final String BUNDLE_NAME = "org.eclipse.egf.common.l10n.messages"; //$NON-NLS-1$

    private EGFCommonMessages() {
        // Do not instantiate
    }

    static {
        // load message values from bundle file
        NLS.initializeMessages(BUNDLE_NAME, EGFCommonMessages.class);
    }

    public static String URI_errorInstance;

    public static String Exception_unexpectedException;

    public static String JavaHelper_AnalysingFailure;

    public static String TypeClassHelper_classHierachy_JobName;

    public static String Wrong_Class_Message;

    public static String Wrong_Class_Sub_Type_Message;

    public static String Bundle_Message;

    public static String Extension_Point_Message;

    public static String Attribute_Message;

}
