/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 **/
package org.eclipse.egf.core.genmodel;

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * Defines all constants related to a GenModel extension point declaration.
 */
public interface IPlatformGenModelConstants {

    /**
     * Define a constant for the generated_package extension-point id.
     */
    public static final String GENERATED_PACKAGE_EXTENSION_POINT_ID = EcorePlugin.GENERATED_PACKAGE_PPID;

    /**
     * Define a constant for the generated_package extension-point id as a fully
     * qualified id.
     */
    public static final String FULLY_QUALIFIED_EXTENSION_POINT_ID = EcorePlugin.getPlugin().getBundle().getSymbolicName() + EGFCommonConstants.DOT_STRING + GENERATED_PACKAGE_EXTENSION_POINT_ID;

    /**
     * Define a constant for the package extension-point child.
     */
    static final String PACKAGE_EXTENSION_CHILD = "package"; //$NON-NLS-1$

    /**
     * Define a constant for the 'uri' attribute.
     */
    public static final String PACKAGE_ATT_URI = "uri"; //$NON-NLS-1$

    /**
     * Define a constant for the 'class' attribute.
     */
    public static final String PACKAGE_ATT_CLASS = "class"; //$NON-NLS-1$

    /**
     * Define a constant for the 'genmodel' attribute.
     */
    public static final String PACKAGE_ATT_GENMODEL = "genModel"; //$NON-NLS-1$    

}
