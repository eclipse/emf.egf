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
package org.eclipse.egf.core.genmodel;

import java.util.Map;

import org.eclipse.egf.common.loader.IClassLoader;
import org.eclipse.egf.core.epackage.IProxyEPackage;
import org.eclipse.egf.core.epackage.IProxyERoot;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointURI;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.pde.core.plugin.IPluginModelBase;

public interface IPlatformGenModel extends IPlatformExtensionPointURI {

    public URI getNsURI();

    public String getGeneratedPackage();

    public String getGenModel();

    public URI getGenModelURI();

    public String getBasePackage();

    public EPackage getEPackage();

    public IProxyEPackage getIProxyEPackage();

    public IProxyEPackage getIProxyEPackage(Map<IPluginModelBase, IClassLoader> loaders);

    public IProxyERoot getIProxyERoot();

    public IProxyERoot getIProxyERoot(Map<IPluginModelBase, IClassLoader> loaders);

    public URI getEPackageNsURI(URI uri);

    public URI getEPackageNsURI(URI uri, Map<IPluginModelBase, IClassLoader> loaders);

}
