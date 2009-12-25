/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
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
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.l10n.CorePlatformMessages;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPoint;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointFactory;
import org.eclipse.egf.core.platform.util.CollectionHelper;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.internal.ui.PDELabelProvider;

public class PlatformBundle implements IPlatformBundle {

  private static Map<Class<? extends IPlatformExtensionPoint>, IPlatformExtensionPointFactory<? extends IPlatformExtensionPoint>> _extensionPointFactories;

  @SuppressWarnings("unchecked")
  private static Map<Class<? extends IPlatformExtensionPoint>, IPlatformExtensionPointFactory<? extends IPlatformExtensionPoint>> getExtensionPointFactories() {
    if (_extensionPointFactories == null) {
      _extensionPointFactories = new HashMap<Class<? extends IPlatformExtensionPoint>, IPlatformExtensionPointFactory<? extends IPlatformExtensionPoint>>();
      for (String extensionPoint : EGFPlatformPlugin.getDefault().getPlatform().keySet()) {
        // Factory
        IPlatformExtensionPointFactory<?> clazz = (IPlatformExtensionPointFactory<?>) ExtensionPointHelper.createInstance(EGFPlatformPlugin.getDefault().getPlatform().get(extensionPoint), IManagerConstants.MANAGER_ATT_CLASS);
        // Fetch Returned Types from Factory
        Class<?> key = EGFPlatformPlugin.fetchReturnedTypeFromFactory(((IPlatformExtensionPointFactory<?>) clazz).getClass());
        // Store it
        _extensionPointFactories.put((Class<? extends IPlatformExtensionPoint>) key, (IPlatformExtensionPointFactory<?>) clazz);
      }
    }
    return _extensionPointFactories;
  }

  public static Set<Class<? extends IPlatformExtensionPoint>> getExtensionPointFactoriesKeys() {
    return getExtensionPointFactories().keySet();
  }

  @SuppressWarnings("unchecked")
  private static <T extends IPlatformExtensionPoint> IPlatformExtensionPointFactory<T> getPlatformExtensionPointFactory(Class<T> clazz) {
    return (IPlatformExtensionPointFactory<T>) getExtensionPointFactories().get(clazz);
  }

  private IPluginModelBase _base;

  private String _previousBundleId;

  private Map<Class<?>, Map<String, Object>> _extensions = new HashMap<Class<?>, Map<String, Object>>();

  public PlatformBundle(IPluginModelBase base) {
    Assert.isNotNull(base);
    Assert.isNotNull(base.getBundleDescription());
    Assert.isNotNull(BundleHelper.getBundleId(base));
    _base = base;
    _previousBundleId = BundleHelper.getBundleId(base);
  }

  public int compareTo(IPlatformBundle model) {
    if (this.equals(model)) {
      return 0;
    }
    if (isTarget() == model.isTarget()) {
      return 0;
    }
    if (isTarget() == false) {
      return -1;
    }
    return 1;
  }

  public String getBundleId() {
    return BundleHelper.getBundleId(getPluginModelBase());
  }

  public String getPreviousBundleId() {
    return _previousBundleId;
  }

  public IPluginBase getPluginBase() {
    return _base.getPluginBase();
  }

  public IPluginModelBase getPluginModelBase() {
    return _base;
  }

  /**
   * Get the IProject from this IPlatformPlugin
   * 
   * @return null if the plug-in is not in the workspace.
   */
  public IProject getProject() {
    if (isTarget() == false) {
      // Retrieve project from the model.
      return getPluginModelBase().getUnderlyingResource().getProject();
    }
    return null;
  }

  public BundleDescription getBundleDescription() {
    return getPluginModelBase().getBundleDescription();
  }

  public boolean isTarget() {
    return getPluginModelBase().getUnderlyingResource() == null;
  }

  public void addPlatformExtensionPoint(Class<? extends IPlatformExtensionPoint> clazz, IPluginExtension extension) {
    if (extension == null || extension.getPluginModel() == null) {
      return;
    }
    for (IPluginObject pluginObject : extension.getChildren()) {
      if (pluginObject instanceof IPluginElement) {
        addPlatformExtensionPoint(clazz, (IPluginElement) pluginObject);
      }
    }
  }

  public <T extends IPlatformExtensionPoint> T addPlatformExtensionPoint(Class<T> clazz, IPluginElement pluginElement) {
    if (pluginElement == null) {
      return null;
    }
    IPlatformExtensionPointFactory<T> extensionPointFactory = getPlatformExtensionPointFactory(clazz);
    if (extensionPointFactory == null) {
      return null;
    }
    T extensionPoint = extensionPointFactory.createExtensionPoint(this, pluginElement);
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
        EGFPlatformPlugin.getDefault().logWarning(NLS.bind("PlatformPlugin.addPlatformExtensionPoint(..) _ Bundle ''{0}'' already contains such Extension Point ''{1}''.", //$NON-NLS-1$
            getBundleId(), extensionPoint.getId()));
        return null;
      }
      if (extensionPoints.put(extensionPoint.getId(), extensionPoint) != null) {
        EGFPlatformPlugin.getDefault().logError(NLS.bind("PlatformPlugin.addPlatformExtensionPoint(..) _ Bundle ''{0}'' unable to add Extension Point ''{1}''.", //$NON-NLS-1$
            getBundleId(), extensionPoint.getId()));
        return null;
      }
    } catch (Exception e) {
      EGFPlatformPlugin.getDefault().logError(new String("PlatformPlugin.addPlatformExtensionPoint(..)"), e); //$NON-NLS-1$
      return null;
    }
    return clazz.cast(extensionPoint);
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
    if (clazz != null && getExtensionPointFactoriesKeys().contains(clazz)) {
      Map<String, Object> extensions = _extensions.get(clazz);
      if (extensions != null) {
        extensionPoints.addAll(_extensions.get(clazz).values());
      }
    }
    return CollectionHelper.toArray(extensionPoints, clazz);
  }

  public boolean removePlatformExtensionPoint(IPlatformExtensionPoint extensionPoint) {
    if (extensionPoint == null) {
      return false;
    }
    for (Class<? extends IPlatformExtensionPoint> clazz : getExtensionPointFactoriesKeys()) {
      if (removePlatformExtensionPoint(clazz, extensionPoint)) {
        return true;
      }
    }
    return false;
  }

  public boolean removePlatformExtensionPoint(Class<? extends IPlatformExtensionPoint> clazz, IPlatformExtensionPoint extensionPoint) {
    if (clazz == null || getExtensionPointFactoriesKeys().contains(clazz) == false || extensionPoint == null) {
      return false;
    }
    if (_extensions.get(clazz) != null && _extensions.get(clazz).remove(extensionPoint.getId()) != null) {
      return true;
    }
    return false;
  }

  public boolean isEmpty() {
    for (Class<? extends IPlatformExtensionPoint> clazz : getExtensionPointFactoriesKeys()) {
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
    for (Class<? extends IPlatformExtensionPoint> clazz : getExtensionPointFactoriesKeys()) {
      if (hasPlatformExtensionPoint(clazz, extensionPoint)) {
        return true;
      }
    }
    return false;
  }

  public boolean hasPlatformExtensionPoint(Class<? extends IPlatformExtensionPoint> clazz, IPlatformExtensionPoint extensionPoint) {
    if (clazz == null || getExtensionPointFactoriesKeys().contains(clazz) == false || extensionPoint == null) {
      return false;
    }
    if (_extensions.get(clazz) != null && _extensions.get(clazz).get(extensionPoint.getId()) != null) {
      return true;
    }
    return false;
  }

  public String getBundleLocation() {
    return getBundleDescription().getLocation();
  }

  @Override
  public String toString() {
    IPluginBase pluginBase = getPluginModelBase().getPluginBase();
    String id = getBundleId();
    String previousId = getPreviousBundleId();
    String version = pluginBase.getVersion();
    StringBuilder text = new StringBuilder("Id: "); //$NON-NLS-1$
    if (version != null && version.length() > 0) {
      text.append(id).append(" ").append(PDELabelProvider.formatVersion(pluginBase.getVersion())); //$NON-NLS-1$
    } else {
      text.append(id);
    }
    if (id.equals(previousId) == false) {
      text.append(" PreviousId: ").append(previousId); //$NON-NLS-1$
    }
    if (pluginBase.getModel() != null && pluginBase.getModel().isInSync() == false) {
      text.append(" ").append(CorePlatformMessages.PlatformManager_outOfSync); //$NON-NLS-1$
    }
    if (isTarget()) {
      text.append(" [Target]"); //$NON-NLS-1$
    } else {
      text.append(" [Workspace]"); //$NON-NLS-1$
    }
    if (getBundleLocation() != null) {
      text.append(" [").append(getBundleLocation()).append("]"); //$NON-NLS-1$  //$NON-NLS-2$
    }
    return text.toString();
  }

}
