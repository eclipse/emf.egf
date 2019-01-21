/**
 * Copyright (c) 2015 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.core.domain;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;

/**
 * @author Thomas Guiu
 */
public class EgfEditingDomainAdapterFactory extends EgfResourceSet implements IEditingDomainProvider {

	private EditingDomain _editingDomain;

	public void setEditingDomain(EditingDomain editingDomain) {
		_editingDomain = editingDomain;
	}

	public EditingDomain getEditingDomain() {
		return _editingDomain;
	}

}
