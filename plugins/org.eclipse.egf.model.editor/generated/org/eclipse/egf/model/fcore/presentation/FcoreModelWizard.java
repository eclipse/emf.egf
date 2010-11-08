/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.fcore.presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.pde.tools.ConvertProjectOperation;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.provider.FcoreResourceItemProviderAdapterFactory;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

/**
 * This is a simple wizard for creating a new model file.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated NOT
 */
public class FcoreModelWizard extends Wizard implements INewWizard {

    /**
     * The supported extensions for created files.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(Arrays.asList(EGFModelEditorPlugin.INSTANCE.getString("_UI_FcoreEditorFilenameExtensions").split("\\s*,\\s*"))); //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * A formatted list of supported file extensions, suitable for display.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String FORMATTED_FILE_EXTENSIONS = EGFModelEditorPlugin.INSTANCE.getString("_UI_FcoreEditorFilenameExtensions").replaceAll("\\s*,\\s*", ", "); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

    /**
     * This is the file creation page.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected FcoreModelWizardNewFileCreationPage newFileCreationPage;

    /**
     * This is the initial object creation page.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected FcoreModelWizardInitialObjectCreationPage initialObjectCreationPage;

    /**
     * Remember the selection during initialization for populating the default
     * container.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IStructuredSelection selection;

    /**
     * Remember the workbench during initialization.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IWorkbench workbench;

    /**
     * Caches the names of the types that can be created as the root object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected List<String> initialObjectNames;

    /**
     * Caches the types that can be created as the root object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Map<String, EClass> roots = new HashMap<String, EClass>();

    /**
    * 
    */
    protected FcoreResourceItemProviderAdapterFactory factory;

    /**
     * This just records the information.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public void init(IWorkbench innerWorkbench, IStructuredSelection innerSelection) {
        this.workbench = innerWorkbench;
        this.selection = innerSelection;
        setWindowTitle(EGFModelEditorPlugin.INSTANCE.getString("_UI_Wizard_label")); //$NON-NLS-1$
        setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(EGFModelEditorPlugin.INSTANCE.getImage("full/wizban/NewFcore"))); //$NON-NLS-1$
        setNeedsProgressMonitor(true);
        factory = new FcoreResourceItemProviderAdapterFactory();
        for (EClass eClass : factory.getRoots()) {
            roots.put(eClass.getName(), eClass);
        }
    }

    /**
     * Returns the names of the types that can be created as the root object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected Collection<String> getInitialObjectNames() {
        if (initialObjectNames == null) {
            initialObjectNames = new ArrayList<String>();
            initialObjectNames.addAll(roots.keySet());
            Collections.sort(initialObjectNames, CommonPlugin.INSTANCE.getComparator());
        }
        return initialObjectNames;
    }

    /**
     * Create a new model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected EObject createInitialModel() {
        EClass eClass = roots.get(initialObjectCreationPage.getInitialObjectName());
        EObject eObject = eClass.getEPackage().getEFactoryInstance().create(eClass);
        eObject.eSet(FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME, getModelFile().getFullPath().removeFileExtension().lastSegment().toString());
        return eObject;
    }

    /**
     * Do the work after everything is specified.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public boolean performFinish() {

        // Variables
        final IFile modelFile = getModelFile();
        final Throwable[] throwable = new Throwable[1];
        final EObject rootObject = createInitialModel();

        // Convert and Process current Project
        WorkspaceModifyOperation convertOperation = new ConvertProjectOperation(modelFile.getProject(), rootObject instanceof FactoryComponent == false, false) {

            @Override
            public List<String> addDependencies() {
                List<String> dependencies = new ArrayList<String>(1);
                dependencies.add("org.eclipse.egf.model.ftask"); //$NON-NLS-1$              
                return dependencies;
            }

            @Override
            public List<String> addSourceFolders() {
                List<String> sourceFolders = new ArrayList<String>(1);
                sourceFolders.add("src"); //$NON-NLS-1$
                return sourceFolders;
            }
        };

        try {
            getContainer().run(false, false, convertOperation);
        } catch (Throwable t) {
            throwable[0] = t;
        }

        // Save resource
        if (throwable[0] == null) {

            WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {

                @Override
                protected void execute(IProgressMonitor monitor) {
                    SubMonitor.convert(monitor, EGFModelEditorPlugin.INSTANCE.getString("_UI_Wizard_createActivity"), 200); //$NON-NLS-1$
                    // Retrieve our editing domain
                    final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
                    try {
                        // Clear previous on error resources
                        URI uri = URIHelper.getPlatformPluginURI(modelFile.getFullPath());
                        Resource previousResource = editingDomain.getResourceSet().getResource(uri, false);
                        if (previousResource != null && previousResource.getContents().size() == 0 && previousResource.getErrors().isEmpty() == false) {
                            previousResource.unload();
                            previousResource.getResourceSet().getResources().remove(previousResource);
                        }
                        // Create a resource for this file.
                        final Resource resource = editingDomain.getResourceSet().createResource(uri);
                        // Add the initial model object to the contents.
                        if (rootObject != null) {
                            editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

                                @Override
                                protected void doExecute() {
                                    resource.getContents().add(rootObject);
                                }

                            });
                        }
                        editingDomain.runExclusive(new Runnable() {

                            public void run() {
                                try {
                                    resource.save(Collections.EMPTY_MAP);
                                } catch (Throwable t) {
                                    throwable[0] = t;
                                }
                            }

                        });
                    } catch (InterruptedException ie) {
                        throwable[0] = ie;
                    }
                }
            };

            try {
                getContainer().run(false, true, operation);
            } catch (Throwable t) {
                throwable[0] = t;
            }

        }

        // Select the new file resource in the current view.
        if (throwable[0] == null) {
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
            try {
                page.openEditor(new FileEditorInput(modelFile), workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());
            } catch (Throwable t) {
                throwable[0] = t;
            }
        }

        if (throwable[0] != null && throwable[0] instanceof InterruptedException == false) {
            ThrowableHandler.handleThrowable(EGFModelEditorPlugin.getPlugin().getBundle().getSymbolicName(), throwable[0]);
            return false;
        }

        return true;
    }

    /**
     * This is the one page of the wizard.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public static class FcoreModelWizardNewFileCreationPage extends WizardNewFileCreationPage {

        /**
         * Pass in the selection.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        public FcoreModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
            super(pageId, selection);
        }

        /**
         * The framework calls this to see if the file is correct.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        @Override
        protected boolean validatePage() {
            if (super.validatePage()) {
                String extension = new Path(getFileName()).getFileExtension();
                if (extension == null || !FILE_EXTENSIONS.contains(extension)) {
                    String key = FILE_EXTENSIONS.size() > 1 ? "_WARN_FilenameExtensions" : "_WARN_FilenameExtension"; //$NON-NLS-1$ //$NON-NLS-2$
                    setErrorMessage(EGFModelEditorPlugin.INSTANCE.getString(key, new Object[] {
                        FORMATTED_FILE_EXTENSIONS
                    }));
                    return false;
                }
                return true;
            }
            return false;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        public IFile getModelFile() {
            return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
        }
    }

    /**
     * This is the page where the type of object to create is selected.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public class FcoreModelWizardInitialObjectCreationPage extends WizardPage {

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        protected Combo initialObjectField;

        /**
         * Pass in the selection.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        public FcoreModelWizardInitialObjectCreationPage(String pageId) {
            super(pageId);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        public void createControl(Composite parent) {
            Composite composite = new Composite(parent, SWT.NONE);
            {
                GridLayout layout = new GridLayout();
                layout.numColumns = 1;
                layout.verticalSpacing = 12;
                composite.setLayout(layout);

                GridData data = new GridData();
                data.verticalAlignment = GridData.FILL;
                data.grabExcessVerticalSpace = true;
                data.horizontalAlignment = GridData.FILL;
                composite.setLayoutData(data);
            }

            Label containerLabel = new Label(composite, SWT.LEFT);
            {
                containerLabel.setText(EGFModelEditorPlugin.INSTANCE.getString("_UI_ModelObject")); //$NON-NLS-1$

                GridData data = new GridData();
                data.horizontalAlignment = GridData.FILL;
                containerLabel.setLayoutData(data);
            }

            initialObjectField = new Combo(composite, SWT.BORDER);
            {
                GridData data = new GridData();
                data.horizontalAlignment = GridData.FILL;
                data.grabExcessHorizontalSpace = true;
                initialObjectField.setLayoutData(data);
            }

            for (String objectName : getInitialObjectNames()) {
                initialObjectField.add(getLabel(objectName));
            }

            initialObjectField.select(0);
            initialObjectField.addModifyListener(validator);

            setPageComplete(validatePage());
            setControl(composite);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        protected ModifyListener validator = new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                setPageComplete(validatePage());
            }
        };

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        protected boolean validatePage() {
            return getInitialObjectName() != null;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        @Override
        public void setVisible(boolean visible) {
            super.setVisible(visible);
            if (visible) {
                if (initialObjectField.getItemCount() == 1) {
                    initialObjectField.clearSelection();
                } else {
                    initialObjectField.setFocus();
                }
            }
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        public String getInitialObjectName() {
            String label = initialObjectField.getText();
            for (String name : getInitialObjectNames()) {
                if (getLabel(name).equals(label)) {
                    return name;
                }
            }
            return null;
        }

        /**
         * Returns the label for the specified type name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated NOT
         */
        protected String getLabel(String typeName) {
            try {
                return factory.getResourceLocator().getString("_UI_" + typeName + "_type"); //$NON-NLS-1$ //$NON-NLS-2$
            } catch (MissingResourceException mre) {
                EGFModelEditorPlugin.INSTANCE.log(mre);
            }
            return typeName;
        }

    }

    /**
     * The framework calls this to create the contents of the wizard.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void addPages() {
        // Create a page, set the title, and the initial model file name.
        //
        newFileCreationPage = new FcoreModelWizardNewFileCreationPage("Whatever", selection); //$NON-NLS-1$
        newFileCreationPage.setTitle(EGFModelEditorPlugin.INSTANCE.getString("_UI_FcoreModelWizard_label")); //$NON-NLS-1$
        newFileCreationPage.setDescription(EGFModelEditorPlugin.INSTANCE.getString("_UI_FcoreModelWizard_description")); //$NON-NLS-1$
        newFileCreationPage.setFileName(EGFModelEditorPlugin.INSTANCE.getString("_UI_FcoreEditorFilenameDefaultBase") + "." + FILE_EXTENSIONS.get(0)); //$NON-NLS-1$ //$NON-NLS-2$
        addPage(newFileCreationPage);

        // Try and get the resource selection to determine a current directory
        // for the file dialog.
        //
        if (selection != null && !selection.isEmpty()) {
            // Get the resource...
            //
            Object selectedElement = selection.iterator().next();
            if (selectedElement instanceof IResource) {
                // Get the resource parent, if its a file.
                //
                IResource selectedResource = (IResource) selectedElement;
                if (selectedResource.getType() == IResource.FILE) {
                    selectedResource = selectedResource.getParent();
                }

                // This gives us a directory...
                //
                if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
                    // Set this for the container.
                    //
                    newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

                    // Make up a unique new name here.
                    //
                    String defaultModelBaseFilename = EGFModelEditorPlugin.INSTANCE.getString("_UI_FcoreEditorFilenameDefaultBase"); //$NON-NLS-1$
                    String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
                    String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension; //$NON-NLS-1$
                    for (int i = 1; ((IContainer) selectedResource).findMember(modelFilename) != null; ++i) {
                        modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension; //$NON-NLS-1$
                    }
                    newFileCreationPage.setFileName(modelFilename);
                }
            }
        }
        initialObjectCreationPage = new FcoreModelWizardInitialObjectCreationPage("Whatever2"); //$NON-NLS-1$
        initialObjectCreationPage.setTitle(EGFModelEditorPlugin.INSTANCE.getString("_UI_FcoreModelWizard_label")); //$NON-NLS-1$
        initialObjectCreationPage.setDescription(EGFModelEditorPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description")); //$NON-NLS-1$
        addPage(initialObjectCreationPage);
    }

    /**
     * Get the file from the page.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public IFile getModelFile() {
        return newFileCreationPage.getModelFile();
    }

}
