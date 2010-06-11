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

public abstract class AbstractPlatformExtensionPoint {

    protected IPlatformBundle _bundle;

    public AbstractPlatformExtensionPoint(IPlatformBundle bundle) {
        Assert.isNotNull(bundle);
        Assert.isNotNull(bundle.getPluginModelBase());
        _bundle = bundle;
    }

    protected void setPlatformBundle(IPlatformBundle bundle) {
        Assert.isNotNull(bundle);
        Assert.isLegal(bundle.getPluginModelBase() == _bundle.getPluginModelBase());
        _bundle = bundle;
    }

    protected void dispose() {
        // Nothing to do
    }

}
