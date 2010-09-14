/**
 * <copyright>
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
 * </copyright>
 */

package org.eclipse.egf.portfolio.genchain.tools.ui.wizards;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.egf.core.ui.dialogs.LoadEcoreDialog;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.portfolio.genchain.extension.ExtensionHelper;
import org.eclipse.egf.portfolio.genchain.extension.ExtensionProperties;
import org.eclipse.egf.portfolio.genchain.tools.ui.Messages;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;

/**
 * @author Thomas Guiu
 * 
 */
public class EcoreModelPage extends WizardPage implements ExtensionProperties, NodeTypes {

    private abstract class MySelectionListener implements SelectionListener {
        protected abstract void buttonSelected();

        public void widgetSelected(SelectionEvent e) {
            buttonSelected();
            refreshButtons();
        }

        public void widgetDefaultSelected(SelectionEvent e) {
        }

    }

    private Button addEcoreButton;
    private Button deleteButton;
    private Button upButton;
    private Button downButton;
    private final Node model;
    private ContainerCheckedTreeViewer viewer;

    public EcoreModelPage(String pageName, Node model) {
        super(pageName);
        this.model = model;
    }

    public EcoreModelPage(String pageName, Node model, IStructuredSelection selection) {
        this(pageName, model);
        for (Object obj : selection.toArray()) {
            if (obj instanceof IFile) {
                IFile file = (IFile) obj;
                if (file.getName().endsWith(".ecore"))//$NON-NLS-1$
                    addEcore(file.getFullPath().toString());
            }
        }
    }

    private Node addEcore(String modelPath) {
        String name = GenerationChainFactory.getModelName(modelPath);
        String bundleName = GenerationChainFactory.getBundleName(modelPath);
        Node chainNode = new Node(model, MODEL);
        chainNode.setName(name);
        model.getChildren().add(chainNode);

        for (Entry<String, ExtensionHelper> entrySet : ExtensionHelper.getExtensionsAsMap().entrySet()) {
            Node extensionNode = new Node(chainNode, EXTENSION);
            Map<String, String> context = new HashMap<String, String>();
            context.put(CONTEXT_PROJECT_NAME, bundleName);
            context.put(CONTEXT_MODEL_NAME, name);

            extensionNode.getProperties().put(ID, entrySet.getKey());
            extensionNode.getProperties().put(MODEL_PATH, modelPath);
            extensionNode.setName(entrySet.getKey());
            chainNode.getChildren().add(extensionNode);

            for (Entry<EAttribute, String> prop : entrySet.getValue().getDefaultProperties(context).entrySet()) {
                Node propertyNode = new Node(extensionNode, PROPERTY);
                propertyNode.setName(prop.getKey().getName());
                propertyNode.getProperties().put(PROPERTY_VALUE, prop.getValue());
                propertyNode.getExtendedProperties().put(PROPERTY_EATTRIBUTE, prop.getKey());
                extensionNode.getChildren().add(propertyNode);
            }
        }
        return chainNode;

    }

    private void createViewerControl(Composite container) {

        viewer = new ContainerCheckedTreeViewer(container, SWT.FULL_SELECTION);
        Tree tree = viewer.getTree();
        tree.setHeaderVisible(true);
        TreeColumn col1 = new TreeColumn(tree, SWT.FULL_SELECTION);
        col1.setText("");//$NON-NLS-1$
        col1.setResizable(true);
        col1.setWidth(280);

        TreeColumn col2 = new TreeColumn(tree, SWT.FULL_SELECTION);
        col2.setText(Messages.genchain_wizard_valueColumn_label);
        col2.setResizable(true);
        col2.setWidth(200);

        TreeViewerColumn tcol2 = new TreeViewerColumn(viewer, col2);
        tcol2.setEditingSupport(new EditingSupport(viewer) {

            private final TextCellEditor textEditor = new TextCellEditor(viewer.getTree());
            private final ComboBoxViewerCellEditor booleanEditor = new ComboBoxViewerCellEditor(viewer.getTree());
            {
                booleanEditor.setLabelProvider(new LabelProvider());
                booleanEditor.setContenProvider(new ListContentProvider());
                booleanEditor.setInput(Arrays.asList("true", "false"));//$NON-NLS-1$ //$NON-NLS-2$
                booleanEditor.getViewer().addDoubleClickListener(new IDoubleClickListener() {

                    public void doubleClick(DoubleClickEvent event) {
                        booleanEditor.getViewer().getCombo().setListVisible(true);
                    }
                });
            }

            @Override
            protected void setValue(Object element, Object value) {
                Node node = (Node) element;
                node.getProperties().put(PROPERTY_VALUE, value.toString());
                viewer.refresh(node);
            }

            @Override
            protected Object getValue(Object element) {
                Node node = (Node) element;
                return node.getProperties().get(PROPERTY_VALUE);
            }

            @Override
            protected CellEditor getCellEditor(Object element) {
                Node node = (Node) element;
                EAttribute attr = (EAttribute) node.getExtendedProperties().get(PROPERTY_EATTRIBUTE);
                if (attr == null)
                    return null;
                final EClassifier eType = attr.getEType();
                if (EcorePackage.eINSTANCE.getEBoolean().equals(eType))
                    return booleanEditor;
                if (EcorePackage.eINSTANCE.getEString().equals(eType))
                    return textEditor;
                return null;
            }

            @Override
            protected boolean canEdit(Object element) {

                return true;
            }
        });

        viewer.setLabelProvider(new NodeLabelProvider());
        viewer.setContentProvider(new NodeContentProvider());
        viewer.setComparator(new ViewerComparator());
        GridData gd = new GridData(GridData.FILL_BOTH);
        viewer.getTree().setLayoutData(gd);
        viewer.setInput(model);
        viewer.addCheckStateListener(new ICheckStateListener() {

            public void checkStateChanged(CheckStateChangedEvent event) {
                Node node = (Node) event.getElement();
                if (node.is(PROPERTY))
                    viewer.setChecked(node.getParent(), event.getChecked());
            }
        });
        viewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                refreshButtons();
            }
        });

    }

    @Override
    public boolean isPageComplete() {
        if (viewer != null) {
            final boolean complete = viewer.getVisibleExpandedElements().length == 0 || viewer.getCheckedElements().length != 0;
            if (complete) {
                setErrorMessage(null);
            } else {
                setErrorMessage(Messages.genchain_wizard_error1);
            }
            return complete;
        }
        return super.isPageComplete();
    }

    public void createButtonControl(Composite parent) {
        parent = new Composite(parent, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_VERTICAL);
        parent.setLayoutData(gd);
        GridLayout layout = new GridLayout();
        layout.marginWidth = 0;
        parent.setFont(parent.getFont());
        parent.setLayout(layout);

        addEcoreButton = new Button(parent, SWT.PUSH);
        addEcoreButton.setToolTipText(Messages.genchain_wizard_addButton_label);
        addEcoreButton.setImage(Activator.getDefault().getImage(ImageShop.IMG_ADD_OBJ));
        addEcoreButton.addSelectionListener(new MySelectionListener() {

            @Override
            protected void buttonSelected() {
                LoadEcoreDialog chooseModelDialog = new LoadEcoreDialog(getShell(), null, false);
                if (chooseModelDialog.open() == Window.OK) {
                    String uri = chooseModelDialog.getURIText();
                    if (uri == null)
                        return;
                    if (uri.startsWith("platform:/plugin"))//$NON-NLS-1$
                        uri = uri.substring("platform:/plugin".length());//$NON-NLS-1$
                    else if (uri.startsWith("platform:/resource"))//$NON-NLS-1$
                        uri = uri.substring("platform:/resource".length());//$NON-NLS-1$
                    else
                        return;
                    Node newNode = addEcore(uri);
                    viewer.refresh();
                    viewer.expandToLevel(newNode, AbstractTreeViewer.ALL_LEVELS);
                }

            }
        });

        deleteButton = new Button(parent, SWT.PUSH);
        deleteButton.setToolTipText(Messages.genchain_wizard_deleteButton_label);
        deleteButton.setImage(Activator.getDefault().getImage(ImageShop.IMG_DELETE_OBJ));
        deleteButton.addSelectionListener(new MySelectionListener() {

            @Override
            protected void buttonSelected() {
                IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
                for (Object obj : selection.toArray()) {
                    if (obj instanceof Node) {
                        Node node = (Node) obj;
                        if (node.is(MODEL)) {
                            node.getParent().getChildren().remove(node);
                        }
                    }
                }
                viewer.refresh();
            }

        });

        upButton = new Button(parent, SWT.PUSH);
        upButton.setToolTipText(Messages.genchain_wizard_upButton_label);
        upButton.setImage(Activator.getDefault().getImage(ImageShop.IMG_UPWARD_OBJ));
        upButton.addSelectionListener(new MySelectionListener() {

            @Override
            protected void buttonSelected() {
                IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
                if (selection.size() == 1) {
                    Node node = (Node) selection.getFirstElement();
                    final Node parent2 = node.getParent();
                    final int index = parent2.getChildren().indexOf(node);
                    if (index > 0) {
                        parent2.getChildren().remove(node);
                        parent2.getChildren().add(index - 1, node);
                    }
                }
                viewer.refresh();
            }

        });

        downButton = new Button(parent, SWT.PUSH);
        downButton.setToolTipText(Messages.genchain_wizard_downButton_label);
        downButton.setImage(Activator.getDefault().getImage(ImageShop.IMG_DOWNWARD_OBJ));
        downButton.addSelectionListener(new MySelectionListener() {

            @Override
            protected void buttonSelected() {
                IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
                if (selection.size() == 1) {
                    Node node = (Node) selection.getFirstElement();
                    final Node parent2 = node.getParent();
                    final int index = parent2.getChildren().indexOf(node);
                    if (index < parent2.getChildren().size() - 1) {
                        parent2.getChildren().remove(node);
                        parent2.getChildren().add(index + 1, node);
                    }
                }
                viewer.refresh();
            }

        });

    }

    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        container.setLayoutData(gd);
        GridLayout layout = new GridLayout(1, false);
        layout.numColumns = 2;
        container.setFont(parent.getFont());
        container.setLayout(layout);

        createViewerControl(container);
        createButtonControl(container);

        refreshButtons();

        setControl(container);

        container.pack();

        viewer.expandToLevel(2);
        viewer.setCheckedElements(viewer.getExpandedElements());
    }

    protected void refreshButtons() {
        deleteButton.setEnabled(false);
        upButton.setEnabled(false);
        downButton.setEnabled(false);
        IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
        if (selection.size() == 1) {
            Node node = (Node) selection.getFirstElement();
            final Node parent2 = node.getParent();
            final int index = parent2.getChildren().indexOf(node);
            if (node.is(MODEL)) {
                upButton.setEnabled(index > 0);
                downButton.setEnabled(index < parent2.getChildren().size() - 1);
            }
        }
        boolean enableDelete = false;
        if (!selection.isEmpty()) {
            enableDelete = true;
            for (Object obj : selection.toArray()) {
                if (obj instanceof Node) {
                    Node node = (Node) obj;
                    if (!node.is(MODEL)) {
                        enableDelete = false;
                        break;
                    }
                }
            }
        }
        deleteButton.setEnabled(enableDelete);
        getContainer().updateButtons();
    }

    public Set<Node> getCheckedElements() {
        Set<Node> checkedElements = new HashSet<Node>();
        for (Object obj : viewer.getCheckedElements())
            checkedElements.add((Node) obj);

        return checkedElements;
    }

    static private class ListContentProvider implements IStructuredContentProvider {

        public Object[] getElements(Object inputElement) {
            if (inputElement instanceof List<?>)
                return ((List<?>) inputElement).toArray();
            return null;
        }

        public void dispose() {
        }

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            if (newInput != null)
                viewer.refresh();
        }

    }

}
