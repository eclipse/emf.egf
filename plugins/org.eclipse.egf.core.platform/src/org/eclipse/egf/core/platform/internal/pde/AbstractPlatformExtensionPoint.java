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
package org.eclipse.egf.core.platform.internal.pde;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.osgi.framework.Bundle;

public abstract class AbstractPlatformExtensionPoint {

    protected String _uniqueIdentifier;

    protected int _handleId = -1;

    protected IPlatformBundle _platformBundle;

    public AbstractPlatformExtensionPoint(IPlatformBundle bundle) {
        Assert.isNotNull(bundle);
        _platformBundle = bundle;
    }

    public AbstractPlatformExtensionPoint(IPlatformBundle bundle, String uniqueIdentifier, int handleId) {
        Assert.isNotNull(bundle);
        _platformBundle = bundle;
        _uniqueIdentifier = uniqueIdentifier != null ? uniqueIdentifier.trim() : null;
        _handleId = handleId;
    }

    protected void setPlatformBundle(IPlatformBundle bundle) {
        Assert.isNotNull(bundle);
        Assert.isLegal(bundle.getPluginModelBase() == _platformBundle.getPluginModelBase());
        _platformBundle = bundle;
    }

    protected void dispose() {
        // Nothing to do
    }

    public boolean isWorkspace() {
        return _platformBundle.isWorkspace();
    }

    public boolean isTarget() {
        return _platformBundle.isTarget();
    }

    public boolean isRuntime() {
        return _platformBundle.isRuntime();
    }

    public IPluginModelBase getPluginModelBase() {
        return _platformBundle.getPluginModelBase();
    }

    public Bundle getBundle() {
        return _platformBundle.getBundle();
    }

}
