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
package org.eclipse.egf.model.helper;

import java.util.Stack;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.Orchestration;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ActivityCycleFinder {

  private Stack<Activity> _activities = new Stack<Activity>();

  private Activity _activity;

  public ActivityCycleFinder(Activity activity) {
    Assert.isNotNull(activity);
    _activity = activity;
  }

  public ModelElement getFirstRepetition() {
    _activities.clear();
    return getFirstRepetition(_activity);
  }

  protected ModelElement getFirstRepetition(Activity activity) {
    if (activity == null) {
      return null;
    }
    if (activity instanceof FactoryComponent) {
      _activities.push(activity);
      ModelElement element = getFirstRepetition(((FactoryComponent) activity).getOrchestration());
      // Everything is fine
      if (element == null) {
        _activities.pop();
      }
      return element;
    }
    return null;
  }

  protected ModelElement getFirstRepetition(Orchestration orchestration) {
    if (orchestration == null) {
      return null;
    }
    for (Invocation invocation : orchestration.getInvocations()) {
      ModelElement element = getFirstRepetition(invocation);
      // Activity detected, break immediately
      if (element != null) {
        return element;
      }
    }
    // Everything is fine
    return null;
  }

  protected ModelElement getFirstRepetition(Invocation invocation) {
    if (invocation == null || invocation.getInvokedActivity() == null) {
      return null;
    }
    // Cycle detection
    if (activityLookup(invocation.getInvokedActivity())) {
      return invocation;
    }
    // Invoked Activity analysis
    return getFirstRepetition(invocation.getInvokedActivity());
  }

  private boolean activityLookup(Activity activity) {
    if (activity == null) {
      return false;
    }
    if (_activities.search(activity) != -1) {
      return true;
    }
    return false;
  }

}
