package org.eclipse.egf.pattern.ui.editors.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.pattern.ui.editors.models.EcoreTypeStructure;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class EcoreTypeChooseContentProvider implements ITreeContentProvider {
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    public void dispose() {
    }

    public Object[] getElements(Object inputElement) {
        if (inputElement instanceof EcoreTypeStructure) {
            return getAllEObject(inputElement);
        }
        return null;
    }

    public boolean hasChildren(Object element) {
        if (element instanceof EList<?>) {
            return getChildren(element).length > 0;
        } else if (element instanceof EPackage) {
            return true;
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
        if (parentElement instanceof EList<?>) {
            Object[] array = ((EList<?>) parentElement).toArray();
            List<EObject> children = new ArrayList<EObject>();
            for (Object eObject : array) {
                if (eObject instanceof EPackage) {
                    EPackage aPackage = ((EPackage) eObject);
                    children.addAll(aPackage.getESubpackages());
                    children.addAll(aPackage.getEClassifiers());
                }
                return children.toArray(new EObject[0]);
            }
        } else if (parentElement instanceof EObject) {
            List<EObject> children = new ArrayList<EObject>();
            if (parentElement instanceof EPackage) {
                EPackage aPackage = ((EPackage) parentElement);
                children.addAll(aPackage.getESubpackages());
                children.addAll(aPackage.getEClassifiers());
            }
            return children.toArray(new EObject[0]);
        }
        return new Object[0];
    }

    private Object[] getAllEObject(Object inputElement) {
        Object[] resources = ((EcoreTypeStructure) inputElement).getResources().toArray();
        List<EList<?>> EObjectsList = new ArrayList<EList<?>>();
        for (int i = 0; i < resources.length; i++) {
            Resource resource = (Resource) resources[i];
            EObjectsList.add(resource.getContents());
        }

        return EObjectsList.toArray();
    }
}
