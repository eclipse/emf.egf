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
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationContext;
import org.eclipse.egf.model.types.TypeClass;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.context.IOrchestrationProductionContext;
import org.eclipse.egf.producer.internal.context.OrchestrationProductionContext;
import org.eclipse.egf.producer.manager.IFactoryComponentManager;
import org.eclipse.egf.producer.manager.IOrchestrationManager;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class OrchestrationManager extends ModelElementManager implements IOrchestrationManager {

  public OrchestrationManager(IFactoryComponentManager parent, Orchestration orchestration) throws InvocationException {
    super(parent, orchestration);
  }

  @Override
  public Orchestration getElement() {
    return (Orchestration) super.getElement();
  }

  @Override
  public IOrchestrationProductionContext getProductionContext() {
    return (IOrchestrationProductionContext) super.getProductionContext();
  }

  @Override
  public IFactoryComponentManager getParent() {
    return (IFactoryComponentManager) super.getParent();
  }

  @Override
  protected abstract OrchestrationProductionContext getInternalProductionContext() throws InvocationException;

  @Override
  public void initializeContext() throws InvocationException {
    // Get Context
    OrchestrationProductionContext context = getInternalProductionContext();
    // Clear Context
    context.clear();
    // Set Context
    for (OrchestrationContext orchestrationContext : getElement().getOrchestrationContexts()) {
      // Nothing to process
      if (orchestrationContext.getType() == null) {
        continue;
      }
      // Class
      if (orchestrationContext.getType() instanceof TypeClass<?>) {
        try {
          Object object = null;
          // Should we instantiate value
          String fqcn = ((TypeClass<?>) orchestrationContext.getType()).getValue();
          if (fqcn != null && fqcn.trim().length() != 0) {
            object = BundleHelper.instantiate(fqcn.trim(), getBundle());
            if (object == null) {
              throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, orchestrationContext.getType().getValue(), getBundle().getSymbolicName()), null)));
            }
          }
          context.addInputData(orchestrationContext, orchestrationContext.getType().getType(), object);
        } catch (Throwable t) {
          throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, orchestrationContext.getType().getValue()), t)));
        }
      } else {
        context.addInputData(orchestrationContext, orchestrationContext.getType().getType(), orchestrationContext.getType().getValue());
      }
    }
  }

}
