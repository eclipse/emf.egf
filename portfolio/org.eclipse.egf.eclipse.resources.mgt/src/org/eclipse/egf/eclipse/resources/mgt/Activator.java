/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.eclipse.resources.mgt;

import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.osgi.framework.BundleContext;

/**
 * @author Matthieu Helleboid
 *
 */
public class Activator extends EGFAbstractPlugin {

    /**
     * Shared instance.
     */
    protected static EGFAbstractPlugin __plugin;

    /**
     * Get shared instance.
     * 
     * @return __plugin
     */
    public static EGFAbstractPlugin getDefault() {
        return __plugin;
    }

    @Override
    public void start(BundleContext context_p) throws Exception {
        super.start(context_p);
        __plugin = this;
    }

    @Override
    public void stop(BundleContext context_p) throws Exception {
        super.stop(context_p);
        __plugin = null;
    }

}
