/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.model.editor.contributions;

import org.eclipse.egf.domain.DomainHelper;
import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * @author Thomas Guiu
 * 
 */
public class DomainEditorContributor extends AbstractTypeEditorContributor {

    public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
        if (!(object instanceof Domain) || ((EObject) object).eResource() == null) {
            return false;
        }
        return checkFeature(object, descriptor, DomainPackage.Literals.DOMAIN__HELPER_IMPLEMENTATION);
    }

    @Override
    protected String getValue(Object object) {
        return ((Domain) object).getHelperImplementation();
    }

    @Override
    protected String getFilteredType(Object object) {
        return DomainHelper.class.getName();
    }

}
