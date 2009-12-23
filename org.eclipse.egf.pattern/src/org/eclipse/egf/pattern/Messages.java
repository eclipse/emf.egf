package org.eclipse.egf.pattern;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

    public static String PatternBuildingFailed;

    private static final String BUNDLE_NAME = "org.eclipse.egf.pattern.PatternMessages";//$NON-NLS-1$
    static {
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

}
