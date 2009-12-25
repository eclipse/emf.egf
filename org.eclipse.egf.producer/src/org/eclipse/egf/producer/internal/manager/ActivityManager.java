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
package org.eclipse.egf.producer.internal.manager;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.ActivityContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.TypeClass;
import org.eclipse.egf.model.fcore.TypeObject;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.context.ModelElementContext;
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.egf.producer.manager.IModelProducerManager;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ActivityManager<T extends Activity> extends AbstractManager<T> {

  public ActivityManager(T activity) throws InvocationException {
    super(activity);
    _platformFcore = EGFCorePlugin.getPlatformFcore(activity.eResource());
    if (_platformFcore == null) {
      throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ProducerMessages.ActivityManager_fcore_activity, getName()), null)));
    }
    init();
  }

  public ActivityManager(Bundle bundle, T activity) throws InvocationException {
    super(bundle, activity);
    init();
  }

  public ActivityManager(IModelProducerManager<?> parent, T activity) throws InvocationException {
    super(parent, activity);
    _platformFcore = EGFCorePlugin.getPlatformFcore(activity.eResource());
    if (_platformFcore == null) {
      throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ProducerMessages.ActivityManager_fcore_activity, getName()), null)));
    }
    init();
  }

  public void init() throws InvocationException {
    // Usuals tests
    if (getElement().getActivityContractContainer() == null) {
      return;
    }
    ActivityContractContainer contracts = getElement().getActivityContractContainer();
    if (contracts.getActivityContracts() == null) {
      return;
    }
    // Get Context
    ModelElementContext<T> productionContext = (ModelElementContext<T>) getProductionContext();
    // Reset Context
    productionContext.reset();
    // Init Contracts
    for (ActivityContract contract : contracts.getActivityContracts()) {
      // Should not happen
      if (contract.getType() == null || contract.getName() == null) {
        continue;
      }
      // Instance
      if (contract.getType() instanceof TypeObject<?>) {
        if (contract.getMode() == ContractMode.IN) {
          productionContext.addInputData(contract.getName(), contract.getType().getType(), contract.getType().getValue());
        } else if (contract.getMode() == ContractMode.OUT) {
          productionContext.addOutputData(contract.getName(), contract.getType().getType(), null);
        } else if (contract.getMode() == ContractMode.IN_OUT) {
          productionContext.addInputData(contract.getName(), contract.getType().getType(), contract.getType().getValue());
          productionContext.addOutputData(contract.getName(), contract.getType().getType(), contract.getType().getValue());
        }
        // Class
      } else if (contract.getType() instanceof TypeClass<?>) {
        try {
          Object object = null;
          // Should we instantiate value
          String fqcn = ((TypeClass<?>) contract.getType()).getValue();
          if (fqcn != null && fqcn.trim().length() != 0) {
            object = BundleHelper.instantiate(fqcn.trim(), getBundle());
            if (object == null) {
              throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, contract.getType().getValue(), getBundle().getSymbolicName()), null)));
            }
          }
          if (contract.getMode() == ContractMode.IN) {
            productionContext.addInputData(contract.getName(), contract.getType().getType(), object);
          } else if (contract.getMode() == ContractMode.OUT) {
            productionContext.addOutputData(contract.getName(), contract.getType().getType(), null);
          } else if (contract.getMode() == ContractMode.IN_OUT) {
            productionContext.addInputData(contract.getName(), contract.getType().getType(), object);
            productionContext.addOutputData(contract.getName(), contract.getType().getType(), object);
          }
        } catch (Throwable t) {
          throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, contract.getType().getValue()), t)));
        }
      }
    }
  }

  public abstract void invoke(IProgressMonitor monitor) throws InvocationException;

}
