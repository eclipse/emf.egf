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
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.helper.ObjectHolder;
import org.eclipse.egf.core.domain.TargetPlatformResourceSet;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.importer.ecore.EcoreImporter;
import org.eclipse.search.core.text.TextSearchEngine;
import org.eclipse.search.core.text.TextSearchRequestor;
import org.eclipse.search.core.text.TextSearchScope;
import org.eclipse.search.ui.text.FileTextSearchScope;

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

    private EcoreImporter importer;

    public static EcoreImporter createDefaultEcoreImporter() throws Exception {
        return new EcoreImporter();
    }

    public static EcoreImporter createEcoreImporter(IPath containterPath, URI ecoreURI, EmfGeneration model) throws Exception {
        return doCreateEcoreImporter(new EcoreImporterHelper(), containterPath, ecoreURI, model);
    }

    protected static EcoreImporter doCreateEcoreImporter(EcoreImporterHelper helper, IPath containterPath, URI ecoreURI, EmfGeneration model) throws Exception {
        helper.importer = new EcoreImporter() {
            public ResourceSet createResourceSet() {
                return new TargetPlatformResourceSet();
            }

            protected List<Resource> computeResourcesToBeSaved() {
                List<Resource> resources = new UniqueEList.FastCompare<Resource>();
                Resource genModelResource = getGenModel().eResource();
                resources.add(genModelResource);

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
        helper.importer.setGenModelContainerPath(containterPath);
        String name = ecoreURI.lastSegment().replace(ECORE_EXT, GENMODEL_EXT);
        helper.importer.setGenModelFileName(name);
        helper.importer.setModelLocation(ecoreURI.toString());

        // helper.importer.computeEPackages(MONITOR);
        // helper.importer.adjustEPackages(MONITOR);
        helper.importer.computeDefaultGenModelFileName();
        helper.importer.prepareGenModelAndEPackages(MONITOR);
        EList<GenPackage> genPackages = helper.importer.getGenModel().getGenPackages();
        helper.addEPackages(containterPath, ecoreURI, helper.importer, model);

        helper.importer.saveGenModelAndEPackages(MONITOR);
        return helper.importer;
    }

    private static Map<String, EPackage> asMap(List<EPackage> packages) {
        Map<String, EPackage> uri2package = new HashMap<String, EPackage>();
        for (EPackage pack : packages)
            uri2package.put(pack.getNsURI(), pack);
        return uri2package;
    }

    protected void addEPackages(IPath containterPath, URI ecoreURI, EcoreImporter ecoreImporter, EmfGeneration model) throws Exception {
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
                IPath ecorePath = new Path(ePackage.eResource().getURI().toString());
                Resource resource = getGenModelResource(ecorePath, genModel, model);

                if (resource != null && !resource.getContents().isEmpty()) {
                    for (EObject obj : resource.getContents())
                        genModel.getUsedGenPackages().addAll(((GenModel) obj).getGenPackages());
                } else {
                    handleMissingGenmodel(resourceSet, genModel, ecorePath);
                }

            } else
                genModel.getUsedGenPackages().addAll(genModels);
        }
    }

    protected void handleMissingGenmodel(ResourceSet resourceSet, GenModel genModel, IPath ecorePath) {
        String fileName = ecorePath.removeFileExtension().addFileExtension("genmodel").lastSegment();

        // look up in the workspace

        TextSearchScope fScope = FileTextSearchScope.newWorkspaceScope(new String[] { fileName }, false);
        final ObjectHolder<IFile> genModelFile = new ObjectHolder<IFile>();
        TextSearchRequestor collector = new TextSearchRequestor() {
            @Override
            public boolean acceptFile(IFile file) throws CoreException {
                genModelFile.object = file;
                return super.acceptFile(file);
            }
        };

        Pattern searchPattern = Pattern.compile("");
        TextSearchEngine.create().search(fScope, collector, searchPattern, null);
        URI uri = URI.createPlatformResourceURI(genModelFile.object.getFullPath().toString(), false);
        Resource resource = resourceSet.getResource(uri, true);
        if (resource != null && !resource.getContents().isEmpty()) {
            for (EObject obj : resource.getContents())
                genModel.getUsedGenPackages().addAll(((GenModel) obj).getGenPackages());
        } else
            throw new RuntimeException("can't find genmodel for " + ecorePath);
    }

    private static Resource getGenModelResource(IPath ecorePath, GenModel genModel, EmfGeneration model) {
        ResourceSet resourceSet = new TargetPlatformResourceSet();

        // try to find it closed to the ecore file
        IPath path = ecorePath.removeFileExtension().addFileExtension("genmodel");
        URI uri = URI.createURI(path.toString());
        Resource resource = null;
        try {
            resource = resourceSet.getResource(uri, true);
            if (resource != null && !resource.getContents().isEmpty())
                return resource;
        } catch (Exception e) {
        }

        // try to find corresponding genmodel in whole generationchain
        IPath ecoreAbsolutePath = ecorePath.setDevice(null).removeFirstSegments(1).makeAbsolute();

        TreeIterator<Object> iterator = EcoreUtil.getAllContents(EcoreUtil.getRootContainer(model), false);
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (next instanceof EmfGeneration) {
                EmfGeneration emfGeneration = (EmfGeneration) next;

                path = new Path(emfGeneration.getPluginName()).append(ecorePath.removeFirstSegments(2)).removeFileExtension().addFileExtension("genmodel");
                uri = URI.createPlatformResourceURI(path.toString(), false);

                if (emfGeneration.getModelPath().equals(ecoreAbsolutePath.toString())) {
                    try {
                        resource = resourceSet.getResource(uri, true);
                        if (resource != null && !resource.getContents().isEmpty())
                            return resource;
                    } catch (Exception e1) {
                    }
                }
            }
        }

        return null;
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
