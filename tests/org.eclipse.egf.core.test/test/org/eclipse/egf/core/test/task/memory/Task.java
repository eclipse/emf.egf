/**
 * Copyright (c) 2015 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.core.test.task.memory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.emf.codegen.merge.java.JMerger;

/**
 * @author Thomas Guiu
 */
public class Task implements ITaskProduction {

    private Integer _quantity;

    private Float _price;

    private Float _amount;

    private Collection<String> _parameters;

    @SuppressWarnings("unchecked")
    public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
        _quantity = context.getInputValue("quantity", Integer.class); //$NON-NLS-1$
        _price = context.getInputValue("price", Float.class); //$NON-NLS-1$
        _parameters = context.getInputValue("parameters", Collection.class); //$NON-NLS-1$
        context.getOutputValue("jmerger", JMerger.class); //$NON-NLS-1$
    }

    public void doExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
        _amount = _quantity * _price;
    }

    public void postExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
        context.setOutputValue("amount", _amount); //$NON-NLS-1$  		  
        context.setOutputValue("jmerger", new JMerger()); //$NON-NLS-1$
        _parameters = new ArrayList<String>();
        _parameters.add("param1"); //$NON-NLS-1$
        _parameters.add("param2"); //$NON-NLS-1$
        context.setOutputValue("parameters", _parameters); //$NON-NLS-1$
    }

}
