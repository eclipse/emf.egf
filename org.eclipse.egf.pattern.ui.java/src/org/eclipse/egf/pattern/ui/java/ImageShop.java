/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.java;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * @author XiaoRu Chen - Soyatec
 */
public class ImageShop {
    // The plug-in ID
    public static final String PLUGIN_ID = "org.eclipse.egf.pattern.ui.java";

    private static final String ICON_PATH = "/icons/";

    public static final String IMG_PARAMETER_OBJ = ICON_PATH + "parameter_obj.gif";

    private static final ImageRegistry REGISTRY = new ImageRegistry();

    public static Image get(String imageFilePath) {
        Image image = REGISTRY.get(imageFilePath);
        if (image != null)
            return image;
        ImageDescriptor descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, imageFilePath);
        image = descriptor.createImage();
        REGISTRY.put(imageFilePath, image);
        return image;
    }
}
