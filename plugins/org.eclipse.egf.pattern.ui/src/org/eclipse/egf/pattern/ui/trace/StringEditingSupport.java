/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */

package org.eclipse.egf.pattern.ui.trace;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

/**
 * @author Thomas Guiu
 * 
 */
public class StringEditingSupport extends AbstractStringEditingSupport {
    private final TextCellEditor cellEditor;

    public StringEditingSupport(TableViewer viewer, Class candidate, String propertyName) {
        super(viewer, candidate, propertyName);
        cellEditor = new TextCellEditor(viewer.getTable());
    }

    @Override
    protected CellEditor getCellEditor(Object element) {
        return cellEditor;
    }

}
