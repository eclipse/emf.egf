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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.common.helper.CollectionHelper;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPoint;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointDelta;

public class PlatformExtensionPointDelta implements IPlatformExtensionPointDelta {

    protected Map<Class<? extends IPlatformExtensionPoint>, List<IPlatformExtensionPoint>> _added = new HashMap<Class<? extends IPlatformExtensionPoint>, List<IPlatformExtensionPoint>>();

    protected Map<Class<? extends IPlatformExtensionPoint>, List<IPlatformExtensionPoint>> _removed = new HashMap<Class<? extends IPlatformExtensionPoint>, List<IPlatformExtensionPoint>>();

    public PlatformExtensionPointDelta() {
        // Nothing to do
    }

    protected static IPlatformExtensionPoint[] getPlatformExtensionPoints(Map<Class<? extends IPlatformExtensionPoint>, List<IPlatformExtensionPoint>> map) {
        List<IPlatformExtensionPoint> extensionPoints = new ArrayList<IPlatformExtensionPoint>();
        for (Map.Entry<Class<? extends IPlatformExtensionPoint>, List<IPlatformExtensionPoint>> entry : map.entrySet()) {
            extensionPoints.addAll(entry.getValue());
        }
        return extensionPoints.toArray(new IPlatformExtensionPoint[extensionPoints.size()]);
    }

    protected static boolean storePlatformExtensionPoint(Map<Class<? extends IPlatformExtensionPoint>, List<IPlatformExtensionPoint>> map, Class<? extends IPlatformExtensionPoint> clazz, IPlatformExtensionPoint extensionPoint) {
        if (clazz == null || EGFPlatformPlugin.getPlatformExtensionPoints().values().contains(clazz) == false || extensionPoint == null) {
            return false;
        }
        List<IPlatformExtensionPoint> extensionPoints = map.get(clazz);
        if (extensionPoints == null) {
            extensionPoints = new ArrayList<IPlatformExtensionPoint>();
            map.put(clazz, extensionPoints);
        }
        return extensionPoints.add(extensionPoint);
    }

    protected static <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(Map<Class<? extends IPlatformExtensionPoint>, List<IPlatformExtensionPoint>> map, Class<T> clazz) {
        List<Object> extensionPoints = new ArrayList<Object>();
        if (clazz != null && EGFPlatformPlugin.getPlatformExtensionPoints().values().contains(clazz)) {
            if (map.get(clazz) != null) {
                extensionPoints.addAll(map.get(clazz));
            }
        }
        return CollectionHelper.toArray(extensionPoints, clazz);
    }

    public IPlatformExtensionPoint[] getAddedPlatformExtensionPoints() {
        return getPlatformExtensionPoints(_added);
    }

    public <T extends IPlatformExtensionPoint> T[] getAddedPlatformExtensionPoints(Class<T> clazz) {
        return getPlatformExtensionPoints(_added, clazz);
    }

    public IPlatformExtensionPoint[] getRemovedPlatformExtensionPoints() {
        return getPlatformExtensionPoints(_removed);
    }

    public <T extends IPlatformExtensionPoint> T[] getRemovedPlatformExtensionPoints(Class<T> clazz) {
        return getPlatformExtensionPoints(_removed, clazz);
    }

    protected boolean isEmpty() {
        return _added.size() == 0 && _removed.size() == 0 ? true : false;
    }

    protected boolean storeAddedPlatformExtensionPoint(Class<? extends IPlatformExtensionPoint> clazz, IPlatformExtensionPoint extensionPoint) {
        return storePlatformExtensionPoint(_added, clazz, extensionPoint);
    }

    protected boolean storeRemovedPlatformExtensionPoint(Class<? extends IPlatformExtensionPoint> clazz, IPlatformExtensionPoint extensionPoint) {
        return storePlatformExtensionPoint(_removed, clazz, extensionPoint);
    }

}
