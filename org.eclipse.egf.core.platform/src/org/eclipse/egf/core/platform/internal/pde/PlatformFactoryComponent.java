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

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.AssertionFailedException;
import org.eclipse.core.runtime.Path;
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
  
  private String _value;
  
  private String _name;
  
  public PlatformFactoryComponent(IPlatformPlugin base, IPluginElement element) throws AssertionFailedException, IllegalArgumentException {
    Assert.isNotNull(base);
    Assert.isNotNull(element);
    Assert.isNotNull(element.getPluginModel());    
    Assert.isLegal(base.getPluginModelBase().equals(element.getPluginModel()));
    Assert.isLegal(IFactoryComponentConstants.FACTORY_COMPONENT_EXTENSION_CHILD.equals(element.getName()));
    IPluginAttribute attribute = element.getAttribute(IFactoryComponentConstants.FACTORY_COMPONENT_ATT_ID);
    Assert.isNotNull(attribute);
    Assert.isLegal(attribute.getValue().trim().length() > 0);
    _base = base;
    _element = element;
    _value = attribute.getValue().trim();
    _previousUri = buildURI(base.getId(), attribute.getValue());
    _name = new Path(_previousUri.lastSegment()).removeFileExtension().toString();
  }
  
  public int compareTo(IPlatformFactoryComponent fc) {
    if (this.equals(fc)) {
      return 0;
    }
    if (getName().equals(fc.getName())) {
      return toString().compareTo(fc.toString());
    }
    return getName().compareTo(fc.getName());
  }  
  
  public static URI buildURI(String id, String value) {
    if (id == null || id.trim().length() == 0 || value == null || value.trim().length() == 0) {
      return null;
    }
    URI uri = URI.createURI(value.trim());
    if (uri.isRelative()) {
      uri = URI.createPlatformPluginURI(id.trim() + "/" + uri.toString(), true); //$NON-NLS-1$
    }
    return uri;
  }
  
  public String getName() {
    return _name;
  }
  
  public String getValue() {
    return _value;
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
    if (getPlatformPlugin().getId().equals(getPlatformPlugin().getPreviousId()) == false) {
      return buildURI(getPlatformPlugin().getId(), getValue());
    }
    return getPreviousURI();
  }  
  
  public String toString() {
    return getURI().toString();
  }   
  
}
