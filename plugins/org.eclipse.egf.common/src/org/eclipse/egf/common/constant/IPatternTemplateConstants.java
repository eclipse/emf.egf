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
package org.eclipse.egf.common.constant;

/**
 * @author Guillaume Brocard
 */
public interface IPatternTemplateConstants { 
  
  /**
   * Pattern plug-in id.
   */
  static final String PATTERN_PLUGIN_ID = "org.eclipse.egf.pattern"; //$NON-NLS-1$
  
  /**
   * Pattern Template extension point id.
   */
  static final String PATTERN_TEMPLATE_EXTENSION_POINT_ID = "patternTemplate"; //$NON-NLS-1$
  
  /**
   * Generated Pattern extension point full id.
   */
  static final String PATTERN_TEMPLATE_EXTENSION_POINT_FULL_ID = 
      PATTERN_PLUGIN_ID 
    + ICommonConstants.DOT_CHARACTER
    + PATTERN_TEMPLATE_EXTENSION_POINT_ID;
  
  /**
   * Pattern extension point child type.
   */
  public static final String PATTERN_TEMPLATE_EXTENSION_POINT_CHILD_TYPE = "patternTemplateExtType"; //$NON-NLS-1$  
  
  /**
   * Generated Pattern extension point child <code>generatedPattern</code>.
   */
  static final String PATTERN_TEMPLATE_EXTENSION_POINT_CHILD_PATTERN_TEMPLATE = PATTERN_TEMPLATE_EXTENSION_POINT_ID;
  
  /**
   * Define a constant for the <code>class</code> attribute.
   */
  static final String PATTERN_TEMPLATE_ATT_CLASS = "class"; //$NON-NLS-1$
  
  /**
   * Define a constant for the <code>type</code> attribute.
   */
  static final String PATTERN_TEMPLATE_ATT_TYPE = "type"; //$NON-NLS-1$
  
  /**
   * Define a constant for the <code>path</code> attribute.
   */
  static final String PATTERN_TEMPLATE_ATT_PATH = "path"; //$NON-NLS-1$  
  
}