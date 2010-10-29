/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.platform.internal.pde;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.common.helper.CollectionHelper;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.l10n.CorePlatformMessages;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPoint;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.framework.internal.core.AbstractBundle;
import org.eclipse.osgi.framework.internal.core.BundleFragment;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.osgi.framework.Bundle;

class PlatformBundle implements IPlatformBundle {

    private Bundle _bundle;

    private IPluginModelBase _base;

    private BundleDescription _bundleDescription;

    private String _previousBundleId;

    private Map<Class<?>, Map<String, Object>> _extensions = new HashMap<Class<?>, Map<String, Object>>();

    public PlatformBundle(IPluginModelBase base) {
        Assert.isNotNull(base);
        Assert.isNotNull(base.getBundleDescription());
        Assert.isNotNull(BundleHelper.getBundleId(base));
        _base = base;
        _bundleDescription = base.getBundleDescription();
        _previousBundleId = BundleHelper.getBundleId(base);
    }

    public PlatformBundle(Bundle bundle) {
        Assert.isNotNull(bundle);
        Assert.isLegal(bundle instanceof AbstractBundle);
        Assert.isNotNull(((AbstractBundle) bundle).getBundleDescription());
        Assert.isNotNull(bundle.getSymbolicName());
        _bundle = bundle;
        _bundleDescription = ((AbstractBundle) bundle).getBundleDescription();
        _previousBundleId = bundle.getSymbolicName();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_base == null) ? 0 : _base.hashCode());
        result = prime * result + ((_bundle == null) ? 0 : _bundle.hashCode());
        result = prime * result + ((_bundleDescription == null) ? 0 : _bundleDescription.hashCode());
        result = prime * result + ((_previousBundleId == null) ? 0 : _previousBundleId.hashCode());
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
        if (object instanceof IPlatformBundle == false) {
            return false;
        }
        if (getPluginModelBase() != null && ((IPlatformBundle) object).getPluginModelBase() != null) {
            return getPluginModelBase() == ((IPlatformBundle) object).getPluginModelBase();
        }
        if (getBundle() != null && ((IPlatformBundle) object).getBundle() != null) {
            return getBundle() == ((IPlatformBundle) object).getBundle();
        }
        return false;
    }

    public String getBundleId() {
        if (_base != null) {
            return BundleHelper.getBundleId(_base);
        }
        return getBundle().getSymbolicName();
    }

    public String getPreviousBundleId() {
        return _previousBundleId;
    }

    public IPluginModelBase getPluginModelBase() {
        if (isRuntime() == false) {
            return _base;
        }
        // Runtime analysis
        IPluginModelBase base = PluginRegistry.findModel(getBundleId());
        if (base == null) {
            return null;
        }
        // Runtime Bundle and Target Bundle are compatible
        if (base.getPluginBase().getVersion() != null && base.getPluginBase().getVersion().equals(_bundle.getVersion().toString())) {
            return base;
        }
        return null;
    }

    public boolean isFragment() {
        if (getPluginModelBase() != null) {
            return getPluginModelBase().isFragmentModel();
        }
        return getBundle() instanceof BundleFragment;
    }

    /**
     * Get the IProject from this IPlatformBundle
     * 
     * @return null if the bundle is not in the workspace.
     */
    public IProject getProject() {
        if (isWorkspace()) {
            // Retrieve project from the model.
            return getPluginModelBase().getUnderlyingResource().getProject();
        }
        return null;
    }

    /**
     * Get the Bundle from this IPlatformBundle
     * 
     * @return null if the bundle is a target or a workspace bundle.
     */
    public Bundle getBundle() {
        if (isRuntime()) {
            return _bundle;
        }
        // Runtime analysis
        Bundle bundle = Platform.getBundle(getBundleId());
        if (bundle == null) {
            return null;
        }
        // Target Bundle and Runtime Bundle are compatible
        if (_base.getPluginBase().getVersion() != null && _base.getPluginBase().getVersion().equals(bundle.getVersion().toString())) {
            return bundle;
        }
        return null;
    }

    public BundleDescription getBundleDescription() {
        return _bundleDescription;
    }

    public boolean isRuntime() {
        return _bundle != null;
    }

    public boolean isTarget() {
        if (isRuntime() == false) {
            return getPluginModelBase().getUnderlyingResource() == null;
        }
        return false;
    }

    public boolean isWorkspace() {
        return isRuntime() == false && isTarget() == false;
    }

    @SuppressWarnings("unchecked")
    protected <T extends IPlatformExtensionPoint> T createPlatformExtensionPoint(Class<T> clazz, Object element) {
        if (element instanceof IPluginElement) {
            // Check
            if (((IPluginElement) element).isValid() == false) {
                EGFPlatformPlugin.getDefault().logWarning(NLS.bind("PlatformBundle.createPlatformExtensionPoint(..) _ Bundle ''{0}'' invalid IPluginElement ''{1}''.", //$NON-NLS-1$
                        getBundleId(), ((IPluginElement) element).getName()));
                return null;
            }
        } else if (element instanceof IConfigurationElement) {
            // Check
            if (((IConfigurationElement) element).isValid() == false) {
                EGFPlatformPlugin.getDefault().logWarning(NLS.bind("PlatformBundle.createPlatformExtensionPoint(..) _ Bundle ''{0}'' invalid IConfigurationElement ''{1}''.", //$NON-NLS-1$
                        getBundleId(), ((IConfigurationElement) element).getName()));
                return null;
            }
        } else {
            throw new UnsupportedOperationException();
        }
        // Retrieve Factory
        IPlatformExtensionPointFactory<T> extensionPointFactory = (IPlatformExtensionPointFactory<T>) EGFPlatformPlugin.getPlatformExtensionPointFactories().get(clazz);
        if (extensionPointFactory == null) {
            return null;
        }
        T extensionPoint = extensionPointFactory.createExtensionPoint(this, element);
        if (extensionPoint == null) {
            return null;
        }
        Map<String, Object> extensionPoints = _extensions.get(clazz);
        if (extensionPoints == null) {
            extensionPoints = new HashMap<String, Object>();
            _extensions.put(clazz, extensionPoints);
        }
        try {
            if (extensionPoints.get(extensionPoint.getId()) != null) {
                EGFPlatformPlugin.getDefault().logWarning(NLS.bind("PlatformBundle.createPlatformExtensionPoint(..) _ Bundle ''{0}'' already contains Extension Point ''{1}''.", //$NON-NLS-1$
                        getBundleId(), extensionPoint.getId()));
                return null;
            }
            if (extensionPoints.put(extensionPoint.getId(), extensionPoint) != null) {
                EGFPlatformPlugin.getDefault().logError(NLS.bind("PlatformBundle.createPlatformExtensionPoint(..) _ Bundle ''{0}'' unable to add Extension Point ''{1}''.", //$NON-NLS-1$
                        getBundleId(), extensionPoint.getId()));
                return null;
            }
        } catch (Throwable t) {
            EGFPlatformPlugin.getDefault().logError("PlatformBundle.createPlatformExtensionPoint(..)", t); //$NON-NLS-1$
            return null;
        }
        return clazz.cast(extensionPoint);
    }

    protected void addPlatformExtensionPoint(Class<? extends IPlatformExtensionPoint> clazz, IPlatformExtensionPoint extensionPoint) {
        if (extensionPoint == null) {
            return;
        }
        Map<String, Object> extensionPoints = _extensions.get(clazz);
        if (extensionPoints == null) {
            extensionPoints = new HashMap<String, Object>();
            _extensions.put(clazz, extensionPoints);
        }
        try {
            if (extensionPoints.get(extensionPoint.getId()) != null) {
                EGFPlatformPlugin.getDefault().logWarning(NLS.bind("PlatformBundle.addPlatformExtensionPoint(..) _ Bundle ''{0}'' already contains Extension Point ''{1}''.", //$NON-NLS-1$
                        getBundleId(), extensionPoint.getId()));
            }
            if (extensionPoints.put(extensionPoint.getId(), extensionPoint) != null) {
                EGFPlatformPlugin.getDefault().logError(NLS.bind("PlatformBundle.addPlatformExtensionPoint(..) _ Bundle ''{0}'' unable to add Extension Point ''{1}''.", //$NON-NLS-1$
                        getBundleId(), extensionPoint.getId()));
            }
            ((AbstractPlatformExtensionPoint) extensionPoint).setPlatformBundle(this);
        } catch (Throwable t) {
            EGFPlatformPlugin.getDefault().logError("PlatformBundle.addPlatformExtensionPoint(..)", t); //$NON-NLS-1$
        }
    }

    public IPlatformExtensionPoint[] getPlatformExtensionPoints() {
        List<Object> extensionPoints = new ArrayList<Object>();
        for (Map<String, Object> extensionPoint : _extensions.values()) {
            extensionPoints.addAll(extensionPoint.values());
        }
        return extensionPoints.toArray(new IPlatformExtensionPoint[extensionPoints.size()]);
    }

    public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(Class<T> clazz) {
        List<Object> extensionPoints = new ArrayList<Object>();
        if (clazz != null && EGFPlatformPlugin.getPlatformExtensionPoints().values().contains(clazz)) {
            Map<String, Object> extensions = _extensions.get(clazz);
            if (extensions != null) {
                extensionPoints.addAll(extensions.values());
            }
        }
        return CollectionHelper.toArray(extensionPoints, clazz);
    }

    protected boolean removePlatformExtensionPoint(Class<? extends IPlatformExtensionPoint> clazz, IPlatformExtensionPoint extensionPoint) {
        if (clazz == null || EGFPlatformPlugin.getPlatformExtensionPoints().values().contains(clazz) == false || extensionPoint == null) {
            return false;
        }
        if (_extensions.get(clazz) != null && _extensions.get(clazz).remove(extensionPoint.getId()) != null) {
            ((AbstractPlatformExtensionPoint) extensionPoint).dispose();
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        for (Class<? extends IPlatformExtensionPoint> clazz : EGFPlatformPlugin.getPlatformExtensionPoints().values()) {
            if (_extensions.get(clazz) != null && _extensions.get(clazz).size() > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean hasPlatformExtensionPoint(IPlatformExtensionPoint extensionPoint) {
        if (extensionPoint == null) {
            return false;
        }
        for (Class<? extends IPlatformExtensionPoint> clazz : EGFPlatformPlugin.getPlatformExtensionPoints().values()) {
            if (hasPlatformExtensionPoint(clazz, extensionPoint)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPlatformExtensionPoint(Class<? extends IPlatformExtensionPoint> clazz, IPlatformExtensionPoint extensionPoint) {
        if (clazz == null || EGFPlatformPlugin.getPlatformExtensionPoints().values().contains(clazz) == false || extensionPoint == null) {
            return false;
        }
        if (_extensions.get(clazz) != null && _extensions.get(clazz).get(extensionPoint.getId()) != null) {
            return true;
        }
        return false;
    }

    public String getInstallLocation() {
        if (isRuntime()) {
            try {
                return FileLocator.getBundleFile(getBundle()).getAbsolutePath();
            } catch (IOException ioe) {
                return null;
            }
        }
        return getPluginModelBase().getInstallLocation();
    }

    public URI getUnrootedBase() {
        return URI.createURI("platform:/plugin/" + getBundleId()); //$NON-NLS-1$
    }

    public URI getRootedBase() {
        return URI.createURI("platform:/plugin/" + getBundleId() + "/"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
    public String toString() {
        String id = getBundleId();
        String previousId = getPreviousBundleId();
        String version = getBundleDescription().getVersion().toString();
        StringBuilder text = new StringBuilder();
        if (version != null && version.length() > 0) {
            text.append(id).append(" ").append(version); //$NON-NLS-1$
        } else {
            text.append(id);
        }
        if (id.equals(previousId) == false) {
            text.append(" PreviousId: ").append(previousId); //$NON-NLS-1$
        }
        if (getPluginModelBase() != null) {
            IPluginBase pluginBase = getPluginModelBase().getPluginBase();
            if (pluginBase.getModel() != null && pluginBase.getModel().isInSync() == false) {
                text.append(" ").append(CorePlatformMessages.PlatformManager_outOfSync); //$NON-NLS-1$
            }
        }
        if (isTarget()) {
            text.append(" [Target]"); //$NON-NLS-1$
        } else if (isWorkspace()) {
            text.append(" [Workspace]"); //$NON-NLS-1$
        } else {
            text.append(" [Runtime]"); //$NON-NLS-1$
        }
        if (getInstallLocation() != null) {
            text.append(" [").append(getInstallLocation()).append("]"); //$NON-NLS-1$  //$NON-NLS-2$
        }
        return text.toString();
    }

}
