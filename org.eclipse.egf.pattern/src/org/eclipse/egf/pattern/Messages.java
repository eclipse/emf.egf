/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern;

import org.eclipse.osgi.util.NLS;

/**
 * @author Thomas Guiu
 * 
 */
public class Messages extends NLS {

    public static String translation_job_label;

    // refactoring
    public static String refactoring_error1;

    // Initializer
    public static String initializer_error1;
    public static String initializer_error2;

    // Extension
    public static String extension_error1;
    public static String extension_error2;
    public static String extension_error3;

    // classloader
    public static String classloader_error1;
    public static String classloader_error2;
    public static String classloader_error3;
    public static String classloader_error4;

    // file helper
    public static String fileHelper_error1;
    public static String fileHelper_error2;
    public static String fileHelper_error3;

    // assembly
    public static String assembly_error1;
    public static String assembly_error2;
    public static String assembly_error3;
    public static String assembly_error4;
    public static String assembly_error5;
    public static String assembly_error6;
    public static String assembly_error7;
    public static String assembly_error8;
    public static String assembly_error9;
    public static String assembly_error10;

    // builder
    public static String PatternBuilding_Failed;
    public static String PatternBuilding_warning;

    // filename management
    public static String PatternFilename_error1;
    public static String PatternFilename_error2;
    public static String PatternFilename_error3;

    // query
    public static String query_error1;
    public static String query_error2;
    public static String query_error3;
    public static String query_error4;
    public static String query_error5;
    public static String query_error6;
    public static String query_error7;
    public static String query_error8;

    // epackage registry
    public static String registration_error2;
    public static String registration_error1;

    // strategies
    public static String strategy_error3;
    public static String strategy_error2;
    public static String strategy_error1;
    public static String strategy_error4;

    public static String collect_error1;
    public static String collect_error2;

    public static String missing_callback_handler;

    public static String engine_error1;
    public static String call_execution_error1;
    public static String model_driven_strategy_error1;

    private static final String BUNDLE_NAME = "org.eclipse.egf.pattern.PatternMessages";//$NON-NLS-1$
    static {
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

}
