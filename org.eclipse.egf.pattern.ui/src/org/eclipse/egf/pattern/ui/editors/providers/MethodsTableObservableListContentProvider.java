package org.eclipse.egf.pattern.ui.editors.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.ui.PatternUIHelper;
import org.eclipse.jface.viewers.TableViewer;

public class MethodsTableObservableListContentProvider extends TableObservableListContentProvider {

    public MethodsTableObservableListContentProvider(TableViewer tableViewer) {
        super(tableViewer);
    }

    public Object[] getElements(Object inputElement) {
        Object[] elements = super.getElements(inputElement);
        List displayItems = new ArrayList();
        for (Object element : elements) {
            if (!PatternUIHelper.isRenameDisable((PatternMethod) element)) {
                displayItems.add(element);
                PatternUIHelper.addAdapter(elements, refresher);
            }
        }
        return displayItems.toArray();
    }
}
