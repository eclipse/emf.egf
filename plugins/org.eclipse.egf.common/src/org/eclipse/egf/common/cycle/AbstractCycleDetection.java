/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.cycle;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class AbstractCycleDetection<T> {

  protected T _element;

  protected T _tortoise; // slower moving element

  protected T _hare; // faster moving element

  protected T _firstRepetition;

  protected boolean _solvedFirstRepetition;

  protected int _mu;

  protected boolean _solvedMu;

  protected int _lambda;

  protected boolean _solvedLambda;

  public AbstractCycleDetection(T element_p) {
    setElement(element_p);
  }

  public T getElement() {
    return _element;
  }

  public void setElement(T element_p) {
    _firstRepetition = null;
    _solvedFirstRepetition = false;
    _lambda = 1;
    _solvedLambda = false;
    _mu = 0;
    _solvedMu = false;
    _element = element_p;
  }

  protected T move(T element_p) {
    if (element_p == null) {
      return null;
    }
    return next(element_p);
  }

  protected abstract T next(T element_p);

  public abstract T getFirstRepetition();

  public abstract int getMu();

  public int getLambda() {
    return _lambda;
  }

}
