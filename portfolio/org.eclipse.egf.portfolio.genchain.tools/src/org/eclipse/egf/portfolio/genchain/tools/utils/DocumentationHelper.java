/**
 * <copyright>
 *
 *  Copyright (c) 2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.portfolio.genchain.tools.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.domain.TypeDomainURI;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.types.Type;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * 
 * @author Thomas Guiu
 */
public class DocumentationHelper {

    public static void addDocumentationInvocation(FactoryComponent mainFC, String ecorePath, String outputDirectoryPath, String plugin) {
        FactoryComponent fc = mainFC;
        Resource eResource = mainFC.eResource();
        ResourceSet resourceSet = eResource.getResourceSet();

        ProductionPlan pp = (ProductionPlan) fc.getOrchestration();
        Activity activity = getActivity(resourceSet, DOCUMENTATION_ACTIVITY_MODEL_URI);
        Map<String, Type> contract2type = new HashMap<String, Type>();

        DomainViewpoint dvp = (DomainViewpoint) mainFC.getViewpointContainer().getViewpoint(DomainViewpoint.class);
        URI uri = URI.createPlatformPluginURI(ecorePath, false);
        DomainURI domain = ActivityInvocationHelper.getDomain(dvp, uri);

        TypeDomainURI typeDomainURI = DomainFactory.eINSTANCE.createTypeDomainURI();
        typeDomainURI.setDomain(domain);
        contract2type.put("domain", typeDomainURI);

        TypeString typeString = TypesFactory.eINSTANCE.createTypeString();
        typeString.setValue(outputDirectoryPath);
        contract2type.put("outputFolder", typeString);

        typeString = TypesFactory.eINSTANCE.createTypeString();
        typeString.setValue(plugin);
        contract2type.put("projectName", typeString);

        ActivityInvocationHelper.addInvocation(pp, activity, contract2type);

    }

    private static Activity getActivity(ResourceSet resourceSet, URI uri) {
        return (Activity) resourceSet.getEObject(uri, true);
    }

    static final URI DOCUMENTATION_ACTIVITY_MODEL_URI = URI.createPlatformPluginURI("/org.eclipse.egf.emf.docgen.html/egf/EmfDocGenHtml.fcore#_BxjIkAG0Ed-7fNNmMjB2jQ", false);

}
