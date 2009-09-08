/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.ui.workbench.internal.drop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.ProductionPlan;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.IProductionPlanExtensionFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.CommonDropAdapterAssistant;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;


/**
 * Drop assistant for factory component invocation.<br>
 * Handles moving factory component invocations within the production plan.<br>
 * @author Guillaume Brocard
 */
public class FactoryComponentInvocationDropAdapterAssistant extends CommonDropAdapterAssistant {

  /**
   * @see org.eclipse.ui.navigator.CommonDropAdapterAssistant#handleDrop(org.eclipse.ui.navigator.CommonDropAdapter, org.eclipse.swt.dnd.DropTargetEvent,
   *      java.lang.Object)
   */
  @Override
  public IStatus handleDrop(CommonDropAdapter dropAdapter_p, DropTargetEvent dropTargetEvent_p, Object target_p) {
    IStatus result = Status.CANCEL_STATUS;
    // Get selected moving factory component invocations.
    List<FactoryComponentInvocation> movingFcInvocations = handleSelection();
    // Get the factory component invocation where the selected factory component invocations should be dropped.
    Object data = dropTargetEvent_p.item.getData();
    if (data instanceof FactoryComponentInvocation) {
      FactoryComponentInvocation fcInvocationAtDropLocation = (FactoryComponentInvocation) data;
      FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer(fcInvocationAtDropLocation);
      ProductionPlan productionPlan = ModelHelper.getProductionPlan(fcContainer);
      // Clone the model list, this one will be used to compute the new order later.
      List<FactoryComponentInvocation> allFcInvocations = new ArrayList<FactoryComponentInvocation>(productionPlan.getFactoryComponentInvocations());
      // FactoryComponent configuration at drop location must not be in moving ones.
      if (!movingFcInvocations.contains(fcInvocationAtDropLocation)) {
        computeNewFcInvocationOrder(movingFcInvocations, dropTargetEvent_p.feedback, fcInvocationAtDropLocation, allFcInvocations);
        // Move factory component invocations.
        moveFcInvocations(productionPlan, allFcInvocations, fcContainer);
        result = Status.OK_STATUS;
      }
    }
    return result;
  }

  /**
   * @param allFcInvocations_p
   * @param feedback_p
   * @param fcInvocationAtDropLocation_p
   */
  private void computeNewFcInvocationOrder(List<FactoryComponentInvocation> movingFcInvocations_p, int feedback_p,
      FactoryComponentInvocation fcInvocationAtDropLocation_p, List<FactoryComponentInvocation> allFcInvocations_p) {
    // Remove all moving factory component invocations first.
    allFcInvocations_p.removeAll(movingFcInvocations_p);
    // Get the position of the factory component at drop position.
    int acAtDropPosition = allFcInvocations_p.indexOf(fcInvocationAtDropLocation_p);
    int newPosition = -1;
    if (feedback_p == DND.FEEDBACK_INSERT_AFTER) {
      newPosition = acAtDropPosition + 1;
    } else if (feedback_p == DND.FEEDBACK_INSERT_BEFORE) {
      if (acAtDropPosition == 0) {
        newPosition = 0;
      } else {
        newPosition = acAtDropPosition;
      }
    }
    allFcInvocations_p.addAll(newPosition, movingFcInvocations_p);
  }

  /**
   * @param productionPlan_p
   * @param allfcInvocations_p
   * @param fcContainer_p
   */
  private void moveFcInvocations(ProductionPlan productionPlan_p, List<FactoryComponentInvocation> allfcInvocations_p, FactoryComponent fcContainer_p) {
    EgfPdeActivator egfPdeActivator = EgfPdeActivator.getDefault();
    IProductionPlanExtensionFactory productionPlanExtensionFactory = egfPdeActivator.getProductionPlanExtensionHelper();
    String productionPlanId = productionPlan_p.getId();
    // Loop over the all factory component invocations to update the production plan extension in plug-in file.
    List<IPluginChangesCommand> unsetCommands = new ArrayList<IPluginChangesCommand>(1);
    List<IPluginChangesCommand> setCommands = new ArrayList<IPluginChangesCommand>(1);
    for (FactoryComponentInvocation fcInvocation : allfcInvocations_p) {
      // Unset the factory component invocation from its previous location.
      unsetCommands.add(productionPlanExtensionFactory.unsetFactoryComponentInvocation(productionPlanId, fcInvocation.getId()));
      // Set it again at the new location.
      setCommands.add(productionPlanExtensionFactory.setFactoryComponentInvocation(productionPlanId, fcInvocation.getId()));
    }
    // Get the bundle id.
    String pluginId = egfPdeActivator.getPluginIdForFactoryComponent(fcContainer_p.getId());
    // Build the command list with all unset commands + all set commands.
    List<IPluginChangesCommand> commands = new ArrayList<IPluginChangesCommand>(unsetCommands);
    commands.addAll(setCommands);
    // Perform the changes.
    egfPdeActivator.getPluginChangesCommandRunner().performChangesOnPlugin(pluginId, commands);
    // Set the new factory component invocation order as the new list of the production plan.
    productionPlan_p.eSet(ModelPackage.Literals.PRODUCTION_PLAN__FACTORY_COMPONENT_INVOCATIONS, allfcInvocations_p);
  }

  /**
   * @see org.eclipse.ui.navigator.CommonDropAdapterAssistant#validateDrop(java.lang.Object, int, org.eclipse.swt.dnd.TransferData)
   */
  @Override
  public IStatus validateDrop(Object target_p, int operation_p, TransferData transferType_p) {
    IStatus result = null;
    // Only, the move operation is taken into account.
    List<FactoryComponentInvocation> selectedFcInvocations = handleSelection();
    switch (operation_p) {
      case DND.DROP_MOVE:
        // Check the selection is the expected one.
        result = (null != selectedFcInvocations) ? Status.OK_STATUS : Status.CANCEL_STATUS;
      break;
      case DND.DROP_DEFAULT:
      case DND.DROP_COPY:
      default:
        result = Status.CANCEL_STATUS;
      break;
    }
    return result;
  }

  /**
   * Handle current selection.
   * @return The list of valid selected elements, null if the selected elements are not valid ones, or none is selected.
   */
  @SuppressWarnings("unchecked")
  private List<FactoryComponentInvocation> handleSelection() {
    List<FactoryComponentInvocation> result = null;
    ISelection selection = LocalSelectionTransfer.getInstance().getSelection();
    // Not a structured selection.
    if (!(selection instanceof IStructuredSelection)) {
      return result;
    }
    // Get selected elements.
    List<?> selectedElements = ((IStructuredSelection) selection).toList();
    // No selected element, stop here.
    if ((null == selectedElements) || selectedElements.isEmpty()) {
      return result;
    }
    // Make sure all selected elements are of FactoryComponentInvocation type and are contained by the same factory component.
    FactoryComponent fcContainer = null;
    boolean isInterrupted = false;
    for (Iterator iterator = selectedElements.iterator(); iterator.hasNext() && !isInterrupted;) {
      Object object = iterator.next();
      if (!(object instanceof FactoryComponentInvocation)) {
        isInterrupted = true;
      }
      if (null == fcContainer) {
        // Handle first loop case.
        fcContainer = ModelHelper.getFactoryComponentContainer((NamedModelElementWithId) object);
      } else if (!fcContainer.equals(ModelHelper.getFactoryComponentContainer((NamedModelElementWithId) object))) {
        isInterrupted = true;
      }
    }
    // Retain selected factory component invocations.
    return result = (!isInterrupted) ? (List<FactoryComponentInvocation>) selectedElements : null;
  }
}
