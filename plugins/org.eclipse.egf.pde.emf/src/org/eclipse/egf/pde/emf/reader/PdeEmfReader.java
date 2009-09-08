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
package org.eclipse.egf.pde.emf.reader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.constant.IEMFConstants;
import org.eclipse.egf.common.descriptor.GenericDescriptor;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.emf.internal.reader.descriptor.EmfExtensionDescriptor;
import org.eclipse.egf.pde.reader.CreateDescriptorOperation;
import org.eclipse.egf.pde.reader.PdeAbstractReader;
import org.eclipse.emf.common.util.URI;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginModelBase;


/**
 * @author brocard
 */
public class PdeEmfReader extends PdeAbstractReader {
  /**
   * Read emf extension description from given project.
   * @param project_p
   * @return an {@link IDescriptor} instance (EMF extension descriptors are stored as children) or null if data could not be found.
   */
  public IDescriptor readEmfExtension(IProject project_p) {
    IDescriptor result = null;
    // Precondition
    if (null == project_p) {
      return result;
    }
    IFile pluginFile = EgfPdeActivator.getDefault().getFile(project_p);
    // Does the plug-in file exist ?
    if (null != pluginFile) {
      result = readDescriptor(new CreateEmfExtensionDescriptorOperation(pluginFile));
    }
    return result;
  }

  /**
   * @author brocard
   */
  protected class CreateEmfExtensionDescriptorOperation extends CreateDescriptorOperation {
    /**
     * Constructor.
     * @param modelFile_p
     */
    public CreateEmfExtensionDescriptorOperation(IFile modelFile_p) {
      super(modelFile_p);
    }

    /**
     * @see org.eclipse.egf.pde.reader.CreateDescriptorOperation#createDescriptor(org.eclipse.pde.core.plugin.IPluginModelBase)
     */
    @Override
    protected IDescriptor createDescriptor(IPluginModelBase model_p) {
      IPluginElement[] extensionPluginElements =
                                                 getExtensionWithNodeName(model_p, IEMFConstants.GENERATED_PACKAGE_EXTENSION_POINT_FULL_ID,
                                                                          IEMFConstants.GENERATED_PACKAGE_EXTENSION_POINT_CHILD);
      // Precondition.
      if (0 == extensionPluginElements.length) {
        return null;
      }
      // Create a generic container to store all created emf extension descriptor.
      GenericDescriptor resultingDescriptors = new GenericDescriptor();
      // Loop over the retrieved extensions to create the related descriptors.
      for (IPluginElement pluginElement : extensionPluginElements) {
        EmfExtensionDescriptor descriptor = new EmfExtensionDescriptor();
        String uri = getPluginAttributeValue(pluginElement, IEMFConstants.GENERATED_PACKAGE_EXTENSION_POINT_ATT_URI);
        String genModelUri = getPluginAttributeValue(pluginElement, IEMFConstants.GENERATED_PACKAGE_EXTENSION_POINT_ATT_GEN_MODEL);
        genModelUri = getModelFile().getProject().getName() + ICommonConstants.SLASH_CHARACTER + genModelUri;
        Couple<String, URI> generatedPackageData = new Couple<String, URI>(uri, URI.createPlatformResourceURI(genModelUri, true));
        descriptor.setGeneratedPackage(generatedPackageData);
        // Add it to the resulting container.
        resultingDescriptors.addChild(descriptor);
      }
      return resultingDescriptors;
    }
  }
}
