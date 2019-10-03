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

import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.InvocationContractContainer;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

public final class RemoveInvocationContractContainerInvocationContracts extends CompoundCommand {

    /**
     * This caches the label.
     */
    protected static final String LABEL = EMFEditPlugin.INSTANCE.getString("_UI_RemoveCommand_label"); //$NON-NLS-1$

    /**
     * This caches the description.
     */
    protected static final String DESCRIPTION = EMFEditPlugin.INSTANCE.getString("_UI_RemoveCommand_description"); //$NON-NLS-1$  

    /**
     * Current Editing Domain.
     */
    private EditingDomain _editingDomain;

    /**
     * Current InvocationContractContainer
     */
    private InvocationContractContainer _invocationContractContainer;

    /**
     * The removed objects.
     */
    private Collection<?> _removedObjects;

    /**
     * Constructor.
     * 
     * @param editingDomain
     * @param invocationContractContainer
     * @param removedObjects
     */
    public RemoveInvocationContractContainerInvocationContracts(EditingDomain editingDomain, InvocationContractContainer invocationContractContainer, Collection<?> removedObjects) {
        super(LABEL, DESCRIPTION);
        _editingDomain = editingDomain;
        _invocationContractContainer = invocationContractContainer;
        _removedObjects = removedObjects;
    }

    /**
     * Constructor.
     * 
     * @param label
     * @param description
     * @param editingDomain
     * @param invocationContractContainer
     * @param removedObjects
     */
    public RemoveInvocationContractContainerInvocationContracts(String label, String description, EditingDomain editingDomain, InvocationContractContainer invocationContractContainer, Collection<?> removedObjects) {
        super(label, description);
        _editingDomain = editingDomain;
        _invocationContractContainer = invocationContractContainer;
        _removedObjects = removedObjects;
    }

    @Override
    protected boolean prepare() {
        for (Object removedObject : _removedObjects) {
            if (removedObject instanceof InvocationContract == false) {
                continue;
            }
            InvocationContract contract = (InvocationContract) removedObject;
            // Reset source
            if (contract.getSourceInvocationContract() != null) {
                // This will reset the eOpposite accordingly
                append(new SetCommand(_editingDomain, contract, FcorePackage.Literals.INVOCATION_CONTRACT__SOURCE_INVOCATION_CONTRACT, null));
            }
            // Reset target
            if (contract.getTargetInvocationContract() != null) {
                // This will reset the eOpposite accordingly
                append(new RemoveCommand(_editingDomain, contract, FcorePackage.Literals.INVOCATION_CONTRACT__TARGET_INVOCATION_CONTRACT, contract.getTargetInvocationContract()));
            }
        }
        // Remove InvocationContracts
        append(new RemoveCommand(_editingDomain, _invocationContractContainer, FcorePackage.Literals.INVOCATION_CONTRACT_CONTAINER__INVOCATION_CONTRACTS, _removedObjects));
        return super.prepare();
    }

}
