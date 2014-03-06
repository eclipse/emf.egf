package org.eclipse.egf.pattern.ui.trace;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;

public abstract class BasicEditingSupport extends EditingSupport {

    public BasicEditingSupport(ColumnViewer viewer) {
        super(viewer);
    }

    @Override
    protected boolean canEdit(Object element) {
        return true;
    }

    protected abstract void doSetValue(Object element, Object value);

    protected final void setValue(Object element, Object value) {
        Object oldValue = getValue(element);
        if (value == null && oldValue == null)
            return;
        if (value != null && value.equals(oldValue))
            return;
        if (oldValue != null && oldValue.equals(value))
            return;
        doSetValue(element, value);
        getViewer().update(element, null);
    }

}