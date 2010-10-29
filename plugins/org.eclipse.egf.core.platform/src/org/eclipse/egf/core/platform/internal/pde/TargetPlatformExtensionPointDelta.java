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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.core.platform.pde.IPlatformExtensionPoint;
import org.eclipse.egf.core.platform.pde.ITargetPlatformExtensionPointDelta;

public class TargetPlatformExtensionPointDelta extends PlatformExtensionPointDelta implements ITargetPlatformExtensionPointDelta {

    protected static IPlatformExtensionPoint[] getPlatformExtensionPoints(Map<Class<? extends IPlatformExtensionPoint>, List<IPlatformExtensionPoint>> map, boolean isTarget) {
        List<IPlatformExtensionPoint> extensionPoints = new ArrayList<IPlatformExtensionPoint>();
        for (Map.Entry<Class<? extends IPlatformExtensionPoint>, List<IPlatformExtensionPoint>> entry : map.entrySet()) {
            for (IPlatformExtensionPoint platformExtensionPoint : entry.getValue()) {
                if (platformExtensionPoint.getPlatformBundle().isTarget() == isTarget) {
                    extensionPoints.add(platformExtensionPoint);
                }
            }
        }
        return extensionPoints.toArray(new IPlatformExtensionPoint[extensionPoints.size()]);
    }

    public IPlatformExtensionPoint[] getTargetAddedPlatformExtensionPoints() {
        return getPlatformExtensionPoints(_added, true);
    }

    public IPlatformExtensionPoint[] getWorkspaceAddedPlatformExtensionPoints() {
        return getPlatformExtensionPoints(_added, false);
    }

    public IPlatformExtensionPoint[] getTargetRemovedPlatformExtensionPoints() {
        return getPlatformExtensionPoints(_removed, true);
    }

    public IPlatformExtensionPoint[] getWorkspaceRemovedPlatformExtensionPoints() {
        return getPlatformExtensionPoints(_removed, false);
    }

}
