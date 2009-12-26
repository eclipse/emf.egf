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

import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.editors.dialogs.JavaTypeSelectionDialog;
import org.eclipse.egf.pattern.ui.editors.dialogs.EcoreModelSelectionDialog;
import org.eclipse.egf.pattern.ui.editors.models.EcoreTypeStructure;
import org.eclipse.egf.pattern.ui.editors.providers.EcoreTypeChooseContentProvider;
import org.eclipse.egf.pattern.ui.editors.providers.TypeChooseLabelProvider;
import org.eclipse.emf.ecore.EObject;
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

    public ChooseTypePage(ISelection selection, TransactionalEditingDomain editingDomain, String type) {
        super("Type selection");
        setTitle("Type selection");
        setDescription("Select a type in the following list of available types");
        this.editingDomain = editingDomain;
    }

    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        createTabFolder(container);
        setControl(container);
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
        dialog = new JavaTypeSelectionDialog(compositeJavaType.getShell(),getWizard());
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
                ISelection selection = ecoreTypeTreeViewer.getSelection();
                final Object selectItem = ((IStructuredSelection) selection).getFirstElement();
                if (selectItem instanceof EObject) {
                    String classDescription = ((EObject) selectItem).getClass().toString();
                    int length = classDescription.length();
                    chooseType = classDescription.substring(classDescription.lastIndexOf(".")+1,length-4);
                }
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
                EcoreModelSelectionDialog chooseModelDialog = new EcoreModelSelectionDialog(compositeEcoreType.getShell(), editingDomain);
                if (chooseModelDialog.open() == Window.OK) {
                    String returnUri = chooseModelDialog.getURIText();
                    searchTypeModel(returnUri);
                }
            }
        });
    }

    /**
     * Get the platform and find all the types from it.
     */
    private void searchTypeModelInPackage(String path, EcoreTypeStructure input) {
        try {
            Resource res = editingDomain.loadResource(path);
            input.addResource(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void searchTypeModel(String returnUri) {
        String[] uris = returnUri.split("  ");
        EcoreTypeStructure input = new EcoreTypeStructure();
        for (String uri : uris) {
            searchTypeModelInPackage(uri, input);
        }
        ecoreTypeTreeViewer.setInput(input);
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
