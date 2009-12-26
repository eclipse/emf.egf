/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern.ui.editors.wizards.pages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.editors.dialogs.JavaTypeSelectionDialog;
import org.eclipse.egf.pattern.ui.editors.dialogs.EcoreModelSelectionDialog;
import org.eclipse.egf.pattern.ui.editors.models.EcoreType;
import org.eclipse.egf.pattern.ui.editors.models.EcoreTypeStructure;
import org.eclipse.egf.pattern.ui.editors.providers.EcoreTypeChooseContentProvider;
import org.eclipse.egf.pattern.ui.editors.providers.TypeChooseLabelProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

/**
 * @author xrchen
 * 
 */
public class ChooseTypePage extends WizardPage {

    private String chooseType;

    private JavaTypeSelectionDialog dialog;

    private TabFolder tabFolder;

    private TransactionalEditingDomain editingDomain;

    private TreeViewer ecoreTypeTreeViewer;

    private List<String> types;

    private EcoreTypeStructure input;

    private List<EcoreType> parents;

    private String type;

    private static final String PARAMETER_TYPE_DEFAULT_VALUE = "http://www.eclipse.org/emf/2002/Ecore#//EClass";

    private static final String PARAMETER_Parent_TYPE_DEFAULT_VALUE = "ecore";

    public ChooseTypePage(ISelection selection, TransactionalEditingDomain editingDomain, String type) {
        super("Type selection");
        setTitle("Type selection");
        setDescription("Select a type in the following list of available types");
        this.editingDomain = editingDomain;
        this.type = type;
    }

    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        createTabFolder(container);
        setControl(container);
        getDefaultTypes();
    }

    /**
     * Get the types of default model.
     */
    private void getDefaultTypes() {
        if (!"".equals(type) && type != null) {
            int index = type.indexOf("#//");
            if (index != -1) {
                String nsURI = type.substring(0, index);
                parents = new ArrayList<EcoreType>();
                types = new ArrayList<String>();
                EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsURI);
                if (ePackage != null) {
                    getPackageTypes(ePackage);
                    input = new EcoreTypeStructure(parents);
                    ecoreTypeTreeViewer.setInput(input);
                    ecoreTypeTreeViewer.expandAll();
                    return;
                }
            }
            ecoreTypeTreeViewer.setInput(getEcoreTypes());
            ecoreTypeTreeViewer.expandAll();
        }
    }

    private void createTabFolder(Composite container) {
        tabFolder = new TabFolder(container, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_BOTH);
        tabFolder.setLayoutData(gd);

        TabItem coreTypeTabItem = new TabItem(tabFolder, SWT.NONE);
        coreTypeTabItem.setText("Ecore type");
        coreTypeTabItem.setImage(ImageShop.get(ImageShop.IMG_CATEGORY_OBJ));

        Composite compositeCoreType = new Composite(tabFolder, SWT.NONE);
        createEcoreType(compositeCoreType);
        coreTypeTabItem.setControl(compositeCoreType);

        TabItem javaTypeTabItem = new TabItem(tabFolder, SWT.NONE);
        javaTypeTabItem.setText("Java type");
        javaTypeTabItem.setImage(ImageShop.get(ImageShop.IMG_CLASS_OBJ));

        Composite compositeJavaType = new Composite(tabFolder, SWT.NONE);
        dialog = new JavaTypeSelectionDialog(compositeJavaType.getShell(), getWizard());
        compositeJavaType.setLayout(new GridLayout());
        dialog.createPage(compositeJavaType);
        compositeJavaType.addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e) {
                dialog.close();
            }
        });
        javaTypeTabItem.setControl(compositeJavaType);
    }

    /**
     * Create the ecoreType tabItem.
     */
    private void createEcoreType(final Composite compositeEcoreType) {
        GridLayout layout = new GridLayout();
        compositeEcoreType.setLayout(layout);

        Composite container = new Composite(compositeEcoreType, SWT.NONE);
        layout = new GridLayout();
        layout.marginWidth = 5;
        container.setLayout(layout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        container.setLayoutData(gd);

        Tree tree = new Tree(container, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        gd = new GridData(GridData.FILL_BOTH);
        tree.setLayoutData(gd);
        tree.setLayoutData(gd);

        TreeColumn treeColumn = new TreeColumn(tree, SWT.NONE);
        treeColumn.setWidth(500);

        ecoreTypeTreeViewer = new TreeViewer(tree);
        ecoreTypeTreeViewer.setLabelProvider(new TypeChooseLabelProvider());
        ecoreTypeTreeViewer.setContentProvider(new EcoreTypeChooseContentProvider());
        ecoreTypeTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                getSelectionType();
            }
        });

        ecoreTypeTreeViewer.addDoubleClickListener(new IDoubleClickListener() {

            public void doubleClick(DoubleClickEvent event) {
                IWizard wizard = getWizard();
                wizard.performFinish();
                IWizardContainer wizardContainer = wizard.getContainer();
                if (wizardContainer instanceof WizardDialog) {
                    ((WizardDialog) wizardContainer).close();
                }
            }
        });

        Button button = new Button(compositeEcoreType, SWT.PUSH);
        button.setText("Choose model...");
        button.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                getSelectionType();
                EcoreModelSelectionDialog chooseModelDialog = new EcoreModelSelectionDialog(compositeEcoreType.getShell(), editingDomain);
                if (chooseModelDialog.open() == Window.OK) {
                    String returnUri = chooseModelDialog.getURIText();
                    searchTypeModel(returnUri);
                    ecoreTypeTreeViewer.expandAll();
                }
            }
        });
    }

    private void getSelectionType() {
        ISelection selection = ecoreTypeTreeViewer.getSelection();
        Object selectItem = ((IStructuredSelection) selection).getFirstElement();
        if (selectItem instanceof EcoreType) {
            chooseType = ((EcoreType) selectItem).getType();
        }
    }

    protected void searchTypeModel(String returnUri) {
        String[] uris = returnUri.split("  ");
        parents = new ArrayList<EcoreType>();
        for (String uri : uris) {
            searchTypeModelInPackage(uri);
        }
        input = new EcoreTypeStructure(parents);
        ecoreTypeTreeViewer.setInput(input);
    }

    /**
     * Get all the types from file.
     */
    private void searchTypeModelInPackage(String path) {
        try {
            Resource resource = editingDomain.loadResource(path);
            getAllTypesInFile(resource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAllTypesInFile(Resource resource) {
        EList<EObject> contents = resource.getContents();
        types = new ArrayList<String>();
        for (EObject eObject : contents) {
            if (eObject instanceof EPackage) {
                EPackage aPackage = ((EPackage) eObject);
                getPackageTypes(aPackage);
            }
        }
    }

    private void getPackageTypes(EPackage aPackage) {
        // Get the parent type.
        String nsURI = aPackage.getNsURI();
        EcoreType parent = new EcoreType(aPackage.getName(), nsURI);

        // Get the sub types.
        EList<EPackage> eSubpackages = aPackage.getESubpackages();
        for (EPackage eSubpackage : eSubpackages) {
            EList<EClassifier> subEClassifiers = eSubpackage.getEClassifiers();
            getTypesUnderPackage(subEClassifiers);
        }
        EList<EClassifier> eClassifiers = aPackage.getEClassifiers();
        getTypesUnderPackage(eClassifiers);

        // Add children to the parent.
        for (String type : types) {
            EcoreType child = new EcoreType(type, nsURI);
            child.setParent(parent);
            parent.getUnderlings().add(child);
        }
        parents.add(parent);
    }

    private void getTypesUnderPackage(EList<EClassifier> eClassifiers) {
        for (EClassifier eClassifier : eClassifiers) {
            if (eClassifier instanceof ENamedElement) {
                ENamedElement eNamedElement = (ENamedElement) eClassifier;
                EClass eClass = eNamedElement.eClass();
                String name = eClass.getName();
                if (!isDuplicateType(name)) {
                    types.add(name);
                }
            }
        }
    }

    private boolean isDuplicateType(String name) {
        for (String type : types) {
            if (name.equals(type))
                return true;
        }
        return false;
    }

    /**
     * Drop any package or uri information of the type.
     */
    public static String getType(String type) {
        if (type == null || type.isEmpty() || "".equals(type))
            return "";
        int index = type.lastIndexOf(".");
        if (index != -1)
            return type.substring(index + 1);
        return type;
    }

    private EcoreTypeStructure getEcoreTypes() {
        EPackage ecorePackage = EcoreFactory.eINSTANCE.getEcorePackage();
        EcoreFactory.eINSTANCE.getEAnnotations();
        EList<EClassifier> eClassifiers = ecorePackage.getEClassifiers();
        EcoreType parent = new EcoreType(PARAMETER_Parent_TYPE_DEFAULT_VALUE, PARAMETER_TYPE_DEFAULT_VALUE);
        for (EClassifier eClassifier : eClassifiers) {
            int id = eClassifier.getClassifierID();
            if (isValidClassifier(id)) {
                EcoreType child = new EcoreType(eClassifier.getName(), PARAMETER_TYPE_DEFAULT_VALUE);
                child.setParent(parent);
                parent.getUnderlings().add(child);
            }
        }
        List<EcoreType> parents = new ArrayList<EcoreType>();
        parents.add(parent);
        return new EcoreTypeStructure(parents);
    }

    /**
     * Check the class whether is a valid classifier
     */
    private boolean isValidClassifier(int id) {
        switch (id) {
        case EcorePackage.EATTRIBUTE:
            return true;
        case EcorePackage.EANNOTATION:
            return true;
        case EcorePackage.ECLASS:
            return true;
        case EcorePackage.EDATA_TYPE:
            return true;
        case EcorePackage.EENUM:
            return true;
        case EcorePackage.EENUM_LITERAL:
            return true;
        case EcorePackage.EFACTORY:
            return true;
        case EcorePackage.EOBJECT:
            return true;
        case EcorePackage.EOPERATION:
            return true;
        case EcorePackage.EPACKAGE:
            return true;
        case EcorePackage.EPARAMETER:
            return true;
        case EcorePackage.EREFERENCE:
            return true;
        case EcorePackage.ESTRING_TO_STRING_MAP_ENTRY:
            return true;
        case EcorePackage.EGENERIC_TYPE:
            return true;
        case EcorePackage.ETYPE_PARAMETER:
            return true;
        default:
            return false;
        }
    }

    public String getType() {
        return chooseType;
    }

    public JavaTypeSelectionDialog getJavaTypePage() {
        return dialog;
    }

    public boolean isInCoreTab() {
        return (tabFolder.getSelectionIndex() == 0);
    }

}
