/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.producer.internal.manager;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.domain.DomainException;
import org.eclipse.egf.domain.IDomainHelper;
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
        SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, getName()), 100);
        // Check Input
        BasicDiagnostic diagnostic = checkInputElement(true);
        // Do not further process if we are on error
        if (diagnostic.getSeverity() != Diagnostic.ERROR) {
            IModelElementManager<Orchestration, OrchestrationParameter> orchestrationManager = getOrchestrationManager();
            if (orchestrationManager != null) {
                // Invoke
                try {
                    try {
                        IDomainHelper.INSTANCE.loadDomains(getElement(), getBundle());
                        diagnostic.add(orchestrationManager.invoke(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE)));
                    } finally {
                        IDomainHelper.INSTANCE.unLoadDomains(getElement(), getBundle());
                    }
                } catch (DomainException de) {
                    throw new InvocationException(de);
                } catch (InvocationException ie) {
                    if (ie.getDiagnostic() != null) {
                        diagnostic.add(ie.getDiagnostic());
                    }
                    ie.setDiagnostic(diagnostic);
                    throw ie;
                }
                // Check Output
                checkOutputElement(diagnostic);
                // Monitor
                if (monitor.isCanceled()) {
                    throw new OperationCanceledException();
                }
            }
        }
        return diagnostic;
    }

}
