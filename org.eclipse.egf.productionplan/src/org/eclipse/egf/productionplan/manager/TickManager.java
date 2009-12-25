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
package org.eclipse.egf.productionplan.manager;

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.productionplan.FactoryComponentInvocation;
import org.eclipse.egf.model.productionplan.ProductionPlan;
import org.eclipse.egf.model.productionplan.ProductionPlanInvocation;
import org.eclipse.egf.model.productionplan.Task;
import org.eclipse.egf.model.productionplan.TaskInvocation;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TickManager {

  private TickManager() {
    // Prevent Instantiation
  }

  public static int getTicks(ProductionPlanInvocation productionPlanInvocation) {
    if (productionPlanInvocation != null) {
      if (productionPlanInvocation instanceof FactoryComponentInvocation) {
        return getTicks(((FactoryComponentInvocation) productionPlanInvocation).getFactoryComponent());
      } else if (productionPlanInvocation instanceof TaskInvocation) {
        return getTicks(((TaskInvocation) productionPlanInvocation).getTask());
      }
    }
    return 0;
  }

  public static int getTicks(Activity activity) {
    if (activity != null) {
      if (activity instanceof FactoryComponent) {
        if (((FactoryComponent) activity).getOrchestration() instanceof ProductionPlan) {
          return getTicks((ProductionPlan) ((FactoryComponent) activity).getOrchestration());
        }
      } else if (activity instanceof Task) {
        if (((Task) activity).getTaskId() != null) {
          return 1;
        }
      }
    }
    return 0;
  }

  public static int getTicks(Task task) {
    if (task != null && task.getTaskId() != null) {
      return 1;
    }
    return 0;
  }

  public static int getTicks(ProductionPlan productionPlan) {
    if (productionPlan != null) {
      int steps = 0;
      for (ProductionPlanInvocation invocation : productionPlan.getProductionPlanInvocations()) {
        steps += getTicks(invocation);
      }
      return steps;
    }
    return 0;
  }

}
