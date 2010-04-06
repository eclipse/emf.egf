/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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
 *         Brent's cycle-finding algorithm
 *         http://en.wikipedia.org/wiki/Cycle_detection
 * 
 */
public abstract class AbstractBrentCycleDetection<T> extends AbstractCycleDetection<T> {

  private double _power;

  public AbstractBrentCycleDetection() {
    this(null);
  }

  public AbstractBrentCycleDetection(T element_p) {
    super(element_p);
  }

  @Override
  public void setElement(T element_p) {
    super.setElement(element_p);
    _power = 1;
    _tortoise = element_p;
    _hare = move(element_p);
  }

  @Override
  public T getFirstRepetition() {
    // is there something to process
    if (_solvedFirstRepetition) {
      return _firstRepetition;
    }
    // Search successive powers of two
    while (_hare != null) {
      if (_hare.equals(_tortoise)) {
        // The hare has caught up with the tortoise
        _firstRepetition = _hare;
        break;
      }
      if (_power == _lambda) {
        // Time to start a new power of two
        _tortoise = _hare;
        _power *= 2;
        _lambda = 0;
      }
      // Move
      _hare = move(_hare);
      _lambda += 1;
    }
    // The hare reached the end
    _solvedFirstRepetition = true;
    _solvedLambda = true;
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
    _mu = 0;
    _tortoise = _hare = _element;
    for (int i = 0; i < _lambda; i++) {
      _hare = move(_hare);
    }
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
    // Solve Cycle and lambda if necessary
    if (_solvedFirstRepetition == false) {
      getFirstRepetition();
    }
    return _lambda;
  }

}
