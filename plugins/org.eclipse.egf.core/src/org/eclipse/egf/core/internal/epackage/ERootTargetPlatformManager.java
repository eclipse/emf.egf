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

    public ERootWrapper getTargetPlatformERootWrapper(URI nsURI) {
        // Ignore
        if (nsURI == null) {
            return null;
        }
        nsURI = PlatformGenModel.getEPackageNsURI(nsURI);
        // Locate an IPlatformGenModel
        IPlatformGenModel genModel = EGFCorePlugin.getTargetPlatformGenModel(nsURI);
        // Not found
        if (genModel == null) {
            return null;
        }
        // Build an ERootWrapper
        return genModel.getERootWrapper();
    }

    public String getTargetPlatformBasePackage(URI nsURI) {
        // Ignore
        if (nsURI == null) {
            return null;
        }
        nsURI = PlatformGenModel.getEPackageNsURI(nsURI);
        // Locate an IPlatformGenModel
        IPlatformGenModel genModel = EGFCorePlugin.getTargetPlatformGenModel(nsURI);
        // Not found
        if (genModel == null) {
            return null;
        }
        // Done
        return genModel.getBasePackage();
    }

    protected String getBasePackage(IPlatformGenModel genModel) {
        return PlatformGenModel.getBasePackage(genModel);
    }

}
