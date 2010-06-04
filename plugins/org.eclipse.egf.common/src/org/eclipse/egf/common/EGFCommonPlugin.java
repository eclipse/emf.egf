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
package org.eclipse.egf.common;

import java.util.List;

import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.common.internal.log.EGFLoggerRegistry;
import org.eclipse.egf.common.log.IEGFLogger;
import org.osgi.framework.BundleContext;

/**
 * Common plug-in activator.
 * 
 * @author Xavier Maysonnave
 */
public class EGFCommonPlugin extends EGFAbstractPlugin {

    /**
     * Keep track of the EGFLoggerRegistry
     */
    private static EGFLoggerRegistry __loggerRegistry;

    /**
     * Shared instance.
     */
    protected static EGFCommonPlugin __plugin;

    /**
     * Get shared instance.
     * 
     * @return __plugin
     */
    public static EGFCommonPlugin getDefault() {
        return __plugin;
    }

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        __plugin = this;
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        if (__loggerRegistry != null) {
            __loggerRegistry.dispose();
            __loggerRegistry = null;
        }
        super.stop(context);
        __plugin = null;
    }

    /**
     * Get egf loggers implementations.
     * 
     * @return an empty list if none could be found.
     */
    public static List<IEGFLogger> getEGFLoggers() {
        if (__loggerRegistry == null) {
            __loggerRegistry = new EGFLoggerRegistry();
        }
        return __loggerRegistry.getEGFLoggers();
    }

}
