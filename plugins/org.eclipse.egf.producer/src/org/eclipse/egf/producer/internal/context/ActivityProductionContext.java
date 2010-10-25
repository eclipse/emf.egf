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
package org.eclipse.egf.producer.internal.context;

import java.util.Collection;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.producer.context.ProductionContext;
import org.eclipse.egf.core.producer.l10n.CoreProducerMessages;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.producer.context.IActivityProductionContext;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ActivityProductionContext<P extends Activity> extends ProductionContext<P, Contract> implements IActivityProductionContext<P> {

    public ActivityProductionContext(ProjectBundleSession projectBundleSession, P element, String name) {
        super(projectBundleSession, element, name);
    }

    public <T extends Invocation> ActivityProductionContext(IProductionContext<T, InvocationContract> parent, ProjectBundleSession projectBundleSession, P element, String name) {
        super(parent, projectBundleSession, element, name);
    }

    @Override
    public boolean isSetAtRuntime(Object key) throws InvocationException {
        // Looking for a Parent Input Contract set at runtime
        if (getParent() != null) {
            return getParent().isSetAtRuntime(getContract(key, getInputValueKeys(), getName(), __inputMode));
        }
        return false;
    }

    @Override
    public Class<?> getInputValueType(Object key) throws InvocationException {
        // Looking for an Input Contract type
        return super.getInputValueType(getContract(key, getInputValueKeys(), getName(), __inputMode));
    }

    @Override
    public <R> R getInputValue(Object key, Class<R> clazz) throws InvocationException {
        // Looking for an Input Contract value
        return super.getInputValue(getContract(key, getInputValueKeys(), getName(), __inputMode), clazz);
    }

    @Override
    public Class<?> getOutputValueType(Object key) throws InvocationException {
        // Looking for an Output Contract type
        return super.getOutputValueType(getContract(key, getOutputValueKeys(), getName(), __outputMode));
    }

    @Override
    public <R> R getOutputValue(Object key, Class<R> clazz) throws InvocationException {
        // Looking for an Output Contract value
        return super.getOutputValue(getContract(key, getOutputValueKeys(), getName(), __outputMode), clazz);
    }

    @Override
    public void setOutputValue(Object key, Object value) throws InvocationException {
        // Set Contract Value
        super.setOutputValue(getContract(key, getOutputValueKeys(), getName(), __outputMode), value);
    }

    private static Contract getContract(Object key, Collection<Contract> keys, String name, String mode) throws InvocationException {
        // Usual Tests
        if (key == null) {
            throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, mode, name));
        }
        if (key instanceof String == false) {
            throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] {
                    String.class.getName(), mode, EMFHelper.getText(key), key.getClass().getName(), name
            }));
        }
        String innerName = ((String) key).trim();
        // Looking for a Contract
        Contract contract = null;
        for (Contract innerContract : keys) {
            if (innerName.equals(innerContract.getName().trim())) {
                contract = innerContract;
                break;
            }
        }
        // Contract should be known at this stage
        if (contract == null) {
            throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_key, new Object[] {
                    mode, innerName, name
            }));
        }
        // Return
        return contract;
    }

}
