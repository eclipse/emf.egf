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

import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.osgi.framework.Bundle;

public interface IPlatformExtensionPoint extends Comparable<IPlatformExtensionPoint> {

    public String getId();

    public String getUniqueIdentifier();

    public int getHandleId();

    public IPlatformBundle getPlatformBundle();

    public boolean isWorkspace();

    public boolean isTarget();

    public boolean isRuntime();

    public IPluginModelBase getPluginModelBase();

    public Bundle getBundle();

}
