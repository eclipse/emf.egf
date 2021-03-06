/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v2.0
 *    which accompanies this distribution, and is available at
 *    https://www.eclipse.org/legal/epl-v2.0
 *
 *    SPDX-License-Identifier: EPL-2.0
 * 
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.buildstep.impl;

import java.util.Collection;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepImpl;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregate Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.AggregateStepImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.AggregateStepImpl#getPublishSteps <em>Publish Steps</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildstep.impl.AggregateStepImpl#getUpdateSiteUrls <em>Update Site Urls</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AggregateStepImpl extends ResultStepImpl implements AggregateStep {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";


    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;


    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;


    /**
     * The cached value of the '{@link #getPublishSteps() <em>Publish Steps</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPublishSteps()
     * @generated
     * @ordered
     */
    protected EList<PublishStep> publishSteps;



    /**
     * The cached value of the '{@link #getUpdateSiteUrls() <em>Update Site Urls</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUpdateSiteUrls()
     * @generated
     * @ordered
     */
    protected EList<String> updateSiteUrls;


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AggregateStepImpl() {

        super();

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return BuildstepPackage.Literals.AGGREGATE_STEP;
    }





    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public String getId() {

        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public void setId(String newId) {

        String oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildstepPackage.AGGREGATE_STEP__ID, oldId, id));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<PublishStep> getPublishSteps() {

        if (publishSteps == null) {
            publishSteps = new EObjectResolvingEList<PublishStep>(PublishStep.class, this, BuildstepPackage.AGGREGATE_STEP__PUBLISH_STEPS);
        }
        return publishSteps;
    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    public EList<String> getUpdateSiteUrls() {

        if (updateSiteUrls == null) {
            updateSiteUrls = new EDataTypeUniqueEList<String>(String.class, this, BuildstepPackage.AGGREGATE_STEP__UPDATE_SITE_URLS);
        }
        return updateSiteUrls;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuildstepPackage.AGGREGATE_STEP__ID:
                return getId();
            case BuildstepPackage.AGGREGATE_STEP__PUBLISH_STEPS:
                return getPublishSteps();
            case BuildstepPackage.AGGREGATE_STEP__UPDATE_SITE_URLS:
                return getUpdateSiteUrls();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case BuildstepPackage.AGGREGATE_STEP__ID:
                setId((String)newValue);
                return;
            case BuildstepPackage.AGGREGATE_STEP__PUBLISH_STEPS:
                getPublishSteps().clear();
                getPublishSteps().addAll((Collection<? extends PublishStep>)newValue);
                return;
            case BuildstepPackage.AGGREGATE_STEP__UPDATE_SITE_URLS:
                getUpdateSiteUrls().clear();
                getUpdateSiteUrls().addAll((Collection<? extends String>)newValue);
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
            case BuildstepPackage.AGGREGATE_STEP__ID:
                setId(ID_EDEFAULT);
                return;
            case BuildstepPackage.AGGREGATE_STEP__PUBLISH_STEPS:
                getPublishSteps().clear();
                return;
            case BuildstepPackage.AGGREGATE_STEP__UPDATE_SITE_URLS:
                getUpdateSiteUrls().clear();
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
            case BuildstepPackage.AGGREGATE_STEP__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case BuildstepPackage.AGGREGATE_STEP__PUBLISH_STEPS:
                return publishSteps != null && !publishSteps.isEmpty();
            case BuildstepPackage.AGGREGATE_STEP__UPDATE_SITE_URLS:
                return updateSiteUrls != null && !updateSiteUrls.isEmpty();
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
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (id: ");
        result.append(id);
        result.append(", updateSiteUrls: ");
        result.append(updateSiteUrls);
        result.append(')');
        return result.toString();
    }



} //AggregateStepImpl
