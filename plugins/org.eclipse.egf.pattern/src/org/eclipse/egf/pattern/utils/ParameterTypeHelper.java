/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.utils;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.genmodel.IPlatformGenModel;
import org.eclipse.emf.common.util.URI;

/**
 * 
 * @author Thomas Guiu
 * 
 */
public class ParameterTypeHelper {

	public static final ParameterTypeHelper INSTANCE = new ParameterTypeHelper();

	private ParameterTypeHelper() {
	}

	public String getSourceTypeLiteral(String type) {
		return getTypeLiteral(type, true);
	}

	public String getBinaryTypeLiteral(String type) {
		return getTypeLiteral(type, false);
	}

	/**
	 * Compute the literal value associated to the given type.<br/>
	 * It can be a java classname or an uri to an EObject.
	 * 
	 */
	private String getTypeLiteral(String type, boolean handleInnerClass) {
		// clearProxies();
		if (type == null || "".equals(type)) {
			throw new IllegalArgumentException();
		}
		// Java Type
		int index = type.indexOf('#');
		if (index == -1) {
			return handleInnerClass ? type.replace('$', '.') : type;
		}

		URI uri = URI.createURI(type.trim());

		IPlatformGenModel genModel = null;
		genModel = EGFCorePlugin.getWorspacePlatformGenModel(uri.trimFragment());

		if (genModel == null) {
			genModel = EGFCorePlugin.getRuntimePlatformGenModel(uri.trimFragment());
		}
		if (genModel != null) {
			return genModel.getBasePackage() + '.' + getClassName(type, index).replace('/', '.');
		}

		throw new IllegalStateException("Cannot find model: " + uri);
	}

	private String getClassName(String type, int index) {
		String className = type.substring(index + 1);
		if (className.startsWith("//")) //$NON-NLS-1$
			return className.substring(2);
		return className;
	}

}
