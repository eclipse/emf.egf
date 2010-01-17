/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.providers;

import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
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

    final AdapterImpl refresher = new AdapterImpl() {
        public void notifyChanged(org.eclipse.emf.common.notify.Notification msg) {
            if (msg.getEventType() == Notification.SET || msg.getEventType() == Notification.UNSET) {
                if (tableViewer != null && tableViewer.getTable() != null && !tableViewer.getTable().isDisposed()) {
                    tableViewer.refresh();
                }
            }
        };
    };

    public TableObservableListContentProvider(TableViewer tableViewer) {
        this.tableViewer = tableViewer;
        addDisposeListener();
    }

    private void addDisposeListener() {
        tableViewer.getTable().addDisposeListener(new DisposeListener() {

            public void widgetDisposed(DisposeEvent e) {
                TableItem[] items = tableViewer.getTable().getItems();
                for (TableItem item : items) {
                    Object object = item.getData();
                    removeAdapter(object);
                }
            }
        });
    }

    public Object[] getElements(Object inputElement) {
        Object[] elements = super.getElements(inputElement);
        for (int i = 0; i < elements.length; i++) {
            addAdapter(elements[i]);

        }
        return elements;
    }

    public void addAdapter(Object object) {
        if (object instanceof EObject) {
            EList<Adapter> eAdapters = ((EObject) object).eAdapters();
            addIntoAdapters(eAdapters);
            addChildAdapter(object);
        }
    }

    private void removeAdapter(Object object) {
        if (object instanceof EObject) {
            EList<Adapter> eAdapters = ((EObject) object).eAdapters();
            removeFromeAdapters(eAdapters);
            removeChildAdapter(object);
        }
    }

    /**
     * Add adapter for the MethodCall's called or PatternInjectedCall's context.
     */
    private void addChildAdapter(Object object) {
        if (object instanceof MethodCall) {
            EList<Adapter> eAdapters = ((MethodCall) object).getCalled().eAdapters();
            addIntoAdapters(eAdapters);

        } else if (object instanceof PatternInjectedCall) {
            EList<Adapter> eAdapters = ((PatternInjectedCall) object).getContext().eAdapters();
            addIntoAdapters(eAdapters);
        }
    }

    /**
     * Remove the MethodCall's called or PatternInjectedCall's context adapters.
     */
    private void removeChildAdapter(Object object) {
        if (object instanceof MethodCall) {
            EList<Adapter> eAdapters = ((MethodCall) object).getCalled().eAdapters();
            removeFromeAdapters(eAdapters);

        } else if (object instanceof PatternInjectedCall) {
            EList<Adapter> eAdapters = ((PatternInjectedCall) object).getContext().eAdapters();
            removeFromeAdapters(eAdapters);
        }
    }

    private void addIntoAdapters(EList<Adapter> eAdapters) {
        if (!eAdapters.contains(refresher)) {
            eAdapters.add(refresher);
        }
    }

    private void removeFromeAdapters(EList<Adapter> eAdapters) {
        if (eAdapters.contains(refresher)) {
            eAdapters.remove(refresher);
        }
    }
}
