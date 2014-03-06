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

package org.eclipse.egf.portfolio.eclipse.build.buildcore.util;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.migration.BuildcoreXMLHelper;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.migration.BuildcoreXMLLoad;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.util.BuildcoreResourceFactoryImpl
 * @generated
 */
public class BuildcoreResourceImpl extends XMIResourceImpl {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * Creates an instance of the resource.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param uri the URI of the new resource.
     * @generated
     */
    public BuildcoreResourceImpl(URI uri) {
        super(uri);
    }
    
    /**
     * @generated NOT
     */
    @Override
    protected boolean useUUIDs() {
        return true;
    }

    /**
     * @generated NOT
     */
    @Override
    protected XMLHelper createXMLHelper() {
    	return new BuildcoreXMLHelper(this);
    }
    
    /**
     * @generated NOT
     */
    @Override
    protected XMLLoad createXMLLoad() {
    	return new BuildcoreXMLLoad(createXMLHelper());
    }

} //BuildcoreResourceImpl
