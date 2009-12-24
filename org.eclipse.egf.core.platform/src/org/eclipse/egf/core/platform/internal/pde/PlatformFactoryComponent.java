/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 * 
 */
package org.eclipse.egf.core.platform.internal.pde;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.AssertionFailedException;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.uri.URIHelper;
import org.eclipse.egf.core.platform.pde.IFactoryComponentConstants;
import org.eclipse.egf.core.platform.pde.IPlatformFactoryComponent;
import org.eclipse.egf.core.platform.pde.IPlatformPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginElement;

public class PlatformFactoryComponent implements IPlatformFactoryComponent {

  private IPluginElement _element;

  private IPlatformPlugin _base;

  private URI _previousUri;

  private String _id;

  private String _name;

  public PlatformFactoryComponent(IPlatformPlugin base, IPluginElement element) throws AssertionFailedException, IllegalArgumentException {
    Assert.isNotNull(base);
    Assert.isNotNull(element);
    Assert.isNotNull(element.getPluginModel());
    Assert.isLegal(base.getPluginModelBase().equals(element.getPluginModel()));
    Assert.isLegal(IFactoryComponentConstants.FACTORY_COMPONENT_EXTENSION_CHILD.equals(element.getName()));
    IPluginAttribute id = element.getAttribute(IFactoryComponentConstants.FACTORY_COMPONENT_ATT_ID);
    Assert.isNotNull(id);
    Assert.isLegal(id.getValue().trim().length() > 0);
    _base = base;
    _element = element;
    _id = id.getValue().trim();
    _previousUri = URIHelper.getPlatformURI(base.getBundleId(), id.getValue(), false);
    _name = new Path(_previousUri.lastSegment()).removeFileExtension().toString();
  }

  public int compareTo(IPlatformFactoryComponent fc) {
    if (this.equals(fc)) {
      return 0;
    }
    if (getURI().equals(fc.getURI())) {
      return toString().compareTo(fc.toString());
    }
    return getURI().toString().compareTo(fc.getURI().toString());
  }

  public String getName() {
    return _name;
  }

  public String getId() {
    return _id;
  }

  public IPluginElement getPluginElement() {
    return _element;
  }

  public IPlatformPlugin getPlatformPlugin() {
    return _base;
  }

  public URI getPreviousURI() {
    return _previousUri;
  }

  public URI getURI() {
    if (getPlatformPlugin().getBundleId().equals(getPlatformPlugin().getPreviousBundleId()) == false) {
      return URIHelper.getPlatformURI(getPlatformPlugin().getBundleId(), getId(), false);
    }
    return getPreviousURI();
  }

  public String toString() {
    return getURI().toString();
  }

}
