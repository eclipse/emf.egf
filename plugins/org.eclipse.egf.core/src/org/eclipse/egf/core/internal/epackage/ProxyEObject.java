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
package org.eclipse.egf.core.internal.epackage;

import org.eclipse.egf.core.epackage.IProxyEObject;
import org.eclipse.emf.common.util.URI;

/**
 * @author Xavier Maysonnave
 *
 */
public abstract class ProxyEObject implements IProxyEObject {

    private String _name;

    private String _instanceClassName;

    private URI _uri;

    private IProxyEObject _parent;

    public ProxyEObject(String name, String instanceClassName, URI uri) {
        this(null, name, instanceClassName, uri);
    }

    public ProxyEObject(IProxyEObject parent, String name, String instanceClassName, URI uri) {
        _parent = parent;
        _name = name;
        _instanceClassName = instanceClassName;
        _uri = uri;
    }

    public IProxyEObject getParent() {
        return _parent;
    }

    public String getName() {
        return _name;
    }

    public String getInstanceClassName() {
        return _instanceClassName;
    }

    public URI getURI() {
        return _uri;
    }

}
