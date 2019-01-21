/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.ui.dialogs;

import java.util.List;

import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class AbstractFilteredItemsSelectionDialog extends FilteredItemsSelectionDialog {

    private List<ISelectionDialogListener> _selectionListeners = new UniqueEList<ISelectionDialogListener>();

    public AbstractFilteredItemsSelectionDialog(Shell shell, boolean multi) {
        super(shell, multi);
    }

    public AbstractFilteredItemsSelectionDialog(Shell shell) {
        super(shell);
    }

    public boolean addSelectionListeners(ISelectionDialogListener listener) {
        if (listener == null) {
            return false;
        }
        return _selectionListeners.add(listener);
    }

    public boolean removeSelectionListeners(ISelectionDialogListener listener) {
        if (listener == null) {
            return false;
        }
        return _selectionListeners.remove(listener);
    }

    public void notifySelectionListeners(Object[] selected) {
        for (ISelectionDialogListener listener : _selectionListeners) {
            listener.handleSelected(selected);
        }
    }

}
