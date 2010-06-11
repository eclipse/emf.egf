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

package org.eclipse.egf.core.ui.dialogs;

import java.util.Map;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.genmodel.IPlatformGenModel;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class LoadEcoreDialog extends LoadResourceDialog {

    private boolean _asEPackageNsURI;

    public LoadEcoreDialog(Shell parent, EditingDomain domain) {
        this(parent, domain, false);
    }

    public LoadEcoreDialog(Shell parent, EditingDomain domain, boolean asEPackageNsURI) {
        super(parent, domain);
        _asEPackageNsURI = asEPackageNsURI;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);
        Composite buttonComposite = (Composite) composite.getChildren()[0];
        Button browseRegisteredPackagesButton = new Button(buttonComposite, SWT.PUSH);
        browseRegisteredPackagesButton.setText(CoreUIMessages._UI_BrowseRegisteredPackages_label);
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
                PlatformPackageDialog dialog = new PlatformPackageDialog(getShell());
                if (dialog.open() != Window.OK) {
                    return;
                }
                Object[] result = dialog.getResult();
                if (result == null) {
                    return;
                }
                ResourceSet resourceSet = new ResourceSetImpl();
                resourceSet.setURIConverter(EGFCorePlugin.getPlatformURIConverter());
                StringBuffer uris = new StringBuffer();
                if (dialog.isTarget() && _asEPackageNsURI == false) {
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

}
