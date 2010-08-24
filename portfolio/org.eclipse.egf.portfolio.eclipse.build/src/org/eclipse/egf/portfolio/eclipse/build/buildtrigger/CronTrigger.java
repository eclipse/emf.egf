/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    All rights reserved. This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v1.0
 *    which accompanies this distribution, and is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 *   
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.buildtrigger;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.Trigger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cron Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildtrigger.CronTrigger#getPlanning <em>Planning</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildtrigger.BuildtriggerPackage#getCronTrigger()
 * @model
 * @generated
 */
public interface CronTrigger extends Trigger {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Planning</b></em>' attribute.
     * The default value is <code>"00 06 * * *"</code>.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Planning</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Planning</em>' attribute.
     * @see #setPlanning(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildtrigger.BuildtriggerPackage#getCronTrigger_Planning()
     * @model default="00 06 * * *"
     * @generated
     */

    String getPlanning();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildtrigger.CronTrigger#getPlanning <em>Planning</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Planning</em>' attribute.
     * @see #getPlanning()
     * @generated
     */

    void setPlanning(String value);





} // CronTrigger
