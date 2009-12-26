package org.eclipse.egf.pattern.ui.editors.providers;

import java.util.Vector;

import org.eclipse.egf.pattern.ui.editors.models.EcoreType;
import org.eclipse.egf.pattern.ui.editors.models.EcoreTypeStructure;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class EcoreTypeChooseContentProvider implements ITreeContentProvider {

    public Object[] getChildren(Object parentElement) {
        return ((EcoreType) parentElement).getUnderlings().toArray();
    }

    public Object getParent(Object element) {

        return ((EcoreType) element).getParent();
    }

    public boolean hasChildren(Object element) {
        Vector<?> underlings = ((EcoreType) element).getUnderlings();
        return !(underlings == null || underlings.size() == 0);
    }

    public Object[] getElements(Object inputElement) {
        if (inputElement instanceof EcoreTypeStructure)
            return new Object[] { ((EcoreTypeStructure) inputElement).getEcoreType()};
        return new Object[0];
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

}
