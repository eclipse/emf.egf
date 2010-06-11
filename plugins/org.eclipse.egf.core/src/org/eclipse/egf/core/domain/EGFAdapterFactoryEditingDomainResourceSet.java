/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.domain;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFAdapterFactoryEditingDomainResourceSet extends EGFResourceSet implements IEditingDomainProvider {

    private EditingDomain _editingDomain;

    public EGFAdapterFactoryEditingDomainResourceSet() {
        super();
    }

    public void setEditingDomain(EditingDomain editingDomain) {
        _editingDomain = editingDomain;
    }

    public EditingDomain getEditingDomain() {
        return _editingDomain;
    }

}