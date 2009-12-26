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
/**
 * 
 */
package org.eclipse.egf.common.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.EGFCommonPlugin;
import org.eclipse.egf.common.constant.CharacterConstants;
import org.eclipse.osgi.util.NLS;

/**
 * @author fournier
 */
public class ExtensionPointHelper {

  private ExtensionPointHelper() {
    // Prevent Instantiation
  }

  /**
   * Define a constant for the attribute named <code>class</code> in
   * ExtensionPoint tab of plug-in xml files.
   */
  public static final String ATT_CLASS = "class"; //$NON-NLS-1$

  /**
   * Define a constant for the attribute named <code>name</code> in
   * ExtensionPoint tab of plug-in xml files.
   */
  public static final String ATT_NAME = "name"; //$NON-NLS-1$

  /**
   * Define a constant for the attribute named <code>id</code> in ExtensionPoint
   * tab of plug-in xml files.
   */
  public static final String ATT_ID = "id"; //$NON-NLS-1$

  /**
   * Define a constant for the element named <code>description</code> in
   * ExtensionPoint tab of plug-in xml files.
   */
  public static final String ELEMENT_DESCRIPTION = "description"; //$NON-NLS-1$

  /**
   * Get the configuration elements for a specified plugin id & extension point
   * id.
   * 
   * @param pluginId
   *          the identifier of the plugin.
   * @param extensionPointId
   *          the simple identifier of the extension point.
   * @return an array of {@link IConfigurationElement} or an empty array if the
   *         extension point does not exist,has no extensions configured, or
   *         none of the extensions contain configuration elements.
   */
  public static IConfigurationElement[] getConfigurationElements(String pluginId, String extensionPointId) {
    return Platform.getExtensionRegistry().getConfigurationElementsFor(pluginId, extensionPointId);
  }

  /**
   * Get the extensions for identified plug-in extension point coming from an
   * identified plug-in.
   * 
   * @param pluginId
   *          The identifier of the plug-in declaring the extension point.
   * @param extensionPointId
   *          The extension point id.
   * @param extensionDeclaringPluginId
   *          The identifier of the plug-in potentially declaring extensions for
   *          this extension point.
   * @return an array of {@link IConfigurationElement}. Empty if no extension
   *         could be found with given criteria.
   */
  public static IConfigurationElement[] getConfigurationElements(String pluginId, String extensionPointId, String extensionDeclaringPluginId) {
    List<IConfigurationElement> resultingElements = new ArrayList<IConfigurationElement>();
    IConfigurationElement[] allElements = getConfigurationElements(pluginId, extensionPointId);
    for (IConfigurationElement configurationElement : allElements) {
      if (isDeclaredBy(configurationElement, extensionDeclaringPluginId)) {
        resultingElements.add(configurationElement);
      }
    }
    return resultingElements.toArray(new IConfigurationElement[resultingElements.size()]);
  }

  /**
   * Is given configuration element declared by identified plug-in ?<br>
   * That is, is it read from the plugin.xml coming with identified plug-in ?
   * 
   * @param configurationElement
   * @param pluginId
   * @return
   */
  public static boolean isDeclaredBy(IConfigurationElement configurationElement, String pluginId) {
    return configurationElement != null && pluginId != null && pluginId.equals(configurationElement.getContributor().getName());
  }

  /**
   * Get the configuration element for specified parameters.
   * 
   * @param pluginId
   *          the identifier of the plugin.
   * @param extensionId
   *          the short identifier of the extension point.
   * @param idValue
   *          the value of the 'id' attribute declared into the extension point.
   * @return a {@link IConfigurationElement} instance or null if the specified
   *         extension is not found.
   */
  public static IConfigurationElement getConfigurationElement(String pluginId, String extensionId, String idValue) {
    return getConfigurationElement(pluginId, extensionId, ATT_ID, idValue);
  }

  /**
   * Get the configuration element for specified parameters.
   * 
   * @param pluginId
   *          the identifier of the plugin.
   * @param extensionId
   *          the short identifier of the extension point.
   * @param attributeName
   *          the attribute name.
   * @param attributeValue
   *          the attribute value.
   * @return a {@link IConfigurationElement} instance or null if the specified
   *         extension is not found.
   */
  public static IConfigurationElement getConfigurationElement(String pluginId, String extensionId, String attributeName, String attributeValue) {
    IConfigurationElement[] configElements = getConfigurationElements(pluginId, extensionId);
    IConfigurationElement result = null;
    for (int i = 0; i < configElements.length && (null == result); i++) {
      IConfigurationElement configElement = configElements[i];
      // Check if attribute value is the expected one.
      if (hasValue(configElement, attributeName, attributeValue)) {
        result = configElement;
      }
    }
    return result;
  }

  /**
   * Is given configuration element containing an attribute named
   * <code>attName_p</code> with value set to given one ?
   * 
   * @param configurationElement
   * @param attributeName
   * @param attributeValue
   * @return
   */
  public static boolean hasValue(IConfigurationElement configurationElement, String attributeName, String attributeValue) {
    boolean result = false;
    // Preconditions.
    if (configurationElement == null || attributeName == null || attributeValue == null) {
      return result;
    }
    // Get attribute value for the configuration element.
    String innerAttributeValue = configurationElement.getAttribute(attributeName);
    // Compare it with given one.
    result = attributeValue.equals(innerAttributeValue);
    return result;
  }

  /**
   * Return the value of the "id" attribute for given configuration element.
   * 
   * @param configurationElement
   * @return null if given element is null, or has no attribute named "id".
   */
  public static String getId(IConfigurationElement configurationElement) {
    String result = null;
    if (configurationElement != null) {
      result = configurationElement.getAttribute(ATT_ID);
    }
    return result;
  }

  /**
   * Return the value of the "id" attribute for given configuration element.
   * 
   * @param configurationElement
   * @return null if given element is null, or has no attribute named "id".
   */
  public static String getAttributeValue(IConfigurationElement configurationElement, String attribute) {
    String result = null;
    if (configurationElement != null && attribute != null) {
      result = configurationElement.getAttribute(attribute);
    }
    return result;
  }

  /**
   * Create an executable extension for a specified plugin's id & extension
   * point id, matching an attribute's value.<br>
   * The extension point must define an attribute 'class'.
   * 
   * @param pluginId
   *          the identifier of the plugin.
   * @param extensionPointId
   *          the simple identifier of the extension point.
   * @param attributeId
   *          the identifier of the attribute used into the comparison. If null,
   *          matching is not performed.
   * @param attributeValue
   *          the value of the attribute used for comparison matching. If null,
   *          matching is not performed.
   * @return an instance of the interface regarding the attribute 'class'
   * @see ATT_CLASS
   */
  public static Object createExecutableExtension(String pluginId, String extensionPointId, String attributeId, String attributeValue) throws CoreException {
    IConfigurationElement[] configElements = getConfigurationElements(pluginId, extensionPointId);
    if (configElements.length == 0) {
      throw new CoreException(EGFCommonPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind("ExtensionPointHelper.createExecutableExtension(..) _ extensionPointId ''{0}'' must exist.", extensionPointId), null)); //$NON-NLS-1$
    }
    boolean isMatchingImperative = false;
    // Test if matching is imperative
    if (attributeId != null && attributeValue != null) {
      isMatchingImperative = true;
    }
    // Loop over configuration until object is created.
    for (int i = 0; i < configElements.length; i++) {
      IConfigurationElement configElement = configElements[i];
      boolean isExecutableExtensionCreatable = true;
      if (isMatchingImperative) {
        // Perform matching on the attribute defined by an
        // identifier
        String innerAttributeValue = configElement.getAttribute(attributeId);
        // If different, do not instantiate the object.
        if (attributeValue.equals(innerAttributeValue) == false) {
          isExecutableExtensionCreatable = false;
        }
      }
      if (isExecutableExtensionCreatable) {
        return createInstance(configElement);
      }
    }
    return null;
  }

  /**
   * Create an executable extension for given parameters.<br>
   * The extension point must define an attribute 'class'.
   * 
   * @param pluginId
   *          the plug-in that exposes the extension point.
   * @param extensionPointId
   *          the extension point containing an attribute 'class' to
   *          instantiate.
   * @param idValue
   *          the extension id value (attribute 'id') that matches the extension
   *          point estensionPointId_p.<br>
   *          If null, comparison is not performed.
   * @return an Object instance if instantiation is successful; null otherwise.
   */
  public static Object createExecutableExtension(String pluginId, String extensionPointId, String idValue) throws CoreException {
    return createExecutableExtension(pluginId, extensionPointId, ATT_ID, idValue);
  }

  /**
   * Create an object instance for specified parameters.
   * 
   * @param configurationElement
   *          a configuration element loaded from an extension point.
   * @return an Object instance if instantiation is successful; null otherwise.
   */
  public static Object createInstance(IConfigurationElement configurationElement) throws CoreException {
    return createInstance(configurationElement, ATT_CLASS);
  }

  /**
   * Create an object instance for specified parameters.
   * 
   * @param configurationElement
   *          a configuration element loaded from an extension point.
   * @param attributeName
   *          the attribute that hosts the java type.
   * @return an Object instance if instantiation is successful; null otherwise.
   */
  public static Object createInstance(IConfigurationElement configurationElement, String attributeName) throws CoreException {
    return configurationElement.createExecutableExtension(attributeName);
  }

  /**
   * Return the fully qualified extension-point id from given parameters.
   * 
   * @param pluginId
   *          the id of the plug-in that defines the extension-point.
   * @param extensionPointId
   *          the short id of the extension-point.
   * @return the fully qualified extension-point id : <code>'plug-in id.'extension-point id'.
   */
  public static String getExtensionPointId(String pluginId, String extensionPointId) {
    return new StringBuilder(pluginId).append(CharacterConstants.DOT_STRING).append(extensionPointId).toString();
  }

  /**
   * Get the bundleId of this IConfigurationElement
   * 
   * @param configurationElement
   *          a configuration element
   * @return a {@link String} instance or null if the specified
   *         extension is not found.
   */
  public static String getNamespace(IConfigurationElement configurationElement) {
    if (configurationElement == null) {
      return null;
    }
    return configurationElement.getContributor().getName();
  }

}
