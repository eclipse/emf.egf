/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.pattern.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * @author XiaoRu Chen - Soyatec
 */
public class ImageShop {
    // The plug-in ID
    public static final String PLUGIN_ID = "org.eclipse.egf.pattern.ui";

    private static final String ICON_PATH = "/icons/";

    public static final String IMG_PLUGIN_MF_OBJ = ICON_PATH + "plugin_mf_obj.gif";
    public static final String IMG_LOCALVARIABLE_OBJ = ICON_PATH + "localvariable_obj.gif";
    public static final String IMG_METHPUB_OBJ = ICON_PATH + "methpub_obj.gif";
    public static final String IMG_HELP = ICON_PATH + "help.gif";
    public static final String IMG_INNERCLASS_PUBLIC_OBJ = ICON_PATH + "innerclass_public_obj.gif";
    public static final String IMG_METHOD_OVERRIDE = ICON_PATH + "method_override.png";
    public static final String IMG_KIND_METODCALL_OBJ = ICON_PATH + "kind_metodCall_obj.gif";
    public static final String IMG_KIND_PATTERNCALL_OBJ = ICON_PATH + "kind_patternCall_obj.gif";
    public static final String IMG_KIND_PATTERNINJECTEDCALL_OBJ = ICON_PATH + "kind_patternInjectedCall_obj.gif";
    public static final String IMG_KIND_SUPERPATTERNCALL_OBJ = ICON_PATH + "kind_superPatternCall_obj.gif";
    public static final String IMG_OVER_OBJ = ICON_PATH + "over_obj.gif";
    public static final String IMG_CATEGORY_OBJ = ICON_PATH + "category_obj.gif";
    public static final String IMG_TREE_MODE = ICON_PATH + "tree_mode.gif";
    public static final String IMG_CLASS_OBJ = ICON_PATH + "class_obj.gif";
    public static final String IMG_ADD_OBJ = ICON_PATH + "add.gif";
    public static final String IMG_EDIT_OBJ = ICON_PATH + "edit.gif";
    public static final String IMG_DELETE_OBJ = ICON_PATH + "delete.gif";
    public static final String IMG_DOWNWARD_OBJ = ICON_PATH + "downward.gif";
    public static final String IMG_UPWARD_OBJ = ICON_PATH + "upward.gif";
    public static final String IMG_METHOD = ICON_PATH + "method.gif";
    public static final String IMG_METHOD_CONTENT_EDIT = ICON_PATH + "method_content_edit.gif";
    public static final String IMG_VARIABLE = ICON_PATH + "variable.gif";

    public static Image get(String imageFilePath) {
        ImageDescriptor imageDesc = getImageDescriptor(imageFilePath);
        if (imageDesc != null) {
            return imageDesc.createImage();
        }
        return getImageRegistry().get(imageFilePath);
    }

    public static ImageRegistry getImageRegistry() {
        return JFaceResources.getImageRegistry();
    }

    public static ImageDescriptor getImageDescriptor(String imageFilePath) {
        return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, imageFilePath);
    }
}
