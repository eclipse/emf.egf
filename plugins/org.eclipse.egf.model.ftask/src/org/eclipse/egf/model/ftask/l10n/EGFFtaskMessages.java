/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.model.ftask.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * @author Thomas Guiu
 * 
 */
public class EGFFtaskMessages extends NLS {

    private static final String BUNDLE_NAME = "org.eclipse.egf.model.ftask.l10n.messages"; //$NON-NLS-1$

    static {
        NLS.initializeMessages(BUNDLE_NAME, EGFFtaskMessages.class);
    }

    public static String missing_task_message;

    public static String missing_kind_message;

    public static String unable_to_create_nature_message;

    public static String missing_nature_message;

}
