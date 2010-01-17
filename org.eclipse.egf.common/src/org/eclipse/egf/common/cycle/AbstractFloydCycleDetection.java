/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.cycle;

/**
 * @author Xavier Maysonnave
 * 
 *         Tortoise and hare
 *         Floyd's cycle-finding algorithm
 *         http://en.wikipedia.org/wiki/Cycle_detection
 *         http://fr.wikipedia.org/wiki/Algorithme_du_li%C3%A8vre_et_de_la_tortue
 * 
 */
public abstract class AbstractFloydCycleDetection<T> extends AbstractCycleDetection<T> {

  public AbstractFloydCycleDetection() {
    this(null);
  }

  public AbstractFloydCycleDetection(T element_p) {
    super(element_p);
  }

  @Override
  public void setElement(T element_p) {
    super.setElement(element_p);
    _tortoise = move(element_p);
    _hare = move(move(element_p));
  }

  @Override
  public T getFirstRepetition() {
    // is there something to process
    if (_solvedFirstRepetition) {
      return _firstRepetition;
    }
    // Search
    while (_hare != null) {
      if (_hare.equals(_tortoise)) {
        // The hare has caught up with the tortoise
        _firstRepetition = _hare;
        break;
      }
      if (move(_hare) == null) {
        // The hare reached the end
        break;
      }
      // The hare moves twice as quickly as the tortoise
      _tortoise = move(_tortoise);
      _hare = move(move(_hare));
    }
    // The hare reached the end
    _solvedFirstRepetition = true;
    return _firstRepetition;
  }

  @Override
  public int getMu() {
    // is there something to process
    if (_solvedMu) {
      return _mu;
    }
    // Solve Cycle if necessary
    if (_solvedFirstRepetition == false) {
      getFirstRepetition();
    }
    // Find the position of the first repetition of length lambda
    // The hare and tortoise move at the same speeds
    _mu = 0;
    _tortoise = _hare = _element;
    while (_hare != null) {
      if (_hare.equals(_tortoise)) {
        break;
      }
      _tortoise = move(_tortoise);
      _hare = move(_hare);
      _mu += 1;
    }
    // Done
    _solvedMu = true;
    return _mu;
  }

  @Override
  public int getLambda() {
    // is there something to process
    if (_solvedLambda) {
      return _lambda;
    }
    // Solve mu if necessary
    if (_solvedMu == false) {
      getMu();
    }
    // Find the length of the shortest cycle starting from _firstRepetitionPosition
    // The hare moves while the tortoise stays still
    _lambda = 1;
    _hare = move(_tortoise);
    while (_hare != null) {
      if (_hare.equals(_tortoise)) {
        break;
      }
      _hare = move(_hare);
      _lambda += 1;
    }
    // Done
    _solvedLambda = true;
    return _lambda;
  }

}
