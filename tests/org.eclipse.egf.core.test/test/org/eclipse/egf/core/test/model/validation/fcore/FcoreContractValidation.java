/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.test.model.validation.fcore;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fprod.FprodFactory;
import org.eclipse.egf.model.fprod.FprodPackage;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.egf.model.fprod.TaskContract;
import org.eclipse.egf.model.fprod.TaskContractContainer;
import org.eclipse.egf.model.types.StringType;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;

public class FcoreContractValidation extends TestCase {

  public static Test suite() {
    return new TestSuite(FcoreContractValidation.class);
  }

  public void testInContractName() throws Exception {

    Task task = FprodFactory.eINSTANCE.createTask();

    TaskContractContainer contracts = FprodFactory.eINSTANCE.createTaskContractContainer();
    task.eSet(FprodPackage.Literals.TASK__ACTIVITY_CONTRACT_CONTAINER, contracts);

    TaskContract name1 = FprodFactory.eINSTANCE.createTaskContract();
    name1.setName("name"); //$NON-NLS-1$
    name1.setMode(ContractMode.IN);
    contracts.getActivityContracts().add(name1);

    StringType name1Type = TypesFactory.eINSTANCE.createStringType();
    name1.eSet(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, name1Type);

    TaskContract name2 = FprodFactory.eINSTANCE.createTaskContract();
    name2.setName("name"); //$NON-NLS-1$
    name2.setMode(ContractMode.IN);
    contracts.getActivityContracts().add(name2);

    StringType name2Type = TypesFactory.eINSTANCE.createStringType();
    name2.eSet(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, name2Type);

    Diagnostician diagnostician = new Diagnostician();
    Diagnostic diagnostic = diagnostician.validate(contracts);

    assertTrue(diagnostic.getSeverity() == Diagnostic.ERROR);

  }

  public void testOutContractName() throws Exception {

    Task task = FprodFactory.eINSTANCE.createTask();

    TaskContractContainer contracts = FprodFactory.eINSTANCE.createTaskContractContainer();
    task.eSet(FprodPackage.Literals.TASK__ACTIVITY_CONTRACT_CONTAINER, contracts);

    TaskContract name1 = FprodFactory.eINSTANCE.createTaskContract();
    name1.setName("name"); //$NON-NLS-1$
    name1.setMode(ContractMode.OUT);
    contracts.getActivityContracts().add(name1);

    StringType name1Type = TypesFactory.eINSTANCE.createStringType();
    name1.eSet(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, name1Type);

    TaskContract name2 = FprodFactory.eINSTANCE.createTaskContract();
    name2.setName("name"); //$NON-NLS-1$
    name2.setMode(ContractMode.OUT);
    contracts.getActivityContracts().add(name2);

    StringType name2Type = TypesFactory.eINSTANCE.createStringType();
    name2.eSet(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, name2Type);

    Diagnostician diagnostician = new Diagnostician();
    Diagnostic diagnostic = diagnostician.validate(contracts);

    assertTrue(diagnostic.getSeverity() == Diagnostic.ERROR);

  }

  public void testContractName() throws Exception {

    Task task = FprodFactory.eINSTANCE.createTask();

    TaskContractContainer contracts = FprodFactory.eINSTANCE.createTaskContractContainer();
    task.eSet(FprodPackage.Literals.TASK__ACTIVITY_CONTRACT_CONTAINER, contracts);

    TaskContract name1 = FprodFactory.eINSTANCE.createTaskContract();
    name1.setName("name"); //$NON-NLS-1$
    name1.setMode(ContractMode.IN);
    contracts.getActivityContracts().add(name1);

    StringType name1Type = TypesFactory.eINSTANCE.createStringType();
    name1.eSet(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, name1Type);

    TaskContract name2 = FprodFactory.eINSTANCE.createTaskContract();
    name2.setName("name"); //$NON-NLS-1$
    name2.setMode(ContractMode.OUT);
    contracts.getActivityContracts().add(name2);

    StringType name2Type = TypesFactory.eINSTANCE.createStringType();
    name2.eSet(FcorePackage.Literals.ACTIVITY_CONTRACT__TYPE, name2Type);

    Diagnostician diagnostician = new Diagnostician();
    Diagnostic diagnostic = diagnostician.validate(contracts);

    assertTrue(diagnostic.getSeverity() == Diagnostic.OK);

  }

}
