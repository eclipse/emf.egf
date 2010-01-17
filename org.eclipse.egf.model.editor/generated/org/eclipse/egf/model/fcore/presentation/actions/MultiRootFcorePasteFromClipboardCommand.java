/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 * Thales Corporate Services S.A.S
 */
package org.eclipse.egf.model.fcore.presentation.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.StrictCompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Multi-rooted resources support.
 * This works exactly like an {@link AddCommand} but the things to be added are copied from the
 * {@link EditingDomain} clipboard.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class MultiRootFcorePasteFromClipboardCommand extends PasteFromClipboardCommand {

  /**
   * This creates a command to add copies from the clipboard to the specified feature of the owner.
   */
  public static Command create(EditingDomain domain, Object owner, Object feature) {
    return create(domain, owner, feature, CommandParameter.NO_INDEX);
  }

  /**
   * This creates a command to add copies from the clipboard to the specified feature of the owner
   * and at the given index.
   */
  public static Command create(EditingDomain domain, Object owner, Object feature, int index) {
    return new MultiRootFcorePasteFromClipboardCommand(domain, owner, feature, index, true);
  }

  /**
   * Constructor
   * 
   * @param domain
   *          the editing domain
   * @param owner
   *          the owner
   * @param feature
   *          the feature
   * @param index
   *          the index
   * 
   *          This constructs an instance from the domain, which provides access the clipboard
   *          collection
   *          via {@link EditingDomain#getCommandStack}.
   *          <!-- begin-user-doc -->
   *          <!-- end-user-doc -->
   * @generated
   */
  public MultiRootFcorePasteFromClipboardCommand(EditingDomain domain, Object owner, Object feature, int index) {
    super(domain, owner, feature, index, true);
  }

  /**
   * Constructor
   * 
   * @param domain
   *          the editing domain
   * @param owner
   *          the owner
   * @param feature
   *          the feature
   * @param index
   *          the index
   * @param optimize
   *          optimize
   * 
   *          This constructs an instance from the domain, which provides access the clipboard
   *          collection
   *          via {@link EditingDomain#getCommandStack}.
   *          <!-- begin-user-doc -->
   *          <!-- end-user-doc -->
   * @generated
   */
  public MultiRootFcorePasteFromClipboardCommand(EditingDomain domain, Object owner, Object feature, int index, boolean optimize) {
    super(domain, owner, feature, index, optimize);
  }

  /**
   * @see org.eclipse.emf.common.command.AbstractCommand#prepare()
   *      <!-- begin-user-doc -->
   *      <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean prepare() {

    // Create a strict compound command to do a copy and then add the result
    //
    command = new StrictCompoundCommand();
    // Create a command to copy the clipboard.
    //
    final Command copyCommand = CopyCommand.create(domain, domain.getClipboard());
    command.append(copyCommand);
    // Create a proxy that will create an add command.
    //
    command.append(

    new CommandWrapper() {

      @Override
      protected Command createCommand() {

        List<Object> otherList = new ArrayList<Object>();
        List<EObject> rootList = new ArrayList<EObject>();
        CompoundCommand addCommand = new CompoundCommand(CompoundCommand.MERGE_COMMAND_ALL);
        // Process Current Clipboard
        // 
        Iterator<?> iter = copyCommand.getResult().iterator();
        while (iter.hasNext()) {
          Object next = iter.next();
          if (next instanceof EObject == false) {
            otherList.add(next);
            continue;
          }
          EObject eObject = (EObject) next;
          // Library is a defined Root Object
          //
          if (owner instanceof Resource) {
            if (eObject instanceof FactoryComponent || eObject instanceof Task) {
              rootList.add(eObject);
              continue;
            }
          }
          // Default
          //
          otherList.add(eObject);
        }
        // Build Root List Commands
        //
        if (rootList.isEmpty() == false) {
          for (EObject eObject : rootList) {
            addCommand.append(new MultiRootAddCommand(domain, ((Resource) owner).getContents(), eObject, index));
          }
        }
        // Build Other List Commands
        //		
        if (otherList.isEmpty() == false) {
          addCommand.append(AddCommand.create(domain, owner, feature, otherList, index));
        }
        // return CompoundCommand
        //
        return addCommand;

      }

    }

    );

    boolean result;
    if (optimize) {
      // This will determine canExecute as efficiently as possible.
      //
      result = optimizedCanExecute();
    } else {
      // This will actually execute the copy command in order to check if the add can execute.
      //
      result = command.canExecute();
    }

    return result;

  }

  /**
   * We'll assume that the copy command can execute and that adding a copy of the clipboard
   * is the same test as adding the clipboard contents itself.
   * 
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected boolean optimizedCanExecute() {
    if (domain.getClipboard() == null) {
      return false;
    }
    List<Object> otherList = new ArrayList<Object>();
    List<EObject> rootList = new ArrayList<EObject>();
    CompoundCommand addCommand = new CompoundCommand(CompoundCommand.MERGE_COMMAND_ALL);
    // Process Current Clipboard
    // 
    Iterator<?> iter = domain.getClipboard().iterator();
    while (iter.hasNext()) {
      Object next = iter.next();
      if (next instanceof EObject == false) {
        otherList.add(next);
        continue;
      }
      EObject eObject = (EObject) next;
      // Library is a defined Root Object
      //
      if (owner instanceof Resource) {
        if (eObject instanceof FactoryComponent || eObject instanceof Task) {
          rootList.add(eObject);
          continue;
        }
      }
      // Default
      //
      otherList.add(eObject);
    }
    // Process Root List
    //
    if (rootList.isEmpty() == false) {
      for (EObject eObject : rootList) {
        addCommand.append(new MultiRootAddCommand(domain, ((Resource) owner).getContents(), eObject, index));
      }
    }
    // Process Other List
    //
    if (otherList.isEmpty() == false) {
      addCommand.append(AddCommand.create(domain, owner, feature, otherList, index));
    }
    // Check CompoundCommand
    //
    boolean result = addCommand.canExecute();
    addCommand.dispose();
    return result;
  }

}
