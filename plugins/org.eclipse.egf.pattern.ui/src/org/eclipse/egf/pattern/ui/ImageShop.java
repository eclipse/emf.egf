/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * XiaoRu Chen, Soyatec
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * @author XiaoRu Chen - Soyatec
 */
public class ImageShop {

  // The plug-in ID
  public static final String PLUGIN_ID = "org.eclipse.egf.pattern.ui"; //$NON-NLS-1$

  private static final String ICON_PATH = "/icons/"; //$NON-NLS-1$

  public static final String IMG_PLUGIN_MF_OBJ = ICON_PATH + "plugin_mf_obj.gif"; //$NON-NLS-1$

  public static final String IMG_LOCALVARIABLE_OBJ = ICON_PATH + "localvariable_obj.gif"; //$NON-NLS-1$

  public static final String IMG_METHPUB_OBJ = ICON_PATH + "methpub_obj.gif"; //$NON-NLS-1$

  public static final String IMG_HELP = ICON_PATH + "help.gif"; //$NON-NLS-1$

  public static final String IMG_INNERCLASS_PUBLIC_OBJ = ICON_PATH + "innerclass_public_obj.gif"; //$NON-NLS-1$

  public static final String IMG_METHOD_OVERRIDE = ICON_PATH + "method_override.png"; //$NON-NLS-1$

  public static final String IMG_KIND_METHODCALL = ICON_PATH + "kind_methodCall.gif"; //$NON-NLS-1$

  public static final String IMG_KIND_PATTERNCALL = ICON_PATH + "kind_patternCall.gif"; //$NON-NLS-1$

  public static final String IMG_KIND_PATTERNINJECTEDCALL = ICON_PATH + "kind_patternInjectedCall.gif"; //$NON-NLS-1$

  public static final String IMG_KIND_BACKCALL = ICON_PATH + "kind_backCall.gif"; //$NON-NLS-1$

  public static final String IMG_KIND_SUPERPATTERNCALL = ICON_PATH + "kind_superPatternCall.gif"; //$NON-NLS-1$

  public static final String IMG_OVER_OBJ = ICON_PATH + "over_obj.gif"; //$NON-NLS-1$

  public static final String IMG_CATEGORY_OBJ = ICON_PATH + "category_obj.gif"; //$NON-NLS-1$

  public static final String IMG_TREE_MODE = ICON_PATH + "tree_mode.gif"; //$NON-NLS-1$

  public static final String IMG_CLASS_OBJ = ICON_PATH + "class_obj.gif"; //$NON-NLS-1$

  public static final String IMG_ADD_OBJ = ICON_PATH + "add.gif"; //$NON-NLS-1$

  public static final String IMG_EDIT_OBJ = ICON_PATH + "edit.gif"; //$NON-NLS-1$

  public static final String IMG_DELETE_OBJ = ICON_PATH + "delete.gif"; //$NON-NLS-1$

  public static final String IMG_DOWNWARD_OBJ = ICON_PATH + "downward.gif"; //$NON-NLS-1$

  public static final String IMG_UPWARD_OBJ = ICON_PATH + "upward.gif"; //$NON-NLS-1$

  public static final String IMG_METHOD = ICON_PATH + "method.gif"; //$NON-NLS-1$

  public static final String IMG_METHOD_CONTENT_EDIT = ICON_PATH + "method_content_edit.gif"; //$NON-NLS-1$

  public static final String IMG_VARIABLE = ICON_PATH + "variable.gif"; //$NON-NLS-1$

  public static final String IMG_QUERY_SET = ICON_PATH + "query_set.gif"; //$NON-NLS-1$

  public static final String IMG_PARAMETER_OBJ = ICON_PATH + "parameter_obj.gif"; //$NON-NLS-1$

  public static final String IMG_VARIABLE_OBJ = ICON_PATH + "variable_obj.gif"; //$NON-NLS-1$

  private static final ImageRegistry REGISTRY = new ImageRegistry();

  public static Image get(String imageFilePath) {
    Image image = REGISTRY.get(imageFilePath);
    if (image != null) {
      return image;
    }
    ImageDescriptor descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, imageFilePath);
    image = descriptor.createImage();
    REGISTRY.put(imageFilePath, image);
    return image;
  }
}
