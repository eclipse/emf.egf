/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.production.internal.context;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.TypeClass;
import org.eclipse.egf.model.fcore.TypeObject;
import org.eclipse.egf.productionplan.EGFProductionPlanPlugin;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * 
 * @author Xavier Maysonnave
 * 
 */
public class ActivityContext<T extends Activity> extends ModelElementContext<T> {

  public ActivityContext(T activity) {
    super(activity);
  }

  @Override
  public void init(Bundle bundle) throws InvocationException {
    // Usuals tests
    if (getElement().getContractContainer() == null) {
      return;
    }
    ContractContainer contracts = getElement().getContractContainer();
    if (contracts.getContracts() == null) {
      return;
    }
    // Init Maps
    super.init(bundle);
    // Init Contracts
    for (Contract contract : contracts.getContracts()) {
      // Should not happen
      if (contract.getType() == null || contract.getName() == null) {
        continue;
      }
      // Instance
      if (contract.getType() instanceof TypeObject<?>) {
        if (contract.getMode() == ContractMode.IN) {
          addInputData(contract.getName(), contract.getType().getType(), contract.getType().getValue());
        } else if (contract.getMode() == ContractMode.OUT) {
          addOutputData(contract.getName(), contract.getType().getType(), contract.getType().getValue());
        }
        // Class
      } else if (contract.getType() instanceof TypeClass<?>) {
        try {
          Object object = BundleHelper.instantiate(((TypeClass<?>) contract.getType()).getValue(), bundle);
          if (object == null) {
            throw new InvocationException(new CoreException(EGFProductionPlanPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, contract.getType().getValue(), bundle.getSymbolicName()), null)));
          }
          if (contract.getMode() == ContractMode.IN) {
            addInputData(contract.getName(), contract.getType().getType(), object);
          } else if (contract.getMode() == ContractMode.OUT) {
            addOutputData(contract.getName(), contract.getType().getType(), object);
          }
        } catch (Throwable t) {
          throw new InvocationException(new CoreException(EGFProductionPlanPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, contract.getType().getValue()), t)));
        }
      }
    }
  }
}
