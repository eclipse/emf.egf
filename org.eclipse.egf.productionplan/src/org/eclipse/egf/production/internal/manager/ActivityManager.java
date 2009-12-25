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
package org.eclipse.egf.production.internal.manager;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.productionplan.EGFProductionPlanPlugin;
import org.eclipse.egf.productionplan.l10n.ProductionPlanMessages;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ActivityManager<Q extends ProductionPlanInvocationManager<?, ?>, T extends Activity> extends AbstractManager<Q, T> {

  public ActivityManager(T activity) throws InvocationException {
    super(activity);
    _platformFcore = EGFCorePlugin.getPlatformFcore(activity.eResource());
    if (_platformFcore == null) {
      throw new InvocationException(new CoreException(EGFProductionPlanPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ProductionPlanMessages.ActivityManager_fcore_activity, getName()), null)));
    }
    reset();
  }

  public ActivityManager(Bundle bundle, T activity) throws InvocationException {
    super(bundle, activity);
    reset();
  }

  public ActivityManager(Q parent, T activity) throws InvocationException {
    super(parent, activity);
    _platformFcore = EGFCorePlugin.getPlatformFcore(activity.eResource());
    if (_platformFcore == null) {
      throw new InvocationException(new CoreException(EGFProductionPlanPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ProductionPlanMessages.ActivityManager_fcore_activity, getName()), null)));
    }
    reset();
  }

  public void reset() throws InvocationException {
    getProductionContext().init(getBundle());
  }

  public abstract void invoke(IProgressMonitor monitor) throws InvocationException;

}
