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

    public static void addDocumentationFCInvocation(FactoryComponent mainFC, String name, String configurationFilePath, String ecorePath, String outputDirectoryPath, String ecoreWorkingSet) {
        FactoryComponent fc = mainFC;
        Resource eResource = mainFC.eResource();
        ResourceSet resourceSet = eResource.getResourceSet();

        ProductionPlan pp = (ProductionPlan) fc.getOrchestration();
        Activity activity = getActivity(resourceSet, DOC_GEN_ACTIVITY_MODEL_URI, DOC_GEN_ACTIVITY_ID);
        Map<String, Type> contract2type = new HashMap<String, Type>();
        TypeString typeString = TypesFactory.eINSTANCE.createTypeString();
        typeString.setValue(configurationFilePath);
        contract2type.put("configurationFilePath", typeString);

        typeString = TypesFactory.eINSTANCE.createTypeString();
        typeString.setValue(ecorePath);
        contract2type.put("ecoreFilePath", typeString);

        typeString = TypesFactory.eINSTANCE.createTypeString();
        typeString.setValue(outputDirectoryPath);
        contract2type.put("outputDirectoryPath", typeString);

        typeString = TypesFactory.eINSTANCE.createTypeString();
        typeString.setValue(ecoreWorkingSet);
        contract2type.put("ecoreWorkingSet", typeString);

        ActivityInvocationHelper.addInvocation(pp, activity, contract2type);

    }

    private static Activity getActivity(ResourceSet resourceSet, URI uri, String id) {
        return (Activity) resourceSet.getResource(uri, true).getEObject(id);
    }

    static final URI DOC_GEN_ACTIVITY_MODEL_URI = URI.createPlatformPluginURI("/com.thalesgroup.mde.emf.doc.egf.fc/model/EcoreDocumentationGenerator.fcore", false);
    static final String DOC_GEN_ACTIVITY_ID = "_OfhqEDf5Ed-kIMxG-EYTcA";

}
