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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.model.PatternViewpoint;
import org.eclipse.egf.pattern.ui.editor.PatternEditorHelper;


/**
 * Move information.
 * @author Guillaume Brocard
 */
public class MoveInfo {
  /**
   * Set of patterns and libraries to move.
   */
  private Set<AbstractPatternElement> _elementsToMove;
  /**
   * Destination element (for elements to move). Should be either a pattern library or the pattern viewpoint.
   */
  private NamedModelElementWithId _destinationElement;

  /**
   * Make sure elements to move structure exists and is not null.
   */
  private void ensureElementsToMoveStructure(int initialSize_p) {
    // Create internal structure, if needed.
    if (null == _elementsToMove) {
      _elementsToMove = new HashSet<AbstractPatternElement>(initialSize_p);
    }
  }

  /**
   * Get elements to move.
   * @return Collection of {@link AbstractPatternElement} (being either a pattern or a library of patterns).
   */
  public Collection<AbstractPatternElement> getElementsToMove() {
    ensureElementsToMoveStructure(0);
    return _elementsToMove;
  }

  /**
   * Get first element to move.
   * @return Null if no element to move is registered yet.
   */
  public AbstractPatternElement getFirstElementToMove() {
    AbstractPatternElement result = null;
    ensureElementsToMoveStructure(0);
    if (!_elementsToMove.isEmpty()) {
      result = _elementsToMove.iterator().next();
    }
    return result;
  }

  /**
   * Add elements to elements to move.<br>
   * Note that given collection is cloned, so it can be modified outside of {@link MoveInfo}.
   * @param elementsToMove_p A not null and not empty collection of elements to move.
   */
  public void addElementsToMove(Collection<AbstractPatternElement> elementsToMove_p) {
    // Preconditions.
    Assert.isNotNull(elementsToMove_p);
    Assert.isTrue(!elementsToMove_p.isEmpty());
    ensureElementsToMoveStructure(elementsToMove_p.size());
    // Add the elements.
    _elementsToMove.addAll(elementsToMove_p);
  }

  /**
   * Add an element to move.<br>
   * @param element_p A not null element to move.
   */
  public void addElementToMove(AbstractPatternElement element_p) {
    // Preconditions.
    Assert.isNotNull(element_p);
    ensureElementsToMoveStructure(1);
    // Add the element.
    _elementsToMove.add(element_p);
  }

  /**
   * Make sure that given element is not already having destination element (if any specified) as a parent.
   * @param element_p
   * @return
   */
  protected boolean isRelevantElementToMove(AbstractPatternElement element_p) {
    boolean result = true;
    // No destination element available yet, add it to the collection of elements.
    // An additional check should be performed later (see #retainRelevantElementsToMove()).
    if (null == _destinationElement) {
      return result;
    }
    // Can't move to current container or to itself.
    result = (_destinationElement != element_p.eContainer()) && (_destinationElement != element_p);
    // Can't move if an editor is being opened.
    if (result && (element_p instanceof PatternModel)) {
      PatternModel patternModel = (PatternModel) element_p;
      result = (null == PatternEditorHelper.isPatternEditorOpen(patternModel));
    }
    return result;
  }

  /**
   * Is move to destination element acceptable for elements to move ?<br>
   * For instance, a pattern can't be moved to the pattern viewpoint.
   * @return
   */
  public boolean isMoveAcceptable() {
    boolean result = true;
    if (_destinationElement instanceof PatternViewpoint) {
      // Make sure no pattern is selected directly.
      for (AbstractPatternElement patternElement  : _elementsToMove) {
        // Found a pattern.
        if (patternElement instanceof PatternModel) {
          result = false;
          break;
        }
      }
    }
    return result;
  }

  /**
   * Retain relevant elements to move only.<br>
   * That is, retain the elements that are not having the destination library as parent.<br>
   * The modified collections is accessible through the {@link #getElementsToMove()} method.
   */
  public void retainRelevantElementsToMove() {
    // Preconditions.
    Assert.isNotNull(_destinationElement);
    Assert.isNotNull(_elementsToMove);
    Assert.isTrue(!_elementsToMove.isEmpty());
    // Go for it !
    // Clone existing elements collection.
    HashSet<AbstractPatternElement> clonedElements = new HashSet<AbstractPatternElement>(_elementsToMove.size());
    clonedElements.addAll(_elementsToMove);
    // Then iterate through the cloned set and remove from original one the elements that should not be here.
    for (AbstractPatternElement abstractPatternElement : clonedElements) {
      // Not relevant, remove it from original set.
      if (!isRelevantElementToMove(abstractPatternElement)) {
        _elementsToMove.remove(abstractPatternElement);
      }
    }
  }

  /**
   * Check if destination element is of correct type.
   * @return true if so, false if not of correct type or null.
   */
  public boolean checkDestinationType() {
    return (_destinationElement instanceof PatternLibrary) || (_destinationElement instanceof PatternViewpoint);
  }

  /**
   * Get destination element.
   * @return
   */
  public NamedModelElementWithId getDestinationElement() {
    return _destinationElement;
  }

  /**
   * Set destination element.
   * @param destinationElement_p
   */
  public void setDestinationElement(NamedModelElementWithId destinationElement_p) {
    _destinationElement = destinationElement_p;
  }
}
