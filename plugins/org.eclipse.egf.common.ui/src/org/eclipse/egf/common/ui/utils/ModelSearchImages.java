/**
 * Copyright (c) 2007-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.ui.utils;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.ui.EGFCommonUIPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ModelSearchImages {

  public final static String ICONS_PATH = "icons/full/"; //$NON-NLS-1$

  public final static String ECORE_IMAGE_PATH = ICONS_PATH + "elcl16/Ecore.gif"; //$NON-NLS-1$

  private static ImageDescriptor ECORE_IMAGE = null;

  public final static String ECLASS_HIERARCHY_IMAGE_PATH = ICONS_PATH + "elcl16/EClassHierarchy.gif"; //$NON-NLS-1$

  private static ImageDescriptor ECLASS_HIERARCHY_IMAGE = null;

  public final static String ASCENDANT_HIERARCHY_IMAGE_PATH = ICONS_PATH + "elcl16/AscendantHierarchy.gif"; //$NON-NLS-1$

  private static ImageDescriptor ASCENDANT_HIERARCHY_IMAGE = null;

  public final static String DESCENDANT_HIERARCHY_IMAGE_PATH = ICONS_PATH + "elcl16/DescendantHierarchy.gif"; //$NON-NLS-1$

  private static ImageDescriptor DESCENDANT_HIERARCHY_IMAGE = null;

  public final static String EREFERENCE_IMAGE_PATH = ICONS_PATH + "elcl16/EReference.gif"; //$NON-NLS-1$

  private static ImageDescriptor EREFERENCE_IMAGE = null;

  public final static String SYNCHRONIZE_IMAGE_PATH = ICONS_PATH + "elcl16/Synchronize.gif"; //$NON-NLS-1$

  private static ImageDescriptor SYNCHRONIZE_IMAGE = null;

  public final static String REFRESH_IMAGE_PATH = ICONS_PATH + "elcl16/Refresh.gif"; //$NON-NLS-1$

  private static ImageDescriptor REFRESH_IMAGE = null;

  public final static String ENABLED_COPY_QUALIFIED_IMAGE_PATH = ICONS_PATH + "elcl16/cpyqual_menu.gif"; //$NON-NLS-1$

  private static ImageDescriptor ENABLED_COPY_QUALIFIED_IMAGE = null;

  public final static String DISABLED_COPY_QUALIFIED_IMAGE_PATH = ICONS_PATH + "dlcl16/cpyqual_menu.gif"; //$NON-NLS-1$

  private static ImageDescriptor DISABLED_COPY_QUALIFIED_IMAGE = null;

  public static ImageDescriptor getImageDescriptor(String imagePath) {
    ImageDescriptor desc = ImageDescriptor.getMissingImageDescriptor();
    Bundle bundle = Platform.getBundle(EGFCommonUIPlugin.getDefault().getBundle().getSymbolicName());
    URL url = null;
    if (bundle != null) {
      url = FileLocator.find(bundle, new Path(imagePath), null);
      desc = ImageDescriptor.createFromURL(url);
    }
    return desc;
  }

  public static ImageDescriptor getImageDescriptor(Bundle bundle, String imagePath) {
    ImageDescriptor desc = ImageDescriptor.getMissingImageDescriptor();
    URL url = null;
    if (bundle != null) {
      url = FileLocator.find(bundle, new Path(imagePath), null);
      desc = ImageDescriptor.createFromURL(url);
    }
    return desc;
  }

  public static ImageDescriptor getEcoreImage() {
    return ECORE_IMAGE == null ? ECORE_IMAGE = getImageDescriptor(ECORE_IMAGE_PATH) : ECORE_IMAGE;
  }

  public static ImageDescriptor getEClassHierarchyImage() {
    return ECLASS_HIERARCHY_IMAGE == null ? ECLASS_HIERARCHY_IMAGE = getImageDescriptor(ECLASS_HIERARCHY_IMAGE_PATH) : ECLASS_HIERARCHY_IMAGE;
  }

  public static ImageDescriptor getAscendantHierarchyImage() {
    return ASCENDANT_HIERARCHY_IMAGE == null ? ASCENDANT_HIERARCHY_IMAGE = getImageDescriptor(ASCENDANT_HIERARCHY_IMAGE_PATH) : ASCENDANT_HIERARCHY_IMAGE;
  }

  public static ImageDescriptor getDescendantHierarchyImage() {
    return DESCENDANT_HIERARCHY_IMAGE == null ? DESCENDANT_HIERARCHY_IMAGE = getImageDescriptor(DESCENDANT_HIERARCHY_IMAGE_PATH) : DESCENDANT_HIERARCHY_IMAGE;
  }

  public static ImageDescriptor getEReferenceImage() {
    return EREFERENCE_IMAGE == null ? EREFERENCE_IMAGE = getImageDescriptor(EREFERENCE_IMAGE_PATH) : EREFERENCE_IMAGE;
  }

  public static ImageDescriptor getSynchronizeImage() {
    return SYNCHRONIZE_IMAGE == null ? SYNCHRONIZE_IMAGE = getImageDescriptor(SYNCHRONIZE_IMAGE_PATH) : SYNCHRONIZE_IMAGE;
  }

  public static ImageDescriptor getRefreshImage() {
    return REFRESH_IMAGE == null ? REFRESH_IMAGE = getImageDescriptor(REFRESH_IMAGE_PATH) : REFRESH_IMAGE;
  }

  public static ImageDescriptor getEnabledCopyQualifiedImage() {
    return ENABLED_COPY_QUALIFIED_IMAGE == null ? ENABLED_COPY_QUALIFIED_IMAGE = getImageDescriptor(ENABLED_COPY_QUALIFIED_IMAGE_PATH) : ENABLED_COPY_QUALIFIED_IMAGE;
  }

  public static ImageDescriptor getDisabledCopyQualifiedImage() {
    return DISABLED_COPY_QUALIFIED_IMAGE == null ? DISABLED_COPY_QUALIFIED_IMAGE = getImageDescriptor(DISABLED_COPY_QUALIFIED_IMAGE_PATH) : DISABLED_COPY_QUALIFIED_IMAGE;
  }

}