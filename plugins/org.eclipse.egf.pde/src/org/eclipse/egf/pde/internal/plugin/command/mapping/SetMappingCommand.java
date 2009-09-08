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
package org.eclipse.egf.pde.internal.plugin.command.mapping;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.extensionpoint.IMappingConstants;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * This command updates or creates an extension matching <code>mapping</code> extension-point.
 * @author Guillaume Brocard
 */
public class SetMappingCommand extends AbstractMappingCommand {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(SetMappingCommand.class.getPackage().getName());
  /**
   * Mapping name.
   */
  private String _mappingName;
  /**
   * Mapping path file.
   */
  private String _path;
  /**
   * The identifier of the factory component that hosts the domain used as input in this mapping.
   */
  private String _source;
  /**
   * The identifier of the factory component that hosts the domain used as output in this mapping.
   */
  private String _target;

  /**
   * Constructor.
   * @param mappingId_p
   */
  public SetMappingCommand(String mappingId_p, String mappingName_p, String path_p, String source_p, String target_p) {
    super(mappingId_p);
    _mappingName = mappingName_p;
    _path = path_p;
    _source = source_p;
    _target = target_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Create (or get) the mapping object.
    IPluginElement mapping = getExtensionElementFromUniqueExtension(getMappingId());
    try {
      // Set the mapping name.
      mapping.setAttribute(ExtensionPointHelper.ATT_NAME, _mappingName);
      // Set the mapping file path.
      mapping.setAttribute(IMappingConstants.MAPPING_ATT_PATH, _path);
      // Set the source.
      mapping.setAttribute(IMappingConstants.MAPPING_ATT_SOURCE, _source);
      // Set the target.
      mapping.setAttribute(IMappingConstants.MAPPING_ATT_TARGET, _target);
    } catch (CoreException exception_p) {
      StringBuffer loggerMessage = new StringBuffer("SetMappingCommand.execute(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
  }
}
