/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.pde.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.pde.core.plugin.IExtensions;
import org.eclipse.pde.core.plugin.IExtensionsModelFactory;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginModelFactory;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.core.plugin.IPluginParent;

/**
 * Provides helpful methods to deal with Extension used in plug-in file.
 * 
 * @author fournier
 */
public class ExtensionHelper {

  /**
   * Create a new extension into given plug-in model object.
   * 
   * @param pluginModelBase
   * @param extensionPointId
   *          the fully qualified extension-point id.
   * @return an {@link IPluginExtension} instance or null if a creation error
   *         occurs.
   */
  public static IPluginExtension createExtension(IPluginModelBase pluginModelBase, String extensionPointId) throws CoreException {
    IPluginExtension extension = null;
    // Get the factory.
    IPluginModelFactory pluginModelFactory = pluginModelBase.getPluginFactory();
    if (pluginModelFactory == null) {
      return null;
    }
    // Create an extension.
    extension = pluginModelFactory.createExtension();
    if (extension == null) {
      return null;
    }
    // Set the matching extension point.
    extension.setPoint(extensionPointId);
    // Add it to the plug-in extensions container.
    pluginModelBase.getExtensions().add(extension);
    // Return extension
    return extension;
  }

  /**
   * Create a plug-in element and add it into parent.
   * 
   * @param parent
   * @return an {@link IPluginElement} instance or null if a creation error
   *         occurs.
   */
  public static IPluginElement createPluginElement(IPluginParent parent, String name) throws CoreException {
    if (parent == null) {
      return null;
    }
    IPluginElement element = null;
    // Get the factory.
    IExtensionsModelFactory factory = parent.getModel().getFactory();
    if (factory == null) {
      return null;
    }
    element = factory.createElement(parent);
    if (element == null) {
      return null;
    }
    // Set element name.
    element.setName(name);
    // Add it to the extension content.
    parent.add(element);
    // Return element
    return element;
  }

  /**
   * Get a list of {@link IPluginExtension} matching given extension-point id.
   * 
   * @param extensions
   *          extension part where is stored all extensions and
   *          extension-points.
   * @param fullyQualifiedExtensionPointId
   *          fully qualified extension-point id (with the id of plug-in that
   *          hosts that one.)
   * @return a not null array of {@link IPluginExtension}.
   */
  public static IPluginExtension[] getPluginExtension(IExtensions extensions, String fullyQualifiedExtensionPointId) {
    List<IPluginExtension> result = new ArrayList<IPluginExtension>();
    // Check Preconditions
    if (fullyQualifiedExtensionPointId == null || extensions == null) {
      return result.toArray(new IPluginExtension[0]);
    }
    // Get all defined extensions.
    for (IPluginExtension pluginExtension : extensions.getExtensions()) {
      // Look up for the one related to given point id.
      if (fullyQualifiedExtensionPointId.equals(pluginExtension.getPoint())) {
        result.add(pluginExtension);
      }
    }
    return result.toArray(new IPluginExtension[result.size()]);
  }

  /**
   * Get the {@link IPluginElement} instances for given parameters.<br>
   * The research looks up for children with a name equals to
   * <code>nodeName_p</code>.
   * 
   * @param parent
   * @param element
   * @return a not null array of {@link IPluginElement}.
   */
  public static IPluginElement[] getPluginElement(IPluginParent parent, String element) {
    List<IPluginElement> result = new ArrayList<IPluginElement>(0);
    // Check Preconditions.
    if (element == null || parent == null) {
      return result.toArray(new IPluginElement[0]);
    }
    // Loop over children to find the ones with specified node name.
    for (IPluginObject pluginObject : parent.getChildren()) {
      if (pluginObject instanceof IPluginElement == false) {
        continue;
      }
      IPluginElement pluginElement = (IPluginElement) pluginObject;
      if (element.equals(pluginElement.getName())) {
        result.add(pluginElement);
      }
    }
    return result.toArray(new IPluginElement[result.size()]);
  }

}
