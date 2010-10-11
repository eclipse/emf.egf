/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.context.ActivityProductionContextProducer;
import org.eclipse.egf.producer.internal.context.FactoryComponentProductionContext;
import org.eclipse.egf.producer.manager.IModelElementManager;
import org.eclipse.egf.producer.manager.OrchestrationManagerProducer;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentManager extends ActivityManager<FactoryComponent> {

    private IModelElementManager<Orchestration, OrchestrationParameter> _orchestrationManager;

    public FactoryComponentManager(FactoryComponent factoryComponent) throws InvocationException {
        super(factoryComponent);
    }

    public FactoryComponentManager(Bundle bundle, FactoryComponent factoryComponent) throws InvocationException {
        super(bundle, factoryComponent);
    }

    public <T extends Invocation> FactoryComponentManager(IModelElementManager<T, InvocationContract> parent, FactoryComponent factoryComponent) throws InvocationException {
        super(parent, factoryComponent);
    }

    @Override
    @SuppressWarnings("unchecked")
    public FactoryComponentProductionContext getInternalProductionContext() throws InvocationException {
        if (_productionContext == null) {
            ActivityProductionContextProducer<FactoryComponent> producer = null;
            try {
                producer = EGFProducerPlugin.getActivityProductionContextProducer(getElement());
            } catch (Throwable t) {
                throw new InvocationException(t);
            }
            if (getParent() != null) {
                _productionContext = producer.createActivityProductionContext((IProductionContext<Invocation, InvocationContract>) getParent().getProductionContext(), getProjectBundleSession(), getElement());
            } else {
                _productionContext = producer.createActivityProductionContext(getProjectBundleSession(), getElement());
            }
        }
        return (FactoryComponentProductionContext) _productionContext;
    }

    public IModelElementManager<Orchestration, OrchestrationParameter> getOrchestrationManager() throws InvocationException {
        if (_orchestrationManager == null && getElement().getOrchestration() != null) {
            OrchestrationManagerProducer<Orchestration> producer = null;
            try {
                producer = EGFProducerPlugin.getOrchestrationProducer(getElement().getOrchestration());
            } catch (Throwable t) {
                throw new InvocationException(t);
            }
            _orchestrationManager = producer.createOrchestrationManager(this, getElement().getOrchestration());
        }
        return _orchestrationManager;
    }

    public List<Activity> getActivities() throws InvocationException {
        // Retrieve Activities
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
        BasicDiagnostic diagnostic = checkInputElement(false);
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
        SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, getName()), 1);
        // Check Input
        BasicDiagnostic diagnostic = checkInputElement(true);
        if (diagnostic.getSeverity() != Diagnostic.ERROR) {
            IModelElementManager<Orchestration, OrchestrationParameter> orchestrationManager = getOrchestrationManager();
            if (orchestrationManager != null) {
                // Invoke
                diagnostic.add(orchestrationManager.invoke(subMonitor.newChild(1, SubMonitor.SUPPRESS_NONE)));
                // Check Output
                checkOutputElement(diagnostic);
                if (monitor.isCanceled()) {
                    throw new OperationCanceledException();
                }
            }
        }
        return diagnostic;
    }

}
