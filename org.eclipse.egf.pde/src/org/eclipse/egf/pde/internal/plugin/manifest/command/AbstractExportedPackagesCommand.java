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
package org.eclipse.egf.pde.internal.plugin.manifest.command;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.pde.plugin.command.AbstractManifestChangesCommand;
import org.eclipse.pde.internal.core.ICoreConstants;
import org.eclipse.pde.internal.core.bundle.BundlePluginBase;
import org.eclipse.pde.internal.core.ibundle.IBundle;
import org.eclipse.pde.internal.core.text.bundle.ExportPackageHeader;
import org.osgi.framework.Constants;


/**
 * @author Guillaume Brocard
 */
public class AbstractExportedPackagesCommand extends AbstractManifestChangesCommand {
  
  /**
   * List of exported packages to consider (either add/remove/modify).
   */
  private String[] _exportedPackages;

  /**
   * Constructor.
   * @param exportedPackages_p
   */
  public AbstractExportedPackagesCommand(String[] exportedPackages_p) {
    _exportedPackages = exportedPackages_p;
  }

  /**
   * Get considered exported packages as an array of String.
   * @return
   */
  protected String[] getExportedPackages() {
    return _exportedPackages;
  }

  /**
   * Return the existing exported packages.
   * @param bundle_p
   * @return a not null list.
   */
  @SuppressWarnings("unchecked")
  protected List<String> getExistingPackages(IBundle bundle_p) {
    List<String> result = new ArrayList<String>(0);
    ExportPackageHeader exportPackageHeader = (ExportPackageHeader) bundle_p.getManifestHeader(getExportedPackageHeader(bundle_p));
    // Null if no package is exported yet.
    if (exportPackageHeader != null) {
      result.addAll(exportPackageHeader.getPackageNames());
    }
    return result;
  }

  /**
   * Return the exported packages as one String.
   * @param exportedPackages_p
   * @return
   */
  protected String getValue(String[] exportedPackages_p) {
    StringBuilder builder = null;
    for (String exportedPackage : exportedPackages_p) {
      if (builder == null) {
        builder = new StringBuilder();
      } else {
        builder
          .append(ICommonConstants.COMMA_CHARACTER)
          .append(ICommonConstants.LINE_SEPARATOR)
          .append(ICommonConstants.WHITE_SPACE_CHARACTER);
      }
      builder.append(exportedPackage);
    }
    return builder == null ? ICommonConstants.EMPTY_STRING : builder.toString();
  }

  /**
   * Get the exported package header.
   * @param bundle_p
   * @return
   */
  protected String getExportedPackageHeader(IBundle bundle_p) {
    int manifestVersion = BundlePluginBase.getBundleManifestVersion(bundle_p);
    return manifestVersion < 2 ? ICoreConstants.PROVIDE_PACKAGE : Constants.EXPORT_PACKAGE;
  }
  
}
