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
package org.eclipse.egf.pde.emf.plugin.command;

import org.eclipse.egf.pde.emf.internal.plugin.command.SetGeneratedPackageCommand;
import org.eclipse.egf.pde.emf.internal.plugin.command.UnsetGeneratedPackageCommand;
import org.eclipse.egf.pde.emf.internal.plugin.command.UpdateGeneratedPackageCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;


/**
 * EMF extension commands factory.
 * @author Guillaume Brocard
 */
public class EmfExtensionFactory {
  /**
   * Create set EMF generated package extension command for given parameters.
   * @param uri_p An URI that uniquely identifies an Ecore package.
   * @param packageClassName_p A fully qualified Java class name of the generated package interface.
   * @param genModelPath_p A plug-in relative URI to the genmodel file for the package.
   * @return
   */
  public static IPluginChangesCommand setEmfGeneratedPackageExtension(String uri_p, String packageClassName_p, String genModelPath_p) {
    return new SetGeneratedPackageCommand(uri_p, packageClassName_p, genModelPath_p);
  }

  /**
   * Create unset EMF 'generated_package' extension command for given URI.
   * @param uri_p An URI that uniquely identifies the Ecore package.
   * @return
   */
  public static IPluginChangesCommand unsetEmfGeneratedPackageExtension(String uri_p) {
    return new UnsetGeneratedPackageCommand(uri_p);
  }

  /**
   * Create update EMF 'generated_package' extension for given URIs.
   * @param oldPackageUri_p The previous package URI.
   * @param newPackageUri_p The new one.
   * @return
   */
  public static IPluginChangesCommand updateEmfGeneratedPackageExtension(String oldPackageUri_p, String newPackageUri_p) {
    return new UpdateGeneratedPackageCommand(oldPackageUri_p, newPackageUri_p);
  }
}
