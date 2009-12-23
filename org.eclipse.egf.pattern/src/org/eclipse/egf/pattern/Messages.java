package org.eclipse.egf.pattern;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

    // Initializer
    public static String initializer_error1;
    public static String initializer_error2;

    // Extension
    public static String extension_error1;
    public static String extension_error2;

    // classloader
    public static String classloader_error1;
    public static String classloader_error2;

    // file helper
    public static String fileHelper_error1;
    public static String fileHelper_error2;
    public static String fileHelper_error3;

    // assembly
    public static String assembly_error1;
    public static String assembly_error2;

    // builder
    public static String PatternBuilding_Failed;
    public static String PatternBuilding_warning;

    // filename management
    public static String PatternFilename_error1;
    public static String PatternFilename_error2;
    public static String PatternFilename_error3;

    private static final String BUNDLE_NAME = "org.eclipse.egf.pattern.PatternMessages";//$NON-NLS-1$
    static {
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

}
