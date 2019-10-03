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

import org.eclipse.egf.core.epackage.IProxyEClassifier;
import org.eclipse.egf.core.epackage.IProxyEObject;
import org.eclipse.egf.core.epackage.IProxyEPackage;
import org.eclipse.egf.core.epackage.IProxyERoot;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;

/**
 * @author Xavier Maysonnave
 *
 */
public class ProxyEPackage extends ProxyEObject implements IProxyEPackage {

    private URI _uri;

    private List<ProxyEClassifier> eClassifiers;

    public ProxyEPackage(String name, String instanceClassName, URI uri) {
        super(name, instanceClassName, uri);
        _uri = uri;
        eClassifiers = new UniqueEList<ProxyEClassifier>();
    }

    public ProxyEPackage(IProxyERoot parent, String name, String instanceClassName, URI uri) {
        super(parent, name, instanceClassName, uri);
        _uri = uri;
        eClassifiers = new UniqueEList<ProxyEClassifier>();
    }

    public URI getNsURI() {
        return _uri;
    }

    public IProxyEClassifier[] getChildren() {
        return eClassifiers.toArray(new IProxyEClassifier[eClassifiers.size()]);
    }

    @Override
    public IProxyERoot getParent() {
        return (IProxyERoot) super.getParent();
    }

    public IProxyEObject getIProxyEObject(URI uri) {
        for (ProxyEClassifier proxy : eClassifiers) {
            if (proxy.getURI().equals(uri)) {
                return proxy;
            }
        }
        return null;
    }

    public void addChildren(ProxyEClassifier proxy) {
        if (proxy != null) {
            eClassifiers.add(proxy);
        }
    }

}
