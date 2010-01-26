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

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

public final class SetInvocationInvokedActivityCommand extends CompoundCommand {

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
   * Current Invocation
   */
  private Invocation _invocation;

  /**
   * The new Activity
   */
  private Activity _activity;

  /**
   * Constructor.
   * 
   * @param editingDomain
   * @param invocation
   * @param activity
   */
  public SetInvocationInvokedActivityCommand(EditingDomain editingDomain, Invocation invocation, Activity activity) {
    super(LABEL, DESCRIPTION);
    _editingDomain = editingDomain;
    _invocation = invocation;
    _activity = activity;
  }

  /**
   * Constructor.
   * 
   * @param label
   * @param description
   * @param editingDomain
   * @param invocation
   * @param activity
   */
  public SetInvocationInvokedActivityCommand(String label, String description, EditingDomain editingDomain, Invocation invocation, Activity activity) {
    super(label, description);
    _editingDomain = editingDomain;
    _invocation = invocation;
    _activity = activity;
  }

  @Override
  protected boolean prepare() {
    // First reset inner reference if necessary
    if (_invocation.getInvocationContractContainer() != null) {
      for (InvocationContract contract : _invocation.getInvocationContractContainer().getInvocationContracts()) {
        if (contract.getFactoryComponentContract() != null) {
          append(new SetCommand(_editingDomain, contract, FcorePackage.Literals.INVOCATION_CONTRACT__FACTORY_COMPONENT_CONTRACT, null));
        }
        if (contract.getOrchestrationParameter() != null) {
          append(new SetCommand(_editingDomain, contract, FcorePackage.Literals.INVOCATION_CONTRACT__ORCHESTRATION_PARAMETER, null));
        }
        if (contract.getSourceInvocationContract() != null) {
          append(new SetCommand(_editingDomain, contract.getSourceInvocationContract(), FcorePackage.Literals.INVOCATION_CONTRACT__TARGET_INVOCATION_CONTRACT, null));
          append(new SetCommand(_editingDomain, contract, FcorePackage.Literals.INVOCATION_CONTRACT__SOURCE_INVOCATION_CONTRACT, null));
        }
        if (contract.getTargetInvocationContract() != null) {
          append(new SetCommand(_editingDomain, contract.getTargetInvocationContract(), FcorePackage.Literals.INVOCATION_CONTRACT__SOURCE_INVOCATION_CONTRACT, null));
          append(new SetCommand(_editingDomain, contract, FcorePackage.Literals.INVOCATION_CONTRACT__TARGET_INVOCATION_CONTRACT, null));
        }
      }
    }
    // Reset contract container
    append(new SetCommand(_editingDomain, _invocation, FcorePackage.Literals.INVOCATION__INVOCATION_CONTRACT_CONTAINER, null));
    // Assign new activity
    append(new SetCommand(_editingDomain, _invocation, FcorePackage.Literals.INVOCATION__INVOKED_ACTIVITY, _activity));
    return super.prepare();
  }

}
