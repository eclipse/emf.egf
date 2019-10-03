/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.domain.emf;

import org.eclipse.egf.core.domain.EgfResourceSet;
import org.eclipse.egf.domain.Activator;
import org.eclipse.egf.domain.DomainException;
import org.eclipse.egf.domain.LoadableDomainHelper;
import org.eclipse.egf.domain.Messages;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.model.domain.LoadableDomain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Thomas Guiu
 * 
 */
public class EMFDomainHelper extends LoadableDomainHelper {

	protected boolean doLoadDomain(LoadableDomain domain) throws DomainException {
		if (domain instanceof EMFDomain) {
			EMFDomain myDomain = (EMFDomain) domain;
			myDomain.setLoaded(true);
			// ResourceSet set = new RuntimePlatformResourceSet();
			ResourceSet set = new EgfResourceSet();
			final URI uri = myDomain.getUri();
			if (uri == null || "".equals(uri.toString())) { //$NON-NLS-1$
				Activator.getDefault().logWarning(Messages.bind(Messages.Load_EMFDomain_error1, domain.getName()));
				return true;
			}
			Resource domainResource = null;
			try {
				domainResource = set.getResource(uri, true);
			} catch (Exception e) {
				throw new DomainException(Messages.bind(Messages.Load_EMFDomain_error2, uri.toString()), e);
			}

			if (!myDomain.getContent().isEmpty())
				throw new DomainException(Messages.bind(Messages.Load_Domain_error1, domain.eClass().getName(), domain.getName()));
			myDomain.getContent().addAll(domainResource.getContents());
			return true;
		}
		return false;
	}

	protected boolean doUnLoadDomain(LoadableDomain domain) throws DomainException {
		if (domain instanceof EMFDomain) {
			EMFDomain myDomain = (EMFDomain) domain;
			if (!myDomain.getContent().isEmpty()) {
				final Resource eResource = ((EObject) myDomain.getContent().get(0)).eResource();
				if (eResource != null)
					eResource.unload();
				myDomain.getContent().clear();
				myDomain.setLoaded(false);
			}
			return true;
		}
		return false;
	}

}
