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
package org.eclipse.egf.model.fcore.commands.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.command.DragAndDropCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FcoreDragAndDropCommand extends DragAndDropCommand {

    public FcoreDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations, int operation, Collection<?> collection) {
        this(domain, owner, location, operations, operation, collection, domain == null ? false : domain.getOptimizeCopy());
    }

    public FcoreDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations, int operation, Collection<?> collection, boolean optimize) {
        super(domain, owner, location, operations, operation, collection);
    }

    /**
     * This attempts to prepare a drop copy insert operation.
     */
    @Override
    protected boolean prepareDropCopyInsert(final Object parent, Collection<?> children, final int index) {
        boolean result;
        // Ignore
        if (collection == null || collection.isEmpty()) {
            dragCommand = IdentityCommand.INSTANCE;
            dropCommand = UnexecutableCommand.INSTANCE;
            result = false;
        }
        // We don't want to copy insert an object before or after itself...
        else if (collection.contains(owner)) {
            dragCommand = IdentityCommand.INSTANCE;
            dropCommand = UnexecutableCommand.INSTANCE;
            result = false;
        } else {
            // Copy the collection
            dragCommand = CopyCommand.create(domain, collection);
            if (optimize) {
                result = optimizedCanExecute();
                if (result) {
                    optimizedDropCommandOwner = parent;
                }
            } else {
                if (dragCommand.canExecute() && dragCommand.canUndo()) {
                    dragCommand.execute();
                    isDragCommandExecuted = true;
                    // And add the copy.
                    dropCommand = AddCommand.create(domain, parent, null, dragCommand.getResult(), index);
                    if (analyzeForNonContainment(dropCommand)) {
                        dropCommand.dispose();
                        dropCommand = UnexecutableCommand.INSTANCE;

                        dragCommand.undo();
                        dragCommand.dispose();
                        isDragCommandExecuted = false;
                        dragCommand = IdentityCommand.INSTANCE;
                    }
                    result = dropCommand.canExecute();
                } else {
                    dropCommand = UnexecutableCommand.INSTANCE;
                    result = false;
                }
            } // if optimize
        } // if collection
        return result;
    }

    /**
     * This attempts to prepare a drop copy on operation.
     */
    @Override
    protected boolean prepareDropCopyOn() {
        // Ignore
        if (collection == null || collection.isEmpty()) {
            dragCommand = IdentityCommand.INSTANCE;
            dropCommand = UnexecutableCommand.INSTANCE;
            return false;
        }
        boolean result;
        dragCommand = CopyCommand.create(domain, collection);
        if (optimize) {
            result = optimizedCanExecute();
            if (result) {
                optimizedDropCommandOwner = owner;
            }
        } else {
            if (dragCommand.canExecute() && dragCommand.canUndo()) {
                dragCommand.execute();
                isDragCommandExecuted = true;
                dropCommand = AddCommand.create(domain, owner, null, dragCommand.getResult());
                if (analyzeForNonContainment(dropCommand)) {
                    dropCommand.dispose();
                    dropCommand = UnexecutableCommand.INSTANCE;
                    dragCommand.undo();
                    dragCommand.dispose();
                    isDragCommandExecuted = false;
                    dragCommand = IdentityCommand.INSTANCE;
                }
            } else {
                dropCommand = UnexecutableCommand.INSTANCE;
            }
            result = dragCommand.canExecute() && dropCommand.canExecute();
        }
        return result;
    }

    /**
     * This attempts to prepare a drop move insert operation.
     */
    @Override
    protected boolean prepareDropMoveInsert(Object parent, Collection<?> children, int index) {
        // Ignore
        if (collection == null || collection.isEmpty()) {
            dragCommand = IdentityCommand.INSTANCE;
            dropCommand = UnexecutableCommand.INSTANCE;
        }
        // We don't want to move insert an object before or after itself...
        else if (collection.contains(owner)) {
            dragCommand = IdentityCommand.INSTANCE;
            dropCommand = UnexecutableCommand.INSTANCE;
        }
        // If the dragged objects share a parent...
        else if (children.containsAll(collection)) {
            dragCommand = IdentityCommand.INSTANCE;

            // Create move commands for all the objects in the collection.
            CompoundCommand compoundCommand = new CompoundCommand();
            List<Object> before = new ArrayList<Object>();
            List<Object> after = new ArrayList<Object>();

            int j = 0;
            for (Object object : children) {
                if (collection.contains(object)) {
                    if (j < index) {
                        before.add(object);
                    } else if (j > index) {
                        after.add(object);
                    }
                }
                ++j;
            }

            for (Object object : before) {
                compoundCommand.append(MoveCommand.create(domain, parent, null, object, index - 1));
            }

            for (ListIterator<Object> objects = after.listIterator(after.size()); objects.hasPrevious();) {
                Object object = objects.previous();
                compoundCommand.append(MoveCommand.create(domain, parent, null, object, index));
            }

            dropCommand = compoundCommand.getCommandList().size() == 0 ? (Command) IdentityCommand.INSTANCE : compoundCommand;
        }
        // CrossDomain        
        else if (isCrossDomain()) {
            dragCommand = IdentityCommand.INSTANCE;
            dropCommand = UnexecutableCommand.INSTANCE;
        } else {
            // Just remove the objects and add them.
            Resource resource = null;
            if (parent instanceof Resource) {
                resource = (Resource) parent;
            } else {
                resource = ((EObject) parent).eResource();
            }
            EObject firstEObject = (EObject) collection.iterator().next();
            if (firstEObject.eResource() == resource) {
                dropCommand = AddCommand.create(domain, parent, null, collection, index);
            } else {
                dropCommand = AddCommand.create(domain, parent, null, CopyCommand.create(domain, collection).getResult(), index);
            }
            if (analyzeForNonContainment(dropCommand)) {
                dropCommand.dispose();
                dropCommand = UnexecutableCommand.INSTANCE;
                dragCommand = IdentityCommand.INSTANCE;
            } else {
                if (firstEObject.eResource() == resource) {
                    dragCommand = RemoveCommand.create(domain, collection);
                } else {
                    dragCommand = IdentityCommand.INSTANCE;
                }
            }
        }
        // if (owner.eResource() == eObjectValue.eResource() && EcoreUtil.getRootContainer(owner) == EcoreUtil.getRootContainer(eObjectValue)) {
        return dragCommand.canExecute() && dropCommand.canExecute();
    }

    /**
     * This attempts to prepare a drop move on operation.
     */
    @Override
    protected boolean prepareDropMoveOn() {
        // Ignore
        if (collection == null || collection.isEmpty()) {
            dragCommand = IdentityCommand.INSTANCE;
            dropCommand = UnexecutableCommand.INSTANCE;
        }
        // CrossDomain
        else if (isCrossDomain()) {
            dragCommand = IdentityCommand.INSTANCE;
            dropCommand = UnexecutableCommand.INSTANCE;
        } else {
            Resource resource = null;
            if (owner instanceof Resource) {
                resource = (Resource) owner;
            } else {
                resource = ((EObject) owner).eResource();
            }
            EObject firstEObject = (EObject) collection.iterator().next();
            if (firstEObject.eResource() == resource) {
                dropCommand = AddCommand.create(domain, owner, null, collection);
            } else {
                dropCommand = AddCommand.create(domain, owner, null, CopyCommand.create(domain, collection).getResult());
            }
            if (analyzeForNonContainment(dropCommand)) {
                dropCommand.dispose();
                dropCommand = UnexecutableCommand.INSTANCE;
                dragCommand = IdentityCommand.INSTANCE;
            } else {
                if (firstEObject.eResource() == resource) {
                    dragCommand = RemoveCommand.create(domain, collection);
                } else {
                    dragCommand = IdentityCommand.INSTANCE;
                }
            }
        }
        return dragCommand.canExecute() && dropCommand.canExecute();
    }

}
