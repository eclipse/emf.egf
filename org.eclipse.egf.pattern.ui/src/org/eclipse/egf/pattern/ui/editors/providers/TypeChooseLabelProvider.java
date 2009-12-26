package org.eclipse.egf.pattern.ui.editors.providers;

import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.editors.models.EcoreType;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

public class TypeChooseLabelProvider implements ITableLabelProvider {

    public Image getColumnImage(Object element, int columnIndex) {
        if (element instanceof EcoreType) {
            EcoreType ecoreType = (EcoreType) element;
            if (ecoreType.getUnderlings().size() > 0) {
                 return ImageShop.get(ImageShop.IMG_TREE_MODE);
            }else{
                return ImageShop.get(ImageShop.IMG_CATEGORY_OBJ);
            }
        } 
        return null;
    }

    public String getColumnText(Object element, int columnIndex) {
        if (element instanceof EcoreType) {
            return ((EcoreType)element).getTypeName();
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
