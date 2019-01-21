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

package org.eclipse.egf.core.ui.contributor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class EditorListenerContributor {

    protected Map<StructuredViewer, IDoubleClickListener> _listeners = new HashMap<StructuredViewer, IDoubleClickListener>();

    public EditorListenerContributor() {
        // Nothing to do
    }

    public abstract void addListener(final IWorkbenchPage page, StructuredViewer viewer);

    public void removeListener(StructuredViewer viewer) {
        if (viewer == null) {
            return;
        }
        // Remove listener
        IDoubleClickListener listener = _listeners.get(viewer);
        if (listener != null) {
            viewer.removeDoubleClickListener(listener);
        }
        // Remove viewer
        _listeners.remove(viewer);
    }

    public void dispose() {
        for (Map.Entry<StructuredViewer, IDoubleClickListener> entry : _listeners.entrySet()) {
            entry.getKey().removeDoubleClickListener(entry.getValue());
        }
        _listeners.clear();
    }

}
