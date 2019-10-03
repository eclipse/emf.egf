/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.model.editor.contributions;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.core.ui.contributor.DefaultPropertyEditorContributor;
import org.eclipse.egf.model.domain.DomainPackage;
import org.eclipse.egf.model.domain.WorkspaceDomain;
import org.eclipse.egf.model.editor.l10n.ModelEditorMessages;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
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
                Object[] initialSelection = null;
                if (domain.getPath() != null) {
                    final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(domain.getPath()));
                    initialSelection = new Object[] { folder };
                }
                String title = ModelEditorMessages.FolderSelectionDialogTitle;
                String message = ModelEditorMessages.FolderSelectionDialogMessage;
                final IContainer[] folders = WorkspaceResourceDialog.openFolderSelection(control.getShell(), title, message, false, initialSelection, null);
                if (folders.length == 1) {
                    return folders[0].getFullPath().toString();
                }
                return domain.getPath();
            }

        };

    }
}
