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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.types.TypeClass;
import org.eclipse.egf.model.types.TypeObject;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.context.IActivityProductionContext;
import org.eclipse.egf.producer.internal.context.ActivityProductionContext;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.egf.producer.manager.IInvocationManager;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ActivityManager extends ModelElementManager implements IActivityManager {

  public ActivityManager(Activity activity) throws InvocationException {
    super(activity);
  }

  public ActivityManager(Bundle bundle, Activity activity) throws InvocationException {
    super(bundle, activity);
  }

  public ActivityManager(IInvocationManager parent, Activity activity) throws InvocationException {
    super(parent, activity);
  }

  @Override
  public Activity getElement() {
    return (Activity) super.getElement();
  }

  @Override
  public IActivityProductionContext getProductionContext() {
    return (IActivityProductionContext) super.getProductionContext();
  }

  @Override
  public IInvocationManager getParent() {
    return (IInvocationManager) super.getParent();
  }

  @Override
  protected abstract ActivityProductionContext getInternalProductionContext() throws InvocationException;

  @Override
  public void prepare() throws InvocationException {
    // Get Context
    ActivityProductionContext context = getInternalProductionContext();
    // Clear Context
    context.clear();
    // Set Context
    for (ActivityContract contract : getElement().getActivityContracts()) {
      // Should not happen, anyway ignore
      if (contract.getType() == null) {
        continue;
      }
      // Object
      if (contract.getType() instanceof TypeObject<?>) {
        if (contract.getMode() == ContractMode.IN) {
          context.addInputData(contract, contract.getType().getType(), contract.getType().getValue());
        } else if (contract.getMode() == ContractMode.OUT) {
          context.addOutputData(contract, contract.getType().getType(), null);
        } else if (contract.getMode() == ContractMode.IN_OUT) {
          context.addInputData(contract, contract.getType().getType(), contract.getType().getValue());
          context.addOutputData(contract, contract.getType().getType(), contract.getType().getValue());
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
            context.addInputData(contract, contract.getType().getType(), object);
          } else if (contract.getMode() == ContractMode.OUT) {
            context.addOutputData(contract, contract.getType().getType(), null);
          } else if (contract.getMode() == ContractMode.IN_OUT) {
            context.addInputData(contract, contract.getType().getType(), object);
            context.addOutputData(contract, contract.getType().getType(), object);
          }
        } catch (Throwable t) {
          throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, contract.getType().getValue()), t)));
        }
      }
    }
  }

}
