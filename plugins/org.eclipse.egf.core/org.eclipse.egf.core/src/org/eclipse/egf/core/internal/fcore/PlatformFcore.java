/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.core.internal.fcore;

import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.PlatformExtensionPointURI;
import org.eclipse.pde.core.plugin.IPluginElement;

public final class PlatformFcore extends PlatformExtensionPointURI implements IPlatformFcore {

  public PlatformFcore(IPlatformBundle bundle, IPluginElement element, String id) {
    super(bundle, element, id);
  }

  public String getName() {
    return getPreviousURI().toString();
  }

}
