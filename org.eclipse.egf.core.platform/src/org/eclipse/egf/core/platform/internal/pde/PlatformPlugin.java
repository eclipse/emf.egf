/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *
 * </copyright>
 * 
 */
package org.eclipse.egf.core.platform.internal.pde;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.console.EGFConsolePlugin;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IFactoryComponentConstants;
import org.eclipse.egf.core.platform.pde.IPlatformFactoryComponent;
import org.eclipse.egf.core.platform.pde.IPlatformPlugin;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.internal.ui.PDELabelProvider;
import org.eclipse.pde.internal.ui.PDEUIMessages;

public class PlatformPlugin implements IPlatformPlugin {

  private IPluginModelBase _base;

  private String _previousBundleId;

  private Map<String, IPlatformFactoryComponent> _factoryComponents = new HashMap<String, IPlatformFactoryComponent>();

  public PlatformPlugin(IPluginModelBase base) {
    Assert.isNotNull(base);
    Assert.isNotNull(base.getBundleDescription());
    Assert.isNotNull(BundleHelper.getBundleId(base));
    _base = base;
    _previousBundleId = BundleHelper.getBundleId(base);
  }

  public int compareTo(IPlatformPlugin model) {
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

  public IPlatformFactoryComponent[] getPlatformFactoryComponents() {
    return _factoryComponents.values().toArray(new IPlatformFactoryComponent[_factoryComponents.size()]);
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

  public void addPlatformFactoryComponent(IPluginExtension extension) {
    if (extension == null || extension.getPluginModel() == null) {
      return;
    }
    for (IPluginObject pluginObject : extension.getChildren()) {
      if (pluginObject instanceof IPluginElement) {
        addPlatformFactoryComponent((IPluginElement) pluginObject);
      }
    }
  }

  public IPlatformFactoryComponent addPlatformFactoryComponent(IPluginElement element) {
    if (element == null) {
      return null;
    }
    if (IFactoryComponentConstants.FACTORY_COMPONENT_EXTENSION_CHILD.equals(element.getName())) {
      try {
        IPlatformFactoryComponent fc = new PlatformFactoryComponent(this, element);
        if (_factoryComponents.get(fc.getValue()) != null) {
          String msg = NLS.bind("PlatformPlugin.addPlatformFactoryComponent(..) _ Bundle ''{0}'' already contains such Factory Component ''{1}''.", //$NON-NLS-1$
              getBundleId(), fc.getValue());
          EGFPlatformPlugin.getDefault().log(msg);
          if (EGFPlatformPlugin.getDefault().isDebugging()) {
            EGFConsolePlugin.getConsole().logWarning(msg);
          }
        } else {
          if (_factoryComponents.put(fc.getValue(), fc) != null) {
            String msg = NLS.bind("PlatformPlugin.addPlatformFactoryComponent(..) _ Bundle ''{0}'' unable to add Factory Component ''{1}''.", //$NON-NLS-1$
                getBundleId(), fc.getValue());
            EGFPlatformPlugin.getDefault().log(msg);
            if (EGFPlatformPlugin.getDefault().isDebugging()) {
              EGFConsolePlugin.getConsole().logError(msg);
            }
          } else {
            return fc;
          }
        }
      } catch (RuntimeException re) {
        String msg = new String("PlatformPlugin.addPlatformFactoryComponent(..)"); //$NON-NLS-1$
        EGFPlatformPlugin.getDefault().log(msg, re);
        if (EGFPlatformPlugin.getDefault().isDebugging()) {
          EGFConsolePlugin.getConsole().logThrowable(msg, re);
        }
      }
    }
    return null;
  }

  public boolean removePlatformFactoryComponent(IPlatformFactoryComponent factoryComponent) {
    if (factoryComponent == null) {
      return false;
    }
    return _factoryComponents.remove(factoryComponent.getValue()) != null;
  }

  public boolean hasPlatformFactoryComponent(IPlatformFactoryComponent factoryComponent) {
    if (factoryComponent == null) {
      return false;
    }
    return _factoryComponents.get(factoryComponent.getValue()) != null;
  }

  public String getLocation() {
    return getBundleDescription().getLocation();
  }

  public String toString() {
    IPluginBase pluginBase = getPluginModelBase().getPluginBase();
    String id = getBundleId();
    String previousId = getPreviousBundleId();
    String version = pluginBase.getVersion();
    StringBuilder text = new StringBuilder("Id: ");
    if (version != null && version.length() > 0) {
      text.append(id).append(" ").append(PDELabelProvider.formatVersion(pluginBase.getVersion()));
    } else {
      text.append(id);
    }
    if (id.equals(previousId) == false) {
      text.append(" PreviousId: ").append(previousId);
    }
    if (pluginBase.getModel() != null && pluginBase.getModel().isInSync() == false) {
      text.append(" ").append(PDEUIMessages.PluginModelManager_outOfSync); //$NON-NLS-1$
    }
    if (isTarget()) {
      text.append(" [Target]"); //$NON-NLS-1$
    } else {
      text.append(" [Workspace]"); //$NON-NLS-1$
    }
    if (getLocation() != null) {
      text.append(" [").append(getLocation()).append("]"); //$NON-NLS-1$  //$NON-NLS-2$
    }
    return text.toString();
  }

}
