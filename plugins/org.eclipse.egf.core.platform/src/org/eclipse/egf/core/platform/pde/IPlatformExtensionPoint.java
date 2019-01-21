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
