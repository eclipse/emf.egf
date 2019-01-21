/**
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
 */
package org.eclipse.egf.core.test.model.validation.fprod;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.ftask.FtaskFactory;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;

public class FprodContractValidation extends TestCase {

  public static Test suite() {
    return new TestSuite(FprodContractValidation.class);
  }

  public void testInContractName() throws Exception {

    Task task = FtaskFactory.eINSTANCE.createTask();
    task.setKind("java"); //$NON-NLS-1$

    ContractContainer contracts = FcoreFactory.eINSTANCE.createContractContainer();
    task.eSet(FcorePackage.Literals.ACTIVITY__CONTRACT_CONTAINER, contracts);

    Contract name1 = FcoreFactory.eINSTANCE.createContract();
    name1.setName("name"); //$NON-NLS-1$
    name1.setMode(ContractMode.IN);
    contracts.getContracts().add(name1);

    TypeString name1Type = TypesFactory.eINSTANCE.createTypeString();
    name1.eSet(FcorePackage.Literals.CONTRACT__TYPE, name1Type);

    Contract name2 = FcoreFactory.eINSTANCE.createContract();
    name2.setName("name"); //$NON-NLS-1$
    name2.setMode(ContractMode.IN);
    contracts.getContracts().add(name2);

    TypeString name2Type = TypesFactory.eINSTANCE.createTypeString();
    name2.eSet(FcorePackage.Literals.CONTRACT__TYPE, name2Type);

    Diagnostician diagnostician = new Diagnostician();
    Diagnostic diagnostic = diagnostician.validate(contracts);

    assertTrue(diagnostic.getSeverity() == Diagnostic.ERROR);

  }

  public void testOutContractName() throws Exception {

    Task task = FtaskFactory.eINSTANCE.createTask();
    task.setKind("java"); //$NON-NLS-1$

    ContractContainer contracts = FcoreFactory.eINSTANCE.createContractContainer();
    task.eSet(FcorePackage.Literals.ACTIVITY__CONTRACT_CONTAINER, contracts);

    Contract name1 = FcoreFactory.eINSTANCE.createContract();
    name1.setName("name"); //$NON-NLS-1$
    name1.setMode(ContractMode.OUT);
    contracts.getContracts().add(name1);

    TypeString name1Type = TypesFactory.eINSTANCE.createTypeString();
    name1.eSet(FcorePackage.Literals.CONTRACT__TYPE, name1Type);

    Contract name2 = FcoreFactory.eINSTANCE.createContract();
    name2.setName("name"); //$NON-NLS-1$
    name2.setMode(ContractMode.OUT);
    contracts.getContracts().add(name2);

    TypeString name2Type = TypesFactory.eINSTANCE.createTypeString();
    name2.eSet(FcorePackage.Literals.CONTRACT__TYPE, name2Type);

    Diagnostician diagnostician = new Diagnostician();
    Diagnostic diagnostic = diagnostician.validate(contracts);

    assertTrue(diagnostic.getSeverity() == Diagnostic.ERROR);

  }

  public void testContractName() throws Exception {

    Task task = FtaskFactory.eINSTANCE.createTask();
    task.setKind("java"); //$NON-NLS-1$)

    ContractContainer contracts = FcoreFactory.eINSTANCE.createContractContainer();
    task.eSet(FcorePackage.Literals.ACTIVITY__CONTRACT_CONTAINER, contracts);

    Contract name1 = FcoreFactory.eINSTANCE.createContract();
    name1.setName("name"); //$NON-NLS-1$
    name1.setMode(ContractMode.IN);
    contracts.getContracts().add(name1);

    TypeString name1Type = TypesFactory.eINSTANCE.createTypeString();
    name1.eSet(FcorePackage.Literals.CONTRACT__TYPE, name1Type);

    Contract name2 = FcoreFactory.eINSTANCE.createContract();
    name2.setName("name"); //$NON-NLS-1$
    name2.setMode(ContractMode.OUT);
    contracts.getContracts().add(name2);

    TypeString name2Type = TypesFactory.eINSTANCE.createTypeString();
    name2.eSet(FcorePackage.Literals.CONTRACT__TYPE, name2Type);

    Diagnostician diagnostician = new Diagnostician();
    Diagnostic diagnostic = diagnostician.validate(contracts);

    assertTrue(diagnostic.getSeverity() == Diagnostic.OK);

  }

}
