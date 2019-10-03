/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.core.domain;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.egf.core.workspace.EGFWorkspaceSynchronizer;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.emf.workspace.impl.WorkspaceCommandStackImpl;

/**
 * @author Thomas Guiu
 * 
 */
public class EgfEditingDomainFactory extends WorkspaceEditingDomainFactory {

    @Override
    public TransactionalEditingDomain createEditingDomain() {
        TransactionalEditingDomain result = super.createEditingDomain();
        configure(result);
        return result;
    }

    @Override
    public TransactionalEditingDomain createEditingDomain(ResourceSet rset) {
        TransactionalEditingDomain result = super.createEditingDomain(rset);
        configure(result);
        return result;
    }

    /**
     * Creates a new editing domain on a default resource set implementation and
     * the specified operation history.
     * 
     * @param history
     *            the operation history to which I delegate the command stack
     * 
     * @return the new editing domain
     */
    @Override
    public synchronized TransactionalEditingDomain createEditingDomain(IOperationHistory history) {
        WorkspaceCommandStackImpl stack = new WorkspaceCommandStackImpl(history);
        stack.setResourceUndoContextPolicy(getResourceUndoContextPolicy());
        TransactionalEditingDomain result = new EgfEditingDomain(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE), stack);
        mapResourceSet(result);
        return result;
    }

    /**
     * Creates a new editing domain on the given resource set and
     * the specified operation history.
     * 
     * @param rset
     *            the resource set to use
     * @param history
     *            the operation history to which I delegate the command stack
     * 
     * @return the new editing domain
     */
    @Override
    public synchronized TransactionalEditingDomain createEditingDomain(ResourceSet rset, IOperationHistory history) {
        WorkspaceCommandStackImpl stack = new WorkspaceCommandStackImpl(history);
        stack.setResourceUndoContextPolicy(getResourceUndoContextPolicy());
        TransactionalEditingDomain result = new EgfEditingDomain(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE), stack, rset);
        mapResourceSet(result);
        return result;
    }

    /**
     * Configures the specified editing domain for correct functioning in the EGF environment.
     * 
     * @param domain
     *            the new editing domain
     */
    protected void configure(final TransactionalEditingDomain domain) {
        // the listener depends on UI to ask the user to solve conflict
        new EGFWorkspaceSynchronizer(domain, PlatformResourceLoadedListener.getResourceLoadedListener());
        // configure domain management
        configureResourceModificationManagement(domain);
    }

    /**
     * Configures <code>domain</code> so that the modified state
     * of resources in the <code>domain</code> is managed as operations are
     * executed, undone and redone on the operation history.
     * 
     * @param domain
     *            the editing domain to be configured
     */
    protected void configureResourceModificationManagement(TransactionalEditingDomain domain) {
        ResourceModificationManager.manage(domain);
    }

}
