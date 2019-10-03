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
package org.eclipse.egf.core.platform.internal.pde;

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;

/**
 * Defines all constants related to a manager into extension point
 * declaration.
 */
public interface IManagerConstants {

    /**
     * Define a constant for the Manager extension-point id.
     */
    public static final String MANAGER_EXTENSION_POINT_ID = "manager"; //$NON-NLS-1$

    /**
     * Define a constant for the Manager extension-point id as a fully
     * qualified id.
     */
    public static final String FULLY_QUALIFIED_EXTENSION_POINT_ID = EGFPlatformPlugin.getDefault().getPluginID() + EGFCommonConstants.DOT_STRING + MANAGER_EXTENSION_POINT_ID;

    /**
     * Define a constant for the Manager extension-point child.
     */
    static final String MANAGER_EXTENSION_CHILD = MANAGER_EXTENSION_POINT_ID;

    /**
     * Define a constant for the 'extension' attribute.
     */
    public static final String MANAGER_ATT_EXTENSION = "extension"; //$NON-NLS-1$

    /**
     * Define a constant for the 'class' attribute.
     */
    public static final String MANAGER_ATT_CLASS = "class"; //$NON-NLS-1$  

}
