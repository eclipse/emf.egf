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

import java.util.List;

import org.eclipse.egf.core.ui.contributor.DefaultPropertyEditorContributor;
import org.eclipse.egf.model.editor.l10n.ModelEditorMessages;
import org.eclipse.egf.model.types.TypeURI;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TypeURIEditorContributor extends DefaultPropertyEditorContributor {

    public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
        return checkFeature(object, descriptor, TypesPackage.Literals.TYPE_URI__VALUE) && object instanceof TypeURI;
    }

    public CellEditor createPropertyEditor(Composite composite, Object object, IItemPropertyDescriptor descriptor) {

        final TypeURI type = (TypeURI) object;

        return new ExtendedDialogCellEditor(composite, getLabelProvider(object, descriptor)) {

            @Override
            protected Object openDialogBox(Control control) {
                ResourceDialog dialog = new ResourceDialog(control.getShell(), ModelEditorMessages.TypeURIEditorContributor_title, SWT.OPEN | SWT.SINGLE) {

                    @Override
                    protected Control createDialogArea(Composite parent) {
                        Control innerControl = super.createDialogArea(parent);
                        if (type.getValue() != null) {
                            uriField.setText(type.getValue().toString());
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
                return type.getValue();
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
