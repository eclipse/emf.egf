/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.wizards.pages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.pattern.ecore.EPackageHelper;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.dialogs.EcoreModelSelectionDialog;
import org.eclipse.egf.pattern.ui.editors.dialogs.JavaTypeSelectionDialog;
import org.eclipse.egf.pattern.ui.editors.providers.EcoreContentProvider;
import org.eclipse.egf.pattern.ui.editors.providers.EcoreLabelProvider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
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
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class ChooseTypePage extends WizardPage {

    private String chooseType;

    private JavaTypeSelectionDialog dialog;

    private TabFolder tabFolder;

    private TransactionalEditingDomain editingDomain;

    private TreeViewer ecoreTypeTreeViewer;

    private String type;

    private static final String PARAMETER_TYPE_DEFAULT_VALUE = "http://www.eclipse.org/emf/2002/Ecore"; //$NON-NLS-1$

    public ChooseTypePage(ISelection selection, TransactionalEditingDomain editingDomain, String type) {
        super(Messages.ChooseTypePage_title);
        setTitle(Messages.ChooseTypePage_title);
        setDescription(Messages.ChooseTypePage_description);
        this.editingDomain = editingDomain;
        this.type = type;
    }

    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        createTabFolder(container);
        setControl(container);
        initContent();
    }

    /**
     * Get the types of default model.
     */
    private void initContent() {
        String nsURI;
        if (!"".equals(type) && type != null) { //$NON-NLS-1$
            int index = type.indexOf("#//"); //$NON-NLS-1$
            if (index != -1) {
                nsURI = type.substring(0, index);
            } else {
                nsURI = PARAMETER_TYPE_DEFAULT_VALUE;
            }
        } else {
            nsURI = PARAMETER_TYPE_DEFAULT_VALUE;
        }
        EPackage ePackage = EPackageHelper.REGISTRY.getEPackage(nsURI);
        if (ePackage != null) {
            ecoreTypeTreeViewer.setInput(ePackage.eResource().getContents());
            ecoreTypeTreeViewer.expandToLevel(2);
        }
    }

    private void createTabFolder(Composite container) {
        tabFolder = new TabFolder(container, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_BOTH);
        tabFolder.setLayoutData(gd);

        TabItem coreTypeTabItem = new TabItem(tabFolder, SWT.NONE);
        coreTypeTabItem.setText(Messages.ChooseTypePage_coreTypeTabItem_title);
        coreTypeTabItem.setImage(ImageShop.get(ImageShop.IMG_CATEGORY_OBJ));

        Composite compositeCoreType = new Composite(tabFolder, SWT.NONE);
        createEcoreType(compositeCoreType);
        coreTypeTabItem.setControl(compositeCoreType);

        TabItem javaTypeTabItem = new TabItem(tabFolder, SWT.NONE);
        javaTypeTabItem.setText(Messages.ChooseTypePage_javaTypeTabItem_title);
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
        gd.heightHint = tree.getItemHeight() * 11;
        tree.setLayoutData(gd);

        TreeColumn treeColumn = new TreeColumn(tree, SWT.NONE);
        treeColumn.setWidth(500);

        ecoreTypeTreeViewer = new TreeViewer(tree);
        ecoreTypeTreeViewer.setLabelProvider(new EcoreLabelProvider());
        ecoreTypeTreeViewer.setComparator(new ViewerComparator() {
            private final EcoreSwitch<Integer> _switch = new EcoreSwitch<Integer>() {

                @Override
                public Integer caseEClassifier(EClassifier object) {

                    return 2;
                }

                @Override
                public Integer caseEPackage(EPackage object) {

                    return 1;
                }
            };

            @Override
            public int category(Object element) {
                if (element instanceof EObject)
                    return _switch.doSwitch((EObject) element);
                return 10;
            }
        });
        ecoreTypeTreeViewer.addFilter(new ViewerFilter() {

            @Override
            public boolean select(Viewer viewer, Object parentElement, Object element) {
                // TODO at present time, we don't support DataType as type for
                // PatternParameter
                return element instanceof EClass || element instanceof EPackage;
            }
        });
        ecoreTypeTreeViewer.setContentProvider(new EcoreContentProvider());
        ecoreTypeTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                selectType();
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
        button.setText(Messages.ChooseTypePage_choose_model_button_title);
        button.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                selectType();
                EcoreModelSelectionDialog chooseModelDialog = new EcoreModelSelectionDialog(compositeEcoreType.getShell(), editingDomain);
                if (chooseModelDialog.open() == Window.OK) {
                    String returnUri = chooseModelDialog.getURIText();
                    searchTypeModel(returnUri);
                    ecoreTypeTreeViewer.expandToLevel(2);
                }
            }
        });
    }

    private void selectType() {
        ISelection selection = ecoreTypeTreeViewer.getSelection();
        Object selectItem = ((IStructuredSelection) selection).getFirstElement();
        String nsURI = ""; //$NON-NLS-1$
        String typeName = ""; //$NON-NLS-1$
        if (selectItem instanceof EPackage) {
            nsURI = ((EPackage) selectItem).getNsURI();
            typeName = ((EPackage) selectItem).eClass().getName();
        } else if (selectItem instanceof EClassifier) {
            nsURI = getEPackageNsURI((EClassifier) selectItem);
            typeName = ((EClassifier) selectItem).getName();
        }
        if (!("".equals(nsURI) && "".equals(typeName))) { //$NON-NLS-1$ //$NON-NLS-2$
            chooseType = nsURI + "#//" + typeName; //$NON-NLS-1$
        }

    }

    /**
     * Get the content's ns_uri.
     */
    private String getEPackageNsURI(EObject eObject) {
        EObject eContainer = ((EObject) eObject).eContainer();
        if (eContainer instanceof EPackage) {
            String nsURI = ((EPackage) eContainer).getNsURI();
            return nsURI;
        }
        return getEPackageNsURI(eContainer);
    }

    protected void searchTypeModel(String returnUri) {
        String[] uris = returnUri.split("  "); //$NON-NLS-1$
        List<EObject> resources = new ArrayList<EObject>();
        for (String uri : uris) {
            int indexOf = (uri.toLowerCase()).indexOf(Messages.ChooseTypePage_ecore_file);
            if (indexOf != -1) {
                Resource resource = editingDomain.loadResource(uri);
                if (resource != null)
                    resources.addAll(resource.getContents());
            }
        }
        ecoreTypeTreeViewer.setInput(resources);
    }

    /**
     * Drop any package or uri information of the type.
     */
    public static String getType(String type) {
        if (type == null || type.length() == 0) //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        int index = type.lastIndexOf("."); //$NON-NLS-1$
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
