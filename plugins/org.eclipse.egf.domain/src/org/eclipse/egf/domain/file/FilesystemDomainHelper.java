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

package org.eclipse.egf.domain.file;

import org.eclipse.egf.domain.DomainException;
import org.eclipse.egf.domain.DomainHelper;
import org.eclipse.egf.domain.Messages;
import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.FilesystemDomain;

/**
 * @author Thomas Guiu
 * 
 */
public class FilesystemDomainHelper implements DomainHelper {

    public boolean loadDomain(Domain domain) throws DomainException {
        if (domain instanceof FilesystemDomain) {
            FilesystemDomain myDomain = (FilesystemDomain) domain;
            if (myDomain.isLoaded())
                throw new DomainException(Messages.bind(Messages.Load_Domain_error1, domain.eClass().getName(), domain.getName()));
            myDomain.setLoaded(true);

            // TODO
            if (!myDomain.getContent().isEmpty())
                throw new DomainException(Messages.bind(Messages.Load_Domain_error1, domain.eClass().getName(), domain.getName()));
            return true;
        }
        return false;
    }

    public boolean unLoadDomain(Domain domain) throws DomainException {
        if (domain instanceof FilesystemDomain) {
            FilesystemDomain myDomain = (FilesystemDomain) domain;
            // TODO
            return true;
        }
        return false;
    }

}
