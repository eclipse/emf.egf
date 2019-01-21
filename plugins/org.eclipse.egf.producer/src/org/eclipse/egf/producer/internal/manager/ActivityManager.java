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

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.ProductionContext;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.helper.ActivityCycleFinder;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.egf.producer.manager.IModelElementManager;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ActivityManager<P extends Activity> extends ModelElementManager<P, Contract> implements IActivityManager<P> {

    public ActivityManager(P activity) throws InvocationException {
        super(activity);
        // Diagnose Cycle
        ActivityCycleFinder finder = new ActivityCycleFinder(activity);
        ModelElement element = finder.getFirstRepetition();
        if (element != null) {
            throw new InvocationException(NLS.bind("Activity cycle detected in ''{0}''", EMFHelper.getText(element))); //$NON-NLS-1$
        }
    }

    public ActivityManager(Bundle bundle, P activity) throws InvocationException {
        super(bundle, activity);
        // Diagnose Cycle
        ActivityCycleFinder finder = new ActivityCycleFinder(activity);
        ModelElement element = finder.getFirstRepetition();
        if (element != null) {
            throw new InvocationException(NLS.bind("Activity cycle detected in ''{0}''", EMFHelper.getText(element))); //$NON-NLS-1$
        }
    }

    public <M extends Invocation> ActivityManager(IModelElementManager<M, InvocationContract> parent, P activity) throws InvocationException {
        super(parent, activity);
    }

    @Override
    protected BasicDiagnostic checkInputElement(boolean runtime) throws InvocationException {
        BasicDiagnostic diagnostic = getDiagnostic(getElement(), runtime);
        BasicDiagnostic containerDiagnostic = null;
        ProductionContext<P, Contract> context = getInternalProductionContext();
        // Diagnose Mandatory In and In_Out Contract
        for (Contract contract : getElement().getContracts(ContractMode.IN)) {
            if (contract.isMandatory()) {
                // Check whether or not we face a contract set at runtime
                if (runtime == false && context.isSetAtRuntime(contract.getName())) {
                    continue;
                }
                // Check Mandatory Value
                Object value = null;
                try {
                    value = context.getInputValue(contract.getName(), contract.getType().getType());
                } catch (InvocationException ie) {
                    if (ie.getCause() != null) {
                        throw ie;
                    }
                }
                if (value == null) {
                    if (containerDiagnostic == null) {
                        containerDiagnostic = getDiagnostic(contract.getContractContainer(), runtime);
                    }
                    containerDiagnostic.add(new BasicDiagnostic(Diagnostic.ERROR, EGFProducerPlugin.getDefault().getPluginID(), 0, NLS.bind("Value is mandatory for ''{0}''", EMFHelper.getText(contract)), //$NON-NLS-1$
                            new Object[] {
                                contract
                            }));
                }
            }
        }
        // containerDiagnostic should be added at the end otherwise, the severity code is not propagated to the parent.
        if (containerDiagnostic != null) {
            diagnostic.add(containerDiagnostic);
        }
        return diagnostic;
    }

    @Override
    protected BasicDiagnostic checkOutputElement(BasicDiagnostic diagnostic) throws InvocationException {
        BasicDiagnostic containerDiagnostic = null;
        ProductionContext<P, Contract> context = getInternalProductionContext();
        // Diagnose Mandatory Out and In_Out Contract
        for (Contract contract : getElement().getContracts(ContractMode.OUT)) {
            if (contract.isMandatory()) {
                // Check Mandatory Value
                Object value = null;
                try {
                    value = context.getOutputValue(contract.getName(), contract.getType().getType());
                } catch (InvocationException ie) {
                    if (ie.getCause() != null) {
                        throw ie;
                    }
                }
                if (value == null) {
                    if (containerDiagnostic == null) {
                        containerDiagnostic = getDiagnostic(contract.getContractContainer(), true);
                    }
                    containerDiagnostic.add(new BasicDiagnostic(Diagnostic.ERROR, EGFProducerPlugin.getDefault().getPluginID(), 0, NLS.bind(ProducerMessages.ActivityManager_mandatory_value, EMFHelper.getText(contract)), new Object[] {
                        contract
                    }));
                }
            }
        }
        // containerDiagnostic should be added at the end otherwise, the severity code is not propagated to the parent.
        if (containerDiagnostic != null) {
            diagnostic.add(containerDiagnostic);
        }
        return diagnostic;
    }

    @Override
    public void initializeContext() throws InvocationException {
        // Get Context
        ProductionContext<P, Contract> context = getInternalProductionContext();
        // Clear Context
        context.clear();
        // Set Context
        for (Contract contract : getElement().getContracts()) {
            // Should not happen, anyway ignore
            if (contract.getType() == null) {
                continue;
            }
            // Populate
            ModelElementManager.populateContext(context, getBundle(), contract, contract.getMode(), contract.getType(), contract.getType().getValue());
        }
    }

}
