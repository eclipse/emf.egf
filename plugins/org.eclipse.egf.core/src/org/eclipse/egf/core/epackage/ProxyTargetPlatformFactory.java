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
package org.eclipse.egf.core.epackage;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.genmodel.IPlatformGenModel;
import org.eclipse.emf.common.util.URI;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProxyTargetPlatformFactory {

    public ProxyTargetPlatformFactory() {
        // Nothing to do
    }

    protected static URI getEPackageNsURI(URI uri) {
        if (uri == null) {
            return null;
        }
        String innerUri = uri.toString();
        if (innerUri.contains("#//") == false) { //$NON-NLS-1$
            return uri;
        }
        return URI.createURI(innerUri.substring(0, innerUri.indexOf("#//"))); //$NON-NLS-1$
    }

    public IProxyEObject getIProxyEObject(URI uri) {
        IProxyERoot proxy = getIProxyERoot(uri);
        if (proxy != null) {
            return proxy.getIProxyEObject(uri);
        }
        return null;
    }

    public IProxyEPackage getIProxyEPackage(URI uri) {
        IProxyERoot proxy = getIProxyERoot(uri);
        if (proxy != null && proxy.getChildren().length == 1) {
            return proxy.getChildren()[0];
        }
        return null;
    }

    public IProxyERoot getIProxyERoot(URI uri) {
        // Ignore
        if (uri == null) {
            return null;
        }
        // Locate an IPlatformGenModel
        URI nsURI = getEPackageNsURI(uri);
        IPlatformGenModel packageGenModel = EGFCorePlugin.getWorspacePlatformGenModel(nsURI);
        // Not found
        if (packageGenModel == null) {
            return null;
        }
        // Inner ePackage processing if applicable
        URI innerNsURI = packageGenModel.getEPackageNsURI(uri);
        if (innerNsURI != null) {
            packageGenModel = EGFCorePlugin.getWorspacePlatformGenModel(innerNsURI);
        }
        // Not found
        if (packageGenModel == null) {
            return null;
        }
        // Build an ERootWrapper
        return packageGenModel.getIProxyERoot();
    }

}
