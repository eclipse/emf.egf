/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pde.plugin.command;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.pde.util.ExtensionHelper;
import org.eclipse.pde.core.plugin.IExtensions;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginParent;


/**
 * Base class to implement a command that performs plug-in changes in extension part.<br>
 * Changes can be an extension adding operation.
 * @author fournier
 */
public abstract class AbstractExtensionChangesCommand extends AbstractChangesCommand {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(AbstractExtensionChangesCommand.class.getPackage().getName());

  /**
   * Create extension for extension-point id returned by {@link #getExtensionPointId()}.
   * @return
   */
  protected IPluginExtension createExtension() {
    // Create a new extension matching extension-point id.
    return ExtensionHelper.createExtension(getExtensionPointId(), getPluginModelBase());
  }

  /**
   * Remove extension point according to the result of {@link #getExtensionPointId()}.
   */
  protected void removeExtension(String extensionChildIdValue_p) {
    ExtensionHelper.removePluginExtension(
      getExtensions(), 
      getExtensionPointId(), 
      getExtensionChildIdAttribute(), 
      extensionChildIdValue_p
    );
  }

  /**
   * Get the extension element for given parameters. Extension is created if not existing, depending on createIfMissing parameter.
   * @param elementName_p name of element to create.
   * @param createIfMissing_p true creates extension if missing; false otherwise.
   * @return a not array of {@link IPluginElement}.
   */
  protected IPluginElement[] getExtensionElementWithNodeName(String elementName_p, boolean createIfMissing_p) {
    List<IPluginElement> result = new ArrayList<IPluginElement>(0);
    // Get the portion of plug-in responsible for extensions and extension-points
    IExtensions extensionPart = getExtensions();
    String extensionPointId = getExtensionPointId();
    IPluginExtension[] extensions = ExtensionHelper.getPluginExtension(extensionPart, extensionPointId);
    // Check if extensions are already containing the searched element?
    // Loop over retrieved extensions to seek for plug-in elements with specified node name.
    for (IPluginExtension currentExtension : extensions) {
      // Retrieve contained element.
      for (IPluginElement pluginElement : ExtensionHelper.getPluginElement(currentExtension, elementName_p)) {
        result.add(pluginElement);
      }
    }
    // If the plug-in element is not found and creation is requested, create a new extension with its extension element.
    if (createIfMissing_p && result.isEmpty()) {
      // Extension doesn't exist yet, let's create it and create first element.
      result.add(ExtensionHelper.createPluginElement(createExtension(), elementName_p));
    }
    return result.toArray(new IPluginElement[result.size()]);
  }

  /**
   * Get a child for given id in extension matching {@link #getExtensionPointId()}, {@link #getExtensionChildName()} and
   * {@link #getExtensionChildIdAttribute()}.
   * @param elementIdValue_p
   * @return null if
   */
  protected IPluginElement getExtensionElementWithId(String elementIdValue_p) {
    IPluginElement result = null;
    // Get the portion of plug-in responsible for extensions and extension-points
    IExtensions extensionPart = getExtensions();
    // Get the extension point id.
    String extensionPointId = getExtensionPointId();
    // Get the extension.
    IPluginExtension[] pluginExtensions = ExtensionHelper.getPluginExtension(extensionPart, extensionPointId);
    // Check if an extension is already containing the searched element?
    if (pluginExtensions != null) {
      // Loop over retrieved extensions to seek for a plug-in element with specified id attribute and id value.
      for (int i = 0; i < pluginExtensions.length && result == null; i++) {
        // Retrieve contained element.
        IPluginElement extensionChild = ExtensionHelper.getPluginElement(
          pluginExtensions[i], 
          getExtensionChildIdAttribute(), 
          elementIdValue_p
        );
        if (extensionChild != null) {
          result = extensionChild;
        }
      }
    }
    // If the plug-in element is not found, create a new extension with its extension element.
    if (result == null) {
      // Extension doesn't exist yet, let's create it.
      IPluginExtension extension = createExtension();
      // Create the element.
      result = ExtensionHelper.createPluginElement(extension, getExtensionChildName());
      // Set it its id.
      try {
        result.setAttribute(getExtensionChildIdAttribute(), elementIdValue_p);
      } catch (CoreException exception_p) {
        StringBuilder loggerMessage = new StringBuilder("AbstractExtensionChangesCommand.getExtensionElementWithId(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p);

      }
    }
    return result;
  }

  /**
   * Get an extension element child for specified element id value. <br>
   * Both {@link #getExtensionChildName()}, {@link #getExtensionChildIdAttribute()} are used to perform the lookup.<br>
   * The extension that hosts the element (or the created one) is unique and is created if not existing at first call.
   * @param childElementId_p
   * @return
   */
  protected IPluginElement getExtensionElementFromUniqueExtension(String childElementId_p) {
    return getExtensionElementFromUniqueExtension(childElementId_p, true);
  }

  /**
   * Get an extension element child for specified element id value. <br>
   * Both {@link #getExtensionChildName()}, {@link #getExtensionChildIdAttribute()} are used to perform the lookup.<br>
   * The extension that hosts the element is unique.
   * @param childElementId_p
   * @return a {@link IPluginElement} instance or null if not found.
   */
  protected IPluginElement getExtensionElementFromUniqueExtension(String childElementId_p, boolean createIfMissing_p) {
    // Get the extension point id.
    String extensionPointId = getExtensionPointId();
    IPluginExtension[] extensions = getExtensions(extensionPointId);
    // Create the extension if not existing.
    IPluginExtension extension = null;
    if (extensions.length == 0) {
      if (createIfMissing_p) {
        extension = createExtension();
      }
    } else {
      extension = extensions[0];
    }
    // Get the extension element as a child of the extension.
    return getElement(extension, getExtensionChildName(), getExtensionChildIdAttribute(), childElementId_p, createIfMissing_p);
  }

  /**
   * Returns the extensions matching the given extension point id.
   * @param extensionPointId_p
   * @return
   */
  protected IPluginExtension[] getExtensions(String extensionPointId_p) {
    // Get the portion of plug-in responsible for extensions and extension-points and get the extension.
    return ExtensionHelper.getPluginExtension(getExtensions(), extensionPointId_p);
  }

  /**
   * Get an element for given parameters. Element is created if not existing, depending on createIfMissing parameter.
   * @param parent_p
   * @param elementChildNodeName_p
   * @param elementChildIdAttribute_p
   * @param elementChildIdAttributeValue_p
   * @param createIfMissing_p
   * @return an {@link IPluginElement} instance or null if not created and not found.
   */
  protected IPluginElement getElement(
    IPluginParent parent_p, 
    String elementChildNodeName_p, 
    String elementChildIdAttribute_p,
    String elementChildIdAttributeValue_p, 
    boolean createIfMissing_p
  ) {
    IPluginElement result = null;
    // Precondition
    if (parent_p == null) {
      return result;
    }
    // Try retrieving contained element.
    result = ExtensionHelper.getPluginElement(parent_p, elementChildIdAttribute_p, elementChildIdAttributeValue_p);
    // If not found and createIfMissing parameter is set, create it.
    if (result == null && createIfMissing_p) {
      result = ExtensionHelper.createPluginElement(parent_p, elementChildNodeName_p);
      try {
        result.setAttribute(elementChildIdAttribute_p, elementChildIdAttributeValue_p);
      } catch (CoreException exception_p) {
        StringBuilder loggerMessage = new StringBuilder("AbstractExtensionChangesCommand.getElement(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p);
      }
    }
    return result;
  }

  /**
   * Get {@link IExtensions} instance from plug-in object.
   * @return
   */
  protected IExtensions getExtensions() {
    IExtensions result = null;
    IPluginModelBase pluginModelBase = getPluginModelBase();
    if (pluginModelBase != null) {
      result = pluginModelBase.getExtensions();
    }
    return result;
  }

  /**
   * Get first extension element for given parameters.<br>
   * Extension-point id and extension element name are retrieved using {@link #getExtensionPointId()} and {@link #getExtensionChildName()}.
   * @return an {@link IPluginElement} instance or null if not found.
   */
  protected IPluginElement getFirstExtensionElement() {
    IPluginElement result = null;
    IPluginElement[] extensionElements = getExtensionElementWithNodeName(getExtensionChildName(), false);
    // Get the first available extension.
    if (extensionElements.length > 0) {
      result = extensionElements[0];
    }
    return result;
  }

  /**
   * Create an extension element child for given parameters.
   * @param extension_p the extension that hosts the created element child.
   * @param elementChildNodeName_p node name of the child element.
   * @param elementChildIdAttribute_p
   * @param elementChildIdAttributeValue_p
   * @return a child element as {@link IPluginElement}.
   */
  protected IPluginElement createExtensionElementChild(
    IPluginElement extension_p, 
    String elementChildNodeName_p, 
    String elementChildIdAttribute_p,
    String elementChildIdAttributeValue_p
  ) {
    // Check Preconditions.
    if (extension_p == null) {
      return null;
    }
    return getElement(extension_p, elementChildNodeName_p, elementChildIdAttribute_p, elementChildIdAttributeValue_p, true);
  }

  /**
   * Remove a child from its parent extension for given parameters.
   * @param elementChildIdAttribute_p
   * @param elementChildAttributeValue_p
   * @return true if the child is successfully removed; false otherwise.
   */
  protected boolean removeExtensionElementChild(
    IPluginElement extension_p, 
    String elementChildIdAttribute_p, 
    String elementChildAttributeValue_p
  ) {
    boolean result = false;
    // Get the parent elements.
    IPluginElement[] extensionElements = getExtensionElementWithNodeName(getExtensionChildName(), false);
    int matchingExtensionCount = extensionElements.length;
    if (extensionElements != null && matchingExtensionCount > 0) {
      // Loop over potential extensions where the element can be located as a child.
      for (int i = 0; i < matchingExtensionCount && !result; i++) {
        // Remove the child element.
        result = ExtensionHelper.removePluginElement(extensionElements[i], elementChildIdAttribute_p, elementChildAttributeValue_p);
      }
    }
    return result;
  }

  /**
   * Set a single child in a parent element.
   * @param parentElement_p
   * @param childNodeName_p
   * @param childIdAttribute_p
   * @param childIdAttributeValue_p
   */
  protected IPluginElement setSingleChild(
    IPluginParent parentElement_p, 
    String childNodeName_p, 
    String childIdAttribute_p, 
    String childIdAttributeValue_p
  ) {
    // Get element with 'createIfMissing' set to true in order to do the job.
    return getElement(parentElement_p, childNodeName_p, childIdAttribute_p, childIdAttributeValue_p, true);
  }

  /**
   * Set the description node.
   * @param parentElement_p
   * @throws CoreException
   */
  protected void setDescription(IPluginElement parentElement_p, String idAttributeValue_p, String description_p) throws CoreException {
    // Get the description child for given parent element.
    // Its id is the given one appended with ".description".
    String idAttributeName = getExtensionChildIdAttribute();
    String idAttributeValue = idAttributeValue_p + ".description"; //$NON-NLS-1$
    if (description_p != null) {
      IPluginElement descriptionElement = getElement(
        parentElement_p, 
        ExtensionPointHelper.ELEMENT_DESCRIPTION, 
        idAttributeName, 
        idAttributeValue, 
        true
      );
      descriptionElement.setText(description_p);
      // Override existing id value to force the setText to be persisted (bug PDE).
      descriptionElement.setAttribute(idAttributeName, idAttributeValue);
    }
  }

  /**
   * Get the extension point id.
   * @return
   */
  protected abstract String getExtensionPointId();

  /**
   * Get the node name of the children for the extension.
   * @return
   */
  protected abstract String getExtensionChildName();

  /**
   * Get the id attribute of the children for the extension.
   * @return
   */
  protected String getExtensionChildIdAttribute() {
    return ExtensionPointHelper.ATT_ID;
  }
  
}
