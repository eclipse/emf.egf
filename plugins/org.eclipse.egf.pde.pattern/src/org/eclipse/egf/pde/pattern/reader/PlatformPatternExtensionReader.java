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
package org.eclipse.egf.pde.pattern.reader;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.descriptor.GenericDescriptor;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.core.extensionpoint.IFactoryComponentConstants;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentDescriptor;


/**
 * Read for pattern extensions coming from deployed plug-ins.
 * @author Guillaume Brocard
 */
public class PlatformPatternExtensionReader implements IPatternExtensionReader {
  
  /**
   * @see org.eclipse.egf.pde.pattern.reader.IPatternExtensionReader#getPatternLibrary(java.lang.String)
   */
  public IDescriptor getPatternLibrary(String libraryFullId_p) {
    IDescriptor result = null;
    // Precondition.
    if (libraryFullId_p == null) {
      return result;
    }
    // Get deployed extension from library id.
    IConfigurationElement element = ExtensionPointHelper.getConfigurationElement(
      IPatternConstants.PATTERN_PLUGIN_ID,
      IPatternConstants.PATTERN_EXTENSION_POINT_ID, 
      libraryFullId_p
    );
    if (element != null) {
      List<GenericDescriptor> descriptors = createDescriptors(new IConfigurationElement[] { element });
      // Only one result is expected, pick it.
      if (!descriptors.isEmpty()) {
        result = descriptors.get(0);
      }
    }
    return result;
  }

  /**
   * Get descriptors for given configuration elements.
   * @param elements_p
   * @return
   */
  protected IDescriptor getDescriptors(IConfigurationElement[] elements_p) {
    GenericDescriptor result = null;
    List<GenericDescriptor> descriptors = createDescriptors(elements_p);
    // Expected result is a list of descriptors, create a descriptor as a container for all retrieved root library descriptors.
    if (descriptors.isEmpty() == false) {
      result = new GenericDescriptor();
      result.addChildren(descriptors);
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.pde.pattern.reader.IPatternExtensionReader#getPatternLibraries()
   */
  public IDescriptor getPatternLibraries() {
    // Get deployed library extensions.
    return getDescriptors(
      ExtensionPointHelper.getConfigurationElements(
        IPatternConstants.PATTERN_PLUGIN_ID,
        IPatternConstants.PATTERN_EXTENSION_POINT_ID
      )
    );
  }

  /**
   * @see org.eclipse.egf.pde.pattern.reader.IPatternExtensionReader#getPatternLibraries(java.lang.String)
   */
  public IDescriptor getPatternLibraries(String fcId_p) {
    // Get deployed library extensions.
    return getDescriptors(
      ExtensionPointHelper.getConfigurationElements(
        IPatternConstants.PATTERN_PLUGIN_ID,
        IPatternConstants.PATTERN_EXTENSION_POINT_ID, 
        CoreActivator.getDefault().getPluginIdForFactoryComponent(fcId_p)
      )      
    );
  }

  /**
   * Create and fill descriptors for given array of configuration elements.
   * @param elements_p
   * @return
   */
  protected List<GenericDescriptor> createDescriptors(IConfigurationElement[] elements_p) {
    List<GenericDescriptor> result = new ArrayList<GenericDescriptor>(0);
    for (IConfigurationElement element : elements_p) {
      // Create descriptor.
      GenericDescriptor newDescriptor = new GenericDescriptor();
      // Fill it.
      fillDescriptor(newDescriptor, element);
      result.add(newDescriptor);
    }
    return result;
  }

  /**
   * Extract factory component configuration element for given plug-in ID.
   * @param pluginId_p
   * @return null if it could not be found. Either the plug-in does not exist, or it is not a factory component.
   */
  protected IConfigurationElement extractFactoryComponentConfigurationElement(String pluginId_p) {
    IConfigurationElement result = null;
    IExtension[] extensions = Platform.getExtensionRegistry().getExtensions(pluginId_p);
    for (IExtension extension : extensions) {
      if (IFactoryComponentConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID.equals(extension.getExtensionPointUniqueIdentifier())) {
        result = extension.getConfigurationElements()[0];
        break;
      }
    }
    return result;
  }

  /**
   * Fill descriptor with given configuration element content.
   * @param descriptor_p
   * @param element_p
   */
  protected void fillDescriptor(GenericDescriptor descriptor_p, IConfigurationElement element_p) {
    // Set id value.
    descriptor_p.setValue(
      ExtensionPointHelper.ATT_ID, 
      element_p.getAttribute(ExtensionPointHelper.ATT_ID)
    );
    // Set plug-in id value.
    String pluginId = element_p.getContributor().getName();
    descriptor_p.setValue(
      IPatternConstants.PATTERN_EXTENSION_CONTAINING_PLUGIN_ID, 
      pluginId
    );
    // Set fc name.
    IFactoryComponentDescriptor fcDescriptor = CoreActivator.getDefault().getFactoryComponentDescriptorFromPlatform(extractFactoryComponentConfigurationElement(pluginId));
    if (fcDescriptor != null) {
      descriptor_p.setValue(
        IPatternConstants.PATTERN_EXTENSION_CONTAINING_FC_NAME, 
        fcDescriptor.getName()
      );
    }
    // Get element type...
    String elementType = element_p.getName();
    // ... and set it.
    descriptor_p.setValue(
      IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_TYPE, 
      elementType
    );
    // The extension is read from the workspace.
    descriptor_p.setValue(
      IPatternConstants.PATTERN_EXTENSION_FROM_WORKSPACE, 
      Boolean.FALSE
    );
    // Set library name value.
    descriptor_p.setValue(
      ExtensionPointHelper.ATT_NAME, 
      element_p.getAttribute(ExtensionPointHelper.ATT_NAME)
    );
    // Library child.
    if (IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_LIBRARY.equals(elementType)) {
      // Set library production orchestration value.
      descriptor_p.setValue(
        IPatternConstants.LIBRARY_PRODUCTION_ORCHESTRATION_ATTRIBUTE_NAME, 
        element_p.getAttribute(IPatternConstants.LIBRARY_PRODUCTION_ORCHESTRATION_ATTRIBUTE_NAME)
      );
      // Set library runtime orchestration value.
      descriptor_p.setValue(
        IPatternConstants.LIBRARY_RUNTIME_ORCHESTRATION_ATTRIBUTE_NAME, 
        element_p.getAttribute(IPatternConstants.LIBRARY_RUNTIME_ORCHESTRATION_ATTRIBUTE_NAME)
      );
      // Get children elements.
      descriptor_p.addChildren(createDescriptors(element_p.getChildren()));
    } else if (IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_PATTERN.equals(elementType)) { // Pattern child.
      // Set pattern definition, that is the path to its defining ecore file.
      descriptor_p.setValue(
        IPatternConstants.PATTERN_MODEL_ATTRIBUTE_NAME, 
        element_p.getAttribute(IPatternConstants.PATTERN_MODEL_ATTRIBUTE_NAME)
      );
    }
  }
  
}