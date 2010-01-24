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
import org.eclipse.egf.core.producer.context.ProductionContext;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.types.Type;
import org.eclipse.egf.model.types.TypeAbstractClass;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.manager.IModelElementManager;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class InvocationManager<P extends Orchestration, T extends Invocation> extends ModelElementManager<T, InvocationContract> {

  public InvocationManager(IModelElementManager<P, OrchestrationParameter> parent, T invocation) throws InvocationException {
    super(parent, invocation);
  }

  @Override
  public void initializeContext() throws InvocationException {
    // Get Context
    ProductionContext<T, InvocationContract> context = getInternalProductionContext();
    // Clear Context
    context.clear();
    // Set Context
    for (InvocationContract invocationContract : getElement().getInvocationContracts()) {
      // Nothing to process
      if (invocationContract.getInvokedContract() == null) {
        continue;
      }
      // Fetch Type and Value
      Type type = invocationContract.getType() != null ? invocationContract.getType() : invocationContract.getInvokedContract().getType();
      Object value = invocationContract.getType() != null ? invocationContract.getType().getValue() : null;
      // Nothing to process
      if (type == null) {
        continue;
      }
      // Class
      if (invocationContract.getType() instanceof TypeAbstractClass) {
        try {
          Object object = null;
          // Should we instantiate value
          String fqcn = (String) value;
          if (fqcn != null && fqcn.trim().length() != 0) {
            object = BundleHelper.instantiate(fqcn.trim(), getBundle());
            if (object == null) {
              throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, value, getBundle().getSymbolicName()), null)));
            }
          }
          if (invocationContract.getInvokedMode() == ContractMode.IN) {
            context.addInputData(invocationContract, type.getType(), object);
          } else if (invocationContract.getInvokedMode() == ContractMode.OUT) {
            context.addOutputData(invocationContract, type.getType(), null);
          } else if (invocationContract.getInvokedMode() == ContractMode.IN_OUT) {
            context.addInputData(invocationContract, type.getType(), object);
            context.addOutputData(invocationContract, type.getType(), object);
          }
        } catch (Throwable t) {
          throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, value), t)));
        }
      } else {
        if (invocationContract.getInvokedMode() == ContractMode.IN) {
          context.addInputData(invocationContract, type.getType(), value);
        } else if (invocationContract.getInvokedMode() == ContractMode.OUT) {
          context.addOutputData(invocationContract, type.getType(), null);
        } else if (invocationContract.getInvokedMode() == ContractMode.IN_OUT) {
          context.addInputData(invocationContract, type.getType(), value);
          context.addOutputData(invocationContract, type.getType(), value);
        }
      }
    }
  }

}
