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

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.egf.core.ui.dialogs.LoadEcoreDialog;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.portfolio.genchain.extension.ExtensionHelper;
import org.eclipse.egf.portfolio.genchain.extension.ExtensionProperties;
import org.eclipse.egf.portfolio.genchain.tools.ui.Messages;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;

/**
 * @author Thomas Guiu
 * 
 */
public class EcoreModelPage extends WizardPage implements ExtensionProperties {

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

    protected EcoreModelPage(String pageName, Node model) {
        super(pageName);
        this.model = model;
    }

    private void addEcore(String modelPath) {
        String name = modelPath.substring(modelPath.lastIndexOf('/') + 1, modelPath.lastIndexOf('.'));
        Node chainNode = new Node(model, Node.CONTAINER_NODE);
        chainNode.setName(name);
        model.getChildren().add(chainNode);

        for (Entry<String, ExtensionHelper> entrySet : ExtensionHelper.getExtensionsAsMap().entrySet()) {
            Node extensionNode = new Node(chainNode, Node.LEAF_NODE);
            extensionNode.getProperties().put(ID, entrySet.getKey());
            extensionNode.getProperties().put(MODEL_PATH, modelPath);
            extensionNode.setName(entrySet.getKey());
            chainNode.getChildren().add(extensionNode);

            // for (String prop : entrySet.getValue().getPropertyNames())
            // {
            // Node propertyNode = new Node(extensionNode, Node.LEAF_NODE);
            // propertyNode.setName(prop);
            // extensionNode.getChildren().add(propertyNode);
            // }

        }
        viewer.refresh();
        viewer.expandToLevel(chainNode, AbstractTreeViewer.ALL_LEVELS);

    }

    private void createViewerControl(Composite container) {
        viewer = new ContainerCheckedTreeViewer(container);
        viewer.setLabelProvider(new NodeLabelProvider());
        viewer.setContentProvider(new NodeContentProvider());
        GridData gd = new GridData(GridData.FILL_BOTH);
        viewer.getTree().setLayoutData(gd);
        viewer.setInput(model);
        viewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                refreshButtons();
            }
        });

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
                    if (uri.startsWith("platform:/plugin"))
                        uri = uri.substring("platform:/plugin".length());
                    else if (uri.startsWith("platform:/resource"))
                        uri = uri.substring("platform:/resource".length());
                    else
                        return;
                    addEcore(uri);
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
                        if (node.isContainerNode()) {
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
            if (node.isContainerNode()) {
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
                    if (!node.isContainerNode()) {
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

}
