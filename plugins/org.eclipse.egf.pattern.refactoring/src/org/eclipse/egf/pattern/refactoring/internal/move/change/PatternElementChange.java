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
package org.eclipse.egf.pattern.refactoring.internal.move.change;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.egf.common.helper.PatternHelper;
import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.model.PatternViewpoint;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.refactoring.move.MoveInfo;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;


/**
 * @author Guillaume Brocard
 */
public class PatternElementChange extends Change {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(PatternElementChange.class.getPackage().getName());
  /**
   * Move information data.
   */
  private MoveInfo _moveInfo;

  /**
   * Constructor.
   * @param info_p The information data describing the move to perform.
   */
  protected PatternElementChange(MoveInfo info_p) {
    Assert.isNotNull(info_p);
    _moveInfo = info_p;
  }

  /**
   * @see org.eclipse.ltk.core.refactoring.Change#getModifiedElement()
   */
  @Override
  public Object getModifiedElement() {
    return null;
  }

  /**
   * @see org.eclipse.ltk.core.refactoring.Change#getName()
   */
  @Override
  public String getName() {
    return StringHelper.formatMessage(Messages.PatternElementChange_Name, new Object[] { _moveInfo.getFirstElementToMove().getName(),
                                                                                        _moveInfo.getDestinationElement().getName() });
  }

  /**
   * @see org.eclipse.ltk.core.refactoring.Change#initializeValidationData(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public void initializeValidationData(IProgressMonitor pm_p) {
    // Nothing to do here.
  }

  /**
   * @see org.eclipse.ltk.core.refactoring.Change#isValid(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public RefactoringStatus isValid(IProgressMonitor pm_p) throws CoreException, OperationCanceledException {
    RefactoringStatus status = new RefactoringStatus();
    AbstractPatternElement element = _moveInfo.getFirstElementToMove();
    if (null == element) {
      status.addError(Messages.PatternElementChange_Error_NoElement);
    }
    NamedModelElementWithId destinationElement = _moveInfo.getDestinationElement();
    if (null == destinationElement) {
      status.addError(Messages.PatternElementChange_Error_NoDestinationElement);
    }
    return status;
  }

  /**
   * @see org.eclipse.ltk.core.refactoring.Change#perform(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public Change perform(IProgressMonitor pm_p) throws CoreException {
    // Element to move.
    AbstractPatternElement elementToMove = _moveInfo.getFirstElementToMove();
    // Destination library.
    NamedModelElementWithId destinationElement = _moveInfo.getDestinationElement();
    // First of all, create the undo change (while this is still possible).
    NamedModelElementWithId previousContainingElement = (NamedModelElementWithId) elementToMove.eContainer();
    Change undoChange = createPatternElementChange(previousContainingElement, elementToMove);
    // Now do the refactoring stuff.
    EditingDomain editingDomain = EgfUiActivator.getDefault().getEditingDomain();
    CommandStack commandStack = editingDomain.getCommandStack();
    // Remove pattern element from current library.
    Command removeCommand = createRemoveFromContainerCommand(editingDomain, previousContainingElement, elementToMove);
    if (null != removeCommand) {
      commandStack.execute(removeCommand);
    }
    // Update models.
    // That includes, update pattern model and pattern library at factory component level.
    // But also, update pattern persisted models, and move them to the correct destination location.
    updateModels(elementToMove, previousContainingElement, destinationElement);
    // Add it to new one.
    Command addRemoveCommand = createAddCommandToContainer(editingDomain, destinationElement, elementToMove);
    if (null != addRemoveCommand) {
      commandStack.execute(addRemoveCommand);
    }
    return undoChange;
  }

  /**
   * Get containing reference for given container, that is hosting the element to move.
   * @param container_p
   * @return null if container is of unexpected type.
   */
  protected EReference getReferenceForContainer(NamedModelElementWithId container_p) {
    EReference result = null;
    if (container_p instanceof PatternLibrary) {
      result = ModelPackage.Literals.PATTERN_LIBRARY__PATTERN_ELEMENTS;
    } else if (container_p instanceof PatternViewpoint) {
      result = ModelPackage.Literals.PATTERN_VIEWPOINT__LIBRARIES;
    }
    return result;
  }

  /**
   * Create a new command for removing the element from its container.
   * @param editingDomain_p
   * @param container_p
   * @param elementToMove_p
   * @return null if there is inconsistency in provided data.
   */
  protected Command createRemoveFromContainerCommand(EditingDomain editingDomain_p, NamedModelElementWithId container_p, AbstractPatternElement elementToMove_p) {
    Command result = null;
    EReference reference = getReferenceForContainer(container_p);
    if (null != reference) {
      // Create the remove command.
      result = RemoveCommand.create(editingDomain_p, container_p, reference, elementToMove_p);
    }
    return result;
  }

  /**
   * Create a new command for adding the element to a new container.<br>
   * Also update model properties if needed.
   * @param editingDomain_p
   * @param destinationContainer_p
   * @param elementToMove_p
   * @return
   */
  protected Command createAddCommandToContainer(EditingDomain editingDomain_p, NamedModelElementWithId destinationContainer_p,
      AbstractPatternElement elementToMove_p) {
    Command result = null;
    EReference reference = getReferenceForContainer(destinationContainer_p);
    if (null != reference) {
      // Create the add command.
      result = AddCommand.create(editingDomain_p, destinationContainer_p, reference, elementToMove_p);
    }
    return result;
  }

  /**
   * Update models.
   * @param elementToMove_p
   * @param previousContainingElement_p
   * @param destinationElement_p
   */
  protected void updateModels(AbstractPatternElement elementToMove_p, NamedModelElementWithId previousContainingElement_p,
      NamedModelElementWithId destinationElement_p) {
    String previousFcId = ModelHelper.getFactoryComponentContainer(previousContainingElement_p).getId();
    String destinationFcId = ModelHelper.getFactoryComponentContainer(destinationElement_p).getId();
    // Get root container full id.
    String rootId = null;
    if (destinationElement_p instanceof PatternLibrary) {
      rootId = destinationElement_p.getId();
    }
    // Finally, update element to move, including its subtree.
    updateElement(elementToMove_p, rootId, previousFcId, destinationFcId);
  }

  /**
   * Update pattern element, including its subtree (if any).<br>
   * IDs are updated on the basis of given parent one (root).
   * @param patternElement_p
   * @param parentFullId_p
   */
  protected void updateElement(AbstractPatternElement patternElement_p, String parentFullId_p, String previousFcId_p, String destinationFcId_p) {
    String elementFullId = patternElement_p.getId();
    String newId = PatternHelper.getFullId(parentFullId_p, PatternHelper.deresolveId(elementFullId).getValue());
    patternElement_p.setId(newId);
    if (patternElement_p instanceof PatternLibrary) {
      EList<AbstractPatternElement> patternElements = ((PatternLibrary) patternElement_p).getPatternElements();
      for (AbstractPatternElement abstractPatternElement : patternElements) {
        updateElement(abstractPatternElement, newId, previousFcId_p, destinationFcId_p);
      }
    } else if (patternElement_p instanceof PatternModel) {
      PatternModel patternModel = (PatternModel) patternElement_p;
      // Load pattern data.
      RefactoringPatternHandler handler = new RefactoringPatternHandler();
      PatternData patternData = null;
      try {
        patternData = handler.load(patternModel.getPath());
      } catch (Exception exception_p) {
        patternData = null;
      }
      // Pattern persisted model loaded, update its id.
      if (null != patternData) {
        try {
          // Pattern is moving from a factory component to another.
          if (previousFcId_p.equals(destinationFcId_p) == false) {
            // Clean all pattern obsolete structures.
            handler.cleanGeneratedStructures();
            handler.refactorContainingFactoryComponent(previousFcId_p, destinationFcId_p);
            handler.refactorFullId(newId, false);
          } else {
            handler.refactorFullId(newId, true);
          }
          handler.save(patternModel);
        } catch (Exception e_p) {
          StringBuilder loggerMessage = new StringBuilder("PatternElementChange.updateElement(..) _ "); //$NON-NLS-1$
          loggerMessage.append("Unable to update element ").append(patternElement_p.getName()); //$NON-NLS-1$
          __logger.error(loggerMessage.toString(), e_p);
        }
      }
    }
  }

  /**
   * Create a new pattern element change with given parameters.
   * @param destinationElement_p A not null destination element. Should be either a pattern library or the pattern viewpoint.
   * @param patternElement_p A not null pattern element to move.
   * @return a new Change that handles moving pattern element to destination library.
   */
  public static Change createPatternElementChange(NamedModelElementWithId destinationElement_p, AbstractPatternElement patternElement_p) {
    // Preconditions.
    Assert.isNotNull(patternElement_p);
    Assert.isNotNull(destinationElement_p);
    // Create expected result.
    MoveInfo info = new MoveInfo();
    info.setDestinationElement(destinationElement_p);
    info.addElementToMove(patternElement_p);
    return new PatternElementChange(info);
  }
}
