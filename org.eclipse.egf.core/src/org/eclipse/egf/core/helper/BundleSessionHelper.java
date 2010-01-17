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
package org.eclipse.egf.core.helper;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPoint;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class BundleSessionHelper {

  private BundleSessionHelper() {
    // Prevent Instantiation
  }

  public static Bundle getBundle(ProjectBundleSession projectBundleSession, IPlatformExtensionPoint platformExtensionPoint) throws CoreException {
    // Usual Tests
    if (projectBundleSession == null || platformExtensionPoint == null) {
      return null;
    }
    // Locate Bundle
    Bundle bundle = null;
    if (platformExtensionPoint.getPlatformBundle().isTarget()) {
      bundle = platformExtensionPoint.getPlatformBundle().getBundle();
    } else {
      bundle = projectBundleSession.getBundle(platformExtensionPoint.getPlatformBundle().getProject());
    }
    return bundle;
  }

}
