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

    private Map<Class<? extends IPlatformExtensionPoint>, List<IPlatformExtensionPoint>> _added = new HashMap<Class<? extends IPlatformExtensionPoint>, List<IPlatformExtensionPoint>>();

    private Map<Class<? extends IPlatformExtensionPoint>, List<IPlatformExtensionPoint>> _removed = new HashMap<Class<? extends IPlatformExtensionPoint>, List<IPlatformExtensionPoint>>();

    public PlatformExtensionPointDelta() {
        // Nothing to do
    }

    public IPlatformExtensionPoint[] getAddedPlatformExtensionPoints() {
        List<IPlatformExtensionPoint> extensionPoints = new ArrayList<IPlatformExtensionPoint>();
        for (Class<? extends IPlatformExtensionPoint> clazz : _added.keySet()) {
            extensionPoints.addAll(_added.get(clazz));
        }
        return extensionPoints.toArray(new IPlatformExtensionPoint[extensionPoints.size()]);
    }

    public <T extends IPlatformExtensionPoint> T[] getAddedPlatformExtensionPoints(Class<T> clazz) {
        List<Object> extensionPoints = new ArrayList<Object>();
        if (clazz != null && EGFPlatformPlugin.getPlatformExtensionPointClasses().contains(clazz)) {
            if (_added.get(clazz) != null) {
                extensionPoints.addAll(_added.get(clazz));
            }
        }
        return CollectionHelper.toArray(extensionPoints, clazz);
    }

    public IPlatformExtensionPoint[] getRemovedPlatformExtensionPoints() {
        List<IPlatformExtensionPoint> extensionPoints = new ArrayList<IPlatformExtensionPoint>();
        for (Class<? extends IPlatformExtensionPoint> clazz : _removed.keySet()) {
            extensionPoints.addAll(_removed.get(clazz));
        }
        return extensionPoints.toArray(new IPlatformExtensionPoint[extensionPoints.size()]);
    }

    public <T extends IPlatformExtensionPoint> T[] getRemovedPlatformExtensionPoints(Class<T> clazz) {
        List<Object> extensionPoints = new ArrayList<Object>();
        if (clazz != null && EGFPlatformPlugin.getPlatformExtensionPointClasses().contains(clazz)) {
            if (_removed.get(clazz) != null) {
                extensionPoints.addAll(_removed.get(clazz));
            }
        }
        return CollectionHelper.toArray(extensionPoints, clazz);
    }

    protected boolean isEmpty() {
        return _added.size() == 0 && _removed.size() == 0 ? true : false;
    }

    protected boolean storeAddedPlatformExtensionPoint(Class<? extends IPlatformExtensionPoint> clazz, IPlatformExtensionPoint extensionPoint) {
        if (clazz == null || EGFPlatformPlugin.getPlatformExtensionPointClasses().contains(clazz) == false || extensionPoint == null) {
            return false;
        }
        List<IPlatformExtensionPoint> extensionPoints = _added.get(clazz);
        if (extensionPoints == null) {
            extensionPoints = new ArrayList<IPlatformExtensionPoint>();
            _added.put(clazz, extensionPoints);
        }
        return extensionPoints.add(extensionPoint);
    }

    protected boolean storeRemovedPlatformExtensionPoint(Class<? extends IPlatformExtensionPoint> clazz, IPlatformExtensionPoint extensionPoint) {
        if (clazz == null || EGFPlatformPlugin.getPlatformExtensionPointClasses().contains(clazz) == false || extensionPoint == null) {
            return false;
        }
        List<IPlatformExtensionPoint> extensionPoints = _removed.get(clazz);
        if (extensionPoints == null) {
            extensionPoints = new ArrayList<IPlatformExtensionPoint>();
            _removed.put(clazz, extensionPoints);
        }
        return extensionPoints.add(extensionPoint);
    }

}
