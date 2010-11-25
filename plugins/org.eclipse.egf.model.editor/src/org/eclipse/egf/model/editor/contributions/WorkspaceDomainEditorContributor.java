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
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.WorkspaceDomain;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Thomas Guiu
 * 
 */
public class WorkspaceDomainEditorContributor extends DefaultPropertyEditorContributor {

    public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
        return checkFeature(object, descriptor, DomainPackage.Literals.WORKSPACE_DOMAIN__PATH) && object instanceof WorkspaceDomain;
    }

    public CellEditor createPropertyEditor(Composite composite, Object object, IItemPropertyDescriptor descriptor) {

        final WorkspaceDomain domain = (WorkspaceDomain) object;

        return new NullableDialogCellEditor(composite, getLabelProvider(object, descriptor)) {

            @Override
            protected Object openDialogBox(Control control) {
                ResourceDialog dialog = new ResourceDialog(control.getShell(), "test", SWT.OPEN | SWT.SINGLE);
                if (dialog.open() == Window.OK) {
                    List<URI> results = dialog.getURIs();
                    if (results != null && results.size() > 0) {
                        return results.get(0).toString();
                    }
                    // Empty URI are processed to null in doSetValue
                    return URI.createURI(""); //$NON-NLS-1$
                }
                return domain.getPath();
            }

        };

    }
}
