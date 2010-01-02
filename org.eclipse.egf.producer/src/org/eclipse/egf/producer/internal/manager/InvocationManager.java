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
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContext;
import org.eclipse.egf.model.types.TypeAbstractClass;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.context.IInvocationProductionContext;
import org.eclipse.egf.producer.internal.context.InvocationProductionContext;
import org.eclipse.egf.producer.manager.IInvocationManager;
import org.eclipse.egf.producer.manager.IOrchestrationManager;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class InvocationManager extends ModelElementManager implements IInvocationManager {

  public InvocationManager(IOrchestrationManager parent, Invocation<?> invocation) throws InvocationException {
    super(parent, invocation);
  }

  @Override
  public Invocation<?> getElement() {
    return (Invocation<?>) super.getElement();
  }

  @Override
  public IInvocationProductionContext getProductionContext() {
    return (IInvocationProductionContext) super.getProductionContext();
  }

  @Override
  public IOrchestrationManager getParent() {
    return (IOrchestrationManager) super.getParent();
  }

  @Override
  protected abstract InvocationProductionContext getInternalProductionContext() throws InvocationException;

  @Override
  public void initializeContext() throws InvocationException {
    // Get Context
    InvocationProductionContext context = getInternalProductionContext();
    // Clear Context
    context.clear();
    // Set Context
    for (InvocationContext invocationContext : getElement().getInvocationContexts()) {
      // Nothing to process
      if (invocationContext.getType() == null || invocationContext.getActivityContract() == null) {
        continue;
      }
      // Class
      if (invocationContext.getType() instanceof TypeAbstractClass<?>) {
        try {
          Object object = null;
          // Should we instantiate value
          String fqcn = ((TypeAbstractClass<?>) invocationContext.getType()).getValue();
          if (fqcn != null && fqcn.trim().length() != 0) {
            object = BundleHelper.instantiate(fqcn.trim(), getBundle());
            if (object == null) {
              throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, invocationContext.getType().getValue(), getBundle().getSymbolicName()), null)));
            }
          }
          if (invocationContext.getMode() == ContractMode.IN) {
            context.addInputData(invocationContext, invocationContext.getType().getType(), object);
          } else if (invocationContext.getMode() == ContractMode.OUT) {
            context.addOutputData(invocationContext, invocationContext.getType().getType(), null);
          } else if (invocationContext.getMode() == ContractMode.IN_OUT) {
            context.addInputData(invocationContext, invocationContext.getType().getType(), object);
            context.addOutputData(invocationContext, invocationContext.getType().getType(), object);
          }
        } catch (Throwable t) {
          throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, invocationContext.getType().getValue()), t)));
        }
      } else {
        if (invocationContext.getMode() == ContractMode.IN) {
          context.addInputData(invocationContext, invocationContext.getType().getType(), invocationContext.getType().getValue());
        } else if (invocationContext.getMode() == ContractMode.OUT) {
          context.addOutputData(invocationContext, invocationContext.getType().getType(), null);
        } else if (invocationContext.getMode() == ContractMode.IN_OUT) {
          context.addInputData(invocationContext, invocationContext.getType().getType(), invocationContext.getType().getValue());
          context.addOutputData(invocationContext, invocationContext.getType().getType(), invocationContext.getType().getValue());
        }
      }
    }
  }

}
