/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.domain.helper;

import java.util.Collection;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.domain.EgfResourceSet;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TypeGenPackageHelper {

	private TypeGenPackageHelper() {
		// Prevent Instantiation
	}

	public static Collection<GenPackage> getAvailableGenPackage(EObject eObject) {
		Collection<GenPackage> result = new UniqueEList<GenPackage>();
		ResourceSet resourceSet = new EgfResourceSet();
		if (eObject != null) {
			// Load available GenPackage
			for (URI uri : new UniqueEList<URI>(EGFCorePlugin.getTargetPlatformGenModelLocationMap().values())) {
				Resource resource = resourceSet.getResource(uri, true);
				if (resource != null) {
					EcoreUtil.resolveAll(resource);
				}
			}
			// Locate GenPackages
			for (Resource resource : resourceSet.getResources()) {
				result.addAll(EMFHelper.getAllGenPackages(resource));
			}
		}
		return result;
	}

}
