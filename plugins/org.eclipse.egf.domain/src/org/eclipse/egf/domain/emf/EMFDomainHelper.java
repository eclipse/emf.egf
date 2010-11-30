/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.domain.emf;

import org.eclipse.egf.core.domain.RuntimePlatformResourceSet;
import org.eclipse.egf.domain.Activator;
import org.eclipse.egf.domain.DomainException;
import org.eclipse.egf.domain.DomainHelper;
import org.eclipse.egf.domain.Messages;
import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Thomas Guiu
 * 
 */
public class EMFDomainHelper implements DomainHelper {

    public boolean loadDomain(Domain domain) throws DomainException {
        if (domain instanceof EMFDomain) {
            EMFDomain myDomain = (EMFDomain) domain;
            ResourceSet set = new RuntimePlatformResourceSet();
            final URI uri = myDomain.getUri();
            if (uri == null || "".equals(uri.toString())) { //$NON-NLS-1$
                Activator.getDefault().logWarning(Messages.bind(Messages.Load_EMFDomain_error1, domain.getName()));
                return true;
            }
            // throw new
            // DomainException(Messages.bind(Messages.Load_EMFDomain_error1,
            // domain.getName()));
            Resource domainResource = null;
            try {
                domainResource = set.getResource(uri, true);
            } catch (Exception e) {
                throw new DomainException(e);
            }

            if (!myDomain.getContent().isEmpty())
                throw new DomainException(Messages.bind(Messages.Load_Domain_error1, domain.eClass().getName(), domain.getName()));
            myDomain.getContent().addAll(domainResource.getContents());
            return true;
        }
        return false;
    }

    public boolean unLoadDomain(Domain domain) throws DomainException {
        if (domain instanceof EMFDomain) {
            EMFDomain myDomain = (EMFDomain) domain;
            if (!myDomain.getContent().isEmpty()) {
                final Resource eResource = ((EObject) myDomain.getContent().get(0)).eResource();
                if (eResource != null)
                    eResource.unload();
                myDomain.getContent().clear();
            }
            return true;
        }
        return false;
    }

}
