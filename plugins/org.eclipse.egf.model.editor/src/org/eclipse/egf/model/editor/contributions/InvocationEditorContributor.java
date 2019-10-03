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
import org.eclipse.egf.model.editor.dialogs.ActivitySelectionDialog;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Thomas Guiu
 * 
 */
public class InvocationEditorContributor extends DefaultPropertyEditorContributor {

    public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
        return checkFeature(object, descriptor, FcorePackage.Literals.INVOCATION__INVOKED_ACTIVITY) && object instanceof Invocation;
    }

    public CellEditor createPropertyEditor(Composite composite, Object object, IItemPropertyDescriptor descriptor) {

        final Invocation invocation = (Invocation) object;

        return new ExtendedDialogCellEditor(composite, getLabelProvider(object, descriptor)) {

            @Override
            protected Object openDialogBox(Control control) {
                ActivitySelectionDialog dialog = new ActivitySelectionDialog(control.getShell(), invocation.getInvokedActivity(), false);
                if (dialog.open() == Window.OK) {
                    Object result = dialog.getFirstResult();
                    if (result != null && result instanceof Activity) {
                        // solve activity against our current domain
                        invocation.eResource().getResourceSet().getResource(((Activity) result).eResource().getURI(), true);
                        // Return selected value
                        return result;
                    }
                }
                return invocation.getInvokedActivity();
            }

        };

    }

}
