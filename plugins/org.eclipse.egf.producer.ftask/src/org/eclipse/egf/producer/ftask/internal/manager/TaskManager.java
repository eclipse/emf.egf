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
package org.eclipse.egf.producer.ftask.internal.manager;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.context.ActivityProductionContextProducer;
import org.eclipse.egf.producer.ftask.EGFProducerFtaskPlugin;
import org.eclipse.egf.producer.ftask.internal.context.TaskProductionContext;
import org.eclipse.egf.producer.internal.manager.ActivityManager;
import org.eclipse.egf.producer.manager.IModelElementManager;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskManager extends ActivityManager<Task> {

    public TaskManager(Task Task) throws InvocationException {
        super(Task);
    }

    public TaskManager(Bundle bundle, Task Task) throws InvocationException {
        super(bundle, Task);
    }

    public <T extends Invocation> TaskManager(IModelElementManager<T, InvocationContract> parent, Task task) throws InvocationException {
        super(parent, task);
    }

    @Override
    @SuppressWarnings("unchecked")
    public TaskProductionContext getInternalProductionContext() throws InvocationException {
        if (_productionContext == null) {
            @SuppressWarnings("rawtypes")
            ActivityProductionContextProducer producer = null;
            try {
                producer = EGFProducerPlugin.getActivityProductionContextProducer(getElement());
            } catch (Throwable t) {
                throw new InvocationException(t);
            }
            if (getParent() != null) {
                _productionContext = producer.createActivityProductionContext(getParent().getProductionContext(), getProjectBundleSession(), getElement());
            } else {
                _productionContext = producer.createActivityProductionContext(getProjectBundleSession(), getElement());
            }
        }
        return (TaskProductionContext) _productionContext;
    }

    @Override
    public void dispose() throws InvocationException {
        super.dispose();
    }

    @Override
    protected BasicDiagnostic checkInputElement(boolean runtime) throws InvocationException {
        BasicDiagnostic diagnostic = super.checkInputElement(runtime);
        if (getElement().getImplementationValue() == null) {
            diagnostic.add(new BasicDiagnostic(Diagnostic.ERROR, EGFProducerPlugin.getDefault().getPluginID(), 0, NLS.bind("Task Implementation is mandatory for ''{0}''", EMFHelper.getText(getElement())), //$NON-NLS-1$
                    new Object[] {
                        getElement()
                    }));
        }
        return diagnostic;
    }

    public int getSteps() throws InvocationException {
        if (getElement().getImplementationValue() != null) {
            return 1;
        }
        return 0;
    }

    public List<Activity> getActivities() throws InvocationException {
        List<Activity> activities = new UniqueEList<Activity>(1);
        activities.add(getElement());
        return activities;
    }

    public Diagnostic invoke(IProgressMonitor monitor) throws InvocationException {
        SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, getName()), 100);
        // Check Input
        BasicDiagnostic diagnostic = checkInputElement(true);
        // Do not further process if we are on error
        if (diagnostic.getSeverity() != Diagnostic.ERROR) {
            // Invoke
            try {
                EGFProducerFtaskPlugin.getTaskProductionInvocationFactory().createInvocation(getBundle(), getInternalProductionContext(), getElement()).invoke(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
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
        return diagnostic;
    }

}
