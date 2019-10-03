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
package org.eclipse.egf.core.workspace;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Concrete synchronization request for new persisted resource.
 * 
 * @author Xavier Maysonnave
 */
class EGFPersistedSynchRequest extends EGFSynchRequest {

    /**
     * Initializes me with the synchronizer on whose behalf I perform a
     * synchronization and the resource whose workspace partner is created.
     * 
     * @param synch
     *            the workspace synchronizer
     * @param resource
     *            the resource that has been deleted
     */
    EGFPersistedSynchRequest(EGFWorkspaceSynchronizer synch, Resource resource) {
        super(synch, resource);
    }

    @Override
    protected void doPerform() {
        if (!synch.getDelegate().handleResourcePersisted(resource)) {
            // note that if our delegate is the default, it
            // will always return true
            EGFWorkspaceSynchronizer.defaultDelegate.handleResourcePersisted(resource);
        }
    }

}
