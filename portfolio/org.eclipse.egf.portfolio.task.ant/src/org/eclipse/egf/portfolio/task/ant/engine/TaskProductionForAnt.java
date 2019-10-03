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
package org.eclipse.egf.portfolio.task.ant.engine;

import java.util.Vector;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;

/**
 * @author xiaoru chen
 * 
 */
public class TaskProductionForAnt extends Task {

    Vector<WriteOUT> writeTasks = new Vector<WriteOUT>();

    Vector<ReadIN> readTasks = new Vector<ReadIN>();

    @Override
    public void execute() throws BuildException {
        super.execute();
        try {
            writeContracts();
            readContracts();
        } catch (Exception e) {
            throw new BuildException(e.getMessage());
        }
    }

    public ITaskProductionContext getContext() {
        Object context = getProject().getReference(AntScriptEngine.TASK_PRODUCTION_CONTEXT);
        // Get the TaskProductionContext from project.
        if (context != null && context instanceof ITaskProductionContext) {
            return (ITaskProductionContext) context;
        }
        return null;
    }

    public ReadIN createReadIN() {
        ReadIN read = new ReadIN();
        readTasks.add(read);
        return read;
    }

    public WriteOUT createWriteOUT() {
        WriteOUT write = new WriteOUT();
        writeTasks.add(write);
        return write;
    }

    /**
     * To read the IN contracts from the task.
     * 
     * @throws Exception
     */
    private void readContracts() throws Exception {
        for (ReadIN read : readTasks) {
            doRead(read);
        }
    }

    /**
     * To write the OUT contracts from the task.
     */
    private void writeContracts() throws Exception {
        for (WriteOUT write : writeTasks) {
            doWrite(write);
        }
    }

    /**
     * To read the IN contract from the task.
     * 
     * @param read
     *            The detail information about read task.
     * @throws Exception
     */
    private void doRead(ReadIN read) throws Exception {
        String type = read.getType();
        String name = read.getName();
        ITaskProductionContext context = getContext();
        if (name != null && context != null) {
            Class<?> inputValueType = null;
            if (type == null) {
                inputValueType = context.getInputValueType(name);
            } else {
                inputValueType = DataConvert.getType(type);
            }
            Object inputValue = context.getInputValue(name, inputValueType);
            getProject().setProperty(name, inputValue.toString());
        }
    }

    /**
     * To write the OUT contract from the task.
     * 
     * @param write
     *            The detail information about write task.
     */
    private void doWrite(WriteOUT write) throws Exception {
        String type = write.getType();
        String value = write.getValue();
        String name = write.getName();
        ITaskProductionContext context = getContext();
        if (name != null && value != null && context != null) {
            if (type == null) {
                Class<?> outputValueType = context.getOutputValueType(name);
                String className = outputValueType.getName();
                String typeName = outputValueType.getName().substring(className.lastIndexOf(".") + 1);
                type = "type:" + typeName;
            }
            context.setOutputValue(name, DataConvert.getConvertVaule(type, value));
        }
    }

    /**
     * The ReadIN class is used to record the name of the contract which user
     * want to read.
     * 
     */
    public class ReadIN {
        /*
         * The name of the contract.
         */
        private String name;
        /*
         * The type of the contract value.
         * It support the basic types:
         * 'type:String','type:Long','type:Character','type:Boolean','type:Class"'.
         */
        private String type;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    /**
     * The WriteOUT class is used to record the information of write output
     * contract task.
     * 
     */
    public class WriteOUT extends ReadIN {
        /*
         * The giving value from the ant script which will be write after
         * fomate.
         */
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
