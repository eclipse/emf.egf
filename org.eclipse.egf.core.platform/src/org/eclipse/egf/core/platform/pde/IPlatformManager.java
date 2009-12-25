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
package org.eclipse.egf.core.platform.pde;

import org.eclipse.core.resources.IProject;
import org.eclipse.pde.core.plugin.IPluginModelBase;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IPlatformManager {

  public IPlatformBundle[] getPlatformBundles();

  public IPlatformBundle getPlatformBundle(IPluginModelBase base);

  public IPlatformBundle getPlatformBundle(IProject project);

  public IPlatformBundle getPlatformBundle(String id);

  public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(Class<T> clazz);

  public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(IProject project, Class<T> clazz);

  public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(String id, Class<T> clazz);

  public <T extends IPlatformExtensionPoint> T[] getWorkspacePlatformExtensionPoints(Class<T> clazz);

  public <T extends IPlatformExtensionPoint> T[] getTargetPlatformExtensionPoints(Class<T> clazz);

  public void addPlatformExtensionPointListener(IPlatformExtensionPointListener listener);

  public void removePlatformExtensionPointListener(IPlatformExtensionPointListener listener);

}
