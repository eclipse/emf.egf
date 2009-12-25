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
package org.eclipse.egf.core.internal.invocation;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.core.invocation.IPlatformInvocation;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.PlatformExtensionPoint;
import org.eclipse.pde.core.plugin.IPluginElement;

public final class PlatformInvocation extends PlatformExtensionPoint implements IPlatformInvocation {

  private String _clazz;

  public PlatformInvocation(IPlatformBundle bundle, IPluginElement element, String id, String clazz) {
    super(bundle, element, id);
    Assert.isNotNull(clazz);
    Assert.isLegal(clazz.trim().length() > 0);
    _clazz = clazz.trim();
  }

  public String getClazz() {
    return _clazz;
  }

}
