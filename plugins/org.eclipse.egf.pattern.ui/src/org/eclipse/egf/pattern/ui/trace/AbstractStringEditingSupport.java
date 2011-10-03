package org.eclipse.egf.pattern.ui.trace;

import java.lang.reflect.Method;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.jface.viewers.ColumnViewer;

public abstract class AbstractStringEditingSupport extends BasicEditingSupport {

    protected static final Class[] EMPTY_CLASS_ARRAY = new Class[0];
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    protected static final Class[] STRING_ARRAY = new Class[] { String.class };
    protected Method getter;
    protected Method setter;

    public AbstractStringEditingSupport(ColumnViewer viewer, Class candidate, String propertyName) {
        super(viewer);
        String getterName = "get" + Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
        String setterName = "set" + Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
        try {
            getter = candidate.getMethod(getterName, EMPTY_CLASS_ARRAY);
            setter = candidate.getMethod(setterName, STRING_ARRAY);
        } catch (Exception e) {
            EGFCoreUIPlugin.getDefault().getLog().log(new Status(IStatus.INFO, EGFCoreUIPlugin.getDefault().getPluginID(), "Cannot get method: disable editing support for property '" + propertyName + "'", e));
        }
    }

    @Override
    protected void doSetValue(Object element, Object value) {
        try {
            setter.invoke(element, new Object[] { value });
        } catch (Exception e) {
            EGFCoreUIPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, EGFCoreUIPlugin.getDefault().getPluginID(), e.getMessage(), e));
        }
    }

    @Override
    protected boolean canEdit(Object element) {
        if (setter == null || getter == null)
            return false;
        return super.canEdit(element);
    }

    @Override
    protected Object getValue(Object element) {
        try {
            Object value = getter.invoke(element, EMPTY_OBJECT_ARRAY);
            return value == null ? "" : value;
        } catch (Exception e) {
            EGFCoreUIPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, EGFCoreUIPlugin.getDefault().getPluginID(), e.getMessage(), e));
        }
        return "";
    }

}