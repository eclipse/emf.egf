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

import org.eclipse.egf.pattern.ui.editors.models.EcoreType;
import org.eclipse.egf.pattern.ui.editors.models.EcoreTypeStructure;
import org.eclipse.egf.pattern.ui.editors.providers.EcoreTypeChooseContentProvider;
import org.eclipse.egf.pattern.ui.editors.providers.TypeChooseLabelProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
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
import org.eclipse.swt.widgets.TreeItem;

/**
 * @author xrchen
 * 
 */
public class ChooseTypePage extends WizardPage {

    private String chooseType;

    private ChooseJavaTypePage page;

    private TabFolder tabFolder;

    private TransactionalEditingDomain editingDomain;

    public ChooseTypePage(ISelection selection, TransactionalEditingDomain editingDomain) {
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

        Composite compositeCoreType = new Composite(tabFolder, SWT.NONE);
        createEcoreType(compositeCoreType);
        coreTypeTabItem.setControl(compositeCoreType);

        TabItem javaTypeTabItem = new TabItem(tabFolder, SWT.NONE);
        javaTypeTabItem.setText("Java type");

        Composite compositeJavaType = new Composite(tabFolder, SWT.NONE);
        page = new ChooseJavaTypePage(compositeJavaType.getShell());
        compositeJavaType.setLayout(new GridLayout());
        page.createPage(compositeJavaType);
        compositeJavaType.addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e) {
                page.close();
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

        final TreeViewer ecoreTypeTreeViewer = new TreeViewer(tree);
        ecoreTypeTreeViewer.setLabelProvider(new TypeChooseLabelProvider());
        ecoreTypeTreeViewer.setContentProvider(new EcoreTypeChooseContentProvider());
        ecoreTypeTreeViewer.setInput(getEcoreTypes());
        ecoreTypeTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                ISelection selection = ecoreTypeTreeViewer.getSelection();
                final Object selectItem = ((IStructuredSelection) selection).getFirstElement();
                if (selectItem instanceof EcoreType) {
                    chooseType = ((EcoreType) selectItem).getType();
                }
            }
        });

        Button button = new Button(compositeEcoreType, SWT.PUSH);
        button.setText("Choose model...");
        button.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                ChooseModelPage chooseModelPage = new ChooseModelPage(compositeEcoreType.getShell(), editingDomain);
                if (chooseModelPage.open() == Window.OK) {
                    chooseType = chooseModelPage.getURIText();
                    String type = getType(chooseType);
                    findEcoreTypeInTree(type);
                }
            }

            private void findEcoreTypeInTree(String type) {
                TreeItem itemParent = ecoreTypeTreeViewer.getTree().getItem(0);
                if (itemParent.getText().equals(type)) {
                    ecoreTypeTreeViewer.getTree().setSelection(itemParent);
                    return;
                }
                int len = ecoreTypeTreeViewer.getTree().getItems()[0].getItemCount();
                for (int i = 0; i < len; i++) {
                    TreeItem itemChild = ecoreTypeTreeViewer.getTree().getItem(0).getItem(i);
                    if (itemChild.getText().equals(type)) {
                        ecoreTypeTreeViewer.getTree().setSelection(itemChild);
                        return;
                    }

                }
            }
        });
        selectDefault(ecoreTypeTreeViewer);
    }

    private EcoreTypeStructure getEcoreTypes() {
        EPackage ecorePackage = EcoreFactory.eINSTANCE.getEcorePackage();
        EcoreFactory.eINSTANCE.getEAnnotations();
        EList<EClassifier> eClassifiers = ecorePackage.getEClassifiers();
        EcoreType parent = new EcoreType("ecore");
        for (EClassifier eClassifier : eClassifiers) {
            int id = eClassifier.getClassifierID();
            if (isValidClassifier(id)) {
                EcoreType child = new EcoreType(eClassifier.getName());
                child.setParent(parent);
                parent.getUnderlings().add(child);
            }
        }
        return new EcoreTypeStructure(parent);
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

    /**
     * Make EcoreType list area's first element selected.
     */
    private void selectDefault(TreeViewer ecoreTypeTreeViewer) {
        Object input = ecoreTypeTreeViewer.getInput();
        if (input instanceof EcoreTypeStructure) {
            Object parent = ((EcoreTypeStructure) input).getEcoreType();
            if (parent != null) {
                ecoreTypeTreeViewer.setSelection(new StructuredSelection(parent));
            }
        }
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

    public ChooseJavaTypePage getJavaTypePage() {
        return page;
    }

    public boolean isInCoreTab() {
        return (tabFolder.getSelectionIndex() == 0);
    }

}
