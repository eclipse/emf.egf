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
package org.eclipse.egf.common.uri;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.pde.core.plugin.IPluginModelBase;

/**
 * @author Xavier Maysonnave
 * 
 */
public class URIHelper {

  private URIHelper() {
    // Prevent Instantiation
  }

  public static URI getPlatformURI(IPluginModelBase model, String value) {
    if (model == null || value == null || value.trim().length() == 0) {
      return null;
    }
    String bundleId = BundleHelper.getBundleId(model);
    if (bundleId == null) {
      return null;
    }
    return getPlatformURI(bundleId, value.trim(), true);
  }

  public static URI getPlatformURI(IPath path) {
    if (path == null || path.segmentCount() < 2) {
      return null;
    }
    IProject project = ProjectHelper.getProject(path.segment(0));
    if (project == null) {
      return null;
    }
    String bundleId = BundleHelper.getBundleId(project);
    if (bundleId == null) {
      return null;
    }
    return getPlatformURI(bundleId, path.removeFirstSegments(1).toString(), true);
  }

  public static URI getPlatformURI(IResource resource) {
    if (resource == null || resource.getFullPath() == null || resource.getFullPath().segmentCount() < 2) {
      return null;
    }
    String bundleId = BundleHelper.getBundleId(resource);
    if (bundleId == null) {
      return null;
    }
    return getPlatformURI(bundleId, resource.getFullPath().removeFirstSegments(1).toString(), true);
  }

  public static URI getPlatformURI(String bundleId, String value, boolean encode) {
    if (bundleId == null || bundleId.trim().length() == 0 || value == null || value.trim().length() == 0) {
      return null;
    }
    URI uri = URI.createURI(value.trim());
    if (uri.isRelative()) {
      uri = URI.createPlatformPluginURI(bundleId.trim() + "/" + uri.toString(), encode); //$NON-NLS-1$
    }
    return uri;
  }

}
