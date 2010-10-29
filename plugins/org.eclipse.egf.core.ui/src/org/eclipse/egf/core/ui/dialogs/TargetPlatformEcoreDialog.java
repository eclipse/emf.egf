/**
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
 * Xavier Maysonnave, Soyatec
 * 
 */
package org.eclipse.egf.core.ui.dialogs;

import java.util.Map;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.domain.TargetPlatformResourceSet;
import org.eclipse.egf.core.genmodel.IPlatformGenModel;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.emf.common.ui.CommonUIPlugin;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * 
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class TargetPlatformEcoreDialog extends ResourceDialog {

    protected boolean _workspace;

    protected boolean _fileSystem;

    protected boolean _multi;

    protected EditingDomain _domain;

    private boolean _packageNsURI;

    private boolean _genmodelURI;

    public TargetPlatformEcoreDialog(Shell parent) {
        this(parent, null, false, false, true, true, true);
    }

    public TargetPlatformEcoreDialog(Shell parent, EditingDomain domain) {
        this(parent, domain, false, false, true, true, true);
    }

    public TargetPlatformEcoreDialog(Shell parent, boolean packageNsURI, boolean genmodelURI, boolean multi, boolean workspace, boolean fileSystem) {
        this(parent, null, packageNsURI, genmodelURI, multi, workspace, fileSystem);
    }

    public TargetPlatformEcoreDialog(Shell parent, EditingDomain domain, boolean packageNsURI, boolean genmodelURI, boolean multi, boolean workspace, boolean fileSystem) {
        super(parent, packageNsURI ? CoreUIMessages._UI_BrowseRegisteredPackages_title : CoreUIMessages._UI_BrowseResource_title, multi ? SWT.OPEN | SWT.MULTI : SWT.OPEN | SWT.SINGLE);
        _packageNsURI = packageNsURI;
        _domain = domain;
        _multi = multi;
        _workspace = workspace;
        _fileSystem = fileSystem;
        _genmodelURI = genmodelURI;
    }

    @Override
    protected boolean processResources() {
        if (_domain != null) {
            for (URI uri : getURIs()) {
                try {
                    if (processResource(_domain.getResourceSet().getResource(uri, true)) == false) {
                        return false;
                    }
                } catch (RuntimeException re) {
                    EGFCoreUIPlugin.getDefault().logError(NLS.bind(CoreUIMessages.ModelSelection_errorMessage, uri));
                }
            }
        }
        return true;
    }

    protected boolean processResource(Resource resource) {
        return true;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);
        updateComposite(composite);
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

    private void updateComposite(Composite composite) {
        for (Control control : composite.getChildren()) {
            if (control instanceof Button) {
                Button button = (Button) control;
                if (CommonUIPlugin.INSTANCE.getString("_UI_BrowseFileSystem_label").equals(button.getText()) && _fileSystem == false) { //$NON-NLS-1$
                    button.setVisible(false);
                } else if (CommonUIPlugin.INSTANCE.getString("_UI_BrowseWorkspace_label").equals(button.getText()) && _workspace == false) { //$NON-NLS-1$
                    button.setVisible(false);
                }
            } else if (control instanceof Text) {
                Text text = (Text) control;
                if (CommonUIPlugin.INSTANCE.getString(isMulti() ? "_UI_ResourceURIs_label" : "_UI_ResourceURI_label").equals(text.getText())) { //$NON-NLS-1$ //$NON-NLS-2$
                    if (_packageNsURI) {
                        if (_multi) {
                            text.setText(CoreUIMessages._UI_PackageURIs_label);
                        } else {
                            text.setText(CoreUIMessages._UI_PackageURI_label);
                        }
                    }
                }
            } else if (control instanceof Composite) {
                updateComposite((Composite) control);
            }
        }
    }

    protected void prepareBrowseRegisteredPackagesButton(Button browseRegisteredPackagesButton) {

        browseRegisteredPackagesButton.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent event) {
                TargetPlatformPackageDialog dialog = new TargetPlatformPackageDialog(getShell(), _multi);
                if (dialog.open() != Window.OK) {
                    return;
                }
                IPlatformGenModel[] result = dialog.getSelectedPlatformGenModels();
                if (result == null) {
                    return;
                }
                StringBuffer uris = new StringBuffer();
                if (_packageNsURI) {
                    for (int i = 0, length = result.length; i < length; i++) {
                        uris.append(result[i]);
                        uris.append("  "); //$NON-NLS-1$
                    }
                    uriField.setText(""); //$NON-NLS-1$
                    uriField.setText((uriField.getText() + "  " + uris.toString()).trim()); //$NON-NLS-1$
                } else if (_genmodelURI) {
                    Map<URI, URI> ePackageNsURItoGenModelLocationMap = EGFCorePlugin.getTargetPlatformGenModelLocationMap();
                    for (int i = 0, length = result.length; i < length; i++) {
                        if (result[i].getURI() == null) {
                            EGFCoreUIPlugin.getDefault().logWarning(NLS.bind(CoreUIMessages._UI_No_Associated_GenModel, result[i].getNsURI()));
                            continue;
                        }
                        URI location = ePackageNsURItoGenModelLocationMap.get(result[i].getURI());
                        if (location != null) {
                            uris.append(location);
                            uris.append("  "); //$NON-NLS-1$                            
                        }
                    }
                    if (uris.length() != 0) {
                        uriField.setText(""); //$NON-NLS-1$
                        uriField.setText((uriField.getText() + "  " + uris.toString()).trim()); //$NON-NLS-1$
                    }
                } else {
                    ResourceSet resourceSet = new TargetPlatformResourceSet();
                    Map<URI, URI> ePackageNsURItoGenModelLocationMap = EGFCorePlugin.getTargetPlatformGenModelLocationMap();
                    for (int i = 0, length = result.length; i < length; i++) {
                        if (result[i].getURI() == null) {
                            EGFCoreUIPlugin.getDefault().logWarning(NLS.bind(CoreUIMessages._UI_No_Associated_GenModel, result[i].getNsURI()));
                            continue;
                        }
                        URI location = ePackageNsURItoGenModelLocationMap.get(result[i].getURI());
                        Resource resource = resourceSet.getResource(location, true);
                        if (resource != null) {
                            EcoreUtil.resolveAll(resource);
                        }
                    }
                    for (Resource resource : resourceSet.getResources()) {
                        LOOP: for (EPackage ePackage : EMFHelper.getAllPackages(resource)) {
                            for (int i = 0, length = result.length; i < length; i++) {
                                if (result[i].getURI().toString().equals(ePackage.getNsURI())) {
                                    URI resourceUri = resource.getURI();
                                    uris.append(resourceUri);
                                    uris.append("  "); //$NON-NLS-1$
                                    continue LOOP;
                                }
                            }
                        }
                    }
                    if (uris.length() != 0) {
                        uriField.setText(""); //$NON-NLS-1$
                        uriField.setText((uriField.getText() + "  " + uris.toString()).trim()); //$NON-NLS-1$
                    }
                }
            }

        });

    }

}
