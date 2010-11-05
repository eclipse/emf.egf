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
package org.eclipse.egf.core.internal.epackage;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.epackage.EObjectWrapper;
import org.eclipse.egf.core.epackage.EPackageWrapper;
import org.eclipse.egf.core.epackage.ERootWrapper;
import org.eclipse.egf.core.genmodel.IPlatformGenModel;
import org.eclipse.egf.core.internal.genmodel.PlatformGenModel;
import org.eclipse.emf.common.util.URI;

/**
 * @author Xavier Maysonnave
 *
 */
public class ERootTargetPlatformManager {

    public ERootTargetPlatformManager() {
        // Nothing to do
    }

    public static URI getEPackageNsURI(URI nsURI) {
        if (nsURI == null) {
            return null;
        }
        String uri = nsURI.toString();
        if (uri.contains("#//") == false) { //$NON-NLS-1$
            return nsURI;
        }
        return URI.createURI(uri.substring(0, uri.indexOf("#//"))); //$NON-NLS-1$
    }

    public EObjectWrapper getTargetPlatformEObjectWrapper(URI nsURI) {
        ERootWrapper wrapper = getTargetPlatformERootWrapper(nsURI);
        if (wrapper != null) {
            return wrapper.getEObjectWrapper(nsURI);
        }
        return null;
    }

    public EPackageWrapper getTargetPlatformEPackageWrapper(URI nsURI) {
        ERootWrapper wrapper = getTargetPlatformERootWrapper(nsURI);
        if (wrapper != null && wrapper.getChildren().size() == 1) {
            return wrapper.getChildren().get(0);
        }
        return null;
    }

    public ERootWrapper getTargetPlatformERootWrapper(URI uri) {
        // Ignore
        if (uri == null) {
            return null;
        }
        // Retrieve a root PlatformGenModel
        URI packageNsURI = getEPackageNsURI(uri);
        // Locate an IPlatformGenModel
        IPlatformGenModel packageGenModel = EGFCorePlugin.getTargetPlatformGenModel(packageNsURI);
        // Not found
        if (packageGenModel == null) {
            return null;
        }
        // Try to address inner epackage
        URI innerPackageNsURI = packageGenModel.getEPackageNsURI(uri);
        packageGenModel = EGFCorePlugin.getTargetPlatformGenModel(innerPackageNsURI);
        // Not found
        if (packageGenModel == null) {
            return null;
        }
        // Build an ERootWrapper
        return packageGenModel.getERootWrapper();
    }

    public String getTargetPlatformBasePackage(URI uri) {
        // Ignore
        if (uri == null) {
            return null;
        }
        // Retrieve a root PlatformGenModel
        URI packageNsURI = getEPackageNsURI(uri);
        // Locate an IPlatformGenModel
        IPlatformGenModel packageGenModel = EGFCorePlugin.getTargetPlatformGenModel(packageNsURI);
        // Not found
        if (packageGenModel == null) {
            return null;
        }
        // Try to address inner epackage
        URI innerPackageNsURI = packageGenModel.getEPackageNsURI(uri);
        packageGenModel = EGFCorePlugin.getTargetPlatformGenModel(innerPackageNsURI);
        // Not found
        if (packageGenModel == null) {
            return null;
        }
        // Done
        return packageGenModel.getBasePackage();
    }

    protected String getBasePackage(IPlatformGenModel genModel) {
        return PlatformGenModel.getBasePackage(genModel);
    }

}
