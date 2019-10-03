/**
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
 */
package org.eclipse.egf.model.ftask.impl;

import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.impl.ActivityImpl;
import org.eclipse.egf.model.ftask.FtaskPackage;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.ftask.impl.TaskImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.egf.model.ftask.impl.TaskImpl#getSuperTask <em>Super Task</em>}</li>
 *   <li>{@link org.eclipse.egf.model.ftask.impl.TaskImpl#getImplementation <em>Implementation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskImpl extends ActivityImpl implements Task {

    /**
     * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected int flags = 0;

    /**
     * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
    protected static final String KIND_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
    protected String kind = KIND_EDEFAULT;

    /**
     * The cached value of the '{@link #getSuperTask() <em>Super Task</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSuperTask()
     * @generated
     * @ordered
     */
    protected Task superTask;

    /**
     * The default value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImplementation()
     * @generated
     * @ordered
     */
    protected static final String IMPLEMENTATION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImplementation()
     * @generated
     * @ordered
     */
    protected String implementation = IMPLEMENTATION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TaskImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public EList<Contract> getContracts() {
        EList<Contract> contracts = new UniqueEList<Contract>();
        contracts.addAll(super.getContracts());
        Task task = this;
        while (task.getSuperTask() != null) {
            task = task.getSuperTask();
            contracts.addAll(task.getContracts());
        }
        return contracts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public EList<Contract> getContracts(Type innerType) {
        EList<Contract> contracts = new UniqueEList<Contract>();
        contracts.addAll(super.getContracts(innerType));
        Task task = this;
        while (task.getSuperTask() != null) {
            task = task.getSuperTask();
            contracts.addAll(task.getContracts(innerType));
        }
        return contracts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public EList<Contract> getContracts(ContractMode mode) {
        EList<Contract> contracts = new UniqueEList<Contract>();
        contracts.addAll(super.getContracts(mode));
        Task task = this;
        while (task.getSuperTask() != null) {
            task = task.getSuperTask();
            contracts.addAll(task.getContracts(mode));
        }
        return contracts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public Contract getContract(String innerName) {
        final Task task = getSuperTask();
        Contract contract = null;
        if (task != null) {
            contract = task.getContract(innerName);
            if (contract != null) {
                return contract;
            }
        }
        return super.getContract(innerName);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public EList<Contract> getContracts(Type innerType, ContractMode mode) {
        EList<Contract> contracts = new UniqueEList<Contract>();
        contracts.addAll(super.getContracts(innerType, mode));
        Task task = this;
        while (task.getSuperTask() != null) {
            task = task.getSuperTask();
            contracts.addAll(task.getContracts(innerType, mode));
        }
        return contracts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FtaskPackage.Literals.TASK;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getKind() {
        return kind;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setKind(String newKind) {
        String oldKind = kind;
        kind = newKind;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FtaskPackage.TASK__KIND, oldKind, kind));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getImplementation() {
        return implementation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setImplementation(String newImplementation) {
        String oldImplementation = implementation;
        implementation = newImplementation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FtaskPackage.TASK__IMPLEMENTATION, oldImplementation, implementation));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Task getSuperTask() {
        if (superTask != null && superTask.eIsProxy()) {
            InternalEObject oldSuperTask = (InternalEObject) superTask;
            superTask = (Task) eResolveProxy(oldSuperTask);
            if (superTask != oldSuperTask) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FtaskPackage.TASK__SUPER_TASK, oldSuperTask, superTask));
            }
        }
        return superTask;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Task basicGetSuperTask() {
        return superTask;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSuperTask(Task newSuperTask) {
        Task oldSuperTask = superTask;
        superTask = newSuperTask;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FtaskPackage.TASK__SUPER_TASK, oldSuperTask, superTask));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getKindValue() {
        if (getKind() == null && getSuperTask() != null) {
            return getSuperTask().getKindValue();
        }
        return getKind();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getImplementationValue() {
        if (getImplementation() == null && getSuperTask() != null) {
            return getSuperTask().getImplementationValue();
        }
        return getImplementation();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case FtaskPackage.TASK__KIND:
            return getKind();
        case FtaskPackage.TASK__SUPER_TASK:
            if (resolve)
                return getSuperTask();
            return basicGetSuperTask();
        case FtaskPackage.TASK__IMPLEMENTATION:
            return getImplementation();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case FtaskPackage.TASK__KIND:
            setKind((String) newValue);
            return;
        case FtaskPackage.TASK__SUPER_TASK:
            setSuperTask((Task) newValue);
            return;
        case FtaskPackage.TASK__IMPLEMENTATION:
            setImplementation((String) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case FtaskPackage.TASK__KIND:
            setKind(KIND_EDEFAULT);
            return;
        case FtaskPackage.TASK__SUPER_TASK:
            setSuperTask((Task) null);
            return;
        case FtaskPackage.TASK__IMPLEMENTATION:
            setImplementation(IMPLEMENTATION_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case FtaskPackage.TASK__KIND:
            return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
        case FtaskPackage.TASK__SUPER_TASK:
            return superTask != null;
        case FtaskPackage.TASK__IMPLEMENTATION:
            return IMPLEMENTATION_EDEFAULT == null ? implementation != null : !IMPLEMENTATION_EDEFAULT.equals(implementation);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (kind: "); //$NON-NLS-1$
        result.append(kind);
        result.append(", implementation: "); //$NON-NLS-1$
        result.append(implementation);
        result.append(')');
        return result.toString();
    }

} // TaskImpl
