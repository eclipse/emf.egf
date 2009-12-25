/*******************************************************************************
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 * Ferenc Hechler, ferenc_hechler@users.sourceforge.net - 83258 [jar exporter]
 * Deploy java application as executable jar
 *******************************************************************************/
package org.eclipse.egf.editor.internal.ui;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.model.editor.EGFModelsEditorPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.osgi.framework.Bundle;

/**
 * Bundle of most images used by the EGF Model Editor plug-in.
 */
public class EGFModelsEditorImages {

  public static final IPath ICONS_PATH = new Path("$nl$/icons/full"); //$NON-NLS-1$

  private static final String T_ELCL = "elcl16"; //$NON-NLS-1$

  /*
   * Set of predefined Image Descriptors.
   */
  public static final ImageDescriptor EGF_RUN_ACTIVITY = createUnManaged(T_ELCL, "runactivity.gif"); //$NON-NLS-1$

  /*
   * Creates an image descriptor for the given prefix and name in the EGF Model
   * Editor
   * bundle. The path can
   * contain variables like $NL$.
   * If no image could be found, <code>useMissingImageDescriptor</code> decides
   * if either
   * the 'missing image descriptor' is returned or <code>null</code>.
   * or <code>null</code>.
   */
  private static ImageDescriptor create(String prefix, String name, boolean useMissingImageDescriptor) {
    IPath path = ICONS_PATH.append(prefix).append(name);
    return createImageDescriptor(EGFModelsEditorPlugin.getPlugin().getBundle(), path, useMissingImageDescriptor);
  }

  /*
   * Creates an image descriptor for the given prefix and name in the JDT UI
   * bundle. The path can
   * contain variables like $NL$.
   * If no image could be found, the 'missing image descriptor' is returned.
   */
  private static ImageDescriptor createUnManaged(String prefix, String name) {
    return create(prefix, name, true);
  }

  /*
   * Creates an image descriptor for the given path in a bundle. The path can
   * contain variables
   * like $NL$.
   * If no image could be found, <code>useMissingImageDescriptor</code> decides
   * if either
   * the 'missing image descriptor' is returned or <code>null</code>.
   * Added for 3.1.1.
   */
  public static ImageDescriptor createImageDescriptor(Bundle bundle, IPath path, boolean useMissingImageDescriptor) {
    URL url = FileLocator.find(bundle, path, null);
    if (url != null) {
      return ImageDescriptor.createFromURL(url);
    }
    if (useMissingImageDescriptor) {
      return ImageDescriptor.getMissingImageDescriptor();
    }
    return null;
  }
}
