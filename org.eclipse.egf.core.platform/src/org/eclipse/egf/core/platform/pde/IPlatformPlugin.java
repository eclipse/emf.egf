/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *
 * </copyright>
 * 
 */
package org.eclipse.egf.core.platform.pde;

import org.eclipse.core.resources.IProject;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;


public interface IPlatformPlugin extends Comparable<IPlatformPlugin> {
  
  public String getBundleId();
  
  public String getPreviousBundleId();  
  
  public IProject getProject();
  
  public IPluginBase getPluginBase();  
  
  public IPluginModelBase getPluginModelBase(); 
  
  public BundleDescription getBundleDescription();    
    
  public IPlatformFactoryComponent[] getPlatformFactoryComponents();
  
  public boolean hasPlatformFactoryComponent(IPlatformFactoryComponent factoryComponent);
  
  public void addPlatformFactoryComponent(IPluginExtension extension);  
  
  public IPlatformFactoryComponent addPlatformFactoryComponent(IPluginElement element);  
  
  public boolean removePlatformFactoryComponent(IPlatformFactoryComponent factoryComponent);
  
  public boolean isTarget();
      
  public String getLocation();  
  
}
