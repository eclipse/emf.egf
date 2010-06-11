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

package org.eclipse.egf.pattern.ui.contributions;

import org.eclipse.egf.core.ui.contributor.EditorListenerContributor;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @author Thomas Guiu
 * 
 */
public class PatternListenerContributor extends EditorListenerContributor {

    @Override
    public void addListener(final IWorkbenchPage page, StructuredViewer viewer) {
        if (page == null || viewer == null) {
            return;
        }
        IDoubleClickListener listener = new IDoubleClickListener() {

            public void doubleClick(DoubleClickEvent event) {
                if (event.getSelection().isEmpty()) {
                    return;
                }
                Object firstElement = ((IStructuredSelection) event.getSelection()).getFirstElement();
                if (firstElement instanceof Pattern) {
                    EditHelper.openPatternEditor(page, ((Pattern) firstElement).getID());
                }
            }
        };
        viewer.addDoubleClickListener(listener);
        _listeners.put(viewer, listener);
    }

}
