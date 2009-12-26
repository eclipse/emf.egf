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
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.context.IFactoryComponentProductionContext;
import org.eclipse.egf.producer.internal.context.FactoryComponentProductionContext;
import org.eclipse.egf.producer.internal.context.ProducerContextFactory;
import org.eclipse.egf.producer.manager.IModelElementProducerManager;
import org.eclipse.egf.producer.orchestration.OrchestrationProducer;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentManager extends ActivityManager {

  private IModelElementProducerManager _orchestrationManager;

  public FactoryComponentManager(FactoryComponent factoryComponent) throws InvocationException {
    super(factoryComponent);
  }

  public FactoryComponentManager(Bundle bundle, FactoryComponent factoryComponent) throws InvocationException {
    super(bundle, factoryComponent);
  }

  public FactoryComponentManager(IModelElementProducerManager parent, FactoryComponent factoryComponent) throws InvocationException {
    super(parent, factoryComponent);
  }

  @Override
  public FactoryComponent getElement() {
    return (FactoryComponent) super.getElement();
  }

  @Override
  public IFactoryComponentProductionContext getProductionContext() {
    return getInternalProductionContext();
  }

  @Override
  public FactoryComponentProductionContext getInternalProductionContext() {
    if (_productionContext == null) {
      _productionContext = ProducerContextFactory.createContext(getElement(), getProjectBundleSession());
    }
    return (FactoryComponentProductionContext) _productionContext;
  }

  public IModelElementProducerManager getOrchestrationManager() throws InvocationException {
    if (_orchestrationManager == null && getElement().getOrchestration() != null) {
      OrchestrationProducer producer = null;
      try {
        producer = EGFProducerPlugin.getOrchestrationProducer(getElement().getOrchestration());
      } catch (Exception e) {
        throw new InvocationException(e);
      }
      _orchestrationManager = producer.createManager(this, getElement().getOrchestration());
    }
    return _orchestrationManager;
  }

  public int getSteps() throws InvocationException {
    if (getOrchestrationManager() != null) {
      return getOrchestrationManager().getSteps();
    }
    return 0;
  }

  public void invoke(IProgressMonitor monitor) throws InvocationException {
    IModelElementProducerManager orchestrationManager = getOrchestrationManager();
    if (orchestrationManager != null) {
      try {
        orchestrationManager.invoke(monitor);
        if (monitor.isCanceled()) {
          throw new OperationCanceledException();
        }
      } finally {
        if (getParent() == null) {
          try {
            dispose();
          } catch (CoreException ce) {
            throw new InvocationException(ce);
          }
        }
      }
    }
  }

}
