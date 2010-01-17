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
package org.eclipse.egf.core.platform.pde;

import org.eclipse.core.runtime.Assert;
import org.eclipse.pde.core.plugin.IPluginElement;

public abstract class PlatformExtensionPoint implements IPlatformExtensionPoint {

  private IPluginElement _element;

  private IPlatformBundle _bundle;

  private String _id;

  public PlatformExtensionPoint(IPlatformBundle bundle, IPluginElement element, String id) {
    Assert.isNotNull(bundle);
    Assert.isNotNull(bundle.getPluginModelBase());
    Assert.isNotNull(element);
    Assert.isNotNull(element.getPluginModel());
    Assert.isLegal(bundle.getPluginModelBase().equals(element.getPluginModel()));
    Assert.isNotNull(id);
    Assert.isLegal(id.trim().length() > 0);
    _bundle = bundle;
    _element = element;
    _id = id.trim();
  }

  public String getId() {
    return _id;
  }

  public IPluginElement getPluginElement() {
    return _element;
  }

  public IPlatformBundle getPlatformBundle() {
    return _bundle;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object instanceof IPlatformExtensionPoint == false) {
      return false;
    }
    IPlatformExtensionPoint platformExtensionPoint = (IPlatformExtensionPoint) object;
    if (platformExtensionPoint.getPlatformBundle().equals(getPlatformBundle())) {
      return toString().compareTo(platformExtensionPoint.toString()) == 0;
    }
    return false;
  }

  @Override
  public String toString() {
    return getId();
  }

}
