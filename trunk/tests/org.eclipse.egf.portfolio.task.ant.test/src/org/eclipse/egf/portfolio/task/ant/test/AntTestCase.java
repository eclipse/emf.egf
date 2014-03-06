/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.portfolio.task.ant.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.ftask.FtaskFactory;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.types.TypeBigDecimal;
import org.eclipse.egf.model.types.TypeBigInteger;
import org.eclipse.egf.model.types.TypeBoolean;
import org.eclipse.egf.model.types.TypeByte;
import org.eclipse.egf.model.types.TypeCharacter;
import org.eclipse.egf.model.types.TypeClass;
import org.eclipse.egf.model.types.TypeCollection;
import org.eclipse.egf.model.types.TypeDate;
import org.eclipse.egf.model.types.TypeDouble;
import org.eclipse.egf.model.types.TypeFloat;
import org.eclipse.egf.model.types.TypeInteger;
import org.eclipse.egf.model.types.TypeLong;
import org.eclipse.egf.model.types.TypeShort;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.model.types.TypeURI;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.egf.portfolio.task.ant.Activator;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.ftask.manager.TaskManagerFactory;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.emf.codegen.merge.java.JMerger;
import org.eclipse.emf.common.util.URI;

/**
 * @author xiaoru chen
 * 
 */
public class AntTestCase extends TestCase {

    public static Test suite() {
        return new TestSuite(AntTestCase.class);
    }

    /**
     * Test saying hello world.
     */
    public void testcases_ant_1() throws Exception {
        Task task = FtaskFactory.eINSTANCE.createTask();
        task.setImplementation("platform:/plugin/org.eclipse.egf.example.task.ant/ant/HelloWord.xml"); //$NON-NLS-1$
        task.setKind("ant"); //$NON-NLS-1$

        ActivityManagerProducer<Task> producer = EGFProducerPlugin.getActivityManagerProducer(task);

        IActivityManager<?> manager = producer.createActivityManager(Activator.getDefault().getBundle(), task);
        try {
            manager.initializeContext();
            manager.invoke(new NullProgressMonitor());
        } catch (Exception e) {
            Activator.getDefault().logError(e);
            fail(e.getMessage());
            return;
        } finally {
            try {
                manager.dispose();
            } catch (Exception e) {
                Activator.getDefault().logError(e);
                fail(e.getMessage());
                return;
            }
        }
    }

    /**
     * Test using task from external ant lib.
     */
    public void testcases_ant_2() throws Exception {
        Task task = FtaskFactory.eINSTANCE.createTask();
        task.setImplementation("platform:/plugin/org.eclipse.egf.example.task.ant/ant/ExecuteTaskFromExternalAntLib.xml"); //$NON-NLS-1$
        task.setKind("ant"); //$NON-NLS-1$

        ActivityManagerProducer<Task> producer = EGFProducerPlugin.getActivityManagerProducer(task);

        IActivityManager<?> manager = producer.createActivityManager(Activator.getDefault().getBundle(), task);
        try {
            manager.initializeContext();
            manager.invoke(new NullProgressMonitor());
        } catch (Exception e) {
            Activator.getDefault().logError(e);
            fail(e.getMessage());
            return;
        } finally {
            try {
                manager.dispose();
            } catch (Exception e) {
                Activator.getDefault().logError(e);
                fail(e.getMessage());
                return;
            }
        }
    }

    /**
     * Test generating a javadoc from few classes
     */
    public void testcases_ant_3() throws Exception {
        Task task = FtaskFactory.eINSTANCE.createTask();
        task.setImplementation("platform:/plugin/org.eclipse.egf.example.task.ant/ant/GenerateJavaDoc.xml"); //$NON-NLS-1$
        task.setKind("ant"); //$NON-NLS-1$

        ActivityManagerProducer<Task> producer = EGFProducerPlugin.getActivityManagerProducer(task);

        IActivityManager<?> manager = producer.createActivityManager(Activator.getDefault().getBundle(), task);
        try {
            manager.initializeContext();
            manager.invoke(new NullProgressMonitor());
        } catch (Exception e) {
            Activator.getDefault().logError(e);
            fail(e.getMessage());
            return;
        } finally {
            try {
                manager.dispose();
            } catch (Exception e) {
                Activator.getDefault().logError(e);
                fail(e.getMessage());
                return;
            }
        }
    }

    /**
     * Test writing output contracts and read input contracts in the ant task's
     * execute() method which rewrite the
     * "org.eclipselabs.egf.portfolio.task.ant.engine.TaskProductionForAnt"
     */
    public void testcases_ant_4() throws InvocationException {
        Task task = FtaskFactory.eINSTANCE.createTask();
        task.setImplementation("platform:/plugin/org.eclipse.egf.example.task.ant/ant/WriteAndReadContractByTask.xml"); //$NON-NLS-1$
        task.setKind("ant"); //$NON-NLS-1$

        ContractContainer contracts = FcoreFactory.eINSTANCE.createContractContainer();
        task.eSet(FcorePackage.Literals.ACTIVITY__CONTRACT_CONTAINER, contracts);

        createInputContracts(contracts);
        createOutputContracts(contracts);

        IActivityManager<Task> manager = TaskManagerFactory.createProductionManager(Activator.getDefault().getBundle(), task);

        String defaultStringValue = null;
        JMerger defaultJMergerValue = null;

        try {
            manager.initializeContext();
            defaultStringValue = manager.getProductionContext().getOutputValue("output_parameter_string", String.class); //$NON-NLS-1$ 
            defaultJMergerValue = manager.getProductionContext().getOutputValue("output_parameter_jmerger", JMerger.class); //$NON-NLS-1$
            manager.invoke(new NullProgressMonitor());
        } catch (Exception e) {
            Activator.getDefault().logError(e);
            fail(e.getMessage());
            return;
        } finally {
            try {
                manager.dispose();
            } catch (Exception e) {
                Activator.getDefault().logError(e);
                fail(e.getMessage());
                return;
            }
        }
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_string", String.class), defaultStringValue); //$NON-NLS-1$
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_jmerger", JMerger.class), defaultJMergerValue); //$NON-NLS-1$
    }

    /**
     * Test reading input contracts in the ant script by using
     * 'org.eclipselabs.egf.portfolio.task.ant.engine.TaskProductionForAnt' ant
     * task.
     */
    public void testcases_ant_5() throws InvocationException {
        Task task = FtaskFactory.eINSTANCE.createTask();
        task.setImplementation("platform:/plugin/org.eclipse.egf.example.task.ant/ant/ReadInputContractDirectly.xml"); //$NON-NLS-1$
        task.setKind("ant"); //$NON-NLS-1$

        ContractContainer contracts = FcoreFactory.eINSTANCE.createContractContainer();
        task.eSet(FcorePackage.Literals.ACTIVITY__CONTRACT_CONTAINER, contracts);

        createInputContracts(contracts);

        IActivityManager<Task> manager = TaskManagerFactory.createProductionManager(Activator.getDefault().getBundle(), task);

        try {
            manager.initializeContext();
            manager.invoke(new NullProgressMonitor());
        } catch (Exception e) {
            Activator.getDefault().logError(e);
            fail(e.getMessage());
            return;
        } finally {
            try {
                manager.dispose();
            } catch (Exception e) {
                Activator.getDefault().logError(e);
                fail(e.getMessage());
                return;
            }
        }
    }

    /**
     * Test writing output contracts in the ant script by using
     * 'org.eclipselabs.egf.portfolio.task.ant.engine.TaskProductionForAnt' ant
     * task.
     */
    public void testcases_ant_6() throws InvocationException {
        Task task = FtaskFactory.eINSTANCE.createTask();
        task.setImplementation("platform:/plugin/org.eclipse.egf.example.task.ant/ant/WriteOutputContractDirectly.xml"); //$NON-NLS-1$
        task.setKind("ant"); //$NON-NLS-1$

        ContractContainer contracts = FcoreFactory.eINSTANCE.createContractContainer();
        task.eSet(FcorePackage.Literals.ACTIVITY__CONTRACT_CONTAINER, contracts);

        createOutputContracts(contracts);

        IActivityManager<Task> manager = TaskManagerFactory.createProductionManager(Activator.getDefault().getBundle(), task);

        String defaultStringValue = null;
        Byte defaultByteValue = null;
        Character defaultCharacterValue = null;
        BigInteger defaultBigIntegerValue = null;
        BigDecimal defaultBigDecimalValue = null;
        Date defaultDateValue = null;
        URI defaultUriValue = null;
        Integer defaultIntegerValue = null;
        Long defaultLongValue = null;
        Float defaultFloatValue = null;
        Double defaultDoubleValue = null;
        Short defaultShortValue = null;

        try {
            manager.initializeContext();

            defaultStringValue = manager.getProductionContext().getOutputValue("output_parameter_string", String.class); //$NON-NLS-1$ 
            defaultByteValue = manager.getProductionContext().getOutputValue("output_parameter_byte", Byte.class); //$NON-NLS-1$ 
            defaultCharacterValue = manager.getProductionContext().getOutputValue("output_parameter_character", Character.class); //$NON-NLS-1$ 
            defaultBigIntegerValue = manager.getProductionContext().getOutputValue("output_parameter_bigInteger", BigInteger.class); //$NON-NLS-1$ 
            defaultBigDecimalValue = manager.getProductionContext().getOutputValue("output_parameter_bigDecimal", BigDecimal.class); //$NON-NLS-1$ 
            defaultDateValue = manager.getProductionContext().getOutputValue("output_parameter_date", Date.class); //$NON-NLS-1$
            defaultUriValue = manager.getProductionContext().getOutputValue("output_parameter_uri", URI.class); //$NON-NLS-1$
            defaultIntegerValue = manager.getProductionContext().getOutputValue("output_parameter_integer", Integer.class); //$NON-NLS-1$ 
            defaultLongValue = manager.getProductionContext().getOutputValue("output_parameter_long", Long.class); //$NON-NLS-1$ 
            defaultFloatValue = manager.getProductionContext().getOutputValue("output_parameter_float", Float.class); //$NON-NLS-1$ 
            defaultDoubleValue = manager.getProductionContext().getOutputValue("output_parameter_double", Double.class); //$NON-NLS-1$ 
            defaultShortValue = manager.getProductionContext().getOutputValue("output_parameter_short", Short.class); //$NON-NLS-1$ 

            manager.invoke(new NullProgressMonitor());
        } catch (Exception e) {
            Activator.getDefault().logError(e);
            fail(e.getMessage());
            return;
        } finally {
            try {
                manager.dispose();
            } catch (Exception e) {
                Activator.getDefault().logError(e);
                fail(e.getMessage());
                return;
            }
        }

        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_string", String.class), defaultStringValue); //$NON-NLS-1$
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_byte", Byte.class), defaultByteValue); //$NON-NLS-1$
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_character", Character.class), defaultCharacterValue); //$NON-NLS-1$
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_bigInteger", BigInteger.class), defaultBigIntegerValue); //$NON-NLS-1$
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_bigDecimal", BigDecimal.class), defaultBigDecimalValue); //$NON-NLS-1$
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_date", Date.class), defaultDateValue); //$NON-NLS-1$
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_uri", URI.class), defaultUriValue); //$NON-NLS-1$
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_integer", Integer.class), defaultIntegerValue); //$NON-NLS-1$
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_long", Long.class), defaultLongValue); //$NON-NLS-1$
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_float", Float.class), defaultFloatValue); //$NON-NLS-1$
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_double", Double.class), defaultDoubleValue); //$NON-NLS-1$
        assertNotSame(manager.getProductionContext().getOutputValue("output_parameter_short", Short.class), defaultShortValue); //$NON-NLS-1$
    }

    /**
     * Create input contracts for contract container.
     */
    private void createInputContracts(ContractContainer contracts) {
        // Input parameter with String type
        Contract inputParameterString = FcoreFactory.eINSTANCE.createContract();
        inputParameterString.setName("input_parameter_string"); //$NON-NLS-1$
        inputParameterString.setMode(ContractMode.IN);
        contracts.getContracts().add(inputParameterString);

        TypeString stringType = TypesFactory.eINSTANCE.createTypeString();
        stringType.setValue("hello"); //$NON-NLS-1$
        inputParameterString.eSet(FcorePackage.Literals.CONTRACT__TYPE, stringType);

        // Input parameter with BigInteger type
        Contract inputParameterBigInteger = FcoreFactory.eINSTANCE.createContract();
        inputParameterBigInteger.setName("input_parameter_bigInteger"); //$NON-NLS-1$
        inputParameterBigInteger.setMode(ContractMode.IN);
        contracts.getContracts().add(inputParameterBigInteger);

        TypeBigInteger bigIntegerType = TypesFactory.eINSTANCE.createTypeBigInteger();
        bigIntegerType.setValue(new BigInteger("9999")); //$NON-NLS-1$
        inputParameterBigInteger.eSet(FcorePackage.Literals.CONTRACT__TYPE, bigIntegerType);

        // Input parameter with BigDecimal type
        Contract inputParameterBigDecimal = FcoreFactory.eINSTANCE.createContract();
        inputParameterBigDecimal.setName("input_parameter_bigDecimal"); //$NON-NLS-1$
        inputParameterBigDecimal.setMode(ContractMode.IN);
        contracts.getContracts().add(inputParameterBigDecimal);

        TypeBigDecimal bigDecimalType = TypesFactory.eINSTANCE.createTypeBigDecimal();
        bigDecimalType.setValue(new BigDecimal(20)); //$NON-NLS-1$
        inputParameterBigDecimal.eSet(FcorePackage.Literals.CONTRACT__TYPE, bigDecimalType);

        // Input parameter with URI type
        Contract inputParameterURI = FcoreFactory.eINSTANCE.createContract();
        inputParameterURI.setName("input_parameter_uri"); //$NON-NLS-1$
        inputParameterURI.setMode(ContractMode.IN);
        contracts.getContracts().add(inputParameterURI);

        TypeURI uriType = TypesFactory.eINSTANCE.createTypeURI();
        uriType.setValue(URI.createURI("platform:/plugin/org.eclipse.egf.example.task.ant/ant/ReadInputContractDirectly.xml")); //$NON-NLS-1$
        inputParameterURI.eSet(FcorePackage.Literals.CONTRACT__TYPE, uriType);

        // Input parameter with Date type
        Contract inputParameterDate = FcoreFactory.eINSTANCE.createContract();
        inputParameterDate.setName("input_parameter_date"); //$NON-NLS-1$
        inputParameterDate.setMode(ContractMode.IN);
        contracts.getContracts().add(inputParameterDate);

        TypeDate dateType = TypesFactory.eINSTANCE.createTypeDate();
        try {
            dateType.setValue((new SimpleDateFormat("yyyy-MM-dd")).parse("2010-12-12")); //$NON-NLS-1$
        } catch (ParseException e) {
            Activator.getDefault().logError(e);
        }
        inputParameterDate.eSet(FcorePackage.Literals.CONTRACT__TYPE, dateType);

        // Input parameter with Boolean type
        Contract inputParameterBoolean = FcoreFactory.eINSTANCE.createContract();
        inputParameterBoolean.setName("input_parameter_boolean"); //$NON-NLS-1$
        inputParameterBoolean.setMode(ContractMode.IN);
        contracts.getContracts().add(inputParameterBoolean);

        TypeBoolean booleanType = TypesFactory.eINSTANCE.createTypeBoolean();
        booleanType.setValue(true); //$NON-NLS-1$
        inputParameterBoolean.eSet(FcorePackage.Literals.CONTRACT__TYPE, booleanType);

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
        collectionType.setValue("java.util.ArrayList"); //$NON-NLS-1$
        inputParameterCollection.eSet(FcorePackage.Literals.CONTRACT__TYPE, collectionType);

        // Input parameter with Jmerger type
        Contract inputParameterJmerger = FcoreFactory.eINSTANCE.createContract();
        inputParameterJmerger.setName("input_parameter_jmerger"); //$NON-NLS-1$
        inputParameterJmerger.setMode(ContractMode.IN);
        contracts.getContracts().add(inputParameterJmerger);

        TypeClass jmergerType = TypesFactory.eINSTANCE.createTypeClass();
        jmergerType.setValue("org.eclipse.emf.codegen.merge.java.JMerger"); //$NON-NLS-1$
        inputParameterJmerger.eSet(FcorePackage.Literals.CONTRACT__TYPE, jmergerType);
    }

    /**
     * Create output contracts for contract container.
     */
    private void createOutputContracts(ContractContainer contracts) {
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

        // Output parameter with BigInteger type
        Contract outputParameterBigInteger = FcoreFactory.eINSTANCE.createContract();
        outputParameterBigInteger.setName("output_parameter_bigInteger"); //$NON-NLS-1$
        outputParameterBigInteger.setMode(ContractMode.OUT);
        contracts.getContracts().add(outputParameterBigInteger);

        TypeBigInteger bigIntegerType = TypesFactory.eINSTANCE.createTypeBigInteger();
        outputParameterBigInteger.eSet(FcorePackage.Literals.CONTRACT__TYPE, bigIntegerType);

        // Output parameter with BigDecimal type
        Contract outputParameterBigDecimal = FcoreFactory.eINSTANCE.createContract();
        outputParameterBigDecimal.setName("output_parameter_bigDecimal"); //$NON-NLS-1$
        outputParameterBigDecimal.setMode(ContractMode.OUT);
        contracts.getContracts().add(outputParameterBigDecimal);

        TypeBigDecimal bigDecimalType = TypesFactory.eINSTANCE.createTypeBigDecimal();
        outputParameterBigDecimal.eSet(FcorePackage.Literals.CONTRACT__TYPE, bigDecimalType);

        // Output parameter with URI type
        Contract outputParameterURI = FcoreFactory.eINSTANCE.createContract();
        outputParameterURI.setName("output_parameter_uri"); //$NON-NLS-1$
        outputParameterURI.setMode(ContractMode.OUT);
        contracts.getContracts().add(outputParameterURI);

        TypeURI uriType = TypesFactory.eINSTANCE.createTypeURI();
        outputParameterURI.eSet(FcorePackage.Literals.CONTRACT__TYPE, uriType);

        // Output parameter with Date type
        Contract outputParameterDate = FcoreFactory.eINSTANCE.createContract();
        outputParameterDate.setName("output_parameter_date"); //$NON-NLS-1$
        outputParameterDate.setMode(ContractMode.OUT);
        contracts.getContracts().add(outputParameterDate);

        TypeDate dateType = TypesFactory.eINSTANCE.createTypeDate();
        outputParameterDate.eSet(FcorePackage.Literals.CONTRACT__TYPE, dateType);

        // Output parameter with Boolean type
        Contract outputParameterBoolean = FcoreFactory.eINSTANCE.createContract();
        outputParameterBoolean.setName("output_parameter_boolean"); //$NON-NLS-1$
        outputParameterBoolean.setMode(ContractMode.OUT);
        contracts.getContracts().add(outputParameterBoolean);

        TypeBoolean booleanType = TypesFactory.eINSTANCE.createTypeBoolean();
        outputParameterBoolean.eSet(FcorePackage.Literals.CONTRACT__TYPE, booleanType);

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
        collectionType.setValue("java.util.ArrayList"); //$NON-NLS-1$
        outputParameterCollection.eSet(FcorePackage.Literals.CONTRACT__TYPE, collectionType);

        // Output parameter with Jmerger type
        Contract outputParameterJmerger = FcoreFactory.eINSTANCE.createContract();
        outputParameterJmerger.setName("output_parameter_jmerger"); //$NON-NLS-1$
        outputParameterJmerger.setMode(ContractMode.OUT);
        contracts.getContracts().add(outputParameterJmerger);

        TypeClass jmergerType = TypesFactory.eINSTANCE.createTypeClass();
        jmergerType.setValue("org.eclipse.emf.codegen.merge.java.JMerger"); //$NON-NLS-1$
        outputParameterJmerger.eSet(FcorePackage.Literals.CONTRACT__TYPE, jmergerType);
    }

}
