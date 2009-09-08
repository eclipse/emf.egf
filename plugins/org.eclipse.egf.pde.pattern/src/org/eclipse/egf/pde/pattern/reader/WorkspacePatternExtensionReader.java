/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 **/
package org.eclipse.egf.pde.pattern.reader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.descriptor.GenericDescriptor;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentDescriptor;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.reader.CreateDescriptorOperation;
import org.eclipse.egf.pde.reader.PdeAbstractReader;
import org.eclipse.egf.pde.reader.WorkspaceFactoryComponentReader;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginModelBase;


/**
 * Read pattern extensions from workspace projects.
 * @author Guillaume Brocard
 */
public class WorkspacePatternExtensionReader extends PdeAbstractReader implements IPatternExtensionReader {
  
  /**
   * @see org.eclipse.egf.pde.pattern.reader.IPatternExtensionReader#getPatternLibrary(java.lang.String)
   */
  public IDescriptor getPatternLibrary(String libraryFullId_p) {
    IDescriptor result = null;
    // Get all projects within this workspace.
    Collection<IProject> projectsList = EgfPdeActivator.getDefault().getPluginProjects();
    // Loop over projects to retrieve those containing a library extension.
    for (Iterator<IProject> projects = projectsList.iterator(); projects.hasNext() && result == null;) {
      IDescriptor descriptor = readPatternExtension(projects.next(), libraryFullId_p);
      if (descriptor != null) {
        result = descriptor;
      }
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.pde.pattern.reader.IPatternExtensionReader#getPatternLibraries()
   */
  public IDescriptor getPatternLibraries() {
    GenericDescriptor result = new GenericDescriptor();
    // Get all projects within this workspace.
    Collection<IProject> projects = EgfPdeActivator.getDefault().getPluginProjects();
    // Loop over projects to retrieve those containing a library extension.
    for (IProject project : projects) {
      IDescriptor descriptor = readPatternExtension(project, null);
      if (descriptor != null) {
        // Add the read descriptor to the resulting descriptor.
        result.addChild(descriptor);
      }
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.pde.pattern.reader.IPatternExtensionReader#getPatternLibraries(java.lang.String)
   */
  public IDescriptor getPatternLibraries(String fcId_p) {
    return getPatternLibraries(EgfPdeActivator.getDefault().getProjectForFactoryComponent(fcId_p));
  }

  /**
   * Get pattern root libraries for given project.<br>
   * Read {@link IPatternExtensionReader#getPatternLibraries()} for details.
   * @param project_p
   * @return A not null, but possibly empty, IDescriptor.
   */
  public IDescriptor getPatternLibraries(IProject project_p) {
    IDescriptor result = readPatternExtension(project_p, null);
    if (result == null) {
      result = new GenericDescriptor();
    }
    return result;
  }

  /**
   * Read pattern condition extensions
   * @param project_p
   * @return
   */
  public IDescriptor readPatternExtension(IProject project_p, String libraryFullId_p) {
    IDescriptor result = null;
    // Precondition.
    if (project_p == null) {
      return result;
    }
    IFile file = EgfPdeActivator.getDefault().getFile(project_p);
    // Test plugin.xml availability.
    if (file != null) {
      result = readDescriptor(new CreatePatternExtensionDescriptorOperation(file, libraryFullId_p));
    }
    return result;
  }

  /**
   * Pattern condition descriptor provider.
   */
  protected class CreatePatternExtensionDescriptorOperation extends CreateDescriptorOperation {
    
    /**
     * Library full id.
     */
    private String _libraryFullId;
    
    /**
     * Project being analyzed.
     */
    private IProject _project;

    /**
     * Constructor.
     * @param modelFile_p
     */
    public CreatePatternExtensionDescriptorOperation(IFile modelFile_p, String libraryFullId_p) {
      super(modelFile_p);
      _libraryFullId = libraryFullId_p;
      _project = modelFile_p.getProject();
    }

    /**
     * @see org.eclipse.egf.pde.reader.CreateDescriptorOperation#createDescriptor(org.eclipse.pde.core.plugin.IPluginModelBase)
     */
    @Override
    protected IDescriptor createDescriptor(IPluginModelBase model_p) {
      GenericDescriptor descriptor = null;
      // If library id is not defined, search for all libraries.
      if (_libraryFullId == null) {
        // Without a library full id, search for all library extension.
        IPluginElement[] pluginElements = getExtensionWithNodeName(
          model_p, 
          IPatternConstants.PATTERN_EXTENSION_POINT_FULL_ID,
          IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_LIBRARY
        );
        // Create descriptors for retrieved libraries.
        List<GenericDescriptor> descriptors = createDescriptors(pluginElements);
        // Expected result is a list of descriptors, create a descriptor as container for all retrieved root library descriptors.
        if (descriptors.isEmpty() == false) {
          descriptor = new GenericDescriptor();
          descriptor.addChildren(descriptors);
        }
      } else {
        // Get element from library id.
        IPluginElement pluginElement = getExtensionWithId(
          model_p, 
          IPatternConstants.PATTERN_EXTENSION_POINT_FULL_ID, 
          _libraryFullId
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
      // Set plug-in id value.
      String pluginId = resolvePluginId(element_p);
      descriptor_p.setValue(
        IPatternConstants.PATTERN_EXTENSION_CONTAINING_PLUGIN_ID, 
        pluginId
      );
      // Set fc name.
      WorkspaceFactoryComponentReader reader = WorkspaceFactoryComponentReader.getDefault();
      IFactoryComponentDescriptor fcDescriptor = reader.readFactoryComponent(_project);
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
        Boolean.TRUE
      );
      // Project analyzed by the time this descriptor is created.
      descriptor_p.setValue(
        IPatternConstants.PATTERN_EXTENSION_WORKSPACE_PROJECT, 
        _project
      );
      // Set library name value.
      descriptor_p.setValue(
        ExtensionPointHelper.ATT_NAME, 
        getPluginAttributeValue(
          element_p, 
          ExtensionPointHelper.ATT_NAME)
      );
      // Library child.
      if (IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_LIBRARY.equals(elementType)) {
        // Set library orchestration value.
        descriptor_p.setValue(
          IPatternConstants.LIBRARY_PRODUCTION_ORCHESTRATION_ATTRIBUTE_NAME,
          getPluginAttributeValue(
            element_p, 
            IPatternConstants.LIBRARY_PRODUCTION_ORCHESTRATION_ATTRIBUTE_NAME
          )
        );
        // Set library runtime orchestration value.
        descriptor_p.setValue(
          IPatternConstants.LIBRARY_RUNTIME_ORCHESTRATION_ATTRIBUTE_NAME,
          getPluginAttributeValue(
            element_p, 
            IPatternConstants.LIBRARY_RUNTIME_ORCHESTRATION_ATTRIBUTE_NAME
          )
        );
        // Get children elements.
        descriptor_p.addChildren(createDescriptors(getChildren(element_p)));
      } else if (IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_PATTERN.equals(elementType)) { // Pattern child.
        // Set pattern definition, that is the path to its defining ecore file.
        descriptor_p.setValue(
          IPatternConstants.PATTERN_MODEL_ATTRIBUTE_NAME,
          getPluginAttributeValue(
            element_p, 
            IPatternConstants.PATTERN_MODEL_ATTRIBUTE_NAME
          )
        );
      }
    }

    /**
     * Get plug-in id from given element.
     * @param element_p
     * @return
     */
    private String resolvePluginId(IPluginElement element_p) {
      String result = null;
      IResource underlyingResource = element_p.getPluginModel().getUnderlyingResource();
      if (underlyingResource != null) {
        IPath fullPath = underlyingResource.getFullPath();
        // Project name must match plug-in id as defined by EGF requirements.
        result = fullPath.segment(0);
      }
      return result;
    }
    
  }
  
}