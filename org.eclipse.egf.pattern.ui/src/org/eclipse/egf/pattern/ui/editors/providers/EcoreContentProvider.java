package org.eclipse.egf.pattern.ui.editors.providers;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class EcoreContentProvider implements ITreeContentProvider {
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    public void dispose() {
    }

    public Object[] getElements(Object inputElement) {
        return getChildren(inputElement);
    }

    public boolean hasChildren(Object element) {
        return getChildren(element).length > 0;
    }

    public Object getParent(Object element) {
        if (element instanceof EObject) {
            return ((EObject) element).eContainer();
        }
        return null;
    }

    public Object[] getChildren(Object parentElement) {
        if (parentElement instanceof Resource) {
            Resource res = (Resource) parentElement;
            return res.getContents().toArray();
        }
        if (parentElement instanceof List<?>)
            return ((List<?>) parentElement).toArray();
        if (parentElement instanceof EPackage) {
            EPackage ePack = (EPackage) parentElement;
            return ePack.getEClassifiers().toArray();
        }
        return new Object[0];
    }
}
