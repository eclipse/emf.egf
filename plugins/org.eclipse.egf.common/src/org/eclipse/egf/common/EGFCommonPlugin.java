/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common;

import java.util.List;

import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.common.internal.registry.EGFLoggerRegistry;
import org.eclipse.egf.common.log.IEGFLogger;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.packageadmin.PackageAdmin;

/**
 * Common plug-in activator.
 * 
 * @author Xavier Maysonnave
 */
public class EGFCommonPlugin extends EGFAbstractPlugin {

    private volatile static PackageAdmin __packageAdmin;

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

    public static PackageAdmin getPackageAdmin() {
        return __packageAdmin;
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

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        __plugin = this;
        ServiceReference service = context.getServiceReference(PackageAdmin.class.getName());
        if (service != null) {
            __packageAdmin = (PackageAdmin) context.getService(service);
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        if (__loggerRegistry != null) {
            __loggerRegistry.dispose();
            __loggerRegistry = null;
        }
        __packageAdmin = null;
        super.stop(context);
        __plugin = null;
    }

}
