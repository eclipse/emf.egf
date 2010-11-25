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

import org.eclipse.egf.core.ui.contributor.DefaultPropertyEditorContributor;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.FilesystemDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;

/**
 * @author Thomas Guiu
 * 
 */
public class FilesystemDomainEditorContributor extends DefaultPropertyEditorContributor {

    public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
        return checkFeature(object, descriptor, DomainPackage.Literals.FILESYSTEM_DOMAIN__PATH) && object instanceof FilesystemDomain;
    }

    public CellEditor createPropertyEditor(Composite composite, Object object, IItemPropertyDescriptor descriptor) {

        final FilesystemDomain domain = (FilesystemDomain) object;

        return new NullableDialogCellEditor(composite, getLabelProvider(object, descriptor)) {

            @Override
            protected Object openDialogBox(Control control) {
                DirectoryDialog dialog = new DirectoryDialog(control.getShell(), SWT.OPEN | SWT.SINGLE);
                return dialog.open();
            }

        };

    }
}
