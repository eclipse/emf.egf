/**
 * <copyright>
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
 * </copyright>
 */
package org.eclipse.egf.example.task.ant.tasks;

import java.util.ArrayList;

import org.apache.tools.ant.BuildException;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.portfolio.task.ant.engine.TaskProductionForAnt;
import org.eclipse.emf.codegen.merge.java.JMerger;

/**
 * @author xiaoru chen
 * 
 */
public class WriteAndReadContractInTask extends TaskProductionForAnt {
    @Override
    public void execute() throws BuildException {
        super.execute();
        // You can write the out put contracts in there.
        try {
            ITaskProductionContext context = getContext();
            if (context != null) {
                writeOutputValue(context);
                readInputValue(context);
            }
        } catch (InvocationException e) {
            throw new BuildException(e);
        }
    }

    private void readInputValue(ITaskProductionContext context) throws InvocationException {
        // Do some reading operation on contracts.
        ArrayList inputValue = context.getInputValue("input_parameter_collection", ArrayList.class);
        inputValue.add("item1");
    }

    private void writeOutputValue(ITaskProductionContext context) throws InvocationException {
        // Do some writing operation on contracts.
        JMerger jMerger = new JMerger();
        context.setOutputValue("output_parameter_jmerger", jMerger);
    }
}
