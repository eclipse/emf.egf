/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * XiaoRu Chen, Soyatec
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.modifiers;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;

/**
 * 
 * @author XiaoRu Chen - Soyatec
 * 
 */
public abstract class EditingDomainCellModifier implements ICellModifier {

    private TransactionalEditingDomain editingDomain;

    private TableViewer tableViewer;

    public EditingDomainCellModifier(TransactionalEditingDomain editingDomain, TableViewer tableViewer) {
        this.editingDomain = editingDomain;
        this.tableViewer = tableViewer;
    }

    public void doModify(final Runnable runnable) {
        RecordingCommand cmd = new RecordingCommand(editingDomain) {

            @Override
            protected void doExecute() {
                runnable.run();
                if (tableViewer != null && !tableViewer.getTable().isDisposed())
                    tableViewer.refresh();
            }

        };
        editingDomain.getCommandStack().execute(cmd);
    }

}
