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
package org.eclipse.emf.importer.ui;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.emf.importer.l10n.TargetPlatformEMFImporterMessages;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.importer.ui.contribution.ModelImporterDescriptor;
import org.eclipse.emf.importer.ui.contribution.ModelImporterManager;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TargetPlatformEMFModelWizard extends EMFModelWizard {

    public TargetPlatformEMFModelWizard() {
        super();
        setWindowTitle(TargetPlatformEMFImporterMessages._UI_EMFWizardModel_title);
    }

    public TargetPlatformEMFModelWizard(IFile reloadFile) {
        super(reloadFile);
        setWindowTitle(TargetPlatformEMFImporterMessages._UI_ReloadWizard_title);
    }

    @Override
    protected ModelImporterDescriptor computeSuggestedDescriptor() {

        ModelImporterDescriptor descriptor = null;

        if (defaultDescriptorID != null) {
            descriptor = ModelImporterManager.INSTANCE.getModelImporterDescriptor(defaultDescriptorID);
            if (descriptor != null) {
                return descriptor;
            }
        }

        if (reloadFile != null) {
            URI reloadURI = URI.createPlatformResourceURI(reloadFile.getFullPath().toString(), true);
            ResourceSet resourceSet = new ResourceSetImpl();
            resourceSet.setURIConverter(EGFCorePlugin.getTargetPlatformURIConverter());
            Resource reloadResource = null;
            try {
                reloadResource = resourceSet.getResource(reloadURI, true);
            } catch (RuntimeException e) {
                reloadResource = resourceSet.getResource(reloadURI, false);
            }

            if (reloadResource != null && !reloadResource.getContents().isEmpty()) {
                Object content = reloadResource.getContents().get(0);
                if (content instanceof GenModel) {
                    GenModel genModel = (GenModel) content;
                    if (genModel.getImporterID() != null) {
                        descriptor = ModelImporterManager.INSTANCE.getModelImporterDescriptor(genModel.getImporterID());
                    } else if (!genModel.getForeignModel().isEmpty()) {
                        String foreignModel = genModel.getForeignModel().get(0);
                        if (foreignModel.endsWith(".mdl")) { //$NON-NLS-1$
                            descriptor = ModelImporterManager.INSTANCE.getModelImporterDescriptor("org.eclipse.emf.importer.rose"); //$NON-NLS-1$
                        } else if (foreignModel.endsWith(".xsd") || foreignModel.endsWith(".wsdl")) { //$NON-NLS-1$ //$NON-NLS-2$
                            descriptor = ModelImporterManager.INSTANCE.getModelImporterDescriptor("org.eclipse.xsd.ecore.importer"); //$NON-NLS-1$
                        } else if (foreignModel.endsWith("@model")) { //$NON-NLS-1$
                            descriptor = ModelImporterManager.INSTANCE.getModelImporterDescriptor("org.eclipse.emf.importer.java"); //$NON-NLS-1$
                        } else if (foreignModel.endsWith(".ecore") || foreignModel.endsWith(".emof")) { //$NON-NLS-1$ //$NON-NLS-2$
                            descriptor = ModelImporterManager.INSTANCE.getModelImporterDescriptor("org.eclipse.emf.importer.ecore"); //$NON-NLS-1$
                        }
                    }
                }
            }
        }

        if (descriptor == null) {
            if (selection != null && !selection.isEmpty()) {
                Object element = selection.getFirstElement();
                if (element instanceof IFile) {
                    String fileExtension = ((IFile) element).getFileExtension();
                    descriptor = ModelImporterManager.INSTANCE.getModelImporterDescriptor(selectionPage.getLastModelConverterDescriptorId());
                    if (descriptor == null || !descriptor.getExtensions().contains(fileExtension)) {
                        List<ModelImporterDescriptor> descriptors = ModelImporterManager.INSTANCE.filterModelImporterDescriptors(fileExtension);
                        if (!descriptors.isEmpty()) {
                            descriptor = descriptors.get(0);
                        }
                    }
                    if (descriptor != null) {
                        modelFile = ((IFile) element);
                    }
                }
            }
        }

        return descriptor;
    }

}
