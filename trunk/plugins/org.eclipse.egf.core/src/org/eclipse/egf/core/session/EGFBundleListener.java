/**
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.session;

import org.eclipse.egf.core.EGFCoreDebug;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.SynchronousBundleListener;

/**
 * @author Xavier Maysonnave
 *
 */
public class EGFBundleListener implements SynchronousBundleListener {

    public void bundleChanged(BundleEvent event) {
        if (EGFCorePlugin.getDefault() == null || EGFCoreDebug.isDebugBundleListener() == false) {
            return;
        }
        if (event.getType() == BundleEvent.STARTED) {
            EGFCorePlugin.getDefault().logInfo(NLS.bind("Bundle ''{0}'' is starting...", event.getBundle().getSymbolicName())); //$NON-NLS-1$
        } else if (event.getType() == BundleEvent.STOPPED) {
            EGFCorePlugin.getDefault().logInfo(NLS.bind("Bundle ''{0}'' is stopped...", event.getBundle().getSymbolicName())); //$NON-NLS-1$            
        }
    }

}
