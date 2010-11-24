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

import java.util.Arrays;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.domain.Activator;
import org.eclipse.egf.domain.DomainException;
import org.eclipse.egf.domain.DomainHelper;
import org.eclipse.egf.domain.Messages;
import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.WorkspaceDomain;

/**
 * @author Thomas Guiu
 * 
 */
public class WorkspaceDomainHelper implements DomainHelper {

    public boolean loadDomain(Domain domain) throws DomainException {
        if (domain instanceof WorkspaceDomain) {
            WorkspaceDomain myDomain = (WorkspaceDomain) domain;
            final String path = myDomain.getPath();
            if (path == null || "".equals(path)) {
                Activator.getDefault().logWarning(Messages.bind(Messages.Load_WorkspaceDomain_error1, domain.getName()));
                return true;
            }

            if (!myDomain.getContent().isEmpty())
                throw new DomainException(Messages.bind(Messages.Load_Domain_error1, domain.eClass().getName(), domain.getName()));
            if (".".equals(path)) {
                myDomain.getContent().addAll(Arrays.asList(ResourcesPlugin.getWorkspace().getRoot().getProjects()));
                return true;
            }
            final Path path2 = new Path(path);
            final int segmentCount = path2.segmentCount();
            try {
                if (segmentCount == 1) {
                    final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(path);
                    myDomain.getContent().addAll(Arrays.asList(project.members()));
                    return true;
                }
                IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(path2);
                myDomain.getContent().addAll(Arrays.asList(folder.members()));
            } catch (CoreException e) {
                throw new DomainException(Messages.Load_WorkspaceDomain_error2, e);
            }
            return true;
        }
        return false;
    }

    public boolean unLoadDomain(Domain domain) throws DomainException {
        if (domain instanceof WorkspaceDomain) {
            WorkspaceDomain myDomain = (WorkspaceDomain) domain;
            myDomain.getContent().clear();
            return true;
        }
        return false;
    }

}
