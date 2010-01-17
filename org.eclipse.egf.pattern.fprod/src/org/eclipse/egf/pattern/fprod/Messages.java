/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.fprod;

import org.eclipse.osgi.util.NLS;

/**
 * @author Thomas Guiu
 * 
 */
public class Messages extends NLS {

    public static String translation_job_label;

    public static String Missing_pattern_error1;

    public static String taskInvocation_error1;
    public static String taskInvocation_error2;
    public static String taskInvocation_error3;

    private static final String BUNDLE_NAME = "org.eclipse.egf.pattern.fprod.PatternFprodMessages";//$NON-NLS-1$
    static {
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

}
