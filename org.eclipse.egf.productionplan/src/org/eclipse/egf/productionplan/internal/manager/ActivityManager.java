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

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.productionplan.EGFProductionPlanPlugin;
import org.eclipse.egf.productionplan.manager.IProductionPlanManager;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ActivityManager implements IProductionPlanManager {

  private Activity _activity;

  private IProductionContext _parentProductionContext;

  public ActivityManager(Activity activity) {
    Assert.isNotNull(activity);
    _activity = activity;
  }

  public ActivityManager(IProductionContext parentProductionContext, Activity activity) {
    this(activity);
    _parentProductionContext = parentProductionContext;
  }

  public Activity getActivity() {
    return _activity;
  }

  public IProductionContext getProductionContext() {
    return EGFProductionPlanPlugin.getProductionPlanContextFactory().createProductionPlanContext(_parentProductionContext, _activity);
  }

  public abstract void invoke(IProgressMonitor monitor) throws InvocationException;

}
