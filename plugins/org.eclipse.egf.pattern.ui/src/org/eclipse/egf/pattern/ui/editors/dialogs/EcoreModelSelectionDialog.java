/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * XiaoRu Chen, Soyatec
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.dialogs;

import java.util.Arrays;
import java.util.Map;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.domain.EGFResourceSet;
import org.eclipse.egf.core.genmodel.IPlatformGenModel;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.presentation.EcoreEditorPlugin;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * 
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class EcoreModelSelectionDialog extends LoadResourceDialog {

    public EcoreModelSelectionDialog(Shell parent, EditingDomain domain) {
        super(parent, domain);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);
        Composite buttonComposite = (Composite) composite.getChildren()[0];
        Button browseRegisteredPackagesButton = new Button(buttonComposite, SWT.PUSH);
        browseRegisteredPackagesButton.setText(EcoreEditorPlugin.INSTANCE.getString("_UI_BrowseRegisteredPackages_label")); //$NON-NLS-1$
        prepareBrowseRegisteredPackagesButton(browseRegisteredPackagesButton);
        {
            FormData data = new FormData();
            Control[] children = buttonComposite.getChildren();
            data.right = new FormAttachment(children[0], -CONTROL_OFFSET);
            browseRegisteredPackagesButton.setLayoutData(data);
        }
        return composite;
    }

    protected void prepareBrowseRegisteredPackagesButton(Button browseRegisteredPackagesButton) {
        browseRegisteredPackagesButton.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent event) {
                RegisteredPackageDialog registeredPackageDialog = new RegisteredPackageDialog(getShell());
                registeredPackageDialog.open();
                Object[] result = registeredPackageDialog.getResult();
                if (result == null) {
                    return;
                }
                StringBuffer uris = new StringBuffer();
                if (registeredPackageDialog.isTarget()) {
                    ResourceSet resourceSet = new EGFResourceSet();
                    Map<String, URI> ePackageNsURItoGenModelLocationMap = EGFCorePlugin.getEPackageNsURIToGenModelLocationMap();
                    for (int i = 0, length = result.length; i < length; i++) {
                        IPlatformGenModel genmodel = (IPlatformGenModel) result[i];
                        // TODO: nothing is done yet when no genmodel resource is associated
                        if (genmodel.getURI() == null) {
                            continue;
                        }
                        URI location = ePackageNsURItoGenModelLocationMap.get(genmodel.getURI().toString());
                        Resource resource = resourceSet.getResource(location, true);
                        EcoreUtil.resolveAll(resource);
                    }
                    for (Resource resource : resourceSet.getResources()) {
                        LOOP: for (EPackage ePackage : EMFHelper.getAllPackages(resource)) {
                            for (int i = 0, length = result.length; i < length; i++) {
                                if (((IPlatformGenModel) result[i]).getId().compareTo(ePackage.getNsURI()) == 0) {
                                    URI resourceUri = resource.getURI();
                                    uris.append(resourceUri);
                                    uris.append("  "); //$NON-NLS-1$
                                    continue LOOP;
                                }
                            }
                        }
                    }
                    uriField.setText(""); //$NON-NLS-1$
                    uriField.setText((uriField.getText() + "  " + uris.toString()).trim()); //$NON-NLS-1$
                } else {
                    for (int i = 0, length = result.length; i < length; i++) {
                        uris.append(result[i]);
                        uris.append("  "); //$NON-NLS-1$
                    }
                    uriField.setText(""); //$NON-NLS-1$
                    uriField.setText((uriField.getText() + "  " + uris.toString()).trim()); //$NON-NLS-1$
                }
            }
        });

    }

    public static class RegisteredPackageDialog extends ElementListSelectionDialog {

        protected boolean isTarget = true;

        public RegisteredPackageDialog(Shell parent) {
            super(parent, new LabelProvider() {

                @Override
                public String getText(Object element) {
                    if (element == null || element instanceof IPlatformGenModel == false) {
                        return element == null ? "" : element.toString();//$NON-NLS-1$
                    }
                    return ((IPlatformGenModel) element).getURI().toString();
                }

                @Override
                public Image getImage(Object element) {
                    return ExtendedImageRegistry.getInstance().getImage(EcoreEditPlugin.INSTANCE.getImage("full/obj16/EPackage")); //$NON-NLS-1$
                }

            });

            setMultipleSelection(true);
            setMessage(EcoreEditorPlugin.INSTANCE.getString("_UI_SelectRegisteredPackageURI")); //$NON-NLS-1$
            setFilter("*"); //$NON-NLS-1$
            setTitle(EcoreEditorPlugin.INSTANCE.getString("_UI_PackageSelection_label")); //$NON-NLS-1$
        }

        public boolean isTarget() {
            return isTarget;
        }

        protected void updateElements() {
            Object[] result = null;
            if (isTarget) {
                result = EGFCorePlugin.getPlatformGenModels();
            } else {
                result = EPackage.Registry.INSTANCE.keySet().toArray(new Object[EPackage.Registry.INSTANCE.size()]);
            }
            Arrays.sort(result);
            setListElements(result);
        }

        @Override
        protected Control createDialogArea(Composite parent) {
            Composite result = (Composite) super.createDialogArea(parent);
            Composite buttonGroup = new Composite(result, SWT.NONE);
            GridLayout layout = new GridLayout();
            layout.numColumns = 2;
            buttonGroup.setLayout(layout);
            final Button targetButton = new Button(buttonGroup, SWT.RADIO);
            targetButton.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent event) {
                    isTarget = targetButton.getSelection();
                    updateElements();
                }

            });
            targetButton.setText(Messages._UI_TargetPlatform_label);
            Button runtimeTimeVersionButton = new Button(buttonGroup, SWT.RADIO);
            runtimeTimeVersionButton.setText(Messages._UI_RuntimeVersion_label);
            targetButton.setSelection(true);
            updateElements();
            return result;
        }
    }
}
