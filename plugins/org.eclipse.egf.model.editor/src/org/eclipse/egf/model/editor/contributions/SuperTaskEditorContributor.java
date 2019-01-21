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

import org.eclipse.egf.core.ui.contributor.DefaultPropertyEditorContributor;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.editor.dialogs.TaskSelectionDialog;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.ftask.FtaskPackage;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Thomas Guiu
 * 
 */
public class SuperTaskEditorContributor extends DefaultPropertyEditorContributor {

    public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
        return checkFeature(object, descriptor, FtaskPackage.Literals.TASK__SUPER_TASK) && object instanceof Task;
    }

    public CellEditor createPropertyEditor(Composite composite, Object object, IItemPropertyDescriptor descriptor) {

        final Task task = (Task) object;
        return new ExtendedDialogCellEditor(composite, getLabelProvider(object, descriptor)) {

            @Override
            protected Object openDialogBox(Control cellEditorWindow) {
                TaskSelectionDialog dialog = new TaskSelectionDialog(EGFModelEditorPlugin.getActiveWorkbenchShell(), task.getSuperTask(), false);
                dialog.open();
                Object[] innerResult = dialog.getResult();
                if (innerResult != null && innerResult.length > 0 && innerResult[0] instanceof Task) {
                    // Force a load resource on the current ResourceSet
                    Activity activity = (Activity) innerResult[0];
                    task.eResource().getResourceSet().getResource(activity.eResource().getURI(), true);
                    // Return selected value
                    return innerResult[0];
                }
                return task.getSuperTask();
            }

        };

    }

}
