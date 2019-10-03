/**
 * <copyright>
 * 
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
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.providers;

import org.eclipse.egf.pattern.ui.PatternUIHelper;
import org.eclipse.egf.pattern.ui.editors.adapter.RefresherAdapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.TableItem;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class TableObservableListContentProvider extends ObservableListContentProvider {

    private TableViewer tableViewer;

    protected AdapterImpl refresher;

    public TableObservableListContentProvider(TableViewer tableViewer) {
        this.tableViewer = tableViewer;
        refresher = new RefresherAdapter(tableViewer);
        addDisposeListener();
    }

    private void addDisposeListener() {
        tableViewer.getTable().addDisposeListener(new DisposeListener() {

            public void widgetDisposed(DisposeEvent e) {
                TableItem[] items = tableViewer.getTable().getItems();
                for (TableItem item : items) {
                    Object object = item.getData();
                    PatternUIHelper.removeAdapter(object, refresher);
                }
            }

        });
    }

    @Override
    public Object[] getElements(Object inputElement) {
        Object[] elements = super.getElements(inputElement);
        for (int i = 0; i < elements.length; i++) {
            PatternUIHelper.addAdapter(elements[i], refresher);
        }
        return elements;
    }

}
