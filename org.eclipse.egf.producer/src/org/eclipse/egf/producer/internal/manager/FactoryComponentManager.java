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

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.context.ActivityProductionContextProducer;
import org.eclipse.egf.producer.context.IFactoryComponentProductionContext;
import org.eclipse.egf.producer.internal.context.FactoryComponentProductionContext;
import org.eclipse.egf.producer.internal.context.ProducerContextFactory;
import org.eclipse.egf.producer.manager.IFactoryComponentManager;
import org.eclipse.egf.producer.manager.IInvocationManager;
import org.eclipse.egf.producer.manager.IOrchestrationManager;
import org.eclipse.egf.producer.manager.OrchestrationManagerProducer;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.UniqueEList;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentManager extends ActivityManager implements IFactoryComponentManager {

  private IOrchestrationManager _orchestrationManager;

  public FactoryComponentManager(FactoryComponent factoryComponent) throws InvocationException {
    super(factoryComponent);
  }

  public FactoryComponentManager(Bundle bundle, FactoryComponent factoryComponent) {
    super(bundle, factoryComponent);
  }

  public FactoryComponentManager(IInvocationManager parent, FactoryComponent factoryComponent) throws InvocationException {
    super(parent, factoryComponent);
  }

  @Override
  public FactoryComponent getElement() {
    return (FactoryComponent) super.getElement();
  }

  @Override
  public IFactoryComponentProductionContext getProductionContext() {
    return (IFactoryComponentProductionContext) super.getProductionContext();
  }

  @Override
  public FactoryComponentProductionContext getInternalProductionContext() throws InvocationException {
    if (_productionContext == null) {
      if (getParent() != null) {
        ActivityProductionContextProducer producer = null;
        try {
          producer = EGFProducerPlugin.getActivityProductionContextProducer(getParent().getProductionContext());
        } catch (Exception e) {
          throw new InvocationException(e);
        }
        _productionContext = producer.createActivityProductionContext(getParent().getProductionContext(), getElement(), getProjectBundleSession());
      } else {
        _productionContext = ProducerContextFactory.createContext(getElement(), getProjectBundleSession());
      }
    }
    return (FactoryComponentProductionContext) _productionContext;
  }

  public IOrchestrationManager getOrchestrationManager() throws InvocationException {
    if (_orchestrationManager == null && getElement().getOrchestration() != null) {
      OrchestrationManagerProducer producer = null;
      try {
        producer = EGFProducerPlugin.getOrchestrationProducer(getElement().getOrchestration());
      } catch (Exception e) {
        throw new InvocationException(e);
      }
      _orchestrationManager = producer.createOrchestrationManager(this, getElement().getOrchestration());
    }
    return _orchestrationManager;
  }

  public List<Activity> getActivities() throws InvocationException {
    List<Activity> activities = new UniqueEList<Activity>();
    activities.add(getElement());
    if (getOrchestrationManager() != null) {
      activities.addAll(getOrchestrationManager().getActivities());
    }
    return activities;
  }

  @Override
  public void dispose() throws InvocationException {
    super.dispose();
    if (getOrchestrationManager() != null) {
      getOrchestrationManager().dispose();
    }
  }

  @Override
  public Diagnostic canInvoke() throws InvocationException {
    BasicDiagnostic diagnostic = (BasicDiagnostic) super.canInvokeElement();
    // Continue
    if (getOrchestrationManager() != null) {
      diagnostic.add(getOrchestrationManager().canInvoke());
    }
    return diagnostic;
  }

  @Override
  public void initializeContext() throws InvocationException {
    super.initializeContext();
    if (getOrchestrationManager() != null) {
      getOrchestrationManager().initializeContext();
    }
  }

  public int getSteps() throws InvocationException {
    if (getOrchestrationManager() != null) {
      return getOrchestrationManager().getSteps();
    }
    return 0;
  }

  public Diagnostic invoke(IProgressMonitor monitor) throws InvocationException {

    BasicDiagnostic diagnostic = (BasicDiagnostic) canInvokeElement();
    if (diagnostic.getSeverity() != Diagnostic.ERROR) {
      IOrchestrationManager orchestrationManager = getOrchestrationManager();
      if (orchestrationManager != null) {
        // Invoke
        diagnostic.add(orchestrationManager.invoke(monitor));
        if (monitor.isCanceled()) {
          throw new OperationCanceledException();
        }
      }
    }
    return diagnostic;
  }

}
