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

import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.osgi.framework.Bundle;

public interface IPlatformBundle {

  /**
   * Returns the current bundle id associated with IPlatformBundle
   * 
   * @return the current bundle id.
   */
  public String getBundleId();

  /**
   * Returns the initial bundle id associated with IPlatformBundle.
   * useful when the symbolic name has changed in the manifest file.
   * 
   * @return the initial bundle id.
   */
  public String getPreviousBundleId();

  /**
   * Returns an IProject if this IPlatformBundle is associated with a
   * workspace IProject.
   * 
   * @return an IProject if this IPlatformBundle is a workspace project,
   *         or <code>null</code> if this IPlatformBundle is a target one.
   * 
   */
  public IProject getProject();

  /**
   * Returns a Bundle if this IPlatformBundle is a target bundle.
   * 
   * @return a Bundle if this IPlatformBundle is a target bundle,
   *         or <code>null</code> if this IPlatformBundle is a workspace one.
   * 
   */
  public Bundle getBundle();

  /**
   * Returns a top-level model object.
   * 
   * @return a top-level model object representing a plug-in or a fragment.
   */
  public IPluginBase getPluginBase();

  /**
   * Manifest file model associated with IPlatformBundle
   * 
   * @return all plug-ins and (possibly) fragments in the workspace as well as
   *         all plug-ins and
   *         (possibly) fragments that are checked on the Target Platform
   *         preference page.
   */
  public IPluginModelBase getPluginModelBase();

  /**
   * Tests if this IPlatformBundle is for the plug-in fragment.
   * 
   * @return <code>true</code> if the model is for the fragment,
   *         <code>false</code> otherwise.
   */
  public boolean isFragment();

  /**
   * Returns the bundle description of the plug-in
   * in case the plug-in uses the new OSGi bundle layout.
   * 
   * @return bundle description if this is an OSGi plug-in,
   *         or <code>null</code> if the plug-in is in a classic
   *         format.
   * 
   * @since 3.0
   */
  public BundleDescription getBundleDescription();

  /**
   * Whether or not this IPlatformBundle is a target IPlatformBundle.
   * 
   * @return true if this IPlatformBundle is a target bundle,
   *         false if this IPlatformBundle is a workspace bundle.
   * 
   */
  public boolean isTarget();

  public boolean isEmpty();

  /**
   * The location string for this bundle.
   * 
   * @return The bundle location or null if the bundle description
   *         does not have a location
   */
  public String getBundleLocation();

  /**
   * The URL for this bundle.
   * 
   * @return The bundle URL.
   */
  public URL getBundleURL();

  public IPlatformExtensionPoint[] getPlatformExtensionPoints();

  public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(Class<T> clazz);

  public boolean hasPlatformExtensionPoint(IPlatformExtensionPoint platformExtensionPoint);

  public boolean hasPlatformExtensionPoint(Class<? extends IPlatformExtensionPoint> clazz, IPlatformExtensionPoint platformExtensionPoint);

  public void addPlatformExtensionPoint(Class<? extends IPlatformExtensionPoint> clazz, IPluginExtension extension);

  public <T extends IPlatformExtensionPoint> T addPlatformExtensionPoint(Class<T> clazz, IPluginElement element);

  public boolean removePlatformExtensionPoint(IPlatformExtensionPoint platformExtensionPoint);

  public boolean removePlatformExtensionPoint(Class<? extends IPlatformExtensionPoint> clazz, IPlatformExtensionPoint platformExtensionPoint);

}
