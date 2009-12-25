/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.pattern.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.egf.model.pattern.BasicQuery;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Basic Query</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BasicQueryImpl extends QueryImpl implements BasicQuery {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected BasicQueryImpl() {
        super();
    }

    @Override
    public Map<String, String> getQueryContext() {
        Map<String, String> result = new HashMap<String, String>();
        result.put(TYPE, getParameter().getType());
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PatternPackage.Literals.BASIC_QUERY;
    }

} // BasicQueryImpl
