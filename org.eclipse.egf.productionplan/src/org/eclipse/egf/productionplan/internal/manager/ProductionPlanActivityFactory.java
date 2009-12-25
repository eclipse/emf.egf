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
package org.eclipse.egf.productionplan.internal.manager;

import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.productionplan.Task;
import org.eclipse.egf.productionplan.manager.IProductionPlanActivityFactory;
import org.eclipse.egf.productionplan.manager.IProductionPlanManager;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanActivityFactory implements IProductionPlanActivityFactory {

  public IProductionPlanManager createProductionPlanManager(IProductionContext productionContext, Activity activity) {
    if (activity instanceof FactoryComponent) {
      return new FactoryComponentManager(productionContext, (FactoryComponent) activity);
    } else if (activity instanceof Task) {
      return new TaskManager(productionContext, (Task) activity);
    }
    return null;
  }

  public IProductionPlanManager createProductionPlanManager(Activity activity) {
    if (activity instanceof FactoryComponent) {
      return new FactoryComponentManager((FactoryComponent) activity);
    } else if (activity instanceof Task) {
      return new TaskManager((Task) activity);
    }
    return null;
  }

}
