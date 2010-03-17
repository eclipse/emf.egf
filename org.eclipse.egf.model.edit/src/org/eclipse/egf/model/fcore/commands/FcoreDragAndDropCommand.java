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
package org.eclipse.egf.model.fcore.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.command.DragAndDropCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FcoreDragAndDropCommand extends DragAndDropCommand {

  /**
   * This creates a command to perform a drag and drop operation upon the owner.
   * See {@link DragAndDropCommand DragAndDropCommand} for a description of the arguments.
   */
  public static Command create(EditingDomain domain, Object owner, float location, int operations, int operation, Collection<?> collection) {
    return domain.createCommand(FcoreDragAndDropCommand.class, new CommandParameter(owner, new Detail(location, operations, operation), collection));
  }

  public FcoreDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations, int operation, Collection<?> collection) {
    this(domain, owner, location, operations, operation, collection, domain == null ? false : domain.getOptimizeCopy());
  }

  public FcoreDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations, int operation, Collection<?> collection, boolean optimize) {
    super(domain, owner, location, operations, operation, collection);
  }

  /**
   * This attempts to prepare a drop move insert operation.
   */
  @Override
  protected boolean prepareDropMoveInsert(Object parent, Collection<?> children, int index) {
    // We don't want to move insert an object before or after itself...
    //
    if (collection.contains(owner)) {
      dragCommand = IdentityCommand.INSTANCE;
      dropCommand = UnexecutableCommand.INSTANCE;
    }
    // If the dragged objects share a parent...
    //
    else if (children.containsAll(collection)) {
      dragCommand = IdentityCommand.INSTANCE;

      // Create move commands for all the objects in the collection.
      //
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
    } else if (isCrossDomain()) {
      dragCommand = IdentityCommand.INSTANCE;
      dropCommand = UnexecutableCommand.INSTANCE;
    } else {
      // Just remove the objects and add them.
      //
      dropCommand = AddCommand.create(domain, parent, null, CopyCommand.create(domain, collection), index);
      if (analyzeForNonContainment(dropCommand)) {
        dropCommand.dispose();
        dropCommand = UnexecutableCommand.INSTANCE;
        dragCommand = IdentityCommand.INSTANCE;
      } else {
        dragCommand = IdentityCommand.INSTANCE;
      }
    }

    boolean result = dragCommand.canExecute() && dropCommand.canExecute();
    return result;
  }

  /**
   * This attempts to prepare a drop move on operation.
   */
  @Override
  protected boolean prepareDropMoveOn() {
    if (isCrossDomain()) {
      dragCommand = IdentityCommand.INSTANCE;
      dropCommand = UnexecutableCommand.INSTANCE;
    } else {
      dropCommand = AddCommand.create(domain, owner, null, CopyCommand.create(domain, collection));
      if (analyzeForNonContainment(dropCommand)) {
        dropCommand.dispose();
        dropCommand = UnexecutableCommand.INSTANCE;
        dragCommand = IdentityCommand.INSTANCE;
      } else {
        dragCommand = IdentityCommand.INSTANCE;
      }
    }

    boolean result = dragCommand.canExecute() && dropCommand.canExecute();
    return result;
  }
}
