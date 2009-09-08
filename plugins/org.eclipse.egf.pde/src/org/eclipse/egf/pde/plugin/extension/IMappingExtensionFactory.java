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
package org.eclipse.egf.pde.plugin.extension;

import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;

/**
 * This factory creates commands to deal with "mapping" extension-point.
 * @author Guillaume Brocard
 */
public interface IMappingExtensionFactory {
  /**
   * Set an extension matching <code>mapping</code> extension-point for given parameters.
   * @param mappingId_p
   * @param mappingName_p
   * @param path_p
   * @param source_p
   * @param target_p
   * @return an {@link IPluginChangesCommand} instance that performs this change.
   */
  public IPluginChangesCommand setMappingExtension(String mappingId_p, String mappingName_p, String path_p, String source_p, String target_p);

  /**
   * Unset an extension matching <code>mapping</code> extension-point for given parameters.
   * @param mappingId_p
   * @return an {@link IPluginChangesCommand} instance that performs this change.
   */
  public IPluginChangesCommand unsetMappingExtension(String mappingId_p);
}