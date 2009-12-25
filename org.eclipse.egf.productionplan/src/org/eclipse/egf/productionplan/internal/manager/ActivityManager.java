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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.TypeClass;
import org.eclipse.egf.model.fcore.TypeObject;
import org.eclipse.egf.productionplan.EGFProductionPlanPlugin;
import org.eclipse.egf.productionplan.internal.context.ModelElementContext;
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
    init();
  }

  public ActivityManager(Bundle bundle, T activity) throws InvocationException {
    super(bundle, activity);
    init();
  }

  public ActivityManager(Q parent, T activity) throws InvocationException {
    super(parent, activity);
    _platformFcore = EGFCorePlugin.getPlatformFcore(activity.eResource());
    if (_platformFcore == null) {
      throw new InvocationException(new CoreException(EGFProductionPlanPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ProductionPlanMessages.ActivityManager_fcore_activity, getName()), null)));
    }
    init();
  }

  public void init() throws InvocationException {
    // Usuals tests
    if (getElement().getContractContainer() == null) {
      return;
    }
    ContractContainer contracts = getElement().getContractContainer();
    if (contracts.getContracts() == null) {
      return;
    }
    // Get Context
    ModelElementContext<T> productionContext = (ModelElementContext<T>) getProductionContext();
    // Reset Context
    productionContext.reset();
    // Init Contracts
    for (Contract contract : contracts.getContracts()) {
      // Should not happen
      if (contract.getType() == null || contract.getName() == null) {
        continue;
      }
      // Instance
      if (contract.getType() instanceof TypeObject<?>) {
        if (contract.getMode() == ContractMode.IN) {
          productionContext.addInputData(contract.getName(), contract.getType().getType(), contract.getType().getValue());
        } else if (contract.getMode() == ContractMode.OUT) {
          productionContext.addOutputData(contract.getName(), contract.getType().getType(), contract.getType().getValue());
        }
        // Class
      } else if (contract.getType() instanceof TypeClass<?>) {
        try {
          Object object = BundleHelper.instantiate(((TypeClass<?>) contract.getType()).getValue(), getBundle());
          if (object == null) {
            throw new InvocationException(new CoreException(EGFProductionPlanPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, contract.getType().getValue(), getBundle().getSymbolicName()), null)));
          }
          if (contract.getMode() == ContractMode.IN) {
            productionContext.addInputData(contract.getName(), contract.getType().getType(), object);
          } else if (contract.getMode() == ContractMode.OUT) {
            productionContext.addOutputData(contract.getName(), contract.getType().getType(), object);
          }
        } catch (Throwable t) {
          throw new InvocationException(new CoreException(EGFProductionPlanPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, contract.getType().getValue()), t)));
        }
      }
    }
  }

  public abstract void invoke(IProgressMonitor monitor) throws InvocationException;

}
