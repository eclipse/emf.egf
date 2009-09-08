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
package org.eclipse.egf.pattern.refactoring.move;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.pattern.refactoring.internal.move.change.PatternElementChange;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;
import org.eclipse.ltk.core.refactoring.participants.SharableParticipants;


/**
 * @author Guillaume Brocard
 */
public class MoveProcessor extends RefactoringProcessor {
  /**
   * Move info.
   */
  private MoveInfo _moveInfo;

  /**
   * Constructor.
   * @param info_p A not null move information packet.
   */
  public MoveProcessor(MoveInfo info_p) {
    // Pre-check.
    Assert.isNotNull(info_p);
    // Retain information.
    _moveInfo = info_p;
  }

  /**
   * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#getElements()
   */
  @Override
  public Object[] getElements() {
    return _moveInfo.getElementsToMove().toArray();
  }

  /**
   * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#getIdentifier()
   */
  @Override
  public String getIdentifier() {
    return MoveProcessor.class.getName();
  }

  /**
   * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#getProcessorName()
   */
  @Override
  public String getProcessorName() {
    return MoveProcessor.class.getSimpleName();
  }

  /**
   * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#checkFinalConditions(org.eclipse.core.runtime.IProgressMonitor,
   *      org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext)
   */
  @Override
  public RefactoringStatus checkFinalConditions(IProgressMonitor pm_p, CheckConditionsContext context_p) throws CoreException, OperationCanceledException {
    RefactoringStatus result = new RefactoringStatus();
    // Make sure there is a destination element set.
    NamedModelElementWithId destinationElement = _moveInfo.getDestinationElement();
    if (null == destinationElement) {
      result.addFatalError(Messages.MoveProcessor_Conditions_Error_NoDestination);
    }
    // Test type correctness.
    if (!_moveInfo.checkDestinationType()) {
      result.addFatalError(Messages.MoveProcessor_Conditions_Error_InvalidDestination);
    }
    // Make sure move is acceptable.
    if (!_moveInfo.isMoveAcceptable()) {
      result.addError(Messages.MoveProcessor_Conditions_Error_ElementsNotMovable);
    }
    // Now retain only elements that should be moved.
    _moveInfo.retainRelevantElementsToMove();
    // If there is no more element to move, skip the refactoring.
    if (_moveInfo.getElementsToMove().isEmpty()) {
      result.addError(Messages.MoveProcessor_Conditions_Error_NoElementToMove);
    }
    return result;
  }

  /**
   * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#checkInitialConditions(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public RefactoringStatus checkInitialConditions(IProgressMonitor pm_p) throws CoreException, OperationCanceledException {
    RefactoringStatus result = new RefactoringStatus();
    boolean noElement = _moveInfo.getElementsToMove().isEmpty();
    if (noElement) {
      result.addError(Messages.MoveProcessor_Conditions_Error_NoElementToMove);
    }
    return result;
  }

  /**
   * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#createChange(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public Change createChange(IProgressMonitor pm_p) throws CoreException, OperationCanceledException {
    // Create composite change.
    CompositeChange change = new CompositeChange(getProcessorName());
    NamedModelElementWithId destinationLibrary = _moveInfo.getDestinationElement();
    // Add a child change for every pattern element to move.
    for (AbstractPatternElement patternElement : _moveInfo.getElementsToMove()) {
      change.add(PatternElementChange.createPatternElementChange(destinationLibrary, patternElement));
    }
    // Return resulting composite.
    return change;
  }

  /**
   * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#isApplicable()
   */
  @Override
  public boolean isApplicable() throws CoreException {
    return true;
  }

  /**
   * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#loadParticipants(org.eclipse.ltk.core.refactoring.RefactoringStatus,
   *      org.eclipse.ltk.core.refactoring.participants.SharableParticipants)
   */
  @Override
  public RefactoringParticipant[] loadParticipants(RefactoringStatus status_p, SharableParticipants sharedParticipants_p) throws CoreException {
    // This would be the place to load the participants via the
    // ParticipantManager and decide which of them are allowed to participate.
    return new RefactoringParticipant[0];
  }
}
