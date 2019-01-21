/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.genchain.extension;

/**
 * @author Thomas Guiu
 * 
 */
public interface ExtensionProperties {
	String ID = "id";
	String MODEL_PATH = "model.path";
	String PROPERTY_VALUE = "property.value";
	String PROPERTY_EATTRIBUTE = "property.attribute";
	String CONFLICT = "property.conflict";

	String CONTEXT_CURRENT_PROJECT_NAME = "ctx.current.project.name";
	String CONTEXT_PROJECT_NAME = "ctx.project.name";
	String CONTEXT_MODEL_NAME = "ctx.model.path";

}
