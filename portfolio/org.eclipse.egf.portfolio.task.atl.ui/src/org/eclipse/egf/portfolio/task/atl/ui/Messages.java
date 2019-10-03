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
package org.eclipse.egf.portfolio.task.atl.ui;

import org.eclipse.osgi.util.NLS;

/**
 * @author xiaoru chen
 * 
 */
public class Messages extends NLS {

    private static final String BUNDLE_NAME = "org.eclipse.egf.portfolio.task.atl.ui.messages";//$NON-NLS-1$

    static {
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    public static String _UI_SelectASMFIle;
}
