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
package org.eclipse.egf.core.producer;

import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author Xavier Maysonnave
 */
public class EGFCoreProducerPlugin extends EGFAbstractPlugin {

    /**
     * Plug-in unique instance.
     */
    private static EGFCoreProducerPlugin __plugin;

    /**
     * Get activator shared instance.
     * 
     * @return __plugin
     */
    public static EGFCoreProducerPlugin getDefault() {
        return __plugin;
    }

    /**
     * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        __plugin = this;
    }

    /**
     * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        __plugin = null;
        super.stop(context);
    }

}
