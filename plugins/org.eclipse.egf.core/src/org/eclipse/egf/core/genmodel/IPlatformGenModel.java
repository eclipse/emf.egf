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

import org.eclipse.egf.core.epackage.EPackageWrapper;
import org.eclipse.egf.core.epackage.ERootWrapper;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointURI;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;

public interface IPlatformGenModel extends IPlatformExtensionPointURI {

    public URI getNsURI();

    public String getGeneratedPackage();

    public String getGenModel();

    public URI getGenModelURI();

    public String getBasePackage();

    public EPackage getEPackage();

    public EPackageWrapper getEPackageWrapper();

    public ERootWrapper getERootWrapper();

    public URI getEPackageNsURI(URI uri);

}
