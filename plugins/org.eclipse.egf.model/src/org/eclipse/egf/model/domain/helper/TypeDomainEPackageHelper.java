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
package org.eclipse.egf.model.domain.helper;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.model.domain.DomainEPackage;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TypeDomainEPackageHelper {

    private TypeDomainEPackageHelper() {
        // Prevent Instantiation
    }

    public static Collection<DomainEPackage> getAvailableDomainEPackage(EObject eObject) {
        Collection<DomainEPackage> result = new UniqueEList<DomainEPackage>();
        if (eObject != null) {
            for (Iterator<EObject> iterator = EMFHelper.getAllProperContents(DomainPackage.eINSTANCE.getDomainEPackage(), EcoreUtil.getRootContainer(eObject, true)).iterator(); iterator.hasNext();) {
                result.add((DomainEPackage) iterator.next());
            }
        }
        return result;
    }

}
