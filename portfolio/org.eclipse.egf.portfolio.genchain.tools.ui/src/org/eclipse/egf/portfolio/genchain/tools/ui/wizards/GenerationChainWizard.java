/**
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.portfolio.genchain.tools.ui.wizards;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.portfolio.genchain.extension.ExtensionHelper;
import org.eclipse.egf.portfolio.genchain.extension.ExtensionProperties;
import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainFactory;
import org.eclipse.egf.portfolio.genchain.tools.ui.Activator;
import org.eclipse.egf.portfolio.genchain.tools.ui.Messages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.ISetSelectionTarget;

/**
 * 
 * @author Thomas Guiu
 */
public class GenerationChainWizard extends Wizard implements INewWizard, ExtensionProperties {

    private EcoreModelPage ecorePage;
    private NewFilePage filePage;
    private final Node model = new Node(NodeTypes.ROOT);
    private IStructuredSelection selection;
    private IWorkbench workbench;

    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
        this.selection = selection;
    }

    public void addPages() {
        filePage = new NewFilePage("newFile", selection);//$NON-NLS-1$
        filePage.setTitle(Messages.genchain_wizard_title);
        filePage.setDescription(Messages.genchain_wizard_file_description);
        addPage(filePage);

        // TODO add a page to choose the name and factory component name

        ecorePage = new EcoreModelPage("ecore", model, selection);//$NON-NLS-1$
        ecorePage.setTitle(Messages.genchain_wizard_title);
        ecorePage.setDescription(Messages.genchain_wizard_content_description);
        addPage(ecorePage);
    }

    private EObject createInitialModel(IFile modelFile) {

        final GenerationChain root = GenerationChainFactory.eINSTANCE.createGenerationChain();
        final String name = modelFile.getName();
        final String shortName = name.substring(0, name.indexOf('.'));
        root.setName(shortName);
        root.setFactoryComponentName("org.eclipse.egf.chain." + shortName.toLowerCase());//$NON-NLS-1$

        init(root);

        return root;
    }

    private void init(GenerationChain root) {
        final Map<String, ExtensionHelper> extensionsAsMap = ExtensionHelper.getExtensionsAsMap();
        final Set<Node> checkedElements = ecorePage.getCheckedElements();

        for (Node containerNode : model.getChildren()) {
            GenerationChain container = GenerationChainFactory.eINSTANCE.createGenerationChain();
            root.getElements().add(container);

            container.setName(containerNode.getName());
            for (Node extensionNode : containerNode.getChildren()) {
                String id = extensionNode.getProperties().get(ID);
                String modelName = getModelName(extensionNode.getProperties().get(MODEL_PATH));
                ExtensionHelper extensionHelper = extensionsAsMap.get(id);
                if (checkedElements.contains(extensionNode)) {
                    Map<String, String> properties = new HashMap<String, String>();
                    for (Node propertyNode : extensionNode.getChildren()) {
                        properties.put(propertyNode.getName(), propertyNode.getProperties().get(PROPERTY_VALUE));
                    }
                    properties.putAll(extensionNode.getProperties());
                    EcoreElement leaf = extensionHelper.createEcoreElement(properties);
                    leaf.setName(Messages.bind(Messages.genchain_wizard_element_name_creation, extensionNode.getName(), modelName));
                    container.getElements().add(leaf);
                }
            }
        }
    }

    @Override
    public boolean performFinish() {

        final IFile modelFile = filePage.getModelFile();

        // Do the work within an operation.
        //
        WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
            @Override
            protected void execute(IProgressMonitor progressMonitor) {
                try {
                    // Create a resource set
                    //
                    ResourceSet resourceSet = new ResourceSetImpl();

                    // Get the URI of the model file.
                    //
                    URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);

                    // Create a resource for this file.
                    //
                    Resource resource = resourceSet.createResource(fileURI);

                    // Add the initial model object to the contents.
                    //
                    EObject rootObject = createInitialModel(modelFile);
                    if (rootObject != null) {
                        resource.getContents().add(rootObject);
                    }

                    // Save the contents of the resource to the file system.
                    //
                    Map<Object, Object> options = new HashMap<Object, Object>();
                    resource.save(options);
                } catch (Exception exception) {
                    Activator.getDefault().logError(exception);
                } finally {
                    progressMonitor.done();
                }
            }

        };

        try {
            getContainer().run(false, false, operation);
        } catch (Exception e) {
            Activator.getDefault().logError(e);
            return false;
        }

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
        return true;
    }

    static String getModelName(String modelPath) {
        return modelPath.substring(modelPath.lastIndexOf('/') + 1, modelPath.lastIndexOf('.'));
    }

    static String getBundleName(String modelPath) {
        return modelPath.substring(1, modelPath.indexOf('/', 1));
    }
}
