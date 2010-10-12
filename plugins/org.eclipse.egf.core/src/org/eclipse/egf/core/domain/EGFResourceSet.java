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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFResourceSet extends ResourceSetImpl {

    protected class EGFResourcesEList<E extends Object & Resource> extends ResourcesEList<E> {

        private static final long serialVersionUID = 1L;

        private Map<URI, Resource> _uriResourceMap;

        public EGFResourcesEList(Map<URI, Resource> uriResourceMap) {
            super();
            _uriResourceMap = uriResourceMap;
        }

        @Override
        public E remove(int i) {
            E object = super.remove(i);
            if (object != null) {
                _uriResourceMap.remove(((Resource) object).getURI());
            }
            return object;
        }

    }

    public EGFResourceSet() {
        super();
        setURIResourceMap(new HashMap<URI, Resource>());
        setURIConverter(EGFCorePlugin.getPlatformURIConverter());
    }

    @Override
    public Resource getResource(URI uri, boolean loadOnDemand) {
        if (uri == null) {
            return null;
        }
        return super.getResource(URI.createURI(URI.decode(uri.toString())), loadOnDemand);
    }

    @Override
    public EList<Resource> getResources() {
        if (resources == null) {
            resources = new EGFResourcesEList<Resource>(getURIResourceMap());
        }
        return resources;
    }

}
