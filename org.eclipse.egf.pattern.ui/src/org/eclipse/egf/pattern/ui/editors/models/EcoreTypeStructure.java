/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.models;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author xrchen
 * 
 */
public class EcoreTypeStructure {

    private Resource resource;
    
    private List<Resource> resources = new ArrayList<Resource>();

    public List<Resource> getResources() {
        return resources;
    }

    public Resource getResource() {
        return resource;
    }

    public void addResource(Resource resource) {
        this.resource = resource;
        resources.add(resource);
    }
}
