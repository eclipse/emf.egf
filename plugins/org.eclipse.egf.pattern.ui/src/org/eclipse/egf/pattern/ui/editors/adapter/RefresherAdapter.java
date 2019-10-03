package org.eclipse.egf.pattern.ui.editors.adapter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.viewers.TableViewer;

public class RefresherAdapter extends AdapterImpl {

    private TableViewer tableViewer;

    public RefresherAdapter(TableViewer tableViewer) {
        this.tableViewer = tableViewer;
    }

    @Override
    public void notifyChanged(org.eclipse.emf.common.notify.Notification msg) {
        if (msg.isTouch()) {
            return;
        }
        if (msg.getFeature() instanceof EAttribute && (msg.getEventType() == Notification.SET || msg.getEventType() == Notification.UNSET)) {
            if (tableViewer != null && tableViewer.getTable() != null && !tableViewer.getTable().isDisposed()) {
                tableViewer.refresh();
            }
        }
    }

}
