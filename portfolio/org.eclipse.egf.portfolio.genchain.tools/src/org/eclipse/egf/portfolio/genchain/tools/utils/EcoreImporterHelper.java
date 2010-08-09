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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.core.domain.EGFResourceSet;
import org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.importer.ecore.EcoreImporter;

/**
 * 
 * @author Thomas Guiu
 */
public class EcoreImporterHelper {
    protected static final BasicMonitor MONITOR = new BasicMonitor();
    protected static final NullProgressMonitor NULL_PROGRESS_MONITOR = new NullProgressMonitor();
    protected static final String GENMODEL_EXT = ".genmodel";
    protected static final String FCORE_EXT = ".fcore";
    protected static final String ECORE_EXT = ".ecore";

    public static EcoreImporter createDefaultEcoreImporter() throws Exception {
        return new EcoreImporter();
    }

    public static EcoreImporter createEcoreImporter(IPath containterPath, URI ecoreURI, EmfGeneration model) throws Exception {
        EcoreImporter ecoreImporter = new EcoreImporter() {
            public ResourceSet createResourceSet() {
                return new EGFResourceSet();
            }

            protected List<Resource> computeResourcesToBeSaved() {
                List<Resource> resources = new UniqueEList.FastCompare<Resource>();
                Resource genModelResource = getGenModel().eResource();
                resources.add(genModelResource);
                // for (GenPackage genPackage : getGenModel().getGenPackages())
                // {
                // resources.add(genPackage.getEcorePackage().eResource());
                // }

                // Handle application genmodel stub
                //
                for (GenPackage genPackage : getGenModel().getUsedGenPackages()) {
                    if (genPackage.eResource() == genModelResource) {
                        resources.add(genPackage.getEcorePackage().eResource());
                    }
                }

                return resources;
            }

        };
        ecoreImporter.setGenModelContainerPath(containterPath);
        String name = ecoreURI.lastSegment().replace(ECORE_EXT, GENMODEL_EXT);
        ecoreImporter.setGenModelFileName(name);
        ecoreImporter.setModelLocation(ecoreURI.toString());

        // ecoreImporter.computeEPackages(MONITOR);
        // ecoreImporter.adjustEPackages(MONITOR);
        ecoreImporter.computeDefaultGenModelFileName();
        ecoreImporter.prepareGenModelAndEPackages(MONITOR);
        EList<GenPackage> genPackages = ecoreImporter.getGenModel().getGenPackages();
        addEPackages(containterPath, ecoreURI, ecoreImporter, model);

        ecoreImporter.saveGenModelAndEPackages(MONITOR);
        return ecoreImporter;
    }

    private static Map<String, EPackage> asMap(List<EPackage> packages) {
        Map<String, EPackage> uri2package = new HashMap<String, EPackage>();
        for (EPackage pack : packages)
            uri2package.put(pack.getNsURI(), pack);
        return uri2package;
    }

    private static void addEPackages(IPath containterPath, URI ecoreURI, EcoreImporter ecoreImporter, EmfGeneration model) throws Exception {
        ResourceSet resourceSet = ecoreImporter.getGenModel().eResource().getResourceSet();
        List<EPackage> ePackages = getOwnEPackages(resourceSet, ecoreURI);

        GenModel genModel = ecoreImporter.getGenModel();
        genModel.initialize(ePackages);

        ecoreImporter.computeEPackages(MONITOR);
        ecoreImporter.adjustEPackages(MONITOR);

        List<EPackage> allEPackages = ecoreImporter.getEPackages();
        Map<String, EPackage> requiredEPackages = asMap(allEPackages);

        for (EPackage ePackage : ePackages)
            requiredEPackages.remove(ePackage.getNsURI());

        for (EPackage ePackage : requiredEPackages.values()) {
            List<GenPackage> genModels = getPluginGenModel(ePackage);
            if (genModels.isEmpty()) {
                // try to find it closed to the ecore file
                IPath ecorePath, path = new Path(ePackage.eResource().getURI().toString());
                ecorePath = path;
                path = path.removeFileExtension().addFileExtension("genmodel");
                URI uri = URI.createURI(path.toString());
                Resource resource = null;
                try {
                    resource = resourceSet.getResource(uri, true);
                } catch (Exception e) {

                }
                if (resource != null && !resource.getContents().isEmpty()) {
                    for (EObject obj : resource.getContents())
                        genModel.getUsedGenPackages().addAll(((GenModel) obj).getGenPackages());
                } else {
                    // try to find it in our work folder
                    path = containterPath.append(ecorePath.lastSegment()).removeFileExtension().addFileExtension("genmodel");
                    uri = URI.createPlatformPluginURI(path.toString(), false);
                    try {
                        resource = resourceSet.getResource(uri, true);
                        for (EObject obj : resource.getContents())
                            genModel.getUsedGenPackages().addAll(((GenModel) obj).getGenPackages());
                    } catch (Exception e1) {
                        e1.printStackTrace();
                        throw new RuntimeException("can't find genmodel for " + ecorePath + "\n" + e1.getMessage());
                    }

                }

            } else
                genModel.getUsedGenPackages().addAll(genModels);
        }
    }

    private static List<GenPackage> getPluginGenModel(EPackage ePackage) {
        ResourceSet resourceSet = ePackage.eResource().getResourceSet();

        Map<String, URI> ePackageNsURItoGenModelLocationMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap();
        for (Entry<String, URI> entry : ePackageNsURItoGenModelLocationMap.entrySet()) {
            if (entry.getKey().equals(ePackage.getNsURI())) {
                URI value = entry.getValue();
                Resource resource = resourceSet.getResource(value, true);
                GenModel eObject = (GenModel) resource.getContents().get(0);
                return eObject.getGenPackages();
            }
        }
        return Collections.emptyList();
    }

    private static List<EPackage> getOwnEPackages(ResourceSet resourceSet, URI ecoreURI) {
        List<EPackage> result = new ArrayList<EPackage>();
        Resource resource = resourceSet.getResource(ecoreURI, true);
        TreeIterator<EObject> allContents = resource.getAllContents();
        while (allContents.hasNext()) {
            EObject next = allContents.next();
            if (next instanceof EPackage) {
                EPackage ePackage = (EPackage) next;
                result.add(ePackage);
            }
        }
        return result;
    }

}
