/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.fcore.commands;

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author Xavier Maysonnave
 */
public class ActivitySetCommand extends SetCommand {

    /**
     * This constructs a primitive command to insert a collection of values into the specified many-valued feature of the owner.
     */
    public ActivitySetCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Object value) {
        super(domain, owner, feature, value);
    }

    @Override
    protected boolean prepare() {
        boolean result = super.prepare();
        if (result == false) {
            return false;
        }
        if (owner instanceof Activity == false) {
            return true;
        }
        if (feature != FcorePackage.Literals.ACTIVITY__CONTRACT_CONTAINER) {
            return true;
        }
        if (value instanceof ContractContainer == false) {
            return true;
        }
        Activity activity = (Activity) owner;
        ContractContainer contractContainer = (ContractContainer) value;
        if (contractContainer.getContracts() == null || contractContainer.getContracts().isEmpty()) {
            return true;
        }
        if (activity instanceof FactoryComponent) {
            for (Object object : contractContainer.getContracts()) {
                if (object instanceof FactoryComponentContract == false) {
                    return false;
                }
            }
        } else {
            for (Object object : contractContainer.getContracts()) {
                if (object instanceof FactoryComponentContract) {
                    return false;
                }
            }
        }
        return true;
    }

}
