package org.eclipse.egf.pattern.ui.editors.providers;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.TableItem;

public class ParametersTableContentProvider extends ObservableListContentProvider {
    private TableViewer tableViewer;

    public ParametersTableContentProvider(TableViewer tableViewer) {
        this.tableViewer = tableViewer;
        addRemoveAdapter();
    }

    final AdapterImpl refresher = new AdapterImpl() {
        public void notifyChanged(org.eclipse.emf.common.notify.Notification msg) {
            if (msg.getEventType() == Notification.SET || msg.getEventType() == Notification.UNSET) {
                if (tableViewer != null && tableViewer.getTable() != null && !tableViewer.getTable().isDisposed()) {
                    tableViewer.refresh();
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

    private void addRemoveAdapter() {
        tableViewer.getTable().addDisposeListener(new DisposeListener() {

            public void widgetDisposed(DisposeEvent e) {
                TableItem[] items = tableViewer.getTable().getItems();
                for (TableItem item : items) {
                    Object object = item.getData();
                    if (object instanceof EObject&& ((EObject) object).eAdapters().contains(refresher)) {
                        ((EObject) object).eAdapters().remove(refresher);
                    }
                }
            }
        });
    }
}
