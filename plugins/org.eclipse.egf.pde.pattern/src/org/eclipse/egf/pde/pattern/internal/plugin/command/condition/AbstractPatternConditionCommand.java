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
package org.eclipse.egf.pde.pattern.internal.plugin.command.condition;

import org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand;

/**
 * @author Guillaume Brocard
 */
public abstract class AbstractPatternConditionCommand extends AbstractExtensionChangesCommand {
  /**
   * Condition pointer id attribute name.
   */
  protected static final String CONDITION_CHILD_ELEMENT_ID_ATTRIBUTE_NAME = "patternId"; //$NON-NLS-1$
  /**
   * Condition extension point full id.
   */
  protected static final String CONDITION_EXTENSION_POINT_FULL_ID = "org.eclipse.egf.pattern.patternCondition"; //$NON-NLS-1$
  /**
   * Condition child element name.
   */
  protected static final String CONDITION_CHILD_ELEMENT_NAME = "conditionPointer"; //$NON-NLS-1$
  /**
   * Pattern full id.
   */
  private String _patternFullId;

  /**
   * Constructor.
   * @param patternFullId_p
   */
  public AbstractPatternConditionCommand(String patternFullId_p) {
    _patternFullId = patternFullId_p;
  }

  /**
   * Get pattern full id.
   * @return
   */
  protected String getPatternFullId() {
    return _patternFullId;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionChildName()
   */
  @Override
  protected String getExtensionChildName() {
    return CONDITION_CHILD_ELEMENT_NAME;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionPointId()
   */
  @Override
  protected String getExtensionPointId() {
    return CONDITION_EXTENSION_POINT_FULL_ID;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionChildIdAttribute()
   */
  @Override
  protected String getExtensionChildIdAttribute() {
    return CONDITION_CHILD_ELEMENT_ID_ATTRIBUTE_NAME;
  }
}
