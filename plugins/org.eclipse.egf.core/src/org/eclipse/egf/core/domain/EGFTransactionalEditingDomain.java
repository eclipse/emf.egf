/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.domain;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CutToClipboardCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.impl.TransactionalCommandStackImpl;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFTransactionalEditingDomain extends TransactionalEditingDomainImpl {

    /**
     * Initializes me with my adapter factory, command stack, and resource set.
     * 
     * @param adapterFactory
     *            my adapter factory
     * @param stack
     *            my command stack
     * @param resourceSet
     *            my resource set
     */
    public EGFTransactionalEditingDomain(AdapterFactory adapterFactory, TransactionalCommandStack stack, ResourceSet resourceSet) {
        super(adapterFactory, stack, resourceSet);
        getResourceSet().setURIConverter(EGFCorePlugin.getPlatformURIConverter());
    }

    /**
     * Initializes me with my adapter factory and a command stack, and a
     * default resource set implementation.
     * 
     * @param adapterFactory
     *            my adapter factory
     * @param stack
     *            my command stack
     */
    public EGFTransactionalEditingDomain(AdapterFactory adapterFactory, TransactionalCommandStack stack) {
        super(adapterFactory, stack, new EGFAdapterFactoryEditingDomainResourceSet());
        ((EGFAdapterFactoryEditingDomainResourceSet) getResourceSet()).setEditingDomain(this);
    }

    /**
     * Initializes me with my adapter factory and a resource set, and a default
     * command stack implementation.
     * 
     * @param adapterFactory
     *            my adapter factory
     * @param resourceSet
     *            my resource set
     */
    public EGFTransactionalEditingDomain(AdapterFactory adapterFactory, ResourceSet resourceSet) {
        super(adapterFactory, new TransactionalCommandStackImpl(), resourceSet);
        getResourceSet().setURIConverter(EGFCorePlugin.getPlatformURIConverter());
    }

    /**
     * Initializes me with my adapter factory and default implementations of
     * a resource set and a command stack.
     * 
     * @param adapterFactory
     *            my adapter factory
     */
    public EGFTransactionalEditingDomain(AdapterFactory adapterFactory) {
        super(adapterFactory, new TransactionalCommandStackImpl(), new EGFAdapterFactoryEditingDomainResourceSet());
        ((EGFAdapterFactoryEditingDomainResourceSet) getResourceSet()).setEditingDomain(this);
    }

    @Override
    public Command createCommand(Class<? extends Command> commandClass, CommandParameter commandParameter) {
        if (commandClass == CutToClipboardCommand.class) {
            // DeleteCommand clean href while the default RemoveCommand don't (this avoid dangling href)
            return new CutToClipboardCommand(this, DeleteCommand.create(this, commandParameter.getCollection()));
        }
        return super.createCommand(commandClass, commandParameter);
    }
}
