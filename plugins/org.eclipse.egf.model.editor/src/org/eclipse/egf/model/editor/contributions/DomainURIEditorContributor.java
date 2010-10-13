/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.model.editor.contributions;

import java.util.List;

import org.eclipse.egf.core.ui.contributor.DefaultPropertyEditorContributor;
import org.eclipse.egf.core.ui.dialogs.LoadEcoreDialog;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Xavier Maysonnave
 * 
 */
public class DomainURIEditorContributor extends DefaultPropertyEditorContributor {

    public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
        return checkFeature(object, descriptor, DomainPackage.Literals.DOMAIN_URI__URI) && object instanceof DomainURI;
    }

    public CellEditor createPropertyEditor(Composite composite, Object object, IItemPropertyDescriptor descriptor) {

        final DomainURI domainURI = (DomainURI) object;

        // Current Editing Domain
        final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(domainURI);
        if (editingDomain == null) {
            return null;
        }

        return new ExtendedDialogCellEditor(composite, getLabelProvider(object, descriptor)) {

            @Override
            protected Object openDialogBox(Control control) {
                LoadEcoreDialog dialog = new LoadEcoreDialog(control.getShell(), editingDomain, false, true, false, true, true) {

                    @Override
                    protected Control createDialogArea(Composite parent) {
                        Control innerControl = super.createDialogArea(parent);
                        if (domainURI.getUri() != null) {
                            uriField.setText(domainURI.getUri().toString());
                        }
                        return innerControl;
                    }

                };
                if (dialog.open() == Window.OK) {
                    List<URI> results = dialog.getURIs();
                    if (results != null && results.size() > 0) {
                        return results.get(0);
                    }
                    // Empty URI are processed to null in doSetValue
                    return URI.createURI(""); //$NON-NLS-1$
                }
                return domainURI.getUri();
            }

            @Override
            protected void doSetValue(Object value) {
                if (value != null && "".equals(value.toString())) { //$NON-NLS-1$
                    super.doSetValue(null);
                } else {
                    super.doSetValue(value);
                }
            }

        };

    }
}
