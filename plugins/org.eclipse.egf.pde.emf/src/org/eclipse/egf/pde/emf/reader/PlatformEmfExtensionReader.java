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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.constant.IEMFConstants;
import org.eclipse.egf.common.descriptor.GenericDescriptor;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.pde.emf.internal.reader.descriptor.EmfExtensionDescriptor;
import org.eclipse.egf.pde.emf.reader.descriptor.IEmfExtensionDescriptor;
import org.eclipse.emf.common.util.URI;


/**
 * EMF generated_package extensions reader for deployed components (referred to as platform ones).
 * @author Guillaume Brocard
 */
public class PlatformEmfExtensionReader {
  /**
   * Read deployed EMF generated_package extensions. 
   * @return A not null but potentially empty descriptor.
   */
  public IDescriptor readEmfExtensions() {
    return getDescriptors();
  }

  /**
   * Get all deployed values as a top level descriptor with possible children.
   * @return Not null but may be empty.
   */
  protected IDescriptor getDescriptors() {
    GenericDescriptor result = new GenericDescriptor();
    IConfigurationElement[] elements = ExtensionPointHelper.getConfigurationElements(IEMFConstants.GENERATED_PACKAGE_EXTENSION_POINT_PLUGIN_ID, IEMFConstants.GENERATED_PACKAGE_EXTENSION_POINT_SHORT_ID);
    if ((null == elements) || (0 == elements.length)) {
      return result;
    }
    for (IConfigurationElement configurationElement : elements) {
      result.addChild(fillDescriptor(configurationElement));
    }
    return result;
  }

  /**
   * Fill specific child descriptor for a given configuration element.
   * @param element_p
   * @return
   */
  protected IEmfExtensionDescriptor fillDescriptor(IConfigurationElement element_p) {
    EmfExtensionDescriptor result = null;
    // Precondition.
    if (null == element_p) {
      return result;
    }
    // Create new descriptor.
    result = new EmfExtensionDescriptor();
    // Get URI.
    String uri = element_p.getAttribute(IEMFConstants.GENERATED_PACKAGE_EXTENSION_POINT_ATT_URI);
    // Get model path as URI.
    String genModelUri = element_p.getAttribute(IEMFConstants.GENERATED_PACKAGE_EXTENSION_POINT_ATT_GEN_MODEL);
    genModelUri = element_p.getContributor().getName() + ICommonConstants.SLASH_CHARACTER + genModelUri;
    // Create and set resulting structure.
    Couple<String, URI> generatedPackageData = new Couple<String, URI>(uri, URI.createPlatformPluginURI(genModelUri, true));
    result.setGeneratedPackage(generatedPackageData);
    return result;
  }
}
