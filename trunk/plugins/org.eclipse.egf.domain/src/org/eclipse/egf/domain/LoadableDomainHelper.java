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

package org.eclipse.egf.domain;

import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.LoadableDomain;
import org.eclipse.osgi.util.NLS;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class LoadableDomainHelper implements IDomainHelper {

    protected abstract boolean doLoadDomain(LoadableDomain domain) throws DomainException;

    protected abstract boolean doUnLoadDomain(LoadableDomain domain) throws DomainException;

    public boolean loadDomain(Domain domain) throws DomainException {
        if (domain instanceof LoadableDomain) {
            final LoadableDomain lDomain = (LoadableDomain) domain;
            if (lDomain.isLoaded())
                throw new DomainException(Messages.bind(Messages.Load_Domain_error1, domain.eClass().getName(), domain.getName()));
            else
                return doLoadDomain(lDomain);
        }
        return true;
    }

    public boolean unLoadDomain(Domain domain) throws DomainException {
        if (domain instanceof LoadableDomain) {
            final LoadableDomain lDomain = (LoadableDomain) domain;
            if (!lDomain.isLoaded())
                Activator.getDefault().logWarning(NLS.bind(Messages.unload_error1, domain.getName()));
            else
                return doUnLoadDomain(lDomain);
        }
        return true;
    }

}
