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
package org.eclipse.egf.common.constant;

/**
 * @author Guillaume Brocard
 */
public interface IPatternConstants {
  
  /**
   * Pattern plug-in id.
   */
  public static final String PATTERN_PLUGIN_ID = "org.eclipse.egf.pattern"; //$NON-NLS-1$
  
  /**
   * Pattern extension point id, excluding plug-in id.
   */
  public static final String PATTERN_EXTENSION_POINT_ID = "pattern"; //$NON-NLS-1$
  
  /**
   * Pattern extension point full id, including plug-in id.
   */
  public static final String PATTERN_EXTENSION_POINT_FULL_ID = 
      PATTERN_PLUGIN_ID 
    + ICommonConstants.DOT_CHARACTER 
    + PATTERN_EXTENSION_POINT_ID;
  
  /**
   * Pattern extension point child type.
   */
  public static final String PATTERN_EXTENSION_POINT_CHILD_TYPE = "patternExtType"; //$NON-NLS-1$
  
  /**
   * Pattern extension containing plug-in id.
   */
  public static final String PATTERN_EXTENSION_CONTAINING_PLUGIN_ID = "pluginId"; //$NON-NLS-1$
  
  /**
   * Pattern extension containing factory component name.
   */
  public static final String PATTERN_EXTENSION_CONTAINING_FC_NAME = "fcName"; //$NON-NLS-1$
  
  /**
   * Pattern extension read from the workspace or from the target platform.<br>
   * Key for a boolean value.<br>
   * True means that the extension has been loaded from the workspace, false from the target platform.
   */
  public static final String PATTERN_EXTENSION_FROM_WORKSPACE = "fromWorkspace"; //$NON-NLS-1$
  
  /**
   * Workspace project containing the pattern being described.<br>
   * Key for an IProject value.
   */
  public static final String PATTERN_EXTENSION_WORKSPACE_PROJECT = "wsProject"; //$NON-NLS-1$
  
  /**
   * Pattern extension point child 'library'.
   */
  public static final String PATTERN_EXTENSION_POINT_CHILD_LIBRARY = "library"; //$NON-NLS-1$
  
  /**
   * Pattern extension point child 'pattern'.
   */
  public static final String PATTERN_EXTENSION_POINT_CHILD_PATTERN = "pattern"; //$NON-NLS-1$
  
  /**
   * Library production orchestration attribute name as defined by the pattern extension point.
   */
  public static final String LIBRARY_PRODUCTION_ORCHESTRATION_ATTRIBUTE_NAME = "productionOrchestration"; //$NON-NLS-1$
  
  /**
   * Library runtime orchestration attribute name as defined by the pattern extension point.
   */
  public static final String LIBRARY_RUNTIME_ORCHESTRATION_ATTRIBUTE_NAME = "runtimeOrchestration"; //$NON-NLS-1$
  
  /**
   * Pattern model attribute name as defined by the pattern extension point.
   */
  public static final String PATTERN_MODEL_ATTRIBUTE_NAME = "model"; //$NON-NLS-1$
  
  /**
   * Library/Pattern separator in a library/pattern id.
   */
  public static final char LIBRARY_PATTERN_ID_SEPARATOR = '/';
  
  /**
   * Java source file extension.
   */
  public static final String JAVA_SOURCE_FILE_EXTENSION = "java"; //$NON-NLS-1$  

}
