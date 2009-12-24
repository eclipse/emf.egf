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
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;

public interface IPlatformBundle extends Comparable<IPlatformBundle> {

  public String getBundleId();

  public String getPreviousBundleId();

  public IProject getProject();

  public IPluginBase getPluginBase();

  public IPluginModelBase getPluginModelBase();

  public BundleDescription getBundleDescription();

  public boolean isTarget();

  public boolean isEmpty();

  public String getBundleLocation();

  public IPlatformExtensionPoint[] getPlatformExtensionPoints();

  public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(Class<T> clazz);

  public boolean hasPlatformExtensionPoint(IPlatformExtensionPoint platformExtensionPoint);

  public boolean hasPlatformExtensionPoint(Class<? extends IPlatformExtensionPoint> clazz, IPlatformExtensionPoint platformExtensionPoint);

  public void addPlatformExtensionPoint(Class<? extends IPlatformExtensionPoint> clazz, IPluginExtension extension);

  public <T extends IPlatformExtensionPoint> T addPlatformExtensionPoint(Class<T> clazz, IPluginElement element);

  public boolean removePlatformExtensionPoint(IPlatformExtensionPoint platformExtensionPoint);

  public boolean removePlatformExtensionPoint(Class<? extends IPlatformExtensionPoint> clazz, IPlatformExtensionPoint platformExtensionPoint);

}
