/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 * Thales Corporate Services S.A.S
 */

package org.eclipse.egf.producer.l10n;

import org.eclipse.osgi.util.NLS;

public class ProducerMessages {

    private static final String BUNDLE_NAME = "org.eclipse.egf.producer.l10n.messages"; //$NON-NLS-1$

    private ProducerMessages() {
        // Do not instantiate
    }

    static {
        // load message values from bundle file
        NLS.initializeMessages(BUNDLE_NAME, ProducerMessages.class);
    }

    public static String ActivityManager_mandatory_value;

    public static String ActivityManagerProducer_extension_error;

    public static String ActivityManagerProducer_type_error;

    public static String ActivityProductionContextProducer_extension_error;

    public static String ActivityProductionContextProducer_type_error;

    public static String OrchestrationManagerProducer_extension_error;

    public static String OrchestrationManagerProducer_type_error;

    public static String CanInvoke_Diagnosis_message;

    public static String RuntimeCanInvoke_Diagnosis_message;

    public static String Activity_Invocation;

    public static String Activity_Invocations;

}
