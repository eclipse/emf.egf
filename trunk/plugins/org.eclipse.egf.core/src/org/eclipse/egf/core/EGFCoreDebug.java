/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core;

import org.eclipse.core.runtime.Platform;

public class EGFCoreDebug {

    private static final boolean BUNDLE_SESSION = Boolean.valueOf(Platform.getDebugOption("org.eclipse.egf.core/debug/bundle/session")).booleanValue(); //$NON-NLS-1$

    private static final boolean BUNDLE_LISTENER = Boolean.valueOf(Platform.getDebugOption("org.eclipse.egf.core/debug/bundle/listener")).booleanValue(); //$NON-NLS-1$

    private static final boolean PACKAGE_CYCLE = Boolean.valueOf(Platform.getDebugOption("org.eclipse.egf.core/debug/package/cycle")).booleanValue(); //$NON-NLS-1$

    public static boolean isDebugBundleSession() {
        if (EGFCorePlugin.getDefault().isDebugging()) {
            return BUNDLE_SESSION;
        }
        return false;
    }

    public static boolean isDebugBundleListener() {
        if (EGFCorePlugin.getDefault().isDebugging()) {
            return BUNDLE_LISTENER;
        }
        return false;
    }

    public static boolean isDebugPackageCycle() {
        if (EGFCorePlugin.getDefault().isDebugging()) {
            return PACKAGE_CYCLE;
        }
        return false;
    }

}
