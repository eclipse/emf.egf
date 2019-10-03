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

package org.eclipse.egf.producer.fprod.l10n;

import org.eclipse.osgi.util.NLS;

public class FprodProducerMessages {

    private static final String BUNDLE_NAME = "org.eclipse.egf.producer.fprod.l10n.messages"; //$NON-NLS-1$

    private FprodProducerMessages() {
        // Do not instantiate
    }

    static {
        // load message values from bundle file
        NLS.initializeMessages(BUNDLE_NAME, FprodProducerMessages.class);
    }

    public static String ProductionPlanManager_unknown_manager;

}
