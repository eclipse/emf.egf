/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.domain;

import org.eclipse.osgi.util.NLS;

/**
 * @author Thomas Guiu
 * 
 */
public class Messages extends NLS {

    public static String Load_WorkspaceDomain_error1;
    public static String Load_WorkspaceDomain_error2;
    public static String Load_EMFDomain_error1;
    public static String Load_EMFDomain_error2;
    public static String Load_Domain_error1;
    public static String Load_Domain_error2;
    public static String Load_FilesystemDomain_error1;
    public static String load_error1;
    public static String unload_error1;

    private static final String BUNDLE_NAME = "org.eclipse.egf.domain.Messages"; //$NON-NLS-1$

    static {
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

}
