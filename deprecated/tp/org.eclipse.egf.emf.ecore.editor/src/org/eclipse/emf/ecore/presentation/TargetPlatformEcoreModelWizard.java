/**
 * <copyright>
 * 
 * Copyright (c) 2004-2007 IBM Corporation and others.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * IBM - Initial API and implementation
 * Xavier Maysonnave - Thales Corporate Services S.A.S - Target Platform contribution
 * 
 * </copyright>
 * 
 * $Id: EcoreModelWizard.java,v 1.17 2008/04/27 20:30:36 davidms Exp $
 */
package org.eclipse.emf.ecore.presentation;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TargetPlatformEcoreModelWizard extends EcoreModelWizard {

    /**
     * Do the work after everything is specified.
     */
    @Override
    public boolean performFinish() {
        try {
            // Remember the file.
            //
            final IFile modelFile = getModelFile();

            // Do the work within an operation.
            //
            WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {

                @Override
                protected void execute(IProgressMonitor progressMonitor) {
                    try {
                        // Create a resource set
                        //
                        ResourceSet resourceSet = new ResourceSetImpl();
                        resourceSet.setURIConverter(EGFCorePlugin.getTargetPlatformURIConverter());

                        // Get the URI of the model file.
                        //
                        URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);

                        // Create a resource for this file. Don't specify a content type, as it could be Ecore or EMOF.
                        //
                        Resource resource = resourceSet.createResource(fileURI);

                        // Add the initial model object to the contents.
                        //
                        EObject rootObject = createInitialModel();
                        if (rootObject != null) {
                            resource.getContents().add(rootObject);
                        }

                        // Save the contents of the resource to the file system.
                        //
                        Map<Object, Object> options = new HashMap<Object, Object>();
                        options.put(XMLResource.OPTION_ENCODING, initialObjectCreationPage.getEncoding());
                        resource.save(options);
                    } catch (Exception exception) {
                        EcoreEditorPlugin.INSTANCE.log(exception);
                    } finally {
                        progressMonitor.done();
                    }
                }
            };

            getContainer().run(false, false, operation);

            // Select the new file resource in the current view.
            //
            IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
            IWorkbenchPage page = workbenchWindow.getActivePage();
            final IWorkbenchPart activePart = page.getActivePart();
            if (activePart instanceof ISetSelectionTarget) {
                final ISelection targetSelection = new StructuredSelection(modelFile);
                getShell().getDisplay().asyncExec(new Runnable() {

                    public void run() {
                        ((ISetSelectionTarget) activePart).selectReveal(targetSelection);
                    }
                });
            }

            // Open an editor on the new file.
            //
            try {
                page.openEditor(new FileEditorInput(modelFile), "org.eclipse.emf.ecore.presentation.TargetPlatformEcoreEditorID"); //$NON-NLS-1$
            } catch (PartInitException exception) {
                MessageDialog.openError(workbenchWindow.getShell(), EcoreEditorPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage()); //$NON-NLS-1$
                return false;
            }

            return true;
        } catch (Exception exception) {
            EcoreEditorPlugin.INSTANCE.log(exception);
            return false;
        }
    }

}
