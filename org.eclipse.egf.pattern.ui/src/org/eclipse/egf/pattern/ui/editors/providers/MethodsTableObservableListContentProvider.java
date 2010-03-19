package org.eclipse.egf.pattern.ui.editors.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.ui.PatternUIHelper;
import org.eclipse.egf.pattern.ui.editors.adapter.RefresherAdapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.TableItem;

public class MethodsTableObservableListContentProvider extends ObservableListContentProvider {

    private TableViewer tableViewer;

    protected AdapterImpl refresher;

    public MethodsTableObservableListContentProvider(TableViewer tableViewer, int patternMethodsNum) {
        super(patternMethodsNum, tableViewer);
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

    public Object[] getElements(Object inputElement) {
        Object[] elements = super.getElements(inputElement);
        List displayItems = new ArrayList();
        for (Object element : elements) {
            if (!PatternUIHelper.isRenameDisable((PatternMethod) element)) {
                displayItems.add(element);
                PatternUIHelper.addAdapter(elements, refresher);
            } else {
                PatternUIHelper.removeAdapter(elements, refresher);
            }
        }
        return displayItems.toArray();
    }
}
