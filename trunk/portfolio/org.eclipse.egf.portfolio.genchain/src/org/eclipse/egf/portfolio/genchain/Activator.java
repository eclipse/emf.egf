package org.eclipse.egf.portfolio.genchain;

import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends EGFAbstractPlugin {

    private static Activator plugin;

    public static Activator getDefault() {
        return plugin;
    }

    public void start(BundleContext bundleContext) throws Exception {
        plugin = this;
    }

    public void stop(BundleContext bundleContext) throws Exception {
        plugin = null;
    }

}
