package org.eclipse.egf.pattern.ui.editors.providers;

import org.eclipse.egf.pattern.ui.editors.models.EcoreType;
import org.eclipse.egf.pattern.ui.editors.models.EcoreTypeStructure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class EcoreTypeChooseContentProvider implements ITreeContentProvider {
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    public void dispose() {
    }

    public Object[] getElements(Object inputElement) {
        if (inputElement instanceof EcoreTypeStructure) {
            return ((EcoreTypeStructure) inputElement).getEcoreTypes().toArray();
        }
        return null;
    }

    public boolean hasChildren(Object element) {
        if (element instanceof EcoreType) {
            return ((EcoreType)element).getUnderlings().size() > 0;
        }
        return false;
    }

    public Object getParent(Object element) {
        if (element instanceof EObject) {
            return ((EObject) element).eContainer();
        }
        return null;
    }

    public Object[] getChildren(Object parentElement) {
        if (parentElement instanceof EcoreType) {
            return ((EcoreType)parentElement).getUnderlings().toArray();
        } 
        return new Object[0];
    }
}
