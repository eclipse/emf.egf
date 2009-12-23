package org.eclipse.egf.pattern.ui;

import org.eclipse.egf.common.ui.activator.EGFAbstractUIPlugin;
import org.eclipse.egf.pattern.ui.builder.FactoryComponentListener;
import org.eclipse.egf.pde.EGFPDEPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends EGFAbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "org.eclipse.egf.pattern.ui";

    // The shared instance
    private static Activator plugin;

    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
     * )
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        EGFPDEPlugin.getDefault().addResourceFactoryComponentListener(FactoryComponentListener.INSTANCE);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
     * )
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        if (EGFPDEPlugin.getDefault() != null)
            EGFPDEPlugin.getDefault().removeResourceFactoryComponentListener(FactoryComponentListener.INSTANCE);
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
