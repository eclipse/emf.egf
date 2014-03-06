package org.eclipse.egf.portfolio.genchain.tools.ui;

import org.eclipse.egf.common.ui.activator.EGFAbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * @author Thomas Guiu
 */
public class Activator extends EGFAbstractUIPlugin {

    protected static Activator plugin;

    public static Activator getDefault() {
        return plugin;
    }

    @Override
    public void start(BundleContext context_p) throws Exception {
        super.start(context_p);
        plugin = this;
    }

    @Override
    public void stop(BundleContext context_p) throws Exception {
        super.stop(context_p);
        plugin = null;
    }

}
