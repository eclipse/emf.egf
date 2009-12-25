/*******************************************************************************
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.pde.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.uri.URIHelper;
import org.eclipse.egf.core.pde.EGFPDEPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.pde.core.plugin.IExtensions;
import org.eclipse.pde.core.plugin.IExtensionsModelFactory;
import org.eclipse.pde.core.plugin.IPluginAttribute;
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
   * @param pluginModelBase_p
   * @param extensionPointId_p
   *          the fully qualified extension-point id.
   * @return an {@link IPluginExtension} instance or null if a creation error
   *         occurs.
   */
  public static IPluginExtension createExtension(IPluginModelBase pluginModelBase_p, String extensionPointId_p) {
    IPluginExtension extension = null;
    // Get the factory.
    IPluginModelFactory pluginModelFactory = pluginModelBase_p.getPluginFactory();
    if (pluginModelFactory != null) {
      // Create an extension.
      extension = pluginModelFactory.createExtension();
      try {
        // Set the matching extension point.
        extension.setPoint(extensionPointId_p);
        // Add it to the plug-in extensions container.
        pluginModelBase_p.getExtensions().add(extension);
      } catch (CoreException ce) {
        EGFPDEPlugin.getDefault().logError(new String("ExtensionHelper.createExtension(..) _"), ce); //$NON-NLS-1$
        // Reset to null the result to force the caller to debug where is the
        // bug.
        extension = null;
      }
    }
    return extension;
  }

  /**
   * Create a plug-in element and add it into parent.
   * 
   * @param parent_p
   * @return an {@link IPluginElement} instance or null if a creation error
   *         occurs.
   */
  public static IPluginElement createPluginElement(IPluginParent parent_p, String name_p) {
    if (parent_p == null) {
      return null;
    }
    IPluginElement element = null;
    // Get the factory.
    IExtensionsModelFactory factory = parent_p.getModel().getFactory();
    if (factory != null) {
      element = factory.createElement(parent_p);
      try {
        // Set element name.
        element.setName(name_p);
        // Add it to the extension content.
        parent_p.add(element);
      } catch (CoreException ce) {
        EGFPDEPlugin.getDefault().logError(new String("ExtensionHelper.createPluginElement(..) _"), ce); //$NON-NLS-1$
        // Reset to null the result to force the caller to debug where is the
        // bug.
        element = null;
      }
    }
    return element;
  }

  /**
   * Get a list of {@link IPluginExtension} matching given extension-point id.
   * 
   * @param extensionPart_p
   *          extension part where is stored all extensions and
   *          extension-points.
   * @param fullyQualifiedExtensionPointId_p
   *          fully qualified extension-point id (with the id of plug-in that
   *          hosts that one.)
   * @return a not null array of {@link IPluginExtension}.
   */
  public static IPluginExtension[] getPluginExtension(IExtensions extensionPart_p, String fullyQualifiedExtensionPointId_p) {
    List<IPluginExtension> result = new ArrayList<IPluginExtension>(0);
    // Check Preconditions
    if (fullyQualifiedExtensionPointId_p == null || extensionPart_p == null) {
      return result.toArray(new IPluginExtension[0]);
    }
    // Get all defined extensions.
    IPluginExtension[] extensions = extensionPart_p.getExtensions();
    for (int i = 0; i < extensions.length; i++) {
      IPluginExtension currentExtension = extensions[i];
      // Look up for the one related to given point id.
      if (fullyQualifiedExtensionPointId_p.equals(currentExtension.getPoint())) {
        result.add(currentExtension);
      }
    }
    return result.toArray(new IPluginExtension[result.size()]);
  }

  /**
   * Remove an {@link IPluginExtension} from an {@link IExtensions} object for
   * given extension-point id.
   * 
   * @param extensionPart_p
   * @param extensionPointId_p
   *          the fully qualified extension-point id.
   */
  public static boolean removePluginExtension(IExtensions extensionPart_p, String extensionPointId_p, String elementId_p, Object elementIdValue_p) {
    boolean result = false;
    // Retrieve the extension.
    IPluginExtension[] matchingExtensions = getPluginExtension(extensionPart_p, extensionPointId_p);
    for (IPluginExtension currentExtension : matchingExtensions) {
      // Remove the element from the retrieved extension
      result = removePluginElement(currentExtension, elementId_p, elementIdValue_p);
      // Is the element found and hence removed ?
      if (result) {
        int childCount = currentExtension.getChildCount();
        try {
          if (childCount == 0) {
            // Remove it.
            extensionPart_p.remove(currentExtension);
          }
        } catch (CoreException ce) {
          EGFPDEPlugin.getDefault().logError(new String("ExtensionHelper.removePluginExtension(..) _"), ce); //$NON-NLS-1$
        }
        // Specified element was successfully removed, stop the loop.
        break;
      }
    }
    return result;
  }

  /**
   * Get an {@link IPluginElement} instance for given parameters.<br>
   * The research looks up for a child with an attribute equals to attributeId_p
   * and its value set to <code>attributeIdValue_p</code>.
   * 
   * @param parent_p
   * @param attributeId_p
   *          .
   * @param uri_p
   * @return a {@link IPluginElement} instance or null if not found.
   */
  public static IPluginElement getPluginElement(IPluginParent parent_p, String attributeId_p, Object elementIdValue_p) {
    IPluginElement result = null;
    // Check Preconditions
    if (elementIdValue_p == null || parent_p == null) {
      return result;
    }
    // Get all children of given parent.
    IPluginObject[] children = parent_p.getChildren();
    for (int i = 0; i < children.length && result == null; i++) {
      IPluginObject object = children[i];
      if (object instanceof IPluginElement) {
        // Locate value
        IPluginElement child = (IPluginElement) object;
        String elementIdValue = null;
        if (attributeId_p == null) {
          elementIdValue = child.getName();
        } else {
          // Look up for the one related to given element name.
          IPluginAttribute attribute = child.getAttribute(attributeId_p);
          if (attribute != null) {
            elementIdValue = attribute.getValue();
          }
        }
        // analysis
        if (elementIdValue != null) {
          if (elementIdValue_p instanceof URI) {
            if (elementIdValue_p.equals(URIHelper.getPlatformURI(parent_p.getPluginModel(), elementIdValue))) {
              result = child;
            }
          } else if (elementIdValue_p.equals(elementIdValue)) {
            result = child;
          }
        }
      }
    }
    return result;
  }

  /**
   * Get the {@link IPluginElement} instances for given parameters.<br>
   * The research looks up for children with a name equals to
   * <code>nodeName_p</code>.
   * 
   * @param parent_p
   * @param nodeName_p
   * @return a not null array of {@link IPluginElement}.
   */
  public static IPluginElement[] getPluginElement(IPluginParent parent_p, String nodeName_p) {
    List<IPluginElement> result = new ArrayList<IPluginElement>(0);
    // Check Preconditions.
    if (nodeName_p == null || parent_p == null) {
      return result.toArray(new IPluginElement[0]);
    }
    // Get all children for given parent.
    IPluginObject[] children = parent_p.getChildren();
    // Loop over children to find the ones with specified node name.
    for (int i = 0; i < children.length; i++) {
      IPluginObject object = children[i];
      if (object instanceof IPluginElement) {
        IPluginElement element = (IPluginElement) object;
        if (nodeName_p.equals(element.getName())) {
          result.add(element);
        }
      }
    }
    return result.toArray(new IPluginElement[result.size()]);
  }

  /**
   * Remove an {@link IPluginElement} element from an IPluginParent for given
   * parameters.<br>
   * If elementId_p is provided (ie not null), the research looks up for a child
   * with a name equals to value_p.<br>
   * Otherwise, the research looks up for a child with an attribute equals to
   * attributeId_p and its value set to value_p.
   * 
   * @param parent_p
   * @param elementId_p
   * @param elementIdValue_p
   * @return true if the element is successfully removed; false otherwise.
   */
  public static boolean removePluginElement(IPluginParent parent_p, String elementId_p, Object elementIdValue_p) {
    boolean result = false;
    // Check Preconditions
    if (elementIdValue_p == null || parent_p == null) {
      return result;
    }
    // Retrieve the plug-in element.
    IPluginElement pluginElement = getPluginElement(parent_p, elementId_p, elementIdValue_p);
    try {
      // Remove it.
      if (pluginElement != null) {
        parent_p.remove(pluginElement);
        result = true;
      }
    } catch (CoreException ce) {
      EGFPDEPlugin.getDefault().logError(new String("ExtensionHelper.removePluginElement(..) _"), ce); //$NON-NLS-1$
    }
    return result;
  }

}
