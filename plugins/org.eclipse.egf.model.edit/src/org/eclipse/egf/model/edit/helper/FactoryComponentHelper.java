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
package org.eclipse.egf.model.edit.helper;

import org.apache.log4j.Logger;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.misc.PlatformLocationType;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.Domain;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.emf.common.util.URI;


/**
 * Provides services related to a factory component implemented using both EGF PDE & RootFc services.
 * @author Guillaume Brocard
 */
public class FactoryComponentHelper {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(FactoryComponentHelper.class.getPackage().getName());

  /**
   * Get the plug-in id for given factory component.
   * @param fcId_p
   * @param search_p drives the algorithm that processes the search.
   * @return a plug-in id or null if not found.
   */
  public static String getPluginId(String fcId_p, PlatformLocationType search_p) {
    String result = null;
    switch (search_p) {
      case TARGET_PLATFORM_ONLY:
        result = lookupInTargetPlatform(fcId_p);
      break;
      case WORKSPACE_ONLY:
        result = lookupInWorkspace(fcId_p);
      break;
      case TARGET_PLATFORM_THEN_WORKSPACE:
        result = lookupInTargetPlatform(fcId_p);
        if (null == result) {
          result = lookupInWorkspace(fcId_p);
        }
      break;
      case WORKSPACE_THEN_TARGET_PLATFORM:
        result = lookupInWorkspace(fcId_p);
        if (null == result) {
          result = lookupInTargetPlatform(fcId_p);
        }
      break;
      default:
        StringBuilder loggerMessage = new StringBuilder("FactoryComponentHelper.getPluginId(..) _ "); //$NON-NLS-1$
        loggerMessage.append("Unknown search flag:").append(search_p); //$NON-NLS-1$
        __logger.error(loggerMessage.toString());
      break;
    }
    return result;
  }

  /**
   * Returns the domain uri for given domain.
   * @param domain_p
   * @return a not null {@link URI} if given domain is defined.
   */
  public static URI getDomainURI(String fcId_p) {
    URI domainUri = null;
    FactoryComponent fc = CoreActivator.getDefault().getFactoryComponent(fcId_p);
    // Precondition
    if (null == fc) {
      return domainUri;
    }
    Domain domain = fc.getDomain();
    if (ModelHelper.isDomainDefined(domain)) {
      // Get the plug-in id that hosts this domain.
      String pluginId = FactoryComponentHelper.getPluginId(fcId_p, PlatformLocationType.WORKSPACE_THEN_TARGET_PLATFORM);
      if (null != pluginId) {
        // Get the domain path inside its hosting plug-in.
        StringBuilder domainPath =
                                   new StringBuilder().append(ICommonConstants.SLASH_CHARACTER).append(pluginId).append(ICommonConstants.SLASH_CHARACTER)
                                       .append(domain.getPath());
        // Create the related URI.
        domainUri = FileHelper.getFileFullUri(domainPath.toString());
      }
    }
    return domainUri;
  }

  /**
   * Lookup given factory component in the workspace.
   * @param fcId_p
   * @return a plug-in id or null if not found.
   */
  private static String lookupInWorkspace(String fcId_p) {
    return EgfPdeActivator.getDefault().getPluginIdForFactoryComponent(fcId_p);
  }

  /**
   * Lookup given factory component in the target platform.
   * @param fcId_p
   * @return a plug-in id or null if not found.
   */
  private static String lookupInTargetPlatform(String fcId_p) {
    return CoreActivator.getDefault().getPluginIdForFactoryComponent(fcId_p);
  }
}