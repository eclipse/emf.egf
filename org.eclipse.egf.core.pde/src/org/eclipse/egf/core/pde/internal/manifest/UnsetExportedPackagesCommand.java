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
package org.eclipse.egf.core.pde.internal.manifest;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.egf.common.helper.MiscHelper;
import org.eclipse.pde.internal.core.ibundle.IBundle;


/**
 * @author Guillaume Brocard
 */
public class UnsetExportedPackagesCommand extends AbstractExportedPackagesCommand {
  
  /**
   * Constructor.
   * @param exportedPackages_p
   */
  public UnsetExportedPackagesCommand(String[] exportedPackages_p) {
    super(exportedPackages_p);
  }

  /**
   * @see org.eclipse.egf.core.pde.plugin.AbstractManifestChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Check that there is something to unset.
    String[] exportedPackages = getExportedPackages();
    if (exportedPackages != null && exportedPackages.length > 0) {
      // Get the related bundle.
      IBundle bundle = getBundlePluginModel().getBundleModel().getBundle();
      // Create a collection of resulting packages.
      Collection<String> newExportedPackages = new ArrayList<String>(0);
      // Add existing ones.
      newExportedPackages.addAll(getExistingPackages(bundle));
      // Remove the others.
      newExportedPackages.removeAll(MiscHelper.asList(exportedPackages));
      // Overwrite existing exported packages with new ones.
      bundle.setHeader(
        getExportedPackageHeader(bundle), 
        getValue(newExportedPackages.toArray(new String[newExportedPackages.size()]))
      );
    }
  }
  
}
