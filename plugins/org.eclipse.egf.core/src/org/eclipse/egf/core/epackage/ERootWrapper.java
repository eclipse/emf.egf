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
public class ERootWrapper extends EObjectWrapper {

    private List<EPackageWrapper> _children;

    public ERootWrapper(URI nsURI) {
        super("root", nsURI); //$NON-NLS-1$
        _children = new UniqueEList<EPackageWrapper>();
    }

    public List<EPackageWrapper> getChildren() {
        return _children;
    }

    public EObjectWrapper getEObjectWrapper(URI nsURI) {
        for (EPackageWrapper wrapper : _children) {
            EObjectWrapper innerWrapper = wrapper.getEOBjectWrapper(nsURI);
            if (innerWrapper != null) {
                return innerWrapper;
            }
        }
        return null;
    }

}
