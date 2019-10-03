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

package org.eclipse.egf.domain.file;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.eclipse.egf.domain.DomainException;
import org.eclipse.egf.domain.LoadableDomainHelper;
import org.eclipse.egf.domain.Messages;
import org.eclipse.egf.model.domain.FilesystemDomain;
import org.eclipse.egf.model.domain.LoadableDomain;

/**
 * @author Thomas Guiu
 * 
 */
public class FilesystemDomainHelper extends LoadableDomainHelper {

    protected boolean doLoadDomain(LoadableDomain domain) throws DomainException {
        if (domain instanceof FilesystemDomain) {
            FilesystemDomain myDomain = (FilesystemDomain) domain;
            myDomain.setLoaded(true);
            File file = new File(myDomain.getPath());
            if (!file.exists())
                throw new DomainException(Messages.bind(Messages.Load_FilesystemDomain_error1, myDomain.getPath()));
            if (!myDomain.getContent().isEmpty())
                throw new DomainException(Messages.bind(Messages.Load_Domain_error1, domain.eClass().getName(), domain.getName()));

            final List<File> children = Arrays.asList(file.listFiles());
            myDomain.getContent().addAll(children);
            return true;
        }
        return false;
    }

    protected boolean doUnLoadDomain(LoadableDomain domain) throws DomainException {
        if (domain instanceof FilesystemDomain) {
            FilesystemDomain myDomain = (FilesystemDomain) domain;
            myDomain.getContent().clear();
            myDomain.setLoaded(false);
            return true;
        }
        return false;
    }

}
