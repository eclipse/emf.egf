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
package org.eclipse.egf.pattern.jet;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

    // assembly
    public static String assembly_error5;
    public static String assembly_error6;

    public static String assembly_error8;
    public static String assembly_error9;

    private static final String BUNDLE_NAME = "org.eclipse.egf.pattern.jet.JetPatternMessages";//$NON-NLS-1$
    static {
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

}
