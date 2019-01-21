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
package org.eclipse.egf.producer.fprod.internal.manager;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.producer.context.ProductionContext;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.fprod.internal.context.ProducerFprodContextFactory;
import org.eclipse.egf.producer.internal.manager.InvocationManager;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.egf.producer.manager.IModelElementManager;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanInvocationManager extends InvocationManager<ProductionPlan, ProductionPlanInvocation> {

    private IActivityManager<Activity> _activityManager;

    public ProductionPlanInvocationManager(IModelElementManager<ProductionPlan, OrchestrationParameter> parent, ProductionPlanInvocation element) throws InvocationException {
        super(parent, element);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ProductionContext<ProductionPlanInvocation, InvocationContract> getInternalProductionContext() throws InvocationException {
        if (_productionContext == null) {
            _productionContext = ProducerFprodContextFactory.createContext((IProductionContext<ProductionPlan, OrchestrationParameter>) getParent().getProductionContext(), getProjectBundleSession(), getElement());
        }
        return (ProductionContext<ProductionPlanInvocation, InvocationContract>) _productionContext;
    }

    public IActivityManager<Activity> getActivityManager() throws InvocationException {
        if (_activityManager == null && getElement().getInvokedActivity() != null) {
            ActivityManagerProducer<Activity> producer = null;
            try {
                producer = EGFProducerPlugin.getActivityManagerProducer(getElement().getInvokedActivity());
            } catch (Throwable t) {
                throw new InvocationException(t);
            }
            _activityManager = producer.createActivityManager(this, getElement().getInvokedActivity());
        }
        return _activityManager;
    }

    @Override
    public void dispose() throws InvocationException {
        super.dispose();
        if (getActivityManager() != null) {
            getActivityManager().dispose();
        }
    }

    @Override
    public Diagnostic canInvoke() throws InvocationException {
        BasicDiagnostic diagnostic = checkInputElement(false);
        if (getActivityManager() != null) {
            diagnostic.add(getActivityManager().canInvoke());
        }
        return diagnostic;
    }

    @Override
    public void initializeContext() throws InvocationException {
        super.initializeContext();
        if (getActivityManager() != null) {
            getActivityManager().initializeContext();
        }
    }

    public int getSteps() throws InvocationException {
        if (getActivityManager() != null) {
            return getActivityManager().getSteps();
        }
        return 0;
    }

    public Diagnostic invoke(IProgressMonitor monitor) throws InvocationException {
        SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, getName()), 100);
        // Check Input
        BasicDiagnostic diagnostic = checkInputElement(true);
        // Do not further process if we are on error
        if (diagnostic.getSeverity() != Diagnostic.ERROR) {
            IActivityManager<Activity> activityManager = getActivityManager();
            if (activityManager != null) {
                // Invoke
                try {
                    diagnostic.add(activityManager.invoke(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE)));
                } catch (InvocationException ie) {
                    if (ie.getDiagnostic() != null) {
                        diagnostic.add(ie.getDiagnostic());
                    }
                    ie.setDiagnostic(diagnostic);
                    throw ie;
                }
                // Monitor
                if (monitor.isCanceled()) {
                    throw new OperationCanceledException();
                }
            }
        }
        return diagnostic;
    }

}
