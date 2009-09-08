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

import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.pattern.refactoring.move.MoveInfo;
import org.eclipse.egf.pattern.refactoring.move.MoveProcessor;
import org.eclipse.egf.pattern.refactoring.move.MoveRefactoring;
import org.eclipse.jdt.internal.ui.actions.WorkbenchRunnableAdapter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ltk.core.refactoring.CheckConditionsOperation;
import org.eclipse.ltk.core.refactoring.CreateChangeOperation;
import org.eclipse.ltk.core.refactoring.PerformChangeOperation;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.CommonDropAdapterAssistant;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;


/**
 * Drop assistant for pattern libraries.<br>
 * Handles that a set of patterns (including a single one) or an entire library can be moved to a receiving one.<br>
 * Delegates to the pattern refactoring mechanism to do so.
 * @author Guillaume Brocard
 */
public class PatternLibraryDropAdapterAssistant extends CommonDropAdapterAssistant {
  /**
   * Currently in use move refactoring.
   */
  private MoveRefactoring _moveRefactoring;

  /**
   * @see org.eclipse.ui.navigator.CommonDropAdapterAssistant#handleDrop(org.eclipse.ui.navigator.CommonDropAdapter, org.eclipse.swt.dnd.DropTargetEvent,
   *      java.lang.Object)
   */
  @Override
  public IStatus handleDrop(CommonDropAdapter dropAdapter_p, DropTargetEvent dropTargetEvent_p, Object target_p) {
    // Create change operation.
    CreateChangeOperation changeOperation = new CreateChangeOperation(_moveRefactoring);
    // Create perform operation.
    PerformChangeOperation performOperation = new PerformChangeOperation(changeOperation);
    // Create resulting status.
    IStatus resultingStatus = Status.CANCEL_STATUS;
    // Execute operation.
    WorkbenchRunnableAdapter runnableAdapter = new WorkbenchRunnableAdapter(performOperation, ResourcesPlugin.getWorkspace().getRoot());
    try {
      PlatformUI.getWorkbench().getProgressService().run(false, false, runnableAdapter);
      resultingStatus = Status.OK_STATUS;
    } catch (Exception e_p) {
      // Already stated as canceled.
    }
    _moveRefactoring = null;
    return resultingStatus;
  }

  /**
   * @see org.eclipse.ui.navigator.CommonDropAdapterAssistant#validateDrop(java.lang.Object, int, org.eclipse.swt.dnd.TransferData)
   */
  @Override
  public IStatus validateDrop(Object target_p, int operation_p, TransferData transferType_p) {
    List<AbstractPatternElement> selectedPatternElements = handleSelection();
    // Create resulting status.
    IStatus resultingStatus = Status.CANCEL_STATUS;
    // Precondition.
    if (null == selectedPatternElements) {
      return resultingStatus;
    }
    // Create move information.
    MoveInfo moveInfo = new MoveInfo();
    // Since this drop adapter is registered for PatternLibrary and PatternViewpoint types only, there should be no problem here.
    NamedModelElementWithId target = (NamedModelElementWithId) target_p;
    moveInfo.setDestinationElement(target);
    moveInfo.addElementsToMove(selectedPatternElements);
    // Create move processor.
    MoveProcessor processor = new MoveProcessor(moveInfo);
    // Create refactoring.
    _moveRefactoring = new MoveRefactoring(processor);
    // Create check conditions operation.
    CheckConditionsOperation checkOperation = new CheckConditionsOperation(_moveRefactoring, CheckConditionsOperation.ALL_CONDITIONS);
    // Execute operation.
    WorkbenchRunnableAdapter runnableAdapter = new WorkbenchRunnableAdapter(checkOperation, ResourcesPlugin.getWorkspace().getRoot());
    try {
      runnableAdapter.run(new NullProgressMonitor());
      RefactoringStatus status = checkOperation.getStatus();
      if (status.isOK()) {
        resultingStatus = Status.OK_STATUS;
      }
    } catch (Exception e_p) {
      // Already stated as canceled.
    }
    return resultingStatus;
  }

  /**
   * Handle current selection.
   * @return The list of valid selected elements, null if the selected elements are not valid ones, or none is selected.
   */
  @SuppressWarnings("unchecked")
  private List<AbstractPatternElement> handleSelection() {
    List<AbstractPatternElement> result = null;
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
    // Make sure all selected elements are of pattern element type.
    for (Object object : selectedElements) {
      if (!(object instanceof AbstractPatternElement)) {
        return result;
      }
    }
    // Retain selected pattern elements.
    result = (List<AbstractPatternElement>) selectedElements;
    return result;
  }
}
