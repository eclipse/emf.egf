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
package org.eclipse.egf.pde.pattern.internal.plugin.command;

import org.eclipse.egf.common.constant.IPatternTemplateConstants;
import org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand;


/**
 * Base class to implement commands that change something regarding 'generatedPattern' extensions.
 * @author Guillaume Brocard
 */
public class AbstractPatternTemplateCommand extends AbstractExtensionChangesCommand {
  
  /**
   * Pattern full id.
   */
  private String _patternFullId;

  /**
   * Constructor.
   * @param id_p Pattern full id.
   */
  protected AbstractPatternTemplateCommand(String patternFullId_p) {
    _patternFullId = patternFullId_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionChildName()
   */
  @Override
  protected String getExtensionChildName() {
    return IPatternTemplateConstants.PATTERN_TEMPLATE_EXTENSION_POINT_CHILD_PATTERN_TEMPLATE;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionPointId()
   */
  @Override
  protected String getExtensionPointId() {
    return IPatternTemplateConstants.PATTERN_TEMPLATE_EXTENSION_POINT_FULL_ID;
  }

  /**
   * Get the pattern element full id.
   * @return
   */
  public String getPatternFullId() {
    return _patternFullId;
  }
  
}