/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.editor.commands;

import org.eclipse.egf.model.editor.l10n.ModelEditorMessages;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.InvocationContractContainer;
import org.eclipse.egf.model.fprod.FprodFactory;
import org.eclipse.egf.model.fprod.FprodPackage;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

public final class InvokeActivityCommand extends CompoundCommand {

  /**
   * This caches the label.
   */
  protected static final String LABEL = ModelEditorMessages._UI_InvokeCommand_label;

  /**
   * This caches the description.
   */
  protected static final String DESCRIPTION = ModelEditorMessages._UI_InvokeCommand_description;

  /**
   * Current Editing Domain.
   */
  private EditingDomain _editingDomain;

  /**
   * Current ProductionPlan
   */
  private ProductionPlan _productionPlan;

  /**
   * The new Activity
   */
  private Activity _activity;

  /**
   * Constructor.
   * 
   * @param editingDomain
   * @param productionPlan
   * @param activity
   */
  public InvokeActivityCommand(EditingDomain editingDomain, ProductionPlan productionPlan, Activity activity) {
    this(LABEL, DESCRIPTION, editingDomain, productionPlan, activity);
  }

  /**
   * Constructor.
   * 
   * @param label
   * @param description
   * @param editingDomain
   * @param productionPlan
   * @param activity
   */
  public InvokeActivityCommand(String label, String description, EditingDomain editingDomain, ProductionPlan productionPlan, Activity activity) {
    super(label, description);
    _editingDomain = editingDomain;
    _productionPlan = productionPlan;
    _activity = activity;
  }

  @Override
  protected boolean prepare() {
    // Usual tests
    if (_productionPlan == null || _productionPlan.getInvocations() == null || _activity == null) {
      return false;
    }
    // Create an AddCommand to create a ProductionPlanInvocation to our ProductionPlan
    ProductionPlanInvocation invocation = FprodFactory.eINSTANCE.createProductionPlanInvocation();
    invocation.setInvokedActivity(_activity);
    // Populate this ProductionPlanInvocation with the activity contracts
    if (_activity.getContracts() != null && _activity.getContracts().size() > 0) {
      // Create an InvocationContractContainer
      InvocationContractContainer container = FcoreFactory.eINSTANCE.createInvocationContractContainer();
      invocation.setInvocationContractContainer(container);
      for (Contract contract : _activity.getContracts()) {
        InvocationContract innerContract = FcoreFactory.eINSTANCE.createInvocationContract();
        innerContract.setInvokedContract(contract);
        container.getInvocationContracts().add(innerContract);
      }
    }
    // Finally add invocation in productionPlan
    append(new AddCommand(_editingDomain, _productionPlan, FprodPackage.Literals.PRODUCTION_PLAN__INVOCATIONS, invocation));
    return super.prepare();
  }

}
