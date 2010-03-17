/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.model.editor.contributions;

import org.eclipse.egf.core.ui.contributor.DefaultPropertyEditorContributor;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.editor.dialogs.ActivitySelectionDialog;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Thomas Guiu
 * 
 */
public class InvocationEditorContributor extends DefaultPropertyEditorContributor {

    public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
        Object feature = descriptor.getFeature(object);
        return feature.equals(FcorePackage.Literals.INVOCATION__INVOKED_ACTIVITY) && object instanceof Invocation;
    }

    public CellEditor createPropertyEditor(Composite composite, Object object, IItemPropertyDescriptor descriptor) {
        final Invocation invocation = (Invocation) object;

        return new ExtendedDialogCellEditor(composite, getLabelProvider(object, descriptor)) {
            @Override
            protected Object openDialogBox(Control cellEditorWindow) {
                ActivitySelectionDialog dialog = new ActivitySelectionDialog(EGFModelEditorPlugin.getActiveWorkbenchShell(), invocation.eResource(), invocation.getInvokedActivity(), false);
                dialog.open();
                Object[] innerResult = dialog.getResult();
                if (innerResult != null && innerResult.length > 0 && innerResult[0] instanceof Activity) {
                    // Force a load resource on the current ResourceSet
                    Activity activity = (Activity) innerResult[0];
                    invocation.eResource().getResourceSet().getResource(activity.eResource().getURI(), true);
                    // Return selected value
                    return innerResult[0];
                }
                return invocation.getInvokedActivity();
            }
        };
    }

}
