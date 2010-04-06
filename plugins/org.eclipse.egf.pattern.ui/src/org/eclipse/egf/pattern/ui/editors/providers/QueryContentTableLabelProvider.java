package org.eclipse.egf.pattern.ui.editors.providers;

import org.eclipse.egf.pattern.ui.editors.models.QueryContent;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

public class QueryContentTableLabelProvider implements ITableLabelProvider {

    public Image getColumnImage(Object element, int columnIndex) {

        return null;
    }

    public String getColumnText(Object element, int columnIndex) {
        if (element instanceof QueryContent) {
            QueryContent content = (QueryContent) element;
            switch (columnIndex) {
            case 0:
                return content.getKey();
            case 1:
                return content.getValue();
            }
        }
        return null;
    }

    public void addListener(ILabelProviderListener listener) {
    }

    public void dispose() {
    }

    public boolean isLabelProperty(Object element, String property) {

        return false;
    }

    public void removeListener(ILabelProviderListener listener) {
    }

}
