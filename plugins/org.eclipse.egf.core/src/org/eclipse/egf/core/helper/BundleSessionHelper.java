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
package org.eclipse.egf.core.helper;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPoint;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class BundleSessionHelper {

    private BundleSessionHelper() {
        // Prevent Instantiation
    }

    public static Bundle getBundle(ProjectBundleSession session, IPlatformExtensionPoint extensionPoint) throws CoreException {
        // Usual Tests
        if (session == null || extensionPoint == null) {
            return null;
        }
        // Locate Bundle
        if (extensionPoint.isRuntime() || extensionPoint.getBundle() != null) {
            return extensionPoint.getBundle();
        } else if (extensionPoint.isWorkspace()) {
            return session.getBundle(extensionPoint.getPlatformBundle().getProject());
        }
        // Cannot associate a Bundle to a target platform extension point
        throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.TargetPlatform_ExtensionPoint_no_bundle, extensionPoint.getId()), null));
    }

}
