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
package org.eclipse.egf.core.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CutToClipboardCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.impl.TransactionalCommandStackImpl;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EgfEditingDomain extends TransactionalEditingDomainImpl {

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
	public EgfEditingDomain(AdapterFactory adapterFactory, TransactionalCommandStack stack, ResourceSet resourceSet) {
		super(adapterFactory, stack, resourceSet);
		getResourceSet().setURIConverter(EGFPlatformPlugin.getPlatformURIConverter());
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
	public EgfEditingDomain(AdapterFactory adapterFactory, TransactionalCommandStack stack) {
		super(adapterFactory, stack, new EgfEditingDomainAdapterFactory());
		((EgfEditingDomainAdapterFactory) getResourceSet()).setEditingDomain(this);
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
	public EgfEditingDomain(AdapterFactory adapterFactory, ResourceSet resourceSet) {
		super(adapterFactory, new TransactionalCommandStackImpl(), resourceSet);
		getResourceSet().setURIConverter(EGFPlatformPlugin.getPlatformURIConverter());
	}

	/**
	 * Initializes me with my adapter factory and default implementations of
	 * a resource set and a command stack.
	 * 
	 * @param adapterFactory
	 *            my adapter factory
	 */
	public EgfEditingDomain(AdapterFactory adapterFactory) {
		super(adapterFactory, new TransactionalCommandStackImpl(), new EgfEditingDomainAdapterFactory());
		((EgfEditingDomainAdapterFactory) getResourceSet()).setEditingDomain(this);
	}

	@Override
	public Command createCommand(Class<? extends Command> commandClass, CommandParameter commandParameter) {
		if (commandClass == CutToClipboardCommand.class) {
			// DeleteCommand clean href while the default RemoveCommand don't (this avoid dangling href)
			return new CutToClipboardCommand(this, DeleteCommand.create(this, commandParameter.getCollection()));
		} else if (commandParameter.getOwner() == null && commandClass == RemoveCommand.class) {
			// For RemoveCommand, we will find the owner by calling EditingDomain.getParent() on the object(s) being removed.
			CompoundCommand removeCommand = new CompoundCommand(CompoundCommand.MERGE_COMMAND_ALL);
			List<Object> objects = new ArrayList<Object>(commandParameter.getCollection());
			while (objects.isEmpty() == false) {
				// We will iterate over the whole collection, removing some as we go.
				ListIterator<Object> remainingObjects = objects.listIterator();
				// Take the first object, and remove it.
				Object object = remainingObjects.next();
				remainingObjects.remove();
				// Determine the object's parent.
				Object parent = getParent(object);
				if (parent != null) {
					// Now we want to find all the other objects with this same parent.
					// So we can collection siblings together and give the parent control over their removal.
					List<Object> siblings = new ArrayList<Object>();
					siblings.add(object);
					// Process
					while (remainingObjects.hasNext()) {
						// Get the next object and check if it has the same parent.
						Object otherObject = remainingObjects.next();
						Object otherParent = getParent(otherObject);
						if (otherParent == parent) {
							// Remove the object and add it as a sibling.
							remainingObjects.remove();
							siblings.add(otherObject);
						}
					}
					// We will now create a command with this implied parent
					Command newRemoveCommand = createCommand(RemoveCommand.class, new CommandParameter(parent, null, siblings));
					// As we cascade commands, some duplicate commands could arise
					if (hasCommand(removeCommand, newRemoveCommand) == false) {
						removeCommand.append(newRemoveCommand);
					}
				} else if (object != null) {
					// The parent is null, which implies a top-level removal, so create a self-removing command.
					removeCommand.append(createCommand(RemoveCommand.class, new CommandParameter(object, null, Collections.singleton(object))));
				}
			}
			return removeCommand.unwrap();
		}
		return super.createCommand(commandClass, commandParameter);
	}

	private boolean hasCommand(Command command, Command newCommand) {
		if (command instanceof CompoundCommand) {
			CompoundCommand compoundCommand = (CompoundCommand) command;
			for (Command innerCommand : compoundCommand.getCommandList()) {
				if (hasCommand(innerCommand, newCommand)) {
					return true;
				}
			}
		}
		if (newCommand instanceof CompoundCommand) {
			CompoundCommand compoundCommand = (CompoundCommand) newCommand;
			for (Command innerCommand : compoundCommand.getCommandList()) {
				if (hasCommand(command, innerCommand)) {
					return true;
				}
			}
		}
		// Check whether or not we face the same command
		if (command instanceof RemoveCommand && command.getClass() == newCommand.getClass()) {
			RemoveCommand removeCommand = (RemoveCommand) command;
			RemoveCommand newRemoveCommand = (RemoveCommand) newCommand;
			if (removeCommand.getCollection().equals(newRemoveCommand.getCollection())) {
				return true;
			}
		}
		return false;
	}
}
