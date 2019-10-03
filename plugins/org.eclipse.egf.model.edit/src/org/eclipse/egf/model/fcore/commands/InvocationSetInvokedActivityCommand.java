/**
 * 
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
 * 
 */
package org.eclipse.egf.model.fcore.commands;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

public final class InvocationSetInvokedActivityCommand extends SetCommand {

    /**
     * state whether or not we have something to process
     */
    private boolean _process;

    /**
     * This cache InvokedContracts 
     */
    private Map<InvocationContract, Contract[]> _contracts;

    /**
     * Current Invocation
     */
    private Invocation _invocation;

    /**
     * The new Activity
     */
    private Activity _newActivity;

    /**
     * Constructor.
     * 
     * @param domain
     * @param invocation
     * @param newActivity
     */
    public InvocationSetInvokedActivityCommand(EditingDomain domain, Invocation invocation, Activity newActivity) {
        super(domain, invocation, FcorePackage.Literals.INVOCATION__INVOKED_ACTIVITY, newActivity);
        _invocation = invocation;
        _newActivity = newActivity;
        _contracts = new HashMap<InvocationContract, Contract[]>();
    }

    @Override
    protected boolean prepare() {
        // Ignore
        if (_invocation.getInvokedActivity() == null || _newActivity == null || _invocation.getInvokedActivity() == _newActivity) {
            return super.prepare();
        }
        // Store previous InvokedContract
        if (_invocation.getInvocationContractContainer() != null) {
            LOOP: for (InvocationContract invocationContract : _invocation.getInvocationContractContainer().getInvocationContracts()) {
                // Store previous InvokedContract
                Contract[] contracts = new Contract[] {
                        null, null
                };
                contracts[0] = invocationContract.getInvokedContract();
                _contracts.put(invocationContract, contracts);
                // Locate a compatible contract if available
                for (Contract invokedContract : _newActivity.getContracts()) {
                    // Ignore
                    if (invokedContract.getType() == null) {
                        continue;
                    }
                    // Name and Type Matching, as soon a valid condition has been found, we do not further process
                    // Model validation will ensure that everything is correct
                    if (invokedContract.getName() != null && invokedContract.getName().equals(invocationContract.getInvokedContract().getName())) {
                        // Valid InvokedContract Type
                        if (invocationContract.getType() != null) {
                            if (invocationContract.getType().isCompatible(invokedContract.getType())) {
                                contracts[1] = invokedContract;
                                continue LOOP;
                            }
                            // Type are not compatible, will be reset to null
                            continue;
                        }
                        // Valid FactoryComponentContract Type
                        if (invocationContract.getFactoryComponentContract() != null && invocationContract.getFactoryComponentContract().getType() != null) {
                            if (invokedContract.getType().isCompatible(invocationContract.getFactoryComponentContract().getType())) {
                                contracts[1] = invokedContract;
                                continue LOOP;
                            }
                            // Type are not compatible, will be reset to null
                            continue;
                        }
                        // Valid OrchestrationParameter Type
                        if (invocationContract.getOrchestrationParameter() != null && invocationContract.getOrchestrationParameter().getType() != null) {
                            if (invokedContract.getType().isCompatible(invocationContract.getOrchestrationParameter().getType()) == false) {
                                contracts[1] = invokedContract;
                                continue LOOP;
                            }
                            // Type are not compatible, will be reset to null
                            continue;
                        }
                        // Valid SourceInvocationContract Type
                        if (invocationContract.getSourceInvocationContract() != null && invocationContract.getSourceInvocationContract().getInvokedContract() != null && invocationContract.getSourceInvocationContract().getInvokedContract().getType() != null) {
                            Type sourceType = invocationContract.getSourceInvocationContract().getType();
                            if (sourceType == null) {
                                sourceType = invocationContract.getSourceInvocationContract().getInvokedContract().getType();
                            }
                            if (invokedContract.getType().isCompatible(sourceType) == false) {
                                contracts[1] = invokedContract;
                                continue LOOP;
                            }
                            // Type are not compatible, will be reset to null
                            continue;
                        }
                    }
                }
            }
            _process = true;
        }
        return super.prepare();
    }

    @Override
    public Collection<?> doGetAffectedObjects() {
        Collection<EObject> affectedObjects = new UniqueEList<EObject>();
        affectedObjects.add(owner);
        affectedObjects.addAll(_contracts.keySet());
        return affectedObjects;
    }

    @Override
    public void doExecute() {
        // Ignore
        if (_process == false) {
            super.doExecute();
            return;
        }
        // process InvokedContracts
        for (Map.Entry<InvocationContract, Contract[]> entry : _contracts.entrySet()) {
            entry.getKey().setInvokedContract(entry.getValue()[1]);
        }
        super.doExecute();
    }

    @Override
    public void doUndo() {
        // Ignore
        if (_process == false) {
            super.doUndo();
            return;
        }
        // process InvokedContracts
        for (Map.Entry<InvocationContract, Contract[]> entry : _contracts.entrySet()) {
            entry.getKey().setInvokedContract(entry.getValue()[0]);
        }
        super.doUndo();
    }

    @Override
    public void doRedo() {
        // Ignore
        if (_process == false) {
            super.doRedo();
            return;
        }
        // process InvokedContracts
        for (Map.Entry<InvocationContract, Contract[]> entry : _contracts.entrySet()) {
            entry.getKey().setInvokedContract(entry.getValue()[1]);
        }
        super.doRedo();
    }

}
