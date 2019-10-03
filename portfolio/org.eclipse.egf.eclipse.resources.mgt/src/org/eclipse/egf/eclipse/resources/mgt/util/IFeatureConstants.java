/**
 * <copyright>
 * 
 * Copyright (c) 2014 Thales Corporate Services S.A.S.
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
 * </copyright>
 */

package org.eclipse.egf.eclipse.resources.mgt.util;

/**
 * This interface declare all contracts names
 * @author Boubekeur Zendagui
 */
public interface IFeatureConstants {
	
	/***************************** Create.Feature.Project task contracts *****************************/
	public static final String CONTRACT_FEATURE_ID = "id"; //$NON-NLS-0$
	public static final String CONTRACT_FEATURE_LABEL = "label"; //$NON-NLS-0$
	public static final String CONTRACT_FEATURE_PROVIDER = "provider"; //$NON-NLS-0$
	public static final String CONTRACT_FEATURE_VERSION = "version"; //$NON-NLS-0$
	
	public static final String CONTRACT_INCLUDED_FEATURE = "incluted.feature.names.list"; //$NON-NLS-0$
	public static final String CONTRACT_PLUGINS_LIST = "plugins.names.list"; //$NON-NLS-0$
	
	public static final String CONTRACT_DESCRIPTION_URL = "description.url"; //$NON-NLS-0$
	public static final String CONTRACT_DESCRIPTION_URI = "description.uri"; //$NON-NLS-0$
	
	public static final String CONTRACT_LICENSE_URL = "license.url"; //$NON-NLS-0$
	public static final String CONTRACT_LICENSE_URI = "license.uri"; //$NON-NLS-0$
	
	public static final String CONTRACT_COPYRIGHT_URL = "copyright.url"; //$NON-NLS-0$
	public static final String CONTRACT_COPYRIGHT_URI = "copyright.uri"; //$NON-NLS-0$
//	public static final String CONTRACT_CREATE_IF_NOT_EXIST = "create.if.not.exist"; //$NON-NLS-0$
	
	/*************** Add.Plugin.or.Include.Feature.to.Existing.Feature task contracts *****************/
	public static final String CONTRACT_FEATURE_NAME = "feature.name"; //$NON-NLS-0$
	public static final String CONTRACT_PLUGIN_TO_INCLUDE = "plugin.name.to.include"; //$NON-NLS-0$
	public static final String CONTRACT_FEATURE_TO_INCLUDE = "feature.name.to.include"; //$NON-NLS-0$
}
