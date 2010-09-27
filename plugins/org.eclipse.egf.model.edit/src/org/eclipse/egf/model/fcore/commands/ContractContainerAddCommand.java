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
package org.eclipse.egf.model.fcore.commands;

import java.util.Collection;

import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ContractContainerAddCommand extends AddCommand {

    /**
     * This constructs a primitive command to insert a collection of values into the specified many-valued feature of the owner.
     */
    public ContractContainerAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Collection<?> collection, int index) {
        super(domain, owner, feature, collection, index);
    }

    @Override
    protected boolean prepare() {
        boolean result = super.prepare();
        if (result == false) {
            return false;
        }
        if (owner instanceof ContractContainer == false) {
            return true;
        }
        if (feature != FcorePackage.Literals.CONTRACT_CONTAINER__CONTRACTS) {
            return true;
        }
        ContractContainer contractContainer = (ContractContainer) owner;
        if (contractContainer.getActivity() == null) {
            return true;
        }
        if (contractContainer.getActivity() instanceof FactoryComponent) {
            for (Object object : collection) {
                if (object instanceof FactoryComponentContract == false) {
                    return false;
                }
            }
        } else {
            for (Object object : collection) {
                if (object instanceof FactoryComponentContract) {
                    return false;
                }
            }
        }
        return true;
    }

}
