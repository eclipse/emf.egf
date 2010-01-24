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
package org.eclipse.egf.model.resource;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.model.edit.EGFModelEditPlugin;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.resource.ResourceItemProvider;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ModelResourceItemProvider extends ResourceItemProvider {

  /**
   * This constructs an instance from a factory and a notifier.
   */
  public ModelResourceItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This returns the label text for the adapted class.
   */
  @Override
  public String getText(Object object) {
    Resource resource = (Resource) object;
    StringBuffer buffer = new StringBuffer(resource.getURI() == null ? "" : URI.decode(resource.getURI().toString())); //$NON-NLS-1$
    IPlatformFcore fc = EGFCorePlugin.getPlatformFcore(resource);
    if (fc != null) {
      if (fc.getPlatformBundle().isTarget()) {
        buffer.append(" [Target]"); //$NON-NLS-1$
      } else {
        buffer.append(" [Workspace]"); //$NON-NLS-1$
      }
      buffer.append(" ["); //$NON-NLS-1$
      buffer.append(fc.getPlatformBundle().getBundleLocation());
      buffer.append("]"); //$NON-NLS-1$
    }
    return buffer.toString();
  }

  /**
   * This returns Fcore.gif.
   */
  @Override
  public Object getImage(Object object) {
    return URI.createURI(EGFModelEditPlugin.INSTANCE.getPluginResourceLocator().getImage("full/obj16/Fcore").toString()); //$NON-NLS-1$
  }

}
