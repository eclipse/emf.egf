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
package org.eclipse.egf.model.productionplan.internal.invocation;

import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointFactory;
import org.eclipse.egf.model.productionplan.invocation.IPlatformTaskInvocationConstants;
import org.eclipse.egf.model.productionplan.invocation.IPlatformTaskInvocation;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginElement;

/**
 * @author Xavier Maysonnave
 * 
 */
public final class PlatformTaskInvocationFactory implements IPlatformExtensionPointFactory<IPlatformTaskInvocation> {

  public IPlatformTaskInvocation createExtensionPoint(IPlatformBundle platformBundle, IPluginElement pluginElement) {
    if (pluginElement == null) {
      return null;
    }
    if (IPlatformTaskInvocationConstants.TASK_INVOCATION_EXTENSION_CHILD.equals(pluginElement.getName()) == false) {
      return null;
    }
    IPluginAttribute id = pluginElement.getAttribute(IPlatformTaskInvocationConstants.INVOCATION_ATT_ID);
    if (id == null || id.getValue() == null || id.getValue().trim().length() == 0) {
      return null;
    }
    IPluginAttribute clazz = pluginElement.getAttribute(IPlatformTaskInvocationConstants.INVOCATION_ATT_CLASS);
    if (clazz == null || clazz.getValue() == null || clazz.getValue().trim().length() == 0) {
      return null;
    }
    return new PlatformTaskInvocation(platformBundle, pluginElement, id.getValue(), clazz.getValue());
  }

}
