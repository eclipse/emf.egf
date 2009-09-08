/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.mapping.internal;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.misc.PlatformLocationType;
import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.mapping.data.MappingServices;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.MappingModel;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.model.edit.helper.FactoryComponentHelper;


/**
 * Helper to deal with {@link MappingModel} elements and {@link MappingServices}.
 * @author Guillaume Brocard
 */
public class MappingHelper {
  /**
   * Returns the mapping services related to given mapping id.<br>
   * The mapping id must be defined within a mapping located in a factory component either in the workspace or in the target platform.
   * @param mappingId_p
   * @return a {@link MappingServices} instance or null if not found.
   */
  public static MappingServices getMappingServices(String mappingId_p) {
    MappingServices result = null;
    // Get all factory components located in both workspace and target platform.
    List<FactoryComponent> allFcs = EgfUiActivator.getDefault().getAllFactoryComponents();
    // Iterate over all factory components to find the one that contains given mapping.
    Iterator<FactoryComponent> iterator = allFcs.iterator();
    MappingModel mappingModel = null;
    FactoryComponent mappingFcContainer = null;
    while (iterator.hasNext() && (null == mappingModel)) {
      mappingFcContainer = iterator.next();
      // Get all mappings for current factory component.
      List<MappingModel> mappings = ModelHelper.getMappings(mappingFcContainer);
      // Get mapping for given id.
      mappingModel = ModelHelper.getMapping(mappingId_p, mappings);
    }
    // The related mapping is found.
    if (null != mappingModel) {
      StringBuilder fullPath = null;
      // Get the project path where the mapping factory component container is located.
      IProject hostingProject = ModelHelper.getProject(mappingFcContainer);
      if (null != hostingProject) {
        // The factory component that contains the mapping model is located in the workspace.
        fullPath = new StringBuilder(hostingProject.getFullPath().toString());
      } else {
        // Get the plug-in id because the factory component that contains the mapping model is located in the target platform.
        fullPath = new StringBuilder().append(ICommonConstants.SLASH_CHARACTER).append(FactoryComponentHelper.getPluginId(mappingFcContainer.getId(), PlatformLocationType.TARGET_PLATFORM_ONLY));
      }
      // Append the slash character as folder separator.
      fullPath.append(ICommonConstants.SLASH_CHARACTER);
      // Get the path of the mapping model.
      fullPath.append(mappingModel.getPath());
      result = new MappingServices(fullPath.toString());
    }
    return result;
  }
}