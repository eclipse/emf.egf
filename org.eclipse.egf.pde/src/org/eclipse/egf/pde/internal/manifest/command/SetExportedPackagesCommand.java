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
package org.eclipse.egf.pde.internal.manifest.command;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.egf.common.helper.MiscHelper;
import org.eclipse.pde.internal.core.ibundle.IBundle;


/**
 * Implement a command that adds exported packages in the <code>Export-Package</code> property of the manifest file.
 * @author Guillaume Brocard
 */
public class SetExportedPackagesCommand extends AbstractExportedPackagesCommand {
  
  /**
   * Constructor.
   * @param exportedPackages_p
   */
  public SetExportedPackagesCommand(String[] exportedPackages_p) {
    super(exportedPackages_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractChangesCommand#execute().
   */
  @Override
  public void execute() {
    // For implementation details have a look at {@link ExportPackageSection#handleAdd} this method is called when using the PDE UI.
    // Preconditions.
    super.execute();
    // Must be something to write.
    String[] exportedPackages = getExportedPackages();
    if (exportedPackages != null && exportedPackages.length > 0) {
      // Get the related bundle.
      IBundle bundle = getBundlePluginModel().getBundleModel().getBundle();
      // Create a set to ensure each exported package is unique between the existing ones and the new ones to append.
      Set<String> newExportedPackages = new HashSet<String>(exportedPackages.length);
      // Add exported packages (from the caller request) to the resulting set.
      newExportedPackages.addAll(MiscHelper.asList(exportedPackages));
      // Add existing exported packages to the resulting set.
      newExportedPackages.addAll(getExistingPackages(bundle));
      // Write (overlap the previous value) all exported packages.
      bundle.setHeader(
        getExportedPackageHeader(bundle), 
        getValue(newExportedPackages.toArray(new String[newExportedPackages.size()]))
      );
    }
  }
  
}
