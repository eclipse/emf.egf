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
package org.eclipse.egf.core.test.context.task.memory;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.test.EGFCoreTestPlugin;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.ftask.FtaskFactory;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.types.TypeByte;
import org.eclipse.egf.model.types.TypeCharacter;
import org.eclipse.egf.model.types.TypeClass;
import org.eclipse.egf.model.types.TypeCollection;
import org.eclipse.egf.model.types.TypeDouble;
import org.eclipse.egf.model.types.TypeFloat;
import org.eclipse.egf.model.types.TypeInteger;
import org.eclipse.egf.model.types.TypeLong;
import org.eclipse.egf.model.types.TypeShort;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.ftask.manager.TaskManagerFactory;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.emf.codegen.merge.java.JMerger;

public class ContextTaskMemory extends TestCase {

    public static Test suite() {
        return new TestSuite(ContextTaskMemory.class);
    }

    public void testContractH1() throws Exception {

        Task task = FtaskFactory.eINSTANCE.createTask();
        task.setImplementation("org.eclipse.egf.example.task.h1.H1"); //$NON-NLS-1$
        task.setKind("java"); //$NON-NLS-1$

        ActivityManagerProducer<Task> producer = EGFProducerPlugin.getActivityManagerProducer(task);

        IActivityManager<?> manager = producer.createActivityManager(EGFCoreTestPlugin.getDefault().getBundle(), task);
        try {
            manager.initializeContext();
            manager.invoke(new NullProgressMonitor());
        } catch (InvocationException ie) {
            return;
        } catch (Exception e) {
            EGFCoreTestPlugin.getDefault().logError(e);
            fail(e.getMessage());
            return;
        } finally {
            try {
                manager.dispose();
            } catch (Exception e) {
                EGFCoreTestPlugin.getDefault().logError(e);
                fail(e.getMessage());
                return;
            }
        }

        fail("InvocationException is expected"); //$NON-NLS-1$

    }

    public void testOutputContractClassNotTheSameH1() throws Exception {

        Task task = FtaskFactory.eINSTANCE.createTask();
        task.setImplementation("org.eclipse.egf.example.task.h1.H1"); //$NON-NLS-1$
        task.setKind("java"); //$NON-NLS-1$

        ContractContainer contracts = FcoreFactory.eINSTANCE.createContractContainer();
        task.eSet(FcorePackage.Literals.ACTIVITY__CONTRACT_CONTAINER, contracts);

        Contract quantity = FcoreFactory.eINSTANCE.createContract();
        quantity.setName("quantity"); //$NON-NLS-1$
        quantity.setMode(ContractMode.IN);
        contracts.getContracts().add(quantity);

        TypeInteger quantityType = TypesFactory.eINSTANCE.createTypeInteger();
        quantityType.setValue(100);
        quantity.eSet(FcorePackage.Literals.CONTRACT__TYPE, quantityType);

        Contract price = FcoreFactory.eINSTANCE.createContract();
        price.setName("price"); //$NON-NLS-1$
        price.setMode(ContractMode.IN);
        contracts.getContracts().add(price);

        TypeFloat priceType = TypesFactory.eINSTANCE.createTypeFloat();
        priceType.setValue(new Float("10.5")); //$NON-NLS-1$    
        price.eSet(FcorePackage.Literals.CONTRACT__TYPE, priceType);

        Contract parameters = FcoreFactory.eINSTANCE.createContract();
        parameters.setName("parameters"); //$NON-NLS-1$
        parameters.setMode(ContractMode.IN_OUT);
        contracts.getContracts().add(parameters);

        TypeCollection parametersType = TypesFactory.eINSTANCE.createTypeCollection();
        parametersType.setValue("java.util.ArrayList"); //$NON-NLS-1$
        parameters.eSet(FcorePackage.Literals.CONTRACT__TYPE, parametersType);

        Contract amount = FcoreFactory.eINSTANCE.createContract();
        amount.setName("amount"); //$NON-NLS-1$
        amount.setMode(ContractMode.OUT);
        contracts.getContracts().add(amount);

        TypeFloat amountType = TypesFactory.eINSTANCE.createTypeFloat();
        amount.eSet(FcorePackage.Literals.CONTRACT__TYPE, amountType);

        Contract jmerger = FcoreFactory.eINSTANCE.createContract();
        jmerger.setName("jmerger"); //$NON-NLS-1$
        jmerger.setMode(ContractMode.OUT);
        contracts.getContracts().add(jmerger);

        TypeClass jmergerType = TypesFactory.eINSTANCE.createTypeClass();
        jmergerType.setValue("org.eclipse.emf.codegen.merge.java.JMerger"); //$NON-NLS-1$
        jmerger.eSet(FcorePackage.Literals.CONTRACT__TYPE, jmergerType);

        // Beware, we use the test plugin bundle here, the manifest should
        // import the bundle who contains the task
        // Otherwise it will fail to load it
        IActivityManager<Task> manager = TaskManagerFactory.createProductionManager(EGFCoreTestPlugin.getDefault().getBundle(), task);

        JMerger defaultValue = null;

        try {
            manager.initializeContext();
            defaultValue = manager.getProductionContext().getOutputValue("jmerger", JMerger.class); //$NON-NLS-1$      
            manager.invoke(new NullProgressMonitor());
        } catch (Exception e) {
            EGFCoreTestPlugin.getDefault().logError(e);
            fail(e.getMessage());
            return;
        } finally {
            try {
                manager.dispose();
            } catch (Exception e) {
                EGFCoreTestPlugin.getDefault().logError(e);
                fail(e.getMessage());
                return;
            }
        }

        assertNotSame(manager.getProductionContext().getOutputValue("jmerger", JMerger.class), defaultValue); //$NON-NLS-1$

    }

    public void testcases_ruby_1() throws Exception {
        Task task = FtaskFactory.eINSTANCE.createTask();
        task.setImplementation("platform:/plugin/org.eclipse.egf.example.task.ruby/src/org/eclipse/egf/example/task/ruby/testcases_ruby_1.rb"); //$NON-NLS-1$
        task.setKind("ruby"); //$NON-NLS-1$

        ActivityManagerProducer<Task> producer = EGFProducerPlugin.getActivityManagerProducer(task);

        IActivityManager<?> manager = producer.createActivityManager(EGFCoreTestPlugin.getDefault().getBundle(), task);
        try {
            manager.initializeContext();
            manager.invoke(new NullProgressMonitor());
        } catch (Exception e) {
            EGFCoreTestPlugin.getDefault().logError(e);
            fail(e.getMessage());
            return;
        } finally {
            try {
                manager.dispose();
            } catch (Exception e) {
                EGFCoreTestPlugin.getDefault().logError(e);
                fail(e.getMessage());
                return;
            }
        }
    }

    public void testcases_ruby_2() throws InvocationException {
        Task task = FtaskFactory.eINSTANCE.createTask();
        task.setImplementation("platform:/plugin/org.eclipse.egf.example.task.ruby/src/org/eclipse/egf/example/task/ruby/testcases_ruby_2.rb"); //$NON-NLS-1$
        task.setKind("ruby"); //$NON-NLS-1$

        ContractContainer contracts = FcoreFactory.eINSTANCE.createContractContainer();
        task.eSet(FcorePackage.Literals.ACTIVITY__CONTRACT_CONTAINER, contracts);

        // Input parameter with String type
        Contract inputParameterString = FcoreFactory.eINSTANCE.createContract();
        inputParameterString.setName("input_parameter_string"); //$NON-NLS-1$
        inputParameterString.setMode(ContractMode.IN);
        contracts.getContracts().add(inputParameterString);

        TypeString stringType = TypesFactory.eINSTANCE.createTypeString();
        stringType.setValue("hello");
        inputParameterString.eSet(FcorePackage.Literals.CONTRACT__TYPE, stringType);

        // Input parameter with Byte type
        Contract inputParameterByte = FcoreFactory.eINSTANCE.createContract();
        inputParameterByte.setName("input_parameter_byte"); //$NON-NLS-1$
        inputParameterByte.setMode(ContractMode.IN);
        contracts.getContracts().add(inputParameterByte);

        TypeByte byteType = TypesFactory.eINSTANCE.createTypeByte();
        byteType.setValue((byte) 100);
        inputParameterByte.eSet(FcorePackage.Literals.CONTRACT__TYPE, byteType);

        // Input parameter with Character type
        Contract inputParameterCharacter = FcoreFactory.eINSTANCE.createContract();
        inputParameterCharacter.setName("input_parameter_character"); //$NON-NLS-1$
        inputParameterCharacter.setMode(ContractMode.IN);
        contracts.getContracts().add(inputParameterCharacter);

        TypeCharacter characterType = TypesFactory.eINSTANCE.createTypeCharacter();
        characterType.setValue('a');
        inputParameterCharacter.eSet(FcorePackage.Literals.CONTRACT__TYPE, characterType);

        // Input parameter with Integer type
        Contract inputParameterInteger = FcoreFactory.eINSTANCE.createContract();
        inputParameterInteger.setName("input_parameter_integer"); //$NON-NLS-1$
        inputParameterInteger.setMode(ContractMode.IN);
        contracts.getContracts().add(inputParameterInteger);

        TypeInteger integerType = TypesFactory.eINSTANCE.createTypeInteger();
        integerType.setValue(10);
        inputParameterInteger.eSet(FcorePackage.Literals.CONTRACT__TYPE, integerType);

        // Input parameter with Long type
        Contract inputParameterLong = FcoreFactory.eINSTANCE.createContract();
        inputParameterLong.setName("input_parameter_long"); //$NON-NLS-1$
        inputParameterLong.setMode(ContractMode.IN);
        contracts.getContracts().add(inputParameterLong);

        TypeLong longType = TypesFactory.eINSTANCE.createTypeLong();
        longType.setValue((long) 600);
        inputParameterLong.eSet(FcorePackage.Literals.CONTRACT__TYPE, longType);

        // Input parameter with Float type
        Contract inputParameterFloat = FcoreFactory.eINSTANCE.createContract();
        inputParameterFloat.setName("input_parameter_float"); //$NON-NLS-1$
        inputParameterFloat.setMode(ContractMode.IN);
        contracts.getContracts().add(inputParameterFloat);

        TypeFloat floatType = TypesFactory.eINSTANCE.createTypeFloat();
        floatType.setValue(new Float(1.0));
        inputParameterFloat.eSet(FcorePackage.Literals.CONTRACT__TYPE, floatType);

        // Input parameter with Double type
        Contract inputParameterDouble = FcoreFactory.eINSTANCE.createContract();
        inputParameterDouble.setName("input_parameter_double"); //$NON-NLS-1$
        inputParameterDouble.setMode(ContractMode.IN);
        contracts.getContracts().add(inputParameterDouble);

        TypeDouble doubleType = TypesFactory.eINSTANCE.createTypeDouble();
        doubleType.setValue(2.0);
        inputParameterDouble.eSet(FcorePackage.Literals.CONTRACT__TYPE, doubleType);

        // Input parameter with Short type
        Contract inputParameterShort = FcoreFactory.eINSTANCE.createContract();
        inputParameterShort.setName("input_parameter_short"); //$NON-NLS-1$
        inputParameterShort.setMode(ContractMode.IN);
        contracts.getContracts().add(inputParameterShort);

        TypeShort shortType = TypesFactory.eINSTANCE.createTypeShort();
        shortType.setValue((short) 3);
        inputParameterShort.eSet(FcorePackage.Literals.CONTRACT__TYPE, shortType);

        // Input parameter with Collection type
        Contract inputParameterCollection = FcoreFactory.eINSTANCE.createContract();
        inputParameterCollection.setName("input_parameter_collection"); //$NON-NLS-1$
        inputParameterCollection.setMode(ContractMode.IN);
        contracts.getContracts().add(inputParameterCollection);

        TypeCollection collectionType = TypesFactory.eINSTANCE.createTypeCollection();
        collectionType.setValue("java.util.ArrayList");
        inputParameterCollection.eSet(FcorePackage.Literals.CONTRACT__TYPE, collectionType);

        // Input parameter with Jmerger type
        Contract inputParameterJmerger = FcoreFactory.eINSTANCE.createContract();
        inputParameterJmerger.setName("input_parameter_jmerger"); //$NON-NLS-1$
        inputParameterJmerger.setMode(ContractMode.IN);
        contracts.getContracts().add(inputParameterJmerger);

        TypeClass jmergerType = TypesFactory.eINSTANCE.createTypeClass();
        jmergerType.setValue("org.eclipse.emf.codegen.merge.java.JMerger"); //$NON-NLS-1$
        inputParameterJmerger.eSet(FcorePackage.Literals.CONTRACT__TYPE, jmergerType);

        IActivityManager<Task> manager = TaskManagerFactory.createProductionManager(EGFCoreTestPlugin.getDefault().getBundle(), task);

        try {
            manager.initializeContext();
            manager.invoke(new NullProgressMonitor());
        } catch (Exception e) {
            EGFCoreTestPlugin.getDefault().logError(e);
            fail(e.getMessage());
            return;
        } finally {
            try {
                manager.dispose();
            } catch (Exception e) {
                EGFCoreTestPlugin.getDefault().logError(e);
                fail(e.getMessage());
                return;
            }
        }

    }

    public void testcases_ruby_3() throws InvocationException {
        Task task = FtaskFactory.eINSTANCE.createTask();
        task.setImplementation("platform:/plugin/org.eclipse.egf.example.task.ruby/src/org/eclipse/egf/example/task/ruby/testcases_ruby_3.rb"); //$NON-NLS-1$
        task.setKind("ruby"); //$NON-NLS-1$

        ContractContainer contracts = FcoreFactory.eINSTANCE.createContractContainer();
        task.eSet(FcorePackage.Literals.ACTIVITY__CONTRACT_CONTAINER, contracts);

        // Output parameter with String type
        Contract outputParameterString = FcoreFactory.eINSTANCE.createContract();
        outputParameterString.setName("output_parameter_string"); //$NON-NLS-1$
        outputParameterString.setMode(ContractMode.OUT);
        contracts.getContracts().add(outputParameterString);

        TypeString stringType = TypesFactory.eINSTANCE.createTypeString();
        outputParameterString.eSet(FcorePackage.Literals.CONTRACT__TYPE, stringType);

        // Output parameter with Character type
        Contract outputParameterCharacter = FcoreFactory.eINSTANCE.createContract();
        outputParameterCharacter.setName("output_parameter_character"); //$NON-NLS-1$
        outputParameterCharacter.setMode(ContractMode.OUT);
        contracts.getContracts().add(outputParameterCharacter);

        TypeCharacter characterType = TypesFactory.eINSTANCE.createTypeCharacter();
        outputParameterCharacter.eSet(FcorePackage.Literals.CONTRACT__TYPE, characterType);

        // Output parameter with Byte type
        Contract outputParameterByte = FcoreFactory.eINSTANCE.createContract();
        outputParameterByte.setName("output_parameter_byte"); //$NON-NLS-1$
        outputParameterByte.setMode(ContractMode.OUT);
        contracts.getContracts().add(outputParameterByte);

        TypeByte byteType = TypesFactory.eINSTANCE.createTypeByte();
        outputParameterByte.eSet(FcorePackage.Literals.CONTRACT__TYPE, byteType);

        // Output parameter with Integer type
        Contract outputParameterInteger = FcoreFactory.eINSTANCE.createContract();
        outputParameterInteger.setName("output_parameter_integer"); //$NON-NLS-1$
        outputParameterInteger.setMode(ContractMode.OUT);
        contracts.getContracts().add(outputParameterInteger);

        TypeInteger integerType = TypesFactory.eINSTANCE.createTypeInteger();
        outputParameterInteger.eSet(FcorePackage.Literals.CONTRACT__TYPE, integerType);

        // Output parameter with Long type
        Contract outputParameterLong = FcoreFactory.eINSTANCE.createContract();
        outputParameterLong.setName("output_parameter_long"); //$NON-NLS-1$
        outputParameterLong.setMode(ContractMode.OUT);
        contracts.getContracts().add(outputParameterLong);

        TypeLong longType = TypesFactory.eINSTANCE.createTypeLong();
        outputParameterLong.eSet(FcorePackage.Literals.CONTRACT__TYPE, longType);

        // Output parameter with Float type
        Contract outputParameterFloat = FcoreFactory.eINSTANCE.createContract();
        outputParameterFloat.setName("output_parameter_float"); //$NON-NLS-1$
        outputParameterFloat.setMode(ContractMode.OUT);
        contracts.getContracts().add(outputParameterFloat);

        TypeFloat floatType = TypesFactory.eINSTANCE.createTypeFloat();
        outputParameterFloat.eSet(FcorePackage.Literals.CONTRACT__TYPE, floatType);

        // Output parameter with Double type
        Contract outputParameterDouble = FcoreFactory.eINSTANCE.createContract();
        outputParameterDouble.setName("output_parameter_double"); //$NON-NLS-1$
        outputParameterDouble.setMode(ContractMode.OUT);
        contracts.getContracts().add(outputParameterDouble);

        TypeDouble doubleType = TypesFactory.eINSTANCE.createTypeDouble();
        outputParameterDouble.eSet(FcorePackage.Literals.CONTRACT__TYPE, doubleType);

        // Output parameter with Short type
        Contract outputParameterShort = FcoreFactory.eINSTANCE.createContract();
        outputParameterShort.setName("output_parameter_short"); //$NON-NLS-1$
        outputParameterShort.setMode(ContractMode.OUT);
        contracts.getContracts().add(outputParameterShort);

        TypeShort shortType = TypesFactory.eINSTANCE.createTypeShort();
        outputParameterShort.eSet(FcorePackage.Literals.CONTRACT__TYPE, shortType);

        // Output parameter with Collection type
        Contract outputParameterCollection = FcoreFactory.eINSTANCE.createContract();
        outputParameterCollection.setName("output_parameter_collection"); //$NON-NLS-1$
        outputParameterCollection.setMode(ContractMode.OUT);
        contracts.getContracts().add(outputParameterCollection);

        TypeCollection collectionType = TypesFactory.eINSTANCE.createTypeCollection();
        collectionType.setValue("java.util.ArrayList");
        outputParameterCollection.eSet(FcorePackage.Literals.CONTRACT__TYPE, collectionType);

        // Output parameter with Jmerger type
        Contract outputParameterJmerger = FcoreFactory.eINSTANCE.createContract();
        outputParameterJmerger.setName("output_parameter_jmerger"); //$NON-NLS-1$
        outputParameterJmerger.setMode(ContractMode.OUT);
        contracts.getContracts().add(outputParameterJmerger);

        TypeClass jmergerType = TypesFactory.eINSTANCE.createTypeClass();
        jmergerType.setValue("org.eclipse.emf.codegen.merge.java.JMerger"); //$NON-NLS-1$
        outputParameterJmerger.eSet(FcorePackage.Literals.CONTRACT__TYPE, jmergerType);

        // Beware, we use the test plugin bundle here, the manifest should
        // import the bundle who contains the task
        // Otherwise it will fail to load it
        IActivityManager<Task> manager = TaskManagerFactory.createProductionManager(EGFCoreTestPlugin.getDefault().getBundle(), task);

        String defaultStringValue = null;
        Byte defaultByteValue = null;
        Character defaultCharacterValue = null;
        Integer defaultIntegerValue = null;
        Long defaultLongValue = null;
        Float defaultFloatValue = null;
        Double defaultDoubleValue = null;
        Short defaultShortValue = null;
        ArrayList defaultCollectionValue = null;
        JMerger defaultJMergerValue = null;

        try {
            manager.initializeContext();

            defaultStringValue = manager.getProductionContext().getOutputValue("output_parameter_string", String.class); //$NON-NLS-1$ 
            defaultByteValue = manager.getProductionContext().getOutputValue("output_parameter_byte", Byte.class); //$NON-NLS-1$ 
            defaultCharacterValue = manager.getProductionContext().getOutputValue("output_parameter_character", Character.class); //$NON-NLS-1$ 
            defaultIntegerValue = manager.getProductionContext().getOutputValue("output_parameter_integer", Integer.class); //$NON-NLS-1$ 
            defaultLongValue = manager.getProductionContext().getOutputValue("output_parameter_long", Long.class); //$NON-NLS-1$ 
            defaultFloatValue = manager.getProductionContext().getOutputValue("output_parameter_float", Float.class); //$NON-NLS-1$ 
            defaultDoubleValue = manager.getProductionContext().getOutputValue("output_parameter_double", Double.class); //$NON-NLS-1$ 
            defaultShortValue = manager.getProductionContext().getOutputValue("output_parameter_short", Short.class); //$NON-NLS-1$ 
            defaultCollectionValue = manager.getProductionContext().getOutputValue("output_parameter_collection", ArrayList.class); //$NON-NLS-1$ 
            defaultJMergerValue = manager.getProductionContext().getOutputValue("output_parameter_jmerger", JMerger.class); //$NON-NLS-1$      

            manager.invoke(new NullProgressMonitor());
        } catch (Exception e) {
            EGFCoreTestPlugin.getDefault().logError(e);
            fail(e.getMessage());
            return;
        } finally {
            try {
                manager.dispose();
            } catch (Exception e) {
                EGFCoreTestPlugin.getDefault().logError(e);
                fail(e.getMessage());
                return;
            }
        }

        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_string", String.class), defaultStringValue);
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_byte", Byte.class), defaultByteValue);
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_character", Character.class), defaultCharacterValue);
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_integer", Integer.class), defaultIntegerValue);
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_long", Long.class), defaultLongValue);
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_float", Float.class), defaultFloatValue);
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_double", Double.class), defaultDoubleValue);
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_short", Short.class), defaultShortValue);
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_collection", ArrayList.class), defaultCollectionValue);
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_jmerger", JMerger.class), defaultJMergerValue); //$NON-NLS-1$
    }
}
