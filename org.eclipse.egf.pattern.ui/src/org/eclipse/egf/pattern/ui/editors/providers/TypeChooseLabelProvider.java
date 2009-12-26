package org.eclipse.egf.pattern.ui.editors.providers;

import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

public class TypeChooseLabelProvider implements ITableLabelProvider {

    public Image getColumnImage(Object element, int columnIndex) {
        if (element instanceof EList<?>) {
            EList<?> elementList = (EList<?>) element;
            if (elementList.size() > 0) {
                Object parent = (elementList).get(0);
                if (parent instanceof EPackage)
                    return ImageShop.get(ImageShop.IMG_TREE_MODE);
            }else{
                return null;
            }
        } else if (element instanceof EPackage) {
            return ImageShop.get(ImageShop.IMG_TREE_MODE);
        }
        return ImageShop.get(ImageShop.IMG_CATEGORY_OBJ);
    }

    public String getColumnText(Object element, int columnIndex) {
        if (element instanceof ENamedElement) {
            ENamedElement eNamedElement = (ENamedElement) element;
            EClass eClass = eNamedElement.eClass();
            String name = eClass.getName();
            return eNamedElement.getName() + " - [" + name + "]";
        } else if (element instanceof EList<?>) {
            EList<?> elementList = (EList<?>) element;
            if (elementList.size() > 0) {
                Object parent = elementList.get(0);
                if (parent instanceof EPackage)
                    return ((EPackage) parent).getName();
            }else{
                return "NULL";
            }
        }
        return "";
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
