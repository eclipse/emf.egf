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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.constant.IPatternTemplateConstants;
import org.eclipse.egf.common.descriptor.GenericDescriptor;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.reader.CreateDescriptorOperation;
import org.eclipse.egf.pde.reader.PdeAbstractReader;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginModelBase;


/**
 * Read a single generated pattern extension for specified plug-in and pattern full id.
 * @author Guillaume Brocard
 */
public class WorkspacePatternTemplateExtensionReader extends PdeAbstractReader {
  
  /**
   * Get pattern templates for given project.<br>
   * @param project_p
   * @return A not null, but possibly empty, IDescriptor.
   */
  public IDescriptor getPatternTemplates(IProject project_p) {
    IDescriptor result = readPatternTemplateExtension(project_p, null);
    if (result == null) {
      result = new GenericDescriptor();
    }
    return result;
  }  
  
  /**
   * Read generated pattern extension for identified plug-in and pattern.
   * @param pluginId_p
   * @param patternFullId_p
   * @return An empty descriptor if no extension could be found for given parameters.
   */
  public IDescriptor readPatternTemplateExtension(IProject project_p, String patternFullId_p) {
    // Preconditions.
    if (project_p == null) {
      return null;
    }
    // Get plug-in file.
    IFile file = EgfPdeActivator.getDefault().getFile(project_p);
    // Could not get plug-in file.
    if (file == null) {
      return null;
    }
    return readDescriptor(
      new CreatePatternTemplateExtensionDescriptorOperation(file, patternFullId_p)
    );
  }

  /**
   * Pattern template extension descriptor provider.
   * @author Guillaume Brocard
   */
  protected class CreatePatternTemplateExtensionDescriptorOperation extends CreateDescriptorOperation {
    
    /**
     * Pattern full id.
     */
    private String _patternFullId;  
    
    /**
     * Project being analyzed.
     */
    private IProject _project;    

    /**
     * Constructor.
     * @param modelFile_p
     * @param patternFullId_p
     */
    protected CreatePatternTemplateExtensionDescriptorOperation(IFile modelFile_p, String patternFullId_p) {
      super(modelFile_p);
      _patternFullId = patternFullId_p;
      _project = modelFile_p.getProject();
    }
    
    /**
     * @see org.eclipse.egf.pde.reader.CreateDescriptorOperation#createDescriptor(org.eclipse.pde.core.plugin.IPluginModelBase)
     */
    @Override
    protected IDescriptor createDescriptor(IPluginModelBase model_p) {
      GenericDescriptor descriptor = null;
      // If pattern full id is not defined, search for all pattern templates.
      if (_patternFullId == null) {
        // Without a pattern full id, search for all pattern template extension.
        IPluginElement[] pluginElements = getExtensionWithNodeName(
          model_p, 
          IPatternTemplateConstants.PATTERN_TEMPLATE_EXTENSION_POINT_FULL_ID,
          IPatternTemplateConstants.PATTERN_TEMPLATE_EXTENSION_POINT_CHILD_PATTERN_TEMPLATE
        );
        // Create descriptors for retrieved pattern templates.
        List<GenericDescriptor> descriptors = createDescriptors(pluginElements);
        // Expected result is a list of descriptors.
        if (descriptors.isEmpty() == false) {
          descriptor = new GenericDescriptor();
          descriptor.addChildren(descriptors);
        }
      } else {
        // Get pattern template from pattern short id.
        IPluginElement pluginElement = getExtensionWithId(
          model_p, 
          IPatternTemplateConstants.PATTERN_TEMPLATE_EXTENSION_POINT_FULL_ID, 
          _patternFullId
        );
        if (pluginElement != null) {
          List<GenericDescriptor> descriptors = createDescriptors(new IPluginElement[] { pluginElement });
          // Only one result is expected, pick it.
          if (descriptors.isEmpty() == false) {
            descriptor = descriptors.get(0);
          }
        }
      }
      return descriptor;
    }    
    
    /**
     * Create and fill descriptors for given array of plug-in elements.
     * @param elements_p
     * @return
     */
    protected List<GenericDescriptor> createDescriptors(IPluginElement[] elements_p) {
      List<GenericDescriptor> result = new ArrayList<GenericDescriptor>(0);
      for (IPluginElement element : elements_p) {
        // Create descriptor.
        GenericDescriptor newDescriptor = new GenericDescriptor();
        // Fill it.
        fillDescriptor(newDescriptor, element);
        result.add(newDescriptor);
      }
      return result;
    }    
    
    /**
     * Fill descriptor with given plug-in element content.
     * @param descriptor_p
     * @param element_p
     */
    protected void fillDescriptor(GenericDescriptor descriptor_p, IPluginElement element_p) {
      // Set id value.
      descriptor_p.setValue(
        ExtensionPointHelper.ATT_ID, 
        getPluginAttributeValue(
          element_p, 
          ExtensionPointHelper.ATT_ID
        )
      );
      // Get element type...
      String elementType = element_p.getName();
      // ... and set it.
      descriptor_p.setValue(
        IPatternTemplateConstants.PATTERN_TEMPLATE_EXTENSION_POINT_CHILD_TYPE, 
        elementType
      );
      // The extension is read from the workspace.
      descriptor_p.setValue(
        IPatternConstants.PATTERN_EXTENSION_FROM_WORKSPACE, 
        Boolean.TRUE
      );
      // Project analyzed by the time this descriptor is created.
      descriptor_p.setValue(
        IPatternConstants.PATTERN_EXTENSION_WORKSPACE_PROJECT, 
        _project
      );      
      // Set template class.
      descriptor_p.setValue(
        IPatternTemplateConstants.PATTERN_TEMPLATE_ATT_CLASS,
        getPluginAttributeValue(
          element_p, 
          IPatternTemplateConstants.PATTERN_TEMPLATE_ATT_CLASS
        )
      );
      // Set type.
      descriptor_p.setValue(
        IPatternTemplateConstants.PATTERN_TEMPLATE_ATT_TYPE,
        getPluginAttributeValue(
          element_p, 
          IPatternTemplateConstants.PATTERN_TEMPLATE_ATT_TYPE
        )
      );
      // Set path.
      descriptor_p.setValue(
        IPatternTemplateConstants.PATTERN_TEMPLATE_ATT_PATH,
        getPluginAttributeValue(
          element_p, 
          IPatternTemplateConstants.PATTERN_TEMPLATE_ATT_PATH
        )
      );          
    }
        
  }
  
}
