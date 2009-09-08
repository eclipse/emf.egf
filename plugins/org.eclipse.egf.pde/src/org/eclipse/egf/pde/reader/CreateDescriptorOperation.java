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
package org.eclipse.egf.pde.reader;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.pde.internal.ui.util.ModelModification;
import org.eclipse.egf.pde.util.ExtensionHelper;
import org.eclipse.pde.core.IBaseModel;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginObject;


/**
 * Base class to implement operations that read elements from a plug-in within the workspace.
 * @author fournier
 */
public abstract class CreateDescriptorOperation extends ModelModification {
  
  private IDescriptor _descriptor;
  
  /**
   * Id of read element.
   */
  private String _readElementId;
  
  /**
   * Related plug-in model.
   */
  private IPluginModelBase _pluginModelBase;

  /**
   * Constructor.
   * @param modelFile_p
   */
  public CreateDescriptorOperation(IFile modelFile_p) {
    super(modelFile_p);
  }

  /**
   * Constructor.
   * @param modelFile_p
   * @param readExtensionId_p id of read element.
   */
  public CreateDescriptorOperation(IFile modelFile_p, String readExtensionId_p) {
    super(modelFile_p);
    _readElementId = readExtensionId_p;
  }

  /**
   * Get the id of the read element.
   * @return
   */
  protected String getReadExtensionId() {
    return _readElementId;
  }

  /**
   * Get the created descriptor.
   * @return an {@link IDescriptor} instance or null if an error occurs.
   */
  public IDescriptor getDescriptor() {
    return _descriptor;
  }

  /**
   * @see org.eclipse.egf.pde.internal.ui.util.ModelModification#modifyModel(org.eclipse.pde.core.IBaseModel,
   *      org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected void modifyModel(IBaseModel model_p, IProgressMonitor monitor_p) throws CoreException {
    // Precondition.
    if (model_p instanceof IPluginModelBase == false)
      return;
    _descriptor = createDescriptor((IPluginModelBase) model_p);
  }

  /**
   * Create descriptor for given model.
   * @param model_p
   * @return a {@link IDescriptor} instance according to model read operations.
   */
  protected abstract IDescriptor createDescriptor(IPluginModelBase model_p);

  /**
   * Get the extension element for given parameters.
   * @param model_p
   * @param extensionPointId_p the fully qualified extension-point id.
   * @param idValue_p the value of the <code>id</code> attribute.
   * @return a plug-in element according to searched extension or null if not found.
   */
  protected IPluginElement getExtensionWithId(IPluginModelBase model_p, String extensionPointId_p, String idValue_p) {
    IPluginElement result = null;
    // Get all extensions matching specified extension-point id.
    IPluginExtension[] extensions = ExtensionHelper.getPluginExtension(
      model_p.getExtensions(), 
      extensionPointId_p
    );
    // Loop over all retrieved extension to find the one with given id.
    for (int i = 0; i < extensions.length && result == null; i++) {
      result = ExtensionHelper.getPluginElement(
        extensions[i], 
        ExtensionPointHelper.ATT_ID, 
        idValue_p
      );
    }
    return result;
  }

  /**
   * Get all extension elements for given parameters.
   * @param model_p
   * @param extensionPointId_p fully qualified extension point id.
   * @param extensionChildNodeName_p the value of the extension child node name.
   * @return a not null array of {@link IPluginElement}.
   */
  protected IPluginElement[] getExtensionWithNodeName(IPluginModelBase model_p, String extensionPointId_p, String extensionChildNodeName_p) {
    List<IPluginElement> result = new ArrayList<IPluginElement>();
    // Get all extensions matching specified extension-point id.
    IPluginExtension[] extensions = ExtensionHelper.getPluginExtension(model_p.getExtensions(), extensionPointId_p);
    // Loop over all retrieved extensions.
    for (IPluginExtension pluginExtension : extensions) {
      // Get all plug-in elements matching given name.
      IPluginElement[] elements = ExtensionHelper.getPluginElement(pluginExtension, extensionChildNodeName_p);
      // Add all retrieved plug-in elements as children. Most of the time, this array has a length set to 1.
      for (IPluginElement pluginElement : elements) {
        result.add(pluginElement);
      }
    }
    return result.toArray(new IPluginElement[result.size()]);
  }

  /**
   * Get all children for a parent with a given name.
   * @param parent_p
   * @param childNodeName_p
   * @return a not null array.
   */
  protected IPluginElement[] getChildren(IPluginElement parent_p, String childNodeName_p) {
    IPluginElement[] allChildren = getChildren(parent_p);
    // Preconditions.
    if (childNodeName_p == null || allChildren.length == 0) {
      return new IPluginElement[0];
    }
    // Create resulting list.
    List<IPluginElement> result = new ArrayList<IPluginElement>(0);
    // Check names of existing children against given one.
    for (IPluginElement pluginElement : allChildren) {
      if (childNodeName_p.equals(pluginElement.getName())) {
        result.add(pluginElement);
      }
    }
    // Return result as an array.
    return result.toArray(new IPluginElement[result.size()]);
  }

  /**
   * Get all children of given plug-in element.
   * @param parent_p
   * @return A not null array of {@link IPluginElement} (but may be empty).
   */
  protected IPluginElement[] getChildren(IPluginElement parent_p) {
    List<IPluginElement> result = null;
    // Precondition.
    if (parent_p == null) {
      return new IPluginElement[0];
    }
    // Initialize resulting list.
    result = new ArrayList<IPluginElement>(0);
    // Get all children.
    IPluginObject[] children = parent_p.getChildren();
    // Check those that are indeed plug-in elements.
    for (IPluginObject pluginObject : children) {
      if (pluginObject instanceof IPluginElement) {
        result.add((IPluginElement) pluginObject);
      }
    }
    // Return result as an array.
    return result.toArray(new IPluginElement[result.size()]);
  }

  /**
   * Get the attribute value for given element and attribute name.
   * @param element_p
   * @param attributeName_p
   * @return null if attribute is not found.
   */
  protected String getPluginAttributeValue(IPluginElement element_p, String attributeName_p) {
    IPluginAttribute attribute = element_p.getAttribute(attributeName_p);
    return attribute != null ? attribute.getValue() : null;
  }

  /**
   * Get model file.
   * @return
   */
  protected IFile getModelFile() {
    return getFile();
  }

  /**
   * Read the description of given plug-in element.
   * @param element_p
   * @return null if no description is read.
   */
  protected String readDescription(IPluginElement element_p) {
    String description = null;
    IPluginElement[] descriptions = getChildren(element_p, ExtensionPointHelper.ELEMENT_DESCRIPTION);
    if (descriptions.length > 0) {
      // The description element must be unique (see the extension-point schemas).
      description = descriptions[0].getText();
    }
    return description;
  }

  /**
   * @return the pluginModelBase
   */
  protected IPluginModelBase getPluginModelBase() {
    return _pluginModelBase;
  }

  /**
   * @param pluginModelBase_p the pluginModelBase to set
   */
  public void setPluginModelBase(IPluginModelBase pluginModelBase_p) {
    _pluginModelBase = pluginModelBase_p;
  }

}
