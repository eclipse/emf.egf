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
package org.eclipse.egf.core.platform.pde;

import org.eclipse.core.runtime.Assert;

public abstract class PlatformExtensionPoint implements IPlatformExtensionPoint {

    private IPlatformBundle _bundle;

    private String _id;

    public PlatformExtensionPoint(IPlatformBundle bundle, String id) {
        Assert.isNotNull(bundle);
        Assert.isNotNull(bundle.getPluginModelBase());
        Assert.isNotNull(id);
        Assert.isLegal(id.trim().length() > 0);
        _bundle = bundle;
        _id = id.trim();
    }

    public String getId() {
        return _id;
    }

    public IPlatformBundle getPlatformBundle() {
        return _bundle;
    }

    public void setPlatformBundle(IPlatformBundle bundle) {
        Assert.isNotNull(bundle);
        Assert.isLegal(bundle.getPluginModelBase() == _bundle.getPluginModelBase());
        _bundle = bundle;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_bundle == null) ? 0 : _bundle.hashCode());
        result = prime * result + ((_id == null) ? 0 : _id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (object instanceof IPlatformExtensionPoint == false) {
            return false;
        }
        IPlatformExtensionPoint platformExtensionPoint = (IPlatformExtensionPoint) object;
        if (platformExtensionPoint.getPlatformBundle().equals(getPlatformBundle()) == false) {
            return false;
        }
        return getId().compareTo(platformExtensionPoint.getId()) == 0;
    }

    @Override
    public String toString() {
        return getId();
    }

}
