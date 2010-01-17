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
package org.eclipse.egf.model.helper;

import java.util.ArrayList;
import java.util.List;

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

  private List<Activity> _activities = new ArrayList<Activity>();

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
    if (activity instanceof FactoryComponent) {
      _activities.add(activity);
      return getFirstRepetition(((FactoryComponent) activity).getOrchestration());
    }
    return null;
  }

  protected ModelElement getFirstRepetition(Orchestration orchestration) {
    for (Invocation<?> invocation : orchestration.getInvocations()) {
      ModelElement element = getFirstRepetition(invocation);
      if (element != null) {
        return element;
      }
    }
    return null;
  }

  protected ModelElement getFirstRepetition(Invocation<?> invocation) {
    if (invocation.getActivity() == null) {
      return null;
    }
    // Cycle detection at invocation level
    if (activityLookup(invocation.getActivity())) {
      return invocation;
    }
    return getFirstRepetition(invocation.getActivity());
  }

  private boolean activityLookup(Activity activity) {
    if (activity == null) {
      return false;
    }
    for (Activity innerActivity : _activities) {
      if (innerActivity.equals(activity)) {
        return true;
      }
    }
    return false;
  }

}
