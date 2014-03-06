/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    All rights reserved. This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v1.0
 *    which accompanies this distribution, and is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 *   
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.buildcore.presentation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.StringTokenizer;

import org.eclipse.emf.common.CommonPlugin;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.xmi.XMLResource;

import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.jface.dialogs.MessageDialog;

import org.eclipse.jface.viewers.IStructuredSelection;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import org.eclipse.ui.actions.WorkspaceModifyOperation;

import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcoreFactory;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.provider.BuildCoreEditPlugin;


import org.eclipse.core.runtime.Path;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;


/**
 * This is a simple wizard for creating a new model file.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BuildcoreModelWizard extends Wizard implements INewWizard {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * The supported extensions for created files.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<String> FILE_EXTENSIONS =
        Collections.unmodifiableList(Arrays.asList(BuildCoreEditPlugin.INSTANCE.getString("_UI_BuildcoreEditorFilenameExtensions").split("\\s*,\\s*")));

    /**
     * A formatted list of supported file extensions, suitable for display.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String FORMATTED_FILE_EXTENSIONS =
        BuildCoreEditPlugin.INSTANCE.getString("_UI_BuildcoreEditorFilenameExtensions").replaceAll("\\s*,\\s*", ", ");

    /**
     * This caches an instance of the model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BuildcorePackage buildcorePackage = BuildcorePackage.eINSTANCE;

    /**
     * This caches an instance of the model factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BuildcoreFactory buildcoreFactory = buildcorePackage.getBuildcoreFactory();

    /**
     * This is the file creation page.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BuildcoreModelWizardNewFileCreationPage newFileCreationPage;

    /**
     * This is the initial object creation page.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BuildcoreModelWizardInitialObjectCreationPage initialObjectCreationPage;

    /**
     * Remember the selection during initialization for populating the default container.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IStructuredSelection selection;

    /**
     * Remember the workbench during initialization.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IWorkbench workbench;

    /**
     * Caches the names of the types that can be created as the root object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected List<String> initialObjectNames;

    /**
     * This just records the information.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
        this.selection = selection;
        setWindowTitle(BuildCoreEditPlugin.INSTANCE.getString("_UI_Wizard_label"));
        setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(BuildCoreEditPlugin.INSTANCE.getImage("full/wizban/NewBuildcore")));
    }

    /**
     * Returns the names of the types that can be created as the root object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Collection<String> getInitialObjectNames() {
        if (initialObjectNames == null) {
            initialObjectNames = new ArrayList<String>();
            for (EClassifier eClassifier : buildcorePackage.getEClassifiers()) {
                if (eClassifier instanceof EClass) {
                    EClass eClass = (EClass)eClassifier;
                    if (!eClass.isAbstract()) {
                        initialObjectNames.add(eClass.getName());
                    }
                }
            }
            Collections.sort(initialObjectNames, CommonPlugin.INSTANCE.getComparator());
        }
        return initialObjectNames;
    }

    /**
     * Create a new model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EObject createInitialModel() {
        EClass eClass = (EClass)buildcorePackage.getEClassifier(initialObjectCreationPage.getInitialObjectName());
        EObject rootObject = buildcoreFactory.create(eClass);
        return rootObject;
    }

    /**
     * Do the work after everything is specified.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean performFinish() {
        try {
            // Remember the file.
            //
            final IFile modelFile = getModelFile();

            // Do the work within an operation.
            //
            WorkspaceModifyOperation operation =
                new WorkspaceModifyOperation() {
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
                            EObject rootObject = createInitialModel();
                            if (rootObject != null) {
                                resource.getContents().add(rootObject);
                            }

                            // Save the contents of the resource to the file system.
                            //
                            Map<Object, Object> options = new HashMap<Object, Object>();
                            options.put(XMLResource.OPTION_ENCODING, initialObjectCreationPage.getEncoding());
                            resource.save(options);
                        }
                        catch (Exception exception) {
                            BuildCoreEditPlugin.INSTANCE.log(exception);
                        }
                        finally {
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
                getShell().getDisplay().asyncExec
                    (new Runnable() {
                         public void run() {
                             ((ISetSelectionTarget)activePart).selectReveal(targetSelection);
                         }
                     });
            }

            // Open an editor on the new file.
            //
            try {
                page.openEditor
                    (new FileEditorInput(modelFile),
                     workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());					 	 
            }
            catch (PartInitException exception) {
                MessageDialog.openError(workbenchWindow.getShell(), BuildCoreEditPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
                return false;
            }

            return true;
        }
        catch (Exception exception) {
            BuildCoreEditPlugin.INSTANCE.log(exception);
            return false;
        }
    }

    /**
     * This is the one page of the wizard.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public class BuildcoreModelWizardNewFileCreationPage extends WizardNewFileCreationPage {
        /**
         * Pass in the selection.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public BuildcoreModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
            super(pageId, selection);
        }

        /**
         * The framework calls this to see if the file is correct.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected boolean validatePage() {
            if (super.validatePage()) {
                String extension = new Path(getFileName()).getFileExtension();
                if (extension == null || !FILE_EXTENSIONS.contains(extension)) {
                    String key = FILE_EXTENSIONS.size() > 1 ? "_WARN_FilenameExtensions" : "_WARN_FilenameExtension";
                    setErrorMessage(BuildCoreEditPlugin.INSTANCE.getString(key, new Object [] { FORMATTED_FILE_EXTENSIONS }));
                    return false;
                }
                return true;
            }
            return false;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
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
     * @generated
     */
    public class BuildcoreModelWizardInitialObjectCreationPage extends WizardPage {
        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected Combo initialObjectField;

        /**
         * @generated
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         */
        protected List<String> encodings;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected Combo encodingField;

        /**
         * Pass in the selection.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public BuildcoreModelWizardInitialObjectCreationPage(String pageId) {
            super(pageId);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void createControl(Composite parent) {
            Composite composite = new Composite(parent, SWT.NONE); {
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
                containerLabel.setText(BuildCoreEditPlugin.INSTANCE.getString("_UI_ModelObject"));

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

            if (initialObjectField.getItemCount() == 1) {
                initialObjectField.select(0);
            }
            initialObjectField.addModifyListener(validator);

            Label encodingLabel = new Label(composite, SWT.LEFT);
            {
                encodingLabel.setText(BuildCoreEditPlugin.INSTANCE.getString("_UI_XMLEncoding"));

                GridData data = new GridData();
                data.horizontalAlignment = GridData.FILL;
                encodingLabel.setLayoutData(data);
            }
            encodingField = new Combo(composite, SWT.BORDER);
            {
                GridData data = new GridData();
                data.horizontalAlignment = GridData.FILL;
                data.grabExcessHorizontalSpace = true;
                encodingField.setLayoutData(data);
            }

            for (String encoding : getEncodings()) {
                encodingField.add(encoding);
            }

            encodingField.select(0);
            encodingField.addModifyListener(validator);

            setPageComplete(validatePage());
            setControl(composite);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected ModifyListener validator =
            new ModifyListener() {
                public void modifyText(ModifyEvent e) {
                    setPageComplete(validatePage());
                }
            };

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected boolean validatePage() {
            return getInitialObjectName() != null && getEncodings().contains(encodingField.getText());
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public void setVisible(boolean visible) {
            super.setVisible(visible);
            if (visible) {
                if (initialObjectField.getItemCount() == 1) {
                    initialObjectField.clearSelection();
                    encodingField.setFocus();
                }
                else {
                    encodingField.clearSelection();
                    initialObjectField.setFocus();
                }
            }
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
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
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public String getEncoding() {
            return encodingField.getText();
        }

        /**
         * Returns the label for the specified type name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected String getLabel(String typeName) {
            try {
                return BuildCoreEditPlugin.INSTANCE.getString("_UI_" + typeName + "_type");
            }
            catch(MissingResourceException mre) {
                BuildCoreEditPlugin.INSTANCE.log(mre);
            }
            return typeName;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected Collection<String> getEncodings() {
            if (encodings == null) {
                encodings = new ArrayList<String>();
                for (StringTokenizer stringTokenizer = new StringTokenizer(BuildCoreEditPlugin.INSTANCE.getString("_UI_XMLEncodingChoices")); stringTokenizer.hasMoreTokens(); ) {
                    encodings.add(stringTokenizer.nextToken());
                }
            }
            return encodings;
        }
    }

    /**
     * The framework calls this to create the contents of the wizard.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
        @Override
    public void addPages() {
        // Create a page, set the title, and the initial model file name.
        //
        newFileCreationPage = new BuildcoreModelWizardNewFileCreationPage("Whatever", selection);
        newFileCreationPage.setTitle(BuildCoreEditPlugin.INSTANCE.getString("_UI_BuildcoreModelWizard_label"));
        newFileCreationPage.setDescription(BuildCoreEditPlugin.INSTANCE.getString("_UI_BuildcoreModelWizard_description"));
        newFileCreationPage.setFileName(BuildCoreEditPlugin.INSTANCE.getString("_UI_BuildcoreEditorFilenameDefaultBase") + "." + FILE_EXTENSIONS.get(0));
        addPage(newFileCreationPage);

        // Try and get the resource selection to determine a current directory for the file dialog.
        //
        if (selection != null && !selection.isEmpty()) {
            // Get the resource...
            //
            Object selectedElement = selection.iterator().next();
            if (selectedElement instanceof IResource) {
                // Get the resource parent, if its a file.
                //
                IResource selectedResource = (IResource)selectedElement;
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
                    String defaultModelBaseFilename = BuildCoreEditPlugin.INSTANCE.getString("_UI_BuildcoreEditorFilenameDefaultBase");
                    String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
                    String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
                    for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
                        modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
                    }
                    newFileCreationPage.setFileName(modelFilename);
                }
            }
        }
        initialObjectCreationPage = new BuildcoreModelWizardInitialObjectCreationPage("Whatever2");
        initialObjectCreationPage.setTitle(BuildCoreEditPlugin.INSTANCE.getString("_UI_BuildcoreModelWizard_label"));
        initialObjectCreationPage.setDescription(BuildCoreEditPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description"));
        addPage(initialObjectCreationPage);
    }

    /**
     * Get the file from the page.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IFile getModelFile() {
        return newFileCreationPage.getModelFile();
    }

}
