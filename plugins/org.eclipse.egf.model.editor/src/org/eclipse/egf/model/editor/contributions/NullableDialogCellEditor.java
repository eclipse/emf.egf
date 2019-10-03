/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.model.editor.contributions;

import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class NullableDialogCellEditor extends ExtendedDialogCellEditor {

    public NullableDialogCellEditor(Composite composite, ILabelProvider labelProvider) {
        super(composite, labelProvider);

    }

    @Override
    protected void doSetValue(Object value) {
        if (value != null && "".equals(value.toString())) { //$NON-NLS-1$
            super.doSetValue(null);
        } else {
            super.doSetValue(value);
        }
    }

}
