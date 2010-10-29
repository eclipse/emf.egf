/**
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.epackage;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;

/**
 * @author Xavier Maysonnave
 *
 */
public class EPackageWrapper extends EObjectWrapper {

    private List<EClassifierWrapper> _children;

    public EPackageWrapper(ERootWrapper parent, String name, URI nsURI) {
        super(parent, name, nsURI);
        _children = new UniqueEList<EClassifierWrapper>();
    }

    public List<EClassifierWrapper> getChildren() {
        return _children;
    }

    public EObjectWrapper getEOBjectWrapper(URI nsURI) {
        for (EClassifierWrapper wrapper : _children) {
            if (wrapper.getNsURI().equals(nsURI)) {
                return wrapper;
            }
        }
        return null;
    }

}
