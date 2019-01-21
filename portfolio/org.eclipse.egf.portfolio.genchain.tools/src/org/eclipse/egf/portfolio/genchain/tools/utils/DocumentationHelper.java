/**
 * <copyright>
 *
 *  Copyright (c) 2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.model.domain.TypeDomain;
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
        EMFDomain domain = ActivityInvocationHelper.getDomain(dvp, uri);

        TypeDomain typeEMFDomain = DomainFactory.eINSTANCE.createTypeDomain();
        typeEMFDomain.setDomain(domain);
        contract2type.put("domain", typeEMFDomain);

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

    static final URI DOCUMENTATION_ACTIVITY_MODEL_URI = URI.createURI("platform:/plugin/org.eclipse.egf.emf.docgen.html/egf/EmfDocGenHtml.fcore#_BxjIkAG0Ed-7fNNmMjB2jQ", false);

}
