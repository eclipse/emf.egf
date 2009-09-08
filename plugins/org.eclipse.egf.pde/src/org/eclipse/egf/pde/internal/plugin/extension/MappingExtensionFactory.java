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
package org.eclipse.egf.pde.internal.plugin.extension;

import org.eclipse.egf.pde.internal.plugin.command.mapping.SetMappingCommand;
import org.eclipse.egf.pde.internal.plugin.command.mapping.UnsetMappingCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.extension.IMappingExtensionFactory;

/**
 * This factory creates commands to deal with <code>mapping</code> extension-point.
 * @author Guillaume Brocard
 */
public class MappingExtensionFactory implements IMappingExtensionFactory {
  /**
   * Unique reference.
   */
  private static MappingExtensionFactory __instance;

  /**
   * Private constructor to implement singleton pattern.
   */
  private MappingExtensionFactory() {
    // Do nothing.
  }

  /**
   * Get the unique instance.
   * @return
   */
  public static MappingExtensionFactory getInstance() {
    if (null == __instance) {
      __instance = new MappingExtensionFactory();
    }
    return __instance;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IMappingExtensionFactory#setMappingExtension(java.lang.String, java.lang.String, java.lang.String,
   *      java.lang.String, java.lang.String)
   */
  public IPluginChangesCommand setMappingExtension(String mappingId_p, String mappingName_p, String path_p, String source_p, String target_p) {
    return new SetMappingCommand(mappingId_p, mappingName_p, path_p, source_p, target_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.extension.IMappingExtensionFactory#unsetMappingExtension(java.lang.String)
   */
  public IPluginChangesCommand unsetMappingExtension(String mappingId_p) {
    return new UnsetMappingCommand(mappingId_p);
  }
}