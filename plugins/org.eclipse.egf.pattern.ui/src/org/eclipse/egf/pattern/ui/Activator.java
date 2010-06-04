/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pattern.ui;

import org.eclipse.egf.common.ui.activator.EGFAbstractUIPlugin;
import org.eclipse.egf.core.pde.EGFPDEPlugin;
import org.eclipse.egf.pattern.ui.builder.FcoreListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.osgi.framework.BundleContext;

/**
 * Common plug-in activator.
 * 
 * @author Xavier Maysonnave
 */
public class Activator extends EGFAbstractUIPlugin {

    /**
     * Shared instance.
     */
    protected static Activator __plugin;

    /**
     * Get shared instance.
     * 
     * @return Activator
     */
    public static Activator getDefault() {
        return __plugin;
    }

    /**
     * 
     * Returns the currently active window for this workbench (if any). Returns
     * <code>null</code> if there is no active workbench window. Returns
     * <code>null</code> if called from a non-UI thread.
     * 
     * @return the active workbench window, or <code>null</code> if there is
     *         no active workbench window or if called from a non-UI thread
     */
    public static IWorkbenchWindow getActiveWorkbenchWindow() {
        return getDefault().getWorkbench().getActiveWorkbenchWindow();
    }

    /**
     * Returns the currently active shell for this workbench (if any).
     * 
     * @return the active workbench shell.
     */
    public static Shell getActiveWorkbenchShell() {
        IWorkbenchWindow window = getActiveWorkbenchWindow();
        if (window == null) {
            IWorkbenchWindow[] windows = getDefault().getWorkbench().getWorkbenchWindows();
            if (windows.length > 0) {
                return windows[0].getShell();
            }
        } else {
            return window.getShell();
        }
        return null;
    }

    @Override
    public void start(BundleContext context_p) throws Exception {
        super.start(context_p);
        __plugin = this;
        EGFPDEPlugin.getDefault().addResourceFcoreListener(FcoreListener.INSTANCE);
    }

    @Override
    public void stop(BundleContext context_p) throws Exception {
        __plugin = null;
        if (EGFPDEPlugin.getDefault() != null)
            EGFPDEPlugin.getDefault().removeResourceFcoreListener(FcoreListener.INSTANCE);
        super.stop(context_p);
    }

}
