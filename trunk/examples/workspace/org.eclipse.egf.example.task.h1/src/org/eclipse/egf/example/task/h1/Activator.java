package org.eclipse.egf.example.task.h1;

import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends EGFAbstractPlugin {

    // The shared instance
    private static Activator plugin;

    /*
     * (non-Javadoc)
     * 
     * @see
     * 
     * 
     * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
     * )
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        logInfo("org.eclipse.egf.example.task.h1 is starting"); //$NON-NLS-1$
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * 
     * 
     * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
     * )
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        Bundle bundle = Platform.getBundle("org.eclipse.swt"); //$NON-NLS-1$
        if (bundle.getState() == Bundle.ACTIVE) {
            logInfo("org.eclipse.egf.example.task.h1 is stopping"); //$NON-NLS-1$
        }
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }

}
