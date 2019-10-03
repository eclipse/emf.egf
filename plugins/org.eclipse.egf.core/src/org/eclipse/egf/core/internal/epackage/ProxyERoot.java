/**
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.internal.epackage;

import java.util.List;

import org.eclipse.egf.core.epackage.IProxyEObject;
import org.eclipse.egf.core.epackage.IProxyEPackage;
import org.eclipse.egf.core.epackage.IProxyERoot;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;

/**
 * @author Xavier Maysonnave
 *
 */
public class ProxyERoot extends ProxyEObject implements IProxyERoot {

    private List<ProxyEPackage> _children;

    public ProxyERoot(URI uri) {
        super("root", null, uri); //$NON-NLS-1$
        _children = new UniqueEList<ProxyEPackage>();
    }

    public IProxyEPackage[] getChildren() {
        return _children.toArray(new IProxyEPackage[_children.size()]);
    }

    public IProxyEObject getIProxyEObject(URI uri) {
        for (ProxyEPackage proxy : _children) {
            IProxyEObject innerProxy = proxy.getIProxyEObject(uri);
            if (innerProxy != null) {
                return innerProxy;
            }
        }
        return null;
    }

    public IProxyEPackage getIProxyEPackage(URI uri) {
        for (IProxyEPackage proxy : getChildren()) {
            if (proxy.getNsURI().equals(uri)) {
                return proxy;
            }
        }
        return null;
    }

    public void addChildren(ProxyEPackage proxy) {
        if (proxy != null) {
            _children.add(proxy);
        }
    }

}
