/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.model.editor.contributions;

import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.types.Type;
import org.eclipse.egf.model.types.TypeAbstractClass;
import org.eclipse.egf.model.types.TypeClass;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * @author Thomas Guiu
 * 
 */
public class TypeEditorContributor extends AbstractTypeEditorContributor {

    public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
        // It should be a TypeAbstractClass in a non null resource
        if (object instanceof TypeAbstractClass == false || ((TypeAbstractClass) object).eResource() == null) {
            return false;
        }
        // Check Current Feature
        if (checkFeature(object, descriptor, TypesPackage.Literals.TYPE_ABSTRACT_CLASS__VALUE)) {
            // TypeClass has its own contributor see TypeClassEditorContributor
            if (object instanceof TypeClass && (((TypeClass) object).eContainer() instanceof Contract || ((TypeClass) object).eContainer() instanceof OrchestrationParameter)) {
                return false;
            }
            // TypeAbstractClass bound to an InvocationContract
            if (((TypeAbstractClass) object).eContainer() instanceof InvocationContract) {
                InvocationContract contract = (InvocationContract) ((TypeAbstractClass) object).eContainer();
                if (contract.getInvokedContract() == null || contract.getInvokedContract().getType() == null || contract.getInvokedContract().getType() instanceof TypeAbstractClass == false) {
                    return false;
                }
                Type invokedContractType = contract.getInvokedContract().getType();
                if (invokedContractType instanceof TypeClass && (invokedContractType.getValue() == null || "".equals(invokedContractType.getValue()))) { //$NON-NLS-1$
                    return false;
                }
                return invokedContractType.getType() != null;
            }
            // TypeAbstractContract bound to a Contract
            return (((TypeAbstractClass) object)).getType() != null;
        }
        return false;
    }

    @Override
    protected String getFilteredType(Object object) {
        // TypeAbstractClass bound to an InvocationContract
        if (((TypeAbstractClass) object).eContainer() instanceof InvocationContract) {
            TypeAbstractClass invokedContractType = (TypeAbstractClass) ((InvocationContract) ((TypeAbstractClass) object).eContainer()).getInvokedContract().getType();
            if (invokedContractType instanceof TypeClass) {
                return invokedContractType.getValue();
            }
            return invokedContractType.getType().getName();
        }
        // TypeAbstractContract bound to a Contract
        return (((TypeAbstractClass) object)).getType().getName();
    }

    @Override
    protected String getValue(Object object) {
        return ((TypeAbstractClass) object).getValue();
    }

}
