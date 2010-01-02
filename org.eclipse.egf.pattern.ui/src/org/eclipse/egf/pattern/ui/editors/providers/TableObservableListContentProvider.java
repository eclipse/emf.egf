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

package org.eclipse.egf.pattern.ui.editors.providers;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
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

    private TableViewer relationTableViewer;

    public TableObservableListContentProvider(TableViewer tableViewer) {
        this.tableViewer = tableViewer;
        removeAdapter();
    }

    public TableObservableListContentProvider(TableViewer tableViewer, TableViewer relationTableViewer) {
        this.tableViewer = tableViewer;
        this.relationTableViewer = relationTableViewer;
        removeAdapter();
    }

    final AdapterImpl refresher = new AdapterImpl() {
        public void notifyChanged(org.eclipse.emf.common.notify.Notification msg) {
            if (msg.getEventType() == Notification.SET || msg.getEventType() == Notification.UNSET) {
                if (tableViewer != null && tableViewer.getTable() != null && !tableViewer.getTable().isDisposed()) {
                    tableViewer.refresh();
                }
                if (relationTableViewer != null && relationTableViewer.getTable() != null && !relationTableViewer.getTable().isDisposed()) {
                    relationTableViewer.refresh();
                }
            }
        };
    };

    public Object[] getElements(Object inputElement) {
        Object[] elements = super.getElements(inputElement);
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] instanceof EObject && !((EObject) elements[i]).eAdapters().contains(refresher)) {
                ((EObject) elements[i]).eAdapters().add(refresher);
            }
        }
        return elements;
    }

    private void removeAdapter() {
        tableViewer.getTable().addDisposeListener(new DisposeListener() {

            public void widgetDisposed(DisposeEvent e) {
                TableItem[] items = tableViewer.getTable().getItems();
                for (TableItem item : items) {
                    Object object = item.getData();
                    if (object instanceof EObject && ((EObject) object).eAdapters().contains(refresher)) {
                        ((EObject) object).eAdapters().remove(refresher);
                    }
                }
            }
        });
    }
}
