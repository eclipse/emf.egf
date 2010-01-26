/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.fcore.commands;

import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

public final class SetInvocationContractTargetInvocationContractCommand extends CompoundCommand {

  /**
   * This caches the label.
   */
  protected static final String LABEL = EMFEditPlugin.INSTANCE.getString("_UI_SetCommand_label"); //$NON-NLS-1$

  /**
   * This caches the description.
   */
  protected static final String DESCRIPTION = EMFEditPlugin.INSTANCE.getString("_UI_SetCommand_description"); //$NON-NLS-1$  

  /**
   * Current Editing Domain.
   */
  private EditingDomain _editingDomain;

  /**
   * Current InvocationContract
   */
  private InvocationContract _invocationContract;

  /**
   * The new TargetInvocationContract.
   */
  private InvocationContract _targetInvocationContract;

  /**
   * Constructor.
   * 
   * @param editingDomain
   * @param invocationContract
   * @param targetInvocationContract
   */
  public SetInvocationContractTargetInvocationContractCommand(EditingDomain editingDomain, InvocationContract invocationContract, InvocationContract targetInvocationContract) {
    super(LABEL, DESCRIPTION);
    _editingDomain = editingDomain;
    _invocationContract = invocationContract;
    _targetInvocationContract = targetInvocationContract;
  }

  /**
   * Constructor.
   * 
   * @param label
   * @param description
   * @param editingDomain
   * @param invocationContract
   * @param targetInvocationContract
   */
  public SetInvocationContractTargetInvocationContractCommand(String label, String description, EditingDomain editingDomain, InvocationContract invocationContract, InvocationContract targetInvocationContract) {
    super(label, description);
    _editingDomain = editingDomain;
    _invocationContract = invocationContract;
    _targetInvocationContract = targetInvocationContract;
  }

  @Override
  protected boolean prepare() {
    prepareCommand();
    return super.prepare();
  }

  protected void prepareCommand() {
    // Reset previous target
    if (_invocationContract.getTargetInvocationContract() != null) {
      append(new SetCommand(_editingDomain, _invocationContract.getTargetInvocationContract(), FcorePackage.Literals.INVOCATION_CONTRACT__SOURCE_INVOCATION_CONTRACT, null));
    }
    // Assign new target
    if (_targetInvocationContract != null) {
      append(new SetCommand(_editingDomain, _targetInvocationContract, FcorePackage.Literals.INVOCATION_CONTRACT__SOURCE_INVOCATION_CONTRACT, _invocationContract));
    }
    // Assign TargetInvocationContract
    append(new SetCommand(_editingDomain, _invocationContract, FcorePackage.Literals.INVOCATION_CONTRACT__TARGET_INVOCATION_CONTRACT, _targetInvocationContract));
  }

}
