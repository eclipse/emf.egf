/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 * 
 */
package org.eclipse.egf.core.internal.genmodel;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.egf.core.genmodel.IPlatformGenModel;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.PlatformExtensionPointURI;
import org.eclipse.emf.common.util.URI;

public final class PlatformGenModel extends PlatformExtensionPointURI implements IPlatformGenModel {

    private String _generatedPackage;

    private String _genModel;

    private URI _genModelURI;

    public PlatformGenModel(IPlatformBundle bundle, String id, String className, String genModel) {
        super(bundle, id);
        Assert.isNotNull(className);
        Assert.isLegal(className.trim().length() != 0);
        _generatedPackage = className.trim();
        if (genModel != null && genModel.trim().length() != 0) {
            _genModel = genModel.trim();
            _genModelURI = URIHelper.getPlatformURI(getPlatformBundle().getBundleId(), URI.decode(_genModel), false);
        }
    }

    public String getNamespace() {
        return getURI().toString();
    }

    public String getGeneratedPackage() {
        return _generatedPackage;
    }

    public String getGenModel() {
        return _genModel;
    }

    public URI getGenModelURI() {
        return _genModelURI;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object) == false) {
            return false;
        }
        if (object instanceof IPlatformGenModel == false) {
            return false;
        }
        IPlatformGenModel platformGenModel = (IPlatformGenModel) object;
        if (platformGenModel.getGeneratedPackage().equals(getGeneratedPackage()) == false) {
            return false;
        }
        if (platformGenModel.getGenModel() == null && getGenModel() == null) {
            return true;
        }
        if (platformGenModel.getGenModel() == null || getGenModel() == null) {
            return false;
        }
        if (platformGenModel.getGenModel().equals(getGenModel()) == false) {
            return false;
        }
        return true;
    }
}