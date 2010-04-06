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
package org.eclipse.egf.core.platform.pde;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.pde.core.plugin.IPluginElement;

public abstract class PlatformExtensionPointURI extends PlatformExtensionPoint implements IPlatformExtensionPointURI {

  private URI _previousUri;

  public PlatformExtensionPointURI(IPlatformBundle bundle, IPluginElement element, String id) {
    super(bundle, element, id);
    _previousUri = URIHelper.getPlatformURI(bundle.getBundleId(), getId(), true);
    Assert.isNotNull(_previousUri);
  }

  public URI getPreviousURI() {
    return _previousUri;
  }

  public URI getURI() {
    if (getPlatformBundle().getBundleId().equals(getPlatformBundle().getPreviousBundleId()) == false) {
      return URIHelper.getPlatformURI(getPlatformBundle().getBundleId(), getId(), true);
    }
    return getPreviousURI();
  }

  @Override
  public String toString() {
    return URI.decode(getURI().toString());
  }

}
