/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.provider.resource;

import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformFactoryComponent;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.resource.ResourceItemProvider;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFResourceItemProvider extends ResourceItemProvider {

  /**
   * This constructs an instance from a factory and a notifier.
   */
  public EGFResourceItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This returns the label text for the adapted class.
   */
  @Override
  public String getText(Object object) {
    Resource resource = (Resource) object;
    StringBuffer buffer = new StringBuffer(resource.getURI() == null ? "" : resource.getURI().toString());
    IPlatformFactoryComponent fc = EGFPlatformPlugin.getPlatformFactoryComponent(resource);
    if (fc != null) {
      if (fc.getPlatformPlugin().isTarget()) {
        buffer.append(" [Target]"); //$NON-NLS-1$
      } else {
        buffer.append(" [Workspace]"); //$NON-NLS-1$
      }
      buffer.append(" ["); //$NON-NLS-1$
      buffer.append(fc.getPlatformPlugin().getLocation());
      buffer.append("]"); //$NON-NLS-1$
    }
    return buffer.toString();
  }

}
